package src;
import java.io.*;
public class XorWithGivenSum {
    static long num=1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            long K = Long.parseLong(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            long[] A = new long[N];
            for(int i_A=0; i_A<arr_A.length; i_A++){
            	A[i_A] = Long.parseLong(arr_A[i_A]);
            }
            long out_ = fun(A, K);
            System.out.println(out_);
         }
         wr.close();
         br.close();
    }
    static long fun(long[] a, long k){
        long maxEle = -100;
        for(int i=0;i<a.length;i++){
            if(maxEle<a[i]){
                maxEle = a[i];
            }
        }
        int m = (1<<((int)log2(maxEle)+1))-1;
        long [][]sol = new long[a.length+1][m+1];
        sol[0][0]=1;
        for(int i=0;i<=a.length;i++){
            sol[i][0]=1;
        }
        for(int i=1;i<=a.length;i++){
            for(int j=0;j<=m;j++){
            	sol[i][j] = ((sol[i-1][j]%num)+((((j^(int)a[i-1])>m || (j^(int)a[i-1])<0))?0:(sol[i-1][j^(int)a[i-1]])%num))%num;
            }
        }
        long count3 = 0l;
        long count1 = 0l;
        
        long count2 = 0l;
        try{
        if(k<=m){
            count3 = sol[a.length][(int)k];
        }
        for(int i=0;i<=Math.min(k,m);i++){
            count1+=sol[a.length][i];
        }
            for(int i=(int)k+1;i<=m;i++){
                count2+=sol[a.length][i];
            }
        }
            catch(Exception e){
                
            }
        long finalCount = 2*(((count1*count2)%num) + ((count1*count3)%num) + ((count3*count2)%num)) +((count1*count1)%num)+((count2*count2)%num)+ ((count3*count3)%num);
        return finalCount;
    }
    public static double log2(long n){
        return (Math.log10(n) / Math.log10(2));
    }
}