package org.scoula.ex04.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cart_view")
public class CartViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("장바구니 리스트");

        // 현재 세션을 가져오기 + false : 세션이 없으면 새로 생성하진 않겠다
        HttpSession session = request.getSession(false);
        // 20초 동안만 세션을 활성화시키겠다
        session.setMaxInactiveInterval(20);

        if(session != null) {
        // 세션이 존재하는 경우
            ArrayList<String> list = (ArrayList<String>) session.getAttribute("product");
        // product에 저장된 상품들을 모두 출력
            out.print("상품: " + list + "<br>");
        } else{
        // 세션이 존재하지 않는 경우
            out.print("세션 없음" + "<br>");
        }
        out.print("<a href='session_product.jsp'>상품 선택 페이지</a><br>");
        out.print("<a href='cart_delete'>장바구니 비우기</a><br>");
        out.print("</body></html>");
    }
}
