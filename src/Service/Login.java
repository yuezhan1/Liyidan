package Service;

import Dao.UserDao;
import DaoImp.UserDaoImp;
import util.DbUtil;
import com.mysql.jdbc.PreparedStatement;
import util.DbcpUtil;


import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/login")
public class Login extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            System.out.println(DbcpUtil.getConnection().toString());
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserDao userDao=new UserDaoImp();
            ResultSet rs = userDao.selectUser(username, password);
            if (!rs.next()) {
                    request.setAttribute("code", "账号或密码错误");
                    RequestDispatcher rdp = request.getRequestDispatcher("index.jsp");
                    rdp.forward(request, response);
            } else {
                if(request.getParameter("free")!=null){
                    Cookie usernameCookie = new Cookie("username", username);
                    usernameCookie.setMaxAge(60 * 60 * 24 * 7 );
                    response.addCookie(usernameCookie);
                }
                else{
                    request.getSession().setAttribute("username", username);
                }
//                Cookie cookie1 = new Cookie("username",username);
//                cookie1.setMaxAge(60*60*24*7);
//                cookie1.setPath("/");
//                cookie1.setDomain("localhost");
//                response.addCookie(cookie1);
                response.sendRedirect("/count");
            }
        } catch (
                SQLException e1) {
            e1.printStackTrace();
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
