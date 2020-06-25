package src;

import java.util.*;

public class CoalExtractionOfRobot {

	public static void main(String[] a) {
		Scanner sc = new Scanner(System.in);
		int depth = sc.nextInt();
		int length = sc.nextInt();
		int breadth = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int time = sc.nextInt();
		System.out.print(findSol(depth, length, breadth, x, y, time));
	}

	static int[] x = new int[] { 0, 1, -1 };
	static int[] y = new int[] { 0, 1, -1 };

	private static int findSol(int depth, int length, int breadth, int x1, int y1, int time) {
		int[][] a = new int[length][breadth];
		Queue<Tuple3> q = new LinkedList<>();
		int newX = x1;
		int newY = y1;
		int i = 0;
		int count = 0;
		int coalCount = 0;
		q.add(new Tuple3(newX, newY, 0));
		boolean[][] isVisited = new boolean[length+1][breadth+1];
		isVisited[newX][newY] = true;
		while (!q.isEmpty()) {
			Tuple3 t = q.peek();
			q.remove();
			if (i != 0 && !isVisited[t.x][t.y]) {
				count += depth + 2 * t.distance;
				if (count <= time) {
					coalCount++;
				} else {
					return coalCount;
				}
			}
			isVisited[t.x][t.y] = true;
			if (t.x + 1 <= length && !isVisited[t.x + 1][t.y]) {
				q.add(new Tuple3(t.x + 1, t.y, t.distance + 1));
			}
			if (t.x - 1 >= 0 && !isVisited[t.x - 1][t.y]) {
				q.add(new Tuple3(t.x - 1, t.y, t.distance + 1));
			}
			if (t.y + 1 <= breadth && !isVisited[t.x][t.y + 1]) {
				q.add(new Tuple3(t.x, t.y + 1, t.distance + 1));
			}
			if (t.y >= 0 && !isVisited[t.x][t.y - 1]) {
				q.add(new Tuple3(t.x, t.y - 1, t.distance + 1));
			}
			i++;
		}

		return coalCount;
	}
}

class Tuple3 {
	int x;
	int y;
	int distance;

	Tuple3(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
}
/*
 * 10 100 200 10 20 100
 */