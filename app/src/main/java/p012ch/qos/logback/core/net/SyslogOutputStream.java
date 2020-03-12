package p012ch.qos.logback.core.net;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* renamed from: ch.qos.logback.core.net.SyslogOutputStream */
public class SyslogOutputStream extends OutputStream {
    private static final int MAX_LEN = 1024;
    private InetAddress address;
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();

    /* renamed from: ds */
    private DatagramSocket f1664ds;
    private final int port;

    public SyslogOutputStream(String str, int i) {
        this.address = InetAddress.getByName(str);
        this.port = i;
        this.f1664ds = new DatagramSocket();
    }

    public void write(byte[] bArr, int i, int i2) {
        this.baos.write(bArr, i, i2);
    }

    public void flush() {
        byte[] byteArray = this.baos.toByteArray();
        DatagramPacket datagramPacket = new DatagramPacket(byteArray, byteArray.length, this.address, this.port);
        if (this.baos.size() > 1024) {
            this.baos = new ByteArrayOutputStream();
        } else {
            this.baos.reset();
        }
        if (byteArray.length != 0 && this.f1664ds != null) {
            this.f1664ds.send(datagramPacket);
        }
    }

    public void close() {
        this.address = null;
        this.f1664ds = null;
    }

    public int getPort() {
        return this.port;
    }

    public void write(int i) {
        this.baos.write(i);
    }

    /* access modifiers changed from: 0000 */
    public int getSendBufferSize() {
        return this.f1664ds.getSendBufferSize();
    }
}
