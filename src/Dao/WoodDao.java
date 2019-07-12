package Dao;

import entity.Wood;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface WoodDao {
    void addWood(Wood wood) throws SQLException;
    void deleteWood(int i) throws SQLException;
    void updateWood(Wood wood) throws SQLException;
    ResultSet selectWood() throws SQLException;
    ResultSet selectWood(int id) throws SQLException;
}
