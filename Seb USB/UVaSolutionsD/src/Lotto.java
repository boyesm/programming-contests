import java.util.*;

public class Lotto {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = -1;
		for (;n != 0;) {
			n = sc.nextInt();
			if (n == 0) {
				break;
			}
			// make an array of the set with size n
			int[] nums = new int[n];
			for (int i = 0; i < n; i ++) {
				nums[i] = sc.nextInt();
			}
			
			// generate and print all combinations of the set with size 6
			comb(nums, 0);
			System.out.println();
		}
	}
	
	static ArrayList<Integer> c = new ArrayList<Integer>();
	
	static void comb(int[] nums, int ind) {
//		System.out.print("[" + ind + "." + c);
		
		if (c.size() == 6) {
			// print comb
			for (int i : c) {
				System.out.print(i + " ");
			}
			System.out.println();
//			System.out.println("a]");
			return;
		}
		
		if (6 - c.size() > nums.length - ind) {
//			System.out.println("b]");
			return;
		}
		c.add(nums[ind]);
		comb(nums, ind + 1);
		c.remove(c.size() - 1);
		comb(nums, ind + 1);
//		System.out.println("c]");
		return;
	}

}
