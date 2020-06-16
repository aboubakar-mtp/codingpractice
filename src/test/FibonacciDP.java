package test;

import java.util.HashMap;

public class FibonacciDP {
	
	public int fibonacci(int n) {
		return fibonacci(n, new int[n + 1]);
		
	}
	//top-down DP memoization
	public int fibonacci(int i, int[] memo) {
		
		if(i == 0 || i == 1) {
			return i;
		}
		
		if(memo[i] == 0) {
			memo[i] = fibonacci(i - 1, memo) + fibonacci(i-2, memo);
		}
		
		return memo[i];
	}
	
	public int fibonacciTD2(int n) {
		return fibonacciTD2(n, new HashMap<Integer, Integer>());
	}
	
	public int fibonacciTD2(int n, HashMap<Integer, Integer> memo) {
		if(n == 0 || n == 1) return n;
		
		if(!memo.containsKey(n)) {
			int res = fibonacciTD2(n-1, memo) + fibonacciTD2(n-2, memo);
			memo.put(n,res );
		}
		
		return memo.get(n);
	}
	
	//bottom-up DP
	
	public int fibonacciBU(int n) {
		if(n == 0 || n == 1) return n;
		
		int[] memo = new int[n +1];
		memo[0] = 0;
		memo[1] = 1;
		for(int i = 2; i <= n; i ++) {
			memo[i] = memo[i-1] + memo [i-2];
		}
		
		return memo[n];
		
	}
	
	public int fibonacciBU2(int n) {
		if(n == 0) return 0;
		int a = 0;
		int b = 1;
		int c = 0;
		for(int i = 2; i<n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		
		return a + b;
	}
	
	public static void main(String[] args) {
		
		FibonacciDP fb = new FibonacciDP();
		int n = 10;
		System.out.println(fb.fibonacci(n));
		System.out.println(fb.fibonacciBU(n));
		
		System.out.println(fb.fibonacciBU2(n));
		
		System.out.println(fb.fibonacciTD2(n));
		
	}

}
