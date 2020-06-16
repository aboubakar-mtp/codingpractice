package generics;

public class GenericMethodTest {
	
	
	public static < T > void printArray(T[] myarr) {
		for(T t : myarr) {
			System.out.print(t + " ");
		}
		System.out.println();
	}
	
	//bounded Type parameters for generics
	public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
		T max = x;
		
		if(y.compareTo(max) > 0) {
			max = y;
		}
		if(z.compareTo(max) > 0) {
			max = z;
		}
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] intArr = {1,2,3,4,5};
		Double[] doubleArr = {1.1,2.2,3.3,4.4,5.5};
		String[] stringArr = {"H", "J", "k", "L", "M"};
		
		System.out.println("Array of integer from generic");
		GenericMethodTest.printArray(intArr);
		
		System.out.println("Array of double from generic");
		printArray(doubleArr);
		
		System.out.println("Array of Strings from generic");
		printArray(stringArr);
		
		
		System.out.println("bounded generic demo");
		
		System.out.printf("Max of %d, %d, and %d is %d\n\n", 3,4,5, maximum(3,4,5));
		
		System.out.printf("Max of %.1f, %.1f, and %.1f is %.1f\n\n", 6.6, 8.8, 7.7, 
				maximum(6.6, 8.8, 7.7));
		
		System.out.printf("Max of %s, %s, and %s is %s\n", "pear", "banana", "orange",
				maximum("pear", "banana", "orange"));

	}

}
