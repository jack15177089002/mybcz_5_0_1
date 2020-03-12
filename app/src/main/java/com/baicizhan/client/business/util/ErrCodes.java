//package com.baicizhan.client.business.util;
//
//import org.p100a.p101a.C2123l;
//import org.p100a.p101a.p107f.C2120g;
//
//public class ErrCodes {
//    public static final int ERR_FILE = -300;
//    public static final int ERR_NET = -100;
//    public static final int ERR_SERVER = -101;
//    public static final int ERR_TOKEN_LOST = -200;
//    public static final int ERR_UNKNOWN = -1000;
//    public static final int NO_ERR = 0;
//
//    private ErrCodes() {
//    }
//
//    public static final int parseNetRelatedErrCode(C2123l lVar) {
//        if (lVar == null) {
//            return -1000;
//        }
//        if (!(lVar instanceof C2120g) || 3 != ((C2120g) lVar).mo18547a()) {
//            return -101;
//        }
//        return -100;
//    }
//
//    public static final int parseNetRelatedErrCode(int i) {
//        if (i == 0 || -101 == i) {
//            return 0;
//        }
//        if (-100 == i) {
//            return ERR_FILE;
//        }
//        if (i < 0) {
//            return -100;
//        }
//        if (i > 200) {
//            return -101;
//        }
//        return -1000;
//    }
//
//    public static final String buildErrMessage(int i, String str) {
//        switch (i) {
//            case -1000:
//                return "Unknown err, info > " + str;
//            case ERR_FILE /*-300*/:
//                return "File I/O error, info > " + str;
//            case ERR_TOKEN_LOST /*-200*/:
//                return "The user token does not exist, info > " + str;
//            case -101:
//                return "The server is not ok, info > " + str;
//            case -100:
//                return "The network is not ok, info > " + str;
//            default:
//                return str;
//        }
//    }
//}
