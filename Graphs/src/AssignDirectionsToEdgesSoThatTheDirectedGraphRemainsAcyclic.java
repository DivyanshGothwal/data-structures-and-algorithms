package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AssignDirectionsToEdgesSoThatTheDirectedGraphRemainsAcyclic {
	static int time = 0;

	public static void main(String[] ar) {
		List<List<CustomEdge>> graph = new ArrayList<>();
		int v = 6;
		for (int i = 0; i < v; i++) {
			graph.add(new ArrayList<>());
		}
		addDirectedEdge(graph, 0, 1, false);
		addDirectedEdge(graph, 0, 5, false);
		addDirectedEdge(graph, 1, 2, false);
		addDirectedEdge(graph, 1, 3, false);
		addDirectedEdge(graph, 1, 4, false);
		addDirectedEdge(graph, 2, 3, false);
		addDirectedEdge(graph, 2, 4, false);
		addDirectedEdge(graph, 5, 1, false);
		addDirectedEdge(graph, 5, 2, false);
		addDirectedEdge(graph, 0, 2, true);
		addDirectedEdge(graph, 0, 3, true);
		addDirectedEdge(graph, 5, 4, true);
		topologicalSort(graph);
	}

	private static void topologicalSort(List<List<CustomEdge>> graph) {
		List<CustomDep> dep = new ArrayList<>();
		int vis[] = new int[graph.size()];
		for (int i = 0; i < graph.size(); i++) {
			topologicalSortUtil(i, graph, dep, vis);
		}
		createDirections(graph, dep);
	}

	private static void createDirections(List<List<CustomEdge>> graph, List<CustomDep> dep) {
		Collections.sort(dep, (a, b) -> b.dep.compareTo(a.dep));
		dep.forEach(e -> System.out.println("u:" + e.u + " dep: " + e.dep));
		int vis[] = new int[graph.size()];
		for (int i = 0; i < dep.size(); i++) {
			CustomDep customDep = dep.get(i);
			Integer v = customDep.u;
			List<CustomEdge> edges = graph.get(v);
			for (int j = 0; j < edges.size(); j++) {
				CustomEdge edge = edges.get(j);
				if (edge.isBlue && vis[edge.v] == 0) {
					edge.isBlue = false;
					System.out.println("u:" + edge.u + " v: " + edge.v);
				}
			}
			vis[v] = 1;
		}
	}

	private static void topologicalSortUtil(int i, List<List<CustomEdge>> graph, List<CustomDep> dep, int vis[]) {
		List<CustomEdge> edges = graph.get(i);
		if (vis[i] == 1) {
			return;
		}
		vis[i] = 1;
		for (int j = 0; j < edges.size(); j++) {
			CustomEdge edge = edges.get(j);
			if (!edge.isBlue && vis[edge.v] == 0) {
				topologicalSortUtil(edge.v, graph, dep, vis);
			}
		}
		dep.add(new CustomDep(i, ++time));
	}

	private static void addDirectedEdge(List<List<CustomEdge>> graph, int i, int j, Boolean isBlue) {
		graph.get(i).add(new CustomEdge(i, j, isBlue));
		if (Boolean.TRUE.equals(isBlue)) {
			graph.get(j).add(new CustomEdge(j, i, isBlue));
		}
	}
}

class CustomEdge {
	int u, v;
	Boolean isBlue;

	CustomEdge(int u, int v, Boolean isBlue) {
		this.u = u;
		this.v = v;
		this.isBlue = isBlue;
	}
}

class CustomDep {
	Integer u, dep;

	CustomDep(int u, int dep) {
		this.u = u;
		this.dep = dep;
	}
}