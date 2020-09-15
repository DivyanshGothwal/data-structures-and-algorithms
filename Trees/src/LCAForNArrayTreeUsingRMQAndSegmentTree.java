package src;

import java.util.*;

public class LCAForNArrayTreeUsingRMQAndSegmentTree {
	static List<Integer> segmentTree;

	public static void main(String[] args) {
		int n = 15;
		List<List<Integer>> graph = new ArrayList<>(n + 1);
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 4);
		addEdge(graph, 2, 4);
		addEdge(graph, 2, 5);
		addEdge(graph, 2, 6);
		addEdge(graph, 3, 7);
		addEdge(graph, 3, 8);
		addEdge(graph, 3, 9);
		addEdge(graph, 5, 10);
		addEdge(graph, 5, 11);
		addEdge(graph, 8, 13);
		addEdge(graph, 9, 14);
		addEdge(graph, 7, 12);
		List<Integer> eulerTour = findEulerTour(graph);
		int segmentTreeSize = getSegmentTreeSize(2 * eulerTour.size() - 1);
		segmentTree = new ArrayList<>();
		for (int i = 0; i < segmentTreeSize; i++) {
			segmentTree.add(null);
		}
		buildSegmentTree(eulerTour);
		Map<Integer, Integer> indexMap = indexArray(eulerTour);
		System.out.println(getLCA(eulerTour.size(), Math.min(indexMap.get(6), indexMap.get(10)), Math.max(indexMap.get(6), indexMap.get(10))));
	}

	public static void addEdge(List<List<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
	}

	public static List<Integer> findEulerTour(List<List<Integer>> graph) {
		List<Integer> tour = new ArrayList<>();
		findEulerTourUtil(1, graph, tour);
		return tour;
	}

	public static void findEulerTourUtil(int i, List<List<Integer>> graph, List<Integer> tour) {
		List<Integer> childs = graph.get(i);
		tour.add(i);
		for (int j = 0; j < childs.size(); j++) {
			findEulerTourUtil(childs.get(j), graph, tour);
			tour.add(i);
		}
	}

	public static Integer getSegmentTreeSize(int n) {
		int i = 0;
		while (n > 0) {
			i++;
			n = n >> 1;
		}
		return (1 << i) + 1;
	}

	public static void buildSegmentTree(List<Integer> ar) {
		buildSegmentTreeUtil(ar, 0, 0, ar.size() - 1);
	}

	public static Integer buildSegmentTreeUtil(List<Integer> ar, int i, int l, int r) {

		if (l > r) {
			return Integer.MAX_VALUE;
		}
		if (l == r) {
			segmentTree.set(i, ar.get(l));
			return ar.get(l);
		}

		int mid = l + (r - l) / 2;
		int left = buildSegmentTreeUtil(ar, 2 * i + 1, l, mid);
		int right = buildSegmentTreeUtil(ar, 2 * i + 2, mid + 1, r);
		segmentTree.set(i, Math.min(left, right));
		return segmentTree.get(i);
	}

	public static Map<Integer, Integer> indexArray(List<Integer> ar) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < ar.size(); i++) {
			map.put(ar.get(i), i);
		}
		return map;
	}

	public static Integer getLCA(int n, int s, int e) {
		return getLCAUtil(0, s, e, 0, n - 1);
	}

	public static Integer getLCAUtil(int i, int s, int e, int l, int r) {
		// full overlap
		if (s <= l && e >= r) {
			return segmentTree.get(i);
		}
		// no overlap
		if (e < l || s > r) {
			return Integer.MAX_VALUE;
		}
		int mid = l + (r - l) / 2;
		int left = getLCAUtil(2 * i + 1, s, e, l, mid);
		int right = getLCAUtil(2 * i + 2, s, e, mid + 1, r);
		return Math.min(left, right);
	}
}
