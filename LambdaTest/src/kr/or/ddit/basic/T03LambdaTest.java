package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class T03LambdaTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("홍길동1");
		list.add("홍길동2");
		list.add("홍길동3");
		
		for(String name : list) System.out.println(name);
		
		System.out.println("---------------------------");
		
		list.forEach(new Consumer<String>() {

			@Override
			public void accept(String name) {
				System.out.println(name);
			}
		});
		
		System.out.println("---------------------------");
		
		list.forEach((name) -> System.out.println(name));
		//리스트 타입이 가지고 있는 forEach 메소드에서는 매개변수로 Consumer 타입을 요구한다.
		//Consumer 인터페이스는 자바에서 제공하는 함수적인터페이스로 이미 메소드를 가지고 있기 때문에
		//위와 같이 람다를 이용하여 코드를 간결하게 만들 수 있음.
		//이렇게 제공해주는 인터페이스는 doc 8에서 java.util.function에서 찾을 수 있음

	}
}
