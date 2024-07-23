package org.scoula.todo.context;

import lombok.Getter;
import lombok.Setter;
import org.scoula.todo.dao.TodoDao;
import org.scoula.todo.dao.UserDao;
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

//        map.put(UserVO.class, new UserDaoImpl());
//        map.put(TodoDao.class, new UserDaoImpl());
//        map.put(AccountService.class, new AccountService());
//        map.put(LoginService.class, new LoginService());
//        map.put(TodoService.class, new TodoService());
    }
    // 생성자 안에서 context를 이용한 다른 객체의 생성자 호출이 있기 때문에 아직 만들어지지 않은 context 객체가 null로 에러가 난다

    private static Context context = new Context();

    static {
        context.map.put(UserDao.class, new UserDaoImpl());
        context.map.put(TodoDao.class, new UserDaoImpl());
        context.map.put(AccountService.class, new AccountService());
        context.map.put(LoginService.class, new LoginService());
        context.map.put(TodoService.class, new TodoService());
    // dao와 service의 순서가 바뀌어도 마찬가지
    }

    public static Context getContext() {
        return context;
    }

    public static <T> T getBean(Class<T> clazz) {
        return (T) context.map.get(clazz);
    }
}
