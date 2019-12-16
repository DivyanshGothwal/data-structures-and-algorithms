package src;
import java.util.*;

public class SparseTableForMinimum {
	public static void main(String ar[]) {
		int arr[]   = {7, 2, 3, 5, 10, 3, 12, 18, 3 };		
		int [][]table = createTable(arr);
		System.out.println(query(3, 4, table));
		System.out.println(query(1, 6, table));
		System.out.println(query(7, 7, table));
	}
	public static int query(int start, int end, int [][] table) {
		int length = end-start+1;
		int index = log2(length);
		if(length%2==0) {
			return (table[index][start]);
		}
		return Math.min(table[index][start], table[index][start+index]);
	}
	public static int log2(int x){
	    return (int) (Math.log(x) / Math.log(2));
	}
	public static int[][] createTable(int a[]) {
		int n = a.length;
		int table[][] = new int[n+1][n+1];
		for(int k=0;k<n;k++) {
			table[0][k] = a[k];
		}
		int i=1;
		int j=1<<i;
		while(j<=n) {
			int k = j/2;
			int l = 0;
			while(k<n) {
				table[i][l] = Math.min(table[i-1][l],table[i-1][k]);
				l++;
				k++;
			}
			i++;
			j=1<<i;
		}
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				System.out.print(table[i][j]+" ");
			}
			System.out.println();
		}
		return table;
	}
}
