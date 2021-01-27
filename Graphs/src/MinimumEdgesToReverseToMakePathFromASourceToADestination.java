package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MinimumEdgesToReverseToMakePathFromASourceToADestination {

	public static void main(String[] args) {
		List<Set<CustomEdge7>> graph = new ArrayList<>();
		int m = 10;
		for (int i = 0; i < m; i++) {
			graph.add(new HashSet<>());
		}
		addEdge(graph, 2, 1);
		addEdge(graph, 0, 1);
		addEdge(graph, 2, 3);
		addEdge(graph, 6, 3);
		addEdge(graph, 6, 4);
		addEdge(graph, 5, 4);
		addEdge(graph, 1, 5);

		countOfReverseEdge(graph, m, 0, 6);
	}

	private static void addEdge(List<Set<CustomEdge7>> graph, int u, int v) {
		CustomEdge7 customEdge7 = new CustomEdge7();
		customEdge7.u = u;
		customEdge7.v = v;
		customEdge7.w = 1;
		graph.get(u).add(customEdge7);
	}

	private static void countOfReverseEdge(List<Set<CustomEdge7>> graph, int size, int s, int d) {
		addReverseEdges(graph);
		System.out.println(findShortestPath(s, d, graph));
	}

	private static int findShortestPath(int s, int d, List<Set<CustomEdge7>> graph) {
		Queue<CustomQueueNode> q = new LinkedList<>();
		q.add(new CustomQueueNode(s, 0));
		q.add(null);
		int level = 0;
		int vis[] = new int[graph.size()];
		int parent[] = new int[graph.size()];
		Arrays.fill(parent, -1);
		while (!q.isEmpty()) {
			CustomQueueNode top = q.remove();
			if (top != null) {
				if (top.level > level) {
					q.add(top);
					continue;
				}
				if (vis[top.value] == 1) {
					continue;
				}
				if (top.value == d) {
					break;
				}
				vis[top.value] = 1;
				Set<CustomEdge7> edges = graph.get(top.value);
				for (CustomEdge7 edge : edges) {
					if (vis[edge.v] == 0) {
						if (parent[edge.v] == -1) {
							parent[edge.v] = edge.u;
						}
						q.add(new CustomQueueNode(edge.v, edge.w + top.level));
					}
				}
			} else if (!q.isEmpty()) {
				level++;
				q.add(null);
			}
		}

		int des = d;
		int count = 0;
		// calculating number of paths in shortest path from s to d using 1 or 2 as edge
		// weights
		while (des != s) {
			des = parent[des];
			count++;
		}
		return level - count;
	}

	private static void addReverseEdges(List<Set<CustomEdge7>> graph) {
		for (int i = 0; i < graph.size(); i++) {
			Set<CustomEdge7> edges = graph.get(i);
			for (CustomEdge7 edge : edges) {
				int s = edge.u;
				int d = edge.v;
				Set<CustomEdge7> destEdges = graph.get(d);
				CustomEdge7 srcEdge = new CustomEdge7();
				srcEdge.u = d;
				srcEdge.v = s;
				srcEdge.w = 2;
				boolean isPresent = destEdges.contains(srcEdge);
				if (!isPresent) {
					destEdges.add(srcEdge);
				}
			}
		}
	}
}

class CustomQueueNode {
	int value;
	int level;

	CustomQueueNode(int v, int l) {
		this.value = v;
		this.level = l;
	}
}

class CustomEdge7 {
	int u, v, w;

	@Override
	public int hashCode() {
		return this.v + this.u;
	}

	@Override
	public boolean equals(Object obj) {
		boolean isEqual = false;
		if (obj instanceof CustomEdge7) {
			CustomEdge7 customEdge7 = (CustomEdge7) obj;
			if (customEdge7.u == this.u && customEdge7.v == this.v) {
				isEqual = true;
			}
		}
		return isEqual;
	}
}