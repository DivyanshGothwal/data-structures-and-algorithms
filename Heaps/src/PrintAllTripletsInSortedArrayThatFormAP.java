/**
 * 
 */
package src;

import java.util.HashMap;
import java.util.Map;

/**
 * @author divyansh
 *
 */
public class PrintAllTripletsInSortedArrayThatFormAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 2, 6, 9, 12, 17, 22, 31, 32, 35, 42 };
		printTripletsUsingExtraSpace(arr, arr.length);
		System.out.println();
		withoutUsingHashMap(arr, arr.length);
	}

	private static void withoutUsingHashMap(int[] arr, int n) {
		for (int i = 1; i < n; i++) {
			int j = i - 1, k = i + 1;
			while (j >= 0 && k < n) {
				if ((2 * arr[i]) == arr[j] + arr[k]) {
					System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
					j--;
					k++;
				} else if ((2 * arr[i]) > arr[j] + arr[k]) {
					k++;
				} else {
					j--;
				}
			}
		}
	}

	private static void printTripletsUsingExtraSpace(int[] arr, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(arr[i], 1);
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int a = arr[i];
				int b = arr[j];
				int d1 = b - a;
				Integer c1 = map.get(b + d1);
				if (c1 == null) {
					continue;
				}
//				if(c1!=null && b+d1==a && c1>1) {
//					
//				}
				if (c1 != null) {
					System.out.println(a + " " + b + " " + (b + d1));
				}
			}
		}
	}

}
