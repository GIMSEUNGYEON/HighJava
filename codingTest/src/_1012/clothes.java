package _1012;

import java.util.HashMap;
import java.util.Map;

public class clothes {
	public static void main(String[] args) {
		Map<String, Integer> type = new HashMap<String, Integer>();

		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };

		for (int i = 0; i < clothes.length; i++) {
			if (!type.containsKey(clothes[i][1])) {
				type.put(clothes[i][1], 1);
			} else {
				type.put(clothes[i][1], type.get(clothes[i][1])+1);
			}
		}
		
		System.out.println(type.get("headgear"));
		System.out.println(type);
		
		int answer = 1;
		
		
		for(String s : type.keySet()) {
			answer*=type.get(s) + 1;
			System.out.println(answer);
		}
		
		answer-=1;
		System.out.println(answer);
		
	}
}
