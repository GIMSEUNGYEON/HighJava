package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
 단일 스레드에서의 사용자 입력 처리
*/
public class T06ThreadTest {	
	//입력 여부를 확인하기 위한 변수 선언
	public static boolean INPUT_CHECK = false;
	public static void main(String[] args) {
		Thread th1 = new DataInput();
		th1.start();
		
		Thread th2 = new CountDown();
		th2.start();
		
		System.out.println("메인메소드 끝");
		
	}
}


class DataInput extends Thread{
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("입력하세요...");
		//윈도우 창으로 뜨는 입력창에 입력하면
		System.out.println("입력한 값은 "+ str + "입니다.");
		//str이 받아서 출력해줌
		
		T06ThreadTest.INPUT_CHECK = true; //입력이 완료되었음을 알려줌
	}
}

class CountDown extends Thread{
	@Override
	public void run() {
		for(int i = 10; i > 0; i--) {
			
			if(T06ThreadTest.INPUT_CHECK) {
				return;
			} //입력값이 존재할 때 스레드 종료
			
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} //10초 카운트다운 반복문
		
		//10초가 경과되었는데도 입력이 없는 경우 프로그램을 종료한다
		System.out.println("10초가 지났습니다. 프로그램을 종료합니다.");
		System.exit(0); //프로그램을 강제종료 시키는 명령
	}
}
