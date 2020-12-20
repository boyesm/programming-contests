import java.util.*;

public class DPKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DPKnapsack run = new DPKnapsack();
		int[] weights = {1, 3, 3, 5};
		int sum = 0;
		for (int i : weights) {
			sum += i;
		}
		System.out.println(run.topDown(weights, weights.length - 1, sum));
	}
	
	static HashMap<String, HashSet<Integer>> memo = new HashMap<String, HashSet<Integer>>();
	
	HashSet<Integer> topDown(int[] weights, int ind, int sum) {
		String k = Integer.toString(ind) + "." + Integer.toString(sum);
		if (memo.containsKey(k)) {
			return memo.get(k);
		}
		
		if (ind == -1) {
			HashSet<Integer> ret = new HashSet<Integer>();
			ret.add(sum);
			return ret;
		}
		
		HashSet<Integer> r1 = new HashSet<Integer>();
		if (sum >= weights[ind]) {
			r1 = topDown(weights, ind - 1, sum - weights[ind]);
		}
		HashSet<Integer> r2 = new HashSet<Integer>();
		r2 = topDown(weights, ind - 1, sum);
		
		r1.addAll(r2);
		memo.put(k, r1);
		return r1;
	}

}
