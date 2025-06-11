package tree;

import model.person.comparators.AbstractPersonComparator;

import java.util.List;

public interface Tree<C>{
    void add(C value);
    void delete(C value);
    C get(C value);
    C getOrAdd(C value, C defaultValue);
    C getLeft(C value);
    C getRight(C value);
    List<C> getBetween(C initial, C end);
}
