package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*부모클래스가 Serializable 인터페이스를 구현하고 있지 않을 경우
    부모객체의 필드값 처리 방법
   1. 부모클래스가 Serializable 인터페이스를 구현하도록 해야한다.
   2. 자식 클래스가 writeObject()와 readObject()메서드를 이용하여 부모객체의 필드값을 처리할 수 있도록 직접 구현한다.
*/
public class T16NonSerializableParentTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		ObjectInputStream 
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/D_Other/nonSerializable.bin"));
		
		Child child = new Child();
		child.setParentName("부모");
		child.setChildName("자식");
		
		oos.writeObject(child);
		
		oos.close();
		
		//////////////////////////////////////////////////////////////////////////////////////
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/D_Other/nonSerializable.bin"));
		
		Child child2 = (Child) ois.readObject(); //역직렬화
		
		System.out.println("parentName : " + child2.getParentName());
		System.out.println("childName : " + child2.getChildName());
		
		ois.close();
	}
}


// Serializable을 구현하지 않은 부모 클래스
class Parent {
	private String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}

//Serializable을 구현한 자식 클래스

class Child extends Parent implements Serializable {
	private String childName;

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}
	//만약 자식이 serializable하지 않고 부모가 가지고 있다면 자식도 구현한 것으로 본다. 하지만 부모가 구현하지 않은 것을 자식이 구현하면 자식이 가진 멤버변수만 구현한 것이 된다.
	
	private void writeObject(ObjectOutputStream out) throws IOException {
	//직렬화될 때 자동으로 호출됨. (접근 제한자가 private가 아니면 자동 호출되지 않는다.
		out.writeUTF(getParentName());
		out.defaultWriteObject();
		//객체 직렬화 과정에서 직렬화 대상이 아닌 객체들을 수동으로 직렬화시켜주는 과정.
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
	//역직렬화될 때 자동으로 호출됨. (접근 제한자가 private가 아니면 자동 호출되지 않는다.)	
		setParentName(in.readUTF());
		in.defaultReadObject();
	}
}