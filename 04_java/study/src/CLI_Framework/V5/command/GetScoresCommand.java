package CLI_Framework.V5.command;

import CLI_Framework.V2.Input;
import CLI_Framework.V5.domain.StudentScores;

public class GetScoresCommand implements Command {
    StudentScores studentScores = StudentScores.getInstance();


    @Override
    public void execute() {
        int[] scores = studentScores.getScores();

        for(int i = 0; i < scores.length; i++) {
            scores[i] = Input.getInt("scores[" + i + "]> ");
        }
    }
}
