package JavaNetwokHomework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.Map;

import java.util.HashMap;
import java.util.Iterator;

public class WhisperServer {
	private Map<String, Socket> clients;

	public WhisperServer() {
		clients = Collections.synchronizedMap(new HashMap<String, Socket>());
	}

	public void startServer() {
		ServerSocket serverSocket = null;
		Socket socket = null;

		int port = 9999;

		try {
			serverSocket = new ServerSocket(port);
			System.out.println("접속 대기 중....");

			while (true) {
				socket = serverSocket.accept();

				System.out.println(socket.getInetAddress() + " : " + socket.getPort());

				// 메시지 전송 처리를 위한 스레드
				ServerReceiver receiver = new ServerReceiver(socket);

				receiver.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 모두에게 메시지를 전송하는 메서드 사용자를 특정하지 않고 모든 사용자에게 메시지를 전송함.
	 * 
	 * @param message 모두에게 전송할 메시지
	 */
	public void broadCastMessage(String message) {

		Iterator<String> it = clients.keySet().iterator();

		while (it.hasNext()) {
			try {
				String name = it.next();

				DataOutputStream dos = new DataOutputStream(clients.get(name).getOutputStream());

				dos.writeUTF(message);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void whisperMessage(String userName, String message, String targetName) {
		
		if(clients.containsKey(userName)) {
			
				try {
				
					DataOutputStream dos = new DataOutputStream(clients.get(targetName).getOutputStream());
					message  = message.replace("/w", "");
					message  = message.replace(targetName, "");
					
					dos.writeUTF(">귓속말" + message);

				} catch (IOException e) {
					e.printStackTrace();
				}
		} else {
		System.out.println("입력한 사용자를 찾을 수 없습니다.");
		return;
		}
	}

	class ServerReceiver extends Thread {

		private Socket socket;
		private DataInputStream dis;
		private String name;

		public ServerReceiver(Socket socket) {
			this.socket = socket;

			try {
				dis = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				name = dis.readUTF();

				clients.put(name, socket);
				System.out.println("현재 서버 접속자 수 : " + clients.size());
				broadCastMessage("SYSTEM [" + name + "]님이 입장하셨습니다.");

				String message = "";

//				message = dis.readUTF();
//				여기서 입력받으면 dis가 이미 null이 아닌 조건을 만족했기 때문에 아래의 반복문이 탈출조건 없이 무한반복하게 된다.
				while (dis != null) {
					message = dis.readUTF();
//					반면 여기서 dis.readUTF를 주게된다면 다음 입력이 올때까지 기다리다가 입력이 들어오면
//					다음 루프를 시작하기 때문에 반복문 안에서 입력을 받아야한다.
					if (message.startsWith("/w")) {
						String[] tmp = message.split(" ");
						whisperMessage(name, "[" + name + "] : " + message, tmp[1]);
					} else {
						broadCastMessage("[" + name + "] : " + message);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				broadCastMessage(name + "님이 나갔습니다.");

				clients.remove(name);

				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]에서 접속 종료하였습니다.");

				System.out.println("현재 서버 접속자 수 : " + clients.size());
			}
		}
	}

	public static void main(String[] args) {
		new WhisperServer().startServer();
	}
}
