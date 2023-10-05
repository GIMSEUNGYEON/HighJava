package kr.or.ddit.ref;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import kr.or.ddit.basic.PrintAnnotation;
import kr.or.ddit.basic.ServiceTest;

public class AnnotationTest {
	public static void main(String[] args) {
		System.out.println("static 상수값 : " + PrintAnnotation.id);

		// reflection 기능을 이용한 메서드의 메타정보 가져오기
		Class<?> clazz = ServiceTest.class;

		Method[] mehtodArr = clazz.getDeclaredMethods();

		for (Method m : mehtodArr) {
			System.out.println("메서드 명  :" + m.getName());

			Annotation[] annos = m.getDeclaredAnnotations();
			for (Annotation anno : annos) {
				
				if (anno.annotationType().getSimpleName().equals("PrintAnnotation")) {
					PrintAnnotation printAnno = (PrintAnnotation) anno;
					for (int i = 0; i < printAnno.count(); i++) {
						System.out.print(printAnno.value());
					}
				}
			}
			System.out.println("\n==================");
		}
	}
}
