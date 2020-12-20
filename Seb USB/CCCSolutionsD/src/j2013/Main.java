package j2013;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main run = new Main();
		run.q5();
	}
	
	Scanner sc = new Scanner(System.in);
	
	void q5() {		
		// fill pts array with -1
		pts = new int[4][4];
		for (int i = 0; i < pts.length; i ++) {
			for (int j = 0; j < pts[i].length; j ++) {
				if (i == j) {
					pts[i][j] = 0;
				} else {
					pts[i][j] = -1;
				}
			}
		}
		
		// scan and fill pts
		team = sc.nextInt();
		int g = sc.nextInt();
		for (int i = 0; i < g; i ++) {
			int t1 = sc.nextInt() - 1;
			int t2 = sc.nextInt() - 1;
			
			int s1 = sc.nextInt();
			int s2 = sc.nextInt();
			
			if (s1 > s2) {
				pts[t1][t2] = 3;
				pts[t2][t1] = 0;
			} else if (s1 < s2) {
				pts[t1][t2] = 0;
				pts[t2][t1] = 3;
			} else {
				pts[t1][t2] = 1;
				pts[t2][t1] = 1;
			}
		}
		
		// build uH and uL
		gfo = 6 - g;
		uH = new int[gfo];
		uL = new int[gfo];
		int counter = 0;
		for (int i = 0; i < pts.length; i ++) {
			for (int j = i + 1; j < pts.length; j ++) {
				if (pts[i][j] == -1) {
					uH[counter] = j;
					uL[counter] = i;
					counter ++;
				}
			}
		}
		
		// call golds
		uO = new int[gfo];
		System.out.println(golds(0));
	}
	
	int[][] pts;
	int[] uH;
	int[] uL;
	int[] uO;
	int gfo;
	int team;
	
	int golds(int gid) {
		// counts number of playouts team wins tournament
		if (gid == gfo) {
			return detGold();
		}
		
		uO[gid] = 0;
		int r1 = golds(gid + 1);
		uO[gid] = 1;
		int r2 = golds(gid + 1);
		uO[gid] = 2;
		int r3 = golds(gid + 1);
		
		return r1 + r2 + r3;
	}
	
	int detGold() {
		// checks if t won gold
		
		// fill pts table
		for (int gid2 = 0; gid2 < gfo; gid2 ++) {
			int h = uH[gid2];
			int l = uL[gid2];
			switch(uO[gid2]) {
			case 0:
				pts[h][l] = 0;
				pts[l][h] = 3;
				break;
			case 1:
				pts[h][l] = 1;
				pts[l][h] = 1;
				break;
			case 2:
				pts[h][l] = 3;
				pts[l][h] = 0;
				break;
			}
		}
		
		// sum up t points
		int tSum = 0;
		for (int i = 0; i < pts.length; i ++) {
			tSum += pts[team - 1][i];
		}
		
		// for team u != t
			// if pts[u] >= pts[t]
				// return 0
		for (int u = 0; u < 4; u ++) {
			if (u == team - 1) {
				continue;
			}
			
			int uSum = 0;
			for (int i = 0; i < pts.length; i ++) {
				uSum += pts[u][i];
			}
			
			if (uSum >= tSum) {
				return 0;
			}
		}
		
		// return 1
		return 1;
	}
	
}
