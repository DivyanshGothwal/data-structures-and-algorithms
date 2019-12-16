package src;

import java.util.Stack;
import java.util.*;

public class MaxFrequencyElement {

	public static void main(String[] args) {
		MaxFreqStack mfs = new MaxFreqStack();
		mfs.push(10);
		mfs.push(1);
		mfs.push(1);
		mfs.push(5);
		mfs.push(8);
		mfs.push(5);
		mfs.push(8);
		mfs.push(2);
		mfs.push(2);
		mfs.push(2);
		mfs.push(8);
		System.out.println(mfs.pop());
		System.out.println(mfs.pop()); 
		System.out.println(mfs.pop());
		System.out.println(mfs.pop());
		System.out.println(mfs.pop());
	}

}

class MaxFreqStack{
	Stack<Integer> s = new Stack<>();
	Stack<Integer> maxFrequencyStack = new Stack<>();
	Map<Integer, Integer> map = new HashMap<>();
	int maxFrequency;
	void push(int data) {
		if(s.isEmpty()) {
			s.push(data);
			maxFrequencyStack.push(data);
			map.put(data,1);
			maxFrequency = 1;
		}
		else {
			s.push(data);
			int currEleFreq = map.get(data) == null ?1:map.get(data)+1;
			if(currEleFreq == maxFrequency) {
				maxFrequencyStack.push(data);
				map.put(data, currEleFreq);
				if(currEleFreq == maxFrequency) {
					maxFrequency = currEleFreq;
				}
			}
			else if(currEleFreq < maxFrequency) {
				maxFrequencyStack.push(maxFrequencyStack.peek());
				map.put(data, currEleFreq);
			}
			else if(currEleFreq > maxFrequency) {
				maxFrequencyStack.push(data);
				map.put(data, currEleFreq);
				maxFrequency = currEleFreq;
			}
		}
	}
	int pop() {
		s.pop();
		int maxFreqEle =  maxFrequencyStack.pop();
		maxFrequency = map.get(maxFreqEle);
		return maxFreqEle;
	}
}
