package com.practice.lambdaExp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LambdaUseCases {
	
	public static void main(String[] args) {
		
		/**
		 * Double braces initialization should be avoided, as what it does 
		 * is that it creates another initializer instance of your class 
		 * and that is used to initialize the values. Not a good approach.
		 * Better to manually add values to the Collection 
		 */
		List<Person> people= new ArrayList<Person>() {{
			add(new Person(12, "Shiv"));
			add(new Person(34, "Papaji"));
		}};
		
		people= new ArrayList<Person>();
		people.add(new Person(12, "Shiv"));
		people.add(new Person(34, "Papaji"));
		people.add(new Person(32, "Mummy"));
		people.add(new Person(19, "Anush"));
		people.add(new Person(15, "Rachit"));
		people.add(new Person(70, "Dadiji"));
		people.add(new Person(10, "Golu"));
		
		/**
		 * Prior to Java 7 way
		 */
		/**
		 * To use this way our child should implement Comparable<T> 
		 * and define it's method compareTo(T)
		 */
		//Collections.sort(people); 
		
		/**
		 * If class doesn't implements Comparable<T>
		 */
		Collections.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getName().compareTo(o2.getName()); //As Person is also implementing Comparable, it too could be used directly
			}
			
		});
		
		performNonReturnOperationOnPeople(people, 
				   predicate -> true,
				   (person) -> System.out.print("{"+ person.toString()+ "}"));
		
		/**
		 * Java 8 way
		 */
		Collections.sort(people, (p1, p2) -> Integer.valueOf(p1.getAge()).compareTo(Integer.valueOf(p2.getAge())));
		
		System.out.print("\nSorted on basis of age:\n");
		performNonReturnOperationOnPeople(people, 
				   predicate -> true, 
				   (person) -> System.out.print("("+ person.toString()+ ")"));
		
		System.out.print("\nPeople between age 18- 65: \n");
		performNonReturnOperationOnPeople(people, 
				   person -> (person.getAge()<= 65 && person.getAge()>= 18)? true: false, 
				   (person) -> System.out.print("["+ person.toString()+ "]"));

		
	}
	
	private static void performNonReturnOperationOnPeople(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		
		people.stream()
		      .filter(predicate)
		      .forEach(consumer);
	}

}
