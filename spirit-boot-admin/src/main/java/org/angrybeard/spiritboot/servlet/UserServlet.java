package org.angrybeard.spiritboot.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by angry_beary on 2019/7/3.
 */
@Slf4j
@WebServlet(name = "userServlet", urlPatterns = "/vip/*")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("run custom Servlet");
        super.doGet(req, resp);
    }
}
