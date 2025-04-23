package printers;

import printers.interfaces.TreePrinter;
import tree.BinaryTree;

public class PosfixPrinter<C extends Comparable<C>> implements TreePrinter<C> {
    @Override
    public void print(BinaryTree<C> tree) {
        System.out.println("posfix");
    }

    @Override
    public String name() {
        return "Posfix";
    }
}
