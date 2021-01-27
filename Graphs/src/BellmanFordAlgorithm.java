package src;

import java.util.ArrayList;
import java.util.List;

public class BellmanFordAlgorithm {
	static List<Edge> edges = null;

	public static void main(String ar[]) {
		List<List<Edge>> graph = new ArrayList<>();
		int m = 8;
		for (int i = 0; i <= m; i++) {
			graph.add(new ArrayList<>());
		}
		edges = new ArrayList<>();
		addUndirectedEdge(graph, 1, 2, 10);
		addUndirectedEdge(graph, 2, 4, 5);
		addUndirectedEdge(graph, 4, 8, 12);
		addUndirectedEdge(graph, 8, 5, -1);
		addUndirectedEdge(graph, 1, 5, 8);
		addUndirectedEdge(graph, 5, 3, 6);
		addUndirectedEdge(graph, 3, 6, 5);
		addUndirectedEdge(graph, 6, 7, -7);
		addUndirectedEdge(graph, 1, 7, 4);
		addUndirectedEdge(graph, 1, 3, 4);
		addUndirectedEdge(graph, 1, 4, 2);
		findShortestPath(graph);
	}

	private static void findShortestPath(List<List<Edge>> graph) {
		int d[] = new int[graph.size()];
		for (int i = 0; i < graph.size(); i++) {
			d[i] = Integer.MAX_VALUE;
		}
		d[1] = 0;
		for (int i = 0; i < graph.size() - 1; i++) {
			for (int j = 0; j < edges.size(); j++) {
				Edge e = edges.get(j);
				if (d[e.u] != Integer.MAX_VALUE && d[e.v] > d[e.u] + e.weight) {
					d[e.v] = d[e.u] + e.weight;
				}
			}
		}
		for (int i = 1; i < graph.size(); i++) {
			System.out.println(d[i]);
		}
	}

	public static void addUndirectedEdge(List<List<Edge>> graph, int u, int v, int w) {
		Edge edge1 = new Edge(u, v, w);
//		Edge edge2 = new Edge(v, u, w);
		graph.get(u).add(edge1);
//		graph.get(v).add(edge2);
		edges.add(edge1);
//		edges.add(edge2);
	}
}
