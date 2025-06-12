package menu.actions;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import menu.actions.abstractactions.Action;
import menu.terminalhandler.UserInteractor;
import model.Context;
import model.person.comparators.PersonDateComparator;
import model.person.comparators.PersonNameComparator;
import tree.PersonStringUtilsForTree;

public class GetPersonWithNamePrefixAction extends Action<Context> {

	public GetPersonWithNamePrefixAction(String name, Scanner scanner) {
		super(name, scanner);
	}

	@Override
	public ActionStatus runAction(Context tree) {
		System.out.println("Buscando por primeiro nome");
		System.out.println("Digite o valor do nome a ser procurado");
		String prefix = scanner.nextLine();

		System.out.println("Buscando por nome");

		List<PersonNameComparator> personNameComparatorList = PersonStringUtilsForTree.getNamesByPrefix(tree.getNameIndexer(), prefix);

		if(!personNameComparatorList.isEmpty()){
			personNameComparatorList.forEach(personDateComparator ->
					System.out.println(personDateComparator.getPerson().toString())
			);

			return ActionStatus.OK;
		}

		System.out.println("Pessoas nesse range não existem.");

		return ActionStatus.OK;
	}
	
}
