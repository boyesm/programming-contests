package s2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main run = new Main();
		run.q4();
	}
	
	Scanner sc = new Scanner(System.in);
	
	void q4() {
		int N = sc.nextInt();
		int M = sc.nextInt();
		int D = sc.nextInt();
		
		ArrayList<ArrayList<Integer>> pEdges = new ArrayList<ArrayList<Integer>>();
		
		// add a condition for the edge
		for (int i = 0; i < M; i ++) {
			ArrayList<Integer> cEdge = new ArrayList<Integer>();
			cEdge.add(sc.nextInt());
			cEdge.add(sc.nextInt());
			cEdge.add(sc.nextInt());
			if (i < N - 1) {
				cEdge.add(1);
			} else {
				cEdge.add(0);
			}
			pEdges.add(cEdge);
		}
		
		ArrayList<Integer> days = new ArrayList<Integer>();
		
		for (int h = 0; h < N; h ++) {
			// subtract d from an edge
			ArrayList<Integer> dEdge = pEdges.get(h);
			int weightI = dEdge.get(2);
			int weight = dEdge.get(2);
			if (weight >= D) {
				weight -= D;
			} else {
				weight = 0;
			}
			dEdge.set(2, weight);
			pEdges.set(h, dEdge);
			
			// sort the edges
			Collections.sort(pEdges, new Comparator<ArrayList<Integer>>() {
				@Override
				public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
					if (a.get(2) > b.get(2)) {
						return 1;
					} else if (a.get(2) < b.get(2)) {
						return -1;
					} else {
						if (a.get(3) == 1 && b.get(3) == 0) {
							return -1;
						} else if (a.get(3) == 0 && b.get(3) == 1) {
							return 1;
						} else {
							return 0;
						}
					}
			    }
			});
			
			int[] ptr = new int[N];
			int[] mxd = new int[N]; // maximum depth
			Arrays.fill(ptr, -1);
			Arrays.fill(mxd, 0);
			ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
			
			for (int i = 0; edges.size() < N; i ++) {
				// pick an edge
				ArrayList<Integer> cEdge = pEdges.get(i);
				int v0 = cEdge.get(0) - 1;
				int v1 = cEdge.get(1) - 1;
				
				// check for cycle
				int r0 = findRoot(v0, ptr);
				int r1 = findRoot(v1, ptr);
				
				ArrayList<Integer> edge = new ArrayList<Integer>();
				edge.add(v0);
				edge.add(v1);
				edge.add(cEdge.get(2));
				edge.add(cEdge.get(3));
				
				if (r0 != r1) {
					// add it
					edges.add(edge);
					// figure which root has a bigger max depth
					if (mxd[r0] > mxd[r1]) {
						ptr[r1] = r0;
					} else if (mxd[r0] < mxd[r1]) {
						ptr[r0] = r1;
					} else { // equal depth
						mxd[r0] ++;
						ptr[r1] = r0;
					}
				}
			}
			
			dEdge.set(2, weightI);
			pEdges.set(h, dEdge);
			
			// get the number of days
			int cDays = 0;
			for (ArrayList<Integer> i : edges) {
				if (i.get(3) == 0) {
					cDays ++;
				}
			}
			days.add(cDays);
		}
		
		// sort the edges
		Collections.sort(pEdges, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
				if (a.get(2) > b.get(2)) {
					return 1;
				} else if (a.get(2) < b.get(2)) {
					return -1;
				} else {
					if (a.get(3) == 1 && b.get(3) == 0) {
						return -1;
					} else if (a.get(3) == 0 && b.get(3) == 1) {
						return 1;
					} else {
						return 0;
					}
				}
		    }
		});
		
		int[] ptr = new int[N];
		int[] mxd = new int[N]; // maximum depth
		Arrays.fill(ptr, -1);
		Arrays.fill(mxd, 0);
		ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; edges.size() != (N - 1); i ++) {
			// pick an edge
			ArrayList<Integer> cEdge = pEdges.get(i);
			int v0 = cEdge.get(0) - 1;
			int v1 = cEdge.get(1) - 1;
			
			// check for cycle
			int r0 = findRoot(v0, ptr);
			int r1 = findRoot(v1, ptr);
			
			ArrayList<Integer> edge = new ArrayList<Integer>();
			edge.add(v0);
			edge.add(v1);
			edge.add(cEdge.get(2));
			edge.add(cEdge.get(3));
			
			if (r0 != r1) {
				// add it
				edges.add(edge);
				// figure which root has a bigger max depth
				if (mxd[r0] > mxd[r1]) {
					ptr[r1] = r0;
				} else if (mxd[r0] < mxd[r1]) {
					ptr[r0] = r1;
				} else { // equal depth
					mxd[r0] ++;
					ptr[r1] = r0;
				}
			}
		}
		
		// get the number of days
		int cDays = 0;
		for (ArrayList<Integer> i : edges) {
			if (i.get(3) == 0) {
				cDays ++;
			}
		}
		days.add(cDays);
		
		int minDays = Collections.min(days);
		System.out.println(minDays);
	}
	
	int findRoot(int v, int[] arr) {
		if (arr[v] == -1) {
			return v;
		} else {
			return findRoot(arr[v], arr);
		}
	}
	
	void q2v4() {
		int n = sc.nextInt();
		ArrayList<Integer> input = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i ++) {
			input.add(sc.nextInt());
		}
		
		Collections.sort(input);
		
		int lp, hp = 0;
		if (n % 2 == 0) {
			lp = n / 2 - 1;
		} else {
			lp = n / 2;
		}
		hp = n - lp;
		
		for (;lp >= 0 && hp < n;) {
			System.out.print(input.get(lp --) + " ");
			System.out.print(input.get(hp ++) + " ");
		}
		
		if (n % 2 == 1) {
			System.out.println(input.get(0));
		}
	}
	
	void q2v3() {
		int n = sc.nextInt();
		ArrayList<Integer> input = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i ++) {
			input.add(sc.nextInt());
		}
		
		Collections.sort(input);
		
		int fl = 0;
		if (n % 2 == 0) {
			fl = n / 2 - 1;
		} else {
			fl  = n / 2;
		}
		
		int jumpsz = 1;
		for (int i = fl; i >= 0 && i < n;) {
			System.out.print(input.get(i) + " ");
			i += jumpsz;
			if (jumpsz > 0) {
				jumpsz = - (jumpsz + 1);
			} else {
				jumpsz = - (jumpsz - 1);
			}
		}
	}
	
	void q2v2() {
		int n = sc.nextInt();
		ArrayList<Integer> input = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i ++) {
			input.add(sc.nextInt());
		}
		
		Collections.sort(input);
		
		int fl = 0;
		if (n % 2 == 0) {
			fl = (n / 2) - 1;
		} else {
			fl = n / 2;
		}
		
		int lp, hp = 0;
		for (int i = 0; i < n; i ++) {
			if (i % 2 == 0) {
				lp = fl - (i / 2);
				if (i == n - 1) {
					System.out.print(input.get(lp));
				} else {
					System.out.print(input.get(lp) + " ");
				}
			} else {
				hp = fl + (i / 2) + 1;
				if (i == n - 1) {
					System.out.print(input.get(hp));
				} else {
					System.out.print(input.get(hp) + " ");
				}
			}
		}
	}
	
	void q2v1() {
		int n = sc.nextInt();
		ArrayList<Integer> input = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i ++) {
			input.add(sc.nextInt());
		}
		
		Collections.sort(input);
		
		int mid;
		if (n % 2 == 0) {
			mid = n / 2;
		} else {
			mid = (n / 2) + 1;
		}
		ArrayList<Integer> lt = new ArrayList<Integer>(input.subList(0, mid));
		ArrayList<Integer> ht = new ArrayList<Integer>(input.subList(mid, n));
		
		Collections.reverse(lt);
		
		int hp = 0;
		int lp = 0;
		for (int i = 0; i < n; i ++) {
			if (i % 2 == 0) {
				System.out.print(lt.get(lp) + " ");
				lp ++;
			} else {
				if (i == n - 1) {
					System.out.print(ht.get(hp));
				} else {
					System.out.print(ht.get(hp) + " ");
				}
				hp ++;
			}
		}
	}
	
	void hello() {
		String[] arr = { "xxx", "cd", "ab", "z" };
		Arrays.sort(arr, new Comparator<String>() {
		    @Override public int compare(String s1, String s2) {
		        //return s1.length() - s2.length();
		    	return s1.compareTo(s2);
		    }
		});
		ArrayList<String> sample = new ArrayList<String>();
		sample.add("c");
		sample.add("ed");
		sample.add("atg");
		sample.add("ddfghyte");
		sample.add("bd");
		sample.add("fgtr");
		Collections.sort(sample, Comparator.comparing((String s) -> s.length()));
		System.out.println(sample);
	}
	
	void q1v2() {
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		
		for (int i = 0; i < n; i ++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i ++) {
			b[i] = sc.nextInt();
		}
		
		int sumA = 0;
		int sumB = 0;
		Integer[] eq = new Integer[n];
		
		for (int i = 0; i < n; i ++) {
			sumA += a[i];
			sumB += b[i];
			
			if (sumA == sumB) {
				eq[i] = i + 1;
			} else {
				eq[i] = 0;
			}
		}
		
		//Arrays.sort(eq, Comparator.comparing((Integer x) -> x));
		
		Arrays.sort(eq, new Comparator<Integer>() {
			@Override
			public int compare(Integer x, Integer y) {
				return x == y ? 0 : x > y ? 1 : -1;
			}
		});

		int fin = eq[eq.length - 1];
		System.out.println(fin);
	}
	
	void q1v1() {
		int n = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i ++) {
			a.add(sc.nextInt());
		}
		for (int i = 0; i < n; i ++) {
			b.add(sc.nextInt());
		}
		
		int sumA = 0;
		int sumB = 0;
		ArrayList<Integer> eq = new ArrayList<Integer> ();
		
		for (int i = 0; i < n; i ++) {
			sumA += a.get(i);
			sumB += b.get(i);
			
			if (sumA == sumB) {
				eq.add(i + 1);
			}
		}
		
		int big;
		
		if (eq.isEmpty()) {
			big = 0;
		} else {
			big = Collections.max(eq);
		}
		
		System.out.println(big);
	}

}
