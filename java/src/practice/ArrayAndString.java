package practice;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayAndString {
	
	public ArrayAndString () {
		
	}
	
	public boolean hasUniqueCharacter(String s) {
		
			
		for (int i = 0; i < s.length(); i++) {
			for (int j = i+1; j < s.length(); j++) {
				if(s.charAt(i) == s.charAt(j)) {
					
					return false;
				}
			}
			
		}
		
		return true;
	}
	
	public boolean hasUniqueCharacter2(String s) {
		
		Map<Integer, Character> map = new HashMap();
		for (int i = 0; i < s.length(); i++) {
			
			if(map.containsValue(s.charAt(i))) {
				return false;
			}
			else {
				map.put(i, s.charAt(i));
			}
			
		}
		
		return true;
	}
	
	public boolean isUniqueChar(String str) {
		
		boolean[] char_set = new boolean[128];
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if(char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		
		return true;
	}
	
	public boolean isPermutationOf(String a, String b) {
		
		if(a.length() != b.length()) {
			return false;
		}
		a = this.sortString(a);
		b = this.sortString(b);
		
		for(int i = 0; i < a.length(); i ++) {
			if(a.charAt(i) != b.charAt(i)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public boolean isPermutationOf2(String a, String b) {
		if(a.length() != b.length()) {
			return false;
		}
		
		int [] char_set1 = new int[128];
		/*
		int[] char_set2 = new int[128];
		
		for(int i = 0; i < a.length(); i++) {
			char_set1[a.charAt(i)] += 1;
			char_set2[b.charAt(i)] += 1;
		}
		
		for(int i = 0; i < 128; i++) {
			if(char_set1[i] != char_set2[i]) {
				return false;
			}
		}
		*/
		
		for(int i = 0; i < a.length(); i++) {
			char_set1[a.charAt(i)] += 1;
		}
		for(int i = 0; i < b.length(); i++) {
			char_set1[b.charAt(i)]--;
			if(char_set1[b.charAt(i)] < 0) {
				return false;
			}
		}
		
		
		
		return true;
	}
	
	public String sortString(String a) {
		char[] ch = a.toCharArray();
		Arrays.sort(ch);
		
		return new String(ch);
	}
	
	public String urlify(String str, int n) {
		char[] st = str.toCharArray();
		String rep = "%20";
		int last = n-1;
		for(int i = 0; i < n; i++) {
			if(st[i] == ' ') {
				for(int j=last; j > i; j--) {
					st[j+2] = st[j];
				}
				last +=2;
				int idx =0;
				for(int j=i; j <= i+2; j++) {
					st[j] = rep.charAt(idx);
					idx++;
					
				}
			}
		}
		
		return new String(st);
	}
	
	public String urlify2(String str, int n) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			if(str.charAt(i) == ' ') {
				sb.append("%20");
			}
			else {
				sb.append(str.charAt(i));
			}
		}
		
		return sb.toString();
	}
	
	public String urlify3(String str, int n) {
		char[] st = str.toCharArray();
		int spaces = 0;
		String rep = "%20";
		for (int i =0; i < n; i++) {
			if(str.charAt(i) == ' ') {
				spaces++;
			}
		}
		int extra = 2 * spaces;
		int lastIdx = extra + n -1;
		for(int i=n-1; i > 0; i--) {
			if(st[i] != ' ') {
				st[lastIdx--] = st[i];
			}else {
				int idx = 2;
				int ll = lastIdx;
				int j = 0;
				for(j = ll; j >= ll-2; j--) {
					st[j] = rep.charAt(idx);
					idx--;
				}
				lastIdx = j;
			}
		}
		return new String(st);
	}
	
	public boolean isPalindromePermutation(String str) {
		int[] check = new int[128];
		
		int spaces = 0;
		
		for(int i = 0; i < str.length(); i++) {
			char ch = Character.toLowerCase(str.charAt(i));
			if( ch == ' ') {
				spaces++;
			}
			else {
				if(check[ch] == 0) {
					check[ch]++;
				}
				else {
					check[ch]--;
				}
			}
			
		}
		
		int sum = Arrays.stream(check).sum();
		
		
		if(sum == 0  || sum == 1) {
			return true;
		}
		
		return false;
	}
	
	
	
	boolean isPalindromePermutation2(String str) {
		int [] table = this.buildCharFrequencyTable(str);
		return this.checkMaxOneOdd(table);
	}
	
	public boolean isPalindromePermutation3(String str) {
		
		int oddCount = 0;
		int[] table = new int[Character.getNumericValue('z') - 
		                      Character.getNumericValue('a') + 1];
		for(char c : str.toCharArray()) {
			int x = this.getCharNumber(c);
			if( x != -1) {
				table[x]++;
				if(table[x] % 2 == 1) {
					oddCount ++;
				}
				else {
					oddCount --;
				}
			}
		}
		
		
		return oddCount <= 1;
	}
	
	public boolean checkMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		for(int count : table) {
			if(count % 2 == 1) {
				if(foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}
	
	public int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		
		if(a <= val && val <= z) {
			return val - a;
		}
		
		return -1;
	}
	
	
	public int[] buildCharFrequencyTable(String phrase) {
		int[] table = new int[Character.getNumericValue('z') - 
		                      Character.getNumericValue('a') +1];
		for(char c : phrase.toCharArray()) {
			int x = this.getCharNumber(c);
			
			if(x != -1) {
				table[x]++;
			}
		}
		
		return table;
	}
	
	
	
	public boolean isStringRotation(String s1, String s2) {
		String s3 = s2.concat(s2);
		return s3.contains(s1);
	}
	
	public int[][] zeroMatrix(int[][] mat){
		int row = mat.length;
		int col = mat[0].length;
		int[][] mat2 = new int[row][col];
		//mat2 = mat.clone();
		for(int r = 0; r < row; r ++) {
			for(int c = 0; c < col; c++) {
				
				mat2[r][c] = mat[r][c];
			}
		}
		for(int r = 0; r < row; r ++) {
			for(int c = 0; c < col; c++) {
				if(mat[r][c] == 0) {
					for(int i = 0; i < col; i++) {
						mat2[r][i] = 0;
					}
					for(int i = 0; i < row; i++) {
						mat2[i][c] = 0;
					}
					//break;
				}
			}
		}
		
		return mat2;
	}
	
	
	public int[][] zeroMatrix2(int[][] mat){
		int row = mat.length;
		int col = mat[0].length;
		int[] foundRows = new int[row*col];
		int[] foundCols = new int[col*col];
		int i = 0;
		for(int r = 0; r < row; r ++) {
			for(int c = 0; c < col; c++) {
				if(mat[r][c] == 0) {
					foundRows[i] = r;
					foundCols[i] = c;
					i++;
				}
			}
			
		}
		
		for(int j=0; j<i; j++) {
			for(int r=0; r < row; r++) {
				mat[r][foundCols[j]] = 0;
			}
			for(int c=0; c < col; c++) {
				mat[foundRows[j]][c] = 0;
			}
		}
		
		return mat;
	}
	
	public void zeroMatrix3(int[][] mat){
		int row = mat.length;
		int col = mat[0].length;
		
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				if(mat[r][c] == 0) {
					for(int i = 0; i < col; i++) {
						mat[r][i] = -1;
					}
					for(int i = 0; i < row; i++) {
						mat[i][c] = -1;
					}
					break;
				}
			}
		}
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				if(mat[r][c] == -1) {
					mat[r][c] = 0;
				}
			}
		}
		
		//return mat;
	}
	
	
	public void zeroMatrix4(int[][] mat) {
		boolean[] row = new boolean[mat.length];
		boolean[] col = new boolean[mat[0].length];
		
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		
		for(int i = 0; i < row.length; i++) {
			if(row[i]) {
				this.nullifyRow(mat, i);
			}
		}
		
		for(int i = 0; i < col.length; i++) {
			if(col[i]) {
				this.nullifyCol(mat, i);
			}
		}
		
		
		
	}
	
	public void nullifyRow(int[][] mat, int row) {
		for(int j = 0; j < mat[0].length; j++) {
			mat[row][j] = 0;
		}
	}
	
	public void nullifyCol(int[][] mat, int col) {
		for(int j = 0; j < mat.length; j++) {
			mat[j][col] = 0;
		}
	}
	
	public int summ (List<Integer> arr) {

        int arraySize = arr.size();
        int sum = 0;
        for(int i = 0; i < arraySize; i++){
            for(int sub = i; sub < arraySize; sub++ ){
                for(int j=i; j < sub; j++){
                    sum = sum + arr.get(j);
                }
            }
        }

        return sum;
	}
	
	public int sumSubArrays(List<Integer> arr) {
		int sum = 0;
		
		int n = arr.size();
		Integer[] list = arr.toArray(new Integer[0]);
		
		for(int i = 0; i<n; i++) {
			for(int j=i; j<n; j++) {
				for(int k=i; k<=j; k++) {
					sum = sum + list[k];
				}
			}
		}
		
		return sum;
	}
	
	public int sumSubArrays2(List<Integer> arr) {
		int sum = 0;
		Integer[] list = arr.toArray(new Integer[0]);
		int n =  arr.size();
		for(int i = 0; i <n; i++) {
			sum = sum + (((n-i)*(i+1)) * list[i]);
		}
		
		return sum;
	}
	
	
	
}
