package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class T12BufferedIOTest {
	public static void main(String[] args) throws IOException{
		//문자 기반
		FileReader fr = new FileReader("src/kr/or/ddit/basic/T11BufferedIOTest.java");
		
		BufferedReader br =  new BufferedReader(fr);
	
		String tempStr = "";
		
		while((tempStr = br.readLine()) != null ) {
			//readLine : 한줄씩 읽어오는 메소드
			System.out.println(tempStr);
		}
		
		br.close();
		
		/*
		int data = 0;
		
		while((data = fr.read()) != -1) {
			System.out.print((char)data);
			//char 타입 : 한글자씩 읽어오는 메소드
		}
		fr.close();
		 */
	}
}
