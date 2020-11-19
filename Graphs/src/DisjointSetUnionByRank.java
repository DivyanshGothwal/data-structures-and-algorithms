package src;

public class DisjointSetUnionByRank {

	public static void main(String ar[]) {
		int m = 10;
		DisjointSet[] a = new DisjointSet[m];
		for (int i = 0; i < m; i++) {
			a[i] = new DisjointSet(i, null, 1);
		}
		DisjointSet set1 = find(a[1]);
		DisjointSet set2 = find(a[2]);

		union(find(a[0]), find(a[1]));
		union(find(a[1]), find(a[3]));
		union(find(a[2]), find(a[5]));
		union(find(a[2]), find(a[8]));
		union(find(a[9]), find(a[4]));
		union(find(a[6]), find(a[9]));
		
		System.out.println(find(a[0]).ele);
		System.out.println(find(a[1]).ele);
		System.out.println(find(a[3]).ele);

		System.out.println(find(a[2]).ele);
		System.out.println(find(a[5]).ele);
		System.out.println(find(a[8]).ele);

		System.out.println(find(a[4]).ele);
		System.out.println(find(a[6]).ele);
		System.out.println(find(a[9]).ele);
		

		System.out.println(find(a[7]).ele);

	}

	public static DisjointSet find(DisjointSet set) {
		while (set.parent != null) {
			set = set.parent;
		}
		return set;
	}

	public static void union(DisjointSet set1, DisjointSet set2) {
		if (set1.nodes > set2.nodes) {
			set2.parent = set1;
			set1.nodes++;
		} else {
			set1.parent = set2;
			set2.nodes++;
		}
	}
}

class DisjointSet {
	Integer ele;
	DisjointSet parent;
	Integer nodes;

	DisjointSet(Integer ele, DisjointSet parent, Integer nodes) {
		this.ele = ele;
		this.parent = parent;
		this.nodes = nodes;
	}
}
