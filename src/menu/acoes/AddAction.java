package menu.acoes;

import tree.Tree;

import java.util.Scanner;
import java.util.function.Consumer;

public class AddAction<T> extends InputAction<Tree<T>> {
    public AddAction(String label, Scanner scanner){
        super(label, scanner);
    }

    @Override
    public void accept(Tree<T> integerTree) {
        System.out.println("Digite o valor a ser adicionado");
    }

    @Override
    public Consumer<Tree<T>> andThen(Consumer<? super Tree<T>> after) {
        return super.andThen(after);
    }
}
