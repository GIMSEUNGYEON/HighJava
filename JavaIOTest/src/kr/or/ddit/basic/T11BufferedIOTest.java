package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class T11BufferedIOTest {
	public static void main(String[] args) {
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream("d:/D_Other/bufferTest.txt");
			//숫자를 저장할 거라서 바이트기반 스트림을 이용
			
			//버퍼의 크기를 지정하지 않으면 기본적으로 버퍼의 크기가 8192(8kb)로 설정된다.
			bos = new BufferedOutputStream(fos, 5);
			//기본 스트림이 필요한 보조 스트림 스트림의 크기를 설정해주는 버퍼역할
			
			for(char ch = '1'; ch<='9'; ch++) {
				bos.write(ch);
			}
			
			bos.flush(); //작업을 종료하기 전에 버퍼에 남아있는 데이터를 모두 출력시킨다.(close()시 자동으로 호출되는 메서드.)
			// 해당 스트림에 대한 모든 버퍼를 지우고 버퍼링된 데이터가 내부 디바이스에 쓰도록 한다. 
			
			System.out.println("작업 끝...");
			
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
