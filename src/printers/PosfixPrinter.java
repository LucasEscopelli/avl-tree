package printers;

import printers.interfaces.TreePrinter;
import tree.BinaryTree;
import tree.Node;

public class PosfixPrinter<C extends Comparable<C>> implements TreePrinter<C> {
    @Override
    public void print(BinaryTree<C> tree) {
        StringBuffer result = new StringBuffer();
        postOrderPrint(tree.getRoot(), result);
        System.out.println(result);
    }

    private void postOrderPrint(Node<C> node, StringBuffer buffer) {
        if (node != null) {
            postOrderPrint(node.getLeft(), buffer);
            postOrderPrint(node.getRight(), buffer);
            if (!buffer.isEmpty()) {
                buffer.append(", ");
            }
            buffer.append(node.getValue());
        }
    }

    @Override
    public String name() {
        return "Posfix";
    }
}
