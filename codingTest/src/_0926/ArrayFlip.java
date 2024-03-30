package _0926;

public class ArrayFlip {
	public static void main(String[] args) {
		int [] num_list = {1,2,3,4,5};
		int [] answer = new  int[num_list.length];
		
		int index = 0;
		for(int i = num_list.length-1; i>=0; i--) {
			answer[index] = num_list[i];
			index++;
		}
		for(int i : answer)
			System.out.println(i);
	}

}

