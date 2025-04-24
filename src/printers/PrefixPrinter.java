package printers;

import printers.interfaces.TreePrinter;
import tree.BinaryTree;
import tree.Node;

public class PrefixPrinter<C extends Comparable<C>> implements TreePrinter<C> {
    @Override
    public void print(BinaryTree<C> tree) {
        StringBuffer result = new StringBuffer();
        preOrderPrint(tree.getRoot(), result);
        System.out.println(result);
    }

    private void preOrderPrint(Node<C> node, StringBuffer buffer) {
        if (node != null) {
            if (!buffer.isEmpty()) {
                buffer.append(", ");
            }
            buffer.append(node.getValue());
            preOrderPrint(node.getLeft(), buffer);
            preOrderPrint(node.getRight(), buffer);
        }
    }

    @Override
    public String name() {
        return "Prefix";
    }
}
