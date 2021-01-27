package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

public class ShortestPathToReachOnePrimeToOtherByChangingSingleDigitAtTime {

	public static void main(String[] args) {
		int m = 10000;
		int s = 1373 ;
		int e = 8179;
		int[] prime = sieveOfEratosthese(m);
		paths(prime, s, e);
		System.out.println(compare(1373,8017));
	}

	private static void paths(int[] prime, int s, int e) {
		List<Integer> primes = new ArrayList<>();
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 1; i < prime.length; i++) {
			if (prime[i] == 0) {
				primes.add(i);
			}
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < primes.size(); i++) {
			for (int j = i + 1; j < primes.size(); j++) {
				int k = primes.get(i);
				int l = primes.get(j);
				if (compare(k, l)) {
					graph.get(k).add(l);
					graph.get(l).add(k);
				}
			}
		}
		System.out.println(BFS(graph, s, e));
	}

	private static Integer BFS(List<List<Integer>> graph, int s, int e) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		q.add(null);
		int count = 0;
		int[] vis = new int[graph.size()];
		vis[s]=1;
		while (!q.isEmpty()) {
			Integer vertex = q.poll();
			System.out.println(vertex+" ");
			if (vertex != null) {
				if (vertex == e) {
					return count;
				}
				List<Integer> edges = graph.get(vertex);
				for (int i = 0; i < edges.size(); i++) {
					int ele = edges.get(i);
					if (vis[ele] == 0) {
						q.add(ele);
						vis[ele] = 1;
					}
				}
			} else if(!q.isEmpty()) {
				q.add(null);
				count++;
			}
		}
		return count;
	}

	private static boolean compare(Integer integer1, Integer integer2) {
		int[] int1 = new int[4];
		int[] int2 = new int[4];
		for (int i = 0; i < 4; i++) {
			int1[i] = -1;
			int2[i] = -1;
		}
		int i = 0;
		while (integer1 > 0) {
			int mod = integer1 % 10;
			integer1 = integer1 / 10;
			int1[i] = mod;
			i++;
		}
		i = 0;
		while (integer2 > 0) {
			int mod = integer2 % 10;
			integer2 = integer2 / 10;
			int2[i] = mod;
			i++;
		}
		int count = 0;
		for (i = 0; i < 4; i++) {
			if (int1[i] != int2[i]) {
				count++;
			}
		}
		return count == 1;
	}

	public static int[] sieveOfEratosthese(int m) {
		int[] prime = new int[m + 1];
		prime[1] = 0;
		prime[2] = 0;
		prime[3] = 0;
		for (int i = 2; i <= m; i++) {
			if (prime[i] == 0) {
				for (int j = 2; j * i <= m; j++) {
					prime[j * i] = 1;
				}
			}
		}

		return prime;
	}

}
