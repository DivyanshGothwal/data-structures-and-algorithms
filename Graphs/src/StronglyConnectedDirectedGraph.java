package src;

import java.util.ArrayList;
import java.util.List;

public class StronglyConnectedDirectedGraph {
	public static void main(String[] args) {
		List<List<Integer>> graph = new ArrayList<>();
		int m = 8;
		for (int i = 0; i <= m; i++) {
			graph.add(new ArrayList<>());
		}
		addDirectedEdge(graph, 1, 2);
		addDirectedEdge(graph, 1, 3);
		addDirectedEdge(graph, 3, 4);
		addDirectedEdge(graph, 2, 5);
		addDirectedEdge(graph, 8, 5);
		addDirectedEdge(graph, 5, 1);
		addDirectedEdge(graph, 4, 8);
//		addDirectedEdge(graph, 4, 1);
		addDirectedEdge(graph, 3, 6);
		addDirectedEdge(graph, 6, 7);
		addDirectedEdge(graph, 7, 1);
		System.out.println(isStronglyConnected(graph));
	}

	private static Boolean isStronglyConnected(List<List<Integer>> graph) {
		boolean[] isVisited = new boolean[graph.size()];
		DFS(2, graph, isVisited);
		if (!isAllVisited(isVisited)) {
			return false;
		}
		graph = reverseEdges(graph);
		isVisited = new boolean[graph.size()];
		DFS(2, graph, isVisited);
		if (!isAllVisited(isVisited)) {
			return false;
		}
		return true;
	}

	private static Boolean isAllVisited(boolean[] isVisited) {
		for (int i = 1; i < isVisited.length; i++) {
			if (!isVisited[i]) {
				return false;
			}
		}
		return true;
	}

	private static List<List<Integer>> reverseEdges(List<List<Integer>> graph) {
		int m = graph.size() - 1;
		List<List<Integer>> newGraph = new ArrayList<>();
		for (int i = 0; i <= m; i++) {
			newGraph.add(new ArrayList<>());
		}
		for (int i = 1; i <= m; i++) {
			int n = graph.get(i).size();
			for (int j = 0; j < n; j++) {
				newGraph.get(graph.get(i).get(j)).add(i);
			}
		}
		return newGraph;
	}

	private static void DFS(int i, List<List<Integer>> graph, boolean[] isVisited) {
		List<Integer> list = graph.get(i);
		isVisited[i] = true;
		for (int j = 0; j < list.size(); j++) {
			if (!isVisited[list.get(j)]) {
				DFS(list.get(j), graph, isVisited);
			}
		}
	}

	public static void addDirectedEdge(List<List<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
	}
}
