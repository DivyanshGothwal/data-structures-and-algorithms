package src;

import java.util.ArrayList;
import java.util.List;

public class DijkstraAlogrithm {

	static List<Edge> edges = null;

	public static void main(String[] a) {
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
		findShortestPath(graph);
	}

	private static void findShortestPath(List<List<Edge>> graph) {
		Heap h = new Heap(graph.size());
		int d[] = new int[graph.size()];
		int p[] = new int[graph.size()];
		for (int i = 1; i < graph.size(); i++) {
			h.insert(i, Integer.MAX_VALUE);
			d[i] = Integer.MAX_VALUE;
			p[i] = i;
		}
		h.decreasePriority(h.new HeapEle(1, Integer.MAX_VALUE), 0);
		d[1] = 0;
		while (!h.isEmpty()) {
			Heap.HeapEle minEle = h.extractMin();
			List<Edge> list = graph.get(minEle.e);
			for (int i = 0; i < list.size(); i++) {
				Edge adjecentEdge = list.get(i);
				int minVal = Math.min(d[adjecentEdge.v], d[adjecentEdge.u] + adjecentEdge.weight);
				if (d[adjecentEdge.v] > d[adjecentEdge.u] + adjecentEdge.weight) {
					h.decreasePriority(h.new HeapEle(adjecentEdge.v, d[adjecentEdge.v]), minVal);
					d[adjecentEdge.v] = minVal;
					p[adjecentEdge.v] = adjecentEdge.u;
				}
			}
		}
		for (int i = 1; i < d.length; i++) {
			System.out.println(d[i] + " u to v : " + p[i] + " " + i);
		}
	}

	public static void addUndirectedEdge(List<List<Edge>> graph, int u, int v, int w) {
		graph.get(u).add(new Edge(u, v, w));
		graph.get(v).add(new Edge(v, u, w));
	}
}
