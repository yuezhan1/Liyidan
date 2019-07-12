package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDao {
     ResultSet selectUser(String username, String password) throws SQLException;
     int UpdateUser(String username,String schoolName,String zhuanye, String[] jiShu) throws SQLException;
     ResultSet selectAllUser()throws SQLException;
     ResultSet selectUser(String username)throws SQLException;
     void alterUser(String username,String password,String schoolName,String zhuanye,String jishu) throws SQLException;

}
