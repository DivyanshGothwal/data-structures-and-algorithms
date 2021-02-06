package src;

import java.util.Arrays;

public class NumberOfSteps {
	static long dp[] = null;

	public static void main(String[] ar) {
		int n = 90;
		dp = new long[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(countSteps(0, n));
		System.out.println(countStepsItr(0, n));
	}

	public static long countStepsItr(long i, int n) {
		dp = new long[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int j = 2; j <= n; j++) {
			dp[j] = dp[j - 1] + dp[j - 2];
		}
		return dp[n];
	}

	public static long countSteps(int i, int n) {
		if (i == n) {
			return 1;
		}
		if (i > n) {
			return 0;
		}
		long left = 0;
		long right = 0;
		if (i + 1 <= n) {
			if (dp[i + 1] == -1) {
				dp[i + 1] = countSteps(i + 1, n);
			}
			left = dp[i + 1];
		}
		if (i + 2 <= n) {
			if (dp[i + 2] == -1) {
				dp[i + 2] = countSteps(i + 2, n);
			}
			right = dp[i + 2];
		}
		return left + right;
	}
}
