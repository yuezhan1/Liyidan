package Service;

import Dao.UserDao;
import DaoImp.UserDaoImp;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/Preference2")
public class Preference2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User p=(User) request.getSession().getAttribute("p");
        p.setJishu(request.getParameterValues("jishu"));
        request.getSession().setAttribute("p",p);
        try {
            UserDao UserDao = new UserDaoImp();
            int code= UserDao.UpdateUser(p.getUsername(),p.getSchoolName(),p.getZhuanye(),p.getJishu());
            if(code==0){

            }
            else{
                request.getRequestDispatcher("succeed.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
