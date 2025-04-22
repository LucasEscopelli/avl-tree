package tree;

public class Node<C> {
    private C value = null;
    private int height = 1;
    private Node<C> right = null;
    private Node<C> left = null;

    public Node(){
        super();
    }

    public Node(C value){
        this.value = value;
    }

    public boolean emptyRight() { return this.right == null; }
    public boolean emptyLeft() { return this.left == null; }
    public Node<C> getRight() {
        return right;
    }

    public Node<C> getLeft() {
        return left;
    }

    public C getValue() {
        return value;
    }

    public void calculateHeight(){
        int leftHeight = (left != null) ? left.height : -1;
        int rightHeight = (right != null) ? right.height : -1;
        this.height = 1 + Math.max(leftHeight, rightHeight);
    }
    public int getBalanceFactor(){
        int leftHeight = (left != null) ? left.height : 0;
        int rightHeight = (right != null) ? right.height : 0;
        return leftHeight - rightHeight;
    }

    public int getHeight() {
        return height;
    }

    public void setValue(C value) {
        this.value = value;
    }

    public void setRight(Node<C> right) {
        this.right = right;
    }

    public void setLeft(Node<C> left) {
        this.left = left;
    }
}
