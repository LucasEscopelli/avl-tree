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
        return;
//        if (value == null){
//            return;
//        }
//
//        Node<C> dummy = root;
//
//        if (dummy == null){
//            root = new Node<C>(value);
//        }
//
//        while (!value.equals(dummy.getValue())){
//
//            if (value.compareTo(dummy.getValue()) < 0) { // se value < dummy.getValue()
//                if (dummy.getLeft() == null){
//                    dummy.setLeft(new Node<>(value));
//                }
//
//                dummy = dummy.getLeft();
//            } else if (value.compareTo(dummy.getValue()) > 0) { // se value > dummy.getValue()
//
//                if (dummy.getRight() == null){
//                    dummy.setRight(new Node<>(value));
//                }
//
//                dummy = dummy.getRight();
//            }
//            System.out.println(dummy.getValue());
//        }
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
