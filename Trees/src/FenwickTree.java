package src;

import java.util.*;
//Also Known as Binary Indexed Tree
public class FenwickTree {

	public static void main(String ar[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []a = new int [n+1];
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
		}
		int q = sc.nextInt();
		int [] bit = constructFenwickTree(a,a.length);
		for(int i=0;i<q;i++) {
			query(sc.nextInt(), bit);
		}
		updateBit(a, bit,9,5);
		sc.close();
	}
	public static void query(int end, int []bit) {
		String s ="";
		int l = end;
		while(l>0) {
			int p = l%2;
			l=l/2;
			s=p+s;
		}
		int count=0, ans=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='0') {
				continue;
			}
			int pow = 1<<(s.length()-1-i);
			count+=pow;
			ans+=bit[count];
		}
		System.out.println(ans);
	}
	public static int[] constructFenwickTree(int []a,int n) {
		int Bit[] = new int[n];
		
		for(int i=1;i<n;i++) {
			updateBit(a, Bit,i,a[i]);
		}
		return Bit;
	}
	
	public static void updateBit(int[]a, int [] Bit, int i, int ele) {
		a[i]=ele;
		int nextEle = i;
		while(nextEle<Bit.length) {
			Bit[nextEle]+=ele;
			nextEle += nextEle & ((~nextEle)+1);
		}
		
	}
}
/**
 * 10
6 4 7 9 4 6 3 8 5 0
 * */