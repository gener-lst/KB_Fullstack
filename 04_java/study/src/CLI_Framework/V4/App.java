package CLI_Framework.V4;

import CLI_Framework.V4.command.*;
import CLI_Framework.V4.ui.Menu;
import CLI_Framework.V4.ui.MenuItem;

//public class App {
//    Menu menu;
//
//    public App() {
//    }
//
//    public void init(int menuSize) {
//        menu = new Menu(menuSize);
//        createMenu(menu);
//    }
//
//    public void createMenu(Menu menu) {
//        menu.add(0, new MenuItem("학생수", new InitScoresCommand()));
//        menu.add(1, new MenuItem("점수입력", new InitScoresCommand()));
//        menu.add(2, new MenuItem("점수리스트", new InitScoresCommand()));
//        menu.add(3, new MenuItem("분석", new InitScoresCommand()));
//        menu.add(4, new MenuItem("종료", new ExitCommand()));
//
//
//    }
//
//    public void executeCommand(int selectNo) {
//        Command command = commands[selectNo - 1];
//        command.execute();
//    }
//
//    public void run() {
//        while(true) {
//            menu.printMenu();
//            int selectNo = menu.getSelect();
//            executeCommand(selectNo);
//        }
//    }
//
//    public static void main(String[] args) {
//        App app = new App();
//        app.run();
//    }
//}

