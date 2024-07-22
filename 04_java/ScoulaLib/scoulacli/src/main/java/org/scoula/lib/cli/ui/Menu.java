package org.scoula.lib.cli.ui;

import org.scoula.lib.cli.command.Command;
import org.scoula.lib.cli.exception.BadMenuException;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    ArrayList<MenuItem> menus;

    public Menu() {
        menus = new ArrayList<>();
    }

    public void add(MenuItem item) {
        menus.add(item);
    }

    public void printMenu() {
        System.out.println("------------------------------------------------");
        for (int i = 0; i < menus.size(); i++) {
            System.out.printf("%d.%s | ", i+1, menus.get(i).getTitle());
        }
        System.out.println();
        System.out.println("------------------------------------------------");
    }

    public Command getSelect() throws Exception {
        try {
            int selectNo = Input.getInt("선택> ");
            return menus.get(selectNo-1).getCommand();
        } catch (Exception e) {
            throw new BadMenuException();
        }

    }
}
