import java.util.*;

public class ConstrainedChoice {

	public static void main(String[] args) {
		ConstrainedChoice run = new ConstrainedChoice();
		
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		char[][] map = new char[y][x];
		for (int i = 0; i < map.length; i ++) {
			String line = sc.next();
			for (int j = 0; j < map[i].length; j ++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		System.out.println(run.fPath(map, 0, map.length - 1, -1));
	}
	
	HashMap<String, Integer> memo = new HashMap<String, Integer>();
	
	int fPath(char[][] map, int x, int y, int dFrom) {
		String k = Integer.toString(x) + "." + Integer.toString(y) + "." + Integer.toString(dFrom);
		if (memo.containsKey(k)) {
			return memo.get(k);
		}
		
		if (x == map[y].length - 1 && y == 0) { // found a config
			return 1;
		}
		int r1 = 0;
		int r2 = 0;
		int r3 = 0;
		if (x < map[y].length - 1) { // go right
			if (map[y][x + 1] != '#') { // able to go right
				r1 = fPath(map, x + 1, y, 3);
			}
		}
		if (y > 0 && dFrom != 0) { // go up
			if (map[y - 1][x] != '#') {
				r2 = fPath(map, x, y - 1, 2);
			}
		}
		if (y < map.length - 1 && dFrom != 2) {
			if (map[y + 1][x] != '#') {
				r3 = fPath(map, x, y + 1, 0);
			}
		}
		
		int res = 0;
		if (r1 == 0 && r2 == 0 & r3 == 0) {
			res = 0;
		} else {
			res = r1 + r2 + r3;
		}
		memo.put(k, res);
		return res;
	}

}
