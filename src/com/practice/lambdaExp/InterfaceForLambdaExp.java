package com.practice.lambdaExp;

@FunctionalInterface 
public interface InterfaceForLambdaExp {  // FuncitonalInterface -> Interface with only 1 method, could contain more methods too but must be static
	
	public int performOperation(int a, int b);
	
	static public void printResult(int a) {
		System.out.print("Value of parameter: "+ a);
	}

}
