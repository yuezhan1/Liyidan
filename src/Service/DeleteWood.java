package Service;

import Dao.WoodDao;
import DaoImp.WoodDaoImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteWood" ,urlPatterns = "/DeleteWood")
public class DeleteWood extends  HttpServlet {

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id =Integer.parseInt(request.getParameter("id"));
            try {
                WoodDao woodDao=new WoodDaoImp();
                woodDao.deleteWood(id);
                response.sendRedirect("business.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
        }
    }
