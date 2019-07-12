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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SelectAllUser",urlPatterns = "/selectAllUser")
public class SelectAllUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<User> list = new ArrayList<>();
            UserDao userDao = new UserDaoImp();
            ResultSet rs = userDao.selectAllUser();
            while(rs.next()){
                User p= new User();
                p.setUsername(rs.getString("username"));
                p.setSchoolName(rs.getString("schoolName"));
                p.setZhuanye(rs.getString("zhuanye"));
                String j=rs.getString("jishu");
                String[] jishu = j.split(",");
                p.setJishu(jishu);
                list.add(p);
            }
            request.setAttribute("list",list);
            request.getRequestDispatcher("selectAllUser.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
