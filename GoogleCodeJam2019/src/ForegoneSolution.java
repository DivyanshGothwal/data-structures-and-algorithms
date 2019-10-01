package src;

import java.util.*;

public class ForegoneSolution {
	public static void main(String ar[]) {
		Scanner sc = new Scanner(System.in);
		long t = sc.nextLong();
		int i=1;
		while (i<=t) {
			if(i==1) {
				String n1 = sc.nextLine();
			}
			String n = sc.nextLine();
			StringBuffer[] ar1 = findNumbers(n);
			System.out.println("Case #" + i + ": " + ar1[0].toString() + " " + ar1[1].toString());
			i++;
		}
	}

	private static StringBuffer[] findNumbers(String n) {
		StringBuffer[] a = new StringBuffer[2];
		StringBuffer s1 = new StringBuffer();
		StringBuffer newS = new StringBuffer();
		for(int i=0;i<n.length();i++) {
			if(n.charAt(i) == '4') {
				s1.append("3");
				newS.append("1");
			}
			else {
				s1.append(Character.toString(n.charAt(i)));
				if(newS.length()!=0) {
					newS.append("0");
				}
			}
		}
		a[0] = s1;
		a[1] = newS;
		return a;
	}

	private static boolean is4Present(long n) {
		while (n != 0) {
			long modulo = n % 10;
			if (modulo == 4) {
				return true;
			}
			n = n / 10;
		}
		return false;
	}
}




