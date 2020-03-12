//package com.p045c.p046a;
//
//import com.tencent.android.tpush.common.Constants;
//import java.io.DataInput;
//import java.io.DataInputStream;
//import java.io.InputStream;
//
///* renamed from: com.c.a.a */
//public final class LEDataInputStream implements DataInput {
//
//    /* renamed from: a */
//    protected final DataInputStream f3434a;
//
//    /* renamed from: b */
//    protected final InputStream f3435b;
//
//    /* renamed from: c */
//    protected final byte[] f3436c = new byte[8];
//
//    public LEDataInputStream(InputStream inputStream) {
//        this.f3435b = inputStream;
//        this.f3434a = new DataInputStream(inputStream);
//    }
//
//    public final boolean readBoolean() {
//        return this.f3434a.readBoolean();
//    }
//
//    public final byte readByte() {
//        return this.f3434a.readByte();
//    }
//
//    public final char readChar() {
//        this.f3434a.readFully(this.f3436c, 0, 2);
//        return (char) (((this.f3436c[1] & Constants.NETWORK_TYPE_UNCONNECTED) << 8) | (this.f3436c[0] & Constants.NETWORK_TYPE_UNCONNECTED));
//    }
//
//    public final double readDouble() {
//        return Double.longBitsToDouble(readLong());
//    }
//
//    public final float readFloat() {
//        return Float.intBitsToFloat(readInt());
//    }
//
//    public final void readFully(byte[] bArr) {
//        this.f3434a.readFully(bArr, 0, bArr.length);
//    }
//
//    public final void readFully(byte[] bArr, int i, int i2) {
//        this.f3434a.readFully(bArr, i, i2);
//    }
//
//    public final int readInt() {
//        this.f3434a.readFully(this.f3436c, 0, 4);
//        return (this.f3436c[3] << 24) | ((this.f3436c[2] & Constants.NETWORK_TYPE_UNCONNECTED) << 16) | ((this.f3436c[1] & Constants.NETWORK_TYPE_UNCONNECTED) << 8) | (this.f3436c[0] & Constants.NETWORK_TYPE_UNCONNECTED);
//    }
//
//    public final String readLine() {
//        return this.f3434a.readLine();
//    }
//
//    public final long readLong() {
//        this.f3434a.readFully(this.f3436c, 0, 8);
//        return (((long) this.f3436c[7]) << 56) | (((long) (this.f3436c[6] & Constants.NETWORK_TYPE_UNCONNECTED)) << 48) | (((long) (this.f3436c[5] & Constants.NETWORK_TYPE_UNCONNECTED)) << 40) | (((long) (this.f3436c[4] & Constants.NETWORK_TYPE_UNCONNECTED)) << 32) | (((long) (this.f3436c[3] & Constants.NETWORK_TYPE_UNCONNECTED)) << 24) | (((long) (this.f3436c[2] & Constants.NETWORK_TYPE_UNCONNECTED)) << 16) | (((long) (this.f3436c[1] & Constants.NETWORK_TYPE_UNCONNECTED)) << 8) | ((long) (this.f3436c[0] & Constants.NETWORK_TYPE_UNCONNECTED));
//    }
//
//    public final short readShort() {
//        this.f3434a.readFully(this.f3436c, 0, 2);
//        return (short) (((this.f3436c[1] & Constants.NETWORK_TYPE_UNCONNECTED) << 8) | (this.f3436c[0] & Constants.NETWORK_TYPE_UNCONNECTED));
//    }
//
//    public final String readUTF() {
//        return this.f3434a.readUTF();
//    }
//
//    public final int readUnsignedByte() {
//        return this.f3434a.readUnsignedByte();
//    }
//
//    public final int readUnsignedShort() {
//        this.f3434a.readFully(this.f3436c, 0, 2);
//        return ((this.f3436c[1] & Constants.NETWORK_TYPE_UNCONNECTED) << 8) | (this.f3436c[0] & Constants.NETWORK_TYPE_UNCONNECTED);
//    }
//
//    public final int skipBytes(int i) {
//        return this.f3434a.skipBytes(i);
//    }
//}
