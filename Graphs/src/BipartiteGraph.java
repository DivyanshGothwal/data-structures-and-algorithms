package src;

import java.util.*;

public class BipartiteGraph {
	public static void main(String[] ar) {
		int m = 8;
		List<List<Integer>> graph = new ArrayList<List<Integer>>(m);
		for (int i = 0; i < m; i++) {
			graph.add(new ArrayList<Integer>());
		}
		graph.get(1).add(2);
		graph.get(1).add(3);
//		graph.get(2).add(4);
		graph.get(2).add(5);
		graph.get(2).add(1);
		graph.get(3).add(1);
//		graph.get(3).add(4);
		graph.get(3).add(6);
		graph.get(4).add(2);
		graph.get(4).add(3);
		graph.get(4).add(5);
		graph.get(4).add(6);
		graph.get(5).add(2);
		graph.get(5).add(4);
//		graph.get(5).add(6);
		graph.get(6).add(3);
//		graph.get(6).add(4);
//		graph.get(6).add(5);
//		graph.get().add(5);
		System.out.println(isGraphBipartite(graph, 1));
	}

	private static Boolean isGraphBipartite(List<List<Integer>> graph, int i) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		int level[] = new int[graph.size() + 1];
		level[i] = 1;
		while (!q.isEmpty()) {
			int curr = q.remove();
			List<Integer> list = graph.get(curr);
			for (int j = 0; j < list.size(); j++) {
				if (level[list.get(j)] == level[curr]) {
					return false;
				}
				if (level[list.get(j)] == 0) {
					q.add(list.get(j));
					level[list.get(j)] = level[curr] + 1;
				}
			}
		}
		return true;
	}

}
