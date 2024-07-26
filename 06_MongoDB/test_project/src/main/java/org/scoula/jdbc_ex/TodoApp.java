package org.scoula.jdbc_ex;

import org.scoula.lib.cli.ui.Menu;
import org.scoula.lib.cli.ui.MenuItem;

public class TodoApp extends App {
    Menu userMenu;
    Menu anonymousMenu;

    @Override
    public void init() {
        anonymousMenu = new Menu();
        anonymousMenu.add(new MenuItem("로그인", this::login));
        anonymousMenu.add(new MenuItem("가입", this::join));
        anonymousMenu.add(new MenuItem("종료", this::exit));

        userMenu = new Menu();
        userMenu.add(new MenuItem("로그아웃", this::logout));
        userMenu.add(new MenuItem("종료", this::exit));

        setMenu(anonymousMenu); // 시작은 anonymousMenu로
    }

    public void join(){

    }

    public void login() {
        setMenu(userMenu); //메뉴교체
    }

    public static void main(final String[] args) {
        final TodoApp app = new TodoApp();
        app.run();
    }
}
