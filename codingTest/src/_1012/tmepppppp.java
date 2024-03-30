package _1012;

import java.util.HashMap;

public class tmepppppp {
	public static void main(String[] args) {
		
		String my_string = "He11oWor1d";
		
		String overwrite_string = "lloWorl";

		
		int s = 2;
		
		String answer = my_string.substring(0, s) + overwrite_string;
		
		if (my_string.length()-answer.length() > 0)
            answer += my_string.substring(s+overwrite_string.length());
				

//		for(int i = 0; i < overwrite_string.length(); i++) {
//			
//			answer = my_string.replace(my_string.charAt(i + s), overwrite_string.charAt(i));
//		}
		
		System.out.println(answer);
		
		String str1 = "aaaaa";
		String str2 = "bbbbb";
		
		String result = "";
		for(int i = 0; i < str1.length(); i++) {
			result+=str1.charAt(i);
			result+=str2.charAt(i);
		}
		
		
		System.out.println(result);
		
	}
}
