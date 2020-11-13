package Chapter11;

import java.io.IOException;
import java.util.Scanner;

public class exercise14 {
    public static void main(String[] args) {
        try {
            // 初始化
            UDPSender sender;
            UDPReceiver receiver;
            sender = new UDPSender(15122);
            receiver = new UDPReceiver(15123);

            // 新建服务器线程
            Thread server = new Thread(() -> {
                try {
                    receiver.receive();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            server.start();

            // 新建客户端线程
            Thread client = new Thread(() -> {
                Scanner in = new Scanner(System.in);
                try {
                    while (true) {
                        System.out.println("请输入要发送的内容（输入 # 终止）：");
                        String content = in.nextLine();     // 读入输入内容
                        if (content.equals("#")) {          // 终止
                            receiver.close();
                            sender.close();
                            System.exit(0);
                        }
                        sender.sendContent(content, 15123);
                        try {
                            Thread.sleep(100);      // 延时避免输出信息错位
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            client.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
