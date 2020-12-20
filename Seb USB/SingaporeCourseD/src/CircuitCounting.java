import java.util.HashMap;

public class CircuitCounting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircuitCounting run = new CircuitCounting();
		int[][] vectors = {{1, 2}, {1, 1}, {-1, -2}, {-2, -3}, {-1, -1}};
		System.out.println(run.dp(vectors, 0, 0, 0) - 1);
	}
	
	HashMap<String, Integer> memo = new HashMap<String, Integer>();
	
	int dp (int[][] vectors, int sumX, int sumY, int ind) {
		String k = Integer.toString(sumX) + "." + Integer.toString(sumY) + "." + Integer.toString(ind);
		
		if (memo.containsKey(k)) {
			return memo.get(k);
		}
		
		if (sumX == 0 && sumY == 0 && ind == vectors.length) {
			return 1;
		}
		
		if (ind == vectors.length) {
			return 0;
		}
		
		int r1 = dp(vectors, sumX + vectors[ind][0], sumY + vectors[ind][1], ind + 1);
		int r2 = dp(vectors, sumX, sumY, ind + 1);
		int res = r1 + r2;
		
		memo.put(k, res);
		return res;
	}

}
