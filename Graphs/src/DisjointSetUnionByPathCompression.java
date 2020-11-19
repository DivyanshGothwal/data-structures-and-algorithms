package src;

public class DisjointSetUnionByPathCompression {

	public static void main(String[] ar) {
		int m = 10;
		DisjointSet a[] = new DisjointSet[m];
		for (int i = 0; i < m; i++) {
			a[i] = new DisjointSet(i, null, 1);
		}
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
		if (set.parent == null) {
			return set;
		}
		DisjointSet parent = find(set.parent);
		set.parent = parent;
		return parent;
	}

	public static void union(DisjointSet set1, DisjointSet set2) {
		if (set1.nodes > set2.nodes) {
			set2.parent = set1;
			set1.nodes += 1;
		} else {
			set1.parent = set2;
			set2.nodes += 1;
		}
	}
}
