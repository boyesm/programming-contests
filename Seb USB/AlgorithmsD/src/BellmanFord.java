import java.util.*;

public class BellmanFord {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// input
		int n = sc.nextInt();
		
		ArrayList<ArrayList<Integer>> ners = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> weights = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < n; i ++) {
			int m = sc.nextInt();
			ArrayList<Integer> cNers = new ArrayList<Integer>();
			ArrayList<Integer> cWeights = new ArrayList<Integer>();
			for (int j = 0; j < m; j ++) {
				cNers.add(sc.nextInt());
				cWeights.add(sc.nextInt());
			}
			ners.add(cNers);
			weights.add(cWeights);
		}
		
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		
		// alg
		for (int i = 0; i < ners.size() - 1; i ++) {
			for (int j = 0; j < ners.size(); j ++) {
				for (int k = 0; k < weights.get(j).size(); k ++) {
					int tar = ners.get(j).get(k);
					dist[tar] = Integer.min(dist[tar], dist[j] + weights.get(j).get(k));
				}
			}
		}
		
		for (int i : dist) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
