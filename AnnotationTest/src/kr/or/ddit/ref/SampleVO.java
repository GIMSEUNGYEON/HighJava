package kr.or.ddit.ref;

public class SampleVO implements Runnable {
	
	public String id;
	protected String name;
	private int age;
	
	@Override
	public void run() {
		
	}
	
	public SampleVO(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "SampleVO [id=" + id + ", name=" + name + ", age=" + age + "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	@Deprecated
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


	public SampleVO() {
		
	}
}
