package s2015;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Main run = new Main();
		run.q1v1();
	}
	
	Scanner sc = new Scanner(System.in);
	
	void q1v1() {
		int n = sc.nextInt();
		ArrayList<Integer> digs = new ArrayList<Integer>();
		for (int i = 0; i < n; i ++) {
			digs.add(sc.nextInt());
		}
		
		for (int i = 0; i < digs.size(); i ++) {
			if (digs.get(i) == 0) {
				digs.remove(i - 1);
				digs.remove(i - 1);
				i -= 2;
			}
		}
		
		int sum = digs.stream().mapToInt(x -> x).sum();
		System.out.println(sum);
	}

}
