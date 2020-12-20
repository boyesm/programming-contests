import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class DPCoinProblem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DPCoinProblem2 run = new DPCoinProblem2();
		int[] coins = {1, 5, 10, 25};
		int n = 71;
		int ind = coins.length - 1;
		int result = run.change(coins, n, ind);
		System.out.println(result);
		int sum = n;
		for (int i = coins.length - 1; i >= 0; i --) {
			if (sum != 0) {
				int amnt = sol.get(Integer.toString(sum) + "." + Integer.toString(i));
				System.out.print(amnt + "x" + coins[i] + ", ");
				sum -= coins[i] * amnt;
			}
		}
		System.out.println();
	}
	
	HashMap<String, Integer> mem = new HashMap<String, Integer>();
	public static HashMap<String, Integer> sol = new HashMap<String, Integer>();
	
	int change(int[] coins, int n, int ind) {
		String k = Integer.toString(n) + "." + Integer.toString(ind);
		if (mem.containsKey(k)) {
			return mem.get(k);
		}
		
		if (n == 0) {
			sol.put(k, 0);
			return 0;
		}
		
		if (ind == 0) {
			int val = n / coins[ind];
			if (n % coins[ind] != 0) {
				val = -1;
			}
			sol.put(k, val);
			return val;
		}
				
		int cMin = Integer.MAX_VALUE;
		int x, xMin = -1;
		for (x = 0; x <= Math.floor(n / coins[ind]); x ++) {
			int r = change(coins, n - x * coins[ind], ind - 1);
			
			if (r == -1) {
				continue;
			}
			if (r < cMin) {
				cMin = r;
				xMin = x;
			}
		}
		
		int ret = cMin + xMin;
		if (cMin == Integer.MAX_VALUE) {
			ret = -1;
		}
		mem.put(k, ret);
		sol.put(k, xMin);
		return ret;
	}
	
	HashMap<String, MyRet> memo = new HashMap<String, MyRet>();
	
	MyRet topDown(int[] coins, int n, int ind) {
		String k = Integer.toString(n) + "." + Integer.toString(ind);
		if (memo.containsKey(k)) {
			return memo.get(k);
		}
		
		if (n == 0) {
			memo.put(k, new MyRet(0, "gnd"));
			return new MyRet(0, "gnd");
		}
		
		if (ind == 0) {
			MyRet val = new MyRet(n / coins[ind], Integer.toString(n / coins[ind]));
			memo.put(k, val);
			if (n % coins[ind] != 0) {
				val.count = -1;
				val.sample = "IMPOSSIBLE";
			}
			return val;
		}
				
		int cMin = Integer.MAX_VALUE;
		int x, xMin = -1;
		String xSample = "";
		for (x = 0; x <= Math.floor(n / coins[ind]); x ++) {
			MyRet cVal = topDown(coins, n - x * coins[ind], ind - 1);
			if (cVal.sample.equals("IMPOSSIBLE")) {
				continue;
			}
			if (cVal.count < cMin) {
				cMin = cVal.count;
				xMin = x;
				xSample = Integer.toString(x) + "." + cVal.sample;
			}
		}
		
		MyRet ret = new MyRet(cMin + xMin, xSample);
		if (cMin == Integer.MAX_VALUE) {
			ret.count = -1;
			ret.sample = "IMPOSSIBLE";
		}
		memo.put(k, ret);
		return ret;
	}
	
	class MyRet {
		int count;
		String sample;
		MyRet(int a1, String a2) {
			count = a1;
			sample = new String(a2);
		}
	}

}
