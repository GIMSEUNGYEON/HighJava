package _1011;

public class rmy_StringTest {
	public static void main(String[] args) {
		//문자열에서 m을 찾아 rn으로 바꾸기
		String rny_string = "masterpiece";
		String answer = rny_string.replace("m", "rn");
		
		System.out.println(answer);
		
		String myString = "cvsgiorszzzmrpaqpe";
		int [] index_list = {16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7};
		
		String result = "";
		
		for(int i : index_list) {
			result += myString.charAt(i);
		}
		System.out.println(result);
		
		result = myString.substring(0, 12);
		System.out.println(result);
	}
}
