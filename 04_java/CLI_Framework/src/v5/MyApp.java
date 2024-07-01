package v5;

import v5.command.ExitCommand;
import v5.command.GetScoresCommand;
import v5.command.InitScoresCommand;
import v5.command.PrintScoreCommand;
import v5.command.AnalyzeCommand;
import v5.ui.Menu;
import v5.ui.MenuItem;

public class MyApp extends App {
    @Override
    public void createMenu(Menu menu) {
        super.createMenu(menu);

        menu.add(0, new MenuItem("학생수", new InitScoresCommand()));
        menu.add(1, new MenuItem("점수입력", new GetScoresCommand()));
        menu.add(2, new MenuItem("점수리스트", new PrintScoreCommand()));
        menu.add(3, new MenuItem("분석", new AnalyzeCommand()));
        menu.add(4, new MenuItem("종료", new ExitCommand()));
    }

    public static void main(final String[] args) {
        App app = new MyApp();
        app.init(5);
        app.run();
    }
}
