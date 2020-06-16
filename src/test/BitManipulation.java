package test;

public class BitManipulation {
	
	public  boolean getBit(int num, int i) {
		return (num & (1 << i) ) != 0;
	}
	
	public  int setBit(int num, int i) {
		
		return num | (1 << i);
	}
	
	public  int clearBit(int num, int i) {
		int mask = ~(1 << i);
		return num & mask;
	}
	
	public  int clearBitsMSBThroughI(int num, int i) {
		int mask = (1 << i) -1;
		
		return num & mask;
	}
	
	public int clearBitsIThrough0(int num, int i) {
		int mask = (-1 << (i + 1));
		
		return num & mask;
	}
	
	public int updateBit(int num, int i, boolean bitIs1) {
		int value = bitIs1 ? 1 : 0;
		
		int mask = ~(1 << i);
		int posV = (value << i);
		
		return (num & mask) | posV;
	}
	
	int insertMinN(int N, int M, int j, int i) {
		for(int a = j; a >= i; a--) {
			N = this.clearBit(N, a);
		}
		
		M = M << i;
		
		return N | M;
	}
	
	int insertMinN2(int N, int M, int j, int i) {
		int allOnes = ~0;
		//build mask that clears bit j through i by in two steps
		int left = allOnes << (j +1);
		
		int right = ((1 << 1) -1);
		
		int mask = left | right;
		
		//clear bits j through i in N
		int clearedN = N & mask;
		
		//shift M = positon j through i
		
		int shiftedM = M << i;
		
		return clearedN | shiftedM;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		BitManipulation bm = new BitManipulation();
		
		///System.out.println(bm.getBit(63, 4));
		
		//System.out.println(bm.setBit(5, 1));
		
		
		System.out.println(bm.insertMinN(15, 2, 2, 1));
		System.out.println(bm.insertMinN2(15, 2, 2, 1));
		

	}

}
