import java.util.*;

public class MChain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MChain run = new MChain();
		int[] p = {30, 35, 15, 5, 10, 20, 25};
//		int[] p = {2, 3, 1, 4};
		System.out.println(run.dp(p, 1, p.length - 1));
		run.printSol(1, p.length - 1);
	}

	HashMap<String, Integer> memo = new HashMap<String, Integer>();
	static HashMap<String, Integer> sol = new HashMap<String, Integer>();
	
	void printSol(int a, int b) {
		if (a == b) {
			return;
		}
		
		int argMin = sol.get(Integer.toString(a) + "." + Integer.toString(b));
		System.out.println(a + ", " + b + " -> " + argMin);
		printSol(a, argMin);
		printSol(argMin + 1, b);
	}
	
	int dp(int[] p, int a, int b) {
		String k = Integer.toString(a) + "." + Integer.toString(b);
		if (memo.containsKey(k)) {
			return memo.get(k);
		}
		
		if (a == b) {
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		int res = 0;
		int argMin = -1;
		for (int i = a; i < b; i ++) {
			res = dp(p, a, i) + dp(p, i + 1, b) + p[a - 1] * p[i] * p[b];
			if (res < min) {
				min = res;
				argMin = i;
			}
		}

		memo.put(k, min);
		sol.put(k, argMin);
		return min;
	}
}
