package src;

import java.util.Arrays;

public class WeightedIntervalScheduling {

	public static void main(String[] args) {
		CustomWeight[] cw = new CustomWeight[10];
//		for (int i = 0; i < 10; i++) {
			cw[0] = new CustomWeight(10, 0, 1, 4);
			cw[1] = new CustomWeight(10, 1, 2, 4);
			cw[2] = new CustomWeight(10, 2, 5, 8);
			cw[3] = new CustomWeight(10, 3, 1, 2);
			cw[4] = new CustomWeight(10, 4, 6, 8);
			cw[5] = new CustomWeight(10, 5, 7, 10);
			cw[6] = new CustomWeight(10, 6, 10, 14);
			cw[7] = new CustomWeight(10, 7, 6, 13);
			cw[8] = new CustomWeight(10, 8, 2, 4);
			cw[9] = new CustomWeight(10, 9, 8, 11);
//		}
		System.out.println(countMaxWeight(cw));
	}

	public static int countMaxWeight(CustomWeight[] cw) {
		int n = cw.length;
		int as[] = new int[n];
		Arrays.sort(cw, (a, b) -> a.weight.compareTo(b.weight));
		as[n - 1] = cw[n - 1].weight;
		for (int i = n - 2; i >= 0; i--) {
			int value = 0;
			for (int j = i + 1; j < n; j++) {
				if (cw[i].end <= cw[j].start) {
					value = as[j];
					break;
				}
			}
			as[i] = Math.max(as[i + 1], cw[i].weight + value);
		}
		return as[0];
	}
}

class CustomWeight {
	Integer weight;
	int index;
	int start;
	int end;

	CustomWeight(int weight, int index, int start, int end) {
		this.weight = weight;
		this.index = index;
		this.start = start;
		this.end = end;
	}
}