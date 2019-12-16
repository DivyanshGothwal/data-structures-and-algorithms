package src;

import java.util.*;

public class LargestMultipleOf3Dp {

	public static void main(String ar[]) {
		int a[] = { 2, 8, 1, 7, 6, 0, 5 };
		findMaxElement(a);
	}

	public static void findMaxElement(int a[]) {
		int n = a.length;
		int sum = Arrays.stream(a).reduce(0, (b, c) -> b + c);
		int dp[][] = new int[n + 1][sum + 1];
		for (int j = 1; j <= sum; j++) {
			for (int i = 1; i <= n; i++) {
				if(a[i-1]==j)
					dp[i][j]=1;
				if(j-a[i-1]>=0 && dp[i-1][j-a[i-1]]!=0) {
						dp[i][j]+=(dp[i-1][j]+dp[i-1][j-a[i-1]]);
				}
				else if(dp[i-1][j]!=0) {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		System.out.println(dp);
	}
}
