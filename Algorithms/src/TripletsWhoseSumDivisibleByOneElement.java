package src;

import java.util.*;
import static java.util.Objects.*;

public class TripletsWhoseSumDivisibleByOneElement {
	public static void main(String arg[]) {
		List<Integer> ar = new ArrayList<>();
//		ar.add(1);
		ar.add(2);
		ar.add(2);
		ar.add(2);
		ar.add(2);
		ar.add(9);
		ar.add(9);
		ar.add(9);
		ar.add(7);
		ar.add(7);
		ar.add(7);
		ar.add(7);
		ar.add(7);
		ar.add(6);
		ar.add(12);
		ar.add(12);
		ar.add(12);
		ar.add(12);
		ar.add(12);
		ar.add(2);
		ar.add(2);
		ar.add(2);
		ar.add(2);
		ar.add(9);
		ar.add(9);
		ar.add(9);		ar.add(12);
		ar.add(12);
		ar.add(2);
		ar.add(2);
		ar.add(2);
		ar.add(2);
		ar.add(9);
		ar.add(9);
		ar.add(9);
		ar.add(7);
		ar.add(7);
		ar.add(7);
		ar.add(7);
		ar.add(7);
		ar.add(6);
		ar.add(12);
		ar.add(12);
		ar.add(12);
		ar.add(12);
		ar.add(12);
		ar.add(7);
		ar.add(7);
		ar.add(7);
		ar.add(7);
		ar.add(7);
		ar.add(6);

		ar.add(13);
		ar.add(18);
		ar.add(9);
		ar.add(10);
		ar.add(12);
		ar.add(12);
		ar.add(12);
		ar.add(12);
		ar.add(12);
		ar.add(100);

		System.out.println(" ans with naive way :- "+noOfTripletsNaive(ar, ar.size()));
		System.out.println(" ans with optimized way :- "+noOfTriplets(ar));
	}

	private static int noOfTripletsNaive(List<Integer> ar, int N) {
		int triplets = 0;
		int i = 0, j = 0, k = 0;
		for (i = 0; i < N; i++) {
			for (j = i + 1; j < N; j++) {
				for (k = j + 1; k < N; k++) {
					if (isGoodTriplet(ar.get(i), ar.get(j), ar.get(k))) {
						triplets += 6;
					}
				}
			}
		}
		return triplets;
	}

	private static long noOfTriplets(List<Integer> ar) {
		long triplets = 0;
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < ar.size(); i++) {
			if (nonNull(map.get(ar.get(i)))) {
				map.put(ar.get(i), map.get(ar.get(i)) + 1);
			} else {
				map.put(ar.get(i), 1);
			}
		}
		int[][][] isVisited = new int[101][101][101];
		Integer[] newAr = map.keySet().toArray(new Integer[map.size()]);
		for (int i = 0; i < newAr.length; i++) {
			for (int j = i + 1; j < newAr.length; j++) {
				long freqi = Long.parseLong(map.get(newAr[i])+"");
				long freqj = Long.parseLong(map.get(newAr[j])+"");
				if (i != j) {
					for (int k = j + 1; k < newAr.length; k++) {
						if (k != i && k != j) {
							long freqk = Long.parseLong(map.get(newAr[k])+"");
							if (isVisited[i][j][k] == 0 && isGoodTriplet(newAr[i], newAr[j], newAr[k])) {
								triplets += (((freqi * freqj * freqk)) * 6);
								isVisited[i][j][k] = 1;
							}
							if (freqk > 1) {
								if (isVisited[i][k][k] == 0 && isVisited[k][i][k] == 0 && isVisited[k][k][i] == 0
										&& isGoodTriplet(newAr[i], newAr[k], newAr[k])) {
									triplets += (((freqk > 2 ? (freqk*(freqk-1))/2 : (freqk - 1)) * freqi) * 6);
									isVisited[i][k][k] = 1;
									isVisited[k][i][k] = 1;
									isVisited[k][k][i] = 1;
								}
								if (isVisited[j][k][k] == 0 && isVisited[k][j][k] == 0 && isVisited[k][k][j] == 0
										&& isGoodTriplet(newAr[k], newAr[k], newAr[j])) {
									triplets += (((freqk > 2 ? (freqk*(freqk-1))/2 : (freqk - 1)) * freqj) * 6);
									isVisited[j][k][k] = 1;
									isVisited[k][j][k] = 1;
									isVisited[k][k][j] = 1;
								}
							}
							if (freqi > 1) {
								if (isVisited[i][i][k] == 0 && isVisited[k][i][i] == 0 && isVisited[i][k][i] == 0
										&& isGoodTriplet(newAr[i], newAr[i], newAr[k])) {
									triplets += (((freqi > 2 ? (freqi*(freqi-1))/2 : (freqi - 1)) * freqk) * 6);
									isVisited[i][i][k] = 1;
									isVisited[k][i][i] = 1;
									isVisited[i][k][i] = 1;
								}
							}
							if (freqj > 1) {
								if (isVisited[j][j][k] == 0 && isVisited[k][j][j] == 0 && isVisited[j][k][j] == 0
										&& isGoodTriplet(newAr[k], newAr[j], newAr[j])) {
									triplets += (((freqj > 2 ? (freqj*(freqj-1))/2 : (freqj - 1)) * freqk) * 6);
									isVisited[j][j][k] = 1;
									isVisited[k][j][j] = 1;
									isVisited[j][k][j] = 1;
								}
							}
						}
					}

					if (freqi > 1) {
						if (isVisited[j][i][i] == 0 && isVisited[i][i][j] == 0 && isVisited[i][j][i] == 0
								&& isGoodTriplet(newAr[i], newAr[i], newAr[j])) {
							triplets += (((freqi > 2 ? (freqi*(freqi-1))/2 : (freqi - 1)) * freqj) * 6);
							isVisited[j][i][i] = 1;
							isVisited[i][i][j] = 1;
							isVisited[i][j][i] = 1;
						}
					}
					if (freqj > 1) {
						if (isVisited[j][j][i] == 0 && isVisited[i][j][j] == 0 && isVisited[j][i][j] == 0
								&& isGoodTriplet(newAr[i], newAr[j], newAr[j])) {
							triplets += (((freqj > 2 ? (freqj*(freqj-1))/2 : (freqj - 1)) * freqi) * 6);
							isVisited[j][j][i] = 1;
							isVisited[i][j][j] = 1;
							isVisited[j][i][j] = 1;
						}
					}
				}
			}
		}
		return triplets;
	}

	private static boolean isGoodTriplet(int i, int j, int k) {
		int sum = i + j + k;
		if (sum % i == 0 && sum % j != 0 && sum % k != 0) {
			return true;
		}
		if (sum % i != 0 && sum % j == 0 && sum % k != 0) {
			return true;
		}
		if (sum % i != 0 && sum % j != 0 && sum % k == 0) {
			return true;
		}
		return false;
	}
}
