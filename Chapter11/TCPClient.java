package Chapter11;

import java.io.*;
import java.net.*;

public class TCPClient {
    private Socket client = null;

    public TCPClient(String host, int port) {
        try {
            this.client = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getResponse() {
        try {
            InputStream inputStream = this.client.getInputStream();
            byte[] buf = new byte[1024];
            int length = inputStream.read(buf);
            if (length != -1)
                System.out.println("[SERVER] " + new String(buf, 0, length));
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
