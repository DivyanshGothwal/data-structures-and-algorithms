package src;

import java.util.ArrayList;
import java.util.List;

public class ConstructBinaryPalindromeByRepeatedAppendingAndTrimming {

	static void dfs(int parent, int ans[], List<Integer> connectchars[]) {
		ans[parent] = 1;

		for (int i = 0; i < connectchars[parent].size(); i++) {
			if (ans[connectchars[parent].get(i)] != 1)
				dfs(connectchars[parent].get(i), ans, connectchars);
		}
	}

	static void printBinaryPalindrome(int n, int k) {
		int[] arr = new int[n];
		int[] ans = new int[n];

// link which digits must be equal 
		List<Integer>[] connectchars = new ArrayList[k];
		for (int i = 0; i < k; i++)
			connectchars[i] = new ArrayList<>();
		for (int i = 0; i < n; i++)
			arr[i] = i % k;

		for (int i = 0; i < n / 2; i++) {
			connectchars[arr[i]].add(arr[n - i - 1]);
			connectchars[arr[n - i - 1]].add(arr[i]);
		}

		dfs(0, ans, connectchars);

		for (int i = 0; i < n; i++)
			System.out.print(ans[arr[i]]);
	}

	public static void main(String[] args) {
		int n = 7;
		int k = 4;
		printBinaryPalindrome(n, k);
	}
}

//[0,1,2,3,0,1,2]
//0->2
//1->1
//2->0
//3

//1010101