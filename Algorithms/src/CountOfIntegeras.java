package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountOfIntegeras {

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < MAX_SIZE; i++){ 
            prime[i] = i; 
            // SPF.add(2); 
        }
        // for(int i=0;i<50;i++){
        //     System.out.print(prime[i]+ "  ");
        // }
        System.out.println();
        manipulated_seive(MAX_SIZE); 
//        for(int i=0;i<50;i++){
////            System.out.print(prime[i]+ "  ");
//        }
        System.out.println(primes.size());
        int t= sc.nextInt();
        while(t-- >0){
            int n=sc.nextInt();
            int count=0;
            for(int i=0;i<n;i++){
                int k = sc.nextInt();
                if(prime[k]==k){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    
    static final int MAX_SIZE = 100000000;
    // static boolean[]isprime = new boolean[MAX_SIZE]; 
    static int []prime = new int[MAX_SIZE]; 
     static List<Integer> primes = new ArrayList<>(10000001);
    static void manipulated_seive(int N) 
    { 
        // 0 and 1 are not prime 
        // isprime[0]= false; 
        // isprime[1] =false; 
        int k=0;prime[0] = 0;
        prime[1] = 0;
          
        // Fill rest of the entries 
        for (int i=2; i<N ; i++) 
        { 
            // If isPrime[i] == True then i is 
            // prime number 
            if (prime[i]==i) 
            { 
                // put i into prime[] vector 
                prime[i] = i; 
                primes.add(i);
       
                // A prime number is its own smallest 
                // prime factor 
                // SPF.set(i,i); 
            }
//                prime[]
            // Remove all multiples of  i*prime[j] which are 
            // not prime by making isPrime[i*prime[j]] = false 
            // and put smallest prime factor of i*Prime[j] as prime[j] 
            // [for exp :let  i = 5, j = 0, prime[j] = 2 [ i*prime[j] = 10] 
            // so smallest prime factor of '10' is '2' that is prime[j] ] 
            // this loop run only one time for number which are not prime 
            for (int j=0; 
				j < primes.size() && 
				i*primes.get(j) < N && primes.get(j) <= (prime[i]); 
				j++)
            { 
                prime[i*primes.get(j)] = primes.get(j);
                // isprime.set(i*prime.get(j),false); 
       
                // put smallest prime factor of i*prime[j] 
                // SPF.set(i*prime.get(j),prime.get(j)) ; 
            }
            
        } 
    }
}
