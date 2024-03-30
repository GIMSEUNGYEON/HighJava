package _0926;

public class ArrayDuplication {
	public static void main(String[] args) {
		/*
		 두 배열이 얼마나 유사한지 확인하려고 합니다. 문자열 배열 s1과 s2가 주어질 때 같은 원소의 개수를 return하도록
		 */
		String [] s1 = {"a","b","c"};
		String [] s2 = {"com","d","b","p","c"};
		//return값 = 2
		
		int count = 0;
//		for(int i = 0; i < s1.length; i++) {
//			for(int j = 0; j < s2.length; j++) {
//				if(s1[i] == s2[j]) {
//					count++;
//				}
//			}
//		}
//		
		for(String str1 : s1) {
			for(String str2 : s2) {
				if(str1.equals(str2)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
