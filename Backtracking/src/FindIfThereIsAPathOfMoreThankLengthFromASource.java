package src;

import java.util.ArrayList;
import java.util.List;

public class FindIfThereIsAPathOfMoreThankLengthFromASource {
	static List<List<Edge>> graph;

	public static void main(String[] args) {
		graph = new ArrayList<>();
		int m = 9;
		for (int i = 0; i < m; i++) {
			graph.add(new ArrayList<>());
		}
		addEdge(0, 1, 4);
		addEdge(0, 7, 8);
		addEdge(1, 2, 8);
		addEdge(1, 7, 11);
		addEdge(2, 3, 7);
		addEdge(2, 8, 2);
		addEdge(2, 5, 4);
		addEdge(3, 4, 9);
		addEdge(3, 5, 14);
		addEdge(4, 5, 10);
		addEdge(5, 6, 2);
		addEdge(6, 7, 1);
		addEdge(6, 8, 6);
		addEdge(7, 8, 7);
		System.out.println(doesPathExists(graph, 58));
	}

	public static void addEdge(int u, int v, int w) {
		graph.get(u).add(new Edge(u, v, w));
		graph.get(v).add(new Edge(v, u, w));
	}

	public static Boolean doesPathExists(List<List<Edge>> graph, int k) {
		int[] vis = new int[graph.size()];
		return doesPathExistsUtil(0, graph, vis, k);
	}

	public static Boolean doesPathExistsUtil(int i, List<List<Edge>> graph, int[] vis, int k) {
		if (k == 0) {
			return true;
		}
		vis[i] = 1;
		Boolean isPossible = false;
		List<Edge> edges = graph.get(i);
		for (int j = 0; j < edges.size(); j++) {
			Edge edge = edges.get(j);
			if (vis[edge.v] == 0) {
				isPossible = isPossible || doesPathExistsUtil(edge.v, graph, vis, k - edge.weight);
				vis[edge.v] = 0;
			}
		}
		return isPossible;
	}
}
