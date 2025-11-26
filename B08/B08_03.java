import java.util.*;

public class B08_03 {
    private HashMap<Integer, Set<Integer>> g = new HashMap<>();

    public void addVertex(int v) {
        g.putIfAbsent(v, new HashSet<>());
    }

    public void removeVertex(int v) {
        if (!g.containsKey(v)) return;
        for (int u : g.get(v)) g.get(u).remove(v);
        g.remove(v);
    }

    public void addEdge(int a, int b) {
        addVertex(a);
        addVertex(b);
        g.get(a).add(b);
        g.get(b).add(a);
    }

    public void removeEdge(int a, int b) {
        if (g.containsKey(a)) g.get(a).remove(b);
        if (g.containsKey(b)) g.get(b).remove(a);
    }
}