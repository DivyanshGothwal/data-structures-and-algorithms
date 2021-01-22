package src;

import java.util.ArrayList;
import java.util.List;

public class AllTopologicalSortsOfADirectedAcyclicGraph {

	public static void main(String ar[]) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			graph.add(new ArrayList<>());
		}
		addEdge(graph, 5, 0);
		addEdge(graph, 5, 2);
		addEdge(graph, 4, 1);
		addEdge(graph, 4, 0);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 1);
		allTopologicalSorts(graph);
	}

	private static void allTopologicalSorts(List<List<Integer>> graph) {
		int[] indeg = new int[graph.size()];
		for (int i = 0; i < graph.size(); i++) {
			List<Integer> edges = graph.get(i);
			for (int j = 0; j < edges.size(); j++) {
				indeg[edges.get(j)]++;
			}
		}
		int vis[] = new int[graph.size()];
		List<Integer> sol = new ArrayList<>();
		for (int i = 0; i < indeg.length; i++) {
			if (indeg[i] == 0 && vis[i] == 0) {
				sol.add(i);
				allTopologicalSortsUtil(i, graph, indeg, vis, sol);
				sol.remove(sol.size() - 1);
			}
		}
	}

	public static void allTopologicalSortsUtil(int ver, List<List<Integer>> graph, int[] indeg, int[] vis,
			List<Integer> sol) {
		vis[ver] = 1;
		List<Integer> edges = graph.get(ver);
		for (int i = 0; i < edges.size(); i++) {
			indeg[edges.get(i)]--;
		}
		boolean isAllVerticesVisited = true;
		for (int i = 0; i < indeg.length; i++) {
			if (indeg[i] == 0 && vis[i] == 0) {
				sol.add(i);
				allTopologicalSortsUtil(i, graph, indeg, vis, sol);
				sol.remove(sol.size() - 1);
				isAllVerticesVisited = false;
			}
		}
		vis[ver] = 0;
		for (int j = 0; j < edges.size(); j++) {
			indeg[edges.get(j)]++;
		}
		if (isAllVerticesVisited) {
			sol.stream().forEach(e -> System.out.print(e + " "));
			System.out.println();
		}
	}

	public static void addEdge(List<List<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
	}
}
