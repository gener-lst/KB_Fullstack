package org.scoula.studentscore.command;

import org.scoula.lib.cli.ui.Input;
import org.scoula.studentscore.domain.StudentScores;

public class StudentScoreService {
    StudentScores studentScores = StudentScores.getInstance();

    public void initScores() {
        int studentNum = Input.getInt("학생수> ");
        studentScores.setStudentNum(studentNum);
    }

    public void getScores() {
        int[] scores = studentScores.getScores();

        for(int i = 0; i < scores.length; i++) {
            scores[i] = Input.getInt("scores[" + i + "]> ");
        }
    }

    public void printScores() {
        int[] scores = studentScores.getScores();

        for(int i = 0; i < scores.length ; i++) {
            System.out.println("scores[" + i + "]: " + scores[i]);
        }
    }

    public void analyze() {
        int[] scores = studentScores.getScores();
        int max = 0;
        int sum = 0;
        double avg = 0;

        for(int i = 0; i < scores.length; i++) {
            max = (max < scores[i]) ? scores[i] : max;
            sum += scores[i];
        }
        avg = (double) sum / studentScores.getStudentNum();

        System.out.println("최고 점수: " + max);
        System.out.println("평균 점수: " + avg);
    }
}
