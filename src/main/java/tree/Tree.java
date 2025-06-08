package tree;

public interface Tree<C>{
    void add(C value);
    void delete(C value);
    C get(C value);
    C getOrAdd(C value, C defaultValue);
}
