package menu;

import menu.acoes.Action;
import menu.acoes.AddAction;
import tree.BinaryTree;
import tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final List<Action<Tree<Integer>>> funcoes = new ArrayList<>();
    private final Tree<Integer> tree = new BinaryTree<>();
    private Scanner scanner = new Scanner(System.in);

    public Menu(){
            funcoes.add(new AddAction<>("1. Adicionar Inteiro à árvore", scanner));
    }

    public void menu(){
        funcoes.forEach(funcao -> {
            System.out.println(funcao.getName());
        });
        Scanner scanner = new Scanner(System.in);
        int escolha = Integer.parseInt(scanner.nextLine());
        funcoes.get(escolha + 1).accept(tree);
    }
}
