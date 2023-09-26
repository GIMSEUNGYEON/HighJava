
package kr.or.ddit.basic;

class Flower {
	static final int ROSE = 1;
	static final int TULIP = 2;
}

class Animal {
	static final int LION = 1;
	static final int TIGER = 2;
}

public class T07enumTest {
	// enum = enumeration 열거
	// 상수를 나열함. static final을 대체하여 사용할 수 있음
	// 기존 final 상수의 문제점
	// 상수 LION과 ROSE가 같게 정의되었으므로 같은 객체 취급하는 문제
	// enum에서는 처음부터 동물 타입인지 꽃 타입인지 구분하기 때문에 이와 같은 문제를 줄일 수 있음

	/*
	  열거형 => 상수값들을 선언하는 방법
	  
	  static final int A = 0; static final int B = 1; static final int C = 2;
	  static final int D = 3;
	  
	  enum Data {A, B, C, D};
	  
	  열거형 선언하는 방법 enum 열거형이름{상수값 목록....};
	 */

	public enum Hometown {대구};
	// City 열거형 객체 선언(기본값을 이용하는 열거형)
	public enum City {서울, 부산, 대구, 광주, 대전};
	// City 타입 상수

	// 데이터값을 임의로 저장하는 열거형 객체 선언
	// 데이터값을 지정해 줄 경우에는 생성자를 만들어서 괄호 속의 값이 변수에 저장되도록 해야한다.
	public enum Season {
		봄("3월부터 5월까지"), 여름("6월부터 8월까지"), 가을("9월부터 11월까지"), 겨울("12월부터 2월까지");

		// 괄호 속의 값이 저장될 변수 선언
		private String data;
		
		// 생성자 만들기(열거형의 생성자는 제어자가 묵시적으로 'private'임)
		Season(String data) {
			this.data = data;
		}

		// 값을 제공하기 위한 getter메서드 작성
		public String getData() {
			return data;
		}
	}
	//클래스 생성과 유사한 점이 많다.
	//생성자가 private인 경우 : 싱글톤 ? 
	//생성자가 private일 때 특징 : 외부에서 생성자 호출이 불가능(객체 생성 불가)
	//enum은 상수값을 대체하기 때문에 여러 객체를 생성하는걸 막고 이미 생성된 상수만을 이용할 수 있도록 함.
	//따라서 seteter는 필요하지 않으며 외부로 보내는 getter만이 존재
	//일반적인 생성자 사용 : new 생성자이름으로 객체 생성
	public static void main(String[] args) {

//		int a = Animal.LION;
//		if(a == Flower.ROSE) {
//			System.out.println("이것은 확실한 장미입니다.");
//		}else {
//			System.out.println("아닌듯"); 
//		}
		
		/*
		 열거형에서 사용되는 메서드
		 
		 1. name() => 열거형 상수의 이름을 문자열로 반환한다. 
		 2. ordinal() => 열거형 상수가 정의된 순서값을 반환한다.
		 				 (기본적으로 0부터 시작한다.) 
		 3. valueOf("열거형상수이름") => 지정된 열거형에서 '열거형상수이름'과 일치하는 열거형 상수를 반환한다.
		 */
		
		City myCity1; // 열거형 객체변수 선언
		City myCity2; // City에서는 생성자를 만들지 않았음

		// 열거형 객체변수에 값 저장하기
		myCity1 = City.서울;
		myCity2 = City.valueOf("서울");

		System.out.println("myCity1 => " + myCity1.name());
		System.out.println("myCity1의 ordinal => " + myCity1.ordinal());
		System.out.println("myCity2 => " + myCity2);
		System.out.println("myCity2의 ordinal => " + myCity2.ordinal());
		System.out.println("=======================================");

		Season ss = Season.valueOf("가을");
		System.out.println("name => " + ss.name());
		System.out.println("ordianl => " + ss.ordinal());
		System.out.println("getter 호출 => " + ss.getData());
		System.out.println("=======================================");

		// 열거형이름.values() => 열거형 상수 배열을 가져온다.
		Season[] enumArr = Season.values();
		//values는 map에서도 사용됨
		for (Season s : enumArr) {
			System.out.println(s.name() + " : " + s.getData());
		}
		System.out.println();

		for (City city : City.values()) {
			System.out.println(city + " : " + city.ordinal());
		}
		
		System.out.println();
		
		City city = City.대구;

		System.out.println(city == City.대전);
		System.out.println(city == City.대구);

		System.out.println();

		System.out.println(city.ordinal() == ss.ordinal());
		//순서가 같은가? 비교 
//		System.out.println(city == Hometown.대구);
		//city타입의 대구와 Hometown 타입의 대구를 비교하기 때문에 타입 자체가 달라 비교 불가 컴파일 에러
		
		System.out.println(">>>>>>" + city.equals(Hometown.대구) + "<<<<<<");
		// 두 상수의 name이 같을 뿐 클래스도 다르고 따로 선언되었기 때문에 다른 객체 취급함. 출력할때에는 name을 출력하기 때문에 같은것처럼 보임.
		// 이것도 오류 방지의 일환.

		System.out.println("대구 => " + city.compareTo(City.대구));
		System.out.println("서울 => " + city.compareTo(City.서울)); //서수 비교 서울 0 대구 2
		System.out.println("대전 => " + city.compareTo(City.대전)); //대전 4
		//enum 상수는 comparable이기도 하다.
		
		//enum 사용 장점 : 타입 자체를 비교하기 때문에 실수할 수 있는 여지를 컴파일 시점에서 줄여줌
		//하나의 객체로서 관리되기 때문에 상수 이상의 기능을 부여하거나 사용할 수 있다는 장점
	}
}