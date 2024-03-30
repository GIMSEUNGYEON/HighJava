package _1010;

import java.util.Arrays;

public class budgetTest {
	public static void main(String[] args) {
		// 최대한 많은 부서에게 예산을 주려고 합니다. 예산을 배정할 때에는 각 부서가 신청한 금액만큼은 모두 줘야합니다.
		// 예를 들어 1000원을 신청한 부서에게는 정확히 1000원을 지원해야하며, 더 적은 금액을 지원해줄 수는 없습니다.
		// 부서별로 신청한 금액이 들어있는 배열 d와 예산 budget이 매개변수로 주어질 때, 최대 몇개의 부서에 물품을 지원할 수 있는지
		// return하여 solution함수를 완성해주세요.
		// 입출력 예 : [1,3,2,5,4] budget = 9 answer = 3
		// 입출력 예 : [2,2,3,3] budget = 10 answer = 4

//		int[] d = { 1, 3, 2, 5, 4 };
//		int budget = 9;
		int[] d = {2,2,3,3};
		int budget = 10;
		int answer = 0;
		
		System.out.println("길이 ? " + d.length);
		Arrays.sort(d);
		
		int temp = 0;
		for (int i = 0; i < d.length; i++) {
		temp+=d[i];
		System.out.println(temp);
		if(budget < temp) {
			System.out.println("최대 지원 가능 수는 " + i);
			break;
		}else if(temp <= budget) {
//		}else if(temp == budget) { ???
			System.out.println("최대 지원 가능 부서는 " +  d.length);
		}
		}
	}
}
