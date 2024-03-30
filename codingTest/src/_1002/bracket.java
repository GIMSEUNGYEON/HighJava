package _1002;

import java.util.LinkedList;

public class bracket {
	public static void main(String[] args) {
		bracket br = new bracket();
		br.RightBracket();
		System.out.println(br.Solution("((())))()()("));
	}
	public boolean RightBracket() {
		
	String s = "())";
	LinkedList<Character> answer = new LinkedList<Character>();
	
	if(s.toCharArray()[0] == ')') return false;
	
	answer.push(s.charAt(0));
	
	for(int i = 1; i < s.toCharArray().length; i++) {
		if(s.toCharArray()[i]==')') {
			answer.clear();
		}else {
			answer.push(s.toCharArray()[i]);
		}
	}
	System.out.println(answer);
	if(answer.isEmpty()) {
		return true;	
	}else {
		return false;
	}
	}
	
	public boolean Solution(String s) {
		int count = 0;
		for(char ch : s.toCharArray()) {
			count += (ch == '(') ? 1 : -1;
			if(count < 0) return false;
        }
        return count == 0 ? true : false;
	}
}
