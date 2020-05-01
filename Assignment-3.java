package com.Hello;
import java.util.HashMap; 
import java.util.Map; 
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Scanner;

public class World {
	
	public static Map<String, String> sieveOfEratosthenes(int n) {
	    boolean prime[] = new boolean[n + 1];
	    Arrays.fill(prime, true);
	    for (int p = 2; p * p <= n; p++) {
	        if (prime[p]) {
	            for (int i = p * 2; i <= n; i += p) {
	                prime[i] = false;
	            }
	        }
	    }
	    int k=66;
	    HashMap<String, String> primeNumbers = new HashMap<>(); 
	    primeNumbers.put("A","1");
	    for (int i = 2; i <= n; i++) {
	        if (prime[i]) {
	        	String x = Character.toString((char)k);
	        	primeNumbers.put(x, Integer.toHexString(i));
	        	k++;
	        }
	    }
	    return primeNumbers;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Map<String,String> map = sieveOfEratosthenes(150);
		 Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		 System.out.println("Enter name");

		 String userName = myObj.nextLine(); 
		 String ans = "";
		 for(int i=0;i<userName.length();i++) {
			 String t = Character.toString(userName.charAt(i));
			if(map.containsKey(t)) {
				String a = map.get(t);
				ans+=a;
			}
		 }
		 System.out.println(ans);
	}
}

