import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class DPCoinProblem {
	
	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		DPCoinProblem run = new DPCoinProblem();
		int n = 8;
		int[] coins = {1, 4, 5};
		int res = run.topDown(n, coins);
		System.out.println(res);
	}
	
	public HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
//	public static HashMap<Integer, Integer> sol = new HashMap<Integer, Integer>();
/*	
	public void pSolI(int n) {
		for (;n > 0; n -= sol.get(n)) {
			System.out.println(sol.get(n));
		}
	}
	
	public void pSolR(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(sol.get(n));
		pSolR(n - sol.get(n));
	}
*/	
	public int topDown(int n, int[] coins) {
		if (n == 0) {
			return 0;
		}
		
		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		
		int cMin = Integer.MAX_VALUE;
		int cSol = -1;
		for (int i : coins) {
			if (i > n) {
				continue;
			} else {
				int nCoins = topDown(n - i, coins) + 1;
				if (nCoins < cMin) {
					cMin = nCoins;
					cSol = i;
				}
			}
		}
		
		memo.put(n, cMin);
//		sol.put(n, cSol);
		return cMin;
	}

}
