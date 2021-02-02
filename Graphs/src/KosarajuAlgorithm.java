package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KosarajuAlgorithm {

	public static void main(String[] args) {
		List<List<Integer>> graph = new ArrayList<>();
		int m = 11;
		for (int i = 0; i < m; i++) {
			graph.add(new ArrayList<>());
		}
		addEdge(graph, 0, 1);
		addEdge(graph, 1, 2);
		addEdge(graph, 2, 0);
		addEdge(graph, 1, 3);
		addEdge(graph, 3, 4);
		addEdge(graph, 4, 5);
		addEdge(graph, 5, 3);
		addEdge(graph, 6, 5);
		addEdge(graph, 6, 7);
		addEdge(graph, 7, 8);
		addEdge(graph, 8, 9);
		addEdge(graph, 9, 6);
		addEdge(graph, 9, 10);
		findStronglyConnectedComponents(graph, m);
	}

	private static void addEdge(List<List<Integer>> graph, int i, int j) {
		graph.get(i).add(j);
	}

	private static void findStronglyConnectedComponents(List<List<Integer>> graph, int m) {
		Stack<Integer> st = new Stack<>();
		int vis[] = new int[m];
		for (int i = 0; i < m; i++) {
			if (vis[i] == 0) {
				DFS(i, vis, st, graph);
			}
		}
		graph = reverseEdges(graph);
		vis = new int[m];
		while (!st.isEmpty()) {
			Integer top = st.pop();
			if (vis[top] == 0) {
				DFS(top, graph, vis);
				System.out.println();
			}
		}
	}

	public static List<List<Integer>> reverseEdges(List<List<Integer>> graph) {
		List<List<Integer>> newGraph = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			newGraph.add(new ArrayList<>());
		}
		for (int i = 0; i < graph.size(); i++) {
			List<Integer> edges = graph.get(i);
			for (int j = 0; j < edges.size(); j++) {
				newGraph.get(edges.get(j)).add(i);
			}
		}
		return newGraph;
	}

	public static void DFS(int i, int[] vis, Stack<Integer> st, List<List<Integer>> graph) {
		vis[i] = 1;
		List<Integer> list = graph.get(i);
		for (int j = 0; j < list.size(); j++) {
			Integer edge = list.get(j);
			if (vis[edge] == 0) {
				DFS(edge, vis, st, graph);
			}
		}
		st.push(i);
	}

	public static void DFS(int i, List<List<Integer>> graph, int[] vis) {
		System.out.print(i + " ");
		List<Integer> edges = graph.get(i);
		vis[i] = 1;
		for (int j = 0; j < edges.size(); j++) {
			if (vis[edges.get(j)] == 0) {
				DFS(edges.get(j), graph, vis);
			}
		}
	}
}
