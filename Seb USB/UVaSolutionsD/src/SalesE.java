import java.util.*;

public class SalesE {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * get next integer
		 * find its position in a sorted array
		 * get number of items lower than it
		 * add that number to array
		 */
		int t = sc.nextInt();
		for (int k = 0; k < t; k ++) {
			int n = sc.nextInt();
			ArrayList<Integer> sortedSales = new ArrayList<Integer>();
			int[] betterThan = new int[n - 1];
			
			for (int i = 0; i < n; i ++) {
				int cInt = sc.nextInt();
				int loE = Collections.binarySearch(sortedSales, cInt);
				
				if (loE < 0) {
					loE = Math.abs(loE) - 1;
				} else {
					loE += 2;
				}
				
				sortedSales.add(cInt);
				if (i > 0) {
					betterThan[i - 1] = loE;
				}
			}
			
			int sum = 0;
			for (int i : betterThan) {
				sum += i;
			}
			
			System.out.println(sum);
		}
	}

}
