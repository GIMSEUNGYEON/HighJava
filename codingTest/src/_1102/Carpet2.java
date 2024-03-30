package _1102;

public class Carpet2 {
	public static void main(String[] args) {
		// 테두리를 두른 갈색 격자와 안쪽을 가득 채운 노란색 격자의 개수를 알고 있을 때
		// 전체 도형의 가로길이(x), 세로길이(y)를 맞추기
		// 가로길이는 세로길이보다 같거나 크다.
		int brown = 10;
		int yellow = 2;
		// 정답은 i가 4, y가 3일때
		int size = brown + yellow;
		// 노란색의 가로길이는 yellow_row라고 했을 때 x보다 2작다.
		// 노란색의 세로길이를 yellow_column라고 했을 때 y보다 2 작다.
		// 전체 사이즈 크기에서 점점 작아지며 답을 찾는게 1부터 시작하는것보다 빠름
		// x 크기로 반복문을 돌며 진짜 x 크기를 찾기
		int[] answer = new int[2];

		for (int i = size - 1; 0 < i; i--) {
			if (size % i != 0)
				continue;
			System.out.println("i : " + i);
			int y = size / i; // 세로 길이
			System.out.println("y : " + y);
			int ySize = (i - 2) * (y - 2); // 노란색의 면적
			int bSize = size - ySize; // 갈색의 면적

			System.out.println("ySize : " + ySize);
			System.out.println();

			if (ySize == yellow && bSize == brown) {
				answer[0] = i;
				answer[1] = y;
				break;
			}
		}

		System.out.println("가로길이  = " + answer[0]);
		System.out.println("세로길이  = " + answer[1]);
		
	
	}

	public int[] anotherWay(int brown, int yellow) {
		int a = (brown + 4) / 2; // 전체 카펫의 가로길이 + 세로길이
		int b = yellow + brown; // 전체 카펫의 크기 
		int[] answer = new int[2];
		answer[0] = (int) (a + Math.sqrt(a * a - 4 * b)) / 2; // 가로 길이
		answer[1] = (int) (a - Math.sqrt(a * a - 4 * b)) / 2; // 세로 길이
		return answer;
	}
}
