package src;

import java.util.ArrayList;
import java.util.List;

public class DFS {
	static int k = 0;

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
		
		graph.get(3).add(4);
		graph.get(4).add(3);
		
		graph.get(3).add(6);
		graph.get(6).add(3);
		
		graph.get(4).add(5);
		graph.get(5).add(4);
		
		graph.get(4).add(6);
		graph.get(6).add(4);
		
		graph.get(5).add(6);
		graph.get(6).add(5);
		int visited[] = new int[m];
		int a[] = new int[m];
		int d[] = new int[m];
		DFS(graph, 1, visited, a, d);
		System.out.println();
		for(int i=1;i<m;i++) {
			System.out.println(a[i]);
		}
		System.out.println();
		for(int i=1;i<m;i++) {
			System.out.println(d[i]);
		}
	}

	private static void DFS(List<List<Integer>> graph, int i, int[] visited, int[] a, int[] d) {
		visited[i] = 1;
		a[i] = ++k;
		System.out.println(i);
		List<Integer> list = graph.get(i);
		for (int j = 0; j < list.size(); j++) {
			if (visited[list.get(j)] == 0) {
				DFS(graph, list.get(j), visited, a, d);
				visited[list.get(j)] = 1;
			}
		}
		d[i] = ++k;
	}

}
