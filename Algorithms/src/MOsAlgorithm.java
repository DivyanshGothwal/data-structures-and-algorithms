package src;

import java.util.*;

public class MOsAlgorithm {

	public static void main(String ar[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int q = sc.nextInt();
		Query[] queries = new Query[q];
		for (int i = 0; i < q; i++) {
			queries[i] = new Query(sc.nextInt(), sc.nextInt());
		}
		findAns(a, n, q, queries);
		sc.close();
	}

	public static void findAns(int a[], int n, int q, Query[] queries) {
		int sqrt = (int) Math.sqrt(n);
		Arrays.sort(queries, (a1, b) -> {
			if (a1.start / sqrt > b.start / sqrt) {
				return 1;
			} else if (a1.start / sqrt < b.start / sqrt) {
				return -1;
			} else {
				return a1.end - b.end;
			}
		});
		Map<Integer, Integer> map = new TreeMap<>();
		int i = 0;
		int prevStart = 0;
		int prevEnd = 0;
		int count = 0;
		while (i < q) {
			int start = queries[i].start;
			int end = queries[i].end;
			while (prevEnd <= end) {
				if (map.get(a[prevEnd]) == null || map.get(a[prevEnd]) == 0) {
					count++;
					map.put(a[prevEnd], 1);
				} else {
					if(map.get(a[prevEnd])==1) {
					count--;
					}
					map.put(a[prevEnd], map.get(a[prevEnd]) + 1);
				}
				prevEnd++;
			}
			while (prevEnd > end+1) {
				if (map.get(a[prevEnd-1]) == null || map.get(a[prevEnd-1]) == 0) {
					map.put(a[prevEnd], 1);
				} else {
					if (map.get(a[prevEnd-1]) == 2) {
						count++;
					} else if (map.get(a[prevEnd-1]) == 1) {
						count--;
					}
					map.put(a[prevEnd-1], map.get(a[prevEnd-1]) - 1);
				}
				prevEnd--;
			}
			while (prevStart < start) {
				if (map.get(a[prevStart]) == null || map.get(a[prevStart]) == 0) {
					map.put(a[prevStart], 1);
				} else {
					if (map.get(a[prevStart]) == 2) {
						count++;
					} else if (map.get(a[prevStart]) == 1) {
						count--;
					}
					map.put(a[prevStart], map.get(a[prevStart]) - 1);
				}
				prevStart++;
			}

			while (prevStart > start) {
				if (map.get(a[prevStart-1]) == null || map.get(a[prevStart-1]) == 0) {
					count++;
					map.put(a[prevStart-1], 1);
				} else {
					if (map.get(a[prevStart-1]) == 1) {
						count--;
					}
					map.put(a[prevStart-1], map.get(a[prevStart-1]) + 1);
//					count--;
				}
				prevStart--;
			}


			System.out.println(count);
			i++;
		}
	}
}

class Query {
	int start;
	int end;

	Query(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

/*
 * 
 * 
 * 10 3 5 2 4 6 4 5 3 4 5 10 4 7 2 6 3 8 6 8 5 9 7 9 6 9 5 7 3 7 2 6
 * 
 */
