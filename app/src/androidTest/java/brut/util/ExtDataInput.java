package brut.util;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExtDataInput extends DataInputDelegate {
    public ExtDataInput(InputStream inputStream) {
        this((DataInput) new DataInputStream(inputStream));
    }

    public ExtDataInput(DataInput dataInput) {
        super(dataInput);
    }

    public int[] readIntArray(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = readInt();
        }
        return iArr;
    }

    public void skipInt() {
        skipBytes(4);
    }

    public void skipCheckInt(int i) {
        int readInt = readInt();
        if (readInt != i) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", new Object[]{Integer.valueOf(i), Integer.valueOf(readInt)}));
        }
    }

    public void skipCheckShort(short s) {
        short readShort = readShort();
        if (readShort != s) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", new Object[]{Short.valueOf(s), Short.valueOf(readShort)}));
        }
    }

    public void skipCheckByte(byte b) {
        byte readByte = readByte();
        if (readByte != b) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", new Object[]{Byte.valueOf(b), Byte.valueOf(readByte)}));
        }
    }

    public String readNulEndedString(int i, boolean z) {
        int i2;
        StringBuilder sb = new StringBuilder(16);
        while (true) {
            i2 = i - 1;
            if (i != 0) {
                short readShort = readShort();
                if (readShort == 0) {
                    break;
                }
                sb.append((char) readShort);
                i = i2;
            } else {
                break;
            }
        }
        if (z) {
            skipBytes(i2 * 2);
        }
        return sb.toString();
    }
}
