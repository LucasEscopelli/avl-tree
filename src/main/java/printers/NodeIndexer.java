package printers;

import tree.Node;

import java.util.HashMap;
import java.util.Map;

public class NodeIndexer<C extends Comparable<C>> {
    private int column;
    private Map<Node<C>, Integer> nodeToColumn = new HashMap<>();
    private Map<Node<C>, Integer> nodeToRow = new HashMap<>();
    public void index(Node<C> root){
        column = 0;
        nodeToColumn.clear();
        nodeToRow.clear();
        dfs(root, 0, nodeToRow, nodeToColumn);
    }
    public int getRow(Node<C> node){ return nodeToRow.getOrDefault(node, -1); }
    public int getColumn(Node<C> node){ return nodeToColumn.getOrDefault(node, -1); }
    private void dfs(Node<C> node, int depth, Map<Node<C>, Integer> mapperRows, Map<Node<C>, Integer> mapperColumns){
        if(!node.emptyLeft()) dfs(node.getLeft(), depth+1, mapperRows, mapperColumns);
        mapperColumns.put(node, column++);
        mapperRows.put(node, depth);
        if(!node.emptyRight()) dfs(node.getRight(), depth+1, mapperRows, mapperColumns);
    }
}
