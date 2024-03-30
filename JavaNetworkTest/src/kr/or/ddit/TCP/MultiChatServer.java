package kr.or.ddit.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MultiChatServer {
		//대화명, 클라이언트의 소켓을 저장하기 위한 객체 변수 선언
		private Map<String, Socket> clients;
		
		public MultiChatServer() {
			//동기화 처리가 가능하도록 Map 객체 생성
			clients = Collections.synchronizedMap(new HashMap<String, Socket>());
		}
		
		//서버 시작
		public void startServer() {
			ServerSocket serverSocket = null;
			Socket socket = null;
			
			try {
				serverSocket = new ServerSocket(7777);
				System.out.println("멀티챗 서버가 시작되었습니다...");
				
				while(true) {
					//클라이언트 접속 대기
					socket = serverSocket.accept();
					
					System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]");
					
					//메시지 전송 처리를 위한 스레드 생성 및 실행
					ServerReceiver receiver = new ServerReceiver(socket);
					//ServerReceiver 클래스가 Thread를 상속하고 있어서 서버리시버 객체를 만든게 스레드로 만든거랑 같음
					receiver.start();
			
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		/**
		 * 대화방, 즉 Map에 저장된 전체 유저에게 안내 메시지를 전송하는 메서드
		 * @param msg 전송할 안내 메시지
		 */
	public void sendMessage(String msg) {
			Iterator<String> it = clients.keySet().iterator();
			System.out.println(it);
			while(it.hasNext()) {
				try {
					String name = it.next(); //대화명 구하기

					//대화명에 해당하는 Socket
					DataOutputStream dos = new DataOutputStream(clients.get(name).getOutputStream());
					
					dos.writeUTF(msg); //메시지 전송
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
	/**
	 * 대화방 즉, Map에 저장된 전체 유저에게 안내 메시지를 전송하는 메서드
	 * @param msg : 전송할 채팅 메시지
	 * @param from : 메시지 보낸 사람
	 * 오버로드 메소드
	 */
	public void sendMessage(String msg, String from) {
		sendMessage("[" + from + "]" + msg);
		
	}
	
	/**
	 * 서버에서 클라이언트로부터 수신한 메시지를 처리하기 위한 스레드 클래스
	 * (Inner클래스에서는 Outer 클래스의 멤버들을 직접 접근할 수 있음)
	 * @author PC-2 
	 *
	 */
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
				// 서버에서는 클라이언트가 보내는 최초의 메시지, 즉 대화명을 수신해야한다.
				name = dis.readUTF();
				
				//대화명을 받아서 다른 모든 클라이언트에게 대화방 참여 메시지를 보낸다.
				sendMessage("#" + name + "님이 입장했습니다.");
				
				//대화명과 소켓객체를 Map에 저장한다.
				clients.put(name, socket);
				
				System.out.println("현재 서버 접속자 수 : " + clients.size());
				
				//이 후의 메시지처리는 반복문으로 처리한다.
				//메시지를 받으면 바로 모든 클라이언트에게 보낸다.
				while(dis != null) {
					sendMessage(dis.readUTF(), name);
				}	
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				//이 finally 영역이 실행된다는 것은 클아이언트의 접속에 문제가 생긴 경우이므로 사용자 정리 작업을 해준다.
				sendMessage(name + "님이 나가셨습니다.");
				
				//Map에서 해당 사용자 제거
				clients.remove(name);
				
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]에서 접속 종료하였습니다.");
				
				System.out.println("현재 서버 접속자 수 : " + clients.size());
				
			}
		}		
	}
	
	public static void main(String[] args) {
		
		new MultiChatServer().startServer();
			
			
	}
		
}
