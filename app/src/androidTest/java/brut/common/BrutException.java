package brut.common;

public class BrutException extends Exception {
    public BrutException(Throwable th) {
        super(th);
    }

    public BrutException(String str, Throwable th) {
        super(str, th);
    }

    public BrutException(String str) {
        super(str);
    }

    public BrutException() {
    }
}
