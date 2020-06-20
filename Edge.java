class Edge {
    int from, to, cost;

    Edge(int from, int to) {
        this.from = from;
        this.to = to;
        cost = Math.abs(to - from);
    }
}