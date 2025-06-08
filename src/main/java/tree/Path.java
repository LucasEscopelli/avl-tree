package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Path<C extends Comparable<C>> {
    private List<Node<C>> path;
    public Path(){
        path = new ArrayList<>();
    }
    public void forEach(Consumer<Node<C>> func){
        for(Node<C> node: path)
            func.accept(node);
    }
    public void reverseForEachWithParent(BiConsumer<Node<C>, Node<C>> func){
        for(int i=path.size()-1;i>=0;i--)
            func.accept((i>0 ? path.get(i-1) : null), path.get(i));
    }
    public boolean reachedValue(C c){
        if(this.isEmpty()) return false;
        return this.getLast().getValue().compareTo(c) == 0;
    }
    public void addToPath(Node<C> n){
        path.add(n);
    }
    public Node<C> getLast(){
        return path.get(path.size()-1);
    }

    /**
     * @param level level of ancestor based on the last node on the path
     * @return
     */
    public Node<C> getParent(int level){
        if(level > path.size()-1){
            return null;
        }
        return path.get(path.size() - 1 - level);
    }
    public void popBack(){
        if(this.isEmpty()) return;
        this.path.remove(this.path.size()-1);
    }
    public boolean isEmpty(){
        return path.isEmpty();
    }
    public List<Node<C>> getPath(){
        return path;
    }
}
