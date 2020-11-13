package Chapter11;

public class exercise15 {
    public static void main(String[] args) {
        // 服务器线程
        Thread server = new Thread(() -> new TCPServer(8002).accept());
        server.start();

        // 客户端线程
        Thread client = new Thread(() -> new TCPClient("127.0.0.1", 8002).getResponse());
        client.start();
    }
}
