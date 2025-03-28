package tree;

public class Node<C> {
    private C value;
    private int height;
    private Node<C> right;
    private Node<C> left;

    public Node<C> getRight() {
        return right;
    }

    public Node<C> getLeft() {
        return left;
    }

    public C getValue() {
        return value;
    }

    public void setHeight(int height) {
        this.height = height;
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

    public Node(){
        super();
    }

    public Node(C value){
        this.value = value;
        this.height = 0;
    }
}
