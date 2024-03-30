
public class Coke {
	public static void main(String[] args) {
		int a = 2;
		int b = 1;
		int n = 20;
		//빈병 n개를 가져다 주면 a개당 콜라 b를 줍니다. b를 모두 마시고 다시 가져다주면 a개당 b를... 시작
		int count = 0;
		while(n >= a) {
			int coke = 0;
			coke+=(n/a)*b;
			count+=coke;
//			System.out.println("받은 콜라 : " + coke);
			n %= a;
//			System.out.println("남은 콜라병 : " + n);
			n += coke;
//			System.out.println("다 마시고 남은 콜라병 : " + n);
//			count++;
//			return;
		}
		System.out.println(count);
		
		int answer = (n > b ? n - b : 0) / (a - b) * b;
		
		System.out.println("answer : " + answer);
	}
}
