package kr.or.ddit.basic;

/*
 yield 메서드에 대하여
 1. 현재 실행 대기 중인 동등한 우선순위 이상의 다른 스레드에게 실행기회를 제공한다.(양보)
 2. 현재 실행 중인 스레드의 상태를 RUNNABLE로 바꾼다. (실행에서 실행대기 상태로 변함, 일시정지와는 다름)
 3. yield() 메서드를 실행한다고 해서 현재 실행 중인 스레드의 상태가 곧바로 전이된다고 확신할 수는 없다.
 양보 스레드가 더 먼저 끝날거라는 보장이 없음
 */
public class T12ThreadYieldTest {
	public static void main(String[] args) {
		Thread th1 = new YieldThreadEx1();
		Thread th2 = new YieldThreadEx2();
		th1.start();
		th2.start();
		
	}
}

class YieldThreadEx1 extends Thread{
	public YieldThreadEx1() {
		super("양보 스레드");
	}
	@Override
		public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
			for(int j = 0; j <=1000000000; j++) {}
			Thread.yield(); //양보하기
		}
	}
}

class YieldThreadEx2 extends Thread{
	public YieldThreadEx2() {
		super("양보 안하는 스레드");
	}
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
			for(int j = 0; j <=1000000000; j++) {}
//			Thread.yield(); //양보없음
		}
	}
}