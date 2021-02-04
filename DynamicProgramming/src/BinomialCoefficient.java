package src;

public class BinomialCoefficient {

	public static void main(String[] args) {
		int n = 10;
		int k = 4;
		System.out.println(findBinomialCoefficient(n, k));
	}

	public static Integer findBinomialCoefficient(int n, int k) {
		int[][] c = new int[n + 1][k + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				if (j > i) {
					continue;
				}
				if (i == j) {
					c[i][j] = 1;
					continue;
				}
				if (j == 1 || j==0) {
					c[i][j] = i;
					continue;
				}

				c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
			}
		}
		return c[n][k];
	}

}
