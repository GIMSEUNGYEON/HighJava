package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T01ArrayListTest {
	public static void main(String[] args) {
		//기본 용량 : 10
		List list1 = new ArrayList();
		//기본 용량을 자체적으로 10자리를 할당하는데, 자리를 직접 설정하고 싶다면 ArrayList(100) 괄호 사이에 숫자를 입력하면 됨
		//ArrayList list1 = new ArrayList();로 선언했을때와 차이 : 위와 같이 선언하면 List에 있는 모든 하위 클래스를 
		//사용할 수 있기 때문에 ArrayList 뿐만 아니라 LinkedList 등 다른 리스트를 사용할수도 있다. 
		//코드를 수정하기 용이함.
		//add 메소드를 사용하여 데이터를 추가한다
		list1.add("aaa");
		list1.add("bbb");
		list1.add(111);
		list1.add('k');
		list1.add(true);
		list1.add(12.34);
		
		//size() => 데이터 개수
		System.out.println("size() = >" +list1.size());
		System.out.println("list1 = >" +list1);
		
		//get()을 이용하여 데이터 꺼내오기
		System.out.println("1번째 자료 : " + list1.get(0));
		
		//데이터 끼워넣기
		list1.add(0,"zzz");
		System.out.println("list1(끼워넣은 후)  : " + list1);
		
		//데이터 변경하기
		String temp = (String) list1.set(0,"yyy");
		System.out.println("temp => " + temp); //대체하기 전의 값 zzz가 저장됨
		System.out.println("list1(데이터 변경 후) => " + list1);
		
		//데이터 삭제하기
		list1.remove(0);
		System.out.println("list1(데이터 삭제 후) => " + list1);
		
		list1.remove("bbb");
		System.out.println("bbb 삭제 후 => " + list1);
		list1.remove(new Integer(111));
		System.out.println("111 삭제 후 => " +list1);
		System.out.println("===============================================");
		
		List<String> list2 = new ArrayList<String>();
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");
		//contains 비교 객체 리스트에 비교객체가 있으면 true 없으면 false를 반환
		for(String s : list2) System.out.println(s);
		
		System.out.println(list2.contains("DDD"));
		
		//indexOf(비교객체) => 리스트에서 비교객체를 찾아 비교객체가 존재하는 인덱스 위치를 반환함
		// 없다면 -1을 리턴
		System.out.println("DDD의 인덱스값 : " + list2.indexOf("DDD"));
		System.out.println("ZZZ의 인덱스값 : " + list2.indexOf("ZZZ"));
		System.out.println("===============================================");
		
		
		for(int i = list2.size() - 1; i >= 0; i--) {
			list2.remove(i);
		}
//		for(int i = 0; i< list2.size(); i++) {
//			list2.remove(i);
//		}
//		//지우는 구문
		
		for(String s : list2) System.out.println(s);
		System.out.println(list2.size());
	}
	
}
