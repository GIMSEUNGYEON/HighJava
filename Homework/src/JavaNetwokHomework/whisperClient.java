package JavaNetwokHomework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.net.Socket;

public class whisperClient {
	PrintWriter pw = null;

	public void startClient() {
		Socket socket = null;
		try {
			socket = new Socket("192.168.141.21", 9999);
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			System.out.println("서버에 연결되었습니다.");
			
			ClientSender sender = new ClientSender(socket);
			sender.start();
			
			ClientReceiver receiver = new ClientReceiver(socket);
			receiver.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class ClientSender extends Thread {
		
		private DataOutputStream dos;
		private DataInputStream dis;
		private Scanner sc;
		
		public ClientSender(Socket socket) {
			sc = new Scanner(System.in);
			
			try {
				
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				
				while(true) {
					if(dos != null) {
						System.out.println("대화명 입력 >>> ");
						String name = sc.nextLine();
						dos.writeUTF(name);
						
						String res = dis.readUTF();
//						System.out.println("res=" + res);
						
						if("중복".equals(res)) {
							System.out.println("중복됩니다. 다시입력하세요");
						}else {
							break;
						}
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				
				while(dos != null) {
					dos.writeUTF(sc.nextLine());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	class ClientReceiver extends Thread {
		private DataInputStream dis;
		
		public ClientReceiver(Socket socket) {
			try {
				dis = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			while(dis != null) {
				try {
					System.out.println(dis.readUTF());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new whisperClient().startClient();
	}

}
