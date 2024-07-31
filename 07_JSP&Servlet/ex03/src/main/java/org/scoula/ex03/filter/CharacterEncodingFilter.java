package org.scoula.ex03.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class CharacterEncodingFilter implements Filter {

    // 필터 초기화 메소드, 필터가 생성될 때 호출된다.
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        Filter.super.init(fConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        // 다음 필터나 서블릿으로 요청과 응답 전달
        chain.doFilter(request, response);
    }

    // 필터 소멸 메소드, 필터가 소멸될 때 호출된다. 자원 해제 작업 수행
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
