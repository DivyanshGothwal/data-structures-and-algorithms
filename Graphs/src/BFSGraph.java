package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph {
	public static void main(String[] ar) {
		int m = 7;
		List<List<Integer>> graph = new ArrayList<List<Integer>>(m);
		for (int i = 0; i < m; i++) {
			graph.add(new ArrayList<Integer>());
		}
		graph.get(1).add(2);
		graph.get(1).add(3);
		graph.get(2).add(4);
		graph.get(2).add(5);
		graph.get(2).add(1);
		graph.get(3).add(1);
		graph.get(3).add(4);
		graph.get(3).add(6);
		graph.get(4).add(2);
		graph.get(4).add(3);
		graph.get(4).add(5);
		graph.get(4).add(6);
		graph.get(5).add(2);
		graph.get(5).add(4);
		graph.get(5).add(6);
		graph.get(6).add(3);
		graph.get(6).add(4);
		graph.get(6).add(5);
		BFS(graph, 3);
	}

	private static void BFS(List<List<Integer>> graph, int index) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(index);
		int isVisited[] = new int[graph.size()];
		isVisited[index] = 1;
		while (!queue.isEmpty()) {
			int curr = queue.remove();
			System.out.println(curr);
			List<Integer> adjecentVertex = graph.get(curr);
			for (int i = 0; i < adjecentVertex.size(); i++) {
				if (isVisited[adjecentVertex.get(i)] == 0) {
					queue.add(adjecentVertex.get(i));
					isVisited[adjecentVertex.get(i)] = 1;
				}
			}
		}
	}
}
