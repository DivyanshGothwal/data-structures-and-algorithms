package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindingKCoresOfAGraph {
	public static void main(String[] ar) {
		List<Map<Integer, Edge>> graph = new ArrayList<>();
		int m = 9;
		for (int i = 0; i < m; i++) {
			graph.add(new HashMap<>());
		}
		addUndirectedEdge(graph, 0, 1);
		addUndirectedEdge(graph, 0, 2);
		addUndirectedEdge(graph, 1, 2);
		addUndirectedEdge(graph, 1, 5);
		addUndirectedEdge(graph, 2, 5);
		addUndirectedEdge(graph, 5, 8);
		addUndirectedEdge(graph, 5, 6);
		addUndirectedEdge(graph, 6, 2);
		addUndirectedEdge(graph, 6, 8);
		addUndirectedEdge(graph, 6, 4);
		addUndirectedEdge(graph, 6, 3);
		addUndirectedEdge(graph, 6, 7);
		addUndirectedEdge(graph, 7, 3);
		addUndirectedEdge(graph, 7, 4);
		addUndirectedEdge(graph, 4, 3);
		addUndirectedEdge(graph, 2, 3);
		addUndirectedEdge(graph, 4, 2);
		findKCores(graph, 4);
		graph.stream().forEach(eachVertex -> {
//			eachVertex.
			System.out.print("edges are: ");
			for (Map.Entry<Integer, Edge> entry : eachVertex.entrySet()) {
				System.out.print(entry.getKey()+" ");
			}
			System.out.println();
		});
	}

	private static void findKCores(List<Map<Integer, Edge>> graph, int k) {
		int[] vis = new int[graph.size()];
		for (int i = 0; i < graph.size(); i++) {
			if (vis[i] == 0)
				DFS(i, graph, vis, k);
		}
	}

	private static void DFS(int i, List<Map<Integer, Edge>> graph, int[] vis, int k) {
		Map<Integer, Edge> list = graph.get(i);
		if (list.size() < k) {
			Set<Map.Entry<Integer, Edge>> set = list.entrySet();
			for (Map.Entry<Integer, Edge> entry : set) {
				Map<Integer, Edge> edges = graph.get(entry.getKey());
				edges.remove(i);
			}
			for (Map.Entry<Integer, Edge> entry : set) {
				if (vis[entry.getKey()] == 0) {
					Map<Integer, Edge> edges = graph.get(entry.getKey());
					edges.remove(i);
					DFS(entry.getKey(), graph, vis, k);
				}
			}
			graph.set(i, new HashMap<>());
			vis[i] = 1;
		}
	}

	public static void addUndirectedEdge(List<Map<Integer, Edge>> graph, int u, int v) {
		graph.get(u).put(v, new Edge(u, v, null));
		graph.get(v).put(u, new Edge(u, v, null));
	}
}
