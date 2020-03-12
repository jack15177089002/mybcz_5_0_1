package brut.util;

import java.io.DataInput;

public abstract class DataInputDelegate implements DataInput {
    protected final DataInput mDelegate;

    public DataInputDelegate(DataInput dataInput) {
        this.mDelegate = dataInput;
    }

    public int skipBytes(int i) {
        return this.mDelegate.skipBytes(i);
    }

    public int readUnsignedShort() {
        return this.mDelegate.readUnsignedShort();
    }

    public int readUnsignedByte() {
        return this.mDelegate.readUnsignedByte();
    }

    public String readUTF() {
        return this.mDelegate.readUTF();
    }

    public short readShort() {
        return this.mDelegate.readShort();
    }

    public long readLong() {
        return this.mDelegate.readLong();
    }

    public String readLine() {
        return this.mDelegate.readLine();
    }

    public int readInt() {
        return this.mDelegate.readInt();
    }

    public void readFully(byte[] bArr, int i, int i2) {
        this.mDelegate.readFully(bArr, i, i2);
    }

    public void readFully(byte[] bArr) {
        this.mDelegate.readFully(bArr);
    }

    public float readFloat() {
        return this.mDelegate.readFloat();
    }

    public double readDouble() {
        return this.mDelegate.readDouble();
    }

    public char readChar() {
        return this.mDelegate.readChar();
    }

    public byte readByte() {
        return this.mDelegate.readByte();
    }

    public boolean readBoolean() {
        return this.mDelegate.readBoolean();
    }
}
