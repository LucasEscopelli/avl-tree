package printers;

import printers.interfaces.TreePrinter;
import tree.BinaryTree;
import tree.Node;

public class InfixPrinter<C extends Comparable<C>> implements TreePrinter<C> {
    @Override
    public void print(BinaryTree<C> tree) {
        inOrderPrint(tree.getRoot());
    }

    private void inOrderPrint(Node<C> node) {
        if (node != null) {
            inOrderPrint(node.getLeft());
            System.out.println(node.getValue());
            inOrderPrint(node.getRight());
        }
    }

    @Override
    public String name() {
        return "Infix";
    }
}
