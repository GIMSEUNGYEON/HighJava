package _1005;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ngfd {
	public static void main(String[] args) {
		int n = 10;
		int m = 25;
		//최대 공약수는 5, 최소공배수는 50
		int min = Math.min(n, m);
		List<Integer> mini = new ArrayList<Integer>();
		for(int i = 1; i <= min; i++) {
				if(n%i == 0 && m%i == 0) {
					mini.add(i);
			}
		}
		Collections.sort(mini, Collections.reverseOrder());
		
		int maxx = n*m/mini.get(0);
		
	}
}
