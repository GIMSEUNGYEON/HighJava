package _1010;

import java.util.Arrays;

public class KNumberTest {
	public static void main(String[] args) {
		// 배열에서 i번째 숫자부터 j번째 숫자까지 자르고 정렬한 다음 k번째 수를 구하기
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		int answer [] = new int[commands.length];
		for(int i = 0; i < commands.length; i++) {			
		int tmp [] = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
		Arrays.sort(tmp);
		answer[i] = tmp[commands[i][2] - 1];
		
		
		}
	}
}
