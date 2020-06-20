import java.util.Scanner;

class MinSpanningTree {
    public static void quickSortDescByCost(Edge[] arr, int start, int end) {
        if (end <= start) return;
        int p = partition(arr, start, end);
        quickSortDescByCost(arr, start, p - 1);
        quickSortDescByCost(arr, p + 1, end);
    }

    private static int partition(Edge[] arr, int start, int end) {
        int c1 = start, c2 = end + 1;
        while (true) {
            while (greater(arr[++c1].cost, arr[start].cost))
                if (c1 == end) break;
            while (greater(arr[start].cost, arr[--c2].cost))
                if (c2 == start) break;
            if (c1 >= c2) break;
            exchange(arr, c1, c2);
        }
        exchange(arr, start, c2);
        return c2;
    }

    private static boolean greater(int x, int y) {
        return x > y;
    }

    private static void exchange(Edge[] arr, int x, int y) {
        Edge temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static LinkedList<LinkedList<Integer>> initializeForest(int n) {
        LinkedList<LinkedList<Integer>> forest = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            forest.insertEnd(forest, new LinkedList<>());
            forest.getLastNode(forest).data.insertEnd(forest.getLastNode(forest).data, i + 1);
        }
        return forest;
    }

    public static Edge[] getEdges(int m, Scanner s) {
        Edge[] edges = new Edge[m];
        int from, to;
        for (int i = 0; i < m; i++) {
            String input = s.nextLine();
            from = Character.getNumericValue(input.charAt(0));
            to = Character.getNumericValue(input.charAt(2));
            edges[i] = new Edge(from , to);
        }
        return edges;
    }

    public static LinkedList<Edge> MST(LinkedList<LinkedList<Integer>> forest, Edge[] edges) {
        int k = 0;
        Edge edge;
        Node<LinkedList<Integer>> fromList, toList;
        LinkedList<Edge> safeEdges = new LinkedList<>();
        while (forest.head.next != null) {
            edge = edges[k++];
            fromList = forest.head;
            toList = forest.head;
            while (fromList.data.notContains(fromList.data, edge.from))
                fromList = fromList.next;
            while (toList.data.notContains(toList.data, edge.to))
                toList = toList.next;
            if (fromList != toList) {
                safeEdges.insertEnd(safeEdges, edge);
                fromList.data = fromList.data.mergeLists(fromList.data, toList.data);
                forest.delete(forest, toList.data);
            }
        }
        return safeEdges;
    }

    public static void printTotalMinCost(Edge[] edges, LinkedList<Edge> safeEdges) {
        int totalMinCost = 0;
        for (Edge edge : edges)
            if (safeEdges.notContains(safeEdges, edge))
                totalMinCost += edge.cost;
        System.out.println(totalMinCost);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int n = Character.getNumericValue(input.charAt(0));
        int m = Character.getNumericValue(input.charAt(2));
        LinkedList<LinkedList<Integer>> forest = initializeForest(n);
        Edge[] edges = getEdges(m, s);
        quickSortDescByCost(edges, 0, edges.length - 1);
        LinkedList<Edge> safeEdges = MST(forest, edges);
        printTotalMinCost(edges, safeEdges);
    }
}
