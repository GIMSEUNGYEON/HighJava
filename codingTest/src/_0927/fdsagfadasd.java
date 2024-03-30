package _0927;


public class fdsagfadasd {
	public static void main(String[] args) {
		int slice = 4;
		int n = 12;
		int answer = 0;
		
		if(n > slice) {
			if(n%slice != 0) {
				answer = n/slice + 1;
			}else{
				answer = n/slice;
			}
		}else {
			answer = 1;
		}
		System.out.println(answer);
	}
}
