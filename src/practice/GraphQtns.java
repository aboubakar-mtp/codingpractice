package practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphQtns {
	
	public GraphQtns() {
		
	}
	
	public boolean searchBFS(Graph g, GNode a, GNode b) {
		
		if(a==b) return true;
		
		Queue<GNode> q = new LinkedList<>();
		q.add(a);
		GNode x; 
		while(!q.isEmpty()) {
			x = q.remove();
			
			for(GNode y : x.neighbors) {
				if(y.visited == false) {
					if (y == b) {
						return true; 
					}
					q.add(y);
				}
			}
			
			x.visited = true;
		}
		
		return false;
	}
	
	public boolean searchDFS(Graph g, GNode a, GNode b) {
		if(a == b) {
			return true;
		}
		else if(a == null) {
			return false;
		}
		return DFSHelper(a, b, false);
		


	}
	
	public boolean DFSHelper(GNode a, GNode b, boolean found) {
		if(a==b) {
			return true;
		}
		a.visited = true;
		for(GNode x : a.neighbors) {
			if( x.visited == false) {
				found = found || DFSHelper(x, b, found);
				if(found) {
					return found;
				}
			}
		}
		
		return found;
	}
	
	public void DFSInOrder(GNode root) {
		if(root != null) {
			
			//root.visited = true;
			System.out.print(root.val + ", ");
			for(GNode x : root.neighbors) {
				//if(!x.visited) {
					DFSInOrder(x);
				//}
			}
			
		}
	}
	
	public GNode minTree(Integer[] arr) {
		if(arr.length == 0) return null;
		//if(arr.length == 1) return new GNode(arr[0]);
		int midIndex = arr.length/2;
		Integer middle = arr[midIndex];
		
		GNode node = new GNode(middle);
		node.neighbors.add(minTree(Arrays.copyOfRange(arr, 0, midIndex)));
		node.neighbors.add(minTree(Arrays.copyOfRange(arr, midIndex+1, arr.length)));
		
		return node;
	}
	
	public GNode minTree2(Integer[] arr) {
		return minTree2Helper(arr, 0, arr.length - 1);
	}
	
	public GNode minTree2Helper(Integer[] arr, int start, int end) {
		if(end < start) {
			return null;
		}
		int middle = (start + end)/2;
		GNode node = new GNode(arr[middle]);
		node.neighbors.add(minTree2Helper(arr, start, middle - 1));
		node.neighbors.add(minTree2Helper(arr, middle + 1, end));
		
		return node;
	}
	
	public void createLevelLinkedList(BTNode root, ArrayList<LinkedList<BTNode>> lists,
			int level) {
		if(root == null) return;
		
		LinkedList<BTNode> list = null;
		if(lists.size() == level) {
			list = new LinkedList<BTNode>();
			lists.add(list);
		}else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);
		
	}
	
	ArrayList<LinkedList<BTNode>> createLevelLinkedList(BTNode root){
		ArrayList<LinkedList<BTNode>> lists = new ArrayList<>();
		
		createLevelLinkedList(root, lists, 0);
		
		return lists;
	}
	
	ArrayList<LinkedList<BTNode>> createLevelLinkedListBFS(BTNode root){
		ArrayList<LinkedList<BTNode>> result = new ArrayList<>();
		
		LinkedList<BTNode> current = new LinkedList<>();
		if(root != null) {
			current.add(root);
		}
		
		while(current.size() > 0) {
			result.add(current);
			LinkedList<BTNode> parents = current;
			current = new LinkedList<>();
			for(BTNode parent : parents) {
				if(parent.left != null) {
					current.add(parent.left);
				}
				if(parent.right != null) {
					current.add(parent.right);
				}
			}
		}
		
		return result;
	}
	
	public int calcBTHeight(BTNode root) {
		int height = 0;
		LinkedList<BTNode> current = new LinkedList<>();
		LinkedList<BTNode> parents = new LinkedList<>();
		
		if(root != null) {
			current.add(root);
		}
		while(current.size() > 0) {
			height++;
			parents = current;
			current = new LinkedList<>();
			for(BTNode p : parents) {
				if(p.left != null) {
					current.add(p.left);
				}
				if(p.right != null) {
					current.add(p.right);
				}
			}
		}
		
		return height;
	}
	
	public boolean checkBalanced(BTNode root) {
		if(root == null) {
			return true;
		}
		int h1 = calcBTHeight(root.left);
		int h2 = calcBTHeight(root.right);
		
		if(Math.abs(h1 - h2) > 1) {
			return false;
		}
		
		return checkBalanced(root.left) && checkBalanced(root.right);
	}
	
	public int getHeightBT(BTNode root) {
		if(root == null) return 0;
		
		return Math.max(getHeightBT(root.left), getHeightBT(root.right)) + 1;
	}
	
	//more efficient checkBalance
	
	int checkHeight(BTNode root) {
		if(root == null) return -1;
		int leftHeight = checkHeight(root.left);
		if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int rightHeight = checkHeight(root.right);
		if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int hd = leftHeight - rightHeight;
		if(Math.abs(hd) > 1) {
			return Integer.MIN_VALUE;
		}
		else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
		
		
	}
	
	public boolean isBalancedBT(BTNode root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	
	public boolean isBinarySearchTree(BTNode root) {
		if(root == null) return true;
		
		return ((root.left == null ? Integer.MIN_VALUE : root.left.val) <= root.val 
				&& root.val <= (root.right == null ? Integer.MAX_VALUE : root.right.val) )
				&& isBinarySearchTree(root.left) && isBinarySearchTree(root.right);
	}
	
	public static void main(String[] args) {
		
		GraphQtns gq = new GraphQtns();
		GNode a = new GNode(1);
		GNode b= new GNode(2);
		GNode c = new GNode(3);
		GNode d = new GNode(4);
		
		a.addNeigbor(b);
		a.addNeigbor(d);
		b.addNeigbor(c);
		d.addNeigbor(c);
		
		
		Graph g = new Graph();
		g.addSubgraph(a);
		
		//System.out.println(gq.searchBFS(g, d, c));
		//System.out.println(gq.searchDFS(g, d, c));
		
		//gq.DFSInOrder(a);
		
		Integer[] arr = new Integer[] {1,2,3,4,5,6,7};
		
		//gq.DFSInOrder(gq.minTree(arr));
		System.out.println();
		//gq.DFSInOrder(gq.minTree2(arr));
		
		BTNode bt = new BTNode(0);
		BTNode bt1 = new BTNode(1);
		BTNode bt2 = new BTNode(2);
		BTNode bt3 = new BTNode(3);
		BTNode bt4 = new BTNode(4);
		BTNode bt5 = new BTNode(5);
		BTNode bt6 = new BTNode(6);
		BTNode bt7 = new BTNode(7);
		BTNode bt8 = new BTNode(8);
		BTNode bt9 = new BTNode(9);
		BTNode bt10 = new BTNode(10);
		BTNode bt11 = new BTNode(11);
		/*
		bt.left = bt1;
		bt.right = bt2;
		bt1.left = bt3;
		bt1.right = bt4;
		bt2.left = bt5;
		bt2.right = bt6;
		bt3.left = bt7;
		bt3.right = bt8;
		bt5.left = bt9;
		bt5.right = bt10;
		bt9.left = bt11;*/
		
		
		
		
		ArrayList<LinkedList<BTNode>> lists = gq.createLevelLinkedListBFS(bt);
		
		/*for(LinkedList<BTNode> l : lists){
			for(BTNode node : l) {
				System.out.print(node.val + " ");
			}
			System.out.println();
			
		}*/
		
		//System.out.println(gq.getHeightBT(bt));
		
		//System.out.println(gq.checkBalanced(bt));
		
		//BST
		bt5.left = bt3;
		bt5.right = bt7;
		bt3.left = bt2;
		bt3.right = bt4;
		bt7.left = bt1;
		bt7.right = bt8;
		
		System.out.println(gq.isBinarySearchTree(bt5));
				
	}

}
