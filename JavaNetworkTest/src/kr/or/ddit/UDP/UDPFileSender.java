package kr.or.ddit.UDP;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPFileSender {
	private DatagramSocket ds;
	private DatagramPacket dp;

	private InetAddress receiverAddr;

	private int port; // 패킷 전송시 사용할 포트 번호
	private File file;

	public UDPFileSender(String receiverIp, int port) {
		try {
			ds = new DatagramSocket();
			this.port = port;
			receiverAddr = InetAddress.getByName(receiverIp);
			file = new File("d:/D_Other/img/ddit.jpg");

			if (!file.exists()) {
				System.out.println("파일이 존재하지 않습니다!");
				System.exit(0);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void start() throws Exception {

		long fileSize = file.length();
		long totalReadByte = 0;

		long startTime = System.currentTimeMillis();
		sendData("start".getBytes()); // 전송 시작을 알려주기 위한 문자열 전송

		sendData(file.getName().getBytes()); // 파일명을 전송

		sendData(String.valueOf(fileSize).getBytes()); // 파일의 크기 정보 전송

		FileInputStream fis = new FileInputStream(file);

		byte[] buffer = new byte[1000];

		while (true) {
			Thread.sleep(10); // 패킷 전송 간의 간격을 주기 위함

			int readByte = fis.read(buffer, 0, buffer.length);

			if (readByte == -1) { // 파일을 다 읽은 경우
				break;
			}
			sendData(buffer, readByte); // 읽어온 파일 내용을 전송하기

			totalReadByte += readByte;

			System.out.println("진행 상태 : " + totalReadByte + " / " + fileSize + "Bytes ("
					+ (totalReadByte * 100 / fileSize) + "% )");
		}

		long endTime = System.currentTimeMillis();
		long difftime = endTime - startTime;
		double transferSpeed = fileSize / difftime;

		System.out.println("걸린 시간 : " + difftime + "(ms");
		System.out.println("평균 전송 속도 : " + transferSpeed + "(Bytes/ms)");

		System.out.println("전송 완료");
	}
	/**
	 * 바이트 배열 전송하기
	 * @param data 전송할 바이트 배열 크기
	 */
	public void sendData(byte[] data) {
		sendData(data, data.length);
		
	}
	
	/**
	 *  바이트 배열 데이터 전송하기
	 * @param data 전송할 바이트 배열
	 * @param length 전송할 바이트 배열 크기
	 */
	public void sendData(byte[] data, int length) {

		try {
			dp = new DatagramPacket(data, length, receiverAddr, port);
			ds.send(dp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		new UDPFileSender("192.168.141.21", 8888).start();;
	}
}
