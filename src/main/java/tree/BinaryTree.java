package tree;

import java.util.ArrayList;
import java.util.List;

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
            Statistics.getInstance().incrementTreeWalks();
            response.addToPath(current);
            Statistics.getInstance().incrementComparison();
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
        assert(current != null);
        current.calculateHeight();
        this.balancer.balance(parent, current);
    }

    @Override
    public void add(C value) {
        Path<C> path = this.pathTo(value);
        if(path.isEmpty()){
            Statistics.getInstance().incrementTreeWalks();
            this.root = new Node<>(value);
            return;
        }
        checkAndAddInto(value, path.getLast());
        path.reverseForEachWithParent(this::updateNodes);
    }
    private void checkAndAddInto(C value, Node<C> current){
        Statistics.getInstance().incrementComparison();
        int comparatorResult = value.compareTo(current.getValue());

        Statistics.getInstance().incrementTreeWalks();
        if(comparatorResult < 0) current.setLeft(new Node<>(value));
        else if(comparatorResult > 0) current.setRight(new Node<>(value));

        current.calculateHeight();
    }
    @Override
    public void delete(C value){
        Path<C> path = internalDelete(value);
        path.reverseForEachWithParent(this::updateNodes);
    }
    private Path<C> internalDelete(C value) {
        Path<C> path = pathTo(value);
        if(!path.reachedValue(value)) throw new RuntimeException("Not found");
        Node<C> parent = path.getParent(1);
        Node<C> node = path.getLast();
        if(executeSimpleDelete(parent, node)) {
            path.popBack();
            return path;
        }
        Statistics.getInstance().incrementTreeWalks();
        path.addToPath(node.getLeft());
        while(!path.getLast().emptyRight()){
            Statistics.getInstance().incrementTreeWalks();
            path.addToPath(path.getLast().getRight());
        }

        C valueToSet = path.getLast().getValue();
        executeSimpleDelete(path.getParent(1), path.getLast());
        path.popBack();
        node.setValue(valueToSet);
        return path;
    }
    private boolean executeSimpleDelete(Node<C> parent, Node<C> current){
        assert(current != null);
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
        assert(current != null);
        Node<C> onlyChild = !current.emptyLeft() ? current.getLeft() : null;
        onlyChild = !current.emptyRight() ? current.getRight() : onlyChild;
        if(parent == null) this.root = onlyChild;
        else if(parent.getLeft() == current) parent.setLeft(onlyChild);
        else parent.setRight(onlyChild);
    }

    public Node<C> getRoot() {
        return root;
    }
    public void setRoot(Node<C> root) {
        this.root = root;
    }

    public List<C> getBetween(C start, C end){
        List<C> responseList = new ArrayList<>();
        this.getBetween(this.root, start, end, responseList);
        return responseList;
    }

    private void getBetween(Node<C> current, C start, C end, List<C> responseList){
        if(current == null) return;
        Statistics.getInstance().incrementTreeWalks();
        Statistics.getInstance().incrementComparison();
        if(current.getValue().compareTo(start) < 0) {
            getBetween(current.getRight(), start, end, responseList);
            return;
        }
        Statistics.getInstance().incrementComparison();
        if(current.getValue().compareTo(end) > 0){
            getBetween(current.getLeft(), start, end, responseList);
            return;
        }

        if(!current.emptyLeft()) getBetween(current.getLeft(), start, end, responseList);
        responseList.add(current.getValue());
        if(!current.emptyRight()) getBetween(current.getRight(), start, end, responseList);
    }
}
