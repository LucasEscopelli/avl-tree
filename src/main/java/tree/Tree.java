package tree;

import java.util.List;

public interface Tree<C>{
    void add(C value);
    void delete(C value);
    C get(C value);
    List<C> getBetween(C start, C end);
}
