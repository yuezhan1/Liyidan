package DaoImp;

import Dao.UserDao;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImp implements UserDao {
    public UserDaoImp() throws SQLException {
    }

    public  ResultSet selectUser(String username, String password) throws SQLException {
        Connection connection= DbUtil.getConnection();
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement("select * from user where username=? and password=?");
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs=  ps.executeQuery();
        connection.close();
        return rs;
    }
    public int UpdateUser(String username,String schoolName,String zhuanye, String[] jiShu) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String jishu =String.join(",",jiShu);
        PreparedStatement ps = connection.prepareStatement("update user set schoolName=?,zhuanye=?,jishu=? where username=? ");
        ps.setString(1,schoolName);
        ps.setString(2,zhuanye);
        ps.setString(3,jishu);
        ps.setString(4,username);
        int rs=ps.executeUpdate();
        connection.close();
        return rs;
    }
    public ResultSet selectAllUser() throws SQLException {
        Connection connection= DbUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from user ");
        ResultSet rs=  ps.executeQuery();
        connection.close();
        return rs;
    }
    public ResultSet selectUser(String username) throws SQLException {
        Connection connection= DbUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from user where username=? ");
        ps.setString(1,username);
        ResultSet rs=  ps.executeQuery();
        connection.close();
        return rs;
    }
    public void alterUser(String username,String password,String schoolName,String zhuanye,String jishu) throws SQLException{
        Connection connection = DbUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement("update user set password=?, schoolName=?,zhuanye=?,jishu=? where username=? ");
        ps.setString(1,password);
        ps.setString(2,schoolName);
        ps.setString(3,zhuanye);
        ps.setString(4,jishu);
        ps.setString(5,username);
        System.out.println(username);
        ps.executeUpdate();
        connection.close();
    }

}
