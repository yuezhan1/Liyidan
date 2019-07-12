package DaoImp;

import Dao.WoodDao;
import entity.Wood;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WoodDaoImp implements WoodDao {
    Connection connection = DbUtil.getConnection();
    String sql;
    PreparedStatement ps;
    public WoodDaoImp() throws SQLException {

    }
    public void addWood(Wood wood) throws SQLException {
        sql="insert into wood(name,price,introce,count,type) values (?,?,?,?,?)";
        ps=connection.prepareStatement(sql);
        ps.setString(1,wood.getName());
        ps.setFloat(2,wood.getPrice());
        ps.setString(3,wood.getIntroce());
        ps.setInt(4,wood.getCount());
        ps.setString(5,wood.getType());
        ps.executeUpdate();
        connection.close();
    };
    public void deleteWood(int id) throws SQLException {
        sql="delete from wood where id=?";
        ps=connection.prepareStatement(sql);
        ps.setInt(1,id);
        ps.executeUpdate();
        connection.close();
    };
    public void updateWood(Wood wood) throws SQLException {
        sql="update wood set name=?,price=?,introce=?,count=?,type=?  where id=?";
        ps=connection.prepareStatement(sql);
        ps.setString(1,wood.getName());
        ps.setFloat(2,wood.getPrice());
        ps.setString(3,wood.getIntroce());
        ps.setInt(4,wood.getCount());
        ps.setString(5,wood.getType());
        ps.setInt(6,wood.getId());
        ps.executeUpdate();
        connection.close();
    };
    public ResultSet selectWood() throws SQLException {
        sql="select * from wood";
        ps=connection.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        connection.close();
        return rs;
    };
    public ResultSet selectWood(int id) throws SQLException {
        sql="select * from wood where id=?";
        ps=connection.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        connection.close();
        return rs;
    };
}
