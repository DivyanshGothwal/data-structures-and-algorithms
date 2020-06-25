package src;


public class RotateWords {
	public static void main(String []ar) {
		String s[] = new String[2];
		s[0]="a";
		s[1]="aabb";
//		s[2]="3232";
//		"12","212","1323");
		System.out.println(findwords(s, 8));
	}

	private static int findwords(String[] s, int k) {
		int count=0;
		for(int i=0;i<s.length;i++) {
			StringBuilder s1 = new StringBuilder(s[i]);
			StringBuilder s2 = new StringBuilder(s[i]);
			int l=0;
			while(l<k && s1.length()>1) {
				char c = s1.charAt(s1.length()-1);
				s1.delete(s1.length()-1, s1.length());
				s1.insert(0,c);
				l++;
			}
			if(s1.toString().equals(s2.toString())) {
				count++;
			}
		}
		return count;
	}
}
