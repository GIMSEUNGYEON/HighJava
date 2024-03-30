package _1012;

import java.util.HashMap;
import java.util.Map;

public class Ponkemon {
	public static void main(String[] args) {
		Map<Integer, Integer> tmp = new HashMap<Integer, Integer>();
		int[] nums = {3,3,3,2,2,2 };

		for (int i = 0; i < nums.length; i++) {
			if (!tmp.containsKey(nums[i])) {
				tmp.put(nums[i], 1);
			} else {
				tmp.put(nums[i], tmp.get(nums[i])+1);
			}
		}
		System.out.println(tmp);
		System.out.println(tmp.get(2));
		int answer = tmp.size() > nums.length/2 ? nums.length/2 : tmp.size();
		//전체 포켓몬 수의 반만 가져갈 수 있고, (수는 항상 짝수) 수의 절반보다 가져갈 수 있는 경우의 수가 더 많은 경우
		//절반을 가져오는 것이 전체 경우의 수가 되며, 경우의 수가 더 적다면 그 적은 경우의 수가 전체 경우의 수가 된다.
		System.out.println(answer);
	}
}
