package tree;

public class TreeBalancer {
    public static <C extends Comparable<C>> void balance(Node<C> parent, Node<C> current){
        if(Math.abs(current.getBalanceFactor()) < 2) return;
        if(current.getBalanceFactor() < 0){
            if(current.getRight().getBalanceFactor() < 0) simpleRotationLeft(parent,current);
            else doubleRotationLeft(parent, current);
        }
        else{
            if(current.getLeft().getBalanceFactor() > 0) simpleRotationRight(parent,current);
            else doubleRotationRight(parent, current);
        }
    }

    /**
     *      parent
     *        |
     *      current
     *    /        \
     *   X          W
     *  / \
     * Y   Z
     *  will be transformed into
     *  parent
     *    |
     *    X
     *  /   \
     * Y  current
     *   /      \
     * Z         W
     */
    private static <C extends Comparable<C>> void simpleRotationRight(Node<C> parent, Node<C> current){
        Node<C> leftChild = current.getLeft();
        assert(leftChild != null); // We should only call this method if the right rotation is possible.
        setNewChildForParent(parent, current, leftChild);
        current.setLeft(leftChild.getRight());
        leftChild.setRight(current);
    }
    /**
     *      parent
     *        |
     *      current
     *    /        \
     *   W          X
     *             / \
     *            Y   Z
     *  will be transformed into
     *      parent
     *        |
     *        X
     *     /    \
     * current   Z
     *   /   \
     *  W     Y
     */
    private static <C extends Comparable<C>> void simpleRotationLeft(Node<C> parent, Node<C> current){
        Node<C> rightChild = current.getRight();
        assert(rightChild != null); // We should only call this method if the right rotation is possible.
        setNewChildForParent(parent, current, rightChild);
        current.setRight(rightChild.getLeft());
        rightChild.setLeft(current);
    }
    private static <C extends Comparable<C>> void doubleRotationRight(Node<C> parent, Node<C> current){
        Node<C> leftChild = current.getLeft();
        assert(leftChild != null); // We should only call this method if the right rotation is possible.
        simpleRotationLeft(current, leftChild);
        simpleRotationRight(parent, current);

    }
    private static <C extends Comparable<C>> void doubleRotationLeft(Node<C> parent, Node<C> current){
        Node<C> rightChild = current.getRight();
        assert(rightChild != null); // We should only call this method if the right rotation is possible.
        simpleRotationLeft(current, rightChild);
        simpleRotationRight(parent, current);
    }
    private static <C extends Comparable<C>> void setNewChildForParent(Node<C> parent, Node<C> current, Node<C> child){
        if(parent == null) return; // we are rotation on a root, so no need for parent in this context
        if(current == parent.getLeft()) parent.setLeft(child);
        else parent.setRight(child);
    }
}
