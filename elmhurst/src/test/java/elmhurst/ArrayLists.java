package elmhurst;

import java.util.ArrayList;

public class ArrayLists {

	public static void main(String[] args) {
		
	ArrayList <String> countries= new ArrayList<String>();
	
	countries.add("Bangladesh");
	countries.add("Unites States of America");
	countries.add("Australia");
	
	System.out.println("My Beloved Nation:"+countries.get(2));
	
	System.out.println(countries.size());
	
	for(String i: countries) {
		System.out.println(i);
	}
	
	//Advance For Loop
	for(String cricket: countries){
	System.out.println("Addvance countries:"+cricket);
	}
	
	for(int i=0; i<countries.size();i++) {
		System.out.println("All Nations:"+countries.get(i));
//		System.out.println(countries.size());
	}
	
	}

}
