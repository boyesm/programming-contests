package s2016;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main run = new Main();
		run.q4();
	}
	
	Scanner sc = new Scanner(System.in);
	
	void q4() {
		int n = sc.nextInt();
		int[] rBalls = new int[n];
		for (int i = 0; i < n; i ++) {
			rBalls[i] = sc.nextInt();
		}

		rSums = new int[n][n];
		for (int i = 0; i < rBalls.length; i ++) {
			int cSum = 0;
			for (int j = i; j < rBalls.length; j ++) {
				cSum += rBalls[j];
				rSums[i][j] = cSum;
			}
		}

		for (int l = 0; l < rBalls.length; l ++) {
			for (int j = l; j < rBalls.length; j ++) {
				String key = Integer.toString(j) + "." + Integer.toString(rSums[l][j]);
				ls.put(key, l);
			}
		}
	
		int max = 0;
		int prevJ = -1;
		for (int i = 0; i < rBalls.length; i ++) {
			for (int j = rBalls.length - 1; j > prevJ && j >= i; j --) {
				if (sumIfMergeable(rBalls, i, j) > 0) {
					prevJ = j;
					if (rSums[i][j] > max) {
						max = rSums[i][j];
					}
				}
			}
		}
		System.out.println(max);
	}
	
	int[][] rSums;
	HashMap<String, Integer> ls = new HashMap<String, Integer>();
	HashMap<String, Integer> merMemo = new HashMap<String, Integer>();
	
	int sumIfMergeable(int[] rBalls, int i, int j) {
		String key = Integer.toString(i) + "." + Integer.toString(j);
		if (merMemo.containsKey(key)) {
			return merMemo.get(key);
		}
		
		if (j <= i) {
			merMemo.put(key, rSums[i][j]);
			return rSums[i][j];
		}
		
		for (int k = i; rSums[i][k] <= rSums[i][j] / 2; k ++) {
			String leKey = Integer.toString(j) + "." + Integer.toString(rSums[i][k]);
			if (ls.containsKey(leKey)) {
				int l = ls.get(leKey);
				int r1 = sumIfMergeable(rBalls, i, k);
				int r2 = sumIfMergeable(rBalls, k + 1, l - 1);
				int r3 = sumIfMergeable(rBalls, l, j);
				if (r1 != -1 && r2 != -1 && r3 != -1) {
					merMemo.put(key, rSums[i][j]);
					return rSums[i][j];
				}
			}
		}
		
		merMemo.put(key, -1);
		return -1;
	}
	
	void q2v1() {
		int qType = sc.nextInt();
		int n = sc.nextInt();
		
		ArrayList<Integer> d = new ArrayList<Integer>();
		ArrayList<Integer> p = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i ++) {
			d.add(sc.nextInt());
		}
		for (int i = 0; i < n; i ++) {
			p.add(sc.nextInt());
		}
		
		if (qType == 1) {
			Collections.sort(d);
			Collections.sort(p);
		} else {
			Collections.sort(d);
			Collections.reverse(d);
			Collections.sort(p);
		}
		
		int total = 0;
		
		for (int i = 0; i < n; i ++) {
			int a = d.get(i);
			int b = p.get(i);
			
			if (a > b) {
				total += a;
			} else {
				total += b;
			}
		}
		
		System.out.println(total);
	}
	
	void q1v1() {
		String a = sc.nextLine();
		String b = sc.nextLine();
		
		boolean anagram = true;
		
		ArrayList<Character> c = new ArrayList<Character>();
		ArrayList<Character> d = new ArrayList<Character>();
		
		for (int i = 0; i < a.length(); i ++) {
			c.add(a.charAt(i));
		}
		for (int i = 0; i < b.length(); i ++) {
			d.add(b.charAt(i));
		}
		
		for (int i = 0; i < c.size(); i ++) {
			if (d.contains(c.get(i))) {
				d.remove(d.indexOf(c.get(i)));
			} else {
				if (d.contains('*')) {
					d.remove(d.indexOf('*'));
				} else {
					anagram = false;
					break;
				}
			}
		}
		
		System.out.println(anagram);
	}

}
