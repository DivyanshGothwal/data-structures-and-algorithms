package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class KruskalsAlgorithm {
	static List<Edge> edges;

	public static void main(String ar[]) {
		List<List<Edge>> graph = new ArrayList<>();
		int m = 8;
		for (int i = 0; i <= m; i++) {
			graph.add(new ArrayList<>());
		}
		edges = new ArrayList<>();
		addUndirectedEdge(graph, 1, 2, 10);
		addUndirectedEdge(graph, 2, 4, 5);
		addUndirectedEdge(graph, 4, 8, 12);
		addUndirectedEdge(graph, 8, 5, 1);
		addUndirectedEdge(graph, 1, 5, 8);
		addUndirectedEdge(graph, 5, 3, 6);
		addUndirectedEdge(graph, 3, 6, 5);
		addUndirectedEdge(graph, 6, 7, 7);
		addUndirectedEdge(graph, 1, 7, 4);
		addUndirectedEdge(graph, 1, 3, 4);
		addUndirectedEdge(graph, 1, 4, 2);
		List<Edge> edgesInMST = findMST(graph);
		System.out.println(edgesInMST);
	}

	public static List<Edge> findMST(List<List<Edge>> graph) {
		edges.sort((Edge a, Edge b) -> {
			return a.weight.compareTo(b.weight);
		});
		DisjointSet[] sets = new DisjointSet[graph.size() + 1];
		for (int i = 0; i <= graph.size(); i++) {
			sets[i] = new DisjointSet(i, null, 0);
		}
		return edges.stream().map(e -> {
			DisjointSet u = find(sets[e.u]);
			DisjointSet v = find(sets[e.v]);
			if (!u.ele.equals(v.ele)) {
				union(u, v);
				return e;
			}
			return null;
		}).filter(Objects::nonNull).collect(Collectors.toList());
	}

	public static DisjointSet find(DisjointSet set) {
		if (set.parent == null) {
			return set;
		}
		DisjointSet parent = find(set.parent);
		set.parent = parent;
		return parent;
	}

	public static void union(DisjointSet set1, DisjointSet set2) {
		if (set1.nodes > set2.nodes) {
			set2.parent = set1;
			set1.nodes += set2.nodes;
		} else {
			set1.parent = set2;
			set2.nodes += set1.nodes;
		}
	}

	public static void addUndirectedEdge(List<List<Edge>> graph, int u, int v, Integer weight) {
		Edge edge1 = new Edge(u, v, weight);
		Edge edge2 = new Edge(v, u, weight);
		graph.get(u).add(edge1);
		graph.get(v).add(edge2);
		edges.add(edge1);
	}
}

class Edge {
	Integer u, v, weight;

	Edge(Integer u, Integer v, Integer weight) {
		this.u = u;
		this.v = v;
		this.weight = weight;
	}
}