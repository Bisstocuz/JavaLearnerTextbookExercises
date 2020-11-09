package Chapter9.test2;

import Chapter9.SQLConnection;
import java.sql.*;
import java.util.*;

class SQLBank {
    private SQLConnection connection;

    SQLBank() {
        this.connection = null;
    }

    public void setConnection() {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入数据库地址（IP:端口）：");
        String ip = in.nextLine();
        System.out.print("请输入数据库名：");
        String db = in.nextLine();
        System.out.print("请输入用户名：");
        String user = in.nextLine();
        System.out.print("请输入密码：");
        String password = in.nextLine();

        this.connection = new SQLConnection("jdbc:mysql://" + ip + "/" + db, user, password);
    }

    // 添加用户
    public void addAccount() {
        if (this.connection == null)
            System.out.println("Please set connection at first.");
        else {
            Scanner in = new Scanner(System.in);
            System.out.print("请输入姓名（#取消）：");
            String name = in.nextLine();
            if (name.equals("#"))
                return;
            System.out.print("请输入余额：");
            int money = in.nextInt();

            this.connection.executeUpdate("insert into tb_count (name,money) values ('" + name + "'," + money + ");");
        }
    }

    // 查询遍历
    public void traverseTable() {
        ResultSet resultSet = this.connection.executeQuery("select * from tb_count");
        try {
            while (resultSet.next()) {
                System.out.println("id=" + resultSet.getInt("id") + "|name=" +
                        resultSet.getString("name") + "|money=" +
                        resultSet.getInt("money"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 转账
    public void pay() {
        Scanner in = new Scanner(System.in);
        System.out.print("转出者ID：");
        int fromId = in.nextInt();
        System.out.print("转入者ID：");
        int toId = in.nextInt();
        System.out.print("金额：");
        int money = in.nextInt();
        this.connection.executeUpdate("update tb_count set money=money-" + money + " where id=" + fromId);
        this.connection.executeUpdate("update tb_count set money=money+" + money + " where id=" + toId);
    }

    public void close() {
        this.connection.closeConnections();
    }
}

public class exercise11 {
    public static void main(String[] args) {
        SQLBank bank = new SQLBank();
        bank.setConnection();
        bank.addAccount();
        bank.addAccount();
        bank.traverseTable();
        bank.pay();
        bank.traverseTable();
        bank.close();
    }
}
