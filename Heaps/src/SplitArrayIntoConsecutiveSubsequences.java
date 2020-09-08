package src;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SplitArrayIntoConsecutiveSubsequences {

	public static void main(String ar[]) {
		int a[] = { 1, 2, 3, 3, 4, 4, 5, 5 };
		System.out.println(isPossible(a));
	}

	public static boolean isPossible(int[] nums) {
		return isPossibleUtil(nums);
	}

	public static boolean isPossibleUtil(int[] ar) {
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		int n = ar.length;
		for (int i = 0; i < n; i++) {
			int ele = ar[i];
			PriorityQueue<Integer> pQueue = map.get(ele - 1);
			if (pQueue == null || pQueue.isEmpty()) {
				pQueue = map.get(ele);
				if (pQueue == null) {
					pQueue = new PriorityQueue<>();
				}
				pQueue.add(1);
				map.put(ele, pQueue);
			} else {
				int len = pQueue.poll();
				pQueue = map.get(ele);
				if (pQueue == null) {
					pQueue = new PriorityQueue<>();
				}
				map.put(ele, pQueue);
				pQueue.add(len + 1);
			}
		}
		for (PriorityQueue<Integer> queue : map.values()) {
			while (queue.size() > 0) {
				Integer len = queue.poll();
				if (len < 3) {
					return false;
				}
			}
		}
		return true;
	}
}
