package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class homework_1011 {
	public static void main(String[] args) {
		// map을 이용하여 전화번호부 정보를 저장하고 파일에 저장 한 후 출력하는 프로그램 작성
		PhoneBookTest pbt = new PhoneBookTest();

		pbt.start();

	}
}

class PhoneBookTest {
	static UtilTest1 ut = new UtilTest1();

	static Scanner sc = new Scanner(System.in);
	Map<String, String> phoneBook = new HashMap<String, String>();

	ObjectOutputStream oos = null;

	ObjectInputStream ois = null;

	public void start() {

		if (new File(ut.util().getProperty("FileName")).exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(ut.util().getProperty("FileName")));

				Object obj = null;
				while ((obj = ois.readObject()) != null) {
					phoneBook = (Map<String, String>) obj;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		while (true) {
			System.out.println("###############################");
			System.out.println("\t     업무 선택");
			System.out.println("1.회원 등록 \n2.회원 수정\n3.회원 삭제\n4.회원 정보 조회\n5.종료");
			System.out.println("###############################");

			System.out.print("선택 => ");
			String select = sc.nextLine();

			switch (select) {
			case "1" : insert();		 	break;
			case "2" : update(); 			break;
			case "3" : delete(); 			break;
			case "4" : display();			break;
			case "5" : closePhoneBook();	break;
			default:
				System.out.println("잘못된 입력 !");
				continue;
			}

		}
	}

	public void insert() {
		String pNum = "";
		boolean test = false;
		do {
			System.out.print("회원 이름 입력 >> ");
			String name = sc.next();
			test = check(name);
			if (test) {
				System.out.println("이미 등록된 이름입니다. 다시 입력해주세요");
			} else {
				System.out.print("전화번호 입력 >> ");
				pNum = sc.next();
				phoneBook.put(name, pNum);
				System.out.println("등록되었습니다.");
			}
		} while (test);

	}

	public void update() {
		String pNum = "";
		boolean test = false;
		do {
			System.out.print("수정할 회원 이름 입력 >> ");
			String name = sc.next();
			test = check(name);
			if (!test) {
				System.out.println("등록되지 않은 이름입니다. 다시 입력해주세요.");
			} else {
				System.out.print("새로운 전화번호 입력 >>");
				pNum = sc.next();
				phoneBook.put(name, pNum);
				System.out.println("수정되었습니다.");
			}
		} while (!test);
	}

	public void delete() {
		String pNum = "";
		boolean test = false;
		do {
			System.out.print("삭제할 회원 이름 입력 >> ");
			String name = sc.next();
			test = check(name);
			if (!test) {
				System.out.println("등록되지 않은 이름입니다. 다시 입력해주세요.");
			} else {
				phoneBook.remove(name);
				System.out.println("삭제되었습니다.");
			}
		} while (!test);

	}

	public void display() {
		Set<String> keySet = phoneBook.keySet();
		if (keySet.size() == 0) {
			System.out.println("등록된 전화번호가 없습니다.");
		} else {
			System.out.println("이름\t\t전화번호");
			for (String key : keySet) {
				System.out.println(key + "\t\t" + phoneBook.get(key));
			}
		}
	}

	private void closePhoneBook() {
		try {
			System.out.println("종료 중...");
			oos = new ObjectOutputStream(new FileOutputStream(ut.util().getProperty("FileName")));
			oos.writeObject(phoneBook);
			oos.writeObject(null);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				System.out.println("종료되었습니다.");
				System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean check(String name) {
		if (phoneBook.get(name) != null) {
			return true;
		} else {
			return false;
		}
	}
}

class UtilTest1 {
	Properties prop;

	public Properties util() {

		prop = new Properties();
		try {
			prop.load(new FileInputStream("res/FileName.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return prop;
	}
}
