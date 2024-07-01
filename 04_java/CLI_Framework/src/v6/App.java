package v6;

import v6.command.Command;
import v6.command.ExitCommand;
import v6.ui.Menu;
import v6.ui.MenuItem;

public abstract class App {
    Menu menu;

    public App() {}

    public void init() {
        menu = new Menu();
        createMenu(menu);
        menu.add(new MenuItem("종료", new ExitCommand()));
    }

    public void createMenu(Menu menu) {

    }

    public void run() {
        init();
        while (true) {
            menu.printMenu();
            Command command = menu.getSelect();
            command.execute();
        }
    }
}


