/**
 * 
 */
package src;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author divyansh
 *
 */
public class SmallestDerangementOfSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 88, 6, 7, 8, 9 };
		int a1[] = findSmallestDerangement(a);
		Arrays.stream(a1).forEach(e->System.out.println(e));
	}

	private static int[] findSmallestDerangement(int[] a) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int newA[] = new int[a.length];
		int i = 0;
		for (i = 0; i < a.length; i++) {
			pq.add(a[i]);
		}
		i = 0;
		while (!pq.isEmpty()) {
			int ele1 = pq.poll();
			if (a[i] == ele1) {
				if (pq.isEmpty()) {
					newA[i] = newA[i - 1];
					newA[i - 1] = ele1;
					break;
				}
				int ele2 = pq.poll();
				newA[i] = ele2;
				pq.add(ele1);
			} else {
				newA[i] = ele1;
			}
			i++;
		}
		return newA;
	}

}
