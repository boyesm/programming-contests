import java.util.*;

public class Continents {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// input
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		char[][] map = new char[N][M];
		
		for (int i = 0; i < N; i ++) {
			String line = sc.next();
			for (int j = 0; j < M; j ++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		int pX = sc.nextInt();
		int pY = sc.nextInt();
		
		// fill the area already conquered
		Buff fringe = new Buff(N * M + 1);
		int sNode = pX * N * M + pY;
		fringe.enq(sNode);
		map[pY][pX] = 'w';
		
		while (!fringe.empty()) {
			int cNode = fringe.deq();
			int cX = cNode / (N * M);
			int cY = cNode % (N * M);
			
			// check all 4 directions for neighbouring nodes
			if (map[cY][(cX - 1) % M] == 'l') {
				map[cY][(cX - 1) % M] = 'w';
				fringe.enq(((cX + 1) % M) * N * M + cY);
			}
			if (map[cY][(cX + 1) % M] == 'l') {
				map[cY][(cX + 1) % M] = 'w';
				fringe.enq(((cX + 1) % M) * N * M + cY);
			}
			if (map[(cY - 1) % M][cX] == 'l') {
				map[(cY - 1) % M][cX] = 'w';
				fringe.enq(cX * N * M + ((cY - 1) % M));
			}
			if (map[(cY + 1) % M][cX] == 'l') {
				map[(cY + 1) % M][cX] = 'w';
				fringe.enq(cX * N * M + ((cY + 1) % M));
			}
		}
		
		// move across map to find the largest area
		
		int max = -1;
		for (int i = 0; i < map.length; i ++) {
			for (int j = 0; j < map[0].length; j ++) {
				if (map[i][j] == 'l') {
					Buff fringeA = new Buff(N * M + 1);
					int sNodeA = j * N * M + i;
					fringeA.enq(sNodeA);
					
					int area = 0;
					
					while (!fringeA.empty()) {
						int cNode = fringeA.deq();
						int cX = cNode / (N * M);
						int cY = cNode % (N * M);
						
						// check all 4 directions for neighbouring nodes
						if (map[cY][(cX - 1) % M] == 'l') {
							map[cY][(cX - 1) % M] = 'w';
							fringeA.enq(((cX + 1) % M) * N * M + cY);
							area ++;
						}
						if (map[cY][(cX + 1) % M] == 'l') {
							map[cY][(cX + 1) % M] = 'w';
							fringeA.enq(((cX + 1) % M) * N * M + cY);
							area ++;
						}
						if (map[(cY - 1) % M][cX] == 'l') {
							map[(cY - 1) % M][cX] = 'w';
							fringeA.enq(cX * N * M + ((cY - 1) % M));
							area ++;
						}
						if (map[(cY + 1) % M][cX] == 'l') {
							map[(cY + 1) % M][cX] = 'w';
							fringeA.enq(cX * N * M + ((cY + 1) % M));
							area ++;
						}
					}
					
					if (area > max) {
						max = area;
					}
				}
			}
		}
		
		System.out.println(max);
	}
	
	static class Buff {
		int[] els;
		int fi = 0, fe = 0;
		int cap;
		
		Buff(int cap) {
			this.cap = cap;
			els = new int[cap];
		}
		
		boolean empty() {
			return fi == fe;
		}
		
		void enq(int el) {
			els[fe] = el;
			fe = (fe + 1) % cap;
		}
		
		int deq() {
			int ret = els[fi];
			fi = (fi + 1) % cap;
			return ret;
		}
	}
}
