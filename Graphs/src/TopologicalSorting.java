package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TopologicalSorting {
	static int time = 0;
	static Stack<Integer> st = null;

	public static void main(String ar[]) {

	}

	static int[] topolicalSort(ArrayList<ArrayList<Integer>> adj, int n) {
		int dep[] = new int[n];
		int vis[] = new int[n];
		st = new Stack<>();
		List<Integer> zeroDeg = getZeroInDegreeVertex(adj);
		time = 0;
		for (int i = 0; i < zeroDeg.size(); i++) {
			DFS(zeroDeg.get(i), adj, n, dep, vis);
		}
		int k = 0;
//		Map<Integer, Integer> map = new TreeMap<>((Integer a, Integer b) -> b.compareTo(a));
//		for (int i = 0; i < dep.length; i++) {
//			map.put(dep[i], i);
//		}
//		Set<Map.Entry<Integer, Integer>> s = map.entrySet();

//		for (Map.Entry<Integer, Integer> it : s) {
//			dep[k] = it.getValue();
//			k++;
//		}
		while (!st.isEmpty()) {
			dep[k] = st.pop();
			k++;
		}
		return dep;
	}

	static List<Integer> getZeroInDegreeVertex(ArrayList<ArrayList<Integer>> adj) {
		int deg[] = new int[adj.size() - 1];
		List<Integer> zeroDeg = new ArrayList<Integer>();
		for (int i = 0; i < adj.size() - 1; i++) {
			ArrayList<Integer> list = adj.get(i);
			for (int j = 0; j < list.size(); j++) {
				deg[list.get(j)]++;
			}
		}
		for (int i = 0; i < adj.size() - 1; i++) {
			if (deg[i] == 0) {
				zeroDeg.add(i);
			}
		}
		return zeroDeg;
	}

	static void DFS(int i, ArrayList<ArrayList<Integer>> adj, int n, int[] dep, int vis[]) {
		vis[i] = 1;
		ArrayList<Integer> list = adj.get(i);
		for (int j = 0; j < list.size(); j++) {
			if (vis[list.get(j)] != 1) {
				DFS(list.get(j), adj, n, dep, vis);
			}
		}
		dep[i] = time++;
		st.push(i);
	}
}
