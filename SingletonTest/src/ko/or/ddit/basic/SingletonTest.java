package ko.or.ddit.basic;

public class SingletonTest {
	public static void main(String[] args) {
//		MySingleton test1 = new MySingleton(); //컴파일 에러 제한자가 private인 생성자를 이용할 수 없음

		// getInstance()를 이용하여 객체 생성
		MySingleton test2 = MySingleton.getInstance();
		MySingleton test3 = MySingleton.getInstance();

		test2.diplayText();
		test3.diplayText();

		System.out.println("test2 => " + test2); //객체의 주소 출력
		System.out.println("test3 => " + test3); //test2와 같은 주소(같은 객체)
		
		System.out.println(test2.equals(test3));
	}
}
