package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class LC133_CloneGraph {

    // V -> Vertices; E -> Edges
    // Time -> O( V + E )
    // Space -> O(V)
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node, Node> visited = new HashMap<>();

        Node firstNode = new Node(node.val);
        visited.put(node, firstNode);

        Deque<Node> q = new ArrayDeque<>();
        q.offer(node);
        while (!q.isEmpty()) {
            Node poll = q.poll();
            for (var n : poll.neighbors) {
                if (!visited.containsKey(n)) {
                    Node newNode = new Node(n.val);
                    visited.put(n, newNode);
                    q.offer(n);
                }
                visited.get(poll).neighbors.add(visited.get(n));

            }
        }
        return firstNode;
    }
}
