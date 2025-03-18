import java.util.*;

public class DialsAlgorithm {
    public static int[] dialsAlgorithm(List<int[]> edges, int V, int S, int maxWeight) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        List<Deque<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= maxWeight * V; i++) {
            buckets.add(new LinkedList<>());
        }

        buckets.get(0).add(S);
        int idx = 0;

        while (true) {
            while (idx < buckets.size() && buckets.get(idx).isEmpty()) {
                idx++;
            }
            if (idx >= buckets.size())
                break;

            int u = buckets.get(idx).poll();
            if (dist[u] < idx)
                continue;

            for (int[] edge : edges) {
                if (edge[0] == u) {
                    int v = edge[1], w = edge[2];
                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                        buckets.get(dist[v] % buckets.size()).add(v);
                    }
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int maxWeight = sc.nextInt();

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new int[] { u, v, w });
        }

        int src = 0; // Assuming source is 0
        int[] dist = dialsAlgorithm(edges, V, src, maxWeight);

        for (int i = 0; i < V; i++) {
            System.out.println("Distance of vertex " + i + " from source is " +
                    (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }

        sc.close();
    }
}
