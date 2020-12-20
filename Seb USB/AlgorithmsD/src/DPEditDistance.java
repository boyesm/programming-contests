
public class DPEditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	int topDown(int l1, int l2, String x, String y) {
		// if memo cointainsKey l1.l2
			// return memo get l1.l2
		// if l1 && l2 == 0
			// return 0
		// r1 = MAX_INT
		// if l2 > 0
			// r1 = topDown(l1, l2 - 1) + 1
		// r2 = MAX_INT
		// if l1 > 0
			// r2 = topDown(l1 - 1, l2) + 1
		// r3 = MAX_INT
		// if l2 > 0 && l1 > 0
			// if match
				// r3 = topDown(l1 - 1, l2 - 1) + 1
			// else
				// r3 = topDown(l1 - 1, l2 - 1)
		// res = min(r1, r2, r3)
		// memo put (l1.l2, res)
		// return res
		return -1;
	}

}
