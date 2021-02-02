package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDirectedAcyclicGraph {
	public static int time = 0;

	public static void main(String[] args) {
		List<List<Edge>> graph = new ArrayList<>();
		int m = 10;
		for (int i = 0; i < m; i++) {
			graph.add(new ArrayList<>());
		}
		addEdge(graph, 0, 1, 5);
		addEdge(graph, 0, 2, 3);
		addEdge(graph, 1, 3, 6);
		addEdge(graph, 1, 2, 2);
		addEdge(graph, 2, 4, 4);
		addEdge(graph, 2, 5, 2);
		addEdge(graph, 2, 3, 7);
		addEdge(graph, 3, 4, -1);
		addEdge(graph, 4, 5, -2);
		shortestDistance(1, graph);
	}

	private static void addEdge(List<List<Edge>> graph, int u, int v, int w) {
		graph.get(u).add(new Edge(u, v, w));
	}

	public static void shortestDistance(int i, List<List<Edge>> graph) {
		Stack<Integer> q = topologcicalSort(i, graph);
		long[] dis = new long[graph.size()];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[i] = 0;
		while (!q.isEmpty()) {
			Integer top = q.pop();
			List<Edge> edges = graph.get(top);
			for (int j = 0; j < edges.size(); j++) {
				Edge edge = edges.get(j);
				if (dis[edge.v] > edge.weight + dis[edge.u]) {
					dis[edge.v] = edge.weight + dis[edge.u];
				}
			}
		}
		for(int j=0;j<dis.length;j++) {
			System.out.println("j  = "+j+" : "+dis[j]);
		}
	}

	private static Stack<Integer> topologcicalSort(int i, List<List<Edge>> graph) {
		Stack<Integer> dep = new Stack<Integer>();
		topologicalSortUtil(i, graph, dep);
		return dep;
	}

	private static void topologicalSortUtil(int i, List<List<Edge>> graph, Stack<Integer> dep) {
		List<Edge> edges = graph.get(i);
		for (int j = 0; j < edges.size(); j++) {
			Edge edge = edges.get(j);
			topologicalSortUtil(edge.v, graph, dep);
		}
		dep.push(i);
	}
}
