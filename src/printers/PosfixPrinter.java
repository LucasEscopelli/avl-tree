package printers;

import printers.interfaces.TreePrinter;
import tree.BinaryTree;
import tree.Node;

public class PosfixPrinter<C extends Comparable<C>> implements TreePrinter<C> {
    @Override
    public void print(BinaryTree<C> tree) {
        postOrderPrint(tree.getRoot());
    }

    @Override
    public String name() {
        return "Posfix";
    }


    private void postOrderPrint(Node<C> node) {
        if (node != null) {
            postOrderPrint(node.getLeft());
            postOrderPrint(node.getRight());
            System.out.println(node.getValue());
        }
    }
}
