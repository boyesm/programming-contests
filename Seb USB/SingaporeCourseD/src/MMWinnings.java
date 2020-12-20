import java.util.*;

public class MMWinnings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MMWinnings run = new MMWinnings();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] conf = new int[n][n];
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				conf[i][j] = sc.nextInt();
			}
		}
		int rem = sc.nextInt();
		
		int[] mm = run.mmFig(conf, 0, rem);
		System.out.println(mm[1] + " " + mm[0]);
	}
	
	HashMap<String, int[]> memo = new HashMap<String, int[]>();
	
	int[] mmFig(int[][] conf, int lvl, int rem) {
		String k = Integer.toString(lvl) + "." + Integer.toString(rem);
		if (memo.containsKey(k)) {
			return memo.get(k);
		}
		
		if (rem == 0) {
			int[] noTurn = {0, 0};
			return noTurn;
		}
		
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < conf.length; i ++) {
			int[] res = mmFig(conf, i, rem - 1);
			int currV = conf[lvl][i];
			if (currV + res[0] < min) {
				min = currV + res[0];
			}
			if (currV + res[1] > max) {
				max = currV + res[1];
			}
		}
		int[] ret = new int[2];
		ret[0] = min;
		ret[1] = max;
		memo.put(k, ret);
		return ret;
	}

}
