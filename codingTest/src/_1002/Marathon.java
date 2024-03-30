package _1002;

import java.util.ArrayList;
import java.util.HashMap;

public class Marathon {
	public static void main(String[] args) {
		String [] participant = {"mislav", "stanko", "mislav", "ana"};
		String [] completion = {"stanko", "ana", "mislav"};
		String answer = "";
		
		 HashMap<String,ArrayList<Integer>> player = new HashMap<>();

	        //↓ computeIfAbsent 이용해서 해당 키의 값이 있으면 그 리스트에 i값을 추가하고 없으면 새로운 리스트 생성후 i값추가
	        for (int i = 0; i < participant.length; i++) {
	            player.computeIfAbsent (participant[i],k-> new ArrayList<>()).add(i);
	        }
	        System.out.println(player);
	        //↓등수랑 상관없는 문제라 리스트 길이가 2이상이면 해당 키의 리스트 0번째 요소 삭제하고 2미만이면 player맵의 키,값 자체 삭제
	        for (String call : completion) {
	            if(player.get(call).size()<2){
	                player.remove(call);
	            } 
	            else{
	                player.get(call).remove(0);
	            }  
	        }
	        //↓ player맵의 요소 딱한개 남아서 keySet()이용
	        for (String key : player.keySet()) {
	            answer=key;
	        }
	        System.out.println(answer);
	}
}
