package Service;

import Dao.CartDao;
import DaoImp.CartDaoImp;
import entity.Cart;

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

@WebServlet(name = "selectCart",urlPatterns = "/selectCart")
public class selectCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CartDao cartDao=new CartDaoImp();
            ResultSet rs= cartDao.selectCart();
            List<Cart> list=new ArrayList<>();
            while(rs.next()){
                Cart cart = new Cart();
                cart.setId(rs.getInt("id"));
                cart.setName(rs.getString("name"));
                cart.setPrice(rs.getFloat("price"));
                cart.setIntroce(rs.getString("introce"));
                cart.setType(rs.getString("type"));
                cart.setBuyCount(rs.getInt("count"));
                cart.setUsername(rs.getString("username"));
                cart.setTime(rs.getDate("time"));
                list.add(cart);
            }
            request.setAttribute("cartList",list);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
