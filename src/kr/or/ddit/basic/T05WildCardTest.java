package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

/*
  와일드카드
  와일드카드(?)는 제너릭 타입을 이용한 타입 안전한 코드를 위해 사용되는 특별한 종류의 인수(Argument)로서,
   변수선언, 객체생성 및 메서드 정의할 때 사용된다.(제너릭 타입 선언시에는 사용할 수 없다.)
   
   <? extends T> => 와일드카드의 상한 제한, T와 그 자손들만 가능 
   <? super T>   => 와일드카드의 하한 제한, T와 그 조상들만 가능
   <?> 			 => 모든 허용가능한 타입 가능.  
 */
public class T05WildCardTest {
	public static void main(String[] args) {
		
	
	List<String> list1 = new ArrayList<String>();
	List<Integer> list2 = new ArrayList<Integer>();
	// 타입 제한은 한가지만 할 수 있으므로 서로 다른 타입을 담고 싶다면 리스트를 새로 생성해야한다.
	//	List<T> list3 = new ArrayList<E>();
	// 객체를 초기화할때에는 명시적인 타입을 설정해야하므로 K, V, T 등 임의의 이름은 지정할 수 없다.

	List<?> list3 = new ArrayList<String>();
	list3 = new ArrayList<Integer>();
	//이때 와일드카드 ? 를 이용하여 두가지 이상의 변수를 객체 하나에 담을 수 있다.
	
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();

		fruitBox.add(new Apple());
		fruitBox.add(new Grape());

		appleBox.add(new Apple());
		appleBox.add(new Apple());

		Juicer.makeJuice(fruitBox);
		Juicer.makeJuice(appleBox);
	}
}

class Fruit {
	private String name;

	public Fruit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {

		return "과일 (" + name + ")";
	}

}

class Apple extends Fruit {

	public Apple() {
		super("사과");

	}

}

class Grape extends Fruit {

	public Grape() {
		super("포도");

	}

}

class Juicer {
//	static <T extends Fruit> void makeJuice(FruitBox<T> box) { 셋 모두 가능한 방식
//	static void makeJuice(FruitBox<? extends Fruit> box) {
	//정확히 무슨 타입인지는 모르지만 fruit의 하위 클래스만 사용할 수 있다.
		static void makeJuice(FruitBox<?> box) {
			//FruitBox 클래스 선언 부분에서 Fruit를 extends 받아 여기서도 Fruit 상속
			String fruitListStr = ""; // 과일 목록
		int cnt = 0;
		for (Object f : box.getFruteList()) {
			//임시 객체 f의 타입은 object로 선언되었지만 와일드카드를 통해 fruit의 하위클래스만 사용할 수 있으므로
			//오브젝트의 하위 클래스 중 fruit의 하위만 이용할 수 있음
			if (cnt == 0) {
				fruitListStr += f;
			} else {
				cnt++;
			}
			System.out.println(fruitListStr + " => 쥬스 완성 !!");
		}
	}
}

class FruitBox<T extends Fruit> {
	private List<T> fruitList;

	public FruitBox() {
		fruitList = new ArrayList<T>();
	}

	public List<T> getFruteList() {
		return fruitList;
	}

	public void add(T fruit) {
		fruitList.add(fruit);
	}
}