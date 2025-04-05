package menu.terminalhandler;

public class ConsoleHandler {
    public static void clearConsole()
    {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }

    public static void invalidOption(){
        clearConsole();
        System.out.println("******************************************************");
        System.out.println("Opcao invalida, insira novamente conforme a descricao:");
        System.out.println("******************************************************");
    }
}
