package printers;

import printers.interfaces.TreePrinter;
import tree.BinaryTree;
import tree.Node;

public class InfixPrinter<C extends Comparable<C>> implements TreePrinter<C> {
    @Override
    public void print(BinaryTree<C> tree) {
        StringBuffer result = new StringBuffer();
        inOrderPrint(tree.getRoot(), result);
        System.out.println(result);
    }

    private void inOrderPrint(Node<C> node, StringBuffer buffer) {
        if (node != null) {
            inOrderPrint(node.getLeft(), buffer);
            if (!buffer.isEmpty()) {
                buffer.append(", ");
            }
            buffer.append(node.getValue());
            inOrderPrint(node.getRight(), buffer);
        }
    }

    @Override
    public String name() {
        return "Infix";
    }
}
