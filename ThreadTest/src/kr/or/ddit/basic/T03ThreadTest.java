package kr.or.ddit.basic;

public class T03ThreadTest {
	public static void main(String[] args) {
		
		// Thread의 수행시간 체크해보기
		Thread th = new Thread(new MyRunner());
		
		//UTC(Universal Time Coordinated) 세계 협정 표준시를 이용하여 1970-01-01 0시 0분 0초를 기준으로
		//경과된 시간을 밀리세컨드(1/1000초)단위로 나타낸다.
		long startTime = System.currentTimeMillis();
		
		th.start(); //스레드 작업 시작
		
		try {
			th.join(); //현재 실행 중인 스레드에서 작업중인 스레드(지금은 th스레드)가 종료될 때까지 기다린다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("경과시간(ms) : " + (endTime - startTime));
	}
}

class MyRunner implements Runnable{
	@Override
	public void run() {
		long sum = 0;
		for(int i = 1; i <=1000000000; i++) {
			sum += i;
		}
		System.out.println("합계 : " + sum);
	}
}