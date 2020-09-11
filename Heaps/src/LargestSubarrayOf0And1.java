/**
 * 
 */
package src;

import java.util.HashMap;
import java.util.Map;

/**
 * @author divyansh
 *
 */
public class LargestSubarrayOf0And1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = {0,0,0,0,1,1,1,0,0,1,0};
		LargestSubarrayOf0And1 l = new LargestSubarrayOf0And1();
		l.maxLen(a, a.length);
	}
	int maxLen(int[] a, int n){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(a[i]==0){
                a[i]=-1;
            }
        }
        int sum=0;
        int max = 0;
        map.put(0,0);
        for(int i=0;i<n;i++){
            sum+=a[i];
            Integer value = map.get(sum);
            if(value==null){
                map.put(sum, i);
                continue;
            }
            if(sum==0){
                max = Math.max(max, i+1);
                continue;
            }
            max = Math.max(max, i-value);
        }
        return max;
    }
}
