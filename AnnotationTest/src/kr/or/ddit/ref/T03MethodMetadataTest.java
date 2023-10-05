package kr.or.ddit.ref;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class T03MethodMetadataTest {
	public static void main(String[] args) throws ClassNotFoundException {
		// Class 객체 생성하기
		Class<?> klass = Class.forName("kr.or.ddit.ref.SampleVO");

		// 클래스에 선언된 모든 메서드의 메타정보 가져오기
		Method[] methodArr = klass.getDeclaredMethods();

		for (Method me : methodArr) {

			System.out.println("메서드 명 : " + me.getName());
			System.out.println("메서드 리턴 타입 : " + me.getReturnType());

			// 해당 메서드의 접근제어자 정보 가져오기
			int modFlag = me.getModifiers();
			System.out.println("메서드 접근 제어자 : " + Modifier.toString(modFlag));

			// 해당 메서드의 파라미터 타입 정보 가져오기
			Class<?>[] paramArr = me.getParameterTypes();
			System.out.print("메서드 파라미터 타입 : ");
			for (Class<?> param : paramArr) {
				System.out.print(param.getName() + " | ");
			}
			System.out.println();

			// 해당 메서드에서 던지는 예외타입 정보 가져오기
			Class<?>[] exArr = me.getExceptionTypes();
			System.out.print("메서드에서 던지는 예외 타입 : ");
			for (Class<?> ex : exArr) {
				System.out.print(ex.getName() + " | ");
			}
			System.out.println();
			
			// 해당 메서드에서 존재하는 annotation 타입 정보 가져오기
			Annotation[] annArr = me.getAnnotations();
			System.out.print("메서드에 존재하는 annotation : ");		
			for(Annotation ann : annArr) {
				System.out.println(ann.annotationType().getName() + " | ");
			}
			//run이나 toString에 있는 오버라이드는 보여주지 않는데 클래스 자체에서 선언한게 아니라 부모 클래스에서 상속받아 가져오면서 붙은거라 안가져옴
			System.out.println("\n==============================================");
		}
	}
}
