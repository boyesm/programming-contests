import java.util.*;

public class LottoB {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = sc.nextInt();
		int[] pool = new int[n];
		for (int i = 0; i < n; i ++) {
			pool[i] = sc.nextInt();
		}
		
		BitMaskGen cGen = new BitMaskGen();
		cGen.bmFo = 6;
		cGen.selFo = n;
		cGen.caller();
		ArrayList<ArrayList<Integer>> inds = new ArrayList<ArrayList<Integer>>(BitMaskGen.combs);
		
		for (int i = 0; i < inds.size(); i ++) {
			for (int j = 0; j < inds.get(i).size(); j ++) {
				int sw = inds.get(i).get(j);
				if (sw == 1) {
					System.out.print(pool[j] + " ");
				}
			}
			System.out.println();
		}
	}

	
	static class BitMaskGen {
		int bm = 0;
		static int bmFo = -1, selFo = 33;
		static ArrayList<ArrayList<Integer>> combs = new ArrayList<ArrayList<Integer>>();
		static void caller() {
			BitMaskGen bmg = new BitMaskGen();
			
			if (selFo > 32)
			{
				System.out.println("smth bad happened");
				System.exit(0);
			}
			bmg.gen(0, bmFo, 0, selFo);
		}
		void gen(int bmCnt, int bmFo, int selIx, int selFo) {
			if (bmCnt == bmFo) {// completed
//				String bmstr = (new StringBuilder(String.format("%6s", Integer.toBinaryString(bm)).replace(' ',  '0'))).reverse().toString();
//				System.out.println(bmstr);
				ArrayList<Integer> cComb = new ArrayList<Integer>();
				for (int ix = 0; ix < selFo; ix++)
					cComb.add((bm >> ix) & 1);
				combs.add(cComb);
				return;
			}

			if (bmFo - bmCnt > selFo - selIx) {// ran out
				return;
			}
				
			bm = bm | 1 << selIx;
			gen(bmCnt + 1, bmFo, selIx + 1, selFo);
			bm = bm & ~(1 << selIx);
			gen(bmCnt, bmFo, selIx + 1, selFo);
			return;
		}
	}
}
