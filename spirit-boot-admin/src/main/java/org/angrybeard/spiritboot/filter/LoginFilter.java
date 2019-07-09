package org.angrybeard.spiritboot.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by angry_beary on 2019/7/3.
 */
@Slf4j
@WebFilter(urlPatterns = "/queryuser/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init LoginFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter LoginFilter");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String userName = req.getParameter("name");
        if (!"tom".equals(userName)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            return;
        }
    }

    @Override
    public void destroy() {
        log.info("destory LoginFilter");
    }
}
