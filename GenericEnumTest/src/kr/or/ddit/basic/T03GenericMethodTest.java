package kr.or.ddit.basic;

public class T03GenericMethodTest {
	public static void main(String[] args) {
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "홍길동");
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "홍길동");
		//객체를 생성하여 사용하려는 시점에 k, v에 해당하는 타입이 뭔지 지정해줘야함
		
		// 구체적인 타입을 명시적으로 지정(생략 가능)
		boolean result1 = Util.<Integer, String>compare(p1, p2);
		//compare가 제너릭메소드이기 때문에 타입을 명시적으로 지정함
		
		if (result1) {
			System.out.println("논리(의미)적으로 동일한 객체임.");
		} else {
			System.out.println("논리(의미)적으로 다른 객체임.");

		}
		if (result1) {
			System.out.println("논리(의미)적으로 동일한 객체임.");
		} else {
			System.out.println("논리(의미)적으로 다른 객체임.");
			
		}
		Pair<String, String> p3 = new Pair<String, String>("001", "홍길동");
		Pair<String, String> p4 = new Pair<String, String>("002", "홍길동");

		boolean result2 = Util.compare(p3, p4);
		//어차피 위의 p3,p4의 객체를 이용하여 compare 메소드를 호출하기 때문에 compare 메소드에서 타입을 지정하는 것은 생략 가능하다.
		if (result2) {
			System.out.println("논리(의미)적으로 동일한 객체임.");
		} else {
			System.out.println("논리(의미)적으로 다른 객체임.");
		}
		p1.displayAll("키", 180);
		//displayAll메소드에 제너릭을 주지 않으면 p1이 선언된 시점에 지정된 타입<Integer, String>을 따라가지만
		//displayAll메소드에 제너릭을 주고 값을 입력하면 입력된 변수의 타입을 따라 String, Integer가 된다.
	}
}

class Util {
	/*
	 * 제너릭 메서드 <T, R> R method(T t)
	 * 
	 * 파라미터 타입과 리턴 타입으로 타입글자를 가지는 메서드 선언방법 : 리턴타입 앞에 <> 기호를 추가하고 타입을 기술 후 사용한다.
	 */
	public static <k, v> boolean compare(Pair<k, v> p1, Pair<k, v> p2) {
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());

		return keyCompare && valueCompare;
	}
}

//멀티타입<k,v>을 가지는 제너릭 클래스
class Pair<k, v> {
	private k key;
	private v value;

	public k getKey() {
		return key;
	}

	public void setKey(k key) {
		this.key = key;
	}

	public v getValue() {
		return value;
	}

	public void setValue(v value) {
		this.value = value;
	}

	public Pair(k key, v value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	//키와 value값 출력을 위한 메서드
	public <K,V> void displayAll(K key, V value) {
		System.out.println(key + " : " + value);
		//k,v는 타입명으로 쓰겠다고 클래스를 선언할때 사용했으므로 메소드에서도 k,v는 타입으로 인식함
	}

}