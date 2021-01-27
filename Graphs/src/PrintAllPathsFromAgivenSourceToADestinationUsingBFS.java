package src;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPathsFromAgivenSourceToADestinationUsingBFS {

	public static void main(String[] args) {
		int m = 4;
		List<List<Integer>> graph = new ArrayList<>(m);
		for (int i = 0; i < m; i++) {
			graph.add(new ArrayList<>());
		}
//		graph.get(1).add(2);
//		graph.get(1).add(3);
//		graph.get(2).add(4);
//		graph.get(2).add(5);
//		graph.get(2).add(1);
//		graph.get(3).add(1);
//		graph.get(3).add(4);
//		graph.get(3).add(6);
//		graph.get(4).add(2);
//		graph.get(4).add(3);
//		graph.get(4).add(5);
//		graph.get(4).add(6);
//		graph.get(5).add(2);
//		graph.get(5).add(4);
//		graph.get(5).add(6);
//		graph.get(6).add(3);
//		graph.get(6).add(4);
//		graph.get(6).add(5);
//		graph.get().add(5);
		graph.get(2).add(0);
		graph.get(2).add(1);
		graph.get(0).add(3);
		graph.get(0).add(1);
		graph.get(0).add(2);
		graph.get(1).add(3);
		findPaths(graph, 2, 3);
	}

	private static void findPaths(List<List<Integer>> graph, int src, int des) {
		int vis[] = new int[graph.size()];
		List<Integer> path = new ArrayList<>();
		vis[src]=1;
		findPathsUtil(src, des, graph, vis, path);
	}

	private static void findPathsUtil(int src, int des, List<List<Integer>> graph, int[] vis, List<Integer> path) {
		List<Integer> edges = graph.get(src);
		if (src == des) {
			printPath(path);
//			System.out.println();
		}
		for (int i = 0; i < edges.size(); i++) {
			int ver = edges.get(i);
			if (vis[ver] == 0) {
				path.add(src);
				vis[ver] = 1;
				findPathsUtil(ver, des, graph, vis, path);
				path.remove(path.size() - 1);
				vis[ver] = 0;
			}
		}
	}

	private static void printPath(List<Integer> path) {
		path.stream().forEach(e->System.out.print(e+" "));
		System.out.println("3");
	}

}
