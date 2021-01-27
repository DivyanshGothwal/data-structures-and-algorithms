package src;

public class ShortestPathWithExactlyKEdgesInADirectedAndWeightedGraph {
	public static Integer INF = Integer.MAX_VALUE;

	public static void main(String[] args) {

		int[][] graph = new int[][] { { 0, 10, 3, 2 }, { INF, 0, INF, 7 }, { INF, INF, 0, 6 }, { INF, INF, INF, 0 } };

		shortestPath(graph, 2, 0, 3);
	}

	private static void shortestPath(int[][] graph, int paths, int s, int d) {
		int v = graph.length;
		int dp[][][] = new int[v][v][paths + 1];
		for (int k = 0; k <= paths; k++) {
			for (int i = 0; i < graph[0].length; i++) {
				for (int j = 0; j < graph[0].length; j++) {
					dp[i][j][k] = INF;
					if (i == j && k == 0) {
						dp[i][j][k] = 0;
					}
					if (k == 1 && graph[i][j] != INF) {
						dp[i][j][1] = graph[i][j];
					}
					if (k > 1) {
						for (int l = 0; l < v; l++) {
							if (i != l && j != l && graph[i][l] != INF && dp[l][j][k - 1] != INF) {
								dp[i][j][k] = Math.min(dp[i][j][k], dp[l][j][k - 1] + graph[i][l]);
							}
						}
					}
				}
			}
		}
		System.out.println(dp[s][d][paths]);
	}

}
