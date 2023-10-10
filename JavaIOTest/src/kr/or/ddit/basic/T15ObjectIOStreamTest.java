package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// 객체 입출력 보조 스트림 예제
public class T15ObjectIOStreamTest {
	public static void main(String[] args) {
		// Member 인스턴스 생성하기
		Member mem1 = new Member("홍길동", 20, "대전");
		Member mem2 = new Member("일지매", 30, "부산");
		Member mem3 = new Member("성춘향", 40, "광주");
		Member mem4 = new Member("이몽룡", 40, "인천");

		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(new FileOutputStream("d:/D_Other/memObj.bin"));
			// 쓰기 작업
			oos.writeObject(mem1); // 데이터를 write하는 과정에서 직렬화가 일어남
			oos.writeObject(mem2);
			oos.writeObject(mem3);
			oos.writeObject(mem4);

			System.out.println("쓰기 작업 완료");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/////////////////////////////////////////////////////
		// 저장한 객체를 읽어와 사용하기
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("d:/D_Other/memObj.bin"));
			Object obj = null;
			while ((obj = ois.readObject()) != null) {
				//읽어온 데이터를 원래의 객체형으로 변환 후 사용(역직렬화)
				Member mem = (Member) obj;
				System.out.println("이름 : " + mem.getName());
				System.out.println("나이 : " + mem.getAge());
				System.out.println("주소 : " + mem.getAddr());
				System.out.println("--------------------------------------");
				//원래 아래에서 End Of File 예외가 발생함
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			//Member클래스를 찾을 수 없을 경우에 발생하는 예외
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

//java.io.NotSerializableException 에러 발생 방지 -   implements Serializable
class Member implements Serializable { // 자바는 Serializable 인터페이스를 구현한 클래스만 직렬화할 수 있도록 제한하고 있음.
	// 아무 메서드도 가지지 않고 그저 타입만 부여하는 인터페이스 : 태그 인터페이스라고 부름
	private transient String name;
	// transient : 직렬화가 되지 않을 멤버변수 지정(static 필드도 직렬화 대상이 아니다.) 직렬화가 되지 않는 멤버변수는 기본값으로 저장됨.
	// 														     	       참조변수 : null, 숫자형변수 : 0
	
	private int age;
	private String addr;

	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}