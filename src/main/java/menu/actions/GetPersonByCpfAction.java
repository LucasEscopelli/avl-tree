package menu.actions;

import java.util.Scanner;

import menu.actions.abstractactions.Action;
import model.Context;
import model.person.Person;
import model.person.comparators.PersonCpfComparator;

public class GetPersonByCpfAction extends Action<Context>{

	public GetPersonByCpfAction(String name, Scanner scanner) {
		super(name, scanner);
	}

	@Override
	public ActionStatus runAction(Context ctx) {
		System.out.print("Digite o CPF (somente números): ");
		String cpfInput = scanner.nextLine();

		if (!isValidCpfFormat(cpfInput)) {
			System.out.println("Erro: CPF inválido. Deve conter exatamente 11 dígitos numéricos.");
			return ActionStatus.FAILED;
		}

		long cpfValue;
		try {
			cpfValue = Long.parseLong(cpfInput);
		} catch (NumberFormatException e) {
			System.out.println("Erro interno: CPF não pôde ser convertido para número. Tente novamente.");
			return ActionStatus.FAILED;
		}

        	System.out.println("Buscando por cpf...");
		PersonCpfComparator searchComparator = new PersonCpfComparator(cpfValue);
		PersonCpfComparator foundComparator = ctx.getCpfIndexer().get(searchComparator);

		if (foundComparator != null) {
			Person foundPerson = foundComparator.getPerson();
			System.out.println("\n--- Pessoa encontrada ---");
			System.out.println(foundPerson.toString());

		} else {
			System.out.println("Pessoa com CPF '" + cpfInput + "' não encontrada.");
		}

        return ActionStatus.OK;
	}

	private boolean isValidCpfFormat(String cpf) {
		if (cpf == null || cpf.length() != 11) {
			return false;
		}

		for (char c : cpf.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

}
