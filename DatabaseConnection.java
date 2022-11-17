import javax.xml.transform.Result;
import java.sql.*;

public class DatabaseConnection {
    /**
     * 要连接的数据库、数据库账号、密码
     */
    //连接本地数据库
    public static final String URL = "jdbc:mysql://localhost:3306/test01?useSSL=false";
    // 连接服务器数据库
//    public static final String URL = "jdbc:mysql://134.175.88.185:3306/aikq?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8";

    //本地数据库账号
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    //服务器数据库账号
//    public static final String USER = "sac";
//    public static final String PASSWORD = "123456";


    private static Connection connection = null;

    //静态代码块只在类第一次被加载时执行一次
    static {
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库连接
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return 返回数据库连接
     */
    public static Connection getConnection() {
        return connection;
    }
}