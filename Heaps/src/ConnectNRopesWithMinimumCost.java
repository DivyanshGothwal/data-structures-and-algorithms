/**
 * 
 */
package src;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author divyansh
 *
 */
public class ConnectNRopesWithMinimumCost {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			List<Long> ar = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				Long a = sc.nextLong();
				ar.add(a);
			}
			System.out.println(minCost(ar));
		}
		sc.close();
	}

	public static Long minCost(List<Long> a) {
		PriorityQueue<Long> pq = new PriorityQueue<Long>((a1, a2) -> {
			return a1.compareTo(a2);
		});

		for (Long ele : a) {
			pq.add(ele);
		}
		Long totalCount = 0L;
		while (!pq.isEmpty()) {
			Long val1 = pq.poll();
			// System.out.println(val1);
			if (pq.isEmpty()) {
				return totalCount;
			}
			Long val2 = pq.poll();
			totalCount += val1;
			totalCount += val2;
			pq.add(val1 + val2);
		}
		return totalCount;
	}

}
