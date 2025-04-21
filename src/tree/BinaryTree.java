package tree;

public class BinaryTree<C extends Comparable<C>> implements Tree<C> {
    private Node<C> root;
    public BinaryTree(){
    }

    /**
     * @param value searched value
     * @return list of nodes of the path going through root to the searched node.
     * If the node is not in the tree, the last index will be the place where the new value should be inserted.
     */
    private Path<C> pathTo(C value){
        Path<C> response = new Path<>();
        Node<C> current = this.root;
        while(current != null){
            response.addToPath(current);
            int compareValue = value.compareTo(current.getValue());
            if(compareValue < 0) current = current.getLeft();
            else if(compareValue > 0) current = current.getRight();
            else current = null;
        }
        return response;
    }
    @Override
    public C get(C value) {
        final Path<C> path = pathTo(value);
        if(path.reachedValue(value)) return path.getLast().getValue();
        return null;
    }
    @Override
    public void add(C value) {
        Path<C> path = this.pathTo(value);
        if(path.isEmpty()){
            this.root = new Node<>(value);
            return;
        }
        checkAndAddInto(value, path.getLast());
        path.reverseForEach(this::balance);
    }
    private void checkAndAddInto(C value, Node<C> current){
        int comparatorResult = current.getValue().compareTo(value);
        if(comparatorResult < 0) current.setLeft(new Node<>(value));
        else if(comparatorResult > 0) current.setRight(new Node<>(value));
        else current.setCount(current.getCount()+1);
    }
    private void balance(Node<C> current){
    }
    private void deleteNodeWithOneChild(Node<C> parent, Node<C> current){
        Node<C> onlyChild = !current.emptyLeft() ? current.getLeft() : null;
        onlyChild = !current.emptyRight() ? current.getRight() : null;
        if(parent.getLeft() == current) parent.setLeft(onlyChild);
        else if(parent.getRight() == current) parent.setRight(onlyChild);
    }
    private void deleteRoot(){
        this.root = null;
    }
    @Override
    public void delete(C value) {
        Path<C> path = pathTo(value);
        if(!path.reachedValue(value)) throw new RuntimeException("Not found");
        Node<C> parent = path.getParent(1);
        Node<C> node = path.getLast();
        if(parent == null){
            deleteRoot();
            return;
        }
        if(!node.emptyRight() ^ !node.emptyLeft()){
            deleteNodeWithOneChild(parent, node);
            return;
        }
        Node<C> parentOfBestFromLeft = node;
        Node<C> bestFromLeft = node.getLeft();
        while(!bestFromLeft.emptyRight()) {
            parentOfBestFromLeft = bestFromLeft;
            bestFromLeft = bestFromLeft.getRight();
        }
        node.setValue(bestFromLeft.getValue());
        deleteNodeWithOneChild(parentOfBestFromLeft, bestFromLeft);
    }
    @Override
    public C getOrAdd(C value, C defaultValue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrAdd'");
    }
}
