package src;

import java.util.ArrayList;
import java.util.List;

public class DfsDirectedGraph {

	public static void main(String[] ar) {
		List<List<Integer>> graph = new ArrayList<List<Integer>>();
		int m = 7;
		for (int i = 0; i <= m; i++) {
			graph.add(new ArrayList<>());
		}
		addDirectedEdge(graph, 1, 2);
		addDirectedEdge(graph, 2, 4);
		addDirectedEdge(graph, 4, 6);
		addDirectedEdge(graph, 4, 1);
		addDirectedEdge(graph, 3, 4);
		addDirectedEdge(graph, 3, 1);
		addDirectedEdge(graph, 3, 6);
		int visited[] = new int[m + 1];
		DFS(graph, 2, visited);
	}

	private static void DFS(List<List<Integer>> graph, int i, int[] visited) {
		List<Integer> list = graph.get(i);
		visited[i] = 1;
		System.out.println(i);
		for (int j = 0; j < list.size(); j++) {
			if (visited[list.get(j)] == 0) {
				DFS(graph, list.get(j), visited);
			}
		}
	}

	static void addDirectedEdge(List<List<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
	}
}
