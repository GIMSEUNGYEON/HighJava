package kr.or.ddit.basic;

public class T14ThreadShareDataTest {
/*
 스레드에서 데이터를 공통(공용)으로 사용하는 방법
 
 1. 공통으로 사용할 데이터를 클래스로 정의한다.
 2. 공유객체를 생성한다.
 3. 이 공유객체를 각각의 스레드에 제공한다.
 4. 각각의 스레드는 이 공유객체의 데이터를 이용하여 작업을 처리한다.
 
 */
	public static void main(String[] args) {
		ShareData sd = new ShareData();
		
		Thread th1 = new CalcPIThread(sd);
		Thread th2 = new PrintPIThread(sd);
		
		th1.start();
		th2.start();
	}
}

//원주율 정보를 관리하기 위한 공유클래스
class  ShareData{
	private double result; //원주율이 저장될 변수
	
	/*
	 volatile(휘발성 물질) => 선언된 변수를 컴파일러의 최적화 대상에서 제외시킨다.
	 컴파일러는 스레드 재생 도중 최적화를 위해 메모리를 참고하지 않기 때문에 
	 메모리에서 변수의 값이 변경되어도 스레드에서는 변수의 값을 변경을 인식하지 못한다.
	 따라서 volatile을 이용하여 최적화 대상에서 제외시키면 스레드는 재생 도중 메모리에서 변경된 변수를 참조하기 때문에
	 재생 속도는 다소 떨어지는 대신 변수의 변경을 인식할 수 있게 된다.
	 즉, 값이 변경되는 즉시 변수에 적용시킨다. (일종의 동기화)
	 */
	private volatile boolean isOk;  // 원주율 계산이 완료되었는지 확인하기 위한 변수
	
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public boolean isOk() {
		return isOk;
	}
	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
}
//원주율 계산하는 스레드
class CalcPIThread extends Thread{
	private ShareData sd;

	public CalcPIThread(ShareData sd) {
		this.sd = sd;
	}
	@Override
	public void run() {
	/*
	 원주율 = (1/1 - 1/3 + 1/5 - 1/7 + 1/9 ......) * 4
	  		  1  -  3  +  5  -  7  +  9   => 분모값
	  		  0     1     2     3     4   => 분모를 2로 나눈 몫     
	 */
	double sum = 0.0;
	for(int i = 1; i <= 1500000000; i+=2) {
		if(((i/2)%2)==0) { //2로 나눈 몫이 짝수이면 +
			sum += (1.0/i);
		}else {//2로 나눈 몫이 홀수이면 - 
			sum -= (1.0/i);
		}
	}
	sd.setResult(sum * 4);
	sd.setOk(true);
	}
}

class PrintPIThread extends Thread{
	private ShareData sd;
	public PrintPIThread(ShareData sd) {
		this.sd = sd;
	}
	@Override
	public void run() {
		while(true) {
			//원주율 계산이 완료되었는지 체크
			if(sd.isOk()) {
				break;
			}
		}
		System.out.println();
		System.out.println("계산된 원주율 : " + sd.getResult());
		System.out.println("       PI : " + Math.PI);
	}
}