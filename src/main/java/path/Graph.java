package path;

public class Graph {

    public void shortestPath(Vertex start, Vertex finish) {
        start.setWeight(0);
    }

    public void initializeVertices(Vertex start) {

    }

    public void createGraph() {
        Edge ab = new Edge(4);
        Edge ac = new Edge(2);
        Edge bc = new Edge(1);
        Edge bd = new Edge(5);
        Edge cd = new Edge(8);
        Edge ce = new Edge(10);
        Edge de = new Edge(2);
        Edge dz = new Edge(6);
        Edge ez = new Edge(3);

        Vertex a = new Vertex();
        Vertex b = new Vertex();
        Vertex c = new Vertex();
        Vertex d = new Vertex();
        Vertex e = new Vertex();
        Vertex z = new Vertex();

        a.addNeighbour(b, ab);
        a.addNeighbour(c, ac);

        b.addNeighbour(a, ab);
        b.addNeighbour(c, bc);
        b.addNeighbour(d, bd);

        c.addNeighbour(a, ac);
        c.addNeighbour(b, bc);
        c.addNeighbour(d, cd);
        c.addNeighbour(e, ce);

        d.addNeighbour(b, bd);
        d.addNeighbour(c, cd);
        d.addNeighbour(e, de);
        d.addNeighbour(z, dz);

        e.addNeighbour(c, ce);
        e.addNeighbour(d, de);
        e.addNeighbour(z, ez);

        z.addNeighbour(d, dz);
        z.addNeighbour(e, ez);
    }
}
