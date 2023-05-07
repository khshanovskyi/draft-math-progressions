package graphs.realizations;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "label")
public class Vertex<T> {
    private String label;
    private List<Vertex<T>> relatedVertexes;

    public void addRelated(Vertex<T> vertex) {
        relatedVertexes.add(vertex);
    }

    public void addRelated(List<Vertex<T>> vertexes) {
        relatedVertexes.addAll(vertexes);
    }
}