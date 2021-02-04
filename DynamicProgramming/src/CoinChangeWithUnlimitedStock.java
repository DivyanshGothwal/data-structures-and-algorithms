package src;

public class CoinChangeWithUnlimitedStock {

	public static void main(String[] args) {
		int arr[] = { 2, 3,4,6,15 };
		int sum = 20;
		System.out.println(coinChange(arr, sum));
	}

	public static Integer coinChange(int[] a, int sum) {
		int n = a.length;
		int[][] sol = new int[n][sum + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (j == 0) {
					sol[i][j] = 1;
					continue;
				}
				sol[i][j] = (i - 1 >= 0 ? sol[i - 1][j] : 0) + (j - a[i] >= 0 ? sol[i][j - a[i]] : 0);
			}
		}
		return sol[n - 1][sum];
	}
}