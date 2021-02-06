package src;

import java.util.*;


 class QuarantineNodesTCSCodeVita {

	public static void main(String ar[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int parent[] = new int[n+1];
		int count[] = new int[n+1];
		int isParentDone[] = new int[n+1];
		int isQuarentine[] = new  int[n+1];
		for (int i = 1; i <=n; i++) {
			parent[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int k = sc.nextInt();
			isQuarentine[k]=1;
		}
		int finalCount = 0;
		for (int i = parent.length-1 ; i > 0; i--) {
			if ((count[i]!=0 || isQuarentine[i]==1)) {
				if(parent[i]!=0) {
					count[parent[i]]++;
				}
				count[i]++;
			}
			if(parent[i]==0 && count[i]!=0 && isParentDone[i]==0) {
				finalCount++;
				isParentDone[i]=1;
			}
		}
		System.out.println(finalCount);
		sc.close();
	}
}

/*
21
0 0 1 1 2 3 6 2 4 4 4 9 3 13 0 15 15 0 18 18 0
11
1 14 7 10 13 11 3 6 9 19 12
 */