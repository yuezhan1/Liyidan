package Dao;

import entity.Cart;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CartDao {
    void buyWood(Cart cart)throws SQLException;
    ResultSet  existence(int id)throws SQLException;
    void alertWood(int id,int count)throws SQLException;
    ResultSet selectCart()throws SQLException;
    int getCount(int id)throws SQLException;
}
