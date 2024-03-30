package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		List<String> testtt = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
//		String a = 
		System.out.println("이름 입력");
//		testtt.add(sc.nextLine());
//		testtt.add(sc.nextLine());
//		testtt.add(sc.nextLine());
//		testtt.add(sc.nextLine());
		
		testtt.add("메롱");
		testtt.add("메롱메롱메롱");
		testtt.add("에렐레렐ㄹ");
		testtt.add("엘렐레");
		testtt.add("testtttttttttt");
		System.out.println(testtt);
		
		for(String str : testtt) {
			boolean what = str.startsWith("김");
			
			if(what) System.out.println(str);
		}
		int max = 0;
		for(String str : testtt) {
			for(String str2 : testtt) {
				max = str.length();
			if(str.length() < str2.length()) {
				max = str2.length();
				}
			}
		}
		System.out.println(max);
	}
}
