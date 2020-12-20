
public class DPCountingTilings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int topDown() {
		// if memo containsKey r.c.curRow.nextRow
			// return memo get(r.c.curRow.nextRow)
		// r1 = r2 = 0
		// if c <= width - 2 && r <= height - 2
			// if curRow[c] == unFilled
				// nextRow[c] = filled
				// r1 = topDown(r, c + 1, curRow, nextRow) vert
				// nextRow[c] = unFilled
				// r2 = topDown(r, c + 2, curRow, nextRow) horiz
			// else
				// r1 = topDown(r, c + 1, curRow, nextRow)
		// else if c <= width - 1 && r <= height - 2
			// if curRow[c] == unFilled
				// nextRow[c] = filled
				// r1 = topDown(r, c + 1, curRow, nextRow) vert
			// else
				// curRow = nextRow
				// nextRow = new array
				// r1 = topDown(r + 1, 0, curRow, nextRow)
		// else if c <= width - 2
			// if curRow[c] == unFilled
				// r2 = topDown(r, c + 2, curRow, nextRow) horiz
			// else
				// r1 = topDown(r, c + 1, curRow, nextRow)
		// else
			// if curRow[c] == unFilled
				// return 0
			// else
				// return 1
		// res = r1 + r2
		// memo put(r.c.curRow.nextRow, res)
		// return res
		
		return -1;
	}

}
