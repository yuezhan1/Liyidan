package util;


import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class DbUtil {
    private static String username="root";
    private static String password="980924";
    private static String url="jdbc:mysql://localhost:3306/shop";
    private static String driverName="com.mysql.jdbc.Driver";
    private static LinkedList<Connection> pool = new LinkedList<>();
    static {
        try {
            Class.forName(driverName);
            for(int i=0;i<10;i++){
                Connection con=DriverManager.getConnection(url,username,password);
                ArrayList<Class<?>> classlist = new ArrayList<>();
                classlist.add(Connection.class);
                classlist.addAll(Arrays.asList(con.getClass().getInterfaces()));
                Class<?>[] classArray=new Class<?>[classlist.size()];
                Connection poolcon= (Connection) Proxy.newProxyInstance(con.getClass().getClassLoader(),classlist.toArray(classArray),new PoolInvercation(con));
                pool.add(poolcon);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()  {
        if(pool!=null&&pool.size()>0){
            Connection con =  pool.getFirst();
            pool.removeFirst();
            return con;
        }
        return null;
    }
    public static void close(Connection con) {
        pool.addLast(con);
    }
}
