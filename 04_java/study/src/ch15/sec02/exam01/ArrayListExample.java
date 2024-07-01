package ch15.sec02.exam01;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
//        ArrayList 생성
//        List는 인터페이스기 때문에 해당 인터페이스를 구현한 구현 클래스로 객체를 생성해야 한다.
        List<Board> list = new ArrayList();

//        객체 추가
        list.add(new Board("제목1", "내용1", "글쓴이1"));
        list.add(new Board("제목2", "내용2", "글쓴이2"));
        list.add(new Board("제목3", "내용3", "글쓴이3"));
        list.add(new Board("제목4", "내용4", "글쓴이4"));
        list.add(new Board("제목5", "내용5", "글쓴이5"));

//        저장된 총 객체 수 얻기
        int size = list.size();
        System.out.println("총 객체 수: " + size);
        System.out.println();

        Board board = list.get(2);
        System.out.println(board.getSubject() + "\t" + board.getContent() + "\t" + board.getWriter());
        System.out.println();

//        for문은 모든 객체를 하나씩 가져올 수 있다
        for (int i = 0; i < list.size(); i++) {
            Board b = list.get(i);
            System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
        }
        System.out.println();

//        인덱스가 2인 객체를 두 번 삭제힘
//        한 번 삭제 후, 뒤에 있는 객체가 앞으로 당겨짐
        list.remove(2);
        list.remove(2);

        // 향상된 for문으로 모든 객체 하나씩 가져오기
        // 향상된 for문으로 모든 객체 하나씩 가져오기
        for(Board b : list) {
            System.out.println((b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter()));
        }
    }
}
