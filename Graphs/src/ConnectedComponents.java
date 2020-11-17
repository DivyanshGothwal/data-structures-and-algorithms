package src;

import java.util.*;

public class ConnectedComponents {
	public static void main(String[] ar) {
		int m = 8;
		List<List<Integer>> graph = new ArrayList<List<Integer>>(m);
		for (int i = 0; i < m; i++) {
			graph.add(new ArrayList<Integer>());
		}
		graph.get(1).add(2);
		graph.get(1).add(3);
//		graph.get(2).add(4);
//		graph.get(2).add(5);
		graph.get(2).add(1);
		graph.get(3).add(1);
//		graph.get(3).add(4);
//		graph.get(3).add(6);
//		graph.get(4).add(2);
//		graph.get(4).add(3);
		graph.get(4).add(5);
//		graph.get(4).add(6);
		graph.get(5).add(2);
		graph.get(5).add(4);
//		graph.get(5).add(6);
//		graph.get(6).add(3);
//		graph.get(6).add(4);
//		graph.get(6).add(5);
//		graph.get().add(5);
		conneectedComponents(graph, m - 1);
	}

	private static void conneectedComponents(List<List<Integer>> graph, int n) {
		int isVisited[] = new int[n+1];
		int count =0 ;
		for (int i = 1; i <= n; i++) {
			if (isVisited[i] == 0) {
				findConnectedComponent(i, graph, isVisited);
				count++;
			}
		}
		System.out.println(count);
	}

	private static void findConnectedComponent(int index, List<List<Integer>> graph, int[] isVisited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(index);
		isVisited[index] = 1;
		while (!queue.isEmpty()) {
			int curr = queue.remove();
//			System.out.println(curr);
			List<Integer> adjList = graph.get(curr);
			for (int i = 0; i < adjList.size(); i++) {
				if (isVisited[adjList.get(i)] == 0) {
					queue.add(adjList.get(i));
					isVisited[adjList.get(i)] = 1;
				}
			}
		}
	}
}
