import java.util.*;

public class Dijkstra {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = sc.nextInt();
		
		ArrayList<ArrayList<II>> edges = new ArrayList<ArrayList<II>>();
		
		for (int i = 0; i < n; i ++) {
			int m = sc.nextInt();
			ArrayList<II> fan = new ArrayList<II>();
			for (int j = 0; j < m; j ++) {
				int first = sc.nextInt();
				int second = sc.nextInt();
				II cEdge = new II(first, second);
				fan.add(cEdge);
			}
			edges.add(fan);
		}
		
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0; // distance from start node to start node is 0
		
		PriorityQueue<II> fringe = new PriorityQueue<II>();
		fringe.add(new II(0, 0));
		
		while (!fringe.isEmpty()) {
			II couple = fringe.poll();
			
			int d = couple.second;
			int cNode = couple.first;
			
			if (d > dist[cNode]) {
				continue;
			}
			
			for (int i = 0; i < edges.get(cNode).size(); i ++) {
				// get edge
				II nEdge = edges.get(cNode).get(i);
				if (dist[cNode] + nEdge.second < dist[nEdge.first]) {
					dist[nEdge.first] = dist[cNode] + nEdge.second;
					fringe.add(new II(nEdge.first, dist[nEdge.first]));
				}
			}
		}
		
		for (int i : dist) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	static class II implements Comparable {
		int first, second;
		
		II (int first, int second) {
			this.first = first;
			this.second = second;
		}
		
		@Override
		public int compareTo(Object arg0) {
			II a0 = (II) arg0;
			if (this.first > a0.first) {
				return 1;
			} else if (this.first < a0.first) {
				return -1;
			}
			return 0;
		}
		
	}
}
