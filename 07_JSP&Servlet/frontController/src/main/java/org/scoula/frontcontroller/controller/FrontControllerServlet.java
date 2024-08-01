package org.scoula.frontcontroller.controller;

import org.scoula.frontcontroller.DispatcherServlet;
import org.scoula.frontcontroller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// 경로 지정하는 방법은 두가지가 있다 1) 디렉토리 기반 2) 확장명 기반
// 디렉토리 기반(/board), 확장명 기반(*.do)
@WebServlet(name = "frontControllerServlet", value = "/")
public class FrontControllerServlet extends DispatcherServlet {
//    Map<String, Command> getMap; // GET 요청
//    Map<String, Command> postMap; // POST 요청
////  CLI에서의 menu의 역할을 함
//    String prefix = "/WEB-INF/views/";
//    String suffix = ".jsp";

    HomeController homeController = new HomeController();
    TodoController todoController = new TodoController();

    @Override
    protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap) {
        getMap.put("/", homeController::getIndex);

        getMap.put("/todo/list", todoController::getList);
        getMap.put("/todo/view", todoController::getView);
        getMap.put("/todo/create", todoController::getCreate);
        getMap.put("/todo/update", todoController::getUpdate);

        postMap.put("/todo/create", todoController::postCreate);
        postMap.put("/todo/update", todoController::postUpdate);
        postMap.put("/todo/delete", todoController::postDelete);
    }

//    public void init() {
//        Map은 인터페이스이므로 구현 클래스인 HashMap으로 객체 생성
//        getMap = new HashMap<>();
//        postMap = new HashMap<>();
//
//        getMap.put("/", homeController::getIndex);
//
//        getMap.put("/todo/list", todoController::getList);
//        getMap.put("/todo/view", todoController::getView);
//        getMap.put("/todo/create", todoController::getCreate);
//        getMap.put("/todo/update", todoController::getUpdate);
//
//        postMap.put("/todo/create", todoController::postCreate);
//        postMap.put("/todo/update", todoController::postUpdate);
//        postMap.put("/todo/delete", todoController::postDelete);
//    }
//
//    public void execute(Command command, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String viewName = command.execute(request, response);
//        if (viewName.startsWith("redirect:")) { // redirect 처 리
//            response.sendRedirect(viewName.substring("redirect:".length()));
//        } else { // forward 처리
//            String view = prefix + viewName + suffix;
//            RequestDispatcher dis = request.getRequestDispatcher(view);
//            dis.forward(request, response);
//        }
//    }
//
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Command command = getCommand(req);
//        if (command != null) {
//            execute(command, req, resp);
//        } else {
//            String view = prefix + "404" + suffix;
//            RequestDispatcher dis = req.getRequestDispatcher(view);
//            dis.forward(req, resp);
//        }
//    }
//
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
//
//    private String getCommandName(HttpServletRequest request) {
//        String requestURI = request.getRequestURI();
//        String contextPath = request.getContextPath();
//        return requestURI.substring(contextPath.length());
//    }
//
//    private Command getCommand(HttpServletRequest request) {
//        request에서 command 이름만 추출
//        String commandName = getCommandName(request);
//
//        Command command;
//        if (request.getMethod().equalsIgnoreCase("GET")) {
//            command = getMap.get(commandName);
//        } else {
//            command = postMap.get(commandName); // key가 없는 경우, 404 에러 발생 ~> 이 경우에는 Map에 없는 값을 get해오기 때문에 null 값 반환
//        }
//        return command;
//    }
}
