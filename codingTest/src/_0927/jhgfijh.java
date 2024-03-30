package _0927;

public class jhgfijh {
	public static void main(String[] args) {
		int[] absolutes = {4,7,12};
		boolean[] signs = {true, false, true};
		int answer = 0;
		for(int i = 0; i < absolutes.length; i++) {
			if(signs[i]==false) {
				absolutes[i]*=(-1);
			}
			answer+= absolutes[i];
		}
		System.out.println(answer);
	}
}
