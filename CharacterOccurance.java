package AssignmentWeek3;

import java.util.HashMap;
import java.util.Map;

public class CharacterOccurance {

	/*Learning Map declaration , how to get values from app , how to add values to map, containsKey()*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String given="welcome to Selenium automation";
		char[] givenChar=given.toCharArray();
		
		Map<Character,Integer> findOcc=new HashMap<Character,Integer>();
		for(int i=0;i<givenChar.length;i++)
		{
			if(findOcc.containsKey(givenChar[i])) 
			{
				findOcc.put(givenChar[i],findOcc.get(givenChar[i])+1);
				
			}
			
			else {
				
				findOcc.put(givenChar[i], 1);
			}
		}
		
		System.out.println(findOcc);
		
	}

}
