package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 3개(명)의 스레드가 각각 알파벳 대문자를 출력하는데 출력을 끝낸 순서대로 결과를 출력하는 프로그램 작성하기
 각각의 스레드가 출력되는 sleep 시간을 Math 랜덤 메소드를 이용하여 출력 속도에 차이를 줌
 */
public class T11DisplayCharacterTest {
	static int CURR_RANK = 1; //초기 기본 순위는 1등으로 시작
	public static void main(String[] args) {
		List<DisplayCharacter> disCharList = new ArrayList<DisplayCharacter>();
		
		disCharList.add(new DisplayCharacter("1번말"));
		disCharList.add(new DisplayCharacter("2번말"));
		disCharList.add(new DisplayCharacter("3번말"));
		disCharList.add(new DisplayCharacter("4번말"));
		
		for(DisplayCharacter dl : disCharList) {
			dl.start();
		}
		
		for(DisplayCharacter dl : disCharList) {
			try {
				dl.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("경기 끝 !!");
		
		System.out.println("++++++++++++++++");
		System.out.println("  == 경기 결과 ==");
		System.out.println();
		System.out.println("================");
		System.out.println("순위    :   이름");
		Collections.sort(disCharList);
		for(DisplayCharacter dl : disCharList) {
			System.out.println(dl.getRank() + "\t" + dl.getName());
		}
		
	}
}
//알파벳 대문자 출력을 위한 클래스
class DisplayCharacter extends Thread implements Comparable<DisplayCharacter>{
	
	private String name;
	
	private int rank;

	public DisplayCharacter(String name) {
		super(name);
		//스레드가 가지고 있는 파라미터를 이름으로 받음
		//명시적으로 이름을 지정해주면 스레드 이름을 세팅할 수 있음
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public void run() {
		for(char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(name + "의 출력문자 : " + ch);
			try {
				//200 ~ 500 사이의 난수를 발생시켜 sleep
				Thread.sleep((int)Math.random()*301 + 200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + "의 출력 끝!");
		
		setRank(T11DisplayCharacterTest.CURR_RANK++); //순위정보 설정
	}

	@Override
	public int compareTo(DisplayCharacter dc) {
		return new Integer(this.getRank()).compareTo(dc.getRank());
	}
	
}