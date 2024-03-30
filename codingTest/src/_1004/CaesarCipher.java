package _1004;

public class CaesarCipher {
	public static void main(String[] args) {
		String s = "a B z";
		char [] sArr = s.toCharArray();
		
		char a = 'a';
		
		int n = 4;
		System.out.println("변환 전 : ");
		for(char ch : sArr) System.out.println(ch);
		
		for(char ch : sArr) {
			if((int)ch != 32) {
				ch+=n;
			}
			System.out.println(ch);
		}
		System.out.println("변환 후 : ");
		for(char ch : sArr) System.out.println(ch);
	}
}
