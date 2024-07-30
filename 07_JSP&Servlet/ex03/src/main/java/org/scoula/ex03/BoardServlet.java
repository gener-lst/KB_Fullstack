package org.scoula.ex03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

//        받아온 파라미터들의 이름만을 열거자로 만듬
        Enumeration<String> enu = request.getParameterNames();

//        hasMoreElements : 요소가 더 있는지 체크해서 없을때까지 돈다
        while (enu.hasMoreElements()) {
//            nextElement : 열거자를 돌면서 다음 요소를 가져옴
            String name = enu.nextElement();
//            열거자에 저장된 이름으로 해당 값들을 가져옴
            String value = request.getParameter(name);
//            hidden이었던 action 값도 출력된다
            out.println(name + " : " + value + "<br>");
        }
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
