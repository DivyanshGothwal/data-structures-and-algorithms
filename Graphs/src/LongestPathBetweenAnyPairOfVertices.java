package src;

import java.util.ArrayList;
import java.util.List;

public class LongestPathBetweenAnyPairOfVertices {
	static int globalMax = Integer.MIN_VALUE;

	public static void main(String[] args) {
		List<List<Edge>> graph = new ArrayList<>();
		int m = 10;
		for (int i = 0; i < m; i++) {
			graph.add(new ArrayList<>());
		}
		addEdge(graph, 1, 2, 5);
		addEdge(graph, 2, 3, 4);
		addEdge(graph, 2, 6, 2);
		addEdge(graph, 6, 4, 6);
		addEdge(graph, 6, 5, 5);
		addEdge(graph, 1, 7, 8);
		addEdge(graph, 3, 8, 6);
		addEdge(graph, 3, 9, 5);
		DFS(graph);
	}

	public static void DFS(List<List<Edge>> graph) {
		int[] vis = new int[graph.size()];
		DFSUtil(1, graph, vis);
		System.out.println(globalMax);
	}

	public static int DFSUtil(int ver, List<List<Edge>> graph, int[] vis) {
		vis[ver] = 1;
		List<Edge> edges = graph.get(ver);
		int firstMax = 0;
		int secondMax = 0;
		for (int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			if (vis[edge.v] == 0) {
				int value = DFSUtil(edge.v, graph, vis);
				value += edge.weight;
				if (firstMax < value) {
					int temp = firstMax;
					firstMax = value;
					secondMax = temp;
				} else if (firstMax > value && secondMax < value) {
					secondMax = value;
				}
				globalMax = Math.max(globalMax, firstMax + secondMax);
			}
		}
		return firstMax;
	}

	public static void addEdge(List<List<Edge>> graph, int u, int v, int w) {
		graph.get(u).add(new Edge(u, v, w));
		graph.get(v).add(new Edge(v, u, w));
	}
}
