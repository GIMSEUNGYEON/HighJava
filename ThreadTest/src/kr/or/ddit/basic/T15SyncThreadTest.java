package kr.or.ddit.basic;

public class T15SyncThreadTest {
	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();
		
		WorkerThread th1 = new WorkerThread("1번스레드", sObj);
		WorkerThread th2 = new WorkerThread("2번스레드", sObj);
		
		th1.start();
		th2.start();
	}
}

class ShareObject {
	private int sum;
	//동기화하는 방법 1 : 메소드 자체에 동기화 설정하기 synchronized 키워드 붙여서 동기화
	//동기화하기 전엔 두개의 스레드에서 add 메소드가 여럿 호출되어 합계가 누계되어 200이 되긴 하지만 누락되는 합계가 있거나
	//두번 출력되는 합계가 있게 됨. 이렇게 출동하는 현상을 임계영역(critical section)이라고 부름
	//동기화함으로써 10부터 200까지 중복 및 누락 없이 누계를 구함. 하나의 메소드에 두개 이상의 스레드가 동시에 진입하지 못하고
	//하나의 스레드만이 구동하기 때문에 (스레드1 스레드2가 줄을 선다)(순서는 랜덤)최적화 성능이 많이 떨어지게 된다.
//	public synchronized void add() { 
	public void add() { 

		//동기화하는 방법 2 : 동기화 블럭으로 설정하기
		//mutex : Mutual Exclusion Object(상호배제 : 동시접근 차단) 
		//synchronized (this) {		
		for(int i = 0; i <= 1000000000; i++) {} //동기화 처리 전까지 시간 벌기
		int n = sum;
		n += 10;
		sum = n;
		System.out.println(Thread.currentThread().getName() + " => 합계 : " + sum);
		//}
	}
}

//작업 수행을 위한 스레드
class WorkerThread extends Thread{
	private ShareObject sObj;
	
	public WorkerThread(String name, ShareObject sObj) {
		super(name);
		this.sObj = sObj;
	}
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			//동기화 방법 3 : 호출한 위치에서 synchronized 블럭 이용하기
			synchronized (sObj) {
			sObj.add();
			}
		}
	}
}