package src;

public class GoldMineProblemGFG {

	public static void main(String[] args) {
		Integer gold[][] = { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 1, 2 } };
		System.out.println(findMaxGoldCoins(gold, 4, 4));
	}

	public static Integer findMaxGoldCoins(Integer[][] golds, int m, int n) {
		int[][] coins = new int[m][n];

		for (int j = 0; j < n; j++) {
			
			
		for (int i = 0; i < m; i++) {
				int rightLeft = 0;
				int rightTop = 0;
				int right = 0;
				if (j - 1 >= 0) {
					right = coins[i][j - 1];
					rightTop = i + 1 < m ? coins[i + 1][j - 1] : 0;
					rightLeft = i - 1 >= 0 ? coins[i - 1][j - 1] : 0;
				}
				coins[i][j] = Math.max(Math.max(right, rightTop), rightLeft) + golds[i][j];
			}
		}
		int sol = 0;
		for(int i=0;i<m;i++) {
			sol = Math.max(sol,coins[i][n-1]);
		}
		return sol;
	}
}
