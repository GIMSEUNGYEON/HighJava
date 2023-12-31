package kr.or.ddit.basic;

public class T04ThreadTest {
	/*
	 1~20억까지의 합계를 구하는데 걸린 시간 체크하기
	 전체 합계를 구하는 작업을 단독으로 처리했을 때(1개의 쓰레드를 이용했을 때)와
	 여러 스레드로 분할해서 작업할 때의 시간을 확인해보자.
	 */
	public static void main(String[] args) {
		//단일 스레드로 처리하는 경우
		SumThread sm = new SumThread(1L, 2000000000L);
		long startTime = System.currentTimeMillis();
		sm.start();
		
		try {
			sm.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("단독 처리 경과 시간 : " + (endTime - startTime));
	
		System.out.println("\n");
		////////////////////////////////////////////////////////////////////////
		
		// 여러스레드가 협력해서 처리했을 때
		SumThread[] sumThs = new SumThread[] {
			new SumThread(	   	   1L,  500000000L), 
			new SumThread( 500000001L, 1000000000L), 
			new SumThread(1000000001L, 1500000000L), 
			new SumThread(1500000001L, 2000000000L), 
			
		};
		startTime = System.currentTimeMillis();
		for(SumThread st : sumThs) {
			st.start();
		}
		for(SumThread st : sumThs) {
			try {
				st.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		endTime = System.currentTimeMillis();

		System.out.println("다중 처리 경과 시간 : " + (endTime - startTime));
		
	}
}	

class SumThread extends Thread{
	private long min, max;

	public SumThread(long min, long max) {
		this.min = min;
		this.max = max;
	}
	
	@Override
	public void run() {
		long sum = 0L;
		for(long i = min; i <= max; i++) {
			sum += i;
		}
		System.out.println(min + " ~ " + max + "까지의 합 : " + sum);
	} 
	
}