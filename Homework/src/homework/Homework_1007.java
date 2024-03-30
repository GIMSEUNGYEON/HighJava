package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Homework_1007 {
	public static void main(String[] args) {
		//D:/D_Other에 있는 Tulips.jpg 파일을 복사본_Tuilps.jpg로 복사하는 프로그램을 작성하시오.
		
		long startTime = System.currentTimeMillis();
		File exFile = new File("d:/D_Other/Tulips.jpg");
		File copyFile = new File("d:/D_Other/복사본_Tulips.jpg");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(exFile); //기존 파일
			fos = new FileOutputStream(copyFile); //새로 만들어서 복사할 파일
			
			int data = 0;
			
			while((data = fis.read()) != -1) {
				fos.write(data); 
				//fis에 있는 데이터를 read 메소드로 data 변수에 넣고 write메소드로 data를 fos 파일에 넣음
			}
			if(copyFile.exists())	System.out.println("복사 성공 !");
			//복사 성공 !
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			//자원 반납을 위한 finally
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println("경과 시간 : " + ((long)endTime - (long)startTime)); //버퍼를 사용하지 않았을 때 경과시간 : 약 2초(2300)
		
		
	}
}
