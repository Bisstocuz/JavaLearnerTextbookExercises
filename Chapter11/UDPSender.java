package Chapter11;

import java.io.*;
import java.net.*;

public class UDPSender {
    private final DatagramSocket sender;
    private DatagramPacket content;

    public UDPSender(int srcPort) throws Exception {
        this.sender = new DatagramSocket(srcPort);

    }

    public void sendContent(String content, int destPort) throws IOException {
        byte[] buf = content.getBytes();
        this.content = new DatagramPacket(buf, buf.length, InetAddress.getByAddress(new byte[]{127, 0, 0, 1}), destPort);
        this.content.setLength(buf.length);
        this.sender.send(this.content);
    }

    public void close() {
        this.sender.close();
    }
}
