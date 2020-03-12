package p012ch.qos.logback.core.joran.spi;

import java.io.OutputStream;

@Deprecated
/* renamed from: ch.qos.logback.core.joran.spi.ConsoleTarget */
public enum ConsoleTarget {
    SystemOut("System.out", new OutputStream() {
        public void write(int i) {
            System.out.write(i);
        }

        public void write(byte[] bArr) {
            System.out.write(bArr);
        }

        public void write(byte[] bArr, int i, int i2) {
            System.out.write(bArr, i, i2);
        }

        public void flush() {
            System.out.flush();
        }
    }),
    SystemErr("System.err", new OutputStream() {
        public void write(int i) {
            System.err.write(i);
        }

        public void write(byte[] bArr) {
            System.err.write(bArr);
        }

        public void write(byte[] bArr, int i, int i2) {
            System.err.write(bArr, i, i2);
        }

        public void flush() {
            System.err.flush();
        }
    });
    
    private final String name;
    private final OutputStream stream;

    public static ConsoleTarget findByName(String str) {
        ConsoleTarget[] values;
        for (ConsoleTarget consoleTarget : values()) {
            if (consoleTarget.name.equalsIgnoreCase(str)) {
                return consoleTarget;
            }
        }
        return null;
    }

    private ConsoleTarget(String str, OutputStream outputStream) {
        this.name = str;
        this.stream = outputStream;
    }

    public final String getName() {
        return this.name;
    }

    public final OutputStream getStream() {
        return this.stream;
    }
}
