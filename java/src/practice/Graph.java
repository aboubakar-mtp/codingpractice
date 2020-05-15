package practice;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	public List<GNode> nodes= new ArrayList<>();
	public Graph() {
		
	}
	
	public void addSubgraph(GNode n) {
		nodes.add(n);
	}
}
