package ch3;

public class OperatorEx {
	public static void main(String[] args) {
		OperatorEx oe = new OperatorEx();
//		oe.operatorEx1();
//		oe.operatorEx2();
//		oe.operatorEx3();
//		oe.operatorEx4();
//		oe.operatorEx5();
//		oe.operatorEx6();
//		oe.operatorEx7();
		oe.operatorEx8();
		oe.operatorEx9();
	}

	public void operatorEx1() {
		int i = 5;
		i++;
		System.out.println("i = " + i);

		i = 5;
		++i;
		System.out.println("i = " + i);
	}

	public void operatorEx2() {
		int i = 5, j = 0;
		j = i++;
		System.out.println("j = i++ 실행 후 j = " + j);
		i = 5;
		j = 0;
		j = ++i;
		System.out.println("j = ++i 실행 후 j = " + j);
	}

	public void operatorEx3() {
		int a = 10, b = 4;
		System.out.printf("%d + %d = %d\n", a, b, a + b);
		System.out.printf("%d - %d = %d\n", a, b, a - b);
		System.out.printf("%d * %d = %d\n", a, b, a * b);
		System.out.printf("%s / %s = %s\n", (double) a, b, (double) a / b); // 둘 중 하나만 캐스팅해도 된다.

	}

	public void operatorEx4() {
		byte a = 10;
		byte b = 20;
		byte c = (byte) (a + b); // 캐스팅 해주지 않으면 오류가 발생한다

		System.out.println("byte c : " + c);
	}

	public void operatorEx5() {

		int a = 1_000_000;
		int b = 2_000_000;

		long c = a * b;
		// 캐스팅해주지 않아 순환오류 발생
		System.out.println("연산 결과 : " + c);
		c = (long) a * b;
		System.out.println("캐스팅 후 연산 결과 : " + c);
	}

	public void operatorEx6() {
		int a = 1_000_000;

		int result1 = a * a / a;
		int result2 = a / a * a;

		System.out.printf("%d * %d / %d = %d\n", a, a, a, result1); // 곱연산을 먼저 하면 표현범위를 벗어나서 이상한 결과 발생
		System.out.printf("%d / %d * %d = %d", a, a, a, result2); // 나누기 연산을 먼저 해서 표현범위 내에서 정상 답 출력
	}

	public void operatorEx7() {
		char a = 'a';
		char d = 'd';
		char zero = '0';
		char two = '2';

		System.out.printf("'%c' - '%c' = %d\n", d, a, d - a);
		System.out.printf("'%c' - '%c' = %d\n", two, zero, two - zero);
		System.out.printf("'%c' = %d\n", a, (int) a);
		System.out.printf("'%c' = %d\n", d, (int) d);
		System.out.printf("'%c' = %d\n", zero, (int) zero);
		System.out.printf("'%c' = %d\n", two, (int) two);
	}

	public void operatorEx8() {
		char c1 = 'a';
		char c2 = c1;
		char c3 = ' ';

		int i = c1 + 1;

		c3 = (char) (c1 + 1);
		c2++;
		c2++;

		System.out.println("i = " + i);
		System.out.println("c2 = " + c2);
		System.out.println("c3 = " + c3);

	}

	public void operatorEx9() {
		char c = 'a';
		for(int i = 0; i < 26; i++) {
			System.out.print(c++);
		}
		System.out.println();
		
		c = 'A';
		for(int i = 0; i < 26; i++) {
			System.out.print(c++);
		}
		System.out.println();
		
		c = '0';
		for(int i = 0; i < 10; i++) {
			System.out.print(c++);
		}
		System.out.println();
	}

}
