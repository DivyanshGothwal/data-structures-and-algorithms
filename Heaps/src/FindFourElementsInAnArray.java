package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindFourElementsInAnArray {

	public static void main(String ar[]) {
		FindFourElementsInAnArray l = new FindFourElementsInAnArray();
		List<Integer> ar1 = new ArrayList<>();
		l.findSum(ar1);
	}
	public Boolean findSum(List<Integer> ar){
	    int n=ar.size();
	    Map<Integer, Integer> map = new HashMap<>(2*n);
	    for(int i=0;i<n;i++){
	        for(int j=i+1;j<n;j++){
	            int sum =ar.get(i)+ar.get(j);
	            Integer l1 = map.getOrDefault(sum,0);
	            l1++;
	            if(l1>=2){
	                return true;
	            }
	            map.put(sum, l1);
	        }
	    }
	    return false;
	}
}
