package src;

import java.util.ArrayList;
import java.util.List;

public class CheckCycleInDirectedGraph {
	static Integer time = 0;

	public static void main(String ar[]) {
		List<List<Integer>> graph = new ArrayList<>();
		int v = 7;
		for (int i = 0; i <= v; i++) {
			graph.add(new ArrayList<>());
		}
		addDirectedEdge(graph, 1, 2);
		addDirectedEdge(graph, 2, 4);
		addDirectedEdge(graph, 4, 6);
		addDirectedEdge(graph, 4, 1);
		addDirectedEdge(graph, 3, 4);
		addDirectedEdge(graph, 3, 1);
//		addDirectedEdge(graph, 6, 3);
		System.out.println(checkCycle(graph));

	}

	static void addDirectedEdge(List<List<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
	}

	static boolean checkCycle(List<List<Integer>> graph) {
		int visited[] = new int[graph.size() + 1];
		int dep[] = new int[graph.size() + 1];
		boolean isCycle = false;
		for (int i = 1; i < graph.size(); i++) {
			if (visited[i] == 0) {
				isCycle = isCycle || checkCycleUtil(graph, i, visited, dep);
			}
		}
		return isCycle;
	}

	private static boolean checkCycleUtil(List<List<Integer>> graph, int i, int[] visited, int[] dep) {
		List<Integer> list = graph.get(i);
		visited[i] = 1;
		boolean isCycle = false;
		for (int j = 0; j < list.size(); j++) {
			if (visited[list.get(j)] == 0) {
				isCycle = isCycle || checkCycleUtil(graph, list.get(j), visited, dep);
			} else if (dep[list.get(j)] == 0) {
				// back edge check for Directed graph
				// and for edge u->v dep[u] < dep[v]
				isCycle = true;
			}
		}
		dep[i] = ++time;
		return isCycle;
	}
}
