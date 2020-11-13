package Chapter11;

import java.io.*;
import java.net.*;

public class TCPServer {
    private ServerSocket serverSocket = null;

    public TCPServer(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void accept() {
        try {
            Socket client = serverSocket.accept();
            OutputStream outputStream = client.getOutputStream();
            outputStream.write(("Hello World").getBytes());
            outputStream.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
