package org.scoula.ex05;

import org.scoula.ex05.domain.Member;
import org.scoula.ex05.dto.LoginDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 요청에서 파라미터 얻기
        String userid = req.getParameter("userid");
        String passwd = req.getParameter("passwd");

        LoginDTO loginDTO = new LoginDTO(userid, passwd);

        // 위에서 만들어진 변수 정보를 request 내에 세팅한다
        req.setAttribute("userid", userid);
        req.setAttribute("passwd", passwd);

        req.setAttribute("login", loginDTO);

        HttpSession session = req.getSession();
        Member member = new Member("홍길동", userid);
        session.setAttribute("user", member);

        // 포워딩(설정한 request를 login.jsp 화면으로 보내줌) -> 이 절차가 없으면 request는 아무 의미가 없음
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        GET 메소드와 동일한 로직을 처리하고 싶으므로 doGet 재호출
        resp.setContentType("text/html;charset=UTF-8");
//        POST 메소드의 경우 기본값 인코딩은 한글이 깨지므로 UTF-8 변경 필수!
        doGet(req, resp);
    }
}