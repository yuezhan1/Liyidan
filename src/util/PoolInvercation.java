package util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

public class PoolInvercation implements InvocationHandler {
    private Connection con;
    public PoolInvercation(Connection con){
        this.con=con;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("close")){
            System.out.println("调用close");
            DbUtil.close(con);
        }
        else{
            System.out.println("调用其他方法");
            return method.invoke(con,args);
        }
        return null;
    }
}
