package menu.actions;

import menu.actions.abstractactions.Action;
import menu.terminalhandler.UserInteractor;
import tree.Tree;

import java.util.Scanner;

public class RemoveAction extends Action<Tree<Integer>> {
    public RemoveAction(String name, Scanner scanner) {
        super(name, scanner);
    }
    @Override
    public ActionStatus runAction(Tree<Integer> tree) {
        printActionToDo();
        Integer node = UserInteractor.getIntegerValueFromUser(scanner, this::printActionToDo);
        try {
            tree.delete( node);
        }catch (Exception e){
            System.out.println("Valor Não encontrado");
            return ActionStatus.FAILED;
        }
        System.out.println("Valor removido com sucesso");
        return ActionStatus.OK;
    }

    private void printActionToDo(){
        System.out.println("Digite o INTEIRO a ser removido da árvore.");
    }
}
