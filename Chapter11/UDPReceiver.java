package Chapter11;

import java.io.*;
import java.net.*;

public class UDPReceiver {
    private final DatagramSocket receiver;
    private final DatagramPacket content;
    private final byte[] buf = new byte[1024];

    public UDPReceiver(int port) throws Exception {
        this.receiver = new DatagramSocket(port);
        this.content = new DatagramPacket(buf, buf.length);
    }

    public String getData() {
        return new String(this.content.getData(), 0, this.content.getLength());
    }

    public void receive() throws IOException {
        while (true) {
            System.out.println("Server Listening...");
            this.receiver.receive(this.content);
            System.out.println(this.content.getAddress().toString() + ":" + this.content.getPort() + " says " + getData());
        }
    }

    public void close() {
        this.receiver.close();
    }
}
