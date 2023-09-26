package kr.or.ddit.basic;
/*
 제한된 타입 파라미터 문법
 */
public class T04GenericMethod {
	public static void main(String[] args) {
		int result1 = Util2.compare(10, 20);
		System.out.println(result1);
		// 입력받는 모든 변수는 Number 타입으로 제한된다
		// 이미 타입에 제한이 되어 있어 여기서 compare 앞에 타입 명시적 제한은 불가능함 
		result1 = Util2.compare(3.14, 3);
		System.out.println(result1);
	}
}

class Util2{
	public static <T extends Number> int compare(T t1, T t2) {
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		return Double.compare(v1, v2);
		// compare 타입은 앞이 크면 1 뒤가 크면 -1 같으면 0을 리턴하는 정수형 리턴
		
		//int, double 등 변수들은 number 타입을 상속받는다. number타입이 가진 메소드엔 doubleValue가 있어
		//number타입을 상속받는 모든 변수는 doubleValue를 사용할 수 있어야하지만 T 타입은 어떤 변수로 제한되지 않아
		//doubleValue를 상속받지 못한다.
		//따라서 이때 제한된 타입 파라미터를 이용하여 T 타입이 Number 타입을 상속받도록 함으로써 타입 제한을 걸어준다.
	}
}