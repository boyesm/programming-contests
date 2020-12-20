import java.util.*;

public class DPRodCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DPRodCutting run = new DPRodCutting();
		int rLength = 5;
		int[] prices = new int[] {1, 2, 3, 5, 5};
		int res = run.bottomUp(rLength, prices);
		System.out.println(res);
	}
	
	public HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
	
	public int topDown(int n, int[] prices) {
		if (n == 0) {
			return 0;
		}
		
		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		
		int cMax = 0;
		for (int i = 1; i <= n; i ++) {
			int total = topDown(n - i, prices) + prices[i - 1];
			if (total > cMax) {
				cMax = total;
			}
		}
		
		memo.put(n, cMax);
		return cMax;
	}
	
	public int bottomUp(int n, int[] prices) {
		memo.put(0, 0);
		
		for (int j = 1; j <= n; j ++) {
			
			int cMax = 0;
			for (int i = 1; i <= j; i ++) {
				int total = memo.get(j - i) + prices[i - 1];
				if (total > cMax) {
					cMax = total;
				}
			}
			memo.put(j, cMax);
		}
		return memo.get(n);
	}

}
