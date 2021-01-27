package src;

import java.util.ArrayList;
import java.util.List;

public class TwoEdgeConnectivity {
	static int time = 0;
	static Boolean isPossible = true;

	public static void main(String[] ar) {
		int m = 7;
		List<List<Integer>> graph = new ArrayList<List<Integer>>(m);
		for (int i = 0; i < m; i++) {
			graph.add(new ArrayList<Integer>());
		}
		graph.get(1).add(2);
		graph.get(2).add(1);

		graph.get(1).add(3);
		graph.get(3).add(1);

		graph.get(2).add(4);
		graph.get(4).add(2);

		graph.get(2).add(5);
		graph.get(5).add(2);

		graph.get(1).add(4);
		graph.get(4).add(1);

//		graph.get(3).add(6);
//		graph.get(6).add(3);

		graph.get(4).add(5);
		graph.get(5).add(4);

		graph.get(4).add(6);
		graph.get(6).add(4);

		graph.get(5).add(6);
		graph.get(6).add(5);
		int visited[] = new int[m];
		int arr[] = new int[m];
		twoEdge(graph, 3, arr, visited, 3, null);
		System.out.println(isPossible);
	}

	private static int twoEdge(List<List<Integer>> graph, int i, int[] arr, int[] visited, int root, Integer parent) {
		arr[i] = ++time;
		visited[i] = 1;
		int deepestBackEdge = arr[i];
		System.out.println(i);
		List<Integer> list = graph.get(i);
		for (int j = 0; j < list.size(); j++) {
			if (visited[list.get(j)] == 0) {
				deepestBackEdge = Math.min(deepestBackEdge, twoEdge(graph, list.get(j), arr, visited, root, i));
			} else if (!list.get(j).equals(parent)) {
				deepestBackEdge = Math.min(arr[list.get(j)], deepestBackEdge);
			}
		}
		if (i != root && deepestBackEdge >= arr[i]) {
			isPossible = false;
		}
		return deepestBackEdge;
	}
}