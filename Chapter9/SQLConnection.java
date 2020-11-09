package Chapter9;

import java.sql.*;

public class SQLConnection {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    // 加载驱动
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Class.forName("com.mysql.jdbc.Driver");  // 旧驱动
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SQLConnection(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);     // 连接数据库
            this.statement = connection.createStatement();    // 获取 Statement 对象

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void traverseTable(String sql) {
        try {   // 执行查询遍历
            this.resultSet = this.statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("  ID  |   姓名  |   性别  |         邮箱        |        生日        ");
        try {
            while (resultSet.next()) {
                String id = String.valueOf(resultSet.getInt("id"));
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                String email = resultSet.getString("email");
                String birthday = resultSet.getString("birthday");
                System.out.printf("%6s|%8s|%8s|%20s|%20s\n", id, name, sex, email, birthday);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 插入、修改、删除操作
    public int executeUpdate(String sql) {
        int result = 0;
        try {
            result = this.statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // 查询操作
    public ResultSet executeQuery(String sql) {
        ResultSet resultSet = null;
        try {
            resultSet = this.statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void closeConnections() {
        try {   // 关闭链接
            if (this.connection != null)
                this.connection.close();
            if (this.statement != null)
                this.statement.close();
            if (this.resultSet != null)
                this.resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
