package _1002;

public class trsjxk {
	public static void main(String[] args) {
		long n = 12345l;
		String sArray = String.valueOf(n);
		System.out.println(sArray);
		int [] answer = new int [sArray.length()];
		
		int index = 0;
		for(int i = sArray.length()-1; i>=0; i--) {
			answer[index] = sArray.charAt(i) - '0';
			index++;
		}

	}
	public void anotherMethod(){
		long n = 12345l;
		 String s = String.valueOf(n);
	      StringBuilder sb = new StringBuilder(s);
	      sb = sb.reverse();
	      String[] ss = sb.toString().split("");

	      int[] answer = new int[ss.length];
	      for (int i=0; i<ss.length; i++) {
	          answer[i] = Integer.parseInt(ss[i]);
	      }
	}
}
