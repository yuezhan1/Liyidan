package Service;

import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Preference1")
public class Preference1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User p=new User();
        p.setUsername((String) request.getSession().getAttribute("username"));
        p.setSchoolName(request.getParameter("schoolName"));
        p.setZhuanye(request.getParameter("zhuanye"));
        request.getSession().setAttribute("p",p);
        request.getRequestDispatcher("preference2.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
