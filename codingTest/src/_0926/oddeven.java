package _0926;

public class oddeven {
	public static void main(String[] args) {
		oddeven oe = new oddeven();
		
		oe.iLikeOdd();
	}
	
public void countOddEven() {
	
	int[] num_list = {1,2,3,4,5};
	
	int odd  = 0;
	int even = 0;
	for(int i : num_list) {
		if(i%2 == 0) {
			even++;
		}else{
			odd++;
		}
	}
	System.out.println("짝 : " + even + " 홀 : " + odd );
	
}

public void iLikeOdd() {
		int n = 15;
		int length = (n%2==0) ? n/2 : n/2+1;
		int [] answer = new int[length];
		int index = 1;
		answer[0] = 1;
		for(int i = 3; i <= n; i++) {
			if(i%2 != 0) {
				answer[index] = i;
				index++;
			}
		}
		for(int i : answer) {
			System.out.println(i);
		}
	}
}
