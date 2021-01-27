package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectCycleUsingDisjointSet {
	static UnionFind[] sets = new UnionFind[10];

	public static void main(String[] ar) {
		for (int i = 0; i < 10; i++) {
			sets[i] = new UnionFind(-1, i);
		}
		System.out.println(find(sets[0]).parent);
		System.out.println(find(sets[1]).parent);
		System.out.println(find(sets[2]).parent);
		System.out.println(find(sets[3]).parent);
//		union(find(sets[3]), find(sets[4]));
//		union(find(sets[0]), find(sets[1]));
//		union(find(sets[1]), find(sets[2]));
//		union(find(sets[1]), find(sets[4]));
//		union(find(sets[3]), find(sets[5]));
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			graph.add(new ArrayList<>());
		}

		addEdge(graph, 1, 2);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);
		addEdge(graph, 4, 5);
		addEdge(graph, 5, 6);
		addEdge(graph, 6, 7);
		addEdge(graph, 7, 8);
		addEdge(graph, 1, 8);
		System.out.println(findCycle(graph));
	}

	public static Boolean findCycle(List<List<Integer>> graph) {
		List<Edge> listOfEdges = new ArrayList<>();
		Map<CustomEdge1, Integer> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			List<Integer> edges = graph.get(i);
			for (int j = 0; j < edges.size(); j++) {
				Integer value = map.get(new CustomEdge1(i, edges.get(j)));
				if (value == null) {
					listOfEdges.add(new Edge(i, edges.get(j), 0));
					map.put(new CustomEdge1(i, edges.get(j)), 1);
				}
			}
		}
		for (int i = 0; i < listOfEdges.size(); i++) {
			Edge edge = listOfEdges.get(i);
			UnionFind u = find(sets[edge.u]);
			UnionFind v = find(sets[edge.v]);
			if (u.ele == v.ele) {
				return true;
			}
			union(u, v);
		}
		return false;
	}

	public static void addEdge(List<List<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
		graph.get(v).add(u);
	}

	public static UnionFind find(UnionFind u) {
		if (u.parent == -1) {
			return u;
		}
		UnionFind parent = find(sets[u.parent]);
		u.parent = parent.ele;
		return parent;
	}

	public static void union(UnionFind u, UnionFind v) {
		v.parent = u.ele;
	}
}

class UnionFind {
	int parent;
	int ele;
	int weight;

	UnionFind(int i, int ele) {
		this.parent = i;
		this.ele = ele;
		this.weight = 0;
	}
}

class CustomEdge1 extends Edge {

	CustomEdge1(Integer u, Integer v) {
		super(u, v, 0);
	}

	@Override
	public int hashCode() {
		return u + v;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof CustomEdge1) {
			CustomEdge1 edge = (CustomEdge1) o;
			if ((this.u == edge.u || this.u == edge.v) && (this.v == edge.u || this.v == edge.v)) {
				return true;
			}
		}
		return false;
	}
}