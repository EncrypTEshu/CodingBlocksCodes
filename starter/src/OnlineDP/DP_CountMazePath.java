package OnlineDP;

public class DP_CountMazePath {
	public static long start;
	public static long end;

	public static void startalgo() {
		start = System.currentTimeMillis();
	}

	public static long endalgo() {
		end = System.currentTimeMillis();
		return end - start;
	}

	public static void main(String[] args) {
		int n=2;
		long strg[][]=new long[n+1][n+1];
		startalgo();
	
		System.out.println(countMazePath(n, n, 0, 0));
		System.out.println("Time taken by normal recursion " + endalgo()+ " ms");
		startalgo();
		System.out.println(countMazePathRS(n, n, 0, 0,strg));
		System.out.println("Time taken by normal recursion " + endalgo() + " ms");
	}

	public static long countMazePath(int er, int ec, int cc, int cr) {
		if (cr == er || ec == cc) {
			return 1;
		}
		if (cc == ec && cr == er) {
			return 0;
		}
		long counter = 0;
		counter += countMazePath(er, ec, cc + 1, cr);
		counter += countMazePath(er, ec, cc, cr + 1);
	return counter;
	}
	public static long countMazePathRS(int er, int ec, int cc, int cr,long[][] strg) {
		if (cr == er || ec == cc) {
			return 1;
		}
		if (cc == ec && cr == er) {
			return 0;
		}
		long counter = 0;
		if(strg[cr][cc]!=0) {
			return strg[cc][cr];
		}
		counter += countMazePathRS(er, ec, cc + 1, cr,strg);
		counter += countMazePathRS(er, ec, cc, cr + 1,strg);
		strg[cc][cr]=counter;
	return counter;
	}
}
