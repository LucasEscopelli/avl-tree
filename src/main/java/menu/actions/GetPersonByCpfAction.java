package menu.actions;

import java.util.Scanner;

import menu.actions.abstractactions.Action;
import model.Context;

public class GetPersonByCpfAction extends Action<Context>{

	public GetPersonByCpfAction(String name, Scanner scanner) {
		super(name, scanner);
	}

	@Override
	public ActionStatus runAction(Context tree) {
        System.out.println("Buscando por cpf");
        return ActionStatus.OK;
	}
	
}
