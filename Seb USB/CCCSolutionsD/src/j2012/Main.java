package j2012;

import java.util.*;

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Main run = new Main();
		run.q5();
	}
	
	Scanner sc = new Scanner(System.in);
	
	void q5() {
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> pos = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i ++) {
			ArrayList<Integer> initPos = new ArrayList<Integer>();
			initPos.add(sc.nextInt());
			pos.add(initPos);
		}
		
		HashSet<ArrayList<ArrayList<Integer>>> ideal = new HashSet<ArrayList<ArrayList<Integer>>>();
		ArrayList<ArrayList<Integer>> end = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i ++) {
			ArrayList<Integer> slot = new ArrayList<Integer>();
			slot.add(i + 1);
			end.add(slot);
		}
		ideal.add(end);
		
		HashSet<ArrayList<ArrayList<Integer>>> glimp = new HashSet<ArrayList<ArrayList<Integer>>>();
		glimp.add(pos);
		
		List<Augm> wList = new ArrayList<Augm>();
		Augm augm = new Augm();
		augm.pos = pos;
		augm.lvl = 0;
		wList.add(augm);
		
		while (wList.size() > 0) {
			Augm cAug = wList.remove(0);
			for (int i = 1; i < n; i ++) {
				// if left ind empty || token < left token
				int sL = cAug.pos.get(i - 1).size();
				int sC = cAug.pos.get(i).size();
				if (sC > 0 && (sL == 0 || cAug.pos.get(i).get(sC - 1) < cAug.pos.get(i - 1).get(sL - 1))) {
					ArrayList<ArrayList<Integer>> nPos = new ArrayList<ArrayList<Integer>>();
					for (ArrayList<Integer> j : cAug.pos) {
						nPos.add(new ArrayList<Integer>());
						for (int k : j) {
							nPos.get(nPos.size() - 1).add(k);
						}
					}
					
					int sN = nPos.get(i).size();
					int tok = nPos.get(i).remove(sN - 1);
					nPos.get(i - 1).add(tok);
					
					Augm nAug = new Augm();
					nAug.pos = nPos;
					nAug.lvl = cAug.lvl + 1;
				
					if (!glimp.contains(nPos)) {
						if (ideal.contains(nPos)) {
							System.out.println(nAug.lvl);
							return;
						}
						// else
						wList.add(nAug);
						glimp.add(nPos);
					}
				}
			}
			for (int i = 0; i < n - 1; i ++) {
				// if left ind empty || token < left token
				int sR = cAug.pos.get(i + 1).size();
				int sC = cAug.pos.get(i).size();
				if (sC > 0 && (sR == 0 || cAug.pos.get(i).get(sC - 1) < cAug.pos.get(i + 1).get(sR - 1))) {
					ArrayList<ArrayList<Integer>> nPos = new ArrayList<ArrayList<Integer>>();
					for (ArrayList<Integer> j : cAug.pos) {
						nPos.add(new ArrayList<Integer>());
						for (int k : j) {
							nPos.get(nPos.size() - 1).add(k);
						}
					}
					
					int sN = nPos.get(i).size();
					int tok = nPos.get(i).remove(sN - 1);
					nPos.get(i + 1).add(tok);
					
					Augm nAug = new Augm();
					nAug.pos = nPos;
					nAug.lvl = cAug.lvl + 1;
				
					if (!glimp.contains(nPos)) {
						if (ideal.contains(nPos)) {
							System.out.println(nAug.lvl);
							return;
						}
						// else
						wList.add(nAug);
						glimp.add(nPos);
					}
				}
			}
		}
		
		System.out.println("IMPOSSIBLE");
	}

}

class Augm {
	ArrayList<ArrayList<Integer>> pos;
	int lvl;
}
