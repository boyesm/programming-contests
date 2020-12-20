import java.util.*;

public class Main {

	public static void main(String[] args) {
//		CCC2019S4.bu();
//		CCC2019S4.td_caller();
		CCC2019S5.go();
	}
	
	static class CCC2019S4 {
		static Scanner sc = new Scanner(System.in);
		
		static void bu () {
			int N = sc.nextInt();
			int[] dp = new int[N + 1];
			if (N == 1) {
				System.out.println(1);
				return;
			}
			if (N == 2) {
				System.out.println(1);
				return;
			}
			// else
			dp[1] = dp[2] = 1;
			for (int i = 3; i <= N; i++) {
				int sum = 0, k = 0;
				for (k = 2; k <= i; k++)
					sum += dp[i/k];
				dp[i] = sum;
			}
			System.out.println(dp[N]);
		}
		
		static HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		static void td_caller () {
			int N = sc.nextInt();
			System.out.println(td(N));
		}
		static int td (int i) {
			Integer r;
			if ((r = hm.get(i)) != null)
				return hm.get(i);
			
			if (i < 3)
				return 1;
			
			int sum = 0, k = 0;
			for (k = 2; k <= i; k++)
				sum += td(i/k);
			
			hm.put(i, sum);
			return sum;
		}
	}

	static class CCC2019S5 {
		static Scanner sc = new Scanner(System.in);
//		static int[][] pars;
		static int[] pars;
		
		static void go () {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int A = N*M;
			
			int[] a = new int[P]; int[] b = new int[P]; int[] c = new int[P];
			int[] x = new int[Q]; int[] y = new int[Q]; int[] z = new int[Q];
			int abcSum = 0;
//			iii[] flights = new iii[P];
//			iii[] portals = new iii[Q];
			iii[] links = new iii[P+Q];
			for (int i = 0; i < P; i ++) {
				a[i] = sc.nextInt() - 1;
				b[i] = sc.nextInt() - 1;
				c[i] = sc.nextInt();
				abcSum += c[i];
//				flights[i] = new iii(a[i], b[i], c[i]);
				links[i] = new iii(a[i], b[i], c[i]);
			}
			int xyzSum = 0;
			for (int j = 0; j < Q; j ++) {
				x[j] = sc.nextInt() - 1;
				y[j] = sc.nextInt() - 1;
				z[j] = - sc.nextInt(); // negative weight to flag a portal
				xyzSum -= z[j];
//				portals[j] = new iii(x[j], y[j], z[j]);
				links[P + j] = new iii(x[j], y[j], z[j]);
			}
			
			int initCost = abcSum  N + xyzSum  M;
			
			// sort abc's+xyz's
			Arrays.sort(links);
			
			// setup edges
			iii[] edges = new iii[P  N + Q  M];
			int eIx = 0;
			for (int lIx = 0; lIx < links.length; lIx++) {
				if (links[lIx].i2 > 0) // flight
					for (int i = 0; i < N; i ++) {
//						int I = i * N;
						edges[eIx++] = new iii(i + N  links[lIx].i0, i + N  links[lIx].i1, links[lIx].i2);
					}
				else // portal
					for (int j = 0; j < M; j ++) {
						int J = j * N;
						edges[eIx++] = new iii(J + links[lIx].i0, J + links[lIx].i1, -links[lIx].i2);
					}
			}

			// kruskal
			// add up edge weights
			int finalCost = 0;
			// initialize union-find forest
			pars = new int[A];
			for (int parIx = 0; parIx < A; parIx ++) {
				pars[parIx] = parIx;
			}
			for (eIx = 0; eIx < edges.length; eIx++) {
				if (find(edges[eIx].i0) == find(edges[eIx].i1))
					continue;
				// else
				finalCost += edges[eIx].i2;
				union(edges[eIx].i0, edges[eIx].i1);
			}
			
			// output savings
			System.out.println(initCost - finalCost);
		}
		
		static int find(int ix) {
			int px;
			for (; (px = pars[ix]) != ix; ix = px);
			return ix; // on return, ix == px
		}
		static void union(int ix, int jx) {
			int px, cx = 0;
			for (; (px = pars[ix]) != ix; ix = px, cx++);
			int qx, dx = 0;
			for (; (qx = pars[jx]) != jx; jx = qx, dx++);
			if (cx > dx)
				pars[qx] = px;
			else
				pars[px] = qx;
		}
		
		static class iii implements Comparable{
			int i0, i1, i2;
			iii (int i0, int i1, int i2) {
				this.i0 = i0; this.i1 = i1; this.i2 = i2;
			}
			public int compareTo(Object arg) {
				iii x = (iii)arg;
				if (i2 < x.i2) return -1;
				if (i2 > x.i2) return 1;
				return 0;
			}
		}
	}
}