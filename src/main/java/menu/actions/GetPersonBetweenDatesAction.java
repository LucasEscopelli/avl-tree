package menu.actions;

import java.util.Scanner;

import menu.actions.abstractactions.Action;
import model.Context;

public class GetPersonBetweenDatesAction extends Action<Context>{
	public GetPersonBetweenDatesAction(String name, Scanner scanner) {
		super(name, scanner);
	}

	@Override
	public ActionStatus runAction(Context tree) {
        System.out.println("Buscando por intervalo de data de nascimento");
        return ActionStatus.OK;
	}
	
}
