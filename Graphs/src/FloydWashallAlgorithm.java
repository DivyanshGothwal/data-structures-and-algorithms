package src;

import java.util.ArrayList;
import java.util.List;

// for both directed and undirected graph
public class FloydWashallAlgorithm {
	public static void main(String[] ar) {
		List<List<Edge>> graph = new ArrayList<>();
		int m = 7;
		for (int i = 0; i <= m; i++) {
			graph.add(new ArrayList<>());
		}
		addUndirectedEdge(graph, 1, 3, 5);
		addUndirectedEdge(graph, 3, 6, -6);
		addUndirectedEdge(graph, 6, 7, -3);
		addUndirectedEdge(graph, 7, 1, 4);
		addUndirectedEdge(graph, 7, 5, 6);
		addUndirectedEdge(graph, 5, 2, 3);
		addUndirectedEdge(graph, 2, 1, -5);
		addUndirectedEdge(graph, 2, 4, -10);
		findAllPairShortestPath(graph);
	}

	public static void findAllPairShortestPath(List<List<Edge>> graph) {
		int n = graph.size();
		int[][] prev = new int[n][n];
		int[][] d = new int[n][n];
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (i == j) {
					d[i][j] = 0;
					prev[i][j] = 0;
					continue;
				}
				d[i][j] = Integer.MAX_VALUE;
				prev[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 1; i < n; i++) {
			List<Edge> edges = graph.get(i);
			for (int j = 0; j < edges.size(); j++) {
				Edge edge = edges.get(j);
				d[i][edge.v] = edge.weight;
				prev[i][edge.v] = i;
			}
		}
		for (int k = 1; k < n; k++) {
			for (int i = 1; i < n; i++) {
				for (int j = 1; j < n; j++) {
					if (d[i][k] != Integer.MAX_VALUE && d[k][j] != Integer.MAX_VALUE && d[i][j] > d[i][k] + d[k][j]) {
						d[i][j] = d[i][k] + d[k][j];
						prev[i][j] = prev[k][j];
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (d[i][i] < 0) {
				System.out.println("Negative Cycles present");
				return;
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				System.out.println(" prev[" + i + "][" + j + "]: " + prev[i][j]);
			}
			System.out.println();
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				System.out.println(" distance from " + i + " to " + j + " is: " + d[i][j]);
			}
		}
	}

	public static void addUndirectedEdge(List<List<Edge>> graph, int u, int v, int w) {
		graph.get(u).add(new Edge(u, v, w));
	}
}
