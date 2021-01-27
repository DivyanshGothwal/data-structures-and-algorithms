package src;

import java.util.ArrayList;
import java.util.List;

public class CheckCycleInUndirectedGraph {
	static Integer time = 0;

	public static void main(String ar[]) {
		List<List<Integer>> graph = new ArrayList<>();
		int v = 7;
		for (int i = 0; i <= v; i++) {
			graph.add(new ArrayList<>());
		}
		addEdge(graph, 1, 2);
		addEdge(graph, 2, 4);
//		addEdge(graph, 4, 6);
//		addEdge(graph, 4, 1);
//		addEdge(graph, 3, 4);
		addEdge(graph, 3, 1);
//		addEdge(graph, 6, 3);
		System.out.println(checkCycle(graph));

	}

	static void addEdge(List<List<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
		graph.get(v).add(u);
	}

	static boolean checkCycle(List<List<Integer>> graph) {
		int visited[] = new int[graph.size() + 1];
		int dep[] = new int[graph.size() + 1];
		boolean isCycle = false;
		for (int i = 1; i < graph.size(); i++) {
			if (visited[i] == 0) {
				isCycle = isCycle || checkCycleUtil(graph, i, visited, dep, null);
			}
		}
		return isCycle;
	}

	private static boolean checkCycleUtil(List<List<Integer>> graph, Integer i, int[] visited, int[] dep, Integer parent) {
		List<Integer> list = graph.get(i);
		visited[i] = 1;
		boolean isCycle = false;
		for (int j = 0; j < list.size(); j++) {
			if (visited[list.get(j)] == 0) {
				isCycle = isCycle || checkCycleUtil(graph, list.get(j), visited, dep, i);
			} else if (dep[list.get(j)] == 0 && !list.get(j).equals(parent)) {
				// back edge check for undirected graph
				// and for every edge u->v dep[u] < dep[v]
				isCycle = true;
			}
		}
		dep[i] = ++time;
		return isCycle;
	}
}
