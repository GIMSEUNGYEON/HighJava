package ch2;

public class VarEx2 {
	public static void main(String[] args) {
		int year = 0, age = 14;
		// 같은 타입인 두 개 이상의 변수는 위와 같이 연이어 선언하고 초기화할 수 있다.
		System.out.println(year);
		System.out.println(age);

		year = age + 2000;
		age = age + 1;
		
		System.out.println(year);
		System.out.println(age);
		
		int x = 10, y = 20, temp;
		temp = x;
		x = y;
		y = temp;
		
		System.out.println("x : " + x);
		System.out.println("y : " + y);

		long bigData = 100_000_000_000_000L; // 너무 큰 숫자가 한눈에 안들어올 때 _를 이용하여 구분할 수 있음
		//하지만 그냥 중간에 넣을 수 있는거지 규칙이 따로 있는건 아니라 작성할 때 조심하기
		System.out.println("큰 숫자 선언하는 법 : " + bigData);
	}
}
