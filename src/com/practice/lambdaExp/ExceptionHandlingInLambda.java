package com.practice.lambdaExp;

import java.util.Arrays;
import java.util.function.BiConsumer;

public class ExceptionHandlingInLambda {

	public static void main(String args[]) {
		
		int[] arr= {2, 3, 4, 5};
		int key= 5;
		
		performOperation(arr, key, (Integer v1, Integer v2) -> {
			try {
				System.out.print((v1* v2)+ " ");
			}catch(ArithmeticException e) {
				System.out.print(e.toString());
			}
		});
		
		String str= " 675, 56, 908  , 45 ";
		arr= Arrays.asList(str.split(",")).stream()
				                          .mapToInt( val -> Integer.parseInt(val.trim()))
				                          .toArray();
		
		Arrays.stream(arr).forEach(System.out:: println);
			
	}
	
	private static void performOperation(int[] a, int key, BiConsumer<Integer, Integer> consumer) {
		
		Arrays.stream(a)
		      .forEach(val -> consumer.accept(val, key));
	}
	
}