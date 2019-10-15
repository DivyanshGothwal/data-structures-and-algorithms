package src;
import java.util.Stack;

public class EvaluatePostfixExpression {
	public static void main(String a[]) {
		String s = "231*+9*";
	    System.out.println(calulateExpression(s));
	}
	public static int calulateExpression(String s){
	    Stack<Integer> st = new Stack<Integer>();
	    for(int i=0;i<s.length();i++){
	        if(!isOperator(s.charAt(i))){
	            st.push(Character.getNumericValue(s.charAt(i)));
	        }
	        else{
	            int a = st.peek();
	            st.pop();
	            int b = st.peek();
	            st.pop();
	            st.push(caluclateWithOperator(s.charAt(i),b,a));
	        }
	    }
	    return st.peek();
	}
	public static boolean isOperator(char character){
	    if(character == '*' || character == '+' || character == '-' || character == '/'  ){
	        return true;
	    }
	    return false;
	}
	public static int caluclateWithOperator(char operator, int a,int b){
	    if(operator=='*'){
	        return a*b;
	    }
	    if(operator=='/'){
	        return a/b;
	    }
	    if(operator=='-'){
	        return a-b;
	    }
	    if(operator=='+'){
	        return a+b;
	    }
	    return 0;
	}
}
