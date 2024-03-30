package _1030;

public class Carpet {
	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;
		int [] answer = new int [2];
		
		//갈색은 4 + 4 + (3-2) + (3-2)이다
		//방정식 푸는거같네...
		//노란색은 4*3 - 갈색이다
		
		//헷갈리니까 (x, y)로 놓고  answer에 대입하는게 낫겠다
		
		int x = 0;
		int y = 0;
		
		if(x*x - (brown + yellow) * x + (brown * yellow) == 0) {
			
		}
		
	}
}	
