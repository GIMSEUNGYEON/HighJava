package kr.or.ddit.basic;

public class T16SyncAccountTest {
	public static void main(String[] args) {
		
		SyncAccount sAcc = new SyncAccount();
		Thread th1 = new BankThread(sAcc);
		Thread th2 = new BankThread(sAcc);
		sAcc.deposit(10000);
		th1.start();
		th2.start();
	}
}

//은행의 입출금 관리를 위한 공유클래스 정의
class SyncAccount {
	private int balance; //잔액이 저장될 변수

	public synchronized int getBalance() {
		return balance;
	}
	
	//입금처리를 수행하는 메서드
	public void deposit(int money) {
	balance += money;
	}
	
	//출금처리를 수행하는 메서드(출금 성공 : true, 출금 실패 : false 반환)
	//동기화 영역에서 호출하는 메서드 동기화 처리를 해주어야함.
	//동기화 블럭 안에서 호출한 메서드가 동기화처리가 되지 않았다면 
	//호출한 메서드를 실행하는 사이에 임계영역이 발생할 수 있기 때문
	//따라서 동기화블럭 안에서 호출한 메서드도 동기화처리를 해주어야함.
	public synchronized boolean withdraw(int money) {
		if(balance >= money) { //잔액이 충분할 경우
			for(int i = 1; i <= 1000000000; i++) {} //시간 벌기
				balance -= money;
				System.out.println("메서드 안에서 balance = " + getBalance());	
				return true;
		}else {
			return false;
		}
	}
}

//은행업무를 처리하기 위한 스레드
class BankThread extends Thread{
	private SyncAccount sAcc;
	
	public BankThread(SyncAccount sAcc) {
		this.sAcc = sAcc;
	}
	@Override
	public void run() {
		boolean result = sAcc.withdraw(6000); //6000원 인출
		
		System.out.println("스레드 안에서 result = " + result 
				+ ", balance = " + sAcc.getBalance());
	}
}
