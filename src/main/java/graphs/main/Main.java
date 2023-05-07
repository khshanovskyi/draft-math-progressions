package graphs.main;

import graphs.realizations.HamiltonCycle;
import graphs.realizations.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Vertex<Object> a = new Vertex<>("A", new ArrayList<>());
        Vertex<Object> b = new Vertex<>("B", new ArrayList<>());
        Vertex<Object> c = new Vertex<>("C", new ArrayList<>());
        Vertex<Object> d = new Vertex<>("D", new ArrayList<>());

        a.addRelated(List.of(b, c, d));
        b.addRelated(List.of(a, c, d));
        c.addRelated(List.of(a, b, d));
        d.addRelated(List.of(a, b, c));

//        a.addRelated(List.of(b));
//        b.addRelated(List.of(a, c));
//        c.addRelated(List.of(b, d));
//        d.addRelated(List.of(c));


        HamiltonCycle<Object> cycle = new HamiltonCycle<>();

        System.out.println(cycle.walkTrough(b, ""));
    }
}
