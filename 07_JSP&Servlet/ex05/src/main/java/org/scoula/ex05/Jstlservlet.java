package org.scoula.ex05;

import org.scoula.ex05.domain.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/jstl_ex")
public class Jstlservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Member> members = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
//            10명의 Member 객체를 만들고 리스트에 저장
            Member member = new Member("홍길동_" + i, "hong_" + i);
            members.add(member);
        }
//        10명의 리스트 정보를 request scope에 속성 설정
        req.setAttribute("members", members);
        req.setAttribute("role", "ADMIN");

        req.setAttribute("today", new Date());

        req.getRequestDispatcher("jstl_ex.jsp")
                .forward(req, resp);
    }
}

