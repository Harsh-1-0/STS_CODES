import java.util.*;

public class BellmanFord {
    public static int[] bellmanFord(List<int[]> edges, int V, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        // Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Check for negative weight cycle
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                return new int[] { -1 }; // Negative cycle detected
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new int[] { u, v, w });
        }

        int src = 0; // Assuming source is 0
        int[] dist = bellmanFord(edges, V, src);

        if (dist.length == 1 && dist[0] == -1) {
            System.out.println("Negative cycle detected");
        } else {
            for (int i = 0; i < V; i++) {
                System.out.println("Distance of vertex " + i + " from source is "
                        + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
            }
        }

        sc.close();
    }
}
