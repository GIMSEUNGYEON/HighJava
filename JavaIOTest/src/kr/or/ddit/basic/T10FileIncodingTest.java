package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class T10FileIncodingTest {
	public static void main(String[] args) throws IOException{
		/*
		 키보드로 입력한 내용을 파일로 저장하는데
		 out_utf8.txt 파일은 'UTF-8' 인코딩 방식으로
		 out_ansi.txt 파일은 'CP949' 인코딩 방식으로 저장한다.
		 */
		InputStreamReader isr = new InputStreamReader(System.in);
		
		//파일 출력용
		FileOutputStream fos1 = new FileOutputStream("d:/D_Other/out_utf8.txt");
		FileOutputStream fos2 = new FileOutputStream("d:/D_Other/out_ansi.txt");
		
		//outputStreamWriter는 바이트기반 출력 스트림에 연결되어 문자기반 출력 스트림인 Writer로 변환시켜주는 보조 스트림
		//바이트기반 -> 문자기반 변환
		OutputStreamWriter osw1 = new OutputStreamWriter(fos1, "UTF-8");
		OutputStreamWriter osw2 = new OutputStreamWriter(fos2, "CP949");
		
		int data = 0;
		
		System.out.println("입력하세요...");
		// 입력 종료는 ctrl + z
		
		while((data = isr.read()) != -1) {
			osw1.write(data);
			osw2.write(data);
		}
		
		System.out.println("작업 완료...");
		
		isr.close();
		osw1.close();
		osw2.close();
	}
}
