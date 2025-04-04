import menu.Menu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Nomes: Erik Morbach, Fábio Valandro e Lucas Escopelli");
        System.out.println("Trabalho prático Grau A - Árvore AVL");
        System.out.println("A Árvore AVL deve armazenar números inteiros e fornecer métodos de busca, inserção e remoção.");
        Menu menu = new Menu();
        do{
            menu.showMenu();
            menu.executeOption(menu.getOption());
        }while(true);
    }
}