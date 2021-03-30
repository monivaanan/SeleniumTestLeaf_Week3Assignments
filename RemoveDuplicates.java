package AssignmentWeek3;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String test="PayPal India";
		String testW=test.replaceAll(" ", "");
		//System.out.println(testW);
		char[] testCh=testW.toCharArray();
		System.out.println(testCh);
		
		Set<Character> charSet=new HashSet <Character>();
		Set<Character> dupCharSet =new HashSet <Character>();
		
		for(int i=0;i<testCh.length;i++)
		{
			if(!charSet.add(testCh[i]))
			{
				dupCharSet.add(testCh[i]);
				
			}
			charSet.removeAll(dupCharSet);
			
		}
		//System.out.println(charSet);
		
		for (Character c : charSet) 
		{
			if (c!= ' ')
			{
				charSet.toString();
				
			}
			
		}
		
		System.out.println(charSet);
		
	}

}
