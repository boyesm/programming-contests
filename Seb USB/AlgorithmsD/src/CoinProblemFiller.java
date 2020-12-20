import java.io.*;

public class CoinProblemFiller {

	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		File f = new File("input.txt");
		PrintWriter out = new PrintWriter(f);
		for (int i = 0; i < 1000; i ++) {
			out.println(i + 1);
		}
 		out.close();
	}

}
