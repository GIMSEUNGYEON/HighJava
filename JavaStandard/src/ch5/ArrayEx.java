package ch5;

import java.util.Arrays;

public class ArrayEx {
	public static void main(String[] args) {
		ArrayEx ae = new ArrayEx();
		ae.arrayEx01();
	}
	public void arrayEx01() {
		//진짜 맨날 까먹는거
		//어레이 출력하는 법
		int [] arr = new int[] {5,4,3,2,1};
		System.out.println(Arrays.toString(arr));
		
		//오름차순 정렬하는 법
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
