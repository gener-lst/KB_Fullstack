package org.scoula.ex04;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 속성 설정(request 스코프 내에서만)
        request.setAttribute("username", "홍길동");
        request.setAttribute("useraddress","서울");

        // forward
        // response.jsp로 요청을 전달할 RequestDispatcher를 가져온다
        RequestDispatcher dis = request.getRequestDispatcher("/response.jsp");
        // request와 reponse를 포워딩시킨다
        dis.forward(request, response);
    }
}
