package kr.or.ddit.TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPChatServer {
	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket socket = null;
		
		try {
			server = new ServerSocket(7777);
			// 7777 : 포트번호 int 범위 내에서 지정 가능
			
			System.out.println("서버 준비 완료...");
			
			socket = server.accept();
			//accept : 접속을 기다리는 메서드 해당 메서드가 호출되면 클라이언트를 기다리고
			//클라이언트가 접속하면 서버의 소켓, 클라이언트의 소켓이 만들어져 서버가 만들어짐
			
			Sender sender = new Sender(socket);
			
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
