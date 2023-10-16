package HotelHDBCTest;

import java.util.List;
import java.util.Scanner;


public class HotelController {
	HotelDao hd = new HotelDao();
	Scanner sc;

	public static void main(String[] args) {
		HotelController hc = new HotelController();
		hc.entrance();
	}

	public void entrance() {

		sc = new Scanner(System.in);

		int select = 1000;
		System.out.println("================================");
		System.out.println("\t호텔 문을 열었습니다.");
		System.out.println("================================");
		do {
			System.out.println("*******************************");
			System.out.println("\t어떤 업무를 하시겠습니까?");
			System.out.println("1. 체크인  2. 체크아웃  3. 객실상태  0. 업무종료");
			System.out.println("*******************************");
			System.out.println("선택  => ");
			select = sc.nextInt();
			
			switch (select) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				displayAll();
				break;
			case 0:
				System.out.println("문을 닫았습니다.");
				System.exit(0);
				break;
			default:
				System.out.println("잘못된 입력!!!!!!!!!!!!!!!!!!");
				continue;
			}
		} while (select != 0);
	}

	private void checkIn() {
		System.out.println("어느 방을 체크인 하시겠습니까?");
		System.out.println("방 번호 입력 >>");
		int roomNo = sc.nextInt();

		if (hd.checkRoom(roomNo)) {
			System.out.println(roomNo + "호는 이미 체크인 되었습니다.");
			return;
		}
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.println("이름 입력 >>");
		
		String name = sc.next();
		HotelVO hv = new HotelVO();
		hv.setRoomNo(roomNo);
		hv.setName(name);
		if(hd.checkIn(hv) > 0) {
			System.out.println("체크인되었습니다.");
		}else {
			System.out.println("체크인실패");			
		}
		
	}

	private void checkOut() {
		System.out.println("어느 방을 체크아웃 하시겠습니까?");
		System.out.print("방 번호 입력 => ");
		int roomNo = sc.nextInt();
		
		if(!hd.checkRoom(roomNo)) {
			System.out.println(roomNo + "호에는 체크인한 사람이 없습니다.");
			return;
		}
		
		if(hd.checkOut(roomNo) > 0 ) {
			System.out.println("체크아웃되었습니다.");
		}else {
			System.out.println("체크아웃실패");			
		}
	}

	private void displayAll() {
	
		if(hd.displayRoom().size() == 0) {
			System.out.println("체크인된 호실이 없습니다.");
		}else {
			
		
		System.out.println("\n----------------------------------------------------");
		System.out.println("  호실\t투숙객");
		System.out.println("----------------------------------------------------");
		
		List<HotelVO> roomList = hd.displayRoom();
		
		for(HotelVO hv : roomList) {
			System.out.println(" " + hv.getRoomNo() + "\t" + hv.getName());
		}
		
		System.out.println("----------------------------------------------------");
	
		System.out.println("출력 완료");
		}
	
	}
}
