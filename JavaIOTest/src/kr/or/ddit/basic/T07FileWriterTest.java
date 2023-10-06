package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//문자기반 스트림 예제
public class T07FileWriterTest {
	public static void main(String[] args) {
		//사용자가 입력한 내용을 그대로 파일로 저장하기
		
		//콘솔(표준입출력장치)과 연결된 입력용 문자 스트림 생성
		
		//InputStreamReader => 바이트기반 스트림을 문자기반 스트림으로 변환해 주는 보조 스트림
		//보조 스트림은 주 기능이 없기 때문에 주 기능을 수행하는 스트림이 필요하다. 
		
		InputStreamReader isr = new InputStreamReader(System.in);
		
		FileWriter fw = null; //파일 출력용 문자 기반 스트림 (문자 기반 스트림에는 Reader/Writer 키워드가 들어간다) 
		
		try {
			fw = new FileWriter("d:/D_Other/testChar.txt");
			
			int data = 0;
			
			System.out.println("입력하세요..."); //콘솔에서 입력할 때 입력의 끝 표시는 Ctrl + Z키를 누르면 된다.
			while((data = isr.read()) != -1) { //Ctrl + Z가 -1을 발생시킴
				fw.write(data); //콘솔에 입력한 값을 파일에 출력하기
			}
			System.out.println("작업 끝...");
			
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				isr.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
