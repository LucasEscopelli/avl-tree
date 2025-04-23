package printers;

import printers.interfaces.TreePrinter;
import tree.BinaryTree;
import tree.Node;


public class AsciiPrinter<C extends Comparable<C>> implements TreePrinter<C> {
    private final Canvas canvas = new Canvas();
    private final NodeIndexer<C> indexer = new NodeIndexer<>();
    private void printArrow(Node<C> a, Node<C> b, char c){
        canvas.printArrow(c,
                indexer.getRow(a),
                indexer.getColumn(a),
                indexer.getRow(b),
                indexer.getColumn(b));
    }
    private void recursivePrint(Node<C> node){
        if(node == null) return;
        canvas.printOnMatrix(indexer.getRow(node),
                indexer.getColumn(node),
                stringFromNode(node));
        if(!node.emptyLeft()) {
            printArrow(node,node.getLeft(), '/');
            recursivePrint(node.getLeft());
        }
        if(!node.emptyRight()) {
            printArrow(node,node.getRight(), '\\');
            recursivePrint(node.getRight());
        }
    }
    @Override
    public void print(BinaryTree<C> tree) {
        indexer.index(tree.getRoot());
        canvas.clearMatrix();
        recursivePrint(tree.getRoot());
        canvas.showMatrix();
    }

    private String stringFromNode(Node<C> node){
        return String.valueOf(node.getValue());
    }
}
