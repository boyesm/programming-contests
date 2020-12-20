import java.util.*;

public class Bars {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bars run = new Bars();
		run.iter();
	}
	
	Scanner sc = new Scanner(System.in);
	
	void iter() {
		int t = sc.nextInt();
		for (int i = 0; i < t; i ++) {
			int n = sc.nextInt();
			int p = sc.nextInt();
			int[] bars = new int[p];
			for (int j = 0; j < p; j ++) {
				bars[j] = sc.nextInt();
			}
			
			boolean found = false;
			int c;
			for (c = 0; c < (1 << p); c ++) {
				int sum = 0;
				for (int j = 0; j < bars.length; j ++) {
					if (((c ^ (c >> 1)) & (1 << j)) > 0) {
						sum += bars[j];
					}
				}
				if (sum == n) {
					found = true;
					break;
				}
			}
			if (found) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	
	void rec() {
		int t = sc.nextInt();
		for (int i = 0; i < t; i ++) {
			int n = sc.nextInt();
			int p = sc.nextInt();
			int[] bars = new int[p];
			for (int j = 0; j < p; j ++) {
				bars[j] = sc.nextInt();
			}
			
			boolean possible = poss(bars, 0, n);
			if (possible) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	
	boolean poss(int[] bars, int ind, int sum) {
//		System.out.print("[" + ind + ", " + sum);
		
		if (sum == 0) {
//			System.out.print(" -> t]");
			return true;
		}
		
		if (ind == bars.length) {
//			System.out.print(" -> f]");
			return false;
		}
		
		boolean r1 = poss(bars, ind + 1, sum - bars[ind]);
		boolean r2 = poss(bars, ind + 1, sum);
//		System.out.print(" -> f]");
		
		return r1 || r2;
	}
	
}
