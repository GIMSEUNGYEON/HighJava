package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class homework_920 {
	public static void main(String[] args) {
		List<Student> stuList = new ArrayList<Student>();
		stuList.add(new Student("4", "홍길동", 78, 65, 73));
		stuList.add(new Student("2", "이몽룡", 64, 78, 86));
		stuList.add(new Student("5", "성춘향", 80, 79, 87));
		stuList.add(new Student("6", "이방원", 94, 88, 85));
		stuList.add(new Student("1", "이성계", 78, 58, 89));
		stuList.add(new Student("3", "정도전", 94, 86, 87));
		
		for(Student stu : stuList) {
			int rank = 1;
			for(Student stu2 : stuList) {
				if(stu.getSum() < stu2.getSum()) rank++;
			}
			stu.setRank(rank);
			
		}
		
		System.out.println("정렬 전 ");
		for (Student stu : stuList) System.out.println(stu);

		Collections.sort(stuList); 
		//Student 클래스 내에서  compareTo 메소드를 재정의하였으므로 
		//그 자체적인 방법대로(stuList 객체가 Student클래스이므로 Student 클래스이 방법을 따름) 재정의한 방식대로 리스트를 정렬해준다. 
		
		System.out.println("==========================================================="
				+ "==========================");
		System.out.println("학번의 오름차순 정렬");
		for (Student stu : stuList)	System.out.println(stu);
		Collections.shuffle(stuList);
		System.out.println("==========================================================="
				+ "==========================");

		
		Collections.sort(stuList, new SortScore());
		//정렬 방식을 새로 정의해준 SortScore 클래스에서 comparator의 compare 메소드를 재정의한 방식대로 stuList를 재정렬해준다.
		System.out.println("총점의 내림차순 정렬");
		for (Student stu : stuList) System.out.println(stu);
		System.out.println("==========================================================="
				+ "==========================");
		
		if(stuList.contains("이")) {
			for(Student stu : stuList) System.out.println(stu);
		}
	}
}

class SortScore implements Comparator<Student> {
	@Override
	public int compare(Student stu1, Student stu2) {
		if (stu1.getSum() > stu2.getSum()) {
			return -1;
		} else if (stu1.getSum() < stu2.getSum()) {
			return 1;
		} else {
			if(Integer.parseInt(stu1.getStuNo()) < Integer.parseInt(stu2.getStuNo())) {
				return 1;
				//혹은 return stu.getStuNo().compareTo(stu2.getStuNo()) * -1;
			}
			return -1;
		}

	}

}

class Student implements Comparable<Student> {
	private String stuNo;
	private String name;
	private int kor;
	private int math;
	private int eng;
	private int sum;
	private int rank;

	@Override
	public String toString() {
		return "Student [학번 = " + stuNo + ", 이름 = " + name + ", 국어점수 = " + kor + ", 수학점수 = " + math + ", 영어점수 = " + eng
				+ ", 총점 = " + sum + ", 등수 = " + rank + "]";
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getSum() {
		return sum;
	}
//	public void getRank(int rank) {
//		this.rank = rank;
//	}
	
	public void setRank(int rank) {
		this.rank =  rank;
	}

	public Student(String stuNo, String name, int kor, int math, int eng) {
		super();
		this.stuNo = stuNo;
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		this.sum = kor + eng + math;
		
	}
	@Override
	public int compareTo(Student stuNo) {
		// TODO Auto-generated method stub
		return Integer.parseInt(this.stuNo) - Integer.parseInt(stuNo.getStuNo());
	}

}
