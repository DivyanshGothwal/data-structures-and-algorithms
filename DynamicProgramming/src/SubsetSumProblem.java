package src;

public class SubsetSumProblem {

	public static void main(String[] args) {
		int arr[] = { 3,34,4,12,5,2 };
		int sum = 48;
		System.out.println(coinChange(arr, sum));
	}

	public static Boolean coinChange(int[] a, int sum) {
		int n = a.length;
		Boolean[][] sol = new Boolean[n][sum + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (j == 0 && j<i) {
					sol[i][j] = false;
					continue;
				}
				if (j == a[i]) {
					sol[i][j] = true;
					continue;
				}
				sol[i][j] = (i - 1 >= 0 ? sol[i - 1][j] : false) || (j - a[i] >= 0 && i - 1 >= 0 ? sol[i-1][j - a[i]] : false);
			}
		}
		return sol[n - 1][sum];
	}

}
