import java.util.*;

public class IntegerSequenceE {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * No idea q# is 0927
		 */
		
		// read number of cases
		int cases = sc.nextInt();
		for (int a = 0; a < cases; a ++) {
			// read the polynomial
			int deg = sc.nextInt();
			int[] coef = new int[deg + 1];
			for (int i = 0; i <= deg; i ++) {
				coef[i] = sc.nextInt();
			}
			
			// read d
			int d = sc.nextInt();
			
			// read k
			int k = sc.nextInt();
			
			// calculate the root
			int root = (int) Math.ceil((-1 + Math.sqrt(1 + 8 * k)) / (2 * d));
			
			// find the powers
			ArrayList<Integer> powers = new ArrayList<Integer>();
			powers.add(1);
			for (int i = 1; i <= deg; i ++) {
				powers.add(powers.get(powers.size() - 1) * root);
			}
			
			// compute a_n = poly
			int sum = 0;
			for (int i = 0; i <= deg; i ++) {
				sum += coef[i] * powers.get(i);
			}
			
			// print a_n
			System.out.println(sum);
		}
	}

}
