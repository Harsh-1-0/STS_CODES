import java.util.*;

public class Bfs {

    public static void addEdge(List<List<Integer>> arr, int u, int v) {
        arr.get(u).add(v);
        arr.get(v).add(u);
        return;
    }

    public static void BFS(List<List<Integer>> arr, int s) {
        boolean[] visited = new boolean[arr.size()];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        while (q.size() != 0) {
            s = q.poll();
            System.out.print(s + " ");
            for (int i : arr.get(s)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>(V);
        int E = sc.nextInt();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge(adj, u, v);
        }

        int s = sc.nextInt();
        BFS(adj, s);
        sc.close();
    }
}
