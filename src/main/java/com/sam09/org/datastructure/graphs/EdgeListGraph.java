package com.sam09.org.datastructure.graphs;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class EdgeListGraph {

    private static void printVertices(Graph graph) {
        System.out.println("\n::Vertices Start::");
        graph.getVertices()
                .forEach(vertex -> System.out.print(vertex.getData() + "\t"));
        System.out.println("\n::Vertices End::");
    }

    private static void printSpecificVertex(Vertex v) {
        System.out.println("Vertex data: " + v.getData() + " pos: " + v.getPosition());
    }

    private static void printEdges(Graph graph) {
        System.out.println("\n::Edges Start::");
        graph.getEdges()
                .forEach(edge -> System.out.print(edge.getData() + "\t"));
        System.out.println("\n::Edges End::");
    }

    private static void printSpecificEdge(Edge e) {
        System.out.println("Edge data: " + e.getData() + " pos: " + e.getPosition() + " vertex1: " + e.getVertex1() + " vertex2: " + e.getVertex2());
    }

    private static void printIncidentEdges(List<Edge> incidentEdges) {
        System.out.println("\n::Incident Edges Start::");
        incidentEdges.forEach(edge -> System.out.print(edge.getData() + "\t"));
        System.out.println("\n::Incident Edges End::");
    }

    void main() {
        var W = new Vertex(23);
        var X = new Vertex(24);
        var Y = new Vertex(25);
        var Z = new Vertex(26);

        var vertices = new ArrayList<Vertex>();
        vertices.add(W);
        vertices.add(X);
        vertices.add(Y);
        vertices.add(Z);

        var a = new Edge(1, X, W);
        var b = new Edge(2, W, Y);
        var c = new Edge(3, Y, Z);

        var edges = new ArrayList<Edge>();
        edges.add(a);
        edges.add(b);
        edges.add(c);

        var graph = new Graph(vertices, edges);
        EdgeListGraph.printVertices(graph);

        var vertex = graph.insertVertex(22);
        EdgeListGraph.printSpecificVertex(vertex);

        EdgeListGraph.printVertices(graph);
        EdgeListGraph.printEdges(graph);

        var edge = graph.insertEdge(4, X, Z);
        EdgeListGraph.printSpecificEdge(edge);
        EdgeListGraph.printEdges(graph);

        var deletedVertex = graph.removeVertex(W);
        System.out.println("Deleted Vertex: " + deletedVertex);
        EdgeListGraph.printVertices(graph);

        var deletedEdge = graph.removeEdge(b);
        System.out.println("Deleted Edge: " + deletedEdge);
        EdgeListGraph.printEdges(graph);

        EdgeListGraph.printIncidentEdges(graph.incidentEdges(Z));

        System.out.println("Opposite of vertex W along edge a: " + graph.opposite(a, W).getData());
        System.out.println("Opposite of vertex Z along edge c: " + graph.opposite(c, Z).getData());

        System.out.println("\nW and Y vertex is adjacent: " + graph.isAdjacentVertex(W, Y));
        System.out.println("\nX and Z vertex is adjacent: " + graph.isAdjacentVertex(X, Z));

        System.out.println("Replace Vertex X: " + graph.replace(X, 32));
        System.out.println("Replace Edge a: " + graph.replace(a, 10));
    }
}
