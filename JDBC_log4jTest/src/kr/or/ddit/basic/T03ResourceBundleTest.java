package kr.or.ddit.basic;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class T03ResourceBundleTest {
	/*
	 ResourceBundle 객체  => 확장자가 properties인 파일 정보를 읽어와 key값과 value값을 분리한 정보를 갖는 객체.
	 					     읽어올 파일은 'key값=value값'형태로 되어 있어야한다.
	 					     
	 */
	public static void main(String[] args) {
		//ResourceBundle 객체 생성하기
		// => 파일을 지정할 때는 '파일명'만 지정하고 확장자는 생략한다.
		
		ResourceBundle bundle = ResourceBundle.getBundle("db", Locale.JAPANESE);
		//db 프로퍼티스 파일을 bin 폴더에 강제로 붙여넣음
		//리소스번들은 클래스패스를 기준으로 파일을 찾기 때문에 코드가 컴파일되는 bin파일로 찾아감
		//db_ko 파일이 있으므로 한국어 사용자에겐 자동으로 한국어 출력을 보여줌
		
		//key값들만 읽어오기
		Enumeration<String> keys = bundle.getKeys();
		
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			
			String value = bundle.getString(key);
			
			System.out.println(key + " => " + value);
		}
		
		System.out.println("출력 끝...");
	}
}
