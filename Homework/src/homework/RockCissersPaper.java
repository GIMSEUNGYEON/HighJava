package homework;

import javax.swing.JOptionPane;

public class RockCissersPaper {
	static boolean check = false;
	public static void main(String[] args) {
		
		Thread th1 = new Playing();
		th1.start();
		
		Thread th2 = new CountDown2();
		th2.start();

		int comSelect = (int) (Math.random()*3+1);
		
	}

}
class Playing extends Thread{

	@Override
	public void run() {
		String user = JOptionPane.showInputDialog("입력하세요...");
		
		System.out.println("당  신 : " + user);

		RockCissersPaper.check = true;
	}
}
class CountDown2 extends Thread{
	@Override
	public void run() {
		for(int i = 5; i > 0; i--) {
			if(RockCissersPaper.check) {
				return;
			}
			System.out.println(i + "초...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("입력값이 없습니다. 패배로 처리하고 시스템을 종료합니다.");
		System.exit(0);
	}
}

