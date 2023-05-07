package graphs.realizations;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

@Getter
public class HamiltonCycle<T> {

    private final Stack<Vertex<T>> toVisit = new Stack<>();
    private final Set<Vertex<T>> visited = new HashSet<>();

    public String walkTrough(Vertex<T> startVertex, String path) {
        if (visited.contains(startVertex)) {
            return path;
        }
        visited.add(startVertex);
        System.out.println(startVertex.getLabel());

        for (Vertex<T> relatedVertex : startVertex.getRelatedVertexes()) {
            if (startVertex.getRelatedVertexes().size() == relatedVertex.getRelatedVertexes().size()) {
                if (!visited.contains(relatedVertex)) {
                    toVisit.add(relatedVertex);
                }
            } else {
                throw new RuntimeException("It isn't a Hamilton cycle!");
            }
        }

        walkTrough(toVisit.pop(), path + ", " + startVertex.getLabel());

        return path;
    }
}
