import java.util.*;

public class BFSCycleCheck {

	public static void main(String[] args) {
		BFSCycleCheck run = new BFSCycleCheck();
		run.alg();
	}
	
	Scanner sc = new Scanner(System.in);
	
	void alg() {
		ArrayList<ArrayList<Integer>> ners = new ArrayList<ArrayList<Integer>>();
		HashSet<Integer> nodes = new HashSet<Integer>();
		HashMap<Integer, Integer> parent = new HashMap<Integer, Integer>();
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i ++) {
			ArrayList<Integer> noNer = new ArrayList<Integer>();
			int numNers = sc.nextInt();
			for (int j = 0; j < numNers; j ++) {
				noNer.add(sc.nextInt());
			}
			ners.add(noNer);
			nodes.add(i);
		}
		
		boolean cyclic = false;
		
		while (!nodes.isEmpty()) {
			HashSet<Integer> found = new HashSet<Integer>();
			ArrayList<Integer> fringe = new ArrayList<Integer>();
			Iterator<Integer> iter = nodes.iterator();
			int startNode = iter.next();
			fringe.add(startNode);
			parent.put(startNode, -1);
			
			while (!fringe.isEmpty()) {
				int cNode = fringe.remove(0);
				found.add(cNode);
				nodes.remove(cNode);
				for (int i : ners.get(cNode)) {
					if (!found.contains(i)) {
						parent.put(i, cNode);
						fringe.add(i);
					} else if (parent.get(i) != cNode) {
						cyclic = true;
					}
				}
			}
		}
		
		System.out.println(cyclic);
		
	}

}
