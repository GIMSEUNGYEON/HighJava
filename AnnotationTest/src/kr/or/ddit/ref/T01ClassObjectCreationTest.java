package kr.or.ddit.ref;

public class T01ClassObjectCreationTest {
/*
 Java Reflection
 		1. 리플렉션은 런타임 시점에 클래스 또는 멤버변수, 메서드, 생성자에 대한 정보를 가져오거나 수정할 수 있고, 새로운 객체를 생성하거나 메소드를 실행할 수 있다.
 	   	   (컴파일 시점에서 해당 정보를 알 수 없는 경우(소스코드 부재)에 유용하게 사용될 수 있다. 
 	    2. 리플렉션 API는 java.lang.reflect 패키지와 java.lang.Class를 통해 제공된다.
 	    3. java.lang.Class의 주요메소드
 	   		- getName(), getSuperClass(), getIngerfaces(), getModifiders() 등
 	    4. java.lang.reflect 패키지의 주요 클래스
 	   		- Field, Method, Construction, Modifier 등
 	
 */
	public static void main(String[] args) throws ClassNotFoundException{
	
		//첫번째 방법 Class.forName() 이용
		Class <?> kclass = Class.forName("kr.or.ddit.ref.T01ClassObjectCreationTest");
		//존재하지 않는 클래스를 호출할 경우 오류가 발생하기 때문에 클래스가 잘 생성되었는지 여부를 확인하기 위해 사용하기도 함
		
		//두번째 방법 getClass() 메서드 이용하기
		T01ClassObjectCreationTest obj = new T01ClassObjectCreationTest();
		kclass = obj.getClass();
		//객체를 생성했을 때 사용한 클래스 오브젝트를 담을 때 사용
		
		//세번째 방법 .class 이용
		kclass = T01ClassObjectCreationTest.class;
		//클래스 오브젝트가 리턴됨
		
	}
		
}
