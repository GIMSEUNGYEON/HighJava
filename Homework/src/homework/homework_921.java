package homework;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class homework_921 {
	public static void main(String[] args) {
		
		while(true) {
		System.out.println("=============================");
		System.out.println("\tLotto 프로그램");
		System.out.println("-----------------------------");
		System.out.println("1. Lotto 구입");
		System.out.println("2. 프로그램 종료");
		System.out.println("=============================");
		System.out.print("메뉴 선택 : ");
		Scanner sc = new Scanner(System.in);
			
		int select = sc.nextInt();
		
		if(select == 1) {
			System.out.println("Lotto 구입 시작");
			System.out.println("1000원에 로또 번호 하나입니다.");
			System.out.print("금액 입력 : ");
			int money = sc.nextInt();
			System.out.println("행운의 로또 번호는 아래와 같습니다");
			for(int i = 1; i < money/1000+1; i++ ) {
				Set<Integer> Lotto = new TreeSet<Integer>();
				while(Lotto.size() < 6) {
					int num = (int)(Math.random()*45+1);
					Lotto.add(num);
				}
				System.out.println("로또 번호 " + i + " : " + Lotto);
				
			}
				System.out.println("받은 금액은 " + money + "원이고 거스름돈은 " + money%1000 + "원입니다.");
		}else if(select == 2) {
			break;
		}
	}
		System.out.println("감사합니다.");
	}
}
