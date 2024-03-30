package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class T09FIleEncodingTest {
/*
 	한글 인코딩 방식
 	
     한글 인코딩 방식은 크게 UTF-8과 EUC-KR 방식으로 나누어진다.
     원래 한글윈도우에서는 CP949방식을 사용했는데 윈도우를 개발한 마이크로소프스타에서
   EUC-KR 방식에서 확장하여 만들었기 때문에 MS949라고도 부른다.
   
     한글 윈도우의 메모장에서 말하는 ANSI 계열 인코딩이란 CP949(Code Page 949)를 의미한다.
   - MS949 => 한글윈도우의 기본 한글 인코딩 방식(ANSI 계열)
   - UTF-8 => 유니코드 UTF-8 인코딩 방식(영문자 및 숫자 : 1byte, 한글 : 3byte) => 가변적
   - US-ASCII => 영문전용 인코딩 방식
   
   ASCII는 영어를 표기하기 위해 만든 코드로 규격 자체에 한글이 없었다가 나중에 한글이 추가되면서 EUC-KR, CP949 등으로 확장되었다.
   
     참고)
     ASCII => extended ASCII(ISO 8859-1) => 조합형, 완성형(KSC 5601) 
     
     => 윈도우 계열 : CP949(확장완성형) - 일부문자(8822)를 추가함. => ANSI 계열
     => 유닉스 계열 : EUC-KR(확장 유닉스 코드)
     
     =>EUC-KR
         유니코드(UTF-8)
 */
	public static void main(String[] args) {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		
		try {
//			fis = new FileInputStream("d:/D_Other/test_ansi.txt");
			fis = new FileInputStream("d:/D_Other/test_utf8.txt");
			
			//파일 인코딩 정보를 이용하여 읽어오기
			// ex) new InputStreamReader(바이트기반스트림객체, 인코딩방식)
			// 두번째 파라미터를 이용해서 인코딩 방식 지정 -> 해당 인코딩 방식으로 파일 읽어오기
//			isr = new InputStreamReader(fis, "CP949");
			isr = new InputStreamReader(fis, "utf-8");
			
			int data = 0;
			while((data = isr.read()) != -1) {
				System.out.print((char)data);
			}
			System.out.println("\n출력 끝...");
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				isr.close(); // 보조스트림만 닫아도 됨.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
