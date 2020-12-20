import java.util.HashMap;

public class DPFib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DPFib run = new DPFib();
		System.out.println(run.topDown(6));
	}
	
	HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
	
	int topDown(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		
		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		
		int val = topDown(n - 1) + topDown(n - 2);
		memo.put(n, val);
		return val;
	}

}
