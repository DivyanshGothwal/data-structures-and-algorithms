package src;

import java.util.Stack;

public class PrefixToPostfix {
	public static void main(String[] ar) {
		String s = "*-A/BC-/AKL";
		System.out.println(preToPost(s));
	}

	static String preToPost(String pre) {
		Stack<String> s = new Stack<String>();
		for (int i = pre.length() - 1; i >= 0; i--) {
			if (isCharacter(pre.charAt(i))) {
				s.push(pre.charAt(i) + "");
			} else {
				String a = s.peek();
				s.pop();
				String b = s.peek();
				s.pop();
				s.push(a + b + pre.charAt(i));
			}
		}
		return s.peek();
	}

	static boolean isCharacter(Character c) {
		int a = (int) (c);
		if ((a >= 65 && a <= 90) || (a >= 97 && a <= 122)) {
			return true;
		}
		return false;
	}
}
