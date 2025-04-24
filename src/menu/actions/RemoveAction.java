package menu.actions;

import menu.actions.abstractactions.Action;
import menu.terminalhandler.UserInteractor;
import tree.Tree;

import java.util.Scanner;
import java.util.function.Consumer;

public class RemoveAction <T> extends Action<Tree<T>> {
    public RemoveAction(String name, Scanner scanner) {
        super(name, scanner);
    }

    @Override
    public ActionStatus runAction(Tree<T> tree) {
        printActionToDo();
        Integer node = UserInteractor.getIntegerValueFromUser(scanner, this::printActionToDo);
        try {
            tree.delete((T) node);
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
