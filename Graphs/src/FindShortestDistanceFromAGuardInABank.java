package src;

import java.util.LinkedList;
import java.util.Queue;

public class FindShortestDistanceFromAGuardInABank {

	static int x[] = { 1, -1, 0 };
	static int y[] = { 1, -1, 0 };

	public static void main(String[] args) {
		char charMatrix[][] = { { 'O', 'O', 'O', 'O', 'G' }, { 'O', 'W', 'W', 'O', 'O' }, { 'O', 'O', 'O', 'W', 'O' },
				{ 'G', 'W', 'W', 'W', 'O' }, { 'O', 'O', 'O', 'O', 'G' } };
		int n = charMatrix.length;
		int m = charMatrix[0].length;
		int[][] matrix = new int[n][m];
		Queue<QueueEle> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int value = 0;
				if (charMatrix[i][j] == 'W') {
					value = -1;
				}
				if (charMatrix[i][j] == 'O') {
					value = Integer.MAX_VALUE;
				}
				if (charMatrix[i][j] == 'G') {
					q.add(new QueueEle(i, j));
				}
				matrix[i][j] = value;
			}
		}
		q.add(null);
		int level = 0;
		int[][] vis = new int[n][m];
		while (!q.isEmpty()) {
			QueueEle top = q.remove();
			if (top != null) {
				int i = top.i;
				int j = top.j;
				vis[i][j] = 1;
				if (matrix[i][j] > level) {
					matrix[i][j] = level;
				}
				for (int k = 0; k < x.length; k++) {
					for (int l = 0; l < x.length; l++) {
						int nextI = x[k] + i;
						int nextJ = y[l] + j;
						if (Math.abs(x[k]) != Math.abs(y[l]) && nextI >= 0 && nextJ >= 0 && nextJ < m && nextI < n
								&& vis[nextI][nextJ] == 0) {
							q.add(new QueueEle(nextI, nextJ));
						}
					}
				}
			} else if (!q.isEmpty()) {
				level++;
				q.add(null);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println(' ');
		}
	}

}

class QueueEle {
	int i;
	int j;

	QueueEle(int i, int j) {
		this.i = i;
		this.j = j;
	}
}