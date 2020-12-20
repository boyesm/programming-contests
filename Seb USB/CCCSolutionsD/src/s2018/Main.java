package s2018;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Main run = new Main();
		run.q3();
	}
	
	Scanner sc = new Scanner(System.in);
	
	void q3() {
		// input
		int height = sc.nextInt();
		int width = sc.nextInt();
		char[][] arena = new char[height][width];
		HashMap<Integer, Integer> dist = new HashMap<Integer, Integer>();
		
		int x = -1, y = -1;
		
		for (int i = 0; i < height; i ++) {
			String line = sc.next();
			for (int j = 0; j < width; j ++) {
				arena[i][j] = line.charAt(j);
				
				if (line.charAt(j) == 'S') {
					x = j;
					y = i;
				}
			}
		}
		
		HashSet<Character> conv = new HashSet<Character>();
		conv.add('L');
		conv.add('R');
		conv.add('U');
		conv.add('D');

		// shortest path to each node (if possible) use bfs (unweighted)
		Buff fringe = new Buff(width * height);
		fringe.enq(new II(x, y));
		HashSet<Integer> found = new HashSet<Integer>();
		found.add(x * width * height + y);
		
		int len = 1;
		while (!fringe.empty()) {
			II cNode = fringe.deq();
			
			if (conv.contains(arena[cNode.second][cNode.first])) {
				char d = arena[cNode.second][cNode.first];
				switch (d) {
				case 'U':
					if (arena[nNode.second - 1][nNode.first] != 'W') {
						nNode = new II(nNode.first, nNode.second - 1);
						if (!found.contains(nNode.first * width * height + nNode.second)) {
							// add to found
							// queue node
							fringe.enq(nNode);
							found.add(nNode.first * width * height + nNode.second);
						}
					}
					break;
				case 'R':
					if (arena[nNode.second][nNode.first + 1] != 'W') {
						nNode = new II(nNode.first + 1, nNode.second);
						if (!found.contains(nNode.first * width * height + nNode.second)) {
							// add to found
							// queue node
							fringe.enq(nNode);
							found.add(nNode.first * width * height + nNode.second);
						}
					}
					break;
				case 'D':
					if (arena[nNode.second + 1][nNode.first] != 'W') {
						nNode = new II(nNode.first, nNode.second + 1);
						if (!found.contains(nNode.first * width * height + nNode.second)) {
							// add to found
							// queue node
							fringe.enq(nNode);
							found.add(nNode.first * width * height + nNode.second);
						}
					}
					break;
				case 'L':
					if (arena[nNode.second][nNode.first - 1] != 'W') {
						nNode = new II(nNode.first - 1, nNode.second);
						if (!found.contains(nNode.first * width * height + nNode.second)) {
							// add to found
							// queue node
							fringe.enq(nNode);
							found.add(nNode.first * width * height + nNode.second);
						}
					}
					break;
				}
			}
			
			for (int j = 0; j < 4; j ++) {
				// 4 directions
				II nNode;
				
				switch (j) {
				case 0: // up
					nNode = new II(cNode.first, cNode.second - 1);
					if (arena[nNode.second][nNode.first] != 'W') {
						if (!found.contains(nNode.first * width * height + nNode.second)) {
							found.add(nNode.first * width * height + nNode.second);
							// what's in the square
							// check if it's a conveyor
							char d = arena[nNode.second][nNode.first];
							if (conv.contains(d)) {
								// do something
								// check where the conveyor wants to go
							} else {
								// has to be just a dot
								// add to the queue and change the distance
								dist.put(nNode.first * width * height + nNode.second, len);
								fringe.enq(nNode);
							}
						}
					}
					break;
				case 1: // right
					nNode = new II(cNode.first + 1, cNode.second);
					if (arena[nNode.second][nNode.first] != 'W') {
						if (!found.contains(nNode.first * width * height + nNode.second)) {
							found.add(nNode.first * width * height + nNode.second);
							// what's in the square
							// check if it's a conveyor
							if (conv.contains(arena[nNode.second][nNode.first])) {
								// do something
							} else {
								// has to be just a dot
								// add to the queue and change the distance
								dist.put(nNode.first * width * height + nNode.second, len);
								fringe.enq(nNode);
							}
						}
					}
					break;
				case 2: // down
					nNode = new II(cNode.first, cNode.second + 1);
					if (arena[nNode.second][nNode.first] != 'W') {
						if (!found.contains(nNode.first * width * height + nNode.second)) {
							found.add(nNode.first * width * height + nNode.second);
							// what's in the square
							// check if it's a conveyor
							if (conv.contains(arena[nNode.second][nNode.first])) {
								// do something
							} else {
								// has to be just a dot
								// add to the queue and change the distance
								dist.put(nNode.first * width * height + nNode.second, len);
								fringe.enq(nNode);
							}
						}
					}
					break;
				case 3: // left
					nNode = new II(cNode.first - 1, cNode.second);
					if (arena[nNode.second][nNode.first] != 'W') {
						if (!found.contains(nNode.first * width * height + nNode.second)) {
							found.add(nNode.first * width * height + nNode.second);
							// what's in the square
							// check if it's a conveyor
							if (conv.contains(arena[nNode.second][nNode.first])) {
								// do something
							} else {
								// has to be just a dot
								// add to the queue and change the distance
								dist.put(nNode.first * width * height + nNode.second, len);
								fringe.enq(nNode);
							}
						}
					}
					break;
				}
			}
			len ++;
		}
		
		for (int i = 0; i < arena.length; i ++) {
			for (int j = 0; j < arena[i].length; j ++) {
				if (arena[i][j] == '.') {
					II node = new II(j, i);
					if (dist.containsKey(node.first * width * height + node.second)) {
						System.out.println(dist.get(node.first * width * height + node.second));
					} else {
						System.out.println(-1);
					}
				}
			}
		}
	}
	
	static class II implements Comparable {
		int first, second;
		
		II (int first, int second) {
			this.first = first;
			this.second = second;
		}
		
		public boolean equals(II arg0) {
			if (this.first == arg0.first && this.second == arg0.second) {
				return true;
			}
			
			return false;
		}
		
		@Override
		public int compareTo(Object arg0) {
			II a0 = (II) arg0;
			if (this.first > a0.first) {
				return 1;
			} else if (this.first < a0.first) {
				return -1;
			}
			return 0;
		}
		
	}
	
	static class Buff {
		II[] els;
		int fi = 0, fe = 0;
		int cap;
		
		Buff(int cap) {
			this.cap = cap;
			els = new II[cap];
		}
		
		boolean empty() {
			return fi == fe;
		}
		
		void enq(II el) {
			els[fe] = el;
			fe = (fe + 1) % cap;
		}
		
		II deq() {
			II ret = els[fi];
			fi = (fi + 1) % cap;
			return ret;
		}
	}
}
