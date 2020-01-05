package src.dp_with_bitmasking;

import java.util.Arrays;

public class PartitionOfArrayIntoKEqualPart {
	public static void main(String[] args) {
		Solution s = new Solution();
		int a[] = {4,3,2,3,5,2,1};
		System.out.println(s.canPartitionKSubsets(a,4));
	}
}

class Solution {
	int dp[] = new int[1<<16];
    public boolean canPartitionKSubsets(int[] a, int k) {
        int n = a.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
        }
        if(sum%k!=0){
            return false;
        }
        int kSum=sum/k;
        int visited[] = new int[n];
        Arrays.sort(a);
        Arrays.stream(a).forEach(e->System.out.print(e));
        System.out.println(" kaSum: "+kSum);
        return isGivenSumPossible(0,a,0,k,0,kSum, 0);
    }
    public boolean isGivenSumPossible(int start, int []a, int k1,int k, int k1Sum, int kSum, int visited) {
        if(k1>=k && k1Sum==0){
            return true;
        }
        else if(k1>=k ){
            return false;
        }
        int n = a.length;
        boolean isPossible = false;
        for(int i=0;i<n;i++){
            if((visited&(1<<i))==0){
            	visited = visited | (1<<i);
                if((a[i]+k1Sum)<kSum){
//                    System.out.print("i:"+i+" before first k1Sum: "+(a[i]+k1Sum)+"  isPossible: "+isPossible);
//                    Arrays.stream(visited).forEach(e->System.out.print(e+" "));
//                    System.out.println();
                	if(dp[visited] == 0) {
                		isPossible = isGivenSumPossible(i+1,a,k1,k,a[i]+k1Sum, kSum, visited);
                		dp[visited] = isPossible?1:-1;
                	}
                	isPossible = dp[visited]==1?true:false;
//                    System.out.print("i:"+i+" after first k1Sum: "+(a[i]+k1Sum)+"  isPossible: "+isPossible);
                    if(!isPossible){
                    	visited = visited & ~(1<<i);
                    }
//                    Arrays.stream(visited).forEach(e->System.out.print(e+" "));
//                    System.out.println();
                    if(isPossible)
                        return isPossible;
                }
                else if((a[i]+k1Sum)==kSum){
                    k1++;
                    
//                    System.out.print("i:"+i+" before second k1Sum: "+(a[i]+k1Sum)+"  isPossible: "+isPossible);

//                    Arrays.stream(visited).forEach(e->System.out.print(e+" "));
//                    System.out.println();
                    if(dp[visited] == 0) {
                    	isPossible = isGivenSumPossible(i+1,a,k1,k,0, kSum, visited);
                    	dp[visited] = isPossible?1:-1;
                	}
                	isPossible = dp[visited]==1?true:false;
//                    System.out.println("i:"+i+" after second k1Sum: "+(a[i]+k1Sum)+"  isPossible: "+isPossible);

//                    System.out.println();
                    if(!isPossible){
                    	visited = visited & ~(1<<i);
                        k1--;
                    }
//                    Arrays.stream(visited).forEach(e->System.out.print(e+" "));
                    if(isPossible)
                        return isPossible;
                }
                else{
//                    System.out.println("i:"+i+" before second k1Sum: "+(a[i]+k1Sum)+"  simply return : ");
                	visited = visited & ~(1<<i);
                    return false;
                }
            }
        }
        return isPossible;
    }
}