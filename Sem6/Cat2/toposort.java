import java.util.*;

public class toposort {

    public static List<Integer> topologicalSort(List<List<Integer>> graph) {
        int V = graph.size();
        int[] degree = new int[V];

        for (int u = 0; u < V; u++) {
            for (int v : graph.get(u)) {
                degree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int u = 0; u < V; u++) {
            if (degree[u] == 0) {
                queue.add(u);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topoOrder.add(u);

            for (int v : graph.get(u)) {
                degree[v]--;
                if (degree[v] == 0) {
                    queue.add(v);
                }
            }
        }
        if (topoOrder.size() != V) {
            return new ArrayList<>();
        }
        return topoOrder;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
        }
        sc.close();
        List<Integer> topoOrder = topologicalSort(graph);
        System.out.println("Topological Order: " + topoOrder);
    }
}