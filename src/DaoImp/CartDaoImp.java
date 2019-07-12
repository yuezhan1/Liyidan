package DaoImp;

import Dao.CartDao;
import entity.Cart;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CartDaoImp implements CartDao {
    Connection connection = DbUtil.getConnection();
    String sql;
    PreparedStatement ps;

    public CartDaoImp() throws SQLException {
    }

    public void buyWood(Cart cart) throws SQLException {
        sql="insert into cart(id,name,price,introce,count,type,username,time) values (?,?,?,?,?,?,?,?)";
        java.sql.Date time= new java.sql.Date(new Date().getTime());
        ps=connection.prepareStatement(sql);
        ps.setInt(1,cart.getId());
        ps.setString(2,cart.getName());
        ps.setFloat(3,cart.getPrice());
        ps.setString(4,cart.getIntroce());
        ps.setInt(5,cart.getBuyCount());
        ps.setString(6,cart.getType());
        ps.setString(7,cart.getUsername());
        ps.setDate(8, time);
        ps.executeUpdate();
        connection.close();
    }
    public ResultSet existence(int id) throws SQLException {
        sql="select * from cart where id=?";
        ps=connection.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs= ps.executeQuery();
        connection.close();
        return rs;
    }
    public void alertWood(int id,int count)throws SQLException{
        sql="update cart     set count=? where id=?";
        ps=connection.prepareStatement(sql);
        ps.setInt(1,count);
        ps.setInt(2,id);
        ps.executeUpdate();
        connection.close();
    }
    public ResultSet selectCart()throws SQLException{
        sql="select * from cart";
        ps=connection.prepareStatement(sql);
        return ps.executeQuery();
    }
    public int getCount(int id)throws SQLException{
        sql="select count from cart where id=?";
        ps=connection.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        connection.close();
        return count;
    }
}
