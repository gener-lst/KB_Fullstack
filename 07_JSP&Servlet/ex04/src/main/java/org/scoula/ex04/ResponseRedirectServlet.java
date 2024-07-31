package org.scoula.ex04;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/response_redirect")
public class ResponseRedirectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청이 달라졌기 때문에 해당 값들은 null이 나온다. 이전 서블릿의 속성은 세션으로 저장해줘야한다.
        String username = (String) request.getSession().getAttribute("username");
        String useraddress = (String) request.getSession().getAttribute("useraddress");

        request.setAttribute("username", username);
        request.setAttribute("useraddress", useraddress);

        // redirect(상대 경로)
        RequestDispatcher dis = request.getRequestDispatcher("/redirect_response.jsp");
        dis.forward(request, response);
    }
}
