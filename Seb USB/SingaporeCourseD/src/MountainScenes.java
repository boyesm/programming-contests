import java.util.*;

public class MountainScenes {

	public static void main(String[] args) {
		MountainScenes run = new MountainScenes();
		
		Scanner sc = new Scanner(System.in);
		int rLength = sc.nextInt();
		int rWidth = sc.nextInt();
		int height = sc.nextInt();
		
		int numW = run.diffL(height, rWidth, rLength, Integer.MIN_VALUE);
		System.out.println(numW);
	}
	
	HashMap<String, Integer> memo = new HashMap<String, Integer>();

	int diffL(int height, int rWidth, int rLength, int lvl) {
		String k = Integer.toString(rWidth) + "." + Integer.toString(rLength) + "." + Integer.toString(lvl);
		if (memo.containsKey(k)) {
			return memo.get(k);
		}
		
		if (rWidth == 0) {
			if (lvl == -1) {
				return 1;
			}
			return 0;
		}
		if (rLength == 0) {
			if (lvl == -1) {
				return 1;
			}
			return 0;
		}
		
		int cap = height > rLength ? rLength : height;
		int conf = 0;
		for (int i = 0; i <= cap; i ++) {
			int dLvl = lvl;
			if (dLvl == Integer.MIN_VALUE) {
				dLvl = i;
			}
			if (i != dLvl) {
				conf += diffL(height, rWidth - 1, rLength - i, -1);
			} else {
				conf += diffL(height, rWidth - 1, rLength - i, dLvl);
			}	
		}
		
		memo.put(k, conf);
		return conf;
	}

}
