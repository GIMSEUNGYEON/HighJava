package kr.or.ddit.basic;

public class T02ThreadTest {
	public static void main(String[] args) {
		//멀티쓰레드 프로그램
		//방법1 : Thread 클래스를 상속한 class의 인스턴스를 생성한 후 이 인스턴스의 start() 메서드를 호출한다.
		MyThread1 th1 = new MyThread1();
		th1.start();
		
		//방법2 : Runnable 인터페이스를 구현한 class의 인스턴스를 생성한 후 
		//		 이 인스턴스를 Thread객체의 인스턴스를 생성할 때 생성자의 매개변수로 넘겨준다.
		// 		 이때 생성된 스레드객체의 인스턴스 메서드 start()를 호출한다.
		// 작업이 고정적이고 별도의 객체가 필요할 때
		//굳이 방법1로 안하고 새로운 방법을 만든 이유 : 자바에서는 다중상속이 불가능하기 때문에 인터페이스 상속을 이용함
		Runnable r = new MyThread2();
		Thread th2 = new Thread(r);
		th2.start();
		
		//방법3 : 익명 클래스를 이용하는 방법
		//		 Runnable 인터페이스를 구현한 익명클래스를 Thread인스턴스를 생성할 때 매개변수로 넣어준다.
		//		 이때 생성된 인스턴스 메서드 start()를 호출
		// 임시 생성이 필요할 때
		Thread th3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i <=200; i++) {
					System.out.print("@");
					
					try {
						//Thread.sleep(시간) => 주어진 시간 동안 작업을 잠시 멈춘다.
						//시간은 밀리세컨드 단위를 사용한다.
						//즉, 1000은 1초를 의미한다.
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println();
			}
		});
		
		th3.start();
		
		System.out.println("\nmain() 메서드 끝...");
	}
}

class MyThread1 extends Thread{
	
	@Override
	public void run() {
		for(int i = 1; i <=200; i++) {
			System.out.print("*");
			
			try {
				//Thread.sleep(시간) => 주어진 시간 동안 작업을 잠시 멈춘다.
				//시간은 밀리세컨드 단위를 사용한다.
				//즉, 1000은 1초를 의미한다.
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}

class MyThread2 implements Runnable{
	
	@Override
	public void run() {
		for(int i = 1; i <=200; i++) {
			System.out.print("$");
			
			try {
				//Thread.sleep(시간) => 주어진 시간 동안 작업을 잠시 멈춘다.
				//시간은 밀리세컨드 단위를 사용한다.
				//즉, 1000은 1초를 의미한다.
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}
