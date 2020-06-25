package src;
import java.util.*;
public class StackWithMinEleWithConstantStack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q= sc.nextInt();
		int j=0;
	    while(j<q){
	    	if(j==0) {
	        String s4 = sc.nextLine();
	    	}
	        String s1 = sc.nextLine();
//	        System.out.println(s1);	     
	        
//			int q1= sc.nextInt();  
	        String s2 = sc.nextLine();
	        int isNo = 0;
//	        System.out.println(s2);
	        for(int i=0;i<s1.length();i++){
	            char c1 = s1.charAt(i);
	            char c2 = s2.charAt(i);
	            if(c1!=c2){
	                if(i-1>=0 && (s1.charAt(i-1)==c2 || c1 == s2.charAt(i-1))){
	                    continue;
	                }
	                if(i+1<s1.length() && (s1.charAt(i+1)==c2 || c1 == s1.charAt(i+1))  ){
	                    continue;
	                }
	                isNo = 1;
	                
	            }
	        }
	        if(isNo==1) {
	        	System.out.println("No");
	        }
	        else {
		        System.out.println("Yes");
	        }
	        j++;
	    }
//		CustomMinStack s = new CustomMinStack();
//		s.push(10);
//		s.push(20);
//		s.push(5);
//		s.push(6);
//		s.push(12);
//		s.push(7);
//		s.push(4);
//		s.push(20);
//		s.push(2);
//		System.out.println("Min "+s.getMin());
//		System.out.println(s.pop());
//		System.out.println("Min "+s.getMin());
//		System.out.println(s.pop());
//		System.out.println("Min "+s.getMin());
	}
}

class CustomMinStack {
	private Stack<Integer> s;
	private int min = Integer.MAX_VALUE;

	CustomMinStack() {
		s = new Stack<>();
	}

	public Integer push(Integer data) {
		s.push(2 * data - min);
		if (data < min) {
			min = data;
		}
		return data;
	}

	public Integer pop() {
		int top = s.getTop();
		s.pop();
		if (top < min) {
			int newMin = min;
			min = 2 * min - top;
			return newMin;
		} else {
			return (top + min) / 2;
		}
	}

	public Integer getMin() {
		return this.min;
	}
}
