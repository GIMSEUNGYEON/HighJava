package kr.or.ddit.UDP;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPFileReceiver {
	private DatagramSocket ds;
	private DatagramPacket dp;

	private byte[] buffer;


	public UDPFileReceiver(int port) {
		try {
			ds = new DatagramSocket(port); // 데이터수신을 위한 포트번호 설정
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void start() throws IOException {
		long fileSize = 0;
		long totalReadByte = 0;

		int readBytes = 0;

		System.out.println("파일 수신 대기 중...");

		String str = new String(receiveData()).trim();

		if (str.equals("start")) {
			str = new String(receiveData()).trim();

			FileOutputStream fos = new FileOutputStream("d:/D_Other/" + str);

			// 전송 파일 크기(bytes) 받기
			str = new String(receiveData()).trim();
			fileSize = Long.parseLong(str);

			long startTime = System.currentTimeMillis();

			while (true) {
				byte[] data = receiveData();
				readBytes = dp.getLength(); // 받은 바이트배열 크기

				fos.write(data, 0, readBytes);

				totalReadByte += readBytes;
				
				System.out.println("진행 상태 : " + totalReadByte + " / " + fileSize + "Bytes ("
						+ (totalReadByte * 100 / fileSize) + "% )");
				
				if(totalReadByte >= fileSize) {
					break;
				}
			}
			
			long endTime = System.currentTimeMillis();
			long difftime = endTime - startTime;
			double transferSpeed = fileSize / difftime;

			System.out.println("걸린 시간 : " + difftime + "(ms");
			System.out.println("평균 전송 속도 : " + transferSpeed + "(Bytes/ms)");

			System.out.println("수신 완료");
		}
	}

	/**
	 * 데이터 수신하기
	 * 
	 * @return 수신한 바이트 배열 데이터
	 * @throws IOException
	 */
	public byte[] receiveData() throws IOException {
		buffer = new byte[1000];
		dp = new DatagramPacket(buffer, buffer.length);
		ds.receive(dp);

		return dp.getData();
	}
	
	public static void main(String[] args) throws Exception {
		new UDPFileReceiver(8888).start();
	}
}
