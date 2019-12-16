package src;
import java.util.*;
public class LCAUsingNarrayTreeSquareRootDecomposition {
	public static int height=0;
	public static int maxHeight;
	public static void main(String ar[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<List<tuple>> graph = new ArrayList<>();
		for(int i=0;i<n;i++) {
			graph.add(new ArrayList<tuple>());
		}
		int m = sc.nextInt();
		for(int i=0;i<m;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
//			int dist = sc.nextInt();
			graph.get(u).add(new tuple(v, 0));
		}
		int levels[] = new int[n];
		int x = sc.nextInt();
		int y = sc.nextInt();
		int parent[] =new int[n];
		getHeight(0, graph, levels, parent);
		System.out.println(findLCA(x, y, graph, levels, parent));
		sc.close();
	}


	private static void getHeight(int start, List<List<tuple>> graph,int []levels, int parent[]) {
		List<tuple> childs = graph.get(start);
		height++;
		levels[start] = height;
		for(int i=0;i<childs.size();i++) {
			parent[childs.get(i).dest]  = start;
			getHeight(childs.get(i).dest, graph, levels, parent);
		}
		if(height > maxHeight) {
			maxHeight = height;
		}
		height--;
	}

	private static int findLCA(int x, int y, List<List<tuple>> graph, int []levels, int parent[]) {
		int p[] = new int[graph.size()];
		p[0]=1;
		findP(new tuple(0,0), graph, levels, p, parent);
		return findFinalLCA(x,y,p,graph,levels, parent);
	}


	private static int findFinalLCA(int x, int y, int[] p, List<List<tuple>> graph, int[] levels, int parent[]) {
		while(p[x]!=p[y]) {
			if(levels[x]>levels[y]) {
				x= p[x];
			}
			else{
				y=p[y];
			}
		}
		while(x!=y) {
			if(levels[x]>levels[y]) {
				x = parent[x];
			}
			else {
				y = parent[y];
			}
		}
		return x;
	}


	private static void findP(tuple start, List<List<tuple>> graph, int[] levels, int p[], int [] parent) {
		List<tuple> childs = graph.get(start.dest);
		if(levels[start.dest]%((int)Math.sqrt(maxHeight-1)) != 0) {
			p[start.dest] = parent[start.dest];
		}
		else {
			p[start.dest] = p[parent[start.dest]];
		}
		for(int i=0;i<childs.size();i++) {
			findP(childs.get(i), graph, levels, p, parent);
		}
		
		
	}
}
class tuple{
	int dest;
	int dist;
	tuple(int dest, int dist){
		this.dest = dest;
		this.dist = dist;
	}
}
