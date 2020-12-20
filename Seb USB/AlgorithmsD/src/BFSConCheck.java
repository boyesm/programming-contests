import java.util.*;

public class BFSConCheck {

	public static void main(String[] args) {
		BFSConCheck run = new BFSConCheck();
		run.alg();
	}
	
	Scanner sc = new Scanner(System.in);
	
	void alg() {
		ArrayList<ArrayList<Integer>> ners = new ArrayList<ArrayList<Integer>>();
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i ++) {
			ArrayList<Integer> noNer = new ArrayList<Integer>();
			int numNers = sc.nextInt();
			for (int j = 0; j < numNers; j ++) {
				noNer.add(sc.nextInt());
			}
			ners.add(noNer);
		}
		
		HashSet<Integer> found = new HashSet<Integer>();
		ArrayList<Integer> fringe = new ArrayList<Integer>();
		fringe.add(0);
		
		while (!fringe.isEmpty()) {
			int cNode = fringe.remove(0);
			found.add(cNode);
			for (int i : ners.get(cNode)) {
				if (!found.contains(i)) {
					fringe.add(i);
				}
			}
		}
		
		boolean allVis = true;
		/*
		for (int i = 0; i < ners.size(); i ++) {
			if (!found.contains(i)) {
				allVis = false;
				break;
			}
		}
		*/
		if (found.size() != n) {
			allVis = false;
		}
		System.out.println(allVis);
	}

}
