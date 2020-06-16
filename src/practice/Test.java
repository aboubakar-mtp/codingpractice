package practice;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Test {

	public static void main(String[] args) {
		
		/*
		HashTable ht = new HashTable(1000);
		
		ht.add("1", "One");
		ht.add("2", "Two");
		ht.add("3", "Three");
		ht.add("4", "Four");
		ht.add("5", "Five");
		
		System.out.println("value for key 5 is " + ht.get("5"));
		*/
		
		HashTable2<Integer, String> h2 = new HashTable2<>(20);
		
		h2.add(1, "One");
		h2.add(2, "Two");
		h2.add(3, "Three");
		h2.add(4, "Four");
		
		//System.out.print("value at key 4 is " + h2.get(4));
		
		
		
		//unique characters in string
		
		ArrayAndString as = new ArrayAndString();
		String s = "aboukk";
		////System.out.println(as.hasUniqueCharacter(s));
		//System.out.println(as.hasUniqueCharacter2(s));
		//System.out.println(as.isUniqueChar(s));
		
		/*
		int a = 5, b = 7;
		
		
		System.out.println("a&b = " + (a & b));
		System.out.println(("a|b = " + (a | b)));
		System.out.println("a^ = " + (a ^ b));
		System.out.println("~a = " + (~a));
		*/
		
		//String a = "abou", b = "boua";
		
		//System.out.println(as.isPermutationOf(a, b));
		//System.out.println(as.isPermutationOf2(a, b));
		
		//String st = "welcome home abou my friend            ";
		
		//System.out.println(as.urlify(st, 27));
		
		//System.out.println(as.urlify2(st, 27));
		
		//System.out.println(as.urlify3(st, 27));
		
		//String str = "maamab";
		
		///System.out.println(as.isPalindromePermutation(str));
		//System.out.println(as.isPalindromePermutation2(str));
		//System.out.println(as.isPalindromePermutation3(str));
		
		//String s1 = "aboubakar", s2 = "bakarabou";
		
		//System.out.println(as.isStringRotation(s1, s2));
		/*
		int[][] mat = new int[][] {
				new int[] {1,1,1,1,1},
				new int[] {1,1,1,1,1},
				new int[] {1,0,1,1,1},
				new int[] {1,1,1,1,1},
		};
		
		int[][] res = as.zeroMatrix(mat);
		
		for(int i=0; i < res.length; i++) {
			for(int j=0; j< res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		System.out.println();
		System.out.println();
		as.zeroMatrix4(mat);
		
		for(int i=0; i < mat.length; i++) {
			for(int j=0; j< mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		
		*/
		
		//test LinkedList
		LinkedList ll = new LinkedList();
		Node start = new Node(3);
		ll.add(start, 5);
		ll.add(start, 8);
		Node cc = ll.add(start, 5);
		ll.add(start, 10);
		ll.add(start, 2);
		ll.add(start, 1);
		
		//ll.printLinkedList(start);
		
		//ll.deleteDups2(start);
		
		//ll.printLinkedList(start);
		
		//System.out.println(ll.returnKthTotheLast4(start, 4).data);
		
		//ll.deleteMiddleNode2(cc);
		
		//ll.printKthToLast(start, 4);
		
		//ll.printLinkedList(start);
		//System.out.println();
		//ll.printLinkedList(ll.partitionList(start, cc));
		//ll.printLinkedList(ll.partitionList2(start, 5));
		
		/*Node dig1 = new Node(7);
		dig1.appendToTail(1);
		dig1.appendToTail(6);
		
		Node dig2 = new Node(5);
		dig2.appendToTail(9);
		dig2.appendToTail(3);
		
		ll.printLinkedList(ll.sumLists3(dig1, dig2));*/
		/*
		Node list = new Node(1);
		list.appendToTail(2);
		list.appendToTail(4);
		list.appendToTail(1);
		
		System.out.println(ll.isPalindrome2(list));
		System.out.println(ll.isPalindrome3(list));
		*/
		/*
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println(as.sumSubArrays(list));
		System.out.println(as.sumSubArrays2(list));
		*/
		/*
		NumberProb np = new NumberProb();
		
		System.out.println(np.largestNumberWithFive(-268));
		*/
		
		/*
		MyStack<Integer> ms = new MyStack<>();
		
		ms.push(5);
		ms.push(3);
		
		StackWithMin msm = new StackWithMin();
		msm.push(4);
		msm.push(7);
		msm.push(3);
		
		System.out.println(msm.min());
		
		*/
		
		SetOfStacks2 ss = new SetOfStacks2(3);
		
		ss.push(1);
		ss.push(5);
		ss.push(3);
		ss.push(2);
		
		
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		//System.out.println(ss.pop());
		
		ss.push(14);
		ss.push(55);
		ss.push(38);
		ss.push(92);
		
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		
		
		
		
		
		
		
		
		
		
		
	}

}
