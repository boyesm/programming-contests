import java.util.*;

public class BFSTopoSort {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> ners = new ArrayList<ArrayList<Integer>>();
		int[] count = new int[n];
		
		for (int i = 0; i < n; i ++) {
			int m = sc.nextInt();
			ArrayList<Integer> nNers = new ArrayList<Integer>();
			for (int j = 0; j < m; j ++) {
				int eV = sc.nextInt();
				nNers.add(eV);
				count[eV] ++;
			}
			ners.add(nNers);
		}
		
		HashSet<Integer> found = new HashSet<Integer>();
		Buff fringe = new Buff(n + 1);
		fringe.enq(0);
		
//		for (int i : count) {
//			System.out.print(i + " ");
//		}
		System.out.println();
		
		while (!fringe.empty()) {
			int cNode = fringe.deq();
			System.out.println(cNode);
			
			for (int i = 0; i < ners.get(cNode).size(); i ++) {
				int nNode = ners.get(cNode).get(i);
				count[nNode] --;
				if (count[nNode] == 0) {
//					System.out.println("red " + nNode + " " + count[nNode]);
					if (!found.contains(nNode)) {
//						System.out.println(nNode);
						found.add(nNode);
						fringe.enq(nNode);
					}
				}
			}
		}
	}
	
	static class Buff {
		int[] els;
		int fi = 0, fe = 0;
		int cap;
		
		Buff(int cap) {
			this.cap = cap;
			els = new int[cap];
		}
		
		boolean empty() {
			return fi == fe;
		}
		
		void enq(int el) {
			els[fe] = el;
			fe = (fe + 1) % cap;
		}
		
		int deq() {
			int ret = els[fi];
			fi = (fi + 1) % cap;
			return ret;
		}
	}
}
