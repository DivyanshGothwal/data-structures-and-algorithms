package src;

import java.util.*;

public class LCAOfNArrayTreeUsingRMQ {

	public static void main(String ar[]) {
		for(int i=1;i<50;i++) {
//			System.out.print(log2(i)+" ");
		}
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		List<List<tuple>> graph = new ArrayList<List<tuple>>();
		for (int i = 0; i <= v; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < e; i++) {
			int s = sc.nextInt();
			int end = sc.nextInt();
			graph.get(s).add(new tuple(end, 0));
		}
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();
		
		int eulerTour[] = new int[2 * v];
		findEulerTour(new tuple(1,0), graph, eulerTour);
		System.out.println(findLCAFromEulersTour(eulerTour, v1, v2));
	}

	private static int findLCAFromEulersTour(int[] eulerTour, int v1, int v2) {
		int n = eulerTour.length;
		int a[][] = new int[n-1][n-1];
		int i=1;
		int j=1<<i;
		for(i=0;i<n-1;i++) {
			a[0][i] = eulerTour[i];
		}
		i=1;
		
		while(j<n-1) {
			int l= 1<<(i-1);int k=0;
			while(k+l<n-1) {
				a[i][k] = Math.min(a[i-1][k],a[i-1][k+l]);
				k++;
			}
			j=1<<i;
			i++;
		}
		int firstOccurance []= new int[n];
		for(i=n-1;i>=0;i--) {
			firstOccurance[eulerTour[i]]=i;
		}
		int startIndex = firstOccurance[v1];
		int endIndex = firstOccurance[v2];
		int length = Math.abs(endIndex - startIndex) +1;
		startIndex = Math.min(startIndex, endIndex);
		int row = log2(length);
		if(length%2==0) {
			return a[row][v1];
		}
		return Math.min(a[row][startIndex], a[row][startIndex-(1<<(row))+length]);
	}

	static int k = 0;
	public static int log2(int x){
	    return (int) (Math.log(x) / Math.log(2));
	}
	private static void findEulerTour(tuple start, List<List<tuple>> graph, int[] eulerTour) {
		List<tuple> edges = graph.get(start.dest);
		eulerTour[k] = start.dest;
		k++;
		int i =0;
		for (i = 0; i < edges.size(); i++) {

			findEulerTour(edges.get(i), graph, eulerTour);
			eulerTour[k] = start.dest;
			k++;
		}
		if(edges.size()>0 && i!= edges.size()) {
			eulerTour[k] = start.dest;
			k++;
		}
	}
}



/*
 * 18 17
1 2
1 3
1 4
2 5
3 6
3 7
4 9
4 8
4 16
4 17
16 18
5 11
5 10
6 12
7 13
9 14
8 15
14 18
 */