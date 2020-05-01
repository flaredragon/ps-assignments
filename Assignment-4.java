package com.Hello;
import java.util.*;


public class World {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Map<String,Set<String>> map = new HashMap<String,Set<String>>();
		 String[] greetings_morning = { "GoodMorning", "Shubhodaya", "Shubhohday", "Bonjour"};
		 String[] greetings_evening = { "good Evening","Shubha sange","susandhya" ,"Bonsoir"};
		 Set<String> temp = new HashSet<String>();
		 Set<String> temp2 = new HashSet<String>();
		 Collections.addAll(temp2, greetings_evening);
		 Collections.addAll(temp, greetings_morning);
		 map.put("GoodMorning",temp);
		 map.put("GoodEvening",temp2);
		 Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		 System.out.println("Enter Greeting");
		 String userName = myObj.nextLine(); 
		 if(map.containsKey(userName)) {
			 System.out.println(map.get(userName));
		 }
		 else if(userName.contentEquals("GoodBye")) {
			 System.out.println("Do you want to enter synonyms (y/n)");
			 String flag =  myObj.nextLine(); 
			 Set<String> set = new HashSet<String>(); ;
			 if(flag.contentEquals("y")) {
				 String x = "";
				 do {
					 x = myObj.nextLine();
					 if(x.length()>0) {
						 set.add(x);
					 }
				 } while(x.length()>0);
			 }
			 map.put(userName, set);
		 }
		 System.out.println(map);
	}
}

