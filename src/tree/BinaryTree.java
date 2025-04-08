package tree;

public class BinaryTree<C extends Comparable<C>> implements Tree<C> {
    Node<C> root;

    public BinaryTree(C ...values){
        for(C value: values){
            add(value);
        }
    }

    @Override
    public void add(C value) {
        System.out.println("entrou no metodo add");
    }

    @Override
    public void delete(C value) {
        System.out.println("Entrou no metodo delete");
    }

    @Override
    public C get(C value) {
        System.out.println("Entrou no metodo get");
        return null;
    }

    @Override
    public C getOrAdd(C value, C defaultValue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrAdd'");
    }
}
