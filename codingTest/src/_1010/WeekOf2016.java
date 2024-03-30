package _1010;

public class WeekOf2016 {
	public static void main(String[] args) {
		// 2016년 1월 1일은 금요일입니다
		// 2016년 a월 b일은 무슨 요일일까요?
		int a = 5, b = 24;
		System.out.println(new String[] { "SUN", "MON", "TUE", "WED", "THU", "FRI","SAT" }
		[(new int[] { 0, 4, 0, 1, 4, 6, 2, 4, 0, 3, 5, 1, 3 }[a] + b) % 7]);

		String [] week = {"FRI","SAT", "SUN", "MON", "TUE", "WED", "THU" };
		
		int [] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int answer = 0;
		for(int i = 0; i < a - 1; i++) {
			answer += month[i];
		}
		answer += b - 1;
		
		System.out.println(week[answer%7]);
		
	}
}
