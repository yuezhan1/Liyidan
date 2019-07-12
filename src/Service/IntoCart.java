package Service;

import Dao.CartDao;
import DaoImp.CartDaoImp;
import entity.Cart;
import entity.Wood;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpCookie;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "IntoCart", urlPatterns = "/IntoCart")
public class IntoCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Cookie[] cookies = request.getCookies();
        String username = null;
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String introce = request.getParameter("introce");
        int buyCount = Integer.parseInt(request.getParameter("buyCount"));
        String type = request.getParameter("type");
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                username = cookie.getValue();
            }
        }
        if(request.getSession().getAttribute("username")!=null){
            username=(String) request.getSession().getAttribute("username");
        }
//        临时购物车
        if (username == null) {
            Object woodObject = request.getSession().getAttribute("woodList");
            List<Wood> woodList = null;
            Wood wood = new Wood(id, name, price, introce, buyCount, type);
            if (woodObject == null) {
                woodList = new ArrayList<>();
                woodList.add(wood);
            } else {
                woodList = (ArrayList<Wood>) woodObject;
                woodList.add(wood);
            }
            request.getSession().setAttribute("woodList", woodList);
            response.sendRedirect("/SelectWood?type=mall");

        }
//        个人购物车
        else {
            try {
                CartDao cartDao = new CartDaoImp();
                Cart cart=new Cart(id,name,price,introce,buyCount,type,username);
                ResultSet rs = cartDao.existence(id);
//                购物车中已经存在，修改购物项
                if(rs.next()){
                    int c=0;
                    c=cartDao.getCount(cart.getId());
                    cartDao.alertWood(cart.getId(),cart.getBuyCount()+c);
                }
//                购物车中不存在，新建购物项
                else {
                    cartDao.buyWood(cart);
                }
                response.sendRedirect("/SelectWood?type=mall");
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
