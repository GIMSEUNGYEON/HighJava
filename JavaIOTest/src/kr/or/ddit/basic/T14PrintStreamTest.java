package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

//프린터 기능을 제공하는 보조 스트림
public class T14PrintStreamTest {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("d:/D_Other/print.txt");

		// PrintStream은 모든 타입의 데이터를 출력할 수 있는 기능을 제공하는 OutputStream의 서브 클래스이다.
		PrintStream ps = new PrintStream(fos);
		ps.print("안녕하세요, PrintStream입니다. \n");
		ps.println("안녕하세요, PrintStream입니다.2");
		ps.println("안녕하세요, PrintStream입니다.3");
		ps.println(fos); // 객체 출력
		ps.println(3.14);

		System.out.println("출력 완료...");
		ps.close();
		
		//////////////////////////////////////////////////////////////////
		
		//PrintWriter가 PrintStream보다 다양한 언어의 문자를 처리하는 데에 적합
		
		FileOutputStream fos2 = new FileOutputStream("d:/D_Other/print2.txt");
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(fos2, "CP949")); //인코딩 방식 지정하기
		
		pw.print("안녕하세요. PrintWriter입니다. \n");
		pw.println("안녕하세요. PrintWriter입니다.2");
		pw.println("안녕하세요. PrintWriter입니다.3");
		pw.print(fos2);
		
		pw.close();
		
	}
}
