package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

// Eulerian path
public class LC332_Itinerary {


    HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> route = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String start = ticket.get(0);
            String end = ticket.get(1);
            graph.computeIfAbsent(start, k -> new PriorityQueue<>()).offer(end);
        }
        visit("JFK");
        return route;

    }

    private void visit(String airport) {
        PriorityQueue<String> targets = graph.get(airport);
        while (targets != null && targets.size() > 0) {
            visit(targets.poll());
        }
        route.add(0, airport);
    }
}
