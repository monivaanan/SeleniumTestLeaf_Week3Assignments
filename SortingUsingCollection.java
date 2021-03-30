package AssignmentWeek3;

import java.util.*;


public class SortingUsingCollection {

	/*---Learning---
	 *1. Array length using Length method
	 *2. Convert String array to list <String>
	 *3. Sort array using Collections.sort()
	 *3. Reverse the sorted list using Collections.reverse()
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] input = {"HCL","Wipro","Aspire Systems","CTS"};
		System.out.println("Array Length:\t" +input.length );
		
		List<String> listInput = Arrays.asList(input);
      /*  System.out.println("Convert String array INPUT to List");
        for(String eachInput : listInput){
            System.out.println("I am List Input:\t "+eachInput);
        }*/
        
		Collections.sort(listInput);
		System.out.println("Sorted Array:" +listInput);
		Collections.reverse(listInput);
		System.out.println("Reverse Sorted Array:" +listInput);
		
	

	}

}
