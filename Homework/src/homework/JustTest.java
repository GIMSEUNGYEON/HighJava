package homework;

import java.util.Scanner;

public class JustTest {
	public static void main(String[] args) {

	}

	public int[] solution(int[] numbers, int num1, int num2) {
		int[] answer = new int[num2 - num1 + 1];

		int i = num1;
		for (int j = 0; j < num2 - num1 + 1; j++) {
			answer[j] = numbers[i];
			i++;

		}
		return answer;
	}

}
