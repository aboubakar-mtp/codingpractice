package test;

public class MathAndLogic {
	
	boolean isPrimeImproved(int n) {
		if(n < 2) return false;
		
		int sqrt = (int) Math.sqrt(n);
		for(int i = 2; i <= sqrt; i++) {
			if( n % i == 0) return false;
		}
		
		return true;
	}
	
	boolean[] sieveOfEratosthenes(int max) {
		boolean[] flags = new boolean[max + 1];
		
		init(flags);
		
		int prime = 2;
		
		while(prime <= Math.sqrt(max)) {
			//cross off remaining multiples of prime
			crossOff(flags, prime);
			
			//find next value is is prime
			
			prime = getNextPrime(flags, prime);
			
		}
		
		return flags;
	}
	
	public void crossOff(boolean[] flags, int prime) {
		for(int i = prime * prime; i < flags.length; i += prime) {
			flags[i] = false;
		}
	}
	
	int getNextPrime(boolean[] flags, int prime) {
		int next = prime + 1;
		
		while(next < flags.length && !flags[next]) {
			next++;
		}
		return next;
	}
	
	public void init(boolean[] flags) {
		for(int i = 2; i < flags.length; i++) {
			flags[i] = true;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MathAndLogic ml = new MathAndLogic();
		
//		System.out.println(ml.isPrimeImproved(25));
		
		/*
		 * boolean[] test = new boolean[] {false, true,};
		 * 
		 * for(boolean t : test) System.out.println(t);
		 */
		
		boolean[] sieve = ml.sieveOfEratosthenes(25);
		System.out.println(sieve.length);
		
		 for(int i = 0; i < sieve.length; i++) {
			 System.out.println(i + " : " + sieve[i]);
		 }
	}

}
