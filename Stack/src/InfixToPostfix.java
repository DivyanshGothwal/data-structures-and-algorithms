package src;

import java.util.Stack;
import java.util.HashMap;

public class InfixToPostfix {

	public static void main(String ar[]) {
		String infix = "((a+b*c^d-e^f+g*h-i))";
		precedenceValue.put((int) '*', 2);
		precedenceValue.put((int) '/', 2);
		precedenceValue.put((int) '-', 3);
		precedenceValue.put((int) '+', 3);
		precedenceValue.put((int) '^', 1);
		precedenceValue.put((int) '(', 4);
		precedenceValue.put((int) ')', 4);
		System.out.println(convertInfixToPostfix(infix));
	}

	static StringBuffer convertInfixToPostfix(String infix) {
		StringBuffer postfix = new StringBuffer("");
		Stack<Character> s = new Stack<Character>();
		for (int i = 0; i < infix.length(); i++) {
			if (!isChar(infix.charAt(i))) {
				if (s.isEmpty() || infix.charAt(i) == '(' || comparePrecedense(s.peek(), infix.charAt(i))) {
					s.push(infix.charAt(i));
				}
				else if(infix.charAt(i) == ')') {
					while(!s.isEmpty() && s.peek() != '(') {
						postfix.append(s.peek());
						s.pop();
					}
					s.pop();
				}
				else if (s.peek() != '(' && !comparePrecedense(s.peek(), infix.charAt(i))) {
					while(!s.isEmpty() && !comparePrecedense(s.peek(), infix.charAt(i)) ) {
						postfix.append(s.peek());
						s.pop();
					}
					s.push(infix.charAt(i));
				}
			} else {
				postfix.append(infix.charAt(i));
			}
		}
		while(!s.isEmpty()) {
			postfix.append(s.peek());
			s.pop();
		}
		return postfix;
	}

	static HashMap<Integer, Integer> precedenceValue = new HashMap<Integer, Integer>();

	static boolean comparePrecedense(Character a, Character b) {
		int asciiValueA = (int) a;
		int asciiValueB = (int) b;
		int a1 = precedenceValue.get(asciiValueA);
		int a2 = precedenceValue.get(asciiValueB);
		if (a1 > a2) {
			return true;
		}
		return false;
	}

	static boolean isChar(Character c) {
		int asciiValue = (int) c;
		if ((asciiValue >= 65 && asciiValue <= 90) || (asciiValue >= 97 && asciiValue <= 122)) {
			return true;
		}
		return false;
	}

}
