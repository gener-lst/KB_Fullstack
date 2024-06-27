package CLI_Framework.V4.command;

import CLI_Framework.V4.domain.StudentScores;

public class PrintScoreCommand implements Command {
    StudentScores studentScores = StudentScores.getInstance();

    public void execute() {
        int[] scores = studentScores.getScores();

        for(int i = 0; i < scores.length ; i++) {
            System.out.println("scores[" + i + "]: " + scores[i]);
        }
    }
}
