package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CountNodesWithinKDistanceFromAllNodesInASet {

	public static void main(String[] args) {
		List<List<Integer>> graph = new ArrayList<>();
		int v = 10;
		for (int i = 0; i <= v; i++) {
			graph.add(new ArrayList<>());
		}
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 8);
		addEdge(graph, 0, 3);
		addEdge(graph, 3, 2);
		addEdge(graph, 3, 6);
		addEdge(graph, 3, 7);
		addEdge(graph, 3, 5);
		addEdge(graph, 5, 4);
		addEdge(graph, 5, 9);
		Map<Integer, Integer> markedVertices = new HashMap<>();
		markedVertices.put(1, 0);
		markedVertices.put(2, 0);
		markedVertices.put(4, 0);
		int k = 3;
		int farestOne = BFS(9, graph, markedVertices);
		int farestTwo = BFS(farestOne, graph, markedVertices);
//		System.out.println(farestOne + " " + farestTwo);
		int[] dis = BFS1(farestOne, graph, k);
		int[] dis1 = BFS1(farestTwo, graph, k);
		for (int i = 0; i < graph.size() - 1; i++) {
			if (dis[i] < k && dis1[i] < k) {
				System.out.println(i);
			}
		}
	}

	static void addEdge(List<List<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
		graph.get(v).add(u);
	}

	private static int BFS(int i, List<List<Integer>> graph, Map<Integer, Integer> markedVertices) {
		Queue<Integer> q = new LinkedList<>();
		int vis[] = new int[graph.size()];
		q.add(i);
		q.add(null);
		int farestNode = i;
		vis[i] = 1;
		int level = 0;
		while (!q.isEmpty()) {
			Integer top = q.remove();
			if (top == null) {
				level++;
				if (!q.isEmpty()) {
					q.add(null);
				}
				continue;
			}
			vis[top] = 1;
			List<Integer> edges = graph.get(top);
			for (int j = 0; j < edges.size(); j++) {
				if (vis[edges.get(j)] == 0) {
					if (markedVertices.get(edges.get(j)) != null) {
						farestNode = edges.get(j);
					}
					q.add(edges.get(j));
				}
			}
		}
		return farestNode;
	}

	private static int[] BFS1(int i, List<List<Integer>> graph, int k) {
		Queue<Integer> q = new LinkedList<>();
		int vis[] = new int[graph.size()];
		q.add(i);
		q.add(null);
		int dis[] = new int[graph.size()];
		vis[i] = 1;
		int level = 0;
		while (!q.isEmpty()) {
			Integer top = q.remove();
			if (top == null) {
				level++;
				if (!q.isEmpty()) {
					q.add(null);
				}
				continue;
			}
			vis[top] = 1;
			List<Integer> edges = graph.get(top);
			for (int j = 0; j < edges.size(); j++) {
				if (vis[edges.get(j)] == 0) {
					dis[edges.get(j)] = level;
					q.add(edges.get(j));
				}
			}
		}
		return dis;
	}
}