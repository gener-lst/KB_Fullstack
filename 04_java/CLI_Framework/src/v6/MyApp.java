package v6;

import v6.command.AnalyzeCommand;
import v6.command.GetScoresCommand;
import v6.command.InitScoresCommand;
import v6.command.PrintScoreCommand;
import v6.ui.Menu;
import v6.ui.MenuItem;

public class MyApp extends App {
    @Override
    public void createMenu(Menu menu) {
        super.createMenu(menu);
        menu.add(new MenuItem("학생수", new InitScoresCommand()));
        menu.add(new MenuItem("점수입력", new GetScoresCommand()));
        menu.add(new MenuItem("점수리스트", new PrintScoreCommand()));
        menu.add(new MenuItem("분석", new AnalyzeCommand()));
    }

    public static void main(final String[] args) {
        App app = new MyApp();
        app.run();
    }
}
