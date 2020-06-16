package practice;

import java.util.ArrayList;
import java.util.List;

public class GNode {
	public int val;
	public List<GNode> neighbors = new ArrayList<>();
	public boolean visited;
	
	public GNode(int v) {
		this.val = v;
		this.visited = false;
	}
	
	public void addNeigbor(GNode n) {
		this.neighbors.add(n);
	}
	
}

