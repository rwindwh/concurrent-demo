package cn.edu.cqvie.web.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/myServlet")
public class MyServlet extends GenericServlet {

    private int i;

    @Override
    public void service(ServletRequest req, ServletResponse res) {
        i++;
    }
}
