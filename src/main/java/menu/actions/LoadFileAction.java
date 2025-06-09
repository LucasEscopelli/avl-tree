package menu.actions;

import java.util.Scanner;

import menu.actions.abstractactions.Action;
import model.Context;

public class LoadFileAction extends Action<Context>{
	private String defaultPath = "./data/nomes.csv";
	public LoadFileAction(String name, Scanner scanner) {
		super(name, scanner);
	}

	@Override
	public ActionStatus runAction(Context ctx) {
		System.out.print("Digite o caminho do arquivo .CSV (Default: './data/nomes.csv'): ");
		String path = scanner.nextLine();
		if (path.isEmpty()) {
			path = defaultPath;
		}
		try {
			System.out.println("Buscando arquivo...");
			ctx.loadFile(path);
			System.out.println("Arquivo carregado com sucesso!");

		} catch (Exception e) {
			System.out.println("Erro ao carregar arquivo: " + e.getMessage());
			return ActionStatus.FAILED;
		}
		return ActionStatus.OK;
	}

}
