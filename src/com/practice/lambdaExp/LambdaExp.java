package com.practice.lambdaExp;

import java.util.Arrays;
import java.util.function.Predicate;

public class LambdaExp {
	
	public static void main(String args[]) {
		
		final int a= 5, b= 6;
		
		InterfaceForLambdaExp interfaceForMult= (v1, v2) ->  v1* v2;
		
		System.out.print(interfaceForMult.performOperation(a, b));
		
		String stringArray[]= {"Harshit", "Rachit", "Mummy", "Pops", "Golu"};
		
		// similar to declaring anonymous inner class, this behaviour passes as parameter to Predicate.test()
		Predicate<String> predicate= (val) -> val.contains("a");
		Arrays.asList(stringArray).stream()
		                          .filter(predicate)
		                          .forEach(val -> System.out.print("\nString qualifying with I predicate: "+ val));
		
		//Predicate<String> predicate2= val -> val.contains("o");
		Predicate<String> predicate2= new Predicate<String>() {
			public boolean result(String str) {
				return true;
			}

			// This is equivalent of making lambda expression
			@Override
			public boolean test(String t) {
				if(t.contains("o"))
					return true;
				
				return false;
			}
		};
		Arrays.asList(stringArray).stream()
		                          .filter(predicate2)
		                          .forEach(val -> System.out.printf("\nStrings qualifying with II predicate: "+ val));
		
		/**
		 * All referring to same location, as JVM optimises strings in string pool
		 * This is done as String are quiet commonly used and this optimization 
		 * saves memory space
		 */
		String s1= "Hi", s2= "Hi", s3= "H"+ "i"; 
		String s4= new String("Hi");  //Now a new memory would be allocated.
		
		
		System.out.print((s1== s3)? "\ns1 and s2 are equal, referring to same memory in String pool ": "\ns1 and s2 are different, referring to different memory in String pool ");		
		
	}

}
