package tree;

public class Node<C> {
    private C value = null;
    private int height = 0;
    private int count = 0;
    private Node<C> right = null;
    private Node<C> left = null;

    public Node(){
        super();
    }

    public Node(C value){
        this.value = value;
        this.count = 1;
    }

    public boolean emptyRight() { return this.left == null; }
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
        this.height = 0;
    }
    public int getBalanceFactor(){
        return 0;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
