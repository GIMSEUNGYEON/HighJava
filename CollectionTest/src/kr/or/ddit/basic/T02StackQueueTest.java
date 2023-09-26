package kr.or.ddit.basic;

import java.util.LinkedList;

public class T02StackQueueTest {
	public static void main(String[] args) {
		/*
		 Stack : 후입선출(LIFO) 의 구조
		 Queue : 선입선출(FIFO) 의 구조
		 */
		
		LinkedList<String> stack = new LinkedList<String>();
		/*
		 Stack을 위한 명령
		 1) 자료 입력 : push(저장할 값)
		 2) 자료 출력 : pop() => 자료를 꺼내온 후 꺼내온 자료를 stack에서 삭제한다
		 */
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");
		System.out.println("현재 stack 값들 : " + stack);
		
		String data = stack.pop();
		System.out.println("꺼내온 자료 : " + data);
		System.out.println("꺼내온 자료 : " + stack.pop());
		System.out.println("현재 stack 값들 : " + stack);
		
		stack.push("성춘향");
		System.out.println("현재 stack 값들 : " + stack);
		System.out.println("꺼내온 자료 : " + stack.pop());
		System.out.println("===========================================");
		
		LinkedList<String> queue = new LinkedList<String>();
		/*
		 Queue를 위한 명령
		 1) 자료 입력 : offer(저장할 값)
		 2) 자료 출력 : poll() => 자료를 꺼내온 후 꺼내온 자료를 Queue에서 삭제한다
		 */
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("강감찬");
		System.out.println("현재 queue의 값 : " + queue);
		
		String temp = queue.poll();
		System.out.println("꺼내온 자료 : " + temp);
		System.out.println("꺼내온 자료 : " + queue.poll());
		System.out.println("현재 queue의 값 : " + queue);
		if(queue.offer("성춘향")) {
			System.out.println("신규 등록 자료 : 성춘향");
		}
		System.out.println("현재 queue의 값 : " + queue);
		System.out.println("꺼내온 자료 : " + queue.poll());
		System.out.println(queue.offer("test"));
		System.out.println(queue.get(1)); //poll을 통해 꺼내오지 않고 데이터를 출력만 하고싶을 때
		System.out.println("현재 queue의 값 : " + queue);
		
		//queue.offer()은 boolean타입을 리턴
		//stack.push는 아닌데...
		//LinkedList 변수 이름에서만 차이가 발생하고 선언한 방식이 같은데 스택이나 큐를 여러개 선언할수는 없나
		//이름의 문제가 아니라 offer/poll/push/pop의 차이인듯 당연히 혼용해서 사용할 수 있음
		//offer/poll/push/pop 메소드들은 list에는 없고 LinkedList에만 있는 기능이라 List로 선언할수는 없음
	}
	
}
