package path;

import java.util.HashMap;
import java.util.Map;

public class Vertex {

    private double weight;
    private boolean visited = false;
    private Map<Vertex, Edge> neighbours = new HashMap<>();

    public Vertex(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Map<Vertex, Edge> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(Map<Vertex, Edge> neighbours) {
        this.neighbours = neighbours;
    }

    public Map<Vertex, Edge> addNeighbour(Vertex neighbour, Edge weight) {
        neighbours.put(neighbour, weight);
        return neighbours;
    }
}
