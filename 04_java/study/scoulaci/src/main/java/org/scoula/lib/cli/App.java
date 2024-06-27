package org.scoula.lib.cli;//package CLI_Framework.V6;
//
//import CLI_Framework.V3.command.Command;
//import CLI_Framework.V6.command.ExitCommand;
//import CLI_Framework.V6.ui.Menu;
//import CLI_Framework.V6.ui.MenuItem;
//
//public abstract class App {
//    Menu menu;
//
//    public App() {}
//
//    public void init(int menuSize) {
//        menu = new Menu();
//        createMenu(menu);
//        menu.add(new MenuItem("종료", new ExitCommand()));
//    }
//
//    public void createMenu(Menu menu) {
//
//    }
//
//    public void run() {
//        init();
//        while (true) {
//            menu.printMenu();
//            Command command = menu.getSelect();
//            command.execute();
//        }
//    }
//}


