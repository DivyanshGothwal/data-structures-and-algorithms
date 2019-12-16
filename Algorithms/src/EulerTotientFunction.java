package src;

import java.util.*;

public class EulerTotientFunction {
	public static void main(String a[]) {
		int n = 24;
		
		findRelativelyPrime(n);
	}

	static int[] findPrimes(int n) {
		int a[] = new int[n + 1];
		Arrays.fill(a, 1);
		a[1] = 0;
		for (int i = 2; i <= n; i++) {
			if (a[i] == 1) {
				for (int j = i + i; j <= n; j = j + i) {
					a[i] = 0;
				}
			}
		}
		return a;
	}
	static List<Integer> findPrimeFactors(int n) {
		int a[] = new int [n+1];
		for(int i=1;i<=n;i++) {
			a[i]=i;
		}
		for(int i=2;i<=n;i++) {
			if(a[i]==i) {
				for(int j=i+i;j<=n;j=j+i) {
					a[j]=i;
				}
			}
		}
		List<Integer> a1 = new ArrayList<Integer>();
		while(n>1) {
			a1.add(a[n]);
			n=n/a[n];
		}
		System.out.println();
		for(int i=0;i<a1.size();i++) {
			System.out.println(a1.get(i));//=i;
		}
		return a1;
	}
	public static int findRelativelyPrime(int n, List<Integer> a) {
		int result = n;
		for(int i=0;i<a.size();i++) {
//			System.out.println(a.get(i));
			result *= ((a.get(i)-1)/(float)a.get(i));
		}
		return result;
	}
	static void findRelativelyPrime(int n) {
		int a[] = findPrimes(n);
		List<Integer> primeFactors = findPrimeFactors(n);
		System.out.println(findRelativelyPrime(n, primeFactors));
	}
}
