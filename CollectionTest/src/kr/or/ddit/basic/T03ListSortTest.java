package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T03ListSortTest {
	public static void main(String[] args) {
		/*
		 정렬과 관련된 Interface는 Comparable과 Comparator 이렇게 두 가지가 있다.
		 
		 보통 객체 자체에 정렬기능을 넣기 위해서는 Comparable을 구현하고
		 정렬 기준을 별도로 구현하고 싶을 떄는 Comparator를 구현하여 사용한다.
		 */
		List<String> list = new ArrayList<String>();
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		
		System.out.println("정렬 전 : " + list);
		
		//정렬은 Collections.sort() 메소드를 이용하여 정렬한다
		//정렬은 기본적으로 오름차순 정렬을 수행한다.
		
		Collections.sort(list);
		System.out.println("정렬 후 : " + list);
		
		Collections.shuffle(list); //섞기
		System.out.println("섞은 후 : " + list);
		
		Collections.sort(list, new Desc());
		System.out.println("정렬 후 : " + list); //new Desc가 양수일땐 오름차순 음수면 내림차순
		
	}
}
//정렬 방식을 구현하기 위한 외부 정렬자 클래스
class Desc implements Comparator<String>{

	@Override
	public int compare(String str1, String str2) {
		/*
		compare() 메소드의 반환값을 결정하는 방법
		오름차순일 경우 앞의 값이 크면 양수, 같으면 0, 작으면 음수를 반환하도록 한다.
		
		 */
		
		return str1.compareTo(str2) * -1;
	}
	
}