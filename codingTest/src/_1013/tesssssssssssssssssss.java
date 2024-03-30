package _1013;

public class tesssssssssssssssssss {
	public static void main(String[] args) {
		String [] s1 = {"a","b","c"};

		String [] s2 = {"com","c","a","r","d"};
		
		int answer = 0; 
		
		for(String s : s1) {
			for(String ss : s2) {
				if(s == ss) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);

		answer = 0;
		
		for(int i = 0; i < s1.length; i++ ) {
			for(int j = 0; j < s2.length; j++) {
				if(s1[i] == s2[j]) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	
	}
}
