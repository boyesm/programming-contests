import java.util.*;

public class Ordering {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// input
		/*
		HashMap<String, Integer> point = new HashMap<String, Integer>();
		back = new HashMap<Integer, String>();
		
		String vars = sc.nextLine();
		Scanner scV = new Scanner(vars);
		int vert = 0;
		while (scV.hasNext()) {
			String k = scV.next();
			point.put(k, vert);
			back.put(vert, k);
			vert ++;
		}
		
		ners = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < point.keySet().size(); i ++) {
			ners.add(new ArrayList<Integer>());
		}
		
		par = new ArrayList<Integer>();
		for (int i = 0; i < ners.size(); i ++) {
			par.add(-1);
		}
		
		String rest = sc.nextLine();
		Scanner scR = new Scanner(rest);
		while (scR.hasNext()) {
			String nxt = scR.next();
			String[] parts = nxt.split("<");
			int part0 = point.get(parts[0]);
			int part1 = point.get(parts[1]);
			
			ners.get(part1).add(part0);
			par.set(part0, part1);
		}
		
		for (int i = 0; i < par.size(); i ++) {
			int sNode = par.get(i);
			if (sNode == -1) {
				found = new HashSet<Integer>();
				
				dfsTop(i);
				System.out.println();
			}
		}
		*/
		perms = new ArrayList<int[]>();
		
		ArrayList<Integer> tGA = new ArrayList<Integer>();
//		tGA.add(0);
//		tGA.add(1);
//		tGA.add(2);
//		tGA.add(3);
		
		int[] tGO = new int[tGA.size()];
		genPerms(tGA, 0, tGO);
		System.out.println();
	}
	
	static HashSet<Integer> found;
	static ArrayList<ArrayList<Integer>> ners;
	static ArrayList<Integer> par;
	static HashMap<Integer, String> back;
	static ArrayList<int[]> perms;
	
	static int dfsTop(int n) {
		if (found.contains(n)) {
			return -1;
		} else {
			found.add(n);
		}
		
		ArrayList<Integer> cNers = new ArrayList<Integer>(ners.get(n));
		perms = new ArrayList<int[]>();
		if (cNers.size() > 0) {
			genPerms(cNers, 0, new int[factorial(cNers.size())]);
		} else {
			perms.add(new int[0]);
		}
		
		for (int i = 0; i < perms.size(); i ++) {
			for (int j = 0; j < perms.get(i).length; j ++) {
				int cyCheck = dfsTop(perms.get(i)[j]);
				if (cyCheck == -1) {
					return -1;
				}
			}
		}
		
		System.out.print(back.get(n) + " ");
		return 0;
	}
	
	static int factorial(int n) {
		if (n <= 0)
			return 1;
		
		return n * factorial(n - 1);
	}
	
	static void genPerms(ArrayList<Integer> pool, int ind, int[] ord) {
//		System.out.print("[" + ind + " -> ");
		// ord[0] == 1 && ord[1] == 2 && ord[2] == 0
		if (ind == pool.size()) {
			// do something with ord
			for (int i : ord) {
				System.out.print(i + " ");
			}
			System.out.println();
			perms.add(ord);
			return;
		}
		
		
		for (int i = ind; i < pool.size(); i ++) {
			int temp = pool.get(i);
			pool.set(i, ord[ind]);
			ord[ind] = temp;
			genPerms(pool, ind + 1, ord);
		}
		
		for (int i = ind; i < pool.size() - 1; i ++) {
			pool.set(i, pool.get(i + 1));
		}
		pool.set(pool.size() - 1, ord[ind]);
	}
}
