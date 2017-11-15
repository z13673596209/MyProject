package MapMST;
/*
* 代表加权无向图中的边
* */
public class Edge implements Comparable<Edge> {
    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return this.w;
    }

    public int other(int vertex) {
        if (vertex == v) {
            return w;
        } else if (vertex == w) {
            return v;
        } else throw new RuntimeException("Inconsistent edge");

    }

    public double weight() {
        return weight;
    }

    public int compareTo(Edge e) {
        if (e.weight() < this.weight) {
            return 1;
        } else if (e.weight > this.weight) {
            return -1;
        } else {
            return 0;
        }
    }
}
