package org.scoula.ex05;

import org.scoula.ex05.domain.Member;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
    ServletContext sc;

    @Override
    public void init(ServletConfig config) throws ServletException {
        sc = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sc.setAttribute("scopeName", "applicationScope 값"); // Application Scope

        HttpSession session = req.getSession(); // 현재 세션을 가져오거나 존재하지 않으면 새로 생성
        session.setAttribute("scopeName", "sessionScope 값"); // Session Scope

        req.setAttribute("scopeName", "requestScope 값"); // Request Scope

//        member의 LoginServlet에서 세션에 세팅하면서 멤버 객체 생성
//        Member member = new Member("홍길동", "hong");
//        req.setAttribute("member", member);

        req.getRequestDispatcher("scope.jsp").forward(req, resp); // scope.jsp 화면 포워딩
    }
}
