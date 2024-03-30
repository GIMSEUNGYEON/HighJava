package ch4;

import java.util.Scanner;

public class FlowEx {
	public static void main(String[] args) {
		FlowEx fe = new FlowEx();
		
//		fe.flowEx01();
//		fe.flowEx02();
//		fe.flowEx03();
		fe.flowEx04();
	}
	public void flowEx01() {  //5*5 별 찍기
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void flowEx02() { // 점점 커지는 삼각형 별 찍기
		for(int i = 1; i < 7; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void flowEx03() {
		Loop1 : for(int i = 2; i <=9; i++) {
			for(int j  = 1; j <= 9; j++) {
				if(j==5) break Loop1;
	
				System.out.println(i+"*"+j+"="+i*j);
			}
			System.out.println();
		}
	}
	public void flowEx04() {
		int menu = 0, num = 0;
		
		Scanner sc = new Scanner(System.in);
		
		outer:
			while(true) {
				System.out.println("(1) square");
				System.out.println("(2) square root");
				System.out.println("(3) log");
				System.out.println("원하는 메뉴를 선택하세요 (종료 : 0) >> ");
				
				String temp = sc.nextLine();
				menu = Integer.parseInt(temp);
				
				if(menu == 0) {
					System.out.println("프로그램 종료");
					break;
				}else if (!(1<= menu && menu <= 3)){
					System.out.println("메뉴를 잘못 선택하셨습니다.");
					continue;
				}
				for(;;) {
					System.out.println("계산할 값을 입력하세요 (계산 종료 : 0) (전체 종료 : 99) >> ");
					temp = sc.nextLine();
					num = Integer.parseInt(temp);
					if(num == 0){
						break;
					}else if(num == 99) {
						break outer;
					}
					
					switch (menu) {
					case 1 : System.out.println("result : " + Math.pow(num,2)); break;
					case 2 : System.out.println("result : " + Math.sqrt(num)); break;
					case 3 : System.out.println("result : " + Math.log(menu)); break;
					}
				}
			}
		
	}
}
