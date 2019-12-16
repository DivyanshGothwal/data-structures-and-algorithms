package src;

import java.util.Stack;
public class DeleteSmallerELements {

	public static void main(String ar[]) {
		int k = 3; 
        int arr[] = { 23, 45, 11,6, 77, 18};
        deleteElements(arr, k); 
	}
	
	public static void deleteElements(int [] a, int k){
		Stack<Integer> s  = new Stack<>();
		s.push(a[0]);
		int count =0;
		for(int i=1;i<a.length;i++) {
			while(!s.isEmpty() && a[i] > s.peek() &&  count<k) {
				s.pop();
				count++;
			}
			s.push(a[i]);
		}
		while(!s.isEmpty()) {
			System.out.print(s.peek()+" ");
			s.pop();
		}
	}
}
