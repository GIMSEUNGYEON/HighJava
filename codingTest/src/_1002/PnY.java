package _1002;

public class PnY {
	public static void main(String[] args) {
		String s = "pPooooyY";
		s = s.toLowerCase();
		int pNo = 0;
		int yNo = 0;
		
		for(char ch : s.toCharArray()) {
			if(ch=='p') {
				pNo++;
			}else if(ch=='y'){
				yNo++;
			}
		}
		System.out.println(pNo);
		System.out.println(yNo);
		
		boolean answer = (pNo == yNo) ? true : false;
		System.out.println(answer);
	}
}
