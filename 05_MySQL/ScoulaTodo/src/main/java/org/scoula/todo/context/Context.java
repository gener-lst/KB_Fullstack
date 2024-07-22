package org.scoula.todo.context;

import lombok.Getter;
import lombok.Setter;
import org.scoula.todo.dao.TodoDao;
import org.scoula.todo.dao.UserDaoImpl;
import org.scoula.todo.domain.UserVO;
import org.scoula.todo.service.AccountService;
import org.scoula.todo.service.LoginService;
import org.scoula.todo.service.TodoService;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Context {
    private UserVO user; // 로그인 사용자 정보, null이면 로그아웃 상태
    private Map<Class, Object> map;

    private Context() {
        map = new HashMap<>();

        map.put(UserVO.class, new UserDaoImpl());
        map.put(TodoDao.class, new UserDaoImpl());
        map.put(AccountService.class, new AccountService());
        map.put(LoginService.class, new LoginService());
        map.put(TodoService.class, new TodoService());
    }

    private static Context context = new Context();

    public static Context getContext() {
        return context;
    }

    public static <T> T getBean(Class<T> clazz) {
        return (T) context.map.get(clazz);
    }
}
