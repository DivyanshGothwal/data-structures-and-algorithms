package src;

public class FirstKMaxElementsFFromBothEnds {
	
	public static void main(String [] ar) {
//		int a[] = {8, 4, 10, 9, 8,12, 7};
		int a[] = {2,9,4,1,6,3,1,8};
		int dp[][] = new int[a.length+1][a.length+1];
		int k=3;
		int arK [] = {6, 9 , 2};
		System.out.println(findSol(a,a.length, 0, a.length-1, dp,k,1, arK));
	}
	public static int findSol(int a[], int n,int start, int end, int [][] dp,  int k, int k1, int []arK) {
		if(start<end) {
			if(k==k1) {
				return Math.max(a[start]*arK[k-1],a[end]*arK[k-1]);
			}
			else {
				k1++;
			int start1 = 0, end1 =0;
			if(dp[start+1][end]!=0) {
				start1 = dp[start+1][end];
			}
			else {
				start1 = findSol(a,n,start+1,end, dp, k, k1, arK);
				dp[start+1][end] = start1;
			}
			if(dp[start][end-1]!=0) {
				end1 = dp[start][end-1];
			}
			else {
				
				end1 = findSol(a,n,start,end-1, dp, k , k1, arK);
				dp[start][end-1]= end1;
			}
			k1--;
			return Math.max((a[start]*arK[k1-1])+start1,(a[end]*arK[k1-1])+end1);
			}
		}
		return 0;
	}
		
}
