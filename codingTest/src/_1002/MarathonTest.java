package _1002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MarathonTest {
	public static void main(String[] args) {
		
	String [] participant = {"mislav", "stanko", "mislav", "ana"};
	String [] completion = {"stanko", "ana", "mislav"};
	String answer = "";

//	HashMap<String, Integer> test = new HashMap<String, Integer>();
//	
//	for(int i  = 0; i < participant.length; i++) {
//		test.put(participant[i], i);
//	}
//	System.out.println(test);
//	
	
//	List<String> partList = new ArrayList<String>(Arrays.asList(participant));
//	List<String> compList = new ArrayList<String>(Arrays.asList(completion));
	
//	partList.removeAll(compList);
//	System.out.println(partList);
	
	String [] part = {"mislav", "stanko", "mislav", "ana"};
	String [] comp = {"stanko", "ana", "mislav"};
	
	Arrays.sort(part);
	Arrays.sort(comp);
	
	for(int i=0; i<part.length; i++) {
		
		if(!part[i].equals(comp[i])) {
			System.out.println(part[i]);
			break;
		}
	}
	
	
	}
	
	
}	
