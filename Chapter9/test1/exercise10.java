package Chapter9.test1;

import Chapter9.SQLConnection;
import java.util.*;

public class exercise10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入数据库地址（IP:端口）：");
        String ip = in.nextLine();
        System.out.print("请输入数据库名：");
        String db = in.nextLine();
        System.out.print("请输入用户名：");
        String user = in.nextLine();
        System.out.print("请输入密码：");
        String password = in.nextLine();

        SQLConnection connection = new SQLConnection("jdbc:mysql://" + ip + "/" + db, user, password);
        connection.traverseTable("select * from tb_user");
        connection.closeConnections();
    }
}
