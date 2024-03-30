package _1004;

public class basicString {
	//문자열 다루기 기본
	public static void main(String[] args) {
		//문자열 s의 길이가 4 혹은 6이고 숫자로만 구성되어있는지 확인하기
		String s = "a234";
		
		if(s.length() !=4 || s.length() !=6) {
			
		}
		for(int i = 0; i <s.length(); i++) {
			if(s.charAt(i) < '0' || s.charAt(i) > '9') {
			
			}
		}
	}
	
}
