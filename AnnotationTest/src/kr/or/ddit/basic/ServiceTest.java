package kr.or.ddit.basic;

public class ServiceTest {
	
	@PrintAnnotation
	public void method01() {
		System.out.println("메서드1 출력");
	}
	
	@PrintAnnotation("%") //요소값을 부여하는게 value하나일땐 생략 가능 근데 count같은건 하나만 부여하고 싶어도 써야함
	public void method02() {
		System.out.println("메서드2 출력");
	}
	
	@PrintAnnotation(value = "#", count = 30)
	public void method03() {
		System.out.println("메서드3 출력");
	}
}
