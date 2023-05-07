package graphs;

import graphs.realizations.Vertex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Graph<T> {

    private List<Vertex<T>> vertexes;

}
