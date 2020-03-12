package p012ch.qos.logback.core.recovery;

import java.io.OutputStream;
import p012ch.qos.logback.core.net.SyslogOutputStream;

/* renamed from: ch.qos.logback.core.recovery.ResilientSyslogOutputStream */
public class ResilientSyslogOutputStream extends ResilientOutputStreamBase {
    int port;
    String syslogHost;

    public ResilientSyslogOutputStream(String str, int i) {
        this.syslogHost = str;
        this.port = i;
        this.f1667os = new SyslogOutputStream(str, i);
        this.presumedClean = true;
    }

    /* access modifiers changed from: 0000 */
    public String getDescription() {
        return "syslog [" + this.syslogHost + ":" + this.port + "]";
    }

    /* access modifiers changed from: 0000 */
    public OutputStream openNewOutputStream() {
        return new SyslogOutputStream(this.syslogHost, this.port);
    }

    public String toString() {
        return "c.q.l.c.recovery.ResilientSyslogOutputStream@" + System.identityHashCode(this);
    }
}
