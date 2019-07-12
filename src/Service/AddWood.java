package Service;

import Dao.WoodDao;
import DaoImp.WoodDaoImp;
import entity.Wood;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddWood", urlPatterns = "/AddWood")
public class AddWood extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            String name = request.getParameter("name");
            float price = Float.parseFloat(request.getParameter("price"));
            String introce = request.getParameter("introce");
            int count = Integer.parseInt(request.getParameter("count"));
            String type = request.getParameter("type");
            Wood wood = new Wood(name,price,introce,count,type);
            WoodDao woodDao =  new WoodDaoImp();
            woodDao.addWood(wood);
            response.sendRedirect("business.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
