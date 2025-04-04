package menu;

import menu.acoes.Action;
import menu.acoes.AddAction;
import tree.BinaryTree;
import tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final List<Action<Tree<Integer>>> actions = new ArrayList<>();
    private final Tree<Integer> tree = new BinaryTree<>();
    private Scanner scanner = new Scanner(System.in);

    public Menu(){
            actions.add(new AddAction<>("1. Adicionar Inteiro à árvore", scanner));
    }

    public void showMenu(){
        System.out.println("Menu:");
        for(int index = 0;index < this.actions.size();index++){
            var action = this.actions.get(index);
            System.out.printf("\t%d. %s\n", index + 1, action);
        }
    }
    public void executeOption(int option){
        if(!isValidOption(option))
            throw new RuntimeException("Opção invalida!");
        option -= 1;
        this.actions.get(option).accept(this.tree);
    }

    private boolean isValidOption(int option){
        return 1 <= option && option <= this.actions.size();
    }

    public int getOption(){
        int option = 0;
        do{
            System.out.print("Digite a opção desejada: ");
            option = this.scanner.nextInt();
            if(!isValidOption(option)){
                System.out.println("Opção invalida... Digite novamente");
            }
        }while(!isValidOption(option));
        return option;
    }
}
