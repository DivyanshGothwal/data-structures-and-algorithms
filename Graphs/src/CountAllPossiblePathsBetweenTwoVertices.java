package src;

import java.util.ArrayList;
import java.util.List;

public class CountAllPossiblePathsBetweenTwoVertices {

	public static void main(String[] ar) {
		List<List<Edge>> graph = new ArrayList<>();
		int m = 5;
		for (int i = 0; i <= m; i++) {
			graph.add(new ArrayList<>());
		}
		addDirectedEdge(graph, 0, 1);
		addDirectedEdge(graph, 1, 4);
		addDirectedEdge(graph, 0, 4);
		addDirectedEdge(graph, 0, 2);
		addDirectedEdge(graph, 2, 4);
		addDirectedEdge(graph, 1, 3);
		addDirectedEdge(graph, 3, 2);
		addDirectedEdge(graph, 0, 5);
		addDirectedEdge(graph, 5, 1);
		System.out.println(countPaths(graph, 0, 4));
	}

	public static void addDirectedEdge(List<List<Edge>> graph, int u, int v) {
		graph.get(u).add(new Edge(u, v, null));
	}

	public static Integer countPaths(List<List<Edge>> graph, int s, int e) {
		int[] dp = new int[graph.size()];
		for (int i = 0; i < graph.size(); i++) {
			dp[i] = -1;
		}
		return countPathUtil(graph, s, e, dp);
//		return 1;
	}

	public static Integer countPathUtil(List<List<Edge>> graph, int s, int e, int[] dp) {
		if (s == e) {
			return 1;
		}
		int count = 0;
		List<Edge> edges = graph.get(s);
		for (int i = 0; i < edges.size(); i++) {
			int v = edges.get(i).v;
			if (dp[v] == -1) {
				dp[v] = countPathUtil(graph, v, e, dp);
			}
			count += dp[v];
		}
		return count;
	}
}
