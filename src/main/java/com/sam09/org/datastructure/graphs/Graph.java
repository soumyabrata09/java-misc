package com.sam09.org.datastructure.graphs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Graph {

    List<Vertex> vertices;
    List<Edge> edges;

    public Vertex insertVertex(int data) {
        var v = new Vertex(data);
        this.vertices.add(v);
        v.setPosition(this.vertices.indexOf(v));
        return v;
    }

    public Edge insertEdge(int data, Vertex v1, Vertex v2) {
        var e = new Edge(data, v1, v2);
        this.edges.add(e);
        e.setPosition(this.edges.indexOf(e));
        return e;
    }

    public int removeVertex(Vertex v) {
        if (this.vertices.contains(v)) {
            this.vertices.remove(v);
            return v.getData();
        }
        return 0;
    }

    public int removeEdge(Edge e) {
        if (this.edges.contains(e)) {
            this.edges.remove(e);
            return e.getData();
        }
        return 0;
    }

    public List<Vertex> vertices() {
        return this.vertices;
    }

    public List<Edge> edges() {
        return this.edges;
    }

    public List<Edge> incidentEdges(Vertex v) {
        return this.edges.stream()
                .filter(edge -> edge.getVertex1() == v || edge.getVertex2() == v)
                .toList();
    }

    public Vertex opposite(Edge e, Vertex v) {
        if (v == e.getVertex1()) {
            return e.getVertex2();
        }

        if (v == e.getVertex2()) {
            return e.getVertex1();
        }
        return null;
    }

    public boolean isAdjacentVertex(Vertex v1, Vertex v2) {
      return this.edges.stream()
              .anyMatch(edge -> (edge.getVertex1() == v1 || edge.getVertex2() == v1) && (edge.getVertex1() == v2 || edge.getVertex2() == v2));

    }

    public int replace(Vertex v, int data) {
        var tempVertex = vertices().get(this.vertices.indexOf(v));
        var oldVertexData = tempVertex.getData();
        tempVertex.setData(data);
        return oldVertexData;
    }

    public int replace(Edge e, int data) {
        var tempEdge = edges().get(this.edges.indexOf(e));
        var oldEdgeData = tempEdge.getData();
        tempEdge.setData(data);
        return oldEdgeData;
    }
}
