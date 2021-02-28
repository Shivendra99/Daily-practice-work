package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ForEachExp {

	static int staticNo= 56;
	
	public static void main(String args[]) {

		Map<Integer, Integer> map= new HashMap<Integer, Integer>();
		List<Integer> list= new ArrayList<Integer>();
		list.add(3);
		list.add(4);
		list.add(5);

		Integer i= 0;

		for(Integer gi: list) { // gi should be declared here only
			if(gi== i)
				list.remove(0);
			System.out.print("");
		}

		int arr[]= {12,34,11,43};
		int ab[]= arr;
		arr[3]= 566;
		
		staticNo++;
		
		System.out.print("\nArray used in forEach loop: ");
		Arrays.stream(arr).forEach(v -> System.out.print(v+ " "));
		Arrays.asList(ab).stream().forEach(v-> System.out.print(v+ " "));
		System.out.println("\nArray which is referenced by above loop: "+ arr);
		Arrays.asList(arr).stream().forEach(v-> System.out.print(v+ " "));
		
		try {
			list.forEach(val -> {
					//list.remove(0);
				if(val== staticNo) // valid. constraint of being final is only applicable on local variables
					print(val, ab);
					System.out.print("\nIn first forEach loop: "+ val+ " ");
					new ForEachExp().abd();
					//throw new Throwable(); -> Won't be handeled by outside try catch block
			});
		}catch(Throwable throwable) {
			System.out.print("\nError in forEach lambda expression: "+ throwable.toString());
		}
		
		System.out.print("After try catch block");
		
	}

	public static void print(Integer in, int[] out) {
		System.out.print(++in);
	}
	
	private void abd() {
		int a[] = {976,678,899};
		int bal= 899;
		Arrays.asList(a).forEach(v-> {
			System.out.print("\nIn abd method forEach loop: "+ v+" ");
			if(v== a)
				return; // forEach can't return a value, i.e., return type should be void
			//System.out.print("\nIn abd method, class check in forEach: "+ this.getClass());
		});
	}

}
