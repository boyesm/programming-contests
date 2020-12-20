package j2018;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Main run = new Main();
		run.q5();
	}
	
	void q5() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// Make an ArrayList<ArrayList<Integer>> for the vertices and where they connect to
		ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i ++) {
			
			ArrayList<Integer> line = new ArrayList<Integer>();
			int m = sc.nextInt();
			
			for (int j = 0; j < m; j ++) {
				line.add(sc.nextInt() - 1);
			}
			
			edges.add(line);
		}
		sc.close();
		
		// First vertex of the group
		int s = 0;
		
		// Level of each vertex
		HashMap<Integer, Integer> level = new HashMap<Integer, Integer>();
		level.put(s, 0);
		
		// The parent of each vertex, used for shortest path through the graph
		HashMap<Integer, Integer> parent = new HashMap<Integer, Integer>();
		parent.put(s, null);
		
		PriorityQueue<Integer> frontier = new PriorityQueue<Integer>();
		frontier.add(s);
		int i = 1;
		while(!frontier.isEmpty()) {
			PriorityQueue<Integer> next = new PriorityQueue<Integer>();
			for (int u : frontier) {
				for (int v : edges.get(u)) {
					if (!level.containsKey(v)) {
						level.put(v, i);
						parent.put(v, u);
						next.add(v);
					}
				}
			}
			frontier = next;
			i ++;
		}
		
		boolean reachable = true;
		
		if (level.keySet().size() == edges.size()) {
			reachable = true;
		} else {
			reachable = false;
		}
		
		if (reachable) {
			System.out.println("Y");
		} else {
			System.out.println("N");
		}
		
		// Get the shortest path
		ArrayList<Integer> exNodes = new ArrayList<Integer>();
		for (int l = 0; l < edges.size(); l ++) {
			if (edges.get(l).size() == 0) {
				exNodes.add(l);
			}
		}
		
		// Backtrack from the end node in the hashmap and count the values to put in ArrayList<Integer>
		ArrayList<Integer> paths = new ArrayList<Integer>();
		for (int j = 0; j < exNodes.size(); j ++) {
			int length = 0;
			int ind = exNodes.get(j);
			if (parent.containsKey(ind)) {
				while (!(parent.get(ind) == null)) {
					ind = parent.get(ind);
					length ++;
				}
				paths.add(length);
			}
			
		}
		
		System.out.println(Collections.min(paths) + 1);
	}

}
