import java.util.*;

public class DPLongestSubsequence {

	public static void main(String[] args) {
		DPLongestSubsequence run = new DPLongestSubsequence();
		int[] sequence = {6, 2, 5, 1, 7, 4, 8, 3};
		System.out.println(run.topDown(sequence, 0, 0));
	}
	
	HashMap<String, Integer> memo = new HashMap<String, Integer>();
	
	int topDown(int[] sequence, int ind, int filter) {
		if (ind == sequence.length - 1) {
			if (sequence[ind] > filter) {
				return 1;
			} else {
				return 0;
			}
		}
		
		String k = Integer.toString(ind) + "." + Integer.toString(filter);
		if (memo.containsKey(k)) {
			return memo.get(k);
		}
		
		int inc;
		if (sequence[ind] > filter) {
			inc = 1 + topDown(sequence, ind + 1, sequence[ind]);
		} else {
			inc = 0; //topDown(sequence, ind + 1, filter);
		}
		int exc = topDown(sequence, ind + 1, filter);
		int fRes = Integer.max(inc, exc);
		
		memo.put(k, fRes);
		return fRes;
	}
}
