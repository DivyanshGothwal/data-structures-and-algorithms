package src;

import java.util.ArrayList;
import java.util.List;

public class MotherVertexInAGraph {
	static int lastVisitedVertex = 1;

	public static void main(String ar[]) {
		List<List<Edge>> graph = new ArrayList<>();
		int n = 7;
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		addUndirectedEdge(graph, 1, 2, 12);
		addUndirectedEdge(graph, 2, 4, 12);
		addUndirectedEdge(graph, 1, 3, 12);
		addUndirectedEdge(graph, 6, 3, 12);
		addUndirectedEdge(graph, 6, 7, 12);
		addUndirectedEdge(graph, 7, 1, 12);
		addUndirectedEdge(graph, 7, 5, 12);
		addUndirectedEdge(graph, 5, 2, 12);
		findMotherVertex(graph);
	}

	private static void findMotherVertex(List<List<Edge>> graph) {
		int vis[] = new int[graph.size()];
		for (int i = 1; i < graph.size(); i++) {
			if (vis[i] == 0) {
				DFS(graph, i, vis);
			}
		}
		for (int i = 1; i < graph.size(); i++) {
			vis[i] = 0;
		}
		DFS(graph, lastVisitedVertex, vis);
		for (int i = 1; i < graph.size(); i++) {
			if (vis[i] == 0) {
				System.out.println("No Mother vertex");
				return;
			}
		}
		System.out.println(lastVisitedVertex);
	}

	private static void DFS(List<List<Edge>> graph, int i, int vis[]) {
		List<Edge> list = graph.get(i);
		vis[i] = 1;
		for (int j = 0; j < list.size(); j++) {
			Edge edge = list.get(j);
			if (vis[edge.v] == 0) {
				DFS(graph, edge.v, vis);
			}
		}
		lastVisitedVertex = i;
	}

	public static void addUndirectedEdge(List<List<Edge>> graph, int u, int v, int w) {
		graph.get(u).add(new Edge(u, v, w));
	}
}
