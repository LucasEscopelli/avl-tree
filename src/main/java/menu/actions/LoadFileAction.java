package menu.actions;

import java.util.Scanner;

import menu.actions.abstractactions.Action;
import model.Context;

public class LoadFileAction extends Action<Context>{

	public LoadFileAction(String name, Scanner scanner) {
		super(name, scanner);
	}

	@Override
	public ActionStatus runAction(Context tree) {
        System.out.println("Buscando arquivo");
        return ActionStatus.OK;
	}
	
}
