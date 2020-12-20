import java.util.*;

public class BFSFloodFill {

	public static void main(String[] args) {
		BFSFloodFill run = new BFSFloodFill();
		run.alg();
	}
	
	Scanner sc = new Scanner(System.in);
	
	void alg() {
		/*
		 Test:
5
2 2 3
1 4
2 0 3
2 0 2
1 1
		 */
		ArrayList<ArrayList<Integer>> ners = new ArrayList<ArrayList<Integer>>();
		HashSet<Integer> nodes = new HashSet<Integer>();
		ArrayList<Integer> labelled = new ArrayList<Integer>();
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i ++) {
			ArrayList<Integer> noNer = new ArrayList<Integer>();
			int numNers = sc.nextInt();
			for (int j = 0; j < numNers; j ++) {
				noNer.add(sc.nextInt());
			}
			ners.add(noNer);
			nodes.add(i);
			labelled.add(-1);
		}
		
		int lbl = 0;
		while (!nodes.isEmpty()) {
			HashSet<Integer> found = new HashSet<Integer>();
			ArrayList<Integer> fringe = new ArrayList<Integer>();
			Iterator<Integer> iter = nodes.iterator();
			fringe.add(iter.next());
			
			while (!fringe.isEmpty()) {
				int cNode = fringe.remove(0);
				found.add(cNode);
				nodes.remove(cNode);
				labelled.set(cNode, lbl);
				for (int i : ners.get(cNode)) {
					if (!found.contains(i)) {
						fringe.add(i);
					}
				}
			}
			lbl ++;
		}
		
		System.out.println(labelled);
	}
	
}
