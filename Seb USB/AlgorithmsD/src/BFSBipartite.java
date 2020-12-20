import java.util.*;

public class BFSBipartite {

	public static void main(String[] args) {
		BFSBipartite run = new BFSBipartite();
		run.alg();
	}
	
	Scanner sc = new Scanner(System.in);
	
	void alg() {
		ArrayList<ArrayList<Integer>> ners = new ArrayList<ArrayList<Integer>>();
		HashSet<Integer> nodes = new HashSet<Integer>();
		ArrayList<Integer> colours = new ArrayList<Integer>();
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i ++) {
			ArrayList<Integer> noNer = new ArrayList<Integer>();
			int numNers = sc.nextInt();
			for (int j = 0; j < numNers; j ++) {
				noNer.add(sc.nextInt());
			}
			ners.add(noNer);
			nodes.add(i);
			colours.add(-1);
		}
		
		boolean bipartite = true;
		
		while (!nodes.isEmpty()) {
			HashSet<Integer> found = new HashSet<Integer>();
			ArrayList<Integer> fringe = new ArrayList<Integer>();
			Iterator<Integer> iter = nodes.iterator();
			int startNode = iter.next();
			fringe.add(startNode);
			
			int counter = 0;
			colours.set(startNode, 1);
			
			while (!fringe.isEmpty()) {
				int cNode = fringe.remove(0);
				found.add(cNode);
				nodes.remove(cNode);
				for (int i : ners.get(cNode)) {
					if (!found.contains(i)) {
						fringe.add(i);
						if (counter % 2 == 0) {
							colours.set(i, 0);
						} else {
							colours.set(i, 1);
						}
					} else {
						if (colours.get(i) == colours.get(cNode)) {
							bipartite = false;
						}
					}
				}
				counter ++;
			}
		}
		
		System.out.println(bipartite);
	}
}
