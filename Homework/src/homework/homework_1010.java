package homework;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class homework_1010 {
	public static void main(String[] args) throws EOFException, FileNotFoundException {
		HotelTest ht = new HotelTest();

		ht.Entrance();
		/*
		 * 호텔 운영을 관리하는 프로그램 작성(Map) 이용, 키는 방 번호 단, 종료시 파일로 저장하고 프로그램 실행시 파일로부터 데이터를 불러올
		 * 수 있도록 처리한다.
		 */

	}
}

class HotelTest implements Serializable {
	static Scanner sc = new Scanner(System.in);
	Map<Integer, String> hotel = new HashMap<Integer, String>();

	ObjectOutputStream oos = null;

	ObjectInputStream ois = null;

	public void Entrance() {
		System.out.println("================================");
		System.out.println("\t호텔 문을 열었습니다.");
		System.out.println("================================");
		
		if(new File("d:/D_Other/hotel_homework.txt").exists()) {
		try {
			ois = new ObjectInputStream(new FileInputStream("d:/D_Other/hotel_homework.txt"));
			Object obj = null;
			while ((obj = ois.readObject()) != null) {
				hotel = (Map<Integer, String>) obj;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		while (true) {
			System.out.println("*******************************");
			System.out.println("\t어떤 업무를 하시겠습니까?");
			System.out.println("1. 체크인 2. 체크아웃 3. 객실상태 4. 업무종료");
			System.out.println("*******************************");
			System.out.println("선택  => ");
			int select = sc.nextInt();
			switch (select) {
			case 1 : checkIn(); 	break;
			case 2 : checkOut();	break;
			case 3 : roomState();	break;
			case 4 : close();		break;
			default:
				System.out.println("잘못된 입력!");
				continue;
			}
		}
	}

	public void checkIn() {
		System.out.println("어느 방을 체크인 하시겠습니까?");
		System.out.println("방 번호 입력 >>");
		int roomNo = sc.nextInt();
		if (hotel.get(roomNo) != null) {
			System.out.println(roomNo + "호는 이미 체크인 되었습니다.");
			return;
		}
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.println("이름 입력 >>");
		String name = sc.next();
		hotel.put(roomNo, name);
		System.out.println("체크인되었습니다.");
	}

	public void checkOut() {
		System.out.println("어느 방을 체크아웃 하시겠습니까?");
		System.out.print("방 번호 입력 => ");
		int roomNo = sc.nextInt();
		if (hotel.get(roomNo) == null) {
			System.out.println(roomNo + "에는 체크인한 사람이 없습니다.");
			return;
		}
		if (hotel.remove(roomNo) == null) {
			System.out.println("체크아웃 실패 !!");
		}
		System.out.println("체크아웃되었습니다.");
	}

	public void roomState() {
		Set<Integer> keySet = hotel.keySet();
		if (keySet.size() == 0) {
			System.out.println("체크인된 호실이 없습니다.");
			return;
		}
		System.out.println("예약된 방 현황");

		for (Integer key : keySet) {
			System.out.println("호실 : " + key + "\t투숙객 : " + hotel.get(key));
		}

	}

	public void close() {
		try {
			oos = new ObjectOutputStream(new FileOutputStream("d:/D_Other/hotel_homework.txt"));
			oos.writeObject(hotel);
			oos.writeObject(null);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				System.out.println("시스템 종료...");
				System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
