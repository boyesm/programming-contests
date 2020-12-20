import java.util.*;

public class DPPathsinaGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DPPathsinaGrid run = new DPPathsinaGrid();
		int[][] grid = 
			{{3, 7, 9, 2, 7},
			{9, 8, 3, 5, 5},
			{1, 7, 9, 8, 5},
			{3, 8, 6, 4, 10},
			{6, 3, 9, 7, 8}};
		System.out.println(run.topDown(0, 0, grid));
	}
	
	HashMap<String, Integer> memo = new HashMap<String, Integer>();
	
	int topDown(int x, int y, int[][] grid) {
		String k = Integer.toString(x) + "." + Integer.toString(y);
		if (memo.containsKey(k)) {
			return memo.get(k);
		}
		
		if (x == grid[grid.length - 1].length - 1 && y == grid.length - 1) {
			return grid[y][x];
		}
		
		int rR = 0;
		int rD = 0;
		if (x < grid[y].length - 1) {
			rR = topDown(x + 1, y, grid);
		}
		if (y < grid.length - 1) {
			rD = topDown(x, y + 1, grid);
		}
		
		int res = Integer.max(rR, rD) + grid[y][x];
		memo.put(k, res);
		return res;
	}
}
