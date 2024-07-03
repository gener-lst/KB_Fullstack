package v3.command;

import v3.domain.StudentScores;
import v3.Input;

public class InitScoresCommand implements Command {
    StudentScores studentScores = StudentScores.getInstance();

    @Override
    public void execute() {
        int studentNum = Input.getInt("학생수> ");
//        studentNum과 점수 배열의 크기를 할당
        studentScores.setStudentNum(studentNum);
    }
}
