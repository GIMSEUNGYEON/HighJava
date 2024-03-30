package _1004;

public class scalarTest {
	public static void main(String[] args) {
		// 내적 길이가 같은 두 배열의.... 같은 자리에 있는걸...곱해서...더하기
		int[] a = { 1, 2, 3, 4 };
		int[] b = { -3, -1, 0, 2 };
		int answer = 0;
		for(int i = 0; i < a.length; i++) {
			answer += a[i]*b[i];
		}
		System.out.println(answer);
	}
}
