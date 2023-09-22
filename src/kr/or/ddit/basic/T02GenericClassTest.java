package kr.or.ddit.basic;

import java.util.List;
import java.util.Map;
import java.util.Set;

class NonGenericClass{
	private Object val;
	//뭐든 넣을 수 있다는 장점이 있으나 직접 사용할때는 변수 타입에 따라 캐스팅해야하는 문제가 있음
	public Object getVal() {
		return val;
	}

	public void setVal(Object val) {
		this.val = val;
	}
}

class MyGeneric<T>{
	private T val;

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}
	
}
public class T02GenericClassTest {
		/*
		 제네릭 클래스를 선언하는 방법
		 형식)
		 class 클래스명<제너릭타입글자>
		 제너릭타입글자 병수명; //변수 선언에 제너릭을 사용할 경우
		 ...
		 제너릭타입글자 메서드명() {//반환값이 있는 메서드에 사용하는 경우
		 ...
		 return 값;
		}
		...
	}
--제너릭타입글자--
T => Type
K => Key
V => value
E => Element
		 */
	public static void main(String[] args) {
		NonGenericClass ng1 = new NonGenericClass();
		
		ng1.setVal("가나다라");
		
	}
}
