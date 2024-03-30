package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class homework_1002 {
	public static void main(String[] args) {
		// 스레드를 이용한 경마프로그램
		List<Horse> race = new ArrayList<Horse>();
		
		for(int i = 0; i < 10; i++) race.add(new Horse((i+1) + "번말"));
		
		for(Horse h : race) {
			h.start();
		}
		//모든 스레드를 동시에 스타트
		
		while(true) { //반복문을 이용해서 열개의 스레드를 한 화면에 표시함
			System.out.println("=========================================================");
			for(int i = 0; i < race.size(); i++) {
				System.out.print(race.get(i).getName() + " : ");
				for(int j = 1; j <= 50; j++) {
					if(race.get(i).getPlace() == j) {
						System.out.print(">");
						continue;
					}
					System.out.print("-");
				}
				System.out.println();
			}//여기까지 각 1번말, 2번말, 한줄 한줄을 표현함
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			int exitNo = 0;
			for(int i = 0; i < race.size(); i++) {
				if(race.get(i).getState() == Thread.State.TERMINATED) {
					exitNo++;
					//스레드가 하나씩 끝날 때마다 인식하는 임시 숫자 지정 
				}
			}
			if(exitNo == 10) {
				//스레드가 10개 끝나면 반복문 탈출
				break;
			}
			System.out.println("=========================================================");
		}
		System.out.println();
		System.out.println("==경기결과==");
		Collections.sort(race);
		for(Horse h : race) {
			System.out.println(h);
		}
	}
}

//달리기만 하고 출력은 없는 스레드 클래스

class Horse extends Thread implements Comparable<Horse> {
	public static int setRank = 1;
	//모든 순위가 1로 시작해서 하나의 스레드가 끝날 때마다 순위를 늘려감
	private String name;
	private int rank;
	private int place = 1;
	
	public Horse(String name) {
		super(name);
		//getName하면 설정한 이름이 출력되도록
		this.name = name;
		//현재 클래스에서 name이라고 부르면 지정한 이름이 불려지도록
	}
	@Override
	public void run() {
		for(int i = 0; i < 50; i++) {
			try {
				Thread.sleep((int)(Math.random()*500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(getPlace() < 50) {
				setPlace(getPlace() + 1);
			}
		}
		rank = setRank++;
		System.out.println(name + " " + rank + "순위로  완주 !!");
	}

	@Override
	public int compareTo(Horse h) {
		return Integer.compare(rank, h.rank);
	}
	@Override
	public String toString() {
		return rank + "위 : " + name;
	}
	public int getPlace() {
		return place;
	}
	public void setPlace(int place) {
		this.place = place;
	}
	
}
