package src;

import java.util.ArrayList;
import java.util.List;

public class NumberOfTrianglesInAnUndirectedGraph {
	static int count = 0;

	public static void main(String[] args) {
		List<List<Integer>> graph = new ArrayList<>();
		int m = 4;
		for (int i = 0; i < m; i++) {
			graph.add(new ArrayList<>());
			for (int j = 0; j < m; j++) {
				graph.get(i).add(-1);
			}
		}
		addEdge(graph, 1, 0);
		addEdge(graph, 1, 2);
		addEdge(graph, 0, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 3, 2);

		System.out.println(countTriangles(graph, m));
	}

	public static void addEdge(List<List<Integer>> graph, int u, int v) {
		graph.get(u).add(v, v);
		graph.get(v).add(u, u);
	}

	public static Integer countTriangles(List<List<Integer>> graph, int m) {
		int[] vis = null;
		count = 0;
		for (int i = 0; i < m - 2; i++) {
			vis = new int[m];
			countTrianglesUtil(i, i, graph, vis, 2);
			vis[i] = 1;
		}
		return count / 2;
	}

	public static void countTrianglesUtil(int s, int start, List<List<Integer>> graph, int[] vis, int paths) {
		List<Integer> edges = graph.get(s);
		if (paths == 0) {
			if (graph.get(s).get(start) != -1) {
				count++;
				vis[s] = 0;
			}
			return;
		}
		vis[s] = 1;
		for (int i = 0; i < edges.size(); i++) {
			Integer edge = edges.get(i);
			if (edge != -1 && vis[edge] == 0) {
				countTrianglesUtil(edge, start, graph, vis, paths - 1);
			}
		}
		vis[s] = 0;
	}

}
