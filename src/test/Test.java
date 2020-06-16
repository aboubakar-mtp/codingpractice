package test;

import java.lang.reflect.Array;
import java.util.regex.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Pattern.matches("(1?\\d?\\d[.]){3}(1?\\d?\\d)", 
				"0.0.199.3"));
		
		Pattern p = Pattern.compile("geek");
		
		Matcher m = p.matcher("geeksfogrgeekslkgjjg254geeksforgeeks");
		//m.find();
		//System.out.println(m.groupCount());
		while(m.find()) {
			System.out.println("Pattern found at " +
					m.start() + " to " + (m.end()-1));
			
		}
		
		int[][] points = new int[2][3];
		
		points[0][0] = 1;
		points[1][0] = 1;
		points[0][1] = 1;
		points[1][1] = 1;
		points[0][2] = 1;
		points[1][2] = 1;
		
		System.out.println(points.length);
		
		
		//System.out.println(m.groupCount());
		
	}

}
