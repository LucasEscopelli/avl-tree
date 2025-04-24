package printers;

import printers.interfaces.TreePrinter;
import tree.BinaryTree;
import tree.Node;

public class PrefixPrinter<C extends Comparable<C>> implements TreePrinter<C> {
    @Override
    public void print(BinaryTree<C> tree) {
        preOrderPrint(tree.getRoot());
    }

    @Override
    public String name() {
        return "Prefix";
    }

    private void preOrderPrint(Node<C> node) {
        if (node != null) {
            System.out.println(node.getValue());
            preOrderPrint(node.getLeft());
            preOrderPrint(node.getRight());
        }
    }
}
