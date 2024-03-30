package _1004;

public class measureTest {
	public static void main(String[] args) {
		// 주어진 두 수 사이의 모든 수 중에서 약수의 개수가 짝수인 수는 더하고 약수의 개수가 홀수인 수는 뺀 총합을 return
		int left = 13;
		int right = 17;
		int answer = 0;
		for(int i = left; i <= right; i++) {
			int count = 0;
			for(int j = 1; j <= i; j++) {
				if(i%j == 0) {
					count++;
				}
			}
			answer += (count%2 == 0) ? (i) : (i * -1);
		}
		System.out.println(answer);
	}
}
