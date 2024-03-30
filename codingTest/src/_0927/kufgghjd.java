package _0927;

public class kufgghjd {
	public static void main(String[] args) {
		int price = 3;
		int money = 35;
		int count = 4;
		int result = 0;
	
		for(int i = 1; i <= count; i++) {
			result+=price*i;
		}
		if(result<money) {
			result = 0;
		}else {
			result-=money;			
		}
		System.out.println(result);
	}
}
