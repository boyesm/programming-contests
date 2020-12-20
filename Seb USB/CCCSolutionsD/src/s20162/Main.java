package s20162;

import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RiceBalls rb = new RiceBalls();
		rb.main();
	}
		
	
	static class RiceBalls {
		
		static Scanner sc = new Scanner(System.in);
		static int n = 0;
		static int[] rbs;

		void main() {
			rbs_bu();
//			rbs_main();
		}
		
		
		
		static void rbs_bu() {

			n = sc.nextInt();
			rbs = new int[n];
			for (int i = 0; i < n; i ++) {
				rbs[i] = sc.nextInt();
			}
			
			int[][] dp = new int[n][]; // dp[i][j] means range starting at i of size j is mergeable (i ... i+j-1 inclusive)

			for (int ix = 0; ix < n; ix ++)
			{
				dp[ix] = new int[n + 1]; // we have a +1 in n+1 to include zero-size ranges
				dp[ix][0] = 0;
				dp[ix][1] = rbs[ix];				
				for (int jx = 2; jx < n; jx ++)
					dp[ix][jx] = -1;
			}
			
			int max = 0;
			for (int size = 1; size <= n; size ++) {
				// fill in dp results for ranges of current size
				for (int startIx = 0; startIx <= n - size; startIx ++)
				{
					boolean isMer = false;
					int lhs = 0; // left hand side sum
					for (int k = startIx; k < startIx + size - 1; k ++) { // k is the li of lhs range; at least one item on the lhs
						lhs += rbs[k];
						int rhs = rbs[startIx + size - 1]; // right hand side sum
						int midSum = 0; for (int h = k + 1; h < startIx + size - 1; h ++) midSum += rbs[h];
						for (int l = startIx + size - 1; l > k; l --) { // l is the fo of the mid range == fi of rhs range; at least one item on the rhs; mid section can have zero items
//							System.out.println("[startIx=" + startIx + " size=" + size + " k=" + k + " l=" + l);
//							if (startIx == 0 && size == 3 && k == 1 && l == 2)
//							{
//								System.out.println();
//							}
							if (lhs == rhs && dp[startIx][k - startIx] > -1 && dp[k][l - k] > -1 && dp[l][startIx + size - 1 - l] > -1)
							{
								dp[startIx][size] = lhs + midSum + rhs;
//								System.out.println(" " + dp[startIx][size] + "]");
								max = max < dp[startIx][size] ? dp[startIx][size] : max;
								isMer = true;
								continue;
							}
//							System.out.println(" no]");
							rhs += rbs[l - 1];
							midSum -= rbs[l - 1];
						}
						if (isMer) break;
					}
				}
//				System.out.println();
			}
			
			System.out.println(max);
		}
	}
}