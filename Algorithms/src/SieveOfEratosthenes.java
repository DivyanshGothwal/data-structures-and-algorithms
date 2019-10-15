package src;

import java.util.Arrays;

public class SieveOfEratosthenes {
	public static void main(String []arg) {
		int n =100;
		findPrimes(n);
	}
	private static void findPrimes(int n) {
		int [] a = new int[n+1];
		Arrays.fill(a, 1);
		a[1]=0;
		for(int i=2;i<=n;i++) {
			if(a[i]==1) {
				for(int j=i+i;j<=n;j=j+i) {
					a[j]=0;
				}
			}
		}
		int count = 0;
		for(int i=1;i<=n;i++) {
			System.out.println(i+" : "+a[i]);
			if(a[i]==1) {
				count++;
			}
		}
		System.out.println(count);
	}
}
