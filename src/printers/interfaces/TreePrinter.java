package printers.interfaces;

import tree.BinaryTree;

public interface TreePrinter<C extends Comparable<C>> {
    void print(BinaryTree<C> tree);
}
