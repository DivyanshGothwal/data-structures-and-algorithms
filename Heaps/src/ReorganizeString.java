/**
 * 
 */
package src;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author divyansh
 *
 */
public class ReorganizeString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String S = "aaab";
		reorganizeString(S);
	}

	public static String reorganizeString(String s) {
		Map<String, Integer> map = new HashMap<String, Integer>(1024, 0.5f);
		for (int i = 0; i < s.length(); i++) {
			map.put(String.valueOf(s.charAt(i)), map.getOrDefault(String.valueOf(s.charAt(i)), 0) + 1);
		}
		PriorityQueue<String> pq = new PriorityQueue<>((a1, a2) -> {
			return map.get(a2).compareTo(map.get(a1));
		});
		for (String a : map.keySet()) {
			pq.add(a);
		}
		StringBuilder sb = new StringBuilder("");
		while (!pq.isEmpty()) {
			String s1 = pq.poll();
			Integer s1Count = map.get(s1);
			if (!pq.isEmpty()) {
				String s2 = pq.poll();
				Integer s2Count = map.get(s2);
				if (s1Count - s2Count > 0) {
					for (int i = 0; i < s2Count; i++) {
						sb.append(s1 + s2);
					}
					map.put(s1, s1Count - s2Count);
					pq.add(s1);
				} else if (s1Count - s2Count < 0) {
					for (int i = 0; i < s1Count; i++) {
						sb.append(s1 + s2);
					}
					map.put(s2, s2Count - s1Count);
					pq.add(s2);
				} else {
					for (int i = 0; i < s1Count; i++) {
						sb.append(s1 + s2);
					}
				}
			} else {
				sb.append(s1);
				if (s1Count > 1) {
					return "";
				}
			}
		}
		while (!pq.isEmpty()) {
			String s1 = pq.poll();
			Integer s1Count = map.get(s1);
			if (s1Count > 1) {
				return "";
			}
		}
		return sb.toString();
	}
}
