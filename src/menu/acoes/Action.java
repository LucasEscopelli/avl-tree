package menu.acoes;

import java.util.function.Consumer;

public abstract class Action<T> implements Consumer<T> {
    private String name;
    Action(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
