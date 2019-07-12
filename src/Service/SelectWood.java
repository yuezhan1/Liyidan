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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SelectWood", urlPatterns = "/SelectWood")
public class SelectWood extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //        查询部分
        if(request.getParameter("id")!=null){
            try {
                int id=Integer.parseInt(request.getParameter("id"));
                WoodDao woodDao = new WoodDaoImp();
                ResultSet rs = woodDao.selectWood(id);
                Wood wood=new Wood();
                while(rs.next()){
                    wood.setId(rs.getInt("id"));
                    wood.setName(rs.getString("name"));
                    wood.setPrice(rs.getFloat("price"));
                    wood.setIntroce(rs.getString("introce"));
                    wood.setCount(rs.getInt("count"));
                    wood.setType(rs.getString("type"));
                }
                request.setAttribute("wood",wood);
                request.getRequestDispatcher("alterWood.jsp").forward(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        //        查询全部
        if(request.getParameter("id")==null||request.getParameter("type").equals("mall")){
            try {
                List<Wood> list = new ArrayList<>();
                WoodDao woodDao = new WoodDaoImp();
                ResultSet rs = woodDao.selectWood();
                while(rs.next()){
                    Wood wood=new Wood();
                    wood.setId(rs.getInt("id"));
                    wood.setName(rs.getString("name"));
                    wood.setPrice(rs.getFloat("price"));
                    wood.setIntroce(rs.getString("introce"));
                    wood.setCount(rs.getInt("count"));
                    wood.setType(rs.getString("type"));
                    list.add(wood);
                }
                request.setAttribute("list", list);
//                买家商品页面
                if(request.getParameter("type")!=null){
                    request.getRequestDispatcher("mall.jsp").forward(request, response);
                }
//                商家商品页面
                else {
                    request.getRequestDispatcher("selectWood.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
