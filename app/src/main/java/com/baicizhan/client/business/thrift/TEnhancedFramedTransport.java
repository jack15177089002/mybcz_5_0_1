//package com.baicizhan.client.business.thrift;
//
//import com.tencent.android.tpush.common.Constants;
//import org.p100a.p101a.TByteArrayOutputStream;
//import org.p100a.p101a.p107f.C2118d;
//import org.p100a.p101a.p107f.C2119f;
//import org.p100a.p101a.p107f.C2120g;
//import org.p100a.p101a.p107f.TTransportFactory;
//
//public class TEnhancedFramedTransport extends C2119f {
//    protected static final int DEFAULT_MAX_LENGTH = 16384000;
//    private final byte[] i32buf = new byte[4];
//    private int maxLength_;
//    private C2118d readBuffer_ = new C2118d(new byte[0]);
//    private C2119f transport_ = null;
//    private final TByteArrayOutputStream writeBuffer_ = new TByteArrayOutputStream(1024);
//
//    public class Factory extends TTransportFactory {
//        private int maxLength_;
//
//        public Factory() {
//            this.maxLength_ = TEnhancedFramedTransport.DEFAULT_MAX_LENGTH;
//        }
//
//        public Factory(int i) {
//            this.maxLength_ = i;
//        }
//
//        public C2119f getTransport(C2119f fVar) {
//            return new TEnhancedFramedTransport(fVar, this.maxLength_);
//        }
//    }
//
//    public TEnhancedFramedTransport(C2119f fVar, int i) {
//        this.transport_ = fVar;
//        this.maxLength_ = i;
//    }
//
//    public TEnhancedFramedTransport(C2119f fVar) {
//        this.transport_ = fVar;
//        this.maxLength_ = DEFAULT_MAX_LENGTH;
//    }
//
//    public void open() {
//        this.transport_.open();
//    }
//
//    public boolean isOpen() {
//        return this.transport_.isOpen();
//    }
//
//    public void close() {
//        this.transport_.close();
//    }
//
//    public int read(byte[] bArr, int i, int i2) {
//        if (this.readBuffer_ != null) {
//            int read = this.readBuffer_.read(bArr, i, i2);
//            if (read > 0) {
//                return read;
//            }
//        }
//        readFrame();
//        return this.readBuffer_.read(bArr, i, i2);
//    }
//
//    public byte[] getBuffer() {
//        return this.readBuffer_.getBuffer();
//    }
//
//    public int getBufferPosition() {
//        return this.readBuffer_.getBufferPosition();
//    }
//
//    public int getBytesRemainingInBuffer() {
//        return this.readBuffer_.getBytesRemainingInBuffer();
//    }
//
//    public void consumeBuffer(int i) {
//        this.readBuffer_.consumeBuffer(i);
//    }
//
//    private void readFrame() {
//        this.transport_.readAll(this.i32buf, 0, 4);
//        int decodeFrameSize = decodeFrameSize(this.i32buf);
//        if (decodeFrameSize < 0) {
//            throw new C2120g("Read a negative frame size (" + decodeFrameSize + ")!");
//        } else if (decodeFrameSize > this.maxLength_) {
//            throw new C2120g("Frame size (" + decodeFrameSize + ") larger than max length (" + this.maxLength_ + ")!");
//        } else {
//            byte[] bArr = new byte[decodeFrameSize];
//            this.transport_.readAll(bArr, 0, decodeFrameSize);
//            this.readBuffer_.mo18538a(bArr);
//        }
//    }
//
//    public void write(byte[] bArr, int i, int i2) {
//        this.writeBuffer_.write(bArr, i, i2);
//    }
//
//    public void flush() {
//        byte[] a = this.writeBuffer_.mo18554a();
//        int b = this.writeBuffer_.mo18555b();
//        this.writeBuffer_.reset();
//        encodeFrameSize(b, this.i32buf);
//        this.transport_.write(this.i32buf, 0, 4);
//        this.transport_.write(a, 0, b);
//        this.transport_.flush();
//    }
//
//    public static final void encodeFrameSize(int i, byte[] bArr) {
//        bArr[0] = (byte) ((i >> 24) & 255);
//        bArr[1] = (byte) ((i >> 16) & 255);
//        bArr[2] = (byte) ((i >> 8) & 255);
//        bArr[3] = (byte) (i & 255);
//    }
//
//    public static final int decodeFrameSize(byte[] bArr) {
//        return ((bArr[0] & Constants.NETWORK_TYPE_UNCONNECTED) << 24) | ((bArr[1] & Constants.NETWORK_TYPE_UNCONNECTED) << 16) | ((bArr[2] & Constants.NETWORK_TYPE_UNCONNECTED) << 8) | (bArr[3] & Constants.NETWORK_TYPE_UNCONNECTED);
//    }
//
//    public C2119f getInnerTransport() {
//        return this.transport_;
//    }
//}
