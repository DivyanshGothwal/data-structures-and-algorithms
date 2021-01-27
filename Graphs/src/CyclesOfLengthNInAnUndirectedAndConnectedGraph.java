package src;

import java.util.ArrayList;
import java.util.List;

public class CyclesOfLengthNInAnUndirectedAndConnectedGraph {
	static int count = 0;

	public static void main(String[] args) {
		List<List<Integer>> graph = new ArrayList<>();
		int m = 5;
		for (int i = 0; i < m; i++) {
			graph.add(new ArrayList<>());
		}
		addEdge(graph, 0, 1);
		addEdge(graph, 1, 2);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);
		addEdge(graph, 4, 1);
		addEdge(graph, 3, 0);
		System.out.println(countCycles(graph, 4));
	}

	public static void addEdge(List<List<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
		graph.get(v).add(u);
	}

	public static int countCycles(List<List<Integer>> graph, int k) {
		int n = graph.size();
		int iterations = n - (k - 1);
		int[] color = new int[n];
		for (int i = 0; i < iterations; i++) {
			if (color[i] == 0) {
				DFS(i, i, graph, k - 1, color, -1);
			}
			color[i] = 2;
		}
		return count / 2;
	}

	public static void DFS(int i, int start, List<List<Integer>> graph, int length, int[] color, int parent) {
		if (color[i] == 2) {
			return;
		}
		if (length == 0) {
			color[i] = 0;
			if (graph.get(i).contains(start)) {
				count++;
			}
			return;
		}
		color[i] = 1;
		List<Integer> edges = graph.get(i);
		for (int j = 0; j < edges.size(); j++) {
			if (color[edges.get(j)] == 0 && edges.get(j) != parent) {
				DFS(edges.get(j), start, graph, length - 1, color, i);
			}
		}
		color[i] = 0;
	}
}
