package debug;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main run = new Main();
		run.lambda();
	}
	
	void lambda () {
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(1);
		test.add(2);
		test.add(3);
		
		test.stream()
			.map(n -> {
				System.out.println(n);
				return n * n;
			})
			.peek(System.out::println)
			.collect(Collectors.toList());
	}

}
