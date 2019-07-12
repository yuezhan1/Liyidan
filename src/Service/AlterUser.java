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

@WebServlet(name = "AlterUser",urlPatterns="/alterUser")
public class AlterUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //获取这个用户
        if(request.getParameter("username")!=null){
            try {
                UserDao userDao =new UserDaoImp();
                ResultSet rs=userDao.selectUser(request.getParameter("username"));
                User user = new User();
                while(rs.next()){
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setSchoolName(rs.getString("SchoolName"));
                    user.setZhuanye(rs.getString("Zhuanye"));
                    String j=rs.getString("jishu");
                    String[] jishu = j.split(",");
                    user.setJishu(jishu);
                }
                request.setAttribute("user",user);
                request.getRequestDispatcher("alterUser.jsp").forward(request,response);
                //        进入修改页面,把这个用户传进去
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
//        从修改页面重新提交回来修改完的用户信息
        else{
            try {
                UserDao userDao =new UserDaoImp();
                String username = request.getParameter("user");
                String password=request.getParameter("password");
                String schoolName= request.getParameter("schoolName");
                String zhuanye =request.getParameter("zhuanye");
                String jishu =request.getParameter("jishu");
                userDao.alterUser(username,password,schoolName,zhuanye,jishu);
                response.sendRedirect("business.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
