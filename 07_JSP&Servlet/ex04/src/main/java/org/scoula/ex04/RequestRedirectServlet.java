package org.scoula.ex04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request_redirect")
public class RequestRedirectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 해당 요청은 내부에서 쓰이지 않으므로 무의미하다
        request.setAttribute("username", "홍길동");
        request.setAttribute("useraddress", "서울");

        // response_redirect URL로 리다이렉트시킨다
        response.sendRedirect("response_redirect");
    }
}
