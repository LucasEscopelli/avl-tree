package tree;

public class BinaryTree<C extends Comparable<C>> implements Tree<C> {
    private Node<C> root;
    private final TreeBalancer<C> balancer;
    public BinaryTree(){
        this.balancer = new TreeBalancer<>(this);
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
    public void updateNodes(Node<C> parent, Node<C> current){
        current.calculateHeight();
        this.balancer.balance(parent, current);
    }

    @Override
    public void add(C value) {
        Path<C> path = this.pathTo(value);
        if(path.isEmpty()){
            this.root = new Node<>(value);
            return;
        }
        checkAndAddInto(value, path.getLast());
        path.reverseForEachWithParent(this::updateNodes);
    }
    private void checkAndAddInto(C value, Node<C> current){
        int comparatorResult = value.compareTo(current.getValue());
        if(comparatorResult < 0) current.setLeft(new Node<>(value));
        else if(comparatorResult > 0) current.setRight(new Node<>(value));
    }
    @Override
    public void delete(C value){
        Path<C> path = internalDelete(value);
        path.reverseForEachWithParent(this::updateNodes);
    }
    public Path<C> internalDelete(C value) {
        Path<C> path = pathTo(value);
        if(!path.reachedValue(value)) throw new RuntimeException("Not found");
        Node<C> parent = path.getParent(1);
        Node<C> node = path.getLast();
        if(executeSimpleDelete(parent, node)) {
            path.popBack();
            return path;
        }
        path.addToPath(node.getLeft());
        while(!path.getLast().emptyRight())
            path.addToPath(path.getLast().getRight());

        C valueToSet = path.getLast().getValue();
        executeSimpleDelete(path.getParent(1), path.getLast());
        path.popBack();
        node.setValue(valueToSet);
        return path;
    }
    private boolean executeSimpleDelete(Node<C> parent, Node<C> current){
        if(current.emptyRight() && current.emptyLeft()){
            deleteEmptyNode(parent, current);
            return true;
        }
        if(current.emptyRight() ^ current.emptyLeft()){
            deleteNodeWithOneChild(parent, current);
            return true;
        }
        return false;
    }
    private void deleteRoot(){
        this.root = null;
    }
    private void deleteEmptyNode(Node<C> parent, Node<C> current){
        if(parent == null) deleteRoot();
        else if(parent.getLeft() == current) parent.setLeft(null);
        else parent.setRight(null);
    }
    private void deleteNodeWithOneChild(Node<C> parent, Node<C> current){
        Node<C> onlyChild = !current.emptyLeft() ? current.getLeft() : null;
        onlyChild = !current.emptyRight() ? current.getRight() : onlyChild;
        if(parent == null) this.root = onlyChild;
        else if(parent.getLeft() == current) parent.setLeft(onlyChild);
        else parent.setRight(onlyChild);
    }
    @Override
    public C getOrAdd(C value, C defaultValue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrAdd'");
    }

    public Node<C> getRoot() {
        return root;
    }
    public void setRoot(Node<C> root) {
        this.root = root;
    }

}
