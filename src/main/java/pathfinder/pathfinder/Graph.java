package pathfinder.pathfinder;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Graph<T extends GraphNode> {
  private Set<T> nodes;
  private Map<String, Set<String>> connections;

  public T getNode(String id) {
    return nodes.stream().filter(n -> n.getId().equals(id)).findFirst().orElseThrow(() -> new IllegalArgumentException("no such node found"));
  }

  public Set<T> getConnections(T node) {
    return connections.get(node.getId()).stream().map(this::getNode).collect(Collectors.toSet());
  }
}
