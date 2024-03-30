package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class homework_922 {
	Map<Integer, String> hotel = new HashMap<Integer, String>();
	static Scanner sc = new Scanner(System.in);
	static homework_922 hotelMap = new homework_922();
	public static void main(String[] args) {
		hotelMap.Entrance();
		
		
	}
	public void Entrance() {
		System.out.println("==============================");
		System.out.println("\t호텔 문을 열었습니다.");
		System.out.println("==============================");
		
		while(true) {
		System.out.println("*******************************");
		System.out.println("\t어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인 2.체크아웃 3.객실상태 4.업무종료");
		System.out.println("*******************************");
		
		System.out.print("메뉴 선택 => ");
		int select = sc.nextInt();
		switch (select) {
		case 1: hotelMap.CheckIn(); break;
		case 2: hotelMap.CheckOut(); break;
		case 3: hotelMap.roomState(); break;
		case 4: 
			System.out.println("시스템을 종료합니다.");
			return;
		default:
			System.out.println("잘못된 입력 !!");
			return;
		   }
		}
		
	}
	public void CheckIn(){
		System.out.println("어느 방을 체크인하시겠습니까?");
		System.out.print("방 번호 입력 => ");
		int roomNo = sc.nextInt();
		if(hotel.get(roomNo) != null) {
			System.out.println(roomNo + "호는 이미 체크인 되었습니다.");
			return;
		}
		System.out.print("누구를 체크인 하시겠습니까? =>");
		String name = sc.next();
		hotel.put(roomNo, name);			
		System.out.println("체크인되었습니다.");
	}
	public void CheckOut() {
		System.out.println("어느 방을 체크아웃 하시겠습니까?");
		System.out.print("방 번호 입력 => ");
		int roomNo = sc.nextInt();
		if(hotel.get(roomNo) == null) {
			System.out.println(roomNo + "에는 체크인한 사람이 없습니다.");
			return;
		}
		if(hotel.remove(roomNo) == null) {
			System.out.println("체크아웃 실패 !!");
		}
		System.out.println("체크아웃되었습니다.");
		
	}
	public void roomState() {
		Set<Integer> keySet = hotel.keySet();
		if(keySet.size() == 0) {
			System.out.println("체크인된 호실이 없습니다.");
			return;
		}
		System.out.println("예약된 방 현황");
		for(Integer key : keySet) {
			System.out.println("호실 : " + key + "\t투숙객 : " + hotel.get(key));
		}
	}
}
