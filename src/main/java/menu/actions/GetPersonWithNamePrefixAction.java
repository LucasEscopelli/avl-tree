package menu.actions;

import java.util.Scanner;

import menu.actions.abstractactions.Action;
import model.Context;

public class GetPersonWithNamePrefixAction extends Action<Context> {

	public GetPersonWithNamePrefixAction(String name, Scanner scanner) {
		super(name, scanner);
	}

	@Override
	public ActionStatus runAction(Context tree) {
        System.out.println("Buscando por nomes com determinado prefixo");
        return ActionStatus.OK;
	}
	
}
