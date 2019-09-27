package src;

import java.util.Arrays;
import java.util.List;

// problem explained: https://www.geeksforgeeks.org/split-the-given-array-into-k-sub-arrays-such-that-maximum-sum-of-all-sub-arrays-is-minimum/

public class MinimumOfMaximumSumSubArray {
	public static void main(String ar[]) {
		List<Integer> a = Arrays.asList(1, 1, 1, 15, 4, 16);
		int maxSubArrayPossible = 3;
		calculateMinimumOfMaxSumSubArray(a, maxSubArrayPossible);
	}

	private static void calculateMinimumOfMaxSumSubArray(List<Integer> ar, int k) {
		Integer max = Integer.MIN_VALUE;
		int maxSum = ar.stream().reduce(0, (acc, ele) -> {

			return acc + ele;
		});
		for (int i = 0; i < ar.size(); i++) {
			if (ar.get(i) > max) {
				max = ar.get(i);
			}
		}
		int ans = 0;
		int start = 1, end =maxSum;
		while(start<=end) {
			int mid = (start+end)/2;
			System.out.println(start+" "+mid+" "+" "+end);
			if(isPossibleForSum(ar,mid,k)) {
				end = mid-1;

				ans = mid;
			}
			else {
				start = mid+1;
		}
		}
		System.out.println(ans);
	}
	private static boolean isPossibleForSum (List<Integer> ar, int mid, int k) {
		int noOfPartitionsPossible = 1;
		int sum = 0;
		for(int i=0;i<ar.size();i++) {
			sum+=ar.get(i);
			if(sum>mid) {
				noOfPartitionsPossible++;
				sum=ar.get(i);
			}
		}
		if(noOfPartitionsPossible<=k) {
			return true;
		}
		return false;
	}
}
