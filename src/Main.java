import menu.Menu;

public class Main {
    public static void main(String[] args) {
        Integer a = 0;
        Integer b = 1;
        System.out.println(a.compareTo(b));
        Menu menu = new Menu();
        do{
            menu.showMenu();
            menu.executeOption(menu.getOption());
        }while(true);
    }
}