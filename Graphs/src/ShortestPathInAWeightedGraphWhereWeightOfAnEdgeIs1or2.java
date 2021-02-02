package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInAWeightedGraphWhereWeightOfAnEdgeIs1or2 {

	public static void main(String[] args) {
		List<List<Edge>> graph = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			graph.add(new ArrayList<>());
		}
//		addEdge(graph, 0, 1, 1);
//		addEdge(graph, 0, 2, 2);
//		addEdge(graph, 2, 3, 1);
//		addEdge(graph, 1, 3, 2);
//		addEdge(graph, 1, 4, 1);
//		addEdge(graph, 3, 5, 2);
//		addEdge(graph, 4, 6, 1);
//		addEdge(graph, 6, 5, 1);
//		addEdge(graph, 6, 7, 1);
//		addEdge(graph, 7, 5, 1);
//		addEdge(graph, 5, 8, 1);
//		addEdge(graph, 7, 9, 2);
		 addEdge(graph, 0, 1, 2); 
         addEdge(graph, 0, 2, 2); 
         addEdge(graph, 1, 2, 1); 
         addEdge(graph, 1, 3, 1); 
         addEdge(graph, 2, 0, 1); 
         addEdge(graph, 2, 3, 2); 
         addEdge(graph, 3, 3, 2); 

		System.out.println(shortestPath(graph, 0, 3));
	}

	private static void addEdge(List<List<Edge>> graph, int u, int v, int w) {
		graph.get(u).add(new Edge(u, v, w));
		graph.get(v).add(new Edge(v, u, w));
	}

	private static Integer shortestPath(List<List<Edge>> graph, int s, int d) {
		Queue<Edge> q = new LinkedList<>();
		q.add(new Edge(s, s, 0));
		q.add(null);
		int level = 0;
		int[] vis = new int[graph.size()];
		while (!q.isEmpty()) {
			Edge top = q.remove();
			if (top != null) {
				if (top.weight > level) {
					q.add(top);
					continue;
				}
				if (vis[top.u] == 1) {
					continue;
				}
				if (top.u == d) {
					return level;
				}
				vis[top.u] = 1;
				List<Edge> edges = graph.get(top.u);
				for (int i = 0; i < edges.size(); i++) {
					Edge edge = edges.get(i);
					if (vis[edge.v] == 0) {
						q.add(new Edge(edge.v, edge.v, top.weight + edge.weight));
					}
				}
			} else if (!q.isEmpty()) {
				level++;
				q.add(null);
			}
		}
		return level;
	}

}
