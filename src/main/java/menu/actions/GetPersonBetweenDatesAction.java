package menu.actions;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import menu.actions.abstractactions.Action;
import menu.terminalhandler.UserInteractor;
import model.Context;
import model.person.Person;
import model.person.comparators.PersonDateComparator;

public class GetPersonBetweenDatesAction extends Action<Context>{
	public GetPersonBetweenDatesAction(String name, Scanner scanner) {
		super(name, scanner);
	}

	@Override
	public ActionStatus runAction(Context tree) {
        System.out.println("Buscando por intervalo de data de nascimento");
		Date beginDate = UserInteractor.getDateValueFromUser(scanner, this::printBegdaAction);
		Date endDate = UserInteractor.getDateValueFromUser(scanner, this::printEnddaAction);

		System.out.println("Buscando por datas");
		PersonDateComparator comparatorBegda = new PersonDateComparator(null, beginDate);
		PersonDateComparator comparatorEndda = new PersonDateComparator(null, endDate);
		List<PersonDateComparator> personDateComparators = tree.getDateIndexer().getBetween(comparatorBegda, comparatorEndda);
		if(!personDateComparators.isEmpty()){
			personDateComparators.forEach(personDateComparator ->
					System.out.println(personDateComparator.getPerson().toString())
			);

			return ActionStatus.OK;
		}
		System.out.println("Pessoas nesse range não existem.");

        return ActionStatus.OK;
	}

	private void printBegdaAction(){
		System.out.println("Digite a data final do range:");
	}

	private void printEnddaAction(){
		System.out.println("Digite a data inicial do range:");
	}
	
}
