//package com.baicizhan.online.bs_words;
//
//import com.baicizhan.client.business.thrift.BaicizhanCookieInflator;
//import com.baicizhan.online.structs.BELogicException;
//import com.baicizhan.online.structs.BESystemException;
//import com.p052e.p053a.p054a.JceStruct;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.OutputStream;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.BitSet;
//import java.util.Collections;
//import java.util.EnumMap;
//import java.util.EnumSet;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import org.p100a.p101a.AsyncProcessFunction;
//import org.p100a.p101a.C2090b;
//import org.p100a.p101a.C2116f;
//import org.p100a.p101a.C2121h;
//import org.p100a.p101a.C2123l;
//import org.p100a.p101a.C2124m;
//import org.p100a.p101a.ProcessFunction;
//import org.p100a.p101a.TApplicationException;
//import org.p100a.p101a.TBaseAsyncProcessor;
//import org.p100a.p101a.TBaseProcessor;
//import org.p100a.p101a.TServiceClient;
//import org.p100a.p101a.TServiceClientFactory;
//import org.p100a.p101a.p102a.AsyncMethodCallback;
//import org.p100a.p101a.p102a.C2089h;
//import org.p100a.p101a.p102a.TAsyncClient;
//import org.p100a.p101a.p102a.TAsyncClientManager;
//import org.p100a.p101a.p102a.TAsyncMethodCall;
//import org.p100a.p101a.p103b.C2091a;
//import org.p100a.p101a.p103b.C2092b;
//import org.p100a.p101a.p103b.C2093c;
//import org.p100a.p101a.p103b.C2095e;
//import org.p100a.p101a.p104c.C2096a;
//import org.p100a.p101a.p104c.C2097b;
//import org.p100a.p101a.p104c.C2098c;
//import org.p100a.p101a.p104c.C2100f;
//import org.p100a.p101a.p104c.C2101g;
//import org.p100a.p101a.p104c.C2102h;
//import org.p100a.p101a.p104c.C2103i;
//import org.p100a.p101a.p104c.C2105k;
//import org.p100a.p101a.p104c.C2106l;
//import org.p100a.p101a.p104c.TMessage;
//import org.p100a.p101a.p105d.C2108a;
//import org.p100a.p101a.p105d.C2109b;
//import org.p100a.p101a.p105d.C2110c;
//import org.p100a.p101a.p105d.C2111d;
//import org.p100a.p101a.p106e.C2113c;
//import org.p100a.p101a.p107f.C2117b;
//import org.p100a.p101a.p107f.C2118d;
//import org.p100a.p101a.p107f.TNonblockingTransport;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class BSWords {
//
//    /* renamed from: com.baicizhan.online.bs_words.BSWords$1 */
//    /* synthetic */ class C13611 {
//
//        /* renamed from: $SwitchMap$com$baicizhan$online$bs_words$BSWords$get_word_media_halftime_list_args$_Fields */
//        static final /* synthetic */ int[] f2549x6d0c3cba = new int[_Fields.values().length];
//
//        static {
//            f2542xc40900f1 = new int[_Fields.values().length];
//            try {
//                f2542xc40900f1[_Fields.SUCCESS.ordinal()] = 1;
//            } catch (NoSuchFieldError e) {
//            }
//            try {
//                f2542xc40900f1[_Fields.SYS_EXCEPTION.ordinal()] = 2;
//            } catch (NoSuchFieldError e2) {
//            }
//            try {
//                f2542xc40900f1[_Fields.LOGIC_EXCEPTION.ordinal()] = 3;
//            } catch (NoSuchFieldError e3) {
//            }
//            f2541xae5de9b1 = new int[_Fields.values().length];
//            try {
//                f2541xae5de9b1[_Fields.PREFER_WORD_LEVEL_ID.ordinal()] = 1;
//            } catch (NoSuchFieldError e4) {
//            }
//            try {
//                f2541xae5de9b1[_Fields.TOPIC_ID.ordinal()] = 2;
//            } catch (NoSuchFieldError e5) {
//            }
//            f2564x507e935c = new int[_Fields.values().length];
//            try {
//                f2564x507e935c[_Fields.SUCCESS.ordinal()] = 1;
//            } catch (NoSuchFieldError e6) {
//            }
//            try {
//                f2564x507e935c[_Fields.SYS_EXCEPTION.ordinal()] = 2;
//            } catch (NoSuchFieldError e7) {
//            }
//            f2563x55b1adc = new int[_Fields.values().length];
//            try {
//                f2563x55b1adc[_Fields.BOOK_ID.ordinal()] = 1;
//            } catch (NoSuchFieldError e8) {
//            }
//            try {
//                f2563x55b1adc[_Fields.SIMILAR_WORDS_VOTES.ordinal()] = 2;
//            } catch (NoSuchFieldError e9) {
//            }
//            f2548x46c4cafe = new int[_Fields.values().length];
//            try {
//                f2548x46c4cafe[_Fields.SUCCESS.ordinal()] = 1;
//            } catch (NoSuchFieldError e10) {
//            }
//            try {
//                f2548x46c4cafe[_Fields.SYS_EXCEPTION.ordinal()] = 2;
//            } catch (NoSuchFieldError e11) {
//            }
//            f2547xc1aed2fe = new int[_Fields.values().length];
//            try {
//                f2547xc1aed2fe[_Fields.ARR_TOPIC_AND_BOOK_IDS.ordinal()] = 1;
//            } catch (NoSuchFieldError e12) {
//            }
//            f2544x4ca3d26f = new int[_Fields.values().length];
//            try {
//                f2544x4ca3d26f[_Fields.SUCCESS.ordinal()] = 1;
//            } catch (NoSuchFieldError e13) {
//            }
//            try {
//                f2544x4ca3d26f[_Fields.SYS_EXCEPTION.ordinal()] = 2;
//            } catch (NoSuchFieldError e14) {
//            }
//            f2543x21db02af = new int[_Fields.values().length];
//            try {
//                f2543x21db02af[_Fields.BOOK_ID.ordinal()] = 1;
//            } catch (NoSuchFieldError e15) {
//            }
//            try {
//                f2543x21db02af[_Fields.ARR_TOPIC_IDS.ordinal()] = 2;
//            } catch (NoSuchFieldError e16) {
//            }
//            f2566x32146097 = new int[_Fields.values().length];
//            try {
//                f2566x32146097[_Fields.SUCCESS.ordinal()] = 1;
//            } catch (NoSuchFieldError e17) {
//            }
//            try {
//                f2566x32146097[_Fields.SYS_EXCEPTION.ordinal()] = 2;
//            } catch (NoSuchFieldError e18) {
//            }
//            try {
//                f2566x32146097[_Fields.LOGIC_EXCEPTION.ordinal()] = 3;
//            } catch (NoSuchFieldError e19) {
//            }
//            f2565x12e8fad7 = new int[_Fields.values().length];
//            try {
//                f2565x12e8fad7[_Fields.TOPIC_ID.ordinal()] = 1;
//            } catch (NoSuchFieldError e20) {
//            }
//            try {
//                f2565x12e8fad7[_Fields.WORD_LEVEL_ID.ordinal()] = 2;
//            } catch (NoSuchFieldError e21) {
//            }
//            try {
//                f2565x12e8fad7[_Fields.TAG_ID.ordinal()] = 3;
//            } catch (NoSuchFieldError e22) {
//            }
//            try {
//                f2565x12e8fad7[_Fields.VERSION.ordinal()] = 4;
//            } catch (NoSuchFieldError e23) {
//            }
//            try {
//                f2565x12e8fad7[_Fields.SIGNED_KEY.ordinal()] = 5;
//            } catch (NoSuchFieldError e24) {
//            }
//            f2572x626d8793 = new int[_Fields.values().length];
//            try {
//                f2572x626d8793[_Fields.SUCCESS.ordinal()] = 1;
//            } catch (NoSuchFieldError e25) {
//            }
//            try {
//                f2572x626d8793[_Fields.SYS_EXCEPTION.ordinal()] = 2;
//            } catch (NoSuchFieldError e26) {
//            }
//            try {
//                f2572x626d8793[_Fields.LOGIC_EXCEPTION.ordinal()] = 3;
//            } catch (NoSuchFieldError e27) {
//            }
//            f2571xd417b0d3 = new int[_Fields.values().length];
//            try {
//                f2571xd417b0d3[_Fields.QUERY_STR.ordinal()] = 1;
//            } catch (NoSuchFieldError e28) {
//            }
//            f2576x27179633 = new int[_Fields.values().length];
//            try {
//                f2576x27179633[_Fields.SUCCESS.ordinal()] = 1;
//            } catch (NoSuchFieldError e29) {
//            }
//            try {
//                f2576x27179633[_Fields.SYS_EXCEPTION.ordinal()] = 2;
//            } catch (NoSuchFieldError e30) {
//            }
//            try {
//                f2576x27179633[_Fields.LOGIC_EXCEPTION.ordinal()] = 3;
//            } catch (NoSuchFieldError e31) {
//            }
//            f2575xeb34e773 = new int[_Fields.values().length];
//            try {
//                f2575xeb34e773[_Fields.TOPIC_ID.ordinal()] = 1;
//            } catch (NoSuchFieldError e32) {
//            }
//            try {
//                f2575xeb34e773[_Fields.BOOK_ID.ordinal()] = 2;
//            } catch (NoSuchFieldError e33) {
//            }
//            try {
//                f2575xeb34e773[_Fields.TAG_ID.ordinal()] = 3;
//            } catch (NoSuchFieldError e34) {
//            }
//            f2574xf70a6332 = new int[_Fields.values().length];
//            try {
//                f2574xf70a6332[_Fields.SUCCESS.ordinal()] = 1;
//            } catch (NoSuchFieldError e35) {
//            }
//            try {
//                f2574xf70a6332[_Fields.SYS_EXCEPTION.ordinal()] = 2;
//            } catch (NoSuchFieldError e36) {
//            }
//            try {
//                f2574xf70a6332[_Fields.LOGIC_EXCEPTION.ordinal()] = 3;
//            } catch (NoSuchFieldError e37) {
//            }
//            f2573xf724e832 = new int[_Fields.values().length];
//            try {
//                f2573xf724e832[_Fields.TOPIC_ID.ordinal()] = 1;
//            } catch (NoSuchFieldError e38) {
//            }
//            try {
//                f2573xf724e832[_Fields.BOOK_ID.ordinal()] = 2;
//            } catch (NoSuchFieldError e39) {
//            }
//            f2558xd72806ef = new int[_Fields.values().length];
//            try {
//                f2558xd72806ef[_Fields.SUCCESS.ordinal()] = 1;
//            } catch (NoSuchFieldError e40) {
//            }
//            try {
//                f2558xd72806ef[_Fields.SYS_EXCEPTION.ordinal()] = 2;
//            } catch (NoSuchFieldError e41) {
//            }
//            try {
//                f2558xd72806ef[_Fields.LOGIC_EXCEPTION.ordinal()] = 3;
//            } catch (NoSuchFieldError e42) {
//            }
//            f2557x50e2572f = new int[_Fields.values().length];
//            try {
//                f2557x50e2572f[_Fields.TOPIC_ID.ordinal()] = 1;
//            } catch (NoSuchFieldError e43) {
//            }
//            try {
//                f2557x50e2572f[_Fields.BOOK_ID.ordinal()] = 2;
//            } catch (NoSuchFieldError e44) {
//            }
//            try {
//                f2557x50e2572f[_Fields.TAG_ID.ordinal()] = 3;
//            } catch (NoSuchFieldError e45) {
//            }
//            f2556xfa520bf6 = new int[_Fields.values().length];
//            try {
//                f2556xfa520bf6[_Fields.SUCCESS.ordinal()] = 1;
//            } catch (NoSuchFieldError e46) {
//            }
//            try {
//                f2556xfa520bf6[_Fields.SYS_EXCEPTION.ordinal()] = 2;
//            } catch (NoSuchFieldError e47) {
//            }
//            try {
//                f2556xfa520bf6[_Fields.LOGIC_EXCEPTION.ordinal()] = 3;
//            } catch (NoSuchFieldError e48) {
//            }
//            f2555x6707f1f6 = new int[_Fields.values().length];
//            try {
//                f2555x6707f1f6[_Fields.TOPIC_ID.ordinal()] = 1;
//            } catch (NoSuchFieldError e49) {
//            }
//            try {
//                f2555x6707f1f6[_Fields.BOOK_ID.ordinal()] = 2;
//            } catch (NoSuchFieldError e50) {
//            }
//            f2554xf69e59d6 = new int[_Fields.values().length];
//            try {
//                f2554xf69e59d6[_Fields.SUCCESS.ordinal()] = 1;
//            } catch (NoSuchFieldError e51) {
//            }
//            try {
//                f2554xf69e59d6[_Fields.SYS_EXCEPTION.ordinal()] = 2;
//            } catch (NoSuchFieldError e52) {
//            }
//            try {
//                f2554xf69e59d6[_Fields.LOGIC_EXCEPTION.ordinal()] = 3;
//            } catch (NoSuchFieldError e53) {
//            }
//            f2553x7bce37d6 = new int[_Fields.values().length];
//            try {
//                f2553x7bce37d6[_Fields.TOPIC_IDS.ordinal()] = 1;
//            } catch (NoSuchFieldError e54) {
//            }
//            try {
//                f2553x7bce37d6[_Fields.WORD_LEVEL_ID.ordinal()] = 2;
//            } catch (NoSuchFieldError e55) {
//            }
//            f2546xc4c3ffb7 = new int[_Fields.values().length];
//            try {
//                f2546xc4c3ffb7[_Fields.SUCCESS.ordinal()] = 1;
//            } catch (NoSuchFieldError e56) {
//            }
//            try {
//                f2546xc4c3ffb7[_Fields.SYS_EXCEPTION.ordinal()] = 2;
//            } catch (NoSuchFieldError e57) {
//            }
//            try {
//                f2546xc4c3ffb7[_Fields.LOGIC_EXCEPTION.ordinal()] = 3;
//            } catch (NoSuchFieldError e58) {
//            }
//            f2545x535e1f7 = new int[_Fields.values().length];
//            try {
//                f2545x535e1f7[_Fields.WORD_LEVEL_ID.ordinal()] = 1;
//            } catch (NoSuchFieldError e59) {
//            }
//            f2550x906eb5ba = new int[_Fields.values().length];
//            try {
//                f2550x906eb5ba[_Fields.SUCCESS.ordinal()] = 1;
//            } catch (NoSuchFieldError e60) {
//            }
//            try {
//                f2550x906eb5ba[_Fields.SYS_EXCEPTION.ordinal()] = 2;
//            } catch (NoSuchFieldError e61) {
//            }
//            f2552xa55f5e33 = new int[_Fields.values().length];
//            try {
//                f2552xa55f5e33[_Fields.SUCCESS.ordinal()] = 1;
//            } catch (NoSuchFieldError e62) {
//            }
//            try {
//                f2552xa55f5e33[_Fields.SYS_EXCEPTION.ordinal()] = 2;
//            } catch (NoSuchFieldError e63) {
//            }
//            f2551x68ceaf73 = new int[_Fields.values().length];
//            try {
//                f2551x68ceaf73[_Fields.BOOK_ID.ordinal()] = 1;
//            } catch (NoSuchFieldError e64) {
//            }
//            f2570x962ad485 = new int[_Fields.values().length];
//            try {
//                f2570x962ad485[_Fields.SUCCESS.ordinal()] = 1;
//            } catch (NoSuchFieldError e65) {
//            }
//            try {
//                f2570x962ad485[_Fields.SYS_EXCEPTION.ordinal()] = 2;
//            } catch (NoSuchFieldError e66) {
//            }
//            f2569x54479245 = new int[_Fields.values().length];
//            try {
//                f2569x54479245[_Fields.TOPIC_IDS.ordinal()] = 1;
//            } catch (NoSuchFieldError e67) {
//            }
//            f2568xfa6e1620 = new int[_Fields.values().length];
//            try {
//                f2568xfa6e1620[_Fields.SUCCESS.ordinal()] = 1;
//            } catch (NoSuchFieldError e68) {
//            }
//            try {
//                f2568xfa6e1620[_Fields.SYS_EXCEPTION.ordinal()] = 2;
//            } catch (NoSuchFieldError e69) {
//            }
//            f2567x78147ea0 = new int[_Fields.values().length];
//            try {
//                f2567x78147ea0[_Fields.TOPIC_IDS.ordinal()] = 1;
//            } catch (NoSuchFieldError e70) {
//            }
//            f2562x7f214c34 = new int[_Fields.values().length];
//            try {
//                f2562x7f214c34[_Fields.SUCCESS.ordinal()] = 1;
//            } catch (NoSuchFieldError e71) {
//            }
//            try {
//                f2562x7f214c34[_Fields.SYS_EXCEPTION.ordinal()] = 2;
//            } catch (NoSuchFieldError e72) {
//            }
//            f2561xd28629b4 = new int[_Fields.values().length];
//            try {
//                f2561xd28629b4[_Fields.WORD_LEVEL_ID.ordinal()] = 1;
//            } catch (NoSuchFieldError e73) {
//            }
//            try {
//                f2561xd28629b4[_Fields.TOPIC_IDS.ordinal()] = 2;
//            } catch (NoSuchFieldError e74) {
//            }
//            f2560x595754d1 = new int[_Fields.values().length];
//            try {
//                f2560x595754d1[_Fields.SUCCESS.ordinal()] = 1;
//            } catch (NoSuchFieldError e75) {
//            }
//            try {
//                f2560x595754d1[_Fields.SYS_EXCEPTION.ordinal()] = 2;
//            } catch (NoSuchFieldError e76) {
//            }
//            f2559xa0efb591 = new int[_Fields.values().length];
//            try {
//                f2559xa0efb591[_Fields.WORD_LEVEL_ID.ordinal()] = 1;
//            } catch (NoSuchFieldError e77) {
//            }
//            try {
//                f2559xa0efb591[_Fields.TOPIC_IDS.ordinal()] = 2;
//            } catch (NoSuchFieldError e78) {
//            }
//        }
//    }
//
//    public class AsyncClient extends TAsyncClient implements AsyncIface {
//
//        public class Factory {
//            private TAsyncClientManager clientManager;
//            private C2102h protocolFactory;
//
//            public Factory(TAsyncClientManager cVar, C2102h hVar) {
//                this.clientManager = cVar;
//                this.protocolFactory = hVar;
//            }
//
//            public AsyncClient getAsyncClient(TNonblockingTransport eVar) {
//                return new AsyncClient(this.protocolFactory, this.clientManager, eVar);
//            }
//        }
//
//        public class get_search_word_package_call extends TAsyncMethodCall {
//            private int prefer_word_level_id;
//            private int topic_id;
//
//            public get_search_word_package_call(int i, int i2, AsyncMethodCallback aVar, TAsyncClient bVar, C2102h hVar, TNonblockingTransport eVar) {
//                super(bVar, hVar, eVar, aVar, false);
//                this.prefer_word_level_id = i;
//                this.topic_id = i2;
//            }
//
//            public void write_args(C2100f fVar) {
//                fVar.mo18499a(new TMessage("get_search_word_package", 1, 0));
//                get_search_word_package_args get_search_word_package_args = new get_search_word_package_args();
//                get_search_word_package_args.setPrefer_word_level_id(this.prefer_word_level_id);
//                get_search_word_package_args.setTopic_id(this.topic_id);
//                get_search_word_package_args.write(fVar);
//            }
//
//            public BBWordPackage getResult() {
//                if (getState() != C2089h.f5806f) {
//                    throw new IllegalStateException("Method call not finished!");
//                }
//                new C2118d(getFrameBuffer().array());
//                return new Client(this.client.getProtocolFactory().mo18526a()).recv_get_search_word_package();
//            }
//        }
//
//        public class get_similar_words_info_call extends TAsyncMethodCall {
//            private List<Integer> arr_topic_ids;
//            private int book_id;
//
//            public get_similar_words_info_call(int i, List<Integer> list, AsyncMethodCallback aVar, TAsyncClient bVar, C2102h hVar, TNonblockingTransport eVar) {
//                super(bVar, hVar, eVar, aVar, false);
//                this.book_id = i;
//                this.arr_topic_ids = list;
//            }
//
//            public void write_args(C2100f fVar) {
//                fVar.mo18499a(new TMessage("get_similar_words_info", 1, 0));
//                get_similar_words_info_args get_similar_words_info_args = new get_similar_words_info_args();
//                get_similar_words_info_args.setBook_id(this.book_id);
//                get_similar_words_info_args.setArr_topic_ids(this.arr_topic_ids);
//                get_similar_words_info_args.write(fVar);
//            }
//
//            public List<BBSimilarWordInfo> getResult() {
//                if (getState() != C2089h.f5806f) {
//                    throw new IllegalStateException("Method call not finished!");
//                }
//                new C2118d(getFrameBuffer().array());
//                return new Client(this.client.getProtocolFactory().mo18526a()).recv_get_similar_words_info();
//            }
//        }
//
//        public class get_word_asset_pack_info_call extends TAsyncMethodCall {
//            private int word_level_id;
//
//            public get_word_asset_pack_info_call(int i, AsyncMethodCallback aVar, TAsyncClient bVar, C2102h hVar, TNonblockingTransport eVar) {
//                super(bVar, hVar, eVar, aVar, false);
//                this.word_level_id = i;
//            }
//
//            public void write_args(C2100f fVar) {
//                fVar.mo18499a(new TMessage("get_word_asset_pack_info", 1, 0));
//                get_word_asset_pack_info_args get_word_asset_pack_info_args = new get_word_asset_pack_info_args();
//                get_word_asset_pack_info_args.setWord_level_id(this.word_level_id);
//                get_word_asset_pack_info_args.write(fVar);
//            }
//
//            public List<BBWordAssetPackInfo> getResult() {
//                if (getState() != C2089h.f5806f) {
//                    throw new IllegalStateException("Method call not finished!");
//                }
//                new C2118d(getFrameBuffer().array());
//                return new Client(this.client.getProtocolFactory().mo18526a()).recv_get_word_asset_pack_info();
//            }
//        }
//
//        public class get_word_assets_info_by_topic_and_book_id_call extends TAsyncMethodCall {
//            private List<BBGetWordAssetInfoArg> arr_topic_and_book_ids;
//
//            public get_word_assets_info_by_topic_and_book_id_call(List<BBGetWordAssetInfoArg> list, AsyncMethodCallback aVar, TAsyncClient bVar, C2102h hVar, TNonblockingTransport eVar) {
//                super(bVar, hVar, eVar, aVar, false);
//                this.arr_topic_and_book_ids = list;
//            }
//
//            public void write_args(C2100f fVar) {
//                fVar.mo18499a(new TMessage("get_word_assets_info_by_topic_and_book_id", 1, 0));
//                get_word_assets_info_by_topic_and_book_id_args get_word_assets_info_by_topic_and_book_id_args = new get_word_assets_info_by_topic_and_book_id_args();
//                get_word_assets_info_by_topic_and_book_id_args.setArr_topic_and_book_ids(this.arr_topic_and_book_ids);
//                get_word_assets_info_by_topic_and_book_id_args.write(fVar);
//            }
//
//            public List<BBGetWordAssetInfoResult> getResult() {
//                if (getState() != C2089h.f5806f) {
//                    throw new IllegalStateException("Method call not finished!");
//                }
//                new C2118d(getFrameBuffer().array());
//                return new Client(this.client.getProtocolFactory().mo18526a()).recv_get_word_assets_info_by_topic_and_book_id();
//            }
//        }
//
//        public class get_word_media_halftime_list_call extends TAsyncMethodCall {
//            public get_word_media_halftime_list_call(AsyncMethodCallback aVar, TAsyncClient bVar, C2102h hVar, TNonblockingTransport eVar) {
//                super(bVar, hVar, eVar, aVar, false);
//            }
//
//            public void write_args(C2100f fVar) {
//                fVar.mo18499a(new TMessage("get_word_media_halftime_list", 1, 0));
//                new get_word_media_halftime_list_args().write(fVar);
//            }
//
//            public BBWordMediaHalftimeList getResult() {
//                if (getState() != C2089h.f5806f) {
//                    throw new IllegalStateException("Method call not finished!");
//                }
//                new C2118d(getFrameBuffer().array());
//                return new Client(this.client.getProtocolFactory().mo18526a()).recv_get_word_media_halftime_list();
//            }
//        }
//
//        public class get_word_media_update_info_call extends TAsyncMethodCall {
//            private int book_id;
//
//            public get_word_media_update_info_call(int i, AsyncMethodCallback aVar, TAsyncClient bVar, C2102h hVar, TNonblockingTransport eVar) {
//                super(bVar, hVar, eVar, aVar, false);
//                this.book_id = i;
//            }
//
//            public void write_args(C2100f fVar) {
//                fVar.mo18499a(new TMessage("get_word_media_update_info", 1, 0));
//                get_word_media_update_info_args get_word_media_update_info_args = new get_word_media_update_info_args();
//                get_word_media_update_info_args.setBook_id(this.book_id);
//                get_word_media_update_info_args.write(fVar);
//            }
//
//            public List<BBWordMediaUpdateInfo> getResult() {
//                if (getState() != C2089h.f5806f) {
//                    throw new IllegalStateException("Method call not finished!");
//                }
//                new C2118d(getFrameBuffer().array());
//                return new Client(this.client.getProtocolFactory().mo18526a()).recv_get_word_media_update_info();
//            }
//        }
//
//        public class get_word_package_call extends TAsyncMethodCall {
//            private List<Integer> topic_ids;
//            private int word_level_id;
//
//            public get_word_package_call(List<Integer> list, int i, AsyncMethodCallback aVar, TAsyncClient bVar, C2102h hVar, TNonblockingTransport eVar) {
//                super(bVar, hVar, eVar, aVar, false);
//                this.topic_ids = list;
//                this.word_level_id = i;
//            }
//
//            public void write_args(C2100f fVar) {
//                fVar.mo18499a(new TMessage("get_word_package", 1, 0));
//                get_word_package_args get_word_package_args = new get_word_package_args();
//                get_word_package_args.setTopic_ids(this.topic_ids);
//                get_word_package_args.setWord_level_id(this.word_level_id);
//                get_word_package_args.write(fVar);
//            }
//
//            public List<BBWordPackage> getResult() {
//                if (getState() != C2089h.f5806f) {
//                    throw new IllegalStateException("Method call not finished!");
//                }
//                new C2118d(getFrameBuffer().array());
//                return new Client(this.client.getProtocolFactory().mo18526a()).recv_get_word_package();
//            }
//        }
//
//        public class get_word_share_info_call extends TAsyncMethodCall {
//            private int book_id;
//            private int topic_id;
//
//            public get_word_share_info_call(int i, int i2, AsyncMethodCallback aVar, TAsyncClient bVar, C2102h hVar, TNonblockingTransport eVar) {
//                super(bVar, hVar, eVar, aVar, false);
//                this.topic_id = i;
//                this.book_id = i2;
//            }
//
//            public void write_args(C2100f fVar) {
//                fVar.mo18499a(new TMessage("get_word_share_info", 1, 0));
//                get_word_share_info_args get_word_share_info_args = new get_word_share_info_args();
//                get_word_share_info_args.setTopic_id(this.topic_id);
//                get_word_share_info_args.setBook_id(this.book_id);
//                get_word_share_info_args.write(fVar);
//            }
//
//            public BBWordShareInfo getResult() {
//                if (getState() != C2089h.f5806f) {
//                    throw new IllegalStateException("Method call not finished!");
//                }
//                new C2118d(getFrameBuffer().array());
//                return new Client(this.client.getProtocolFactory().mo18526a()).recv_get_word_share_info();
//            }
//        }
//
//        public class get_word_share_info_v2_call extends TAsyncMethodCall {
//            private int book_id;
//            private int tag_id;
//            private int topic_id;
//
//            public get_word_share_info_v2_call(int i, int i2, int i3, AsyncMethodCallback aVar, TAsyncClient bVar, C2102h hVar, TNonblockingTransport eVar) {
//                super(bVar, hVar, eVar, aVar, false);
//                this.topic_id = i;
//                this.book_id = i2;
//                this.tag_id = i3;
//            }
//
//            public void write_args(C2100f fVar) {
//                fVar.mo18499a(new TMessage("get_word_share_info_v2", 1, 0));
//                get_word_share_info_v2_args get_word_share_info_v2_args = new get_word_share_info_v2_args();
//                get_word_share_info_v2_args.setTopic_id(this.topic_id);
//                get_word_share_info_v2_args.setBook_id(this.book_id);
//                get_word_share_info_v2_args.setTag_id(this.tag_id);
//                get_word_share_info_v2_args.write(fVar);
//            }
//
//            public BBWordShareInfo getResult() {
//                if (getState() != C2089h.f5806f) {
//                    throw new IllegalStateException("Method call not finished!");
//                }
//                new C2118d(getFrameBuffer().array());
//                return new Client(this.client.getProtocolFactory().mo18526a()).recv_get_word_share_info_v2();
//            }
//        }
//
//        public class get_word_topic_assets_call extends TAsyncMethodCall {
//            private List<Integer> topic_ids;
//            private int word_level_id;
//
//            public get_word_topic_assets_call(int i, List<Integer> list, AsyncMethodCallback aVar, TAsyncClient bVar, C2102h hVar, TNonblockingTransport eVar) {
//                super(bVar, hVar, eVar, aVar, false);
//                this.word_level_id = i;
//                this.topic_ids = list;
//            }
//
//            public void write_args(C2100f fVar) {
//                fVar.mo18499a(new TMessage("get_word_topic_assets", 1, 0));
//                get_word_topic_assets_args get_word_topic_assets_args = new get_word_topic_assets_args();
//                get_word_topic_assets_args.setWord_level_id(this.word_level_id);
//                get_word_topic_assets_args.setTopic_ids(this.topic_ids);
//                get_word_topic_assets_args.write(fVar);
//            }
//
//            public List<BBTopicAsset> getResult() {
//                if (getState() != C2089h.f5806f) {
//                    throw new IllegalStateException("Method call not finished!");
//                }
//                new C2118d(getFrameBuffer().array());
//                return new Client(this.client.getProtocolFactory().mo18526a()).recv_get_word_topic_assets();
//            }
//        }
//
//        public class get_word_topic_assets_v2_call extends TAsyncMethodCall {
//            private List<Integer> topic_ids;
//            private int word_level_id;
//
//            public get_word_topic_assets_v2_call(int i, List<Integer> list, AsyncMethodCallback aVar, TAsyncClient bVar, C2102h hVar, TNonblockingTransport eVar) {
//                super(bVar, hVar, eVar, aVar, false);
//                this.word_level_id = i;
//                this.topic_ids = list;
//            }
//
//            public void write_args(C2100f fVar) {
//                fVar.mo18499a(new TMessage("get_word_topic_assets_v2", 1, 0));
//                get_word_topic_assets_v2_args get_word_topic_assets_v2_args = new get_word_topic_assets_v2_args();
//                get_word_topic_assets_v2_args.setWord_level_id(this.word_level_id);
//                get_word_topic_assets_v2_args.setTopic_ids(this.topic_ids);
//                get_word_topic_assets_v2_args.write(fVar);
//            }
//
//            public List<BBTopicAssetV2> getResult() {
//                if (getState() != C2089h.f5806f) {
//                    throw new IllegalStateException("Method call not finished!");
//                }
//                new C2118d(getFrameBuffer().array());
//                return new Client(this.client.getProtocolFactory().mo18526a()).recv_get_word_topic_assets_v2();
//            }
//        }
//
//        public class similar_words_vote_call extends TAsyncMethodCall {
//            private int book_id;
//            private List<BBSimilarWordVote> similar_words_votes;
//
//            public similar_words_vote_call(int i, List<BBSimilarWordVote> list, AsyncMethodCallback aVar, TAsyncClient bVar, C2102h hVar, TNonblockingTransport eVar) {
//                super(bVar, hVar, eVar, aVar, false);
//                this.book_id = i;
//                this.similar_words_votes = list;
//            }
//
//            public void write_args(C2100f fVar) {
//                fVar.mo18499a(new TMessage("similar_words_vote", 1, 0));
//                similar_words_vote_args similar_words_vote_args = new similar_words_vote_args();
//                similar_words_vote_args.setBook_id(this.book_id);
//                similar_words_vote_args.setSimilar_words_votes(this.similar_words_votes);
//                similar_words_vote_args.write(fVar);
//            }
//
//            public int getResult() {
//                if (getState() != C2089h.f5806f) {
//                    throw new IllegalStateException("Method call not finished!");
//                }
//                new C2118d(getFrameBuffer().array());
//                return new Client(this.client.getProtocolFactory().mo18526a()).recv_similar_words_vote();
//            }
//        }
//
//        public class update_online_topic_call extends TAsyncMethodCall {
//            private String signed_key;
//            private int tag_id;
//            private int topic_id;
//            private int version;
//            private int word_level_id;
//
//            public update_online_topic_call(int i, int i2, int i3, int i4, String str, AsyncMethodCallback aVar, TAsyncClient bVar, C2102h hVar, TNonblockingTransport eVar) {
//                super(bVar, hVar, eVar, aVar, false);
//                this.topic_id = i;
//                this.word_level_id = i2;
//                this.tag_id = i3;
//                this.version = i4;
//                this.signed_key = str;
//            }
//
//            public void write_args(C2100f fVar) {
//                fVar.mo18499a(new TMessage("update_online_topic", 1, 0));
//                update_online_topic_args update_online_topic_args = new update_online_topic_args();
//                update_online_topic_args.setTopic_id(this.topic_id);
//                update_online_topic_args.setWord_level_id(this.word_level_id);
//                update_online_topic_args.setTag_id(this.tag_id);
//                update_online_topic_args.setVersion(this.version);
//                update_online_topic_args.setSigned_key(this.signed_key);
//                update_online_topic_args.write(fVar);
//            }
//
//            public int getResult() {
//                if (getState() != C2089h.f5806f) {
//                    throw new IllegalStateException("Method call not finished!");
//                }
//                new C2118d(getFrameBuffer().array());
//                return new Client(this.client.getProtocolFactory().mo18526a()).recv_update_online_topic();
//            }
//        }
//
//        public class word_media_by_topic_ids_call extends TAsyncMethodCall {
//            private List<Integer> topic_ids;
//
//            public word_media_by_topic_ids_call(List<Integer> list, AsyncMethodCallback aVar, TAsyncClient bVar, C2102h hVar, TNonblockingTransport eVar) {
//                super(bVar, hVar, eVar, aVar, false);
//                this.topic_ids = list;
//            }
//
//            public void write_args(C2100f fVar) {
//                fVar.mo18499a(new TMessage("word_media_by_topic_ids", 1, 0));
//                word_media_by_topic_ids_args word_media_by_topic_ids_args = new word_media_by_topic_ids_args();
//                word_media_by_topic_ids_args.setTopic_ids(this.topic_ids);
//                word_media_by_topic_ids_args.write(fVar);
//            }
//
//            public List<BBWordMedia> getResult() {
//                if (getState() != C2089h.f5806f) {
//                    throw new IllegalStateException("Method call not finished!");
//                }
//                new C2118d(getFrameBuffer().array());
//                return new Client(this.client.getProtocolFactory().mo18526a()).recv_word_media_by_topic_ids();
//            }
//        }
//
//        public class word_media_by_topic_ids_v2_call extends TAsyncMethodCall {
//            private List<Integer> topic_ids;
//
//            public word_media_by_topic_ids_v2_call(List<Integer> list, AsyncMethodCallback aVar, TAsyncClient bVar, C2102h hVar, TNonblockingTransport eVar) {
//                super(bVar, hVar, eVar, aVar, false);
//                this.topic_ids = list;
//            }
//
//            public void write_args(C2100f fVar) {
//                fVar.mo18499a(new TMessage("word_media_by_topic_ids_v2", 1, 0));
//                word_media_by_topic_ids_v2_args word_media_by_topic_ids_v2_args = new word_media_by_topic_ids_v2_args();
//                word_media_by_topic_ids_v2_args.setTopic_ids(this.topic_ids);
//                word_media_by_topic_ids_v2_args.write(fVar);
//            }
//
//            public List<BBWordMediaV2> getResult() {
//                if (getState() != C2089h.f5806f) {
//                    throw new IllegalStateException("Method call not finished!");
//                }
//                new C2118d(getFrameBuffer().array());
//                return new Client(this.client.getProtocolFactory().mo18526a()).recv_word_media_by_topic_ids_v2();
//            }
//        }
//
//        public class word_search_call extends TAsyncMethodCall {
//            private String query_str;
//
//            public word_search_call(String str, AsyncMethodCallback aVar, TAsyncClient bVar, C2102h hVar, TNonblockingTransport eVar) {
//                super(bVar, hVar, eVar, aVar, false);
//                this.query_str = str;
//            }
//
//            public void write_args(C2100f fVar) {
//                fVar.mo18499a(new TMessage("word_search", 1, 0));
//                word_search_args word_search_args = new word_search_args();
//                word_search_args.setQuery_str(this.query_str);
//                word_search_args.write(fVar);
//            }
//
//            public List<BBWordSearchResult> getResult() {
//                if (getState() != C2089h.f5806f) {
//                    throw new IllegalStateException("Method call not finished!");
//                }
//                new C2118d(getFrameBuffer().array());
//                return new Client(this.client.getProtocolFactory().mo18526a()).recv_word_search();
//            }
//        }
//
//        public class word_share_notify_call extends TAsyncMethodCall {
//            private int book_id;
//            private int topic_id;
//
//            public word_share_notify_call(int i, int i2, AsyncMethodCallback aVar, TAsyncClient bVar, C2102h hVar, TNonblockingTransport eVar) {
//                super(bVar, hVar, eVar, aVar, false);
//                this.topic_id = i;
//                this.book_id = i2;
//            }
//
//            public void write_args(C2100f fVar) {
//                fVar.mo18499a(new TMessage("word_share_notify", 1, 0));
//                word_share_notify_args word_share_notify_args = new word_share_notify_args();
//                word_share_notify_args.setTopic_id(this.topic_id);
//                word_share_notify_args.setBook_id(this.book_id);
//                word_share_notify_args.write(fVar);
//            }
//
//            public int getResult() {
//                if (getState() != C2089h.f5806f) {
//                    throw new IllegalStateException("Method call not finished!");
//                }
//                new C2118d(getFrameBuffer().array());
//                return new Client(this.client.getProtocolFactory().mo18526a()).recv_word_share_notify();
//            }
//        }
//
//        public class word_share_notify_v2_call extends TAsyncMethodCall {
//            private int book_id;
//            private int tag_id;
//            private int topic_id;
//
//            public word_share_notify_v2_call(int i, int i2, int i3, AsyncMethodCallback aVar, TAsyncClient bVar, C2102h hVar, TNonblockingTransport eVar) {
//                super(bVar, hVar, eVar, aVar, false);
//                this.topic_id = i;
//                this.book_id = i2;
//                this.tag_id = i3;
//            }
//
//            public void write_args(C2100f fVar) {
//                fVar.mo18499a(new TMessage("word_share_notify_v2", 1, 0));
//                word_share_notify_v2_args word_share_notify_v2_args = new word_share_notify_v2_args();
//                word_share_notify_v2_args.setTopic_id(this.topic_id);
//                word_share_notify_v2_args.setBook_id(this.book_id);
//                word_share_notify_v2_args.setTag_id(this.tag_id);
//                word_share_notify_v2_args.write(fVar);
//            }
//
//            public int getResult() {
//                if (getState() != C2089h.f5806f) {
//                    throw new IllegalStateException("Method call not finished!");
//                }
//                new C2118d(getFrameBuffer().array());
//                return new Client(this.client.getProtocolFactory().mo18526a()).recv_word_share_notify_v2();
//            }
//        }
//
//        public AsyncClient(C2102h hVar, TAsyncClientManager cVar, TNonblockingTransport eVar) {
//            super(hVar, cVar, eVar);
//        }
//
//        public void get_word_topic_assets(int i, List<Integer> list, AsyncMethodCallback aVar) {
//            checkReady();
//            get_word_topic_assets_call get_word_topic_assets_call2 = new get_word_topic_assets_call(i, list, aVar, this, this.___protocolFactory, this.___transport);
//            this.___currentMethod = get_word_topic_assets_call2;
//            this.___manager.mo18472a((TAsyncMethodCall) get_word_topic_assets_call2);
//        }
//
//        public void get_word_topic_assets_v2(int i, List<Integer> list, AsyncMethodCallback aVar) {
//            checkReady();
//            get_word_topic_assets_v2_call get_word_topic_assets_v2_call2 = new get_word_topic_assets_v2_call(i, list, aVar, this, this.___protocolFactory, this.___transport);
//            this.___currentMethod = get_word_topic_assets_v2_call2;
//            this.___manager.mo18472a((TAsyncMethodCall) get_word_topic_assets_v2_call2);
//        }
//
//        public void word_media_by_topic_ids(List<Integer> list, AsyncMethodCallback aVar) {
//            checkReady();
//            word_media_by_topic_ids_call word_media_by_topic_ids_call2 = new word_media_by_topic_ids_call(list, aVar, this, this.___protocolFactory, this.___transport);
//            this.___currentMethod = word_media_by_topic_ids_call2;
//            this.___manager.mo18472a((TAsyncMethodCall) word_media_by_topic_ids_call2);
//        }
//
//        public void word_media_by_topic_ids_v2(List<Integer> list, AsyncMethodCallback aVar) {
//            checkReady();
//            word_media_by_topic_ids_v2_call word_media_by_topic_ids_v2_call2 = new word_media_by_topic_ids_v2_call(list, aVar, this, this.___protocolFactory, this.___transport);
//            this.___currentMethod = word_media_by_topic_ids_v2_call2;
//            this.___manager.mo18472a((TAsyncMethodCall) word_media_by_topic_ids_v2_call2);
//        }
//
//        public void get_word_media_update_info(int i, AsyncMethodCallback aVar) {
//            checkReady();
//            get_word_media_update_info_call get_word_media_update_info_call2 = new get_word_media_update_info_call(i, aVar, this, this.___protocolFactory, this.___transport);
//            this.___currentMethod = get_word_media_update_info_call2;
//            this.___manager.mo18472a((TAsyncMethodCall) get_word_media_update_info_call2);
//        }
//
//        public void get_word_media_halftime_list(AsyncMethodCallback aVar) {
//            checkReady();
//            get_word_media_halftime_list_call get_word_media_halftime_list_call2 = new get_word_media_halftime_list_call(aVar, this, this.___protocolFactory, this.___transport);
//            this.___currentMethod = get_word_media_halftime_list_call2;
//            this.___manager.mo18472a((TAsyncMethodCall) get_word_media_halftime_list_call2);
//        }
//
//        public void get_word_asset_pack_info(int i, AsyncMethodCallback aVar) {
//            checkReady();
//            get_word_asset_pack_info_call get_word_asset_pack_info_call2 = new get_word_asset_pack_info_call(i, aVar, this, this.___protocolFactory, this.___transport);
//            this.___currentMethod = get_word_asset_pack_info_call2;
//            this.___manager.mo18472a((TAsyncMethodCall) get_word_asset_pack_info_call2);
//        }
//
//        public void get_word_package(List<Integer> list, int i, AsyncMethodCallback aVar) {
//            checkReady();
//            get_word_package_call get_word_package_call2 = new get_word_package_call(list, i, aVar, this, this.___protocolFactory, this.___transport);
//            this.___currentMethod = get_word_package_call2;
//            this.___manager.mo18472a((TAsyncMethodCall) get_word_package_call2);
//        }
//
//        public void get_word_share_info(int i, int i2, AsyncMethodCallback aVar) {
//            checkReady();
//            get_word_share_info_call get_word_share_info_call2 = new get_word_share_info_call(i, i2, aVar, this, this.___protocolFactory, this.___transport);
//            this.___currentMethod = get_word_share_info_call2;
//            this.___manager.mo18472a((TAsyncMethodCall) get_word_share_info_call2);
//        }
//
//        public void get_word_share_info_v2(int i, int i2, int i3, AsyncMethodCallback aVar) {
//            checkReady();
//            get_word_share_info_v2_call get_word_share_info_v2_call2 = new get_word_share_info_v2_call(i, i2, i3, aVar, this, this.___protocolFactory, this.___transport);
//            this.___currentMethod = get_word_share_info_v2_call2;
//            this.___manager.mo18472a((TAsyncMethodCall) get_word_share_info_v2_call2);
//        }
//
//        public void word_share_notify(int i, int i2, AsyncMethodCallback aVar) {
//            checkReady();
//            word_share_notify_call word_share_notify_call2 = new word_share_notify_call(i, i2, aVar, this, this.___protocolFactory, this.___transport);
//            this.___currentMethod = word_share_notify_call2;
//            this.___manager.mo18472a((TAsyncMethodCall) word_share_notify_call2);
//        }
//
//        public void word_share_notify_v2(int i, int i2, int i3, AsyncMethodCallback aVar) {
//            checkReady();
//            word_share_notify_v2_call word_share_notify_v2_call2 = new word_share_notify_v2_call(i, i2, i3, aVar, this, this.___protocolFactory, this.___transport);
//            this.___currentMethod = word_share_notify_v2_call2;
//            this.___manager.mo18472a((TAsyncMethodCall) word_share_notify_v2_call2);
//        }
//
//        public void word_search(String str, AsyncMethodCallback aVar) {
//            checkReady();
//            word_search_call word_search_call2 = new word_search_call(str, aVar, this, this.___protocolFactory, this.___transport);
//            this.___currentMethod = word_search_call2;
//            this.___manager.mo18472a((TAsyncMethodCall) word_search_call2);
//        }
//
//        public void update_online_topic(int i, int i2, int i3, int i4, String str, AsyncMethodCallback aVar) {
//            checkReady();
//            update_online_topic_call update_online_topic_call2 = new update_online_topic_call(i, i2, i3, i4, str, aVar, this, this.___protocolFactory, this.___transport);
//            this.___currentMethod = update_online_topic_call2;
//            this.___manager.mo18472a((TAsyncMethodCall) update_online_topic_call2);
//        }
//
//        public void get_similar_words_info(int i, List<Integer> list, AsyncMethodCallback aVar) {
//            checkReady();
//            get_similar_words_info_call get_similar_words_info_call2 = new get_similar_words_info_call(i, list, aVar, this, this.___protocolFactory, this.___transport);
//            this.___currentMethod = get_similar_words_info_call2;
//            this.___manager.mo18472a((TAsyncMethodCall) get_similar_words_info_call2);
//        }
//
//        public void get_word_assets_info_by_topic_and_book_id(List<BBGetWordAssetInfoArg> list, AsyncMethodCallback aVar) {
//            checkReady();
//            get_word_assets_info_by_topic_and_book_id_call get_word_assets_info_by_topic_and_book_id_call2 = new get_word_assets_info_by_topic_and_book_id_call(list, aVar, this, this.___protocolFactory, this.___transport);
//            this.___currentMethod = get_word_assets_info_by_topic_and_book_id_call2;
//            this.___manager.mo18472a((TAsyncMethodCall) get_word_assets_info_by_topic_and_book_id_call2);
//        }
//
//        public void similar_words_vote(int i, List<BBSimilarWordVote> list, AsyncMethodCallback aVar) {
//            checkReady();
//            similar_words_vote_call similar_words_vote_call2 = new similar_words_vote_call(i, list, aVar, this, this.___protocolFactory, this.___transport);
//            this.___currentMethod = similar_words_vote_call2;
//            this.___manager.mo18472a((TAsyncMethodCall) similar_words_vote_call2);
//        }
//
//        public void get_search_word_package(int i, int i2, AsyncMethodCallback aVar) {
//            checkReady();
//            get_search_word_package_call get_search_word_package_call2 = new get_search_word_package_call(i, i2, aVar, this, this.___protocolFactory, this.___transport);
//            this.___currentMethod = get_search_word_package_call2;
//            this.___manager.mo18472a((TAsyncMethodCall) get_search_word_package_call2);
//        }
//    }
//
//    public interface AsyncIface {
//        void get_search_word_package(int i, int i2, AsyncMethodCallback aVar);
//
//        void get_similar_words_info(int i, List<Integer> list, AsyncMethodCallback aVar);
//
//        void get_word_asset_pack_info(int i, AsyncMethodCallback aVar);
//
//        void get_word_assets_info_by_topic_and_book_id(List<BBGetWordAssetInfoArg> list, AsyncMethodCallback aVar);
//
//        void get_word_media_halftime_list(AsyncMethodCallback aVar);
//
//        void get_word_media_update_info(int i, AsyncMethodCallback aVar);
//
//        void get_word_package(List<Integer> list, int i, AsyncMethodCallback aVar);
//
//        void get_word_share_info(int i, int i2, AsyncMethodCallback aVar);
//
//        void get_word_share_info_v2(int i, int i2, int i3, AsyncMethodCallback aVar);
//
//        void get_word_topic_assets(int i, List<Integer> list, AsyncMethodCallback aVar);
//
//        void get_word_topic_assets_v2(int i, List<Integer> list, AsyncMethodCallback aVar);
//
//        void similar_words_vote(int i, List<BBSimilarWordVote> list, AsyncMethodCallback aVar);
//
//        void update_online_topic(int i, int i2, int i3, int i4, String str, AsyncMethodCallback aVar);
//
//        void word_media_by_topic_ids(List<Integer> list, AsyncMethodCallback aVar);
//
//        void word_media_by_topic_ids_v2(List<Integer> list, AsyncMethodCallback aVar);
//
//        void word_search(String str, AsyncMethodCallback aVar);
//
//        void word_share_notify(int i, int i2, AsyncMethodCallback aVar);
//
//        void word_share_notify_v2(int i, int i2, int i3, AsyncMethodCallback aVar);
//    }
//
//    public class AsyncProcessor<I extends AsyncIface> extends TBaseAsyncProcessor<I> {
//        /* access modifiers changed from: private */
//        public static final Logger LOGGER = LoggerFactory.getLogger(AsyncProcessor.class.getName());
//
//        public class get_search_word_package<I extends AsyncIface> extends AsyncProcessFunction<I, get_search_word_package_args, BBWordPackage> {
//            public get_search_word_package() {
//                super("get_search_word_package");
//            }
//
//            public get_search_word_package_args getEmptyArgsInstance() {
//                return new get_search_word_package_args();
//            }
//
//            public AsyncMethodCallback<BBWordPackage> getResultHandler(final C2113c cVar, final int i) {
//                return new AsyncMethodCallback<BBWordPackage>() {
//                    public void onComplete(BBWordPackage bBWordPackage) {
//                        get_search_word_package_result get_search_word_package_result = new get_search_word_package_result();
//                        get_search_word_package_result.success = bBWordPackage;
//                        try {
//                            this.sendResponse(cVar, get_search_word_package_result, 2, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//
//                    public void onError(Exception exc) {
//                        C2116f fVar;
//                        byte b = 2;
//                        get_search_word_package_result get_search_word_package_result = new get_search_word_package_result();
//                        if (exc instanceof BESystemException) {
//                            get_search_word_package_result.sysException = (BESystemException) exc;
//                            get_search_word_package_result.setSysExceptionIsSet(true);
//                            fVar = get_search_word_package_result;
//                        } else if (exc instanceof BELogicException) {
//                            get_search_word_package_result.logicException = (BELogicException) exc;
//                            get_search_word_package_result.setLogicExceptionIsSet(true);
//                            fVar = get_search_word_package_result;
//                        } else {
//                            fVar = (C2116f) new TApplicationException(6, exc.getMessage());
//                            b = 3;
//                        }
//                        try {
//                            this.sendResponse(cVar, fVar, b, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//                };
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public void start(I i, get_search_word_package_args get_search_word_package_args, AsyncMethodCallback<BBWordPackage> aVar) {
//                i.get_search_word_package(get_search_word_package_args.prefer_word_level_id, get_search_word_package_args.topic_id, aVar);
//            }
//        }
//
//        public class get_similar_words_info<I extends AsyncIface> extends AsyncProcessFunction<I, get_similar_words_info_args, List<BBSimilarWordInfo>> {
//            public get_similar_words_info() {
//                super("get_similar_words_info");
//            }
//
//            public get_similar_words_info_args getEmptyArgsInstance() {
//                return new get_similar_words_info_args();
//            }
//
//            public AsyncMethodCallback<List<BBSimilarWordInfo>> getResultHandler(final C2113c cVar, final int i) {
//                return new AsyncMethodCallback<List<BBSimilarWordInfo>>() {
//                    public void onComplete(List<BBSimilarWordInfo> list) {
//                        get_similar_words_info_result get_similar_words_info_result = new get_similar_words_info_result();
//                        get_similar_words_info_result.success = list;
//                        try {
//                            this.sendResponse(cVar, get_similar_words_info_result, 2, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//
//                    public void onError(Exception exc) {
//                        C2116f fVar;
//                        byte b = 2;
//                        get_similar_words_info_result get_similar_words_info_result = new get_similar_words_info_result();
//                        if (exc instanceof BESystemException) {
//                            get_similar_words_info_result.sysException = (BESystemException) exc;
//                            get_similar_words_info_result.setSysExceptionIsSet(true);
//                            fVar = get_similar_words_info_result;
//                        } else {
//                            fVar = (C2116f) new TApplicationException(6, exc.getMessage());
//                            b = 3;
//                        }
//                        try {
//                            this.sendResponse(cVar, fVar, b, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//                };
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public void start(I i, get_similar_words_info_args get_similar_words_info_args, AsyncMethodCallback<List<BBSimilarWordInfo>> aVar) {
//                i.get_similar_words_info(get_similar_words_info_args.book_id, get_similar_words_info_args.arr_topic_ids, aVar);
//            }
//        }
//
//        public class get_word_asset_pack_info<I extends AsyncIface> extends AsyncProcessFunction<I, get_word_asset_pack_info_args, List<BBWordAssetPackInfo>> {
//            public get_word_asset_pack_info() {
//                super("get_word_asset_pack_info");
//            }
//
//            public get_word_asset_pack_info_args getEmptyArgsInstance() {
//                return new get_word_asset_pack_info_args();
//            }
//
//            public AsyncMethodCallback<List<BBWordAssetPackInfo>> getResultHandler(final C2113c cVar, final int i) {
//                return new AsyncMethodCallback<List<BBWordAssetPackInfo>>() {
//                    public void onComplete(List<BBWordAssetPackInfo> list) {
//                        get_word_asset_pack_info_result get_word_asset_pack_info_result = new get_word_asset_pack_info_result();
//                        get_word_asset_pack_info_result.success = list;
//                        try {
//                            this.sendResponse(cVar, get_word_asset_pack_info_result, 2, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//
//                    public void onError(Exception exc) {
//                        C2116f fVar;
//                        byte b = 2;
//                        get_word_asset_pack_info_result get_word_asset_pack_info_result = new get_word_asset_pack_info_result();
//                        if (exc instanceof BESystemException) {
//                            get_word_asset_pack_info_result.sysException = (BESystemException) exc;
//                            get_word_asset_pack_info_result.setSysExceptionIsSet(true);
//                            fVar = get_word_asset_pack_info_result;
//                        } else if (exc instanceof BELogicException) {
//                            get_word_asset_pack_info_result.logicException = (BELogicException) exc;
//                            get_word_asset_pack_info_result.setLogicExceptionIsSet(true);
//                            fVar = get_word_asset_pack_info_result;
//                        } else {
//                            fVar = (C2116f) new TApplicationException(6, exc.getMessage());
//                            b = 3;
//                        }
//                        try {
//                            this.sendResponse(cVar, fVar, b, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//                };
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public void start(I i, get_word_asset_pack_info_args get_word_asset_pack_info_args, AsyncMethodCallback<List<BBWordAssetPackInfo>> aVar) {
//                i.get_word_asset_pack_info(get_word_asset_pack_info_args.word_level_id, aVar);
//            }
//        }
//
//        public class get_word_assets_info_by_topic_and_book_id<I extends AsyncIface> extends AsyncProcessFunction<I, get_word_assets_info_by_topic_and_book_id_args, List<BBGetWordAssetInfoResult>> {
//            public get_word_assets_info_by_topic_and_book_id() {
//                super("get_word_assets_info_by_topic_and_book_id");
//            }
//
//            public get_word_assets_info_by_topic_and_book_id_args getEmptyArgsInstance() {
//                return new get_word_assets_info_by_topic_and_book_id_args();
//            }
//
//            public AsyncMethodCallback<List<BBGetWordAssetInfoResult>> getResultHandler(final C2113c cVar, final int i) {
//                return new AsyncMethodCallback<List<BBGetWordAssetInfoResult>>() {
//                    public void onComplete(List<BBGetWordAssetInfoResult> list) {
//                        get_word_assets_info_by_topic_and_book_id_result get_word_assets_info_by_topic_and_book_id_result = new get_word_assets_info_by_topic_and_book_id_result();
//                        get_word_assets_info_by_topic_and_book_id_result.success = list;
//                        try {
//                            this.sendResponse(cVar, get_word_assets_info_by_topic_and_book_id_result, 2, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//
//                    public void onError(Exception exc) {
//                        C2116f fVar;
//                        byte b = 2;
//                        get_word_assets_info_by_topic_and_book_id_result get_word_assets_info_by_topic_and_book_id_result = new get_word_assets_info_by_topic_and_book_id_result();
//                        if (exc instanceof BESystemException) {
//                            get_word_assets_info_by_topic_and_book_id_result.sysException = (BESystemException) exc;
//                            get_word_assets_info_by_topic_and_book_id_result.setSysExceptionIsSet(true);
//                            fVar = get_word_assets_info_by_topic_and_book_id_result;
//                        } else {
//                            fVar = (C2116f) new TApplicationException(6, exc.getMessage());
//                            b = 3;
//                        }
//                        try {
//                            this.sendResponse(cVar, fVar, b, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//                };
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public void start(I i, get_word_assets_info_by_topic_and_book_id_args get_word_assets_info_by_topic_and_book_id_args, AsyncMethodCallback<List<BBGetWordAssetInfoResult>> aVar) {
//                i.get_word_assets_info_by_topic_and_book_id(get_word_assets_info_by_topic_and_book_id_args.arr_topic_and_book_ids, aVar);
//            }
//        }
//
//        public class get_word_media_halftime_list<I extends AsyncIface> extends AsyncProcessFunction<I, get_word_media_halftime_list_args, BBWordMediaHalftimeList> {
//            public get_word_media_halftime_list() {
//                super("get_word_media_halftime_list");
//            }
//
//            public get_word_media_halftime_list_args getEmptyArgsInstance() {
//                return new get_word_media_halftime_list_args();
//            }
//
//            public AsyncMethodCallback<BBWordMediaHalftimeList> getResultHandler(final C2113c cVar, final int i) {
//                return new AsyncMethodCallback<BBWordMediaHalftimeList>() {
//                    public void onComplete(BBWordMediaHalftimeList bBWordMediaHalftimeList) {
//                        get_word_media_halftime_list_result get_word_media_halftime_list_result = new get_word_media_halftime_list_result();
//                        get_word_media_halftime_list_result.success = bBWordMediaHalftimeList;
//                        try {
//                            this.sendResponse(cVar, get_word_media_halftime_list_result, 2, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//
//                    public void onError(Exception exc) {
//                        C2116f fVar;
//                        byte b = 2;
//                        get_word_media_halftime_list_result get_word_media_halftime_list_result = new get_word_media_halftime_list_result();
//                        if (exc instanceof BESystemException) {
//                            get_word_media_halftime_list_result.sysException = (BESystemException) exc;
//                            get_word_media_halftime_list_result.setSysExceptionIsSet(true);
//                            fVar = get_word_media_halftime_list_result;
//                        } else {
//                            fVar = (C2116f) new TApplicationException(6, exc.getMessage());
//                            b = 3;
//                        }
//                        try {
//                            this.sendResponse(cVar, fVar, b, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//                };
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public void start(I i, get_word_media_halftime_list_args get_word_media_halftime_list_args, AsyncMethodCallback<BBWordMediaHalftimeList> aVar) {
//                i.get_word_media_halftime_list(aVar);
//            }
//        }
//
//        public class get_word_media_update_info<I extends AsyncIface> extends AsyncProcessFunction<I, get_word_media_update_info_args, List<BBWordMediaUpdateInfo>> {
//            public get_word_media_update_info() {
//                super("get_word_media_update_info");
//            }
//
//            public get_word_media_update_info_args getEmptyArgsInstance() {
//                return new get_word_media_update_info_args();
//            }
//
//            public AsyncMethodCallback<List<BBWordMediaUpdateInfo>> getResultHandler(final C2113c cVar, final int i) {
//                return new AsyncMethodCallback<List<BBWordMediaUpdateInfo>>() {
//                    public void onComplete(List<BBWordMediaUpdateInfo> list) {
//                        get_word_media_update_info_result get_word_media_update_info_result = new get_word_media_update_info_result();
//                        get_word_media_update_info_result.success = list;
//                        try {
//                            this.sendResponse(cVar, get_word_media_update_info_result, 2, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//
//                    public void onError(Exception exc) {
//                        C2116f fVar;
//                        byte b = 2;
//                        get_word_media_update_info_result get_word_media_update_info_result = new get_word_media_update_info_result();
//                        if (exc instanceof BESystemException) {
//                            get_word_media_update_info_result.sysException = (BESystemException) exc;
//                            get_word_media_update_info_result.setSysExceptionIsSet(true);
//                            fVar = get_word_media_update_info_result;
//                        } else {
//                            fVar = (C2116f) new TApplicationException(6, exc.getMessage());
//                            b = 3;
//                        }
//                        try {
//                            this.sendResponse(cVar, fVar, b, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//                };
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public void start(I i, get_word_media_update_info_args get_word_media_update_info_args, AsyncMethodCallback<List<BBWordMediaUpdateInfo>> aVar) {
//                i.get_word_media_update_info(get_word_media_update_info_args.book_id, aVar);
//            }
//        }
//
//        public class get_word_package<I extends AsyncIface> extends AsyncProcessFunction<I, get_word_package_args, List<BBWordPackage>> {
//            public get_word_package() {
//                super("get_word_package");
//            }
//
//            public get_word_package_args getEmptyArgsInstance() {
//                return new get_word_package_args();
//            }
//
//            public AsyncMethodCallback<List<BBWordPackage>> getResultHandler(final C2113c cVar, final int i) {
//                return new AsyncMethodCallback<List<BBWordPackage>>() {
//                    public void onComplete(List<BBWordPackage> list) {
//                        get_word_package_result get_word_package_result = new get_word_package_result();
//                        get_word_package_result.success = list;
//                        try {
//                            this.sendResponse(cVar, get_word_package_result, 2, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//
//                    public void onError(Exception exc) {
//                        C2116f fVar;
//                        byte b = 2;
//                        get_word_package_result get_word_package_result = new get_word_package_result();
//                        if (exc instanceof BESystemException) {
//                            get_word_package_result.sysException = (BESystemException) exc;
//                            get_word_package_result.setSysExceptionIsSet(true);
//                            fVar = get_word_package_result;
//                        } else if (exc instanceof BELogicException) {
//                            get_word_package_result.logicException = (BELogicException) exc;
//                            get_word_package_result.setLogicExceptionIsSet(true);
//                            fVar = get_word_package_result;
//                        } else {
//                            fVar = (C2116f) new TApplicationException(6, exc.getMessage());
//                            b = 3;
//                        }
//                        try {
//                            this.sendResponse(cVar, fVar, b, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//                };
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public void start(I i, get_word_package_args get_word_package_args, AsyncMethodCallback<List<BBWordPackage>> aVar) {
//                i.get_word_package(get_word_package_args.topic_ids, get_word_package_args.word_level_id, aVar);
//            }
//        }
//
//        public class get_word_share_info<I extends AsyncIface> extends AsyncProcessFunction<I, get_word_share_info_args, BBWordShareInfo> {
//            public get_word_share_info() {
//                super("get_word_share_info");
//            }
//
//            public get_word_share_info_args getEmptyArgsInstance() {
//                return new get_word_share_info_args();
//            }
//
//            public AsyncMethodCallback<BBWordShareInfo> getResultHandler(final C2113c cVar, final int i) {
//                return new AsyncMethodCallback<BBWordShareInfo>() {
//                    public void onComplete(BBWordShareInfo bBWordShareInfo) {
//                        get_word_share_info_result get_word_share_info_result = new get_word_share_info_result();
//                        get_word_share_info_result.success = bBWordShareInfo;
//                        try {
//                            this.sendResponse(cVar, get_word_share_info_result, 2, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//
//                    public void onError(Exception exc) {
//                        C2116f fVar;
//                        byte b = 2;
//                        get_word_share_info_result get_word_share_info_result = new get_word_share_info_result();
//                        if (exc instanceof BESystemException) {
//                            get_word_share_info_result.sysException = (BESystemException) exc;
//                            get_word_share_info_result.setSysExceptionIsSet(true);
//                            fVar = get_word_share_info_result;
//                        } else if (exc instanceof BELogicException) {
//                            get_word_share_info_result.logicException = (BELogicException) exc;
//                            get_word_share_info_result.setLogicExceptionIsSet(true);
//                            fVar = get_word_share_info_result;
//                        } else {
//                            fVar = (C2116f) new TApplicationException(6, exc.getMessage());
//                            b = 3;
//                        }
//                        try {
//                            this.sendResponse(cVar, fVar, b, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//                };
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public void start(I i, get_word_share_info_args get_word_share_info_args, AsyncMethodCallback<BBWordShareInfo> aVar) {
//                i.get_word_share_info(get_word_share_info_args.topic_id, get_word_share_info_args.book_id, aVar);
//            }
//        }
//
//        public class get_word_share_info_v2<I extends AsyncIface> extends AsyncProcessFunction<I, get_word_share_info_v2_args, BBWordShareInfo> {
//            public get_word_share_info_v2() {
//                super("get_word_share_info_v2");
//            }
//
//            public get_word_share_info_v2_args getEmptyArgsInstance() {
//                return new get_word_share_info_v2_args();
//            }
//
//            public AsyncMethodCallback<BBWordShareInfo> getResultHandler(final C2113c cVar, final int i) {
//                return new AsyncMethodCallback<BBWordShareInfo>() {
//                    public void onComplete(BBWordShareInfo bBWordShareInfo) {
//                        get_word_share_info_v2_result get_word_share_info_v2_result = new get_word_share_info_v2_result();
//                        get_word_share_info_v2_result.success = bBWordShareInfo;
//                        try {
//                            this.sendResponse(cVar, get_word_share_info_v2_result, 2, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//
//                    public void onError(Exception exc) {
//                        C2116f fVar;
//                        byte b = 2;
//                        get_word_share_info_v2_result get_word_share_info_v2_result = new get_word_share_info_v2_result();
//                        if (exc instanceof BESystemException) {
//                            get_word_share_info_v2_result.sysException = (BESystemException) exc;
//                            get_word_share_info_v2_result.setSysExceptionIsSet(true);
//                            fVar = get_word_share_info_v2_result;
//                        } else if (exc instanceof BELogicException) {
//                            get_word_share_info_v2_result.logicException = (BELogicException) exc;
//                            get_word_share_info_v2_result.setLogicExceptionIsSet(true);
//                            fVar = get_word_share_info_v2_result;
//                        } else {
//                            fVar = (C2116f) new TApplicationException(6, exc.getMessage());
//                            b = 3;
//                        }
//                        try {
//                            this.sendResponse(cVar, fVar, b, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//                };
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public void start(I i, get_word_share_info_v2_args get_word_share_info_v2_args, AsyncMethodCallback<BBWordShareInfo> aVar) {
//                i.get_word_share_info_v2(get_word_share_info_v2_args.topic_id, get_word_share_info_v2_args.book_id, get_word_share_info_v2_args.tag_id, aVar);
//            }
//        }
//
//        public class get_word_topic_assets<I extends AsyncIface> extends AsyncProcessFunction<I, get_word_topic_assets_args, List<BBTopicAsset>> {
//            public get_word_topic_assets() {
//                super("get_word_topic_assets");
//            }
//
//            public get_word_topic_assets_args getEmptyArgsInstance() {
//                return new get_word_topic_assets_args();
//            }
//
//            public AsyncMethodCallback<List<BBTopicAsset>> getResultHandler(final C2113c cVar, final int i) {
//                return new AsyncMethodCallback<List<BBTopicAsset>>() {
//                    public void onComplete(List<BBTopicAsset> list) {
//                        get_word_topic_assets_result get_word_topic_assets_result = new get_word_topic_assets_result();
//                        get_word_topic_assets_result.success = list;
//                        try {
//                            this.sendResponse(cVar, get_word_topic_assets_result, 2, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//
//                    public void onError(Exception exc) {
//                        C2116f fVar;
//                        byte b = 2;
//                        get_word_topic_assets_result get_word_topic_assets_result = new get_word_topic_assets_result();
//                        if (exc instanceof BESystemException) {
//                            get_word_topic_assets_result.sysException = (BESystemException) exc;
//                            get_word_topic_assets_result.setSysExceptionIsSet(true);
//                            fVar = get_word_topic_assets_result;
//                        } else {
//                            fVar = (C2116f) new TApplicationException(6, exc.getMessage());
//                            b = 3;
//                        }
//                        try {
//                            this.sendResponse(cVar, fVar, b, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//                };
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public void start(I i, get_word_topic_assets_args get_word_topic_assets_args, AsyncMethodCallback<List<BBTopicAsset>> aVar) {
//                i.get_word_topic_assets(get_word_topic_assets_args.word_level_id, get_word_topic_assets_args.topic_ids, aVar);
//            }
//        }
//
//        public class get_word_topic_assets_v2<I extends AsyncIface> extends AsyncProcessFunction<I, get_word_topic_assets_v2_args, List<BBTopicAssetV2>> {
//            public get_word_topic_assets_v2() {
//                super("get_word_topic_assets_v2");
//            }
//
//            public get_word_topic_assets_v2_args getEmptyArgsInstance() {
//                return new get_word_topic_assets_v2_args();
//            }
//
//            public AsyncMethodCallback<List<BBTopicAssetV2>> getResultHandler(final C2113c cVar, final int i) {
//                return new AsyncMethodCallback<List<BBTopicAssetV2>>() {
//                    public void onComplete(List<BBTopicAssetV2> list) {
//                        get_word_topic_assets_v2_result get_word_topic_assets_v2_result = new get_word_topic_assets_v2_result();
//                        get_word_topic_assets_v2_result.success = list;
//                        try {
//                            this.sendResponse(cVar, get_word_topic_assets_v2_result, 2, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//
//                    public void onError(Exception exc) {
//                        C2116f fVar;
//                        byte b = 2;
//                        get_word_topic_assets_v2_result get_word_topic_assets_v2_result = new get_word_topic_assets_v2_result();
//                        if (exc instanceof BESystemException) {
//                            get_word_topic_assets_v2_result.sysException = (BESystemException) exc;
//                            get_word_topic_assets_v2_result.setSysExceptionIsSet(true);
//                            fVar = get_word_topic_assets_v2_result;
//                        } else {
//                            fVar = (C2116f) new TApplicationException(6, exc.getMessage());
//                            b = 3;
//                        }
//                        try {
//                            this.sendResponse(cVar, fVar, b, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//                };
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public void start(I i, get_word_topic_assets_v2_args get_word_topic_assets_v2_args, AsyncMethodCallback<List<BBTopicAssetV2>> aVar) {
//                i.get_word_topic_assets_v2(get_word_topic_assets_v2_args.word_level_id, get_word_topic_assets_v2_args.topic_ids, aVar);
//            }
//        }
//
//        public class similar_words_vote<I extends AsyncIface> extends AsyncProcessFunction<I, similar_words_vote_args, Integer> {
//            public similar_words_vote() {
//                super("similar_words_vote");
//            }
//
//            public similar_words_vote_args getEmptyArgsInstance() {
//                return new similar_words_vote_args();
//            }
//
//            public AsyncMethodCallback<Integer> getResultHandler(final C2113c cVar, final int i) {
//                return new AsyncMethodCallback<Integer>() {
//                    public void onComplete(Integer num) {
//                        similar_words_vote_result similar_words_vote_result = new similar_words_vote_result();
//                        similar_words_vote_result.success = num.intValue();
//                        similar_words_vote_result.setSuccessIsSet(true);
//                        try {
//                            this.sendResponse(cVar, similar_words_vote_result, 2, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//
//                    public void onError(Exception exc) {
//                        C2116f fVar;
//                        byte b = 2;
//                        similar_words_vote_result similar_words_vote_result = new similar_words_vote_result();
//                        if (exc instanceof BESystemException) {
//                            similar_words_vote_result.sysException = (BESystemException) exc;
//                            similar_words_vote_result.setSysExceptionIsSet(true);
//                            fVar = similar_words_vote_result;
//                        } else {
//                            fVar = (C2116f) new TApplicationException(6, exc.getMessage());
//                            b = 3;
//                        }
//                        try {
//                            this.sendResponse(cVar, fVar, b, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//                };
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public void start(I i, similar_words_vote_args similar_words_vote_args, AsyncMethodCallback<Integer> aVar) {
//                i.similar_words_vote(similar_words_vote_args.book_id, similar_words_vote_args.similar_words_votes, aVar);
//            }
//        }
//
//        public class update_online_topic<I extends AsyncIface> extends AsyncProcessFunction<I, update_online_topic_args, Integer> {
//            public update_online_topic() {
//                super("update_online_topic");
//            }
//
//            public update_online_topic_args getEmptyArgsInstance() {
//                return new update_online_topic_args();
//            }
//
//            public AsyncMethodCallback<Integer> getResultHandler(final C2113c cVar, final int i) {
//                return new AsyncMethodCallback<Integer>() {
//                    public void onComplete(Integer num) {
//                        update_online_topic_result update_online_topic_result = new update_online_topic_result();
//                        update_online_topic_result.success = num.intValue();
//                        update_online_topic_result.setSuccessIsSet(true);
//                        try {
//                            this.sendResponse(cVar, update_online_topic_result, 2, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//
//                    public void onError(Exception exc) {
//                        C2116f fVar;
//                        byte b = 2;
//                        update_online_topic_result update_online_topic_result = new update_online_topic_result();
//                        if (exc instanceof BESystemException) {
//                            update_online_topic_result.sysException = (BESystemException) exc;
//                            update_online_topic_result.setSysExceptionIsSet(true);
//                            fVar = update_online_topic_result;
//                        } else if (exc instanceof BELogicException) {
//                            update_online_topic_result.logicException = (BELogicException) exc;
//                            update_online_topic_result.setLogicExceptionIsSet(true);
//                            fVar = update_online_topic_result;
//                        } else {
//                            fVar = (C2116f) new TApplicationException(6, exc.getMessage());
//                            b = 3;
//                        }
//                        try {
//                            this.sendResponse(cVar, fVar, b, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//                };
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public void start(I i, update_online_topic_args update_online_topic_args, AsyncMethodCallback<Integer> aVar) {
//                i.update_online_topic(update_online_topic_args.topic_id, update_online_topic_args.word_level_id, update_online_topic_args.tag_id, update_online_topic_args.version, update_online_topic_args.signed_key, aVar);
//            }
//        }
//
//        public class word_media_by_topic_ids<I extends AsyncIface> extends AsyncProcessFunction<I, word_media_by_topic_ids_args, List<BBWordMedia>> {
//            public word_media_by_topic_ids() {
//                super("word_media_by_topic_ids");
//            }
//
//            public word_media_by_topic_ids_args getEmptyArgsInstance() {
//                return new word_media_by_topic_ids_args();
//            }
//
//            public AsyncMethodCallback<List<BBWordMedia>> getResultHandler(final C2113c cVar, final int i) {
//                return new AsyncMethodCallback<List<BBWordMedia>>() {
//                    public void onComplete(List<BBWordMedia> list) {
//                        word_media_by_topic_ids_result word_media_by_topic_ids_result = new word_media_by_topic_ids_result();
//                        word_media_by_topic_ids_result.success = list;
//                        try {
//                            this.sendResponse(cVar, word_media_by_topic_ids_result, 2, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//
//                    public void onError(Exception exc) {
//                        C2116f fVar;
//                        byte b = 2;
//                        word_media_by_topic_ids_result word_media_by_topic_ids_result = new word_media_by_topic_ids_result();
//                        if (exc instanceof BESystemException) {
//                            word_media_by_topic_ids_result.sysException = (BESystemException) exc;
//                            word_media_by_topic_ids_result.setSysExceptionIsSet(true);
//                            fVar = word_media_by_topic_ids_result;
//                        } else {
//                            fVar = (C2116f) new TApplicationException(6, exc.getMessage());
//                            b = 3;
//                        }
//                        try {
//                            this.sendResponse(cVar, fVar, b, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//                };
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public void start(I i, word_media_by_topic_ids_args word_media_by_topic_ids_args, AsyncMethodCallback<List<BBWordMedia>> aVar) {
//                i.word_media_by_topic_ids(word_media_by_topic_ids_args.topic_ids, aVar);
//            }
//        }
//
//        public class word_media_by_topic_ids_v2<I extends AsyncIface> extends AsyncProcessFunction<I, word_media_by_topic_ids_v2_args, List<BBWordMediaV2>> {
//            public word_media_by_topic_ids_v2() {
//                super("word_media_by_topic_ids_v2");
//            }
//
//            public word_media_by_topic_ids_v2_args getEmptyArgsInstance() {
//                return new word_media_by_topic_ids_v2_args();
//            }
//
//            public AsyncMethodCallback<List<BBWordMediaV2>> getResultHandler(final C2113c cVar, final int i) {
//                return new AsyncMethodCallback<List<BBWordMediaV2>>() {
//                    public void onComplete(List<BBWordMediaV2> list) {
//                        word_media_by_topic_ids_v2_result word_media_by_topic_ids_v2_result = new word_media_by_topic_ids_v2_result();
//                        word_media_by_topic_ids_v2_result.success = list;
//                        try {
//                            this.sendResponse(cVar, word_media_by_topic_ids_v2_result, 2, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//
//                    public void onError(Exception exc) {
//                        C2116f fVar;
//                        byte b = 2;
//                        word_media_by_topic_ids_v2_result word_media_by_topic_ids_v2_result = new word_media_by_topic_ids_v2_result();
//                        if (exc instanceof BESystemException) {
//                            word_media_by_topic_ids_v2_result.sysException = (BESystemException) exc;
//                            word_media_by_topic_ids_v2_result.setSysExceptionIsSet(true);
//                            fVar = word_media_by_topic_ids_v2_result;
//                        } else {
//                            fVar = (C2116f) new TApplicationException(6, exc.getMessage());
//                            b = 3;
//                        }
//                        try {
//                            this.sendResponse(cVar, fVar, b, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//                };
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public void start(I i, word_media_by_topic_ids_v2_args word_media_by_topic_ids_v2_args, AsyncMethodCallback<List<BBWordMediaV2>> aVar) {
//                i.word_media_by_topic_ids_v2(word_media_by_topic_ids_v2_args.topic_ids, aVar);
//            }
//        }
//
//        /* renamed from: com.baicizhan.online.bs_words.BSWords$AsyncProcessor$word_search */
//        public class C1377word_search<I extends AsyncIface> extends AsyncProcessFunction<I, word_search_args, List<BBWordSearchResult>> {
//            public C1377word_search() {
//                super("word_search");
//            }
//
//            public word_search_args getEmptyArgsInstance() {
//                return new word_search_args();
//            }
//
//            public AsyncMethodCallback<List<BBWordSearchResult>> getResultHandler(final C2113c cVar, final int i) {
//                return new AsyncMethodCallback<List<BBWordSearchResult>>() {
//                    public void onComplete(List<BBWordSearchResult> list) {
//                        word_search_result word_search_result = new word_search_result();
//                        word_search_result.success = list;
//                        try {
//                            this.sendResponse(cVar, word_search_result, 2, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//
//                    public void onError(Exception exc) {
//                        C2116f fVar;
//                        byte b = 2;
//                        word_search_result word_search_result = new word_search_result();
//                        if (exc instanceof BESystemException) {
//                            word_search_result.sysException = (BESystemException) exc;
//                            word_search_result.setSysExceptionIsSet(true);
//                            fVar = word_search_result;
//                        } else if (exc instanceof BELogicException) {
//                            word_search_result.logicException = (BELogicException) exc;
//                            word_search_result.setLogicExceptionIsSet(true);
//                            fVar = word_search_result;
//                        } else {
//                            fVar = (C2116f) new TApplicationException(6, exc.getMessage());
//                            b = 3;
//                        }
//                        try {
//                            this.sendResponse(cVar, fVar, b, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//                };
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public void start(I i, word_search_args word_search_args, AsyncMethodCallback<List<BBWordSearchResult>> aVar) {
//                i.word_search(word_search_args.query_str, aVar);
//            }
//        }
//
//        public class word_share_notify<I extends AsyncIface> extends AsyncProcessFunction<I, word_share_notify_args, Integer> {
//            public word_share_notify() {
//                super("word_share_notify");
//            }
//
//            public word_share_notify_args getEmptyArgsInstance() {
//                return new word_share_notify_args();
//            }
//
//            public AsyncMethodCallback<Integer> getResultHandler(final C2113c cVar, final int i) {
//                return new AsyncMethodCallback<Integer>() {
//                    public void onComplete(Integer num) {
//                        word_share_notify_result word_share_notify_result = new word_share_notify_result();
//                        word_share_notify_result.success = num.intValue();
//                        word_share_notify_result.setSuccessIsSet(true);
//                        try {
//                            this.sendResponse(cVar, word_share_notify_result, 2, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//
//                    public void onError(Exception exc) {
//                        C2116f fVar;
//                        byte b = 2;
//                        word_share_notify_result word_share_notify_result = new word_share_notify_result();
//                        if (exc instanceof BESystemException) {
//                            word_share_notify_result.sysException = (BESystemException) exc;
//                            word_share_notify_result.setSysExceptionIsSet(true);
//                            fVar = word_share_notify_result;
//                        } else if (exc instanceof BELogicException) {
//                            word_share_notify_result.logicException = (BELogicException) exc;
//                            word_share_notify_result.setLogicExceptionIsSet(true);
//                            fVar = word_share_notify_result;
//                        } else {
//                            fVar = (C2116f) new TApplicationException(6, exc.getMessage());
//                            b = 3;
//                        }
//                        try {
//                            this.sendResponse(cVar, fVar, b, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//                };
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public void start(I i, word_share_notify_args word_share_notify_args, AsyncMethodCallback<Integer> aVar) {
//                i.word_share_notify(word_share_notify_args.topic_id, word_share_notify_args.book_id, aVar);
//            }
//        }
//
//        public class word_share_notify_v2<I extends AsyncIface> extends AsyncProcessFunction<I, word_share_notify_v2_args, Integer> {
//            public word_share_notify_v2() {
//                super("word_share_notify_v2");
//            }
//
//            public word_share_notify_v2_args getEmptyArgsInstance() {
//                return new word_share_notify_v2_args();
//            }
//
//            public AsyncMethodCallback<Integer> getResultHandler(final C2113c cVar, final int i) {
//                return new AsyncMethodCallback<Integer>() {
//                    public void onComplete(Integer num) {
//                        word_share_notify_v2_result word_share_notify_v2_result = new word_share_notify_v2_result();
//                        word_share_notify_v2_result.success = num.intValue();
//                        word_share_notify_v2_result.setSuccessIsSet(true);
//                        try {
//                            this.sendResponse(cVar, word_share_notify_v2_result, 2, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//
//                    public void onError(Exception exc) {
//                        C2116f fVar;
//                        byte b = 2;
//                        word_share_notify_v2_result word_share_notify_v2_result = new word_share_notify_v2_result();
//                        if (exc instanceof BESystemException) {
//                            word_share_notify_v2_result.sysException = (BESystemException) exc;
//                            word_share_notify_v2_result.setSysExceptionIsSet(true);
//                            fVar = word_share_notify_v2_result;
//                        } else if (exc instanceof BELogicException) {
//                            word_share_notify_v2_result.logicException = (BELogicException) exc;
//                            word_share_notify_v2_result.setLogicExceptionIsSet(true);
//                            fVar = word_share_notify_v2_result;
//                        } else {
//                            fVar = (C2116f) new TApplicationException(6, exc.getMessage());
//                            b = 3;
//                        }
//                        try {
//                            this.sendResponse(cVar, fVar, b, i);
//                        } catch (Exception e) {
//                            AsyncProcessor.LOGGER.error("Exception writing to internal frame buffer", (Throwable) e);
//                            cVar.mo18536c();
//                        }
//                    }
//                };
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public void start(I i, word_share_notify_v2_args word_share_notify_v2_args, AsyncMethodCallback<Integer> aVar) {
//                i.word_share_notify_v2(word_share_notify_v2_args.topic_id, word_share_notify_v2_args.book_id, word_share_notify_v2_args.tag_id, aVar);
//            }
//        }
//
//        public AsyncProcessor(I i) {
//            super(i, getProcessMap(new HashMap()));
//        }
//
//        protected AsyncProcessor(I i, Map<String, AsyncProcessFunction<I, ? extends C2116f, ?>> map) {
//            super(i, getProcessMap(map));
//        }
//
//        private static <I extends AsyncIface> Map<String, AsyncProcessFunction<I, ? extends C2116f, ?>> getProcessMap(Map<String, AsyncProcessFunction<I, ? extends C2116f, ?>> map) {
//            map.put("get_word_topic_assets", new get_word_topic_assets());
//            map.put("get_word_topic_assets_v2", new get_word_topic_assets_v2());
//            map.put("word_media_by_topic_ids", new word_media_by_topic_ids());
//            map.put("word_media_by_topic_ids_v2", new word_media_by_topic_ids_v2());
//            map.put("get_word_media_update_info", new get_word_media_update_info());
//            map.put("get_word_media_halftime_list", new get_word_media_halftime_list());
//            map.put("get_word_asset_pack_info", new get_word_asset_pack_info());
//            map.put("get_word_package", new get_word_package());
//            map.put("get_word_share_info", new get_word_share_info());
//            map.put("get_word_share_info_v2", new get_word_share_info_v2());
//            map.put("word_share_notify", new word_share_notify());
//            map.put("word_share_notify_v2", new word_share_notify_v2());
//            map.put("word_search", new C1377word_search());
//            map.put("update_online_topic", new update_online_topic());
//            map.put("get_similar_words_info", new get_similar_words_info());
//            map.put("get_word_assets_info_by_topic_and_book_id", new get_word_assets_info_by_topic_and_book_id());
//            map.put("similar_words_vote", new similar_words_vote());
//            map.put("get_search_word_package", new get_search_word_package());
//            return map;
//        }
//    }
//
//    public class Client extends TServiceClient implements Iface {
//
//        public class Factory implements TServiceClientFactory<Client> {
//            public Client getClient(C2100f fVar) {
//                return new Client(fVar);
//            }
//
//            public Client getClient(C2100f fVar, C2100f fVar2) {
//                return new Client(fVar, fVar2);
//            }
//        }
//
//        public Client(C2100f fVar) {
//            super(fVar, fVar);
//        }
//
//        public Client(C2100f fVar, C2100f fVar2) {
//            super(fVar, fVar2);
//        }
//
//        public List<BBTopicAsset> get_word_topic_assets(int i, List<Integer> list) {
//            send_get_word_topic_assets(i, list);
//            return recv_get_word_topic_assets();
//        }
//
//        public void send_get_word_topic_assets(int i, List<Integer> list) {
//            get_word_topic_assets_args get_word_topic_assets_args = new get_word_topic_assets_args();
//            get_word_topic_assets_args.setWord_level_id(i);
//            get_word_topic_assets_args.setTopic_ids(list);
//            sendBase("get_word_topic_assets", get_word_topic_assets_args);
//        }
//
//        public List<BBTopicAsset> recv_get_word_topic_assets() {
//            get_word_topic_assets_result get_word_topic_assets_result = new get_word_topic_assets_result();
//            receiveBase(get_word_topic_assets_result, "get_word_topic_assets");
//            if (get_word_topic_assets_result.isSetSuccess()) {
//                return get_word_topic_assets_result.success;
//            }
//            if (get_word_topic_assets_result.sysException != null) {
//                throw get_word_topic_assets_result.sysException;
//            }
//            throw new TApplicationException(5, "get_word_topic_assets failed: unknown result");
//        }
//
//        public List<BBTopicAssetV2> get_word_topic_assets_v2(int i, List<Integer> list) {
//            send_get_word_topic_assets_v2(i, list);
//            return recv_get_word_topic_assets_v2();
//        }
//
//        public void send_get_word_topic_assets_v2(int i, List<Integer> list) {
//            get_word_topic_assets_v2_args get_word_topic_assets_v2_args = new get_word_topic_assets_v2_args();
//            get_word_topic_assets_v2_args.setWord_level_id(i);
//            get_word_topic_assets_v2_args.setTopic_ids(list);
//            sendBase("get_word_topic_assets_v2", get_word_topic_assets_v2_args);
//        }
//
//        public List<BBTopicAssetV2> recv_get_word_topic_assets_v2() {
//            get_word_topic_assets_v2_result get_word_topic_assets_v2_result = new get_word_topic_assets_v2_result();
//            receiveBase(get_word_topic_assets_v2_result, "get_word_topic_assets_v2");
//            if (get_word_topic_assets_v2_result.isSetSuccess()) {
//                return get_word_topic_assets_v2_result.success;
//            }
//            if (get_word_topic_assets_v2_result.sysException != null) {
//                throw get_word_topic_assets_v2_result.sysException;
//            }
//            throw new TApplicationException(5, "get_word_topic_assets_v2 failed: unknown result");
//        }
//
//        public List<BBWordMedia> word_media_by_topic_ids(List<Integer> list) {
//            send_word_media_by_topic_ids(list);
//            return recv_word_media_by_topic_ids();
//        }
//
//        public void send_word_media_by_topic_ids(List<Integer> list) {
//            word_media_by_topic_ids_args word_media_by_topic_ids_args = new word_media_by_topic_ids_args();
//            word_media_by_topic_ids_args.setTopic_ids(list);
//            sendBase("word_media_by_topic_ids", word_media_by_topic_ids_args);
//        }
//
//        public List<BBWordMedia> recv_word_media_by_topic_ids() {
//            word_media_by_topic_ids_result word_media_by_topic_ids_result = new word_media_by_topic_ids_result();
//            receiveBase(word_media_by_topic_ids_result, "word_media_by_topic_ids");
//            if (word_media_by_topic_ids_result.isSetSuccess()) {
//                return word_media_by_topic_ids_result.success;
//            }
//            if (word_media_by_topic_ids_result.sysException != null) {
//                throw word_media_by_topic_ids_result.sysException;
//            }
//            throw new TApplicationException(5, "word_media_by_topic_ids failed: unknown result");
//        }
//
//        public List<BBWordMediaV2> word_media_by_topic_ids_v2(List<Integer> list) {
//            send_word_media_by_topic_ids_v2(list);
//            return recv_word_media_by_topic_ids_v2();
//        }
//
//        public void send_word_media_by_topic_ids_v2(List<Integer> list) {
//            word_media_by_topic_ids_v2_args word_media_by_topic_ids_v2_args = new word_media_by_topic_ids_v2_args();
//            word_media_by_topic_ids_v2_args.setTopic_ids(list);
//            sendBase("word_media_by_topic_ids_v2", word_media_by_topic_ids_v2_args);
//        }
//
//        public List<BBWordMediaV2> recv_word_media_by_topic_ids_v2() {
//            word_media_by_topic_ids_v2_result word_media_by_topic_ids_v2_result = new word_media_by_topic_ids_v2_result();
//            receiveBase(word_media_by_topic_ids_v2_result, "word_media_by_topic_ids_v2");
//            if (word_media_by_topic_ids_v2_result.isSetSuccess()) {
//                return word_media_by_topic_ids_v2_result.success;
//            }
//            if (word_media_by_topic_ids_v2_result.sysException != null) {
//                throw word_media_by_topic_ids_v2_result.sysException;
//            }
//            throw new TApplicationException(5, "word_media_by_topic_ids_v2 failed: unknown result");
//        }
//
//        public List<BBWordMediaUpdateInfo> get_word_media_update_info(int i) {
//            send_get_word_media_update_info(i);
//            return recv_get_word_media_update_info();
//        }
//
//        public void send_get_word_media_update_info(int i) {
//            get_word_media_update_info_args get_word_media_update_info_args = new get_word_media_update_info_args();
//            get_word_media_update_info_args.setBook_id(i);
//            sendBase("get_word_media_update_info", get_word_media_update_info_args);
//        }
//
//        public List<BBWordMediaUpdateInfo> recv_get_word_media_update_info() {
//            get_word_media_update_info_result get_word_media_update_info_result = new get_word_media_update_info_result();
//            receiveBase(get_word_media_update_info_result, "get_word_media_update_info");
//            if (get_word_media_update_info_result.isSetSuccess()) {
//                return get_word_media_update_info_result.success;
//            }
//            if (get_word_media_update_info_result.sysException != null) {
//                throw get_word_media_update_info_result.sysException;
//            }
//            throw new TApplicationException(5, "get_word_media_update_info failed: unknown result");
//        }
//
//        public BBWordMediaHalftimeList get_word_media_halftime_list() {
//            send_get_word_media_halftime_list();
//            return recv_get_word_media_halftime_list();
//        }
//
//        public void send_get_word_media_halftime_list() {
//            sendBase("get_word_media_halftime_list", new get_word_media_halftime_list_args());
//        }
//
//        public BBWordMediaHalftimeList recv_get_word_media_halftime_list() {
//            get_word_media_halftime_list_result get_word_media_halftime_list_result = new get_word_media_halftime_list_result();
//            receiveBase(get_word_media_halftime_list_result, "get_word_media_halftime_list");
//            if (get_word_media_halftime_list_result.isSetSuccess()) {
//                return get_word_media_halftime_list_result.success;
//            }
//            if (get_word_media_halftime_list_result.sysException != null) {
//                throw get_word_media_halftime_list_result.sysException;
//            }
//            throw new TApplicationException(5, "get_word_media_halftime_list failed: unknown result");
//        }
//
//        public List<BBWordAssetPackInfo> get_word_asset_pack_info(int i) {
//            send_get_word_asset_pack_info(i);
//            return recv_get_word_asset_pack_info();
//        }
//
//        public void send_get_word_asset_pack_info(int i) {
//            get_word_asset_pack_info_args get_word_asset_pack_info_args = new get_word_asset_pack_info_args();
//            get_word_asset_pack_info_args.setWord_level_id(i);
//            sendBase("get_word_asset_pack_info", get_word_asset_pack_info_args);
//        }
//
//        public List<BBWordAssetPackInfo> recv_get_word_asset_pack_info() {
//            get_word_asset_pack_info_result get_word_asset_pack_info_result = new get_word_asset_pack_info_result();
//            receiveBase(get_word_asset_pack_info_result, "get_word_asset_pack_info");
//            if (get_word_asset_pack_info_result.isSetSuccess()) {
//                return get_word_asset_pack_info_result.success;
//            }
//            if (get_word_asset_pack_info_result.sysException != null) {
//                throw get_word_asset_pack_info_result.sysException;
//            } else if (get_word_asset_pack_info_result.logicException != null) {
//                throw get_word_asset_pack_info_result.logicException;
//            } else {
//                throw new TApplicationException(5, "get_word_asset_pack_info failed: unknown result");
//            }
//        }
//
//        public List<BBWordPackage> get_word_package(List<Integer> list, int i) {
//            send_get_word_package(list, i);
//            return recv_get_word_package();
//        }
//
//        public void send_get_word_package(List<Integer> list, int i) {
//            get_word_package_args get_word_package_args = new get_word_package_args();
//            get_word_package_args.setTopic_ids(list);
//            get_word_package_args.setWord_level_id(i);
//            sendBase("get_word_package", get_word_package_args);
//        }
//
//        public List<BBWordPackage> recv_get_word_package() {
//            get_word_package_result get_word_package_result = new get_word_package_result();
//            receiveBase(get_word_package_result, "get_word_package");
//            if (get_word_package_result.isSetSuccess()) {
//                return get_word_package_result.success;
//            }
//            if (get_word_package_result.sysException != null) {
//                throw get_word_package_result.sysException;
//            } else if (get_word_package_result.logicException != null) {
//                throw get_word_package_result.logicException;
//            } else {
//                throw new TApplicationException(5, "get_word_package failed: unknown result");
//            }
//        }
//
//        public BBWordShareInfo get_word_share_info(int i, int i2) {
//            send_get_word_share_info(i, i2);
//            return recv_get_word_share_info();
//        }
//
//        public void send_get_word_share_info(int i, int i2) {
//            get_word_share_info_args get_word_share_info_args = new get_word_share_info_args();
//            get_word_share_info_args.setTopic_id(i);
//            get_word_share_info_args.setBook_id(i2);
//            sendBase("get_word_share_info", get_word_share_info_args);
//        }
//
//        public BBWordShareInfo recv_get_word_share_info() {
//            get_word_share_info_result get_word_share_info_result = new get_word_share_info_result();
//            receiveBase(get_word_share_info_result, "get_word_share_info");
//            if (get_word_share_info_result.isSetSuccess()) {
//                return get_word_share_info_result.success;
//            }
//            if (get_word_share_info_result.sysException != null) {
//                throw get_word_share_info_result.sysException;
//            } else if (get_word_share_info_result.logicException != null) {
//                throw get_word_share_info_result.logicException;
//            } else {
//                throw new TApplicationException(5, "get_word_share_info failed: unknown result");
//            }
//        }
//
//        public BBWordShareInfo get_word_share_info_v2(int i, int i2, int i3) {
//            send_get_word_share_info_v2(i, i2, i3);
//            return recv_get_word_share_info_v2();
//        }
//
//        public void send_get_word_share_info_v2(int i, int i2, int i3) {
//            get_word_share_info_v2_args get_word_share_info_v2_args = new get_word_share_info_v2_args();
//            get_word_share_info_v2_args.setTopic_id(i);
//            get_word_share_info_v2_args.setBook_id(i2);
//            get_word_share_info_v2_args.setTag_id(i3);
//            sendBase("get_word_share_info_v2", get_word_share_info_v2_args);
//        }
//
//        public BBWordShareInfo recv_get_word_share_info_v2() {
//            get_word_share_info_v2_result get_word_share_info_v2_result = new get_word_share_info_v2_result();
//            receiveBase(get_word_share_info_v2_result, "get_word_share_info_v2");
//            if (get_word_share_info_v2_result.isSetSuccess()) {
//                return get_word_share_info_v2_result.success;
//            }
//            if (get_word_share_info_v2_result.sysException != null) {
//                throw get_word_share_info_v2_result.sysException;
//            } else if (get_word_share_info_v2_result.logicException != null) {
//                throw get_word_share_info_v2_result.logicException;
//            } else {
//                throw new TApplicationException(5, "get_word_share_info_v2 failed: unknown result");
//            }
//        }
//
//        public int word_share_notify(int i, int i2) {
//            send_word_share_notify(i, i2);
//            return recv_word_share_notify();
//        }
//
//        public void send_word_share_notify(int i, int i2) {
//            word_share_notify_args word_share_notify_args = new word_share_notify_args();
//            word_share_notify_args.setTopic_id(i);
//            word_share_notify_args.setBook_id(i2);
//            sendBase("word_share_notify", word_share_notify_args);
//        }
//
//        public int recv_word_share_notify() {
//            word_share_notify_result word_share_notify_result = new word_share_notify_result();
//            receiveBase(word_share_notify_result, "word_share_notify");
//            if (word_share_notify_result.isSetSuccess()) {
//                return word_share_notify_result.success;
//            }
//            if (word_share_notify_result.sysException != null) {
//                throw word_share_notify_result.sysException;
//            } else if (word_share_notify_result.logicException != null) {
//                throw word_share_notify_result.logicException;
//            } else {
//                throw new TApplicationException(5, "word_share_notify failed: unknown result");
//            }
//        }
//
//        public int word_share_notify_v2(int i, int i2, int i3) {
//            send_word_share_notify_v2(i, i2, i3);
//            return recv_word_share_notify_v2();
//        }
//
//        public void send_word_share_notify_v2(int i, int i2, int i3) {
//            word_share_notify_v2_args word_share_notify_v2_args = new word_share_notify_v2_args();
//            word_share_notify_v2_args.setTopic_id(i);
//            word_share_notify_v2_args.setBook_id(i2);
//            word_share_notify_v2_args.setTag_id(i3);
//            sendBase("word_share_notify_v2", word_share_notify_v2_args);
//        }
//
//        public int recv_word_share_notify_v2() {
//            word_share_notify_v2_result word_share_notify_v2_result = new word_share_notify_v2_result();
//            receiveBase(word_share_notify_v2_result, "word_share_notify_v2");
//            if (word_share_notify_v2_result.isSetSuccess()) {
//                return word_share_notify_v2_result.success;
//            }
//            if (word_share_notify_v2_result.sysException != null) {
//                throw word_share_notify_v2_result.sysException;
//            } else if (word_share_notify_v2_result.logicException != null) {
//                throw word_share_notify_v2_result.logicException;
//            } else {
//                throw new TApplicationException(5, "word_share_notify_v2 failed: unknown result");
//            }
//        }
//
//        public List<BBWordSearchResult> word_search(String str) {
//            send_word_search(str);
//            return recv_word_search();
//        }
//
//        public void send_word_search(String str) {
//            word_search_args word_search_args = new word_search_args();
//            word_search_args.setQuery_str(str);
//            sendBase("word_search", word_search_args);
//        }
//
//        public List<BBWordSearchResult> recv_word_search() {
//            word_search_result word_search_result = new word_search_result();
//            receiveBase(word_search_result, "word_search");
//            if (word_search_result.isSetSuccess()) {
//                return word_search_result.success;
//            }
//            if (word_search_result.sysException != null) {
//                throw word_search_result.sysException;
//            } else if (word_search_result.logicException != null) {
//                throw word_search_result.logicException;
//            } else {
//                throw new TApplicationException(5, "word_search failed: unknown result");
//            }
//        }
//
//        public int update_online_topic(int i, int i2, int i3, int i4, String str) {
//            send_update_online_topic(i, i2, i3, i4, str);
//            return recv_update_online_topic();
//        }
//
//        public void send_update_online_topic(int i, int i2, int i3, int i4, String str) {
//            update_online_topic_args update_online_topic_args = new update_online_topic_args();
//            update_online_topic_args.setTopic_id(i);
//            update_online_topic_args.setWord_level_id(i2);
//            update_online_topic_args.setTag_id(i3);
//            update_online_topic_args.setVersion(i4);
//            update_online_topic_args.setSigned_key(str);
//            sendBase("update_online_topic", update_online_topic_args);
//        }
//
//        public int recv_update_online_topic() {
//            update_online_topic_result update_online_topic_result = new update_online_topic_result();
//            receiveBase(update_online_topic_result, "update_online_topic");
//            if (update_online_topic_result.isSetSuccess()) {
//                return update_online_topic_result.success;
//            }
//            if (update_online_topic_result.sysException != null) {
//                throw update_online_topic_result.sysException;
//            } else if (update_online_topic_result.logicException != null) {
//                throw update_online_topic_result.logicException;
//            } else {
//                throw new TApplicationException(5, "update_online_topic failed: unknown result");
//            }
//        }
//
//        public List<BBSimilarWordInfo> get_similar_words_info(int i, List<Integer> list) {
//            send_get_similar_words_info(i, list);
//            return recv_get_similar_words_info();
//        }
//
//        public void send_get_similar_words_info(int i, List<Integer> list) {
//            get_similar_words_info_args get_similar_words_info_args = new get_similar_words_info_args();
//            get_similar_words_info_args.setBook_id(i);
//            get_similar_words_info_args.setArr_topic_ids(list);
//            sendBase("get_similar_words_info", get_similar_words_info_args);
//        }
//
//        public List<BBSimilarWordInfo> recv_get_similar_words_info() {
//            get_similar_words_info_result get_similar_words_info_result = new get_similar_words_info_result();
//            receiveBase(get_similar_words_info_result, "get_similar_words_info");
//            if (get_similar_words_info_result.isSetSuccess()) {
//                return get_similar_words_info_result.success;
//            }
//            if (get_similar_words_info_result.sysException != null) {
//                throw get_similar_words_info_result.sysException;
//            }
//            throw new TApplicationException(5, "get_similar_words_info failed: unknown result");
//        }
//
//        public List<BBGetWordAssetInfoResult> get_word_assets_info_by_topic_and_book_id(List<BBGetWordAssetInfoArg> list) {
//            send_get_word_assets_info_by_topic_and_book_id(list);
//            return recv_get_word_assets_info_by_topic_and_book_id();
//        }
//
//        public void send_get_word_assets_info_by_topic_and_book_id(List<BBGetWordAssetInfoArg> list) {
//            get_word_assets_info_by_topic_and_book_id_args get_word_assets_info_by_topic_and_book_id_args = new get_word_assets_info_by_topic_and_book_id_args();
//            get_word_assets_info_by_topic_and_book_id_args.setArr_topic_and_book_ids(list);
//            sendBase("get_word_assets_info_by_topic_and_book_id", get_word_assets_info_by_topic_and_book_id_args);
//        }
//
//        public List<BBGetWordAssetInfoResult> recv_get_word_assets_info_by_topic_and_book_id() {
//            get_word_assets_info_by_topic_and_book_id_result get_word_assets_info_by_topic_and_book_id_result = new get_word_assets_info_by_topic_and_book_id_result();
//            receiveBase(get_word_assets_info_by_topic_and_book_id_result, "get_word_assets_info_by_topic_and_book_id");
//            if (get_word_assets_info_by_topic_and_book_id_result.isSetSuccess()) {
//                return get_word_assets_info_by_topic_and_book_id_result.success;
//            }
//            if (get_word_assets_info_by_topic_and_book_id_result.sysException != null) {
//                throw get_word_assets_info_by_topic_and_book_id_result.sysException;
//            }
//            throw new TApplicationException(5, "get_word_assets_info_by_topic_and_book_id failed: unknown result");
//        }
//
//        public int similar_words_vote(int i, List<BBSimilarWordVote> list) {
//            send_similar_words_vote(i, list);
//            return recv_similar_words_vote();
//        }
//
//        public void send_similar_words_vote(int i, List<BBSimilarWordVote> list) {
//            similar_words_vote_args similar_words_vote_args = new similar_words_vote_args();
//            similar_words_vote_args.setBook_id(i);
//            similar_words_vote_args.setSimilar_words_votes(list);
//            sendBase("similar_words_vote", similar_words_vote_args);
//        }
//
//        public int recv_similar_words_vote() {
//            similar_words_vote_result similar_words_vote_result = new similar_words_vote_result();
//            receiveBase(similar_words_vote_result, "similar_words_vote");
//            if (similar_words_vote_result.isSetSuccess()) {
//                return similar_words_vote_result.success;
//            }
//            if (similar_words_vote_result.sysException != null) {
//                throw similar_words_vote_result.sysException;
//            }
//            throw new TApplicationException(5, "similar_words_vote failed: unknown result");
//        }
//
//        public BBWordPackage get_search_word_package(int i, int i2) {
//            send_get_search_word_package(i, i2);
//            return recv_get_search_word_package();
//        }
//
//        public void send_get_search_word_package(int i, int i2) {
//            get_search_word_package_args get_search_word_package_args = new get_search_word_package_args();
//            get_search_word_package_args.setPrefer_word_level_id(i);
//            get_search_word_package_args.setTopic_id(i2);
//            sendBase("get_search_word_package", get_search_word_package_args);
//        }
//
//        public BBWordPackage recv_get_search_word_package() {
//            get_search_word_package_result get_search_word_package_result = new get_search_word_package_result();
//            receiveBase(get_search_word_package_result, "get_search_word_package");
//            if (get_search_word_package_result.isSetSuccess()) {
//                return get_search_word_package_result.success;
//            }
//            if (get_search_word_package_result.sysException != null) {
//                throw get_search_word_package_result.sysException;
//            } else if (get_search_word_package_result.logicException != null) {
//                throw get_search_word_package_result.logicException;
//            } else {
//                throw new TApplicationException(5, "get_search_word_package failed: unknown result");
//            }
//        }
//    }
//
//    public interface Iface {
//        BBWordPackage get_search_word_package(int i, int i2);
//
//        List<BBSimilarWordInfo> get_similar_words_info(int i, List<Integer> list);
//
//        List<BBWordAssetPackInfo> get_word_asset_pack_info(int i);
//
//        List<BBGetWordAssetInfoResult> get_word_assets_info_by_topic_and_book_id(List<BBGetWordAssetInfoArg> list);
//
//        BBWordMediaHalftimeList get_word_media_halftime_list();
//
//        List<BBWordMediaUpdateInfo> get_word_media_update_info(int i);
//
//        List<BBWordPackage> get_word_package(List<Integer> list, int i);
//
//        BBWordShareInfo get_word_share_info(int i, int i2);
//
//        BBWordShareInfo get_word_share_info_v2(int i, int i2, int i3);
//
//        List<BBTopicAsset> get_word_topic_assets(int i, List<Integer> list);
//
//        List<BBTopicAssetV2> get_word_topic_assets_v2(int i, List<Integer> list);
//
//        int similar_words_vote(int i, List<BBSimilarWordVote> list);
//
//        int update_online_topic(int i, int i2, int i3, int i4, String str);
//
//        List<BBWordMedia> word_media_by_topic_ids(List<Integer> list);
//
//        List<BBWordMediaV2> word_media_by_topic_ids_v2(List<Integer> list);
//
//        List<BBWordSearchResult> word_search(String str);
//
//        int word_share_notify(int i, int i2);
//
//        int word_share_notify_v2(int i, int i2, int i3);
//    }
//
//    public class Processor<I extends Iface> extends TBaseProcessor<I> {
//        private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());
//
//        public class get_search_word_package<I extends Iface> extends ProcessFunction<I, get_search_word_package_args> {
//            public get_search_word_package() {
//                super("get_search_word_package");
//            }
//
//            public get_search_word_package_args getEmptyArgsInstance() {
//                return new get_search_word_package_args();
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public get_search_word_package_result getResult(I i, get_search_word_package_args get_search_word_package_args) {
//                get_search_word_package_result get_search_word_package_result = new get_search_word_package_result();
//                try {
//                    get_search_word_package_result.success = i.get_search_word_package(get_search_word_package_args.prefer_word_level_id, get_search_word_package_args.topic_id);
//                } catch (BESystemException e) {
//                    get_search_word_package_result.sysException = e;
//                } catch (BELogicException e2) {
//                    get_search_word_package_result.logicException = e2;
//                }
//                return get_search_word_package_result;
//            }
//        }
//
//        public class get_similar_words_info<I extends Iface> extends ProcessFunction<I, get_similar_words_info_args> {
//            public get_similar_words_info() {
//                super("get_similar_words_info");
//            }
//
//            public get_similar_words_info_args getEmptyArgsInstance() {
//                return new get_similar_words_info_args();
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public get_similar_words_info_result getResult(I i, get_similar_words_info_args get_similar_words_info_args) {
//                get_similar_words_info_result get_similar_words_info_result = new get_similar_words_info_result();
//                try {
//                    get_similar_words_info_result.success = i.get_similar_words_info(get_similar_words_info_args.book_id, get_similar_words_info_args.arr_topic_ids);
//                } catch (BESystemException e) {
//                    get_similar_words_info_result.sysException = e;
//                }
//                return get_similar_words_info_result;
//            }
//        }
//
//        public class get_word_asset_pack_info<I extends Iface> extends ProcessFunction<I, get_word_asset_pack_info_args> {
//            public get_word_asset_pack_info() {
//                super("get_word_asset_pack_info");
//            }
//
//            public get_word_asset_pack_info_args getEmptyArgsInstance() {
//                return new get_word_asset_pack_info_args();
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public get_word_asset_pack_info_result getResult(I i, get_word_asset_pack_info_args get_word_asset_pack_info_args) {
//                get_word_asset_pack_info_result get_word_asset_pack_info_result = new get_word_asset_pack_info_result();
//                try {
//                    get_word_asset_pack_info_result.success = i.get_word_asset_pack_info(get_word_asset_pack_info_args.word_level_id);
//                } catch (BESystemException e) {
//                    get_word_asset_pack_info_result.sysException = e;
//                } catch (BELogicException e2) {
//                    get_word_asset_pack_info_result.logicException = e2;
//                }
//                return get_word_asset_pack_info_result;
//            }
//        }
//
//        public class get_word_assets_info_by_topic_and_book_id<I extends Iface> extends ProcessFunction<I, get_word_assets_info_by_topic_and_book_id_args> {
//            public get_word_assets_info_by_topic_and_book_id() {
//                super("get_word_assets_info_by_topic_and_book_id");
//            }
//
//            public get_word_assets_info_by_topic_and_book_id_args getEmptyArgsInstance() {
//                return new get_word_assets_info_by_topic_and_book_id_args();
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public get_word_assets_info_by_topic_and_book_id_result getResult(I i, get_word_assets_info_by_topic_and_book_id_args get_word_assets_info_by_topic_and_book_id_args) {
//                get_word_assets_info_by_topic_and_book_id_result get_word_assets_info_by_topic_and_book_id_result = new get_word_assets_info_by_topic_and_book_id_result();
//                try {
//                    get_word_assets_info_by_topic_and_book_id_result.success = i.get_word_assets_info_by_topic_and_book_id(get_word_assets_info_by_topic_and_book_id_args.arr_topic_and_book_ids);
//                } catch (BESystemException e) {
//                    get_word_assets_info_by_topic_and_book_id_result.sysException = e;
//                }
//                return get_word_assets_info_by_topic_and_book_id_result;
//            }
//        }
//
//        public class get_word_media_halftime_list<I extends Iface> extends ProcessFunction<I, get_word_media_halftime_list_args> {
//            public get_word_media_halftime_list() {
//                super("get_word_media_halftime_list");
//            }
//
//            public get_word_media_halftime_list_args getEmptyArgsInstance() {
//                return new get_word_media_halftime_list_args();
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public get_word_media_halftime_list_result getResult(I i, get_word_media_halftime_list_args get_word_media_halftime_list_args) {
//                get_word_media_halftime_list_result get_word_media_halftime_list_result = new get_word_media_halftime_list_result();
//                try {
//                    get_word_media_halftime_list_result.success = i.get_word_media_halftime_list();
//                } catch (BESystemException e) {
//                    get_word_media_halftime_list_result.sysException = e;
//                }
//                return get_word_media_halftime_list_result;
//            }
//        }
//
//        public class get_word_media_update_info<I extends Iface> extends ProcessFunction<I, get_word_media_update_info_args> {
//            public get_word_media_update_info() {
//                super("get_word_media_update_info");
//            }
//
//            public get_word_media_update_info_args getEmptyArgsInstance() {
//                return new get_word_media_update_info_args();
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public get_word_media_update_info_result getResult(I i, get_word_media_update_info_args get_word_media_update_info_args) {
//                get_word_media_update_info_result get_word_media_update_info_result = new get_word_media_update_info_result();
//                try {
//                    get_word_media_update_info_result.success = i.get_word_media_update_info(get_word_media_update_info_args.book_id);
//                } catch (BESystemException e) {
//                    get_word_media_update_info_result.sysException = e;
//                }
//                return get_word_media_update_info_result;
//            }
//        }
//
//        public class get_word_package<I extends Iface> extends ProcessFunction<I, get_word_package_args> {
//            public get_word_package() {
//                super("get_word_package");
//            }
//
//            public get_word_package_args getEmptyArgsInstance() {
//                return new get_word_package_args();
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public get_word_package_result getResult(I i, get_word_package_args get_word_package_args) {
//                get_word_package_result get_word_package_result = new get_word_package_result();
//                try {
//                    get_word_package_result.success = i.get_word_package(get_word_package_args.topic_ids, get_word_package_args.word_level_id);
//                } catch (BESystemException e) {
//                    get_word_package_result.sysException = e;
//                } catch (BELogicException e2) {
//                    get_word_package_result.logicException = e2;
//                }
//                return get_word_package_result;
//            }
//        }
//
//        public class get_word_share_info<I extends Iface> extends ProcessFunction<I, get_word_share_info_args> {
//            public get_word_share_info() {
//                super("get_word_share_info");
//            }
//
//            public get_word_share_info_args getEmptyArgsInstance() {
//                return new get_word_share_info_args();
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public get_word_share_info_result getResult(I i, get_word_share_info_args get_word_share_info_args) {
//                get_word_share_info_result get_word_share_info_result = new get_word_share_info_result();
//                try {
//                    get_word_share_info_result.success = i.get_word_share_info(get_word_share_info_args.topic_id, get_word_share_info_args.book_id);
//                } catch (BESystemException e) {
//                    get_word_share_info_result.sysException = e;
//                } catch (BELogicException e2) {
//                    get_word_share_info_result.logicException = e2;
//                }
//                return get_word_share_info_result;
//            }
//        }
//
//        public class get_word_share_info_v2<I extends Iface> extends ProcessFunction<I, get_word_share_info_v2_args> {
//            public get_word_share_info_v2() {
//                super("get_word_share_info_v2");
//            }
//
//            public get_word_share_info_v2_args getEmptyArgsInstance() {
//                return new get_word_share_info_v2_args();
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public get_word_share_info_v2_result getResult(I i, get_word_share_info_v2_args get_word_share_info_v2_args) {
//                get_word_share_info_v2_result get_word_share_info_v2_result = new get_word_share_info_v2_result();
//                try {
//                    get_word_share_info_v2_result.success = i.get_word_share_info_v2(get_word_share_info_v2_args.topic_id, get_word_share_info_v2_args.book_id, get_word_share_info_v2_args.tag_id);
//                } catch (BESystemException e) {
//                    get_word_share_info_v2_result.sysException = e;
//                } catch (BELogicException e2) {
//                    get_word_share_info_v2_result.logicException = e2;
//                }
//                return get_word_share_info_v2_result;
//            }
//        }
//
//        public class get_word_topic_assets<I extends Iface> extends ProcessFunction<I, get_word_topic_assets_args> {
//            public get_word_topic_assets() {
//                super("get_word_topic_assets");
//            }
//
//            public get_word_topic_assets_args getEmptyArgsInstance() {
//                return new get_word_topic_assets_args();
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public get_word_topic_assets_result getResult(I i, get_word_topic_assets_args get_word_topic_assets_args) {
//                get_word_topic_assets_result get_word_topic_assets_result = new get_word_topic_assets_result();
//                try {
//                    get_word_topic_assets_result.success = i.get_word_topic_assets(get_word_topic_assets_args.word_level_id, get_word_topic_assets_args.topic_ids);
//                } catch (BESystemException e) {
//                    get_word_topic_assets_result.sysException = e;
//                }
//                return get_word_topic_assets_result;
//            }
//        }
//
//        public class get_word_topic_assets_v2<I extends Iface> extends ProcessFunction<I, get_word_topic_assets_v2_args> {
//            public get_word_topic_assets_v2() {
//                super("get_word_topic_assets_v2");
//            }
//
//            public get_word_topic_assets_v2_args getEmptyArgsInstance() {
//                return new get_word_topic_assets_v2_args();
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public get_word_topic_assets_v2_result getResult(I i, get_word_topic_assets_v2_args get_word_topic_assets_v2_args) {
//                get_word_topic_assets_v2_result get_word_topic_assets_v2_result = new get_word_topic_assets_v2_result();
//                try {
//                    get_word_topic_assets_v2_result.success = i.get_word_topic_assets_v2(get_word_topic_assets_v2_args.word_level_id, get_word_topic_assets_v2_args.topic_ids);
//                } catch (BESystemException e) {
//                    get_word_topic_assets_v2_result.sysException = e;
//                }
//                return get_word_topic_assets_v2_result;
//            }
//        }
//
//        public class similar_words_vote<I extends Iface> extends ProcessFunction<I, similar_words_vote_args> {
//            public similar_words_vote() {
//                super("similar_words_vote");
//            }
//
//            public similar_words_vote_args getEmptyArgsInstance() {
//                return new similar_words_vote_args();
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public similar_words_vote_result getResult(I i, similar_words_vote_args similar_words_vote_args) {
//                similar_words_vote_result similar_words_vote_result = new similar_words_vote_result();
//                try {
//                    similar_words_vote_result.success = i.similar_words_vote(similar_words_vote_args.book_id, similar_words_vote_args.similar_words_votes);
//                    similar_words_vote_result.setSuccessIsSet(true);
//                } catch (BESystemException e) {
//                    similar_words_vote_result.sysException = e;
//                }
//                return similar_words_vote_result;
//            }
//        }
//
//        public class update_online_topic<I extends Iface> extends ProcessFunction<I, update_online_topic_args> {
//            public update_online_topic() {
//                super("update_online_topic");
//            }
//
//            public update_online_topic_args getEmptyArgsInstance() {
//                return new update_online_topic_args();
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public update_online_topic_result getResult(I i, update_online_topic_args update_online_topic_args) {
//                update_online_topic_result update_online_topic_result = new update_online_topic_result();
//                try {
//                    update_online_topic_result.success = i.update_online_topic(update_online_topic_args.topic_id, update_online_topic_args.word_level_id, update_online_topic_args.tag_id, update_online_topic_args.version, update_online_topic_args.signed_key);
//                    update_online_topic_result.setSuccessIsSet(true);
//                } catch (BESystemException e) {
//                    update_online_topic_result.sysException = e;
//                } catch (BELogicException e2) {
//                    update_online_topic_result.logicException = e2;
//                }
//                return update_online_topic_result;
//            }
//        }
//
//        public class word_media_by_topic_ids<I extends Iface> extends ProcessFunction<I, word_media_by_topic_ids_args> {
//            public word_media_by_topic_ids() {
//                super("word_media_by_topic_ids");
//            }
//
//            public word_media_by_topic_ids_args getEmptyArgsInstance() {
//                return new word_media_by_topic_ids_args();
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public word_media_by_topic_ids_result getResult(I i, word_media_by_topic_ids_args word_media_by_topic_ids_args) {
//                word_media_by_topic_ids_result word_media_by_topic_ids_result = new word_media_by_topic_ids_result();
//                try {
//                    word_media_by_topic_ids_result.success = i.word_media_by_topic_ids(word_media_by_topic_ids_args.topic_ids);
//                } catch (BESystemException e) {
//                    word_media_by_topic_ids_result.sysException = e;
//                }
//                return word_media_by_topic_ids_result;
//            }
//        }
//
//        public class word_media_by_topic_ids_v2<I extends Iface> extends ProcessFunction<I, word_media_by_topic_ids_v2_args> {
//            public word_media_by_topic_ids_v2() {
//                super("word_media_by_topic_ids_v2");
//            }
//
//            public word_media_by_topic_ids_v2_args getEmptyArgsInstance() {
//                return new word_media_by_topic_ids_v2_args();
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public word_media_by_topic_ids_v2_result getResult(I i, word_media_by_topic_ids_v2_args word_media_by_topic_ids_v2_args) {
//                word_media_by_topic_ids_v2_result word_media_by_topic_ids_v2_result = new word_media_by_topic_ids_v2_result();
//                try {
//                    word_media_by_topic_ids_v2_result.success = i.word_media_by_topic_ids_v2(word_media_by_topic_ids_v2_args.topic_ids);
//                } catch (BESystemException e) {
//                    word_media_by_topic_ids_v2_result.sysException = e;
//                }
//                return word_media_by_topic_ids_v2_result;
//            }
//        }
//
//        /* renamed from: com.baicizhan.online.bs_words.BSWords$Processor$word_search */
//        public class C1381word_search<I extends Iface> extends ProcessFunction<I, word_search_args> {
//            public C1381word_search() {
//                super("word_search");
//            }
//
//            public word_search_args getEmptyArgsInstance() {
//                return new word_search_args();
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public word_search_result getResult(I i, word_search_args word_search_args) {
//                word_search_result word_search_result = new word_search_result();
//                try {
//                    word_search_result.success = i.word_search(word_search_args.query_str);
//                } catch (BESystemException e) {
//                    word_search_result.sysException = e;
//                } catch (BELogicException e2) {
//                    word_search_result.logicException = e2;
//                }
//                return word_search_result;
//            }
//        }
//
//        public class word_share_notify<I extends Iface> extends ProcessFunction<I, word_share_notify_args> {
//            public word_share_notify() {
//                super("word_share_notify");
//            }
//
//            public word_share_notify_args getEmptyArgsInstance() {
//                return new word_share_notify_args();
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public word_share_notify_result getResult(I i, word_share_notify_args word_share_notify_args) {
//                word_share_notify_result word_share_notify_result = new word_share_notify_result();
//                try {
//                    word_share_notify_result.success = i.word_share_notify(word_share_notify_args.topic_id, word_share_notify_args.book_id);
//                    word_share_notify_result.setSuccessIsSet(true);
//                } catch (BESystemException e) {
//                    word_share_notify_result.sysException = e;
//                } catch (BELogicException e2) {
//                    word_share_notify_result.logicException = e2;
//                }
//                return word_share_notify_result;
//            }
//        }
//
//        public class word_share_notify_v2<I extends Iface> extends ProcessFunction<I, word_share_notify_v2_args> {
//            public word_share_notify_v2() {
//                super("word_share_notify_v2");
//            }
//
//            public word_share_notify_v2_args getEmptyArgsInstance() {
//                return new word_share_notify_v2_args();
//            }
//
//            /* access modifiers changed from: protected */
//            public boolean isOneway() {
//                return false;
//            }
//
//            public word_share_notify_v2_result getResult(I i, word_share_notify_v2_args word_share_notify_v2_args) {
//                word_share_notify_v2_result word_share_notify_v2_result = new word_share_notify_v2_result();
//                try {
//                    word_share_notify_v2_result.success = i.word_share_notify_v2(word_share_notify_v2_args.topic_id, word_share_notify_v2_args.book_id, word_share_notify_v2_args.tag_id);
//                    word_share_notify_v2_result.setSuccessIsSet(true);
//                } catch (BESystemException e) {
//                    word_share_notify_v2_result.sysException = e;
//                } catch (BELogicException e2) {
//                    word_share_notify_v2_result.logicException = e2;
//                }
//                return word_share_notify_v2_result;
//            }
//        }
//
//        public Processor(I i) {
//            super(i, getProcessMap(new HashMap()));
//        }
//
//        protected Processor(I i, Map<String, ProcessFunction<I, ? extends C2116f>> map) {
//            super(i, getProcessMap(map));
//        }
//
//        private static <I extends Iface> Map<String, ProcessFunction<I, ? extends C2116f>> getProcessMap(Map<String, ProcessFunction<I, ? extends C2116f>> map) {
//            map.put("get_word_topic_assets", new get_word_topic_assets());
//            map.put("get_word_topic_assets_v2", new get_word_topic_assets_v2());
//            map.put("word_media_by_topic_ids", new word_media_by_topic_ids());
//            map.put("word_media_by_topic_ids_v2", new word_media_by_topic_ids_v2());
//            map.put("get_word_media_update_info", new get_word_media_update_info());
//            map.put("get_word_media_halftime_list", new get_word_media_halftime_list());
//            map.put("get_word_asset_pack_info", new get_word_asset_pack_info());
//            map.put("get_word_package", new get_word_package());
//            map.put("get_word_share_info", new get_word_share_info());
//            map.put("get_word_share_info_v2", new get_word_share_info_v2());
//            map.put("word_share_notify", new word_share_notify());
//            map.put("word_share_notify_v2", new word_share_notify_v2());
//            map.put("word_search", new C1381word_search());
//            map.put("update_online_topic", new update_online_topic());
//            map.put("get_similar_words_info", new get_similar_words_info());
//            map.put("get_word_assets_info_by_topic_and_book_id", new get_word_assets_info_by_topic_and_book_id());
//            map.put("similar_words_vote", new similar_words_vote());
//            map.put("get_search_word_package", new get_search_word_package());
//            return map;
//        }
//    }
//
//    public class get_search_word_package_args implements Serializable, Cloneable, Comparable<get_search_word_package_args>, C2116f<get_search_word_package_args, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2097b PREFER_WORD_LEVEL_ID_FIELD_DESC = new C2097b("prefer_word_level_id", 8, 1);
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_search_word_package_args");
//        /* access modifiers changed from: private */
//        public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 2);
//        private static final int __PREFER_WORD_LEVEL_ID_ISSET_ID = 0;
//        private static final int __TOPIC_ID_ISSET_ID = 1;
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        private byte __isset_bitfield;
//        public int prefer_word_level_id;
//        public int topic_id;
//
//        public enum _Fields implements C2124m {
//            PREFER_WORD_LEVEL_ID(1, "prefer_word_level_id"),
//            TOPIC_ID(2, "topic_id");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 1:
//                        return PREFER_WORD_LEVEL_ID;
//                    case 2:
//                        return TOPIC_ID;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_search_word_package_argsStandardScheme extends C2110c<get_search_word_package_args> {
//            private get_search_word_package_argsStandardScheme() {
//            }
//
//            /* synthetic */ get_search_word_package_argsStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_search_word_package_args get_search_word_package_args) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 1:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_search_word_package_args.prefer_word_level_id = fVar.mo18513n();
//                                    get_search_word_package_args.setPrefer_word_level_idIsSet(true);
//                                    break;
//                                }
//                            case 2:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_search_word_package_args.topic_id = fVar.mo18513n();
//                                    get_search_word_package_args.setTopic_idIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        if (!get_search_word_package_args.isSetPrefer_word_level_id()) {
//                            throw new C2101g("Required field 'prefer_word_level_id' was not found in serialized data! Struct: " + toString());
//                        } else if (!get_search_word_package_args.isSetTopic_id()) {
//                            throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                        } else {
//                            get_search_word_package_args.validate();
//                            return;
//                        }
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_search_word_package_args get_search_word_package_args) {
//                get_search_word_package_args.validate();
//                get_search_word_package_args.STRUCT_DESC;
//                fVar.mo18490a();
//                fVar.mo18496a(get_search_word_package_args.PREFER_WORD_LEVEL_ID_FIELD_DESC);
//                fVar.mo18493a(get_search_word_package_args.prefer_word_level_id);
//                fVar.mo18496a(get_search_word_package_args.TOPIC_ID_FIELD_DESC);
//                fVar.mo18493a(get_search_word_package_args.topic_id);
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class get_search_word_package_argsStandardSchemeFactory implements C2109b {
//            private get_search_word_package_argsStandardSchemeFactory() {
//            }
//
//            /* synthetic */ get_search_word_package_argsStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_search_word_package_argsStandardScheme getScheme() {
//                return new get_search_word_package_argsStandardScheme(null);
//            }
//        }
//
//        class get_search_word_package_argsTupleScheme extends C2111d<get_search_word_package_args> {
//            private get_search_word_package_argsTupleScheme() {
//            }
//
//            /* synthetic */ get_search_word_package_argsTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_search_word_package_args get_search_word_package_args) {
//                C2106l lVar = (C2106l) fVar;
//                lVar.mo18493a(get_search_word_package_args.prefer_word_level_id);
//                lVar.mo18493a(get_search_word_package_args.topic_id);
//            }
//
//            public void read(C2100f fVar, get_search_word_package_args get_search_word_package_args) {
//                C2106l lVar = (C2106l) fVar;
//                get_search_word_package_args.prefer_word_level_id = lVar.mo18513n();
//                get_search_word_package_args.setPrefer_word_level_idIsSet(true);
//                get_search_word_package_args.topic_id = lVar.mo18513n();
//                get_search_word_package_args.setTopic_idIsSet(true);
//            }
//        }
//
//        class get_search_word_package_argsTupleSchemeFactory implements C2109b {
//            private get_search_word_package_argsTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_search_word_package_argsTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_search_word_package_argsTupleScheme getScheme() {
//                return new get_search_word_package_argsTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new get_search_word_package_argsStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new get_search_word_package_argsTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.PREFER_WORD_LEVEL_ID, new C2091a("prefer_word_level_id", 1, new C2092b(8, 0)));
//            enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_search_word_package_args.class, metaDataMap);
//        }
//
//        public get_search_word_package_args() {
//            this.__isset_bitfield = 0;
//        }
//
//        public get_search_word_package_args(int i, int i2) {
//            this();
//            this.prefer_word_level_id = i;
//            setPrefer_word_level_idIsSet(true);
//            this.topic_id = i2;
//            setTopic_idIsSet(true);
//        }
//
//        public get_search_word_package_args(get_search_word_package_args get_search_word_package_args) {
//            this.__isset_bitfield = 0;
//            this.__isset_bitfield = get_search_word_package_args.__isset_bitfield;
//            this.prefer_word_level_id = get_search_word_package_args.prefer_word_level_id;
//            this.topic_id = get_search_word_package_args.topic_id;
//        }
//
//        public get_search_word_package_args deepCopy() {
//            return new get_search_word_package_args(this);
//        }
//
//        public void clear() {
//            setPrefer_word_level_idIsSet(false);
//            this.prefer_word_level_id = 0;
//            setTopic_idIsSet(false);
//            this.topic_id = 0;
//        }
//
//        public int getPrefer_word_level_id() {
//            return this.prefer_word_level_id;
//        }
//
//        public get_search_word_package_args setPrefer_word_level_id(int i) {
//            this.prefer_word_level_id = i;
//            setPrefer_word_level_idIsSet(true);
//            return this;
//        }
//
//        public void unsetPrefer_word_level_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//        }
//
//        public boolean isSetPrefer_word_level_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 0);
//        }
//
//        public void setPrefer_word_level_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//        }
//
//        public int getTopic_id() {
//            return this.topic_id;
//        }
//
//        public get_search_word_package_args setTopic_id(int i) {
//            this.topic_id = i;
//            setTopic_idIsSet(true);
//            return this;
//        }
//
//        public void unsetTopic_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//        }
//
//        public boolean isSetTopic_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 1);
//        }
//
//        public void setTopic_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case PREFER_WORD_LEVEL_ID:
//                    if (obj == null) {
//                        unsetPrefer_word_level_id();
//                        return;
//                    } else {
//                        setPrefer_word_level_id(((Integer) obj).intValue());
//                        return;
//                    }
//                case TOPIC_ID:
//                    if (obj == null) {
//                        unsetTopic_id();
//                        return;
//                    } else {
//                        setTopic_id(((Integer) obj).intValue());
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case PREFER_WORD_LEVEL_ID:
//                    return Integer.valueOf(getPrefer_word_level_id());
//                case TOPIC_ID:
//                    return Integer.valueOf(getTopic_id());
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case PREFER_WORD_LEVEL_ID:
//                    return isSetPrefer_word_level_id();
//                case TOPIC_ID:
//                    return isSetTopic_id();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_search_word_package_args)) {
//                return equals((get_search_word_package_args) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_search_word_package_args get_search_word_package_args) {
//            if (get_search_word_package_args != null && this.prefer_word_level_id == get_search_word_package_args.prefer_word_level_id && this.topic_id == get_search_word_package_args.topic_id) {
//                return true;
//            }
//            return false;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_search_word_package_args get_search_word_package_args) {
//            if (!getClass().equals(get_search_word_package_args.getClass())) {
//                return getClass().getName().compareTo(get_search_word_package_args.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetPrefer_word_level_id()).compareTo(Boolean.valueOf(get_search_word_package_args.isSetPrefer_word_level_id()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetPrefer_word_level_id()) {
//                int a = C2121h.m5522a(this.prefer_word_level_id, get_search_word_package_args.prefer_word_level_id);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(get_search_word_package_args.isSetTopic_id()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetTopic_id()) {
//                int a2 = C2121h.m5522a(this.topic_id, get_search_word_package_args.topic_id);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_search_word_package_args(");
//            sb.append("prefer_word_level_id:");
//            sb.append(this.prefer_word_level_id);
//            sb.append(", ");
//            sb.append("topic_id:");
//            sb.append(this.topic_id);
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                this.__isset_bitfield = 0;
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_search_word_package_result implements Serializable, Cloneable, Comparable<get_search_word_package_result>, C2116f<get_search_word_package_result, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2097b LOGIC_EXCEPTION_FIELD_DESC = new C2097b("logicException", JceStruct.ZERO_TAG, 2);
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_search_word_package_result");
//        /* access modifiers changed from: private */
//        public static final C2097b SUCCESS_FIELD_DESC = new C2097b("success", JceStruct.ZERO_TAG, 0);
//        /* access modifiers changed from: private */
//        public static final C2097b SYS_EXCEPTION_FIELD_DESC = new C2097b("sysException", JceStruct.ZERO_TAG, 1);
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        public BELogicException logicException;
//        public BBWordPackage success;
//        public BESystemException sysException;
//
//        public enum _Fields implements C2124m {
//            SUCCESS(0, "success"),
//            SYS_EXCEPTION(1, "sysException"),
//            LOGIC_EXCEPTION(2, "logicException");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 0:
//                        return SUCCESS;
//                    case 1:
//                        return SYS_EXCEPTION;
//                    case 2:
//                        return LOGIC_EXCEPTION;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_search_word_package_resultStandardScheme extends C2110c<get_search_word_package_result> {
//            private get_search_word_package_resultStandardScheme() {
//            }
//
//            /* synthetic */ get_search_word_package_resultStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_search_word_package_result get_search_word_package_result) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 0:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_search_word_package_result.success = new BBWordPackage();
//                                    get_search_word_package_result.success.read(fVar);
//                                    get_search_word_package_result.setSuccessIsSet(true);
//                                    break;
//                                }
//                            case 1:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_search_word_package_result.sysException = new BESystemException();
//                                    get_search_word_package_result.sysException.read(fVar);
//                                    get_search_word_package_result.setSysExceptionIsSet(true);
//                                    break;
//                                }
//                            case 2:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_search_word_package_result.logicException = new BELogicException();
//                                    get_search_word_package_result.logicException.read(fVar);
//                                    get_search_word_package_result.setLogicExceptionIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        get_search_word_package_result.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_search_word_package_result get_search_word_package_result) {
//                get_search_word_package_result.validate();
//                get_search_word_package_result.STRUCT_DESC;
//                fVar.mo18490a();
//                if (get_search_word_package_result.success != null) {
//                    fVar.mo18496a(get_search_word_package_result.SUCCESS_FIELD_DESC);
//                    get_search_word_package_result.success.write(fVar);
//                }
//                if (get_search_word_package_result.sysException != null) {
//                    fVar.mo18496a(get_search_word_package_result.SYS_EXCEPTION_FIELD_DESC);
//                    get_search_word_package_result.sysException.write(fVar);
//                }
//                if (get_search_word_package_result.logicException != null) {
//                    fVar.mo18496a(get_search_word_package_result.LOGIC_EXCEPTION_FIELD_DESC);
//                    get_search_word_package_result.logicException.write(fVar);
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class get_search_word_package_resultStandardSchemeFactory implements C2109b {
//            private get_search_word_package_resultStandardSchemeFactory() {
//            }
//
//            /* synthetic */ get_search_word_package_resultStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_search_word_package_resultStandardScheme getScheme() {
//                return new get_search_word_package_resultStandardScheme(null);
//            }
//        }
//
//        class get_search_word_package_resultTupleScheme extends C2111d<get_search_word_package_result> {
//            private get_search_word_package_resultTupleScheme() {
//            }
//
//            /* synthetic */ get_search_word_package_resultTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_search_word_package_result get_search_word_package_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet bitSet = new BitSet();
//                if (get_search_word_package_result.isSetSuccess()) {
//                    bitSet.set(0);
//                }
//                if (get_search_word_package_result.isSetSysException()) {
//                    bitSet.set(1);
//                }
//                if (get_search_word_package_result.isSetLogicException()) {
//                    bitSet.set(2);
//                }
//                lVar.mo18527a(bitSet, 3);
//                if (get_search_word_package_result.isSetSuccess()) {
//                    get_search_word_package_result.success.write(lVar);
//                }
//                if (get_search_word_package_result.isSetSysException()) {
//                    get_search_word_package_result.sysException.write(lVar);
//                }
//                if (get_search_word_package_result.isSetLogicException()) {
//                    get_search_word_package_result.logicException.write(lVar);
//                }
//            }
//
//            public void read(C2100f fVar, get_search_word_package_result get_search_word_package_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet b = lVar.mo18528b(3);
//                if (b.get(0)) {
//                    get_search_word_package_result.success = new BBWordPackage();
//                    get_search_word_package_result.success.read(lVar);
//                    get_search_word_package_result.setSuccessIsSet(true);
//                }
//                if (b.get(1)) {
//                    get_search_word_package_result.sysException = new BESystemException();
//                    get_search_word_package_result.sysException.read(lVar);
//                    get_search_word_package_result.setSysExceptionIsSet(true);
//                }
//                if (b.get(2)) {
//                    get_search_word_package_result.logicException = new BELogicException();
//                    get_search_word_package_result.logicException.read(lVar);
//                    get_search_word_package_result.setLogicExceptionIsSet(true);
//                }
//            }
//        }
//
//        class get_search_word_package_resultTupleSchemeFactory implements C2109b {
//            private get_search_word_package_resultTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_search_word_package_resultTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_search_word_package_resultTupleScheme getScheme() {
//                return new get_search_word_package_resultTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new get_search_word_package_resultStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new get_search_word_package_resultTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.SUCCESS, new C2091a("success", 3, new C2095e(BBWordPackage.class)));
//            enumMap.put(_Fields.SYS_EXCEPTION, new C2091a("sysException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            enumMap.put(_Fields.LOGIC_EXCEPTION, new C2091a("logicException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_search_word_package_result.class, metaDataMap);
//        }
//
//        public get_search_word_package_result() {
//        }
//
//        public get_search_word_package_result(BBWordPackage bBWordPackage, BESystemException bESystemException, BELogicException bELogicException) {
//            this();
//            this.success = bBWordPackage;
//            this.sysException = bESystemException;
//            this.logicException = bELogicException;
//        }
//
//        public get_search_word_package_result(get_search_word_package_result get_search_word_package_result) {
//            if (get_search_word_package_result.isSetSuccess()) {
//                this.success = new BBWordPackage(get_search_word_package_result.success);
//            }
//            if (get_search_word_package_result.isSetSysException()) {
//                this.sysException = new BESystemException(get_search_word_package_result.sysException);
//            }
//            if (get_search_word_package_result.isSetLogicException()) {
//                this.logicException = new BELogicException(get_search_word_package_result.logicException);
//            }
//        }
//
//        public get_search_word_package_result deepCopy() {
//            return new get_search_word_package_result(this);
//        }
//
//        public void clear() {
//            this.success = null;
//            this.sysException = null;
//            this.logicException = null;
//        }
//
//        public BBWordPackage getSuccess() {
//            return this.success;
//        }
//
//        public get_search_word_package_result setSuccess(BBWordPackage bBWordPackage) {
//            this.success = bBWordPackage;
//            return this;
//        }
//
//        public void unsetSuccess() {
//            this.success = null;
//        }
//
//        public boolean isSetSuccess() {
//            return this.success != null;
//        }
//
//        public void setSuccessIsSet(boolean z) {
//            if (!z) {
//                this.success = null;
//            }
//        }
//
//        public BESystemException getSysException() {
//            return this.sysException;
//        }
//
//        public get_search_word_package_result setSysException(BESystemException bESystemException) {
//            this.sysException = bESystemException;
//            return this;
//        }
//
//        public void unsetSysException() {
//            this.sysException = null;
//        }
//
//        public boolean isSetSysException() {
//            return this.sysException != null;
//        }
//
//        public void setSysExceptionIsSet(boolean z) {
//            if (!z) {
//                this.sysException = null;
//            }
//        }
//
//        public BELogicException getLogicException() {
//            return this.logicException;
//        }
//
//        public get_search_word_package_result setLogicException(BELogicException bELogicException) {
//            this.logicException = bELogicException;
//            return this;
//        }
//
//        public void unsetLogicException() {
//            this.logicException = null;
//        }
//
//        public boolean isSetLogicException() {
//            return this.logicException != null;
//        }
//
//        public void setLogicExceptionIsSet(boolean z) {
//            if (!z) {
//                this.logicException = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case SUCCESS:
//                    if (obj == null) {
//                        unsetSuccess();
//                        return;
//                    } else {
//                        setSuccess((BBWordPackage) obj);
//                        return;
//                    }
//                case SYS_EXCEPTION:
//                    if (obj == null) {
//                        unsetSysException();
//                        return;
//                    } else {
//                        setSysException((BESystemException) obj);
//                        return;
//                    }
//                case LOGIC_EXCEPTION:
//                    if (obj == null) {
//                        unsetLogicException();
//                        return;
//                    } else {
//                        setLogicException((BELogicException) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case SUCCESS:
//                    return getSuccess();
//                case SYS_EXCEPTION:
//                    return getSysException();
//                case LOGIC_EXCEPTION:
//                    return getLogicException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case SUCCESS:
//                    return isSetSuccess();
//                case SYS_EXCEPTION:
//                    return isSetSysException();
//                case LOGIC_EXCEPTION:
//                    return isSetLogicException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_search_word_package_result)) {
//                return equals((get_search_word_package_result) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_search_word_package_result get_search_word_package_result) {
//            if (get_search_word_package_result == null) {
//                return false;
//            }
//            boolean isSetSuccess = isSetSuccess();
//            boolean isSetSuccess2 = get_search_word_package_result.isSetSuccess();
//            if ((isSetSuccess || isSetSuccess2) && (!isSetSuccess || !isSetSuccess2 || !this.success.equals(get_search_word_package_result.success))) {
//                return false;
//            }
//            boolean isSetSysException = isSetSysException();
//            boolean isSetSysException2 = get_search_word_package_result.isSetSysException();
//            if ((isSetSysException || isSetSysException2) && (!isSetSysException || !isSetSysException2 || !this.sysException.equals(get_search_word_package_result.sysException))) {
//                return false;
//            }
//            boolean isSetLogicException = isSetLogicException();
//            boolean isSetLogicException2 = get_search_word_package_result.isSetLogicException();
//            if ((isSetLogicException || isSetLogicException2) && (!isSetLogicException || !isSetLogicException2 || !this.logicException.equals(get_search_word_package_result.logicException))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_search_word_package_result get_search_word_package_result) {
//            if (!getClass().equals(get_search_word_package_result.getClass())) {
//                return getClass().getName().compareTo(get_search_word_package_result.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetSuccess()).compareTo(Boolean.valueOf(get_search_word_package_result.isSetSuccess()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetSuccess()) {
//                int a = C2121h.m5524a((Comparable) this.success, (Comparable) get_search_word_package_result.success);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetSysException()).compareTo(Boolean.valueOf(get_search_word_package_result.isSetSysException()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetSysException()) {
//                int a2 = C2121h.m5524a((Comparable) this.sysException, (Comparable) get_search_word_package_result.sysException);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            int compareTo3 = Boolean.valueOf(isSetLogicException()).compareTo(Boolean.valueOf(get_search_word_package_result.isSetLogicException()));
//            if (compareTo3 != 0) {
//                return compareTo3;
//            }
//            if (isSetLogicException()) {
//                int a3 = C2121h.m5524a((Comparable) this.logicException, (Comparable) get_search_word_package_result.logicException);
//                if (a3 != 0) {
//                    return a3;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_search_word_package_result(");
//            sb.append("success:");
//            if (this.success == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.success);
//            }
//            sb.append(", ");
//            sb.append("sysException:");
//            if (this.sysException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.sysException);
//            }
//            sb.append(", ");
//            sb.append("logicException:");
//            if (this.logicException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.logicException);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//            if (this.success != null) {
//                this.success.validate();
//            }
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_similar_words_info_args implements Serializable, Cloneable, Comparable<get_similar_words_info_args>, C2116f<get_similar_words_info_args, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2097b ARR_TOPIC_IDS_FIELD_DESC = new C2097b("arr_topic_ids", 15, 2);
//        /* access modifiers changed from: private */
//        public static final C2097b BOOK_ID_FIELD_DESC = new C2097b("book_id", 8, 1);
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_similar_words_info_args");
//        private static final int __BOOK_ID_ISSET_ID = 0;
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        private byte __isset_bitfield;
//        public List<Integer> arr_topic_ids;
//        public int book_id;
//
//        public enum _Fields implements C2124m {
//            BOOK_ID(1, "book_id"),
//            ARR_TOPIC_IDS(2, "arr_topic_ids");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 1:
//                        return BOOK_ID;
//                    case 2:
//                        return ARR_TOPIC_IDS;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_similar_words_info_argsStandardScheme extends C2110c<get_similar_words_info_args> {
//            private get_similar_words_info_argsStandardScheme() {
//            }
//
//            /* synthetic */ get_similar_words_info_argsStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_similar_words_info_args get_similar_words_info_args) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 1:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_similar_words_info_args.book_id = fVar.mo18513n();
//                                    get_similar_words_info_args.setBook_idIsSet(true);
//                                    break;
//                                }
//                            case 2:
//                                if (g.f5835b != 15) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    C2098c i = fVar.mo18508i();
//                                    get_similar_words_info_args.arr_topic_ids = new ArrayList(i.f5838b);
//                                    for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                        get_similar_words_info_args.arr_topic_ids.add(Integer.valueOf(fVar.mo18513n()));
//                                    }
//                                    get_similar_words_info_args.setArr_topic_idsIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        if (!get_similar_words_info_args.isSetBook_id()) {
//                            throw new C2101g("Required field 'book_id' was not found in serialized data! Struct: " + toString());
//                        }
//                        get_similar_words_info_args.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_similar_words_info_args get_similar_words_info_args) {
//                get_similar_words_info_args.validate();
//                get_similar_words_info_args.STRUCT_DESC;
//                fVar.mo18490a();
//                fVar.mo18496a(get_similar_words_info_args.BOOK_ID_FIELD_DESC);
//                fVar.mo18493a(get_similar_words_info_args.book_id);
//                if (get_similar_words_info_args.arr_topic_ids != null) {
//                    fVar.mo18496a(get_similar_words_info_args.ARR_TOPIC_IDS_FIELD_DESC);
//                    fVar.mo18497a(new C2098c(8, get_similar_words_info_args.arr_topic_ids.size()));
//                    for (Integer intValue : get_similar_words_info_args.arr_topic_ids) {
//                        fVar.mo18493a(intValue.intValue());
//                    }
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class get_similar_words_info_argsStandardSchemeFactory implements C2109b {
//            private get_similar_words_info_argsStandardSchemeFactory() {
//            }
//
//            /* synthetic */ get_similar_words_info_argsStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_similar_words_info_argsStandardScheme getScheme() {
//                return new get_similar_words_info_argsStandardScheme(null);
//            }
//        }
//
//        class get_similar_words_info_argsTupleScheme extends C2111d<get_similar_words_info_args> {
//            private get_similar_words_info_argsTupleScheme() {
//            }
//
//            /* synthetic */ get_similar_words_info_argsTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_similar_words_info_args get_similar_words_info_args) {
//                C2106l lVar = (C2106l) fVar;
//                lVar.mo18493a(get_similar_words_info_args.book_id);
//                lVar.mo18493a(get_similar_words_info_args.arr_topic_ids.size());
//                for (Integer intValue : get_similar_words_info_args.arr_topic_ids) {
//                    lVar.mo18493a(intValue.intValue());
//                }
//            }
//
//            public void read(C2100f fVar, get_similar_words_info_args get_similar_words_info_args) {
//                C2106l lVar = (C2106l) fVar;
//                get_similar_words_info_args.book_id = lVar.mo18513n();
//                get_similar_words_info_args.setBook_idIsSet(true);
//                C2098c cVar = new C2098c(8, lVar.mo18513n());
//                get_similar_words_info_args.arr_topic_ids = new ArrayList(cVar.f5838b);
//                for (int i = 0; i < cVar.f5838b; i++) {
//                    get_similar_words_info_args.arr_topic_ids.add(Integer.valueOf(lVar.mo18513n()));
//                }
//                get_similar_words_info_args.setArr_topic_idsIsSet(true);
//            }
//        }
//
//        class get_similar_words_info_argsTupleSchemeFactory implements C2109b {
//            private get_similar_words_info_argsTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_similar_words_info_argsTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_similar_words_info_argsTupleScheme getScheme() {
//                return new get_similar_words_info_argsTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new get_similar_words_info_argsStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new get_similar_words_info_argsTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.BOOK_ID, new C2091a("book_id", 1, new C2092b(8, 0)));
//            enumMap.put(_Fields.ARR_TOPIC_IDS, new C2091a("arr_topic_ids", 1, new C2093c(new C2092b(8, 0))));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_similar_words_info_args.class, metaDataMap);
//        }
//
//        public get_similar_words_info_args() {
//            this.__isset_bitfield = 0;
//        }
//
//        public get_similar_words_info_args(int i, List<Integer> list) {
//            this();
//            this.book_id = i;
//            setBook_idIsSet(true);
//            this.arr_topic_ids = list;
//        }
//
//        public get_similar_words_info_args(get_similar_words_info_args get_similar_words_info_args) {
//            this.__isset_bitfield = 0;
//            this.__isset_bitfield = get_similar_words_info_args.__isset_bitfield;
//            this.book_id = get_similar_words_info_args.book_id;
//            if (get_similar_words_info_args.isSetArr_topic_ids()) {
//                this.arr_topic_ids = new ArrayList(get_similar_words_info_args.arr_topic_ids);
//            }
//        }
//
//        public get_similar_words_info_args deepCopy() {
//            return new get_similar_words_info_args(this);
//        }
//
//        public void clear() {
//            setBook_idIsSet(false);
//            this.book_id = 0;
//            this.arr_topic_ids = null;
//        }
//
//        public int getBook_id() {
//            return this.book_id;
//        }
//
//        public get_similar_words_info_args setBook_id(int i) {
//            this.book_id = i;
//            setBook_idIsSet(true);
//            return this;
//        }
//
//        public void unsetBook_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//        }
//
//        public boolean isSetBook_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 0);
//        }
//
//        public void setBook_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//        }
//
//        public int getArr_topic_idsSize() {
//            if (this.arr_topic_ids == null) {
//                return 0;
//            }
//            return this.arr_topic_ids.size();
//        }
//
//        public Iterator<Integer> getArr_topic_idsIterator() {
//            if (this.arr_topic_ids == null) {
//                return null;
//            }
//            return this.arr_topic_ids.iterator();
//        }
//
//        public void addToArr_topic_ids(int i) {
//            if (this.arr_topic_ids == null) {
//                this.arr_topic_ids = new ArrayList();
//            }
//            this.arr_topic_ids.add(Integer.valueOf(i));
//        }
//
//        public List<Integer> getArr_topic_ids() {
//            return this.arr_topic_ids;
//        }
//
//        public get_similar_words_info_args setArr_topic_ids(List<Integer> list) {
//            this.arr_topic_ids = list;
//            return this;
//        }
//
//        public void unsetArr_topic_ids() {
//            this.arr_topic_ids = null;
//        }
//
//        public boolean isSetArr_topic_ids() {
//            return this.arr_topic_ids != null;
//        }
//
//        public void setArr_topic_idsIsSet(boolean z) {
//            if (!z) {
//                this.arr_topic_ids = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case BOOK_ID:
//                    if (obj == null) {
//                        unsetBook_id();
//                        return;
//                    } else {
//                        setBook_id(((Integer) obj).intValue());
//                        return;
//                    }
//                case ARR_TOPIC_IDS:
//                    if (obj == null) {
//                        unsetArr_topic_ids();
//                        return;
//                    } else {
//                        setArr_topic_ids((List) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case BOOK_ID:
//                    return Integer.valueOf(getBook_id());
//                case ARR_TOPIC_IDS:
//                    return getArr_topic_ids();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case BOOK_ID:
//                    return isSetBook_id();
//                case ARR_TOPIC_IDS:
//                    return isSetArr_topic_ids();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_similar_words_info_args)) {
//                return equals((get_similar_words_info_args) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_similar_words_info_args get_similar_words_info_args) {
//            if (get_similar_words_info_args == null || this.book_id != get_similar_words_info_args.book_id) {
//                return false;
//            }
//            boolean isSetArr_topic_ids = isSetArr_topic_ids();
//            boolean isSetArr_topic_ids2 = get_similar_words_info_args.isSetArr_topic_ids();
//            if ((isSetArr_topic_ids || isSetArr_topic_ids2) && (!isSetArr_topic_ids || !isSetArr_topic_ids2 || !this.arr_topic_ids.equals(get_similar_words_info_args.arr_topic_ids))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_similar_words_info_args get_similar_words_info_args) {
//            if (!getClass().equals(get_similar_words_info_args.getClass())) {
//                return getClass().getName().compareTo(get_similar_words_info_args.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetBook_id()).compareTo(Boolean.valueOf(get_similar_words_info_args.isSetBook_id()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetBook_id()) {
//                int a = C2121h.m5522a(this.book_id, get_similar_words_info_args.book_id);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetArr_topic_ids()).compareTo(Boolean.valueOf(get_similar_words_info_args.isSetArr_topic_ids()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetArr_topic_ids()) {
//                int a2 = C2121h.m5526a((List) this.arr_topic_ids, (List) get_similar_words_info_args.arr_topic_ids);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_similar_words_info_args(");
//            sb.append("book_id:");
//            sb.append(this.book_id);
//            sb.append(", ");
//            sb.append("arr_topic_ids:");
//            if (this.arr_topic_ids == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.arr_topic_ids);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//            if (this.arr_topic_ids == null) {
//                throw new C2101g("Required field 'arr_topic_ids' was not present! Struct: " + toString());
//            }
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                this.__isset_bitfield = 0;
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_similar_words_info_result implements Serializable, Cloneable, Comparable<get_similar_words_info_result>, C2116f<get_similar_words_info_result, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_similar_words_info_result");
//        /* access modifiers changed from: private */
//        public static final C2097b SUCCESS_FIELD_DESC = new C2097b("success", 15, 0);
//        /* access modifiers changed from: private */
//        public static final C2097b SYS_EXCEPTION_FIELD_DESC = new C2097b("sysException", JceStruct.ZERO_TAG, 1);
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        public List<BBSimilarWordInfo> success;
//        public BESystemException sysException;
//
//        public enum _Fields implements C2124m {
//            SUCCESS(0, "success"),
//            SYS_EXCEPTION(1, "sysException");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 0:
//                        return SUCCESS;
//                    case 1:
//                        return SYS_EXCEPTION;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_similar_words_info_resultStandardScheme extends C2110c<get_similar_words_info_result> {
//            private get_similar_words_info_resultStandardScheme() {
//            }
//
//            /* synthetic */ get_similar_words_info_resultStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_similar_words_info_result get_similar_words_info_result) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 0:
//                                if (g.f5835b != 15) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    C2098c i = fVar.mo18508i();
//                                    get_similar_words_info_result.success = new ArrayList(i.f5838b);
//                                    for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                        BBSimilarWordInfo bBSimilarWordInfo = new BBSimilarWordInfo();
//                                        bBSimilarWordInfo.read(fVar);
//                                        get_similar_words_info_result.success.add(bBSimilarWordInfo);
//                                    }
//                                    get_similar_words_info_result.setSuccessIsSet(true);
//                                    break;
//                                }
//                            case 1:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_similar_words_info_result.sysException = new BESystemException();
//                                    get_similar_words_info_result.sysException.read(fVar);
//                                    get_similar_words_info_result.setSysExceptionIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        get_similar_words_info_result.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_similar_words_info_result get_similar_words_info_result) {
//                get_similar_words_info_result.validate();
//                get_similar_words_info_result.STRUCT_DESC;
//                fVar.mo18490a();
//                if (get_similar_words_info_result.success != null) {
//                    fVar.mo18496a(get_similar_words_info_result.SUCCESS_FIELD_DESC);
//                    fVar.mo18497a(new C2098c(JceStruct.ZERO_TAG, get_similar_words_info_result.success.size()));
//                    for (BBSimilarWordInfo write : get_similar_words_info_result.success) {
//                        write.write(fVar);
//                    }
//                }
//                if (get_similar_words_info_result.sysException != null) {
//                    fVar.mo18496a(get_similar_words_info_result.SYS_EXCEPTION_FIELD_DESC);
//                    get_similar_words_info_result.sysException.write(fVar);
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class get_similar_words_info_resultStandardSchemeFactory implements C2109b {
//            private get_similar_words_info_resultStandardSchemeFactory() {
//            }
//
//            /* synthetic */ get_similar_words_info_resultStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_similar_words_info_resultStandardScheme getScheme() {
//                return new get_similar_words_info_resultStandardScheme(null);
//            }
//        }
//
//        class get_similar_words_info_resultTupleScheme extends C2111d<get_similar_words_info_result> {
//            private get_similar_words_info_resultTupleScheme() {
//            }
//
//            /* synthetic */ get_similar_words_info_resultTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_similar_words_info_result get_similar_words_info_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet bitSet = new BitSet();
//                if (get_similar_words_info_result.isSetSuccess()) {
//                    bitSet.set(0);
//                }
//                if (get_similar_words_info_result.isSetSysException()) {
//                    bitSet.set(1);
//                }
//                lVar.mo18527a(bitSet, 2);
//                if (get_similar_words_info_result.isSetSuccess()) {
//                    lVar.mo18493a(get_similar_words_info_result.success.size());
//                    for (BBSimilarWordInfo write : get_similar_words_info_result.success) {
//                        write.write(lVar);
//                    }
//                }
//                if (get_similar_words_info_result.isSetSysException()) {
//                    get_similar_words_info_result.sysException.write(lVar);
//                }
//            }
//
//            public void read(C2100f fVar, get_similar_words_info_result get_similar_words_info_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet b = lVar.mo18528b(2);
//                if (b.get(0)) {
//                    C2098c cVar = new C2098c(JceStruct.ZERO_TAG, lVar.mo18513n());
//                    get_similar_words_info_result.success = new ArrayList(cVar.f5838b);
//                    for (int i = 0; i < cVar.f5838b; i++) {
//                        BBSimilarWordInfo bBSimilarWordInfo = new BBSimilarWordInfo();
//                        bBSimilarWordInfo.read(lVar);
//                        get_similar_words_info_result.success.add(bBSimilarWordInfo);
//                    }
//                    get_similar_words_info_result.setSuccessIsSet(true);
//                }
//                if (b.get(1)) {
//                    get_similar_words_info_result.sysException = new BESystemException();
//                    get_similar_words_info_result.sysException.read(lVar);
//                    get_similar_words_info_result.setSysExceptionIsSet(true);
//                }
//            }
//        }
//
//        class get_similar_words_info_resultTupleSchemeFactory implements C2109b {
//            private get_similar_words_info_resultTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_similar_words_info_resultTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_similar_words_info_resultTupleScheme getScheme() {
//                return new get_similar_words_info_resultTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new get_similar_words_info_resultStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new get_similar_words_info_resultTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.SUCCESS, new C2091a("success", 3, new C2093c(new C2095e(BBSimilarWordInfo.class))));
//            enumMap.put(_Fields.SYS_EXCEPTION, new C2091a("sysException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_similar_words_info_result.class, metaDataMap);
//        }
//
//        public get_similar_words_info_result() {
//        }
//
//        public get_similar_words_info_result(List<BBSimilarWordInfo> list, BESystemException bESystemException) {
//            this();
//            this.success = list;
//            this.sysException = bESystemException;
//        }
//
//        public get_similar_words_info_result(get_similar_words_info_result get_similar_words_info_result) {
//            if (get_similar_words_info_result.isSetSuccess()) {
//                ArrayList arrayList = new ArrayList(get_similar_words_info_result.success.size());
//                for (BBSimilarWordInfo bBSimilarWordInfo : get_similar_words_info_result.success) {
//                    arrayList.add(new BBSimilarWordInfo(bBSimilarWordInfo));
//                }
//                this.success = arrayList;
//            }
//            if (get_similar_words_info_result.isSetSysException()) {
//                this.sysException = new BESystemException(get_similar_words_info_result.sysException);
//            }
//        }
//
//        public get_similar_words_info_result deepCopy() {
//            return new get_similar_words_info_result(this);
//        }
//
//        public void clear() {
//            this.success = null;
//            this.sysException = null;
//        }
//
//        public int getSuccessSize() {
//            if (this.success == null) {
//                return 0;
//            }
//            return this.success.size();
//        }
//
//        public Iterator<BBSimilarWordInfo> getSuccessIterator() {
//            if (this.success == null) {
//                return null;
//            }
//            return this.success.iterator();
//        }
//
//        public void addToSuccess(BBSimilarWordInfo bBSimilarWordInfo) {
//            if (this.success == null) {
//                this.success = new ArrayList();
//            }
//            this.success.add(bBSimilarWordInfo);
//        }
//
//        public List<BBSimilarWordInfo> getSuccess() {
//            return this.success;
//        }
//
//        public get_similar_words_info_result setSuccess(List<BBSimilarWordInfo> list) {
//            this.success = list;
//            return this;
//        }
//
//        public void unsetSuccess() {
//            this.success = null;
//        }
//
//        public boolean isSetSuccess() {
//            return this.success != null;
//        }
//
//        public void setSuccessIsSet(boolean z) {
//            if (!z) {
//                this.success = null;
//            }
//        }
//
//        public BESystemException getSysException() {
//            return this.sysException;
//        }
//
//        public get_similar_words_info_result setSysException(BESystemException bESystemException) {
//            this.sysException = bESystemException;
//            return this;
//        }
//
//        public void unsetSysException() {
//            this.sysException = null;
//        }
//
//        public boolean isSetSysException() {
//            return this.sysException != null;
//        }
//
//        public void setSysExceptionIsSet(boolean z) {
//            if (!z) {
//                this.sysException = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case SUCCESS:
//                    if (obj == null) {
//                        unsetSuccess();
//                        return;
//                    } else {
//                        setSuccess((List) obj);
//                        return;
//                    }
//                case SYS_EXCEPTION:
//                    if (obj == null) {
//                        unsetSysException();
//                        return;
//                    } else {
//                        setSysException((BESystemException) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case SUCCESS:
//                    return getSuccess();
//                case SYS_EXCEPTION:
//                    return getSysException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case SUCCESS:
//                    return isSetSuccess();
//                case SYS_EXCEPTION:
//                    return isSetSysException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_similar_words_info_result)) {
//                return equals((get_similar_words_info_result) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_similar_words_info_result get_similar_words_info_result) {
//            if (get_similar_words_info_result == null) {
//                return false;
//            }
//            boolean isSetSuccess = isSetSuccess();
//            boolean isSetSuccess2 = get_similar_words_info_result.isSetSuccess();
//            if ((isSetSuccess || isSetSuccess2) && (!isSetSuccess || !isSetSuccess2 || !this.success.equals(get_similar_words_info_result.success))) {
//                return false;
//            }
//            boolean isSetSysException = isSetSysException();
//            boolean isSetSysException2 = get_similar_words_info_result.isSetSysException();
//            if ((isSetSysException || isSetSysException2) && (!isSetSysException || !isSetSysException2 || !this.sysException.equals(get_similar_words_info_result.sysException))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_similar_words_info_result get_similar_words_info_result) {
//            if (!getClass().equals(get_similar_words_info_result.getClass())) {
//                return getClass().getName().compareTo(get_similar_words_info_result.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetSuccess()).compareTo(Boolean.valueOf(get_similar_words_info_result.isSetSuccess()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetSuccess()) {
//                int a = C2121h.m5526a((List) this.success, (List) get_similar_words_info_result.success);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetSysException()).compareTo(Boolean.valueOf(get_similar_words_info_result.isSetSysException()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetSysException()) {
//                int a2 = C2121h.m5524a((Comparable) this.sysException, (Comparable) get_similar_words_info_result.sysException);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_similar_words_info_result(");
//            sb.append("success:");
//            if (this.success == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.success);
//            }
//            sb.append(", ");
//            sb.append("sysException:");
//            if (this.sysException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.sysException);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_word_asset_pack_info_args implements Serializable, Cloneable, Comparable<get_word_asset_pack_info_args>, C2116f<get_word_asset_pack_info_args, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_word_asset_pack_info_args");
//        /* access modifiers changed from: private */
//        public static final C2097b WORD_LEVEL_ID_FIELD_DESC = new C2097b("word_level_id", 8, 1);
//        private static final int __WORD_LEVEL_ID_ISSET_ID = 0;
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        private byte __isset_bitfield;
//        public int word_level_id;
//
//        public enum _Fields implements C2124m {
//            WORD_LEVEL_ID(1, "word_level_id");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 1:
//                        return WORD_LEVEL_ID;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_word_asset_pack_info_argsStandardScheme extends C2110c<get_word_asset_pack_info_args> {
//            private get_word_asset_pack_info_argsStandardScheme() {
//            }
//
//            /* synthetic */ get_word_asset_pack_info_argsStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_word_asset_pack_info_args get_word_asset_pack_info_args) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 1:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_asset_pack_info_args.word_level_id = fVar.mo18513n();
//                                    get_word_asset_pack_info_args.setWord_level_idIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        if (!get_word_asset_pack_info_args.isSetWord_level_id()) {
//                            throw new C2101g("Required field 'word_level_id' was not found in serialized data! Struct: " + toString());
//                        }
//                        get_word_asset_pack_info_args.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_word_asset_pack_info_args get_word_asset_pack_info_args) {
//                get_word_asset_pack_info_args.validate();
//                get_word_asset_pack_info_args.STRUCT_DESC;
//                fVar.mo18490a();
//                fVar.mo18496a(get_word_asset_pack_info_args.WORD_LEVEL_ID_FIELD_DESC);
//                fVar.mo18493a(get_word_asset_pack_info_args.word_level_id);
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class get_word_asset_pack_info_argsStandardSchemeFactory implements C2109b {
//            private get_word_asset_pack_info_argsStandardSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_asset_pack_info_argsStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_asset_pack_info_argsStandardScheme getScheme() {
//                return new get_word_asset_pack_info_argsStandardScheme(null);
//            }
//        }
//
//        class get_word_asset_pack_info_argsTupleScheme extends C2111d<get_word_asset_pack_info_args> {
//            private get_word_asset_pack_info_argsTupleScheme() {
//            }
//
//            /* synthetic */ get_word_asset_pack_info_argsTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_word_asset_pack_info_args get_word_asset_pack_info_args) {
//                ((C2106l) fVar).mo18493a(get_word_asset_pack_info_args.word_level_id);
//            }
//
//            public void read(C2100f fVar, get_word_asset_pack_info_args get_word_asset_pack_info_args) {
//                get_word_asset_pack_info_args.word_level_id = ((C2106l) fVar).mo18513n();
//                get_word_asset_pack_info_args.setWord_level_idIsSet(true);
//            }
//        }
//
//        class get_word_asset_pack_info_argsTupleSchemeFactory implements C2109b {
//            private get_word_asset_pack_info_argsTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_asset_pack_info_argsTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_asset_pack_info_argsTupleScheme getScheme() {
//                return new get_word_asset_pack_info_argsTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new get_word_asset_pack_info_argsStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new get_word_asset_pack_info_argsTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.WORD_LEVEL_ID, new C2091a("word_level_id", 1, new C2092b(8, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_word_asset_pack_info_args.class, metaDataMap);
//        }
//
//        public get_word_asset_pack_info_args() {
//            this.__isset_bitfield = 0;
//        }
//
//        public get_word_asset_pack_info_args(int i) {
//            this();
//            this.word_level_id = i;
//            setWord_level_idIsSet(true);
//        }
//
//        public get_word_asset_pack_info_args(get_word_asset_pack_info_args get_word_asset_pack_info_args) {
//            this.__isset_bitfield = 0;
//            this.__isset_bitfield = get_word_asset_pack_info_args.__isset_bitfield;
//            this.word_level_id = get_word_asset_pack_info_args.word_level_id;
//        }
//
//        public get_word_asset_pack_info_args deepCopy() {
//            return new get_word_asset_pack_info_args(this);
//        }
//
//        public void clear() {
//            setWord_level_idIsSet(false);
//            this.word_level_id = 0;
//        }
//
//        public int getWord_level_id() {
//            return this.word_level_id;
//        }
//
//        public get_word_asset_pack_info_args setWord_level_id(int i) {
//            this.word_level_id = i;
//            setWord_level_idIsSet(true);
//            return this;
//        }
//
//        public void unsetWord_level_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//        }
//
//        public boolean isSetWord_level_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 0);
//        }
//
//        public void setWord_level_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case WORD_LEVEL_ID:
//                    if (obj == null) {
//                        unsetWord_level_id();
//                        return;
//                    } else {
//                        setWord_level_id(((Integer) obj).intValue());
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case WORD_LEVEL_ID:
//                    return Integer.valueOf(getWord_level_id());
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case WORD_LEVEL_ID:
//                    return isSetWord_level_id();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_word_asset_pack_info_args)) {
//                return equals((get_word_asset_pack_info_args) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_word_asset_pack_info_args get_word_asset_pack_info_args) {
//            if (get_word_asset_pack_info_args != null && this.word_level_id == get_word_asset_pack_info_args.word_level_id) {
//                return true;
//            }
//            return false;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_word_asset_pack_info_args get_word_asset_pack_info_args) {
//            if (!getClass().equals(get_word_asset_pack_info_args.getClass())) {
//                return getClass().getName().compareTo(get_word_asset_pack_info_args.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetWord_level_id()).compareTo(Boolean.valueOf(get_word_asset_pack_info_args.isSetWord_level_id()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetWord_level_id()) {
//                int a = C2121h.m5522a(this.word_level_id, get_word_asset_pack_info_args.word_level_id);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_word_asset_pack_info_args(");
//            sb.append("word_level_id:");
//            sb.append(this.word_level_id);
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                this.__isset_bitfield = 0;
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_word_asset_pack_info_result implements Serializable, Cloneable, Comparable<get_word_asset_pack_info_result>, C2116f<get_word_asset_pack_info_result, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2097b LOGIC_EXCEPTION_FIELD_DESC = new C2097b("logicException", JceStruct.ZERO_TAG, 2);
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_word_asset_pack_info_result");
//        /* access modifiers changed from: private */
//        public static final C2097b SUCCESS_FIELD_DESC = new C2097b("success", 15, 0);
//        /* access modifiers changed from: private */
//        public static final C2097b SYS_EXCEPTION_FIELD_DESC = new C2097b("sysException", JceStruct.ZERO_TAG, 1);
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        public BELogicException logicException;
//        public List<BBWordAssetPackInfo> success;
//        public BESystemException sysException;
//
//        public enum _Fields implements C2124m {
//            SUCCESS(0, "success"),
//            SYS_EXCEPTION(1, "sysException"),
//            LOGIC_EXCEPTION(2, "logicException");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 0:
//                        return SUCCESS;
//                    case 1:
//                        return SYS_EXCEPTION;
//                    case 2:
//                        return LOGIC_EXCEPTION;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_word_asset_pack_info_resultStandardScheme extends C2110c<get_word_asset_pack_info_result> {
//            private get_word_asset_pack_info_resultStandardScheme() {
//            }
//
//            /* synthetic */ get_word_asset_pack_info_resultStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_word_asset_pack_info_result get_word_asset_pack_info_result) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 0:
//                                if (g.f5835b != 15) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    C2098c i = fVar.mo18508i();
//                                    get_word_asset_pack_info_result.success = new ArrayList(i.f5838b);
//                                    for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                        BBWordAssetPackInfo bBWordAssetPackInfo = new BBWordAssetPackInfo();
//                                        bBWordAssetPackInfo.read(fVar);
//                                        get_word_asset_pack_info_result.success.add(bBWordAssetPackInfo);
//                                    }
//                                    get_word_asset_pack_info_result.setSuccessIsSet(true);
//                                    break;
//                                }
//                            case 1:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_asset_pack_info_result.sysException = new BESystemException();
//                                    get_word_asset_pack_info_result.sysException.read(fVar);
//                                    get_word_asset_pack_info_result.setSysExceptionIsSet(true);
//                                    break;
//                                }
//                            case 2:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_asset_pack_info_result.logicException = new BELogicException();
//                                    get_word_asset_pack_info_result.logicException.read(fVar);
//                                    get_word_asset_pack_info_result.setLogicExceptionIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        get_word_asset_pack_info_result.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_word_asset_pack_info_result get_word_asset_pack_info_result) {
//                get_word_asset_pack_info_result.validate();
//                get_word_asset_pack_info_result.STRUCT_DESC;
//                fVar.mo18490a();
//                if (get_word_asset_pack_info_result.success != null) {
//                    fVar.mo18496a(get_word_asset_pack_info_result.SUCCESS_FIELD_DESC);
//                    fVar.mo18497a(new C2098c(JceStruct.ZERO_TAG, get_word_asset_pack_info_result.success.size()));
//                    for (BBWordAssetPackInfo write : get_word_asset_pack_info_result.success) {
//                        write.write(fVar);
//                    }
//                }
//                if (get_word_asset_pack_info_result.sysException != null) {
//                    fVar.mo18496a(get_word_asset_pack_info_result.SYS_EXCEPTION_FIELD_DESC);
//                    get_word_asset_pack_info_result.sysException.write(fVar);
//                }
//                if (get_word_asset_pack_info_result.logicException != null) {
//                    fVar.mo18496a(get_word_asset_pack_info_result.LOGIC_EXCEPTION_FIELD_DESC);
//                    get_word_asset_pack_info_result.logicException.write(fVar);
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class get_word_asset_pack_info_resultStandardSchemeFactory implements C2109b {
//            private get_word_asset_pack_info_resultStandardSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_asset_pack_info_resultStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_asset_pack_info_resultStandardScheme getScheme() {
//                return new get_word_asset_pack_info_resultStandardScheme(null);
//            }
//        }
//
//        class get_word_asset_pack_info_resultTupleScheme extends C2111d<get_word_asset_pack_info_result> {
//            private get_word_asset_pack_info_resultTupleScheme() {
//            }
//
//            /* synthetic */ get_word_asset_pack_info_resultTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_word_asset_pack_info_result get_word_asset_pack_info_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet bitSet = new BitSet();
//                if (get_word_asset_pack_info_result.isSetSuccess()) {
//                    bitSet.set(0);
//                }
//                if (get_word_asset_pack_info_result.isSetSysException()) {
//                    bitSet.set(1);
//                }
//                if (get_word_asset_pack_info_result.isSetLogicException()) {
//                    bitSet.set(2);
//                }
//                lVar.mo18527a(bitSet, 3);
//                if (get_word_asset_pack_info_result.isSetSuccess()) {
//                    lVar.mo18493a(get_word_asset_pack_info_result.success.size());
//                    for (BBWordAssetPackInfo write : get_word_asset_pack_info_result.success) {
//                        write.write(lVar);
//                    }
//                }
//                if (get_word_asset_pack_info_result.isSetSysException()) {
//                    get_word_asset_pack_info_result.sysException.write(lVar);
//                }
//                if (get_word_asset_pack_info_result.isSetLogicException()) {
//                    get_word_asset_pack_info_result.logicException.write(lVar);
//                }
//            }
//
//            public void read(C2100f fVar, get_word_asset_pack_info_result get_word_asset_pack_info_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet b = lVar.mo18528b(3);
//                if (b.get(0)) {
//                    C2098c cVar = new C2098c(JceStruct.ZERO_TAG, lVar.mo18513n());
//                    get_word_asset_pack_info_result.success = new ArrayList(cVar.f5838b);
//                    for (int i = 0; i < cVar.f5838b; i++) {
//                        BBWordAssetPackInfo bBWordAssetPackInfo = new BBWordAssetPackInfo();
//                        bBWordAssetPackInfo.read(lVar);
//                        get_word_asset_pack_info_result.success.add(bBWordAssetPackInfo);
//                    }
//                    get_word_asset_pack_info_result.setSuccessIsSet(true);
//                }
//                if (b.get(1)) {
//                    get_word_asset_pack_info_result.sysException = new BESystemException();
//                    get_word_asset_pack_info_result.sysException.read(lVar);
//                    get_word_asset_pack_info_result.setSysExceptionIsSet(true);
//                }
//                if (b.get(2)) {
//                    get_word_asset_pack_info_result.logicException = new BELogicException();
//                    get_word_asset_pack_info_result.logicException.read(lVar);
//                    get_word_asset_pack_info_result.setLogicExceptionIsSet(true);
//                }
//            }
//        }
//
//        class get_word_asset_pack_info_resultTupleSchemeFactory implements C2109b {
//            private get_word_asset_pack_info_resultTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_asset_pack_info_resultTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_asset_pack_info_resultTupleScheme getScheme() {
//                return new get_word_asset_pack_info_resultTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new get_word_asset_pack_info_resultStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new get_word_asset_pack_info_resultTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.SUCCESS, new C2091a("success", 3, new C2093c(new C2095e(BBWordAssetPackInfo.class))));
//            enumMap.put(_Fields.SYS_EXCEPTION, new C2091a("sysException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            enumMap.put(_Fields.LOGIC_EXCEPTION, new C2091a("logicException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_word_asset_pack_info_result.class, metaDataMap);
//        }
//
//        public get_word_asset_pack_info_result() {
//        }
//
//        public get_word_asset_pack_info_result(List<BBWordAssetPackInfo> list, BESystemException bESystemException, BELogicException bELogicException) {
//            this();
//            this.success = list;
//            this.sysException = bESystemException;
//            this.logicException = bELogicException;
//        }
//
//        public get_word_asset_pack_info_result(get_word_asset_pack_info_result get_word_asset_pack_info_result) {
//            if (get_word_asset_pack_info_result.isSetSuccess()) {
//                ArrayList arrayList = new ArrayList(get_word_asset_pack_info_result.success.size());
//                for (BBWordAssetPackInfo bBWordAssetPackInfo : get_word_asset_pack_info_result.success) {
//                    arrayList.add(new BBWordAssetPackInfo(bBWordAssetPackInfo));
//                }
//                this.success = arrayList;
//            }
//            if (get_word_asset_pack_info_result.isSetSysException()) {
//                this.sysException = new BESystemException(get_word_asset_pack_info_result.sysException);
//            }
//            if (get_word_asset_pack_info_result.isSetLogicException()) {
//                this.logicException = new BELogicException(get_word_asset_pack_info_result.logicException);
//            }
//        }
//
//        public get_word_asset_pack_info_result deepCopy() {
//            return new get_word_asset_pack_info_result(this);
//        }
//
//        public void clear() {
//            this.success = null;
//            this.sysException = null;
//            this.logicException = null;
//        }
//
//        public int getSuccessSize() {
//            if (this.success == null) {
//                return 0;
//            }
//            return this.success.size();
//        }
//
//        public Iterator<BBWordAssetPackInfo> getSuccessIterator() {
//            if (this.success == null) {
//                return null;
//            }
//            return this.success.iterator();
//        }
//
//        public void addToSuccess(BBWordAssetPackInfo bBWordAssetPackInfo) {
//            if (this.success == null) {
//                this.success = new ArrayList();
//            }
//            this.success.add(bBWordAssetPackInfo);
//        }
//
//        public List<BBWordAssetPackInfo> getSuccess() {
//            return this.success;
//        }
//
//        public get_word_asset_pack_info_result setSuccess(List<BBWordAssetPackInfo> list) {
//            this.success = list;
//            return this;
//        }
//
//        public void unsetSuccess() {
//            this.success = null;
//        }
//
//        public boolean isSetSuccess() {
//            return this.success != null;
//        }
//
//        public void setSuccessIsSet(boolean z) {
//            if (!z) {
//                this.success = null;
//            }
//        }
//
//        public BESystemException getSysException() {
//            return this.sysException;
//        }
//
//        public get_word_asset_pack_info_result setSysException(BESystemException bESystemException) {
//            this.sysException = bESystemException;
//            return this;
//        }
//
//        public void unsetSysException() {
//            this.sysException = null;
//        }
//
//        public boolean isSetSysException() {
//            return this.sysException != null;
//        }
//
//        public void setSysExceptionIsSet(boolean z) {
//            if (!z) {
//                this.sysException = null;
//            }
//        }
//
//        public BELogicException getLogicException() {
//            return this.logicException;
//        }
//
//        public get_word_asset_pack_info_result setLogicException(BELogicException bELogicException) {
//            this.logicException = bELogicException;
//            return this;
//        }
//
//        public void unsetLogicException() {
//            this.logicException = null;
//        }
//
//        public boolean isSetLogicException() {
//            return this.logicException != null;
//        }
//
//        public void setLogicExceptionIsSet(boolean z) {
//            if (!z) {
//                this.logicException = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case SUCCESS:
//                    if (obj == null) {
//                        unsetSuccess();
//                        return;
//                    } else {
//                        setSuccess((List) obj);
//                        return;
//                    }
//                case SYS_EXCEPTION:
//                    if (obj == null) {
//                        unsetSysException();
//                        return;
//                    } else {
//                        setSysException((BESystemException) obj);
//                        return;
//                    }
//                case LOGIC_EXCEPTION:
//                    if (obj == null) {
//                        unsetLogicException();
//                        return;
//                    } else {
//                        setLogicException((BELogicException) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case SUCCESS:
//                    return getSuccess();
//                case SYS_EXCEPTION:
//                    return getSysException();
//                case LOGIC_EXCEPTION:
//                    return getLogicException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case SUCCESS:
//                    return isSetSuccess();
//                case SYS_EXCEPTION:
//                    return isSetSysException();
//                case LOGIC_EXCEPTION:
//                    return isSetLogicException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_word_asset_pack_info_result)) {
//                return equals((get_word_asset_pack_info_result) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_word_asset_pack_info_result get_word_asset_pack_info_result) {
//            if (get_word_asset_pack_info_result == null) {
//                return false;
//            }
//            boolean isSetSuccess = isSetSuccess();
//            boolean isSetSuccess2 = get_word_asset_pack_info_result.isSetSuccess();
//            if ((isSetSuccess || isSetSuccess2) && (!isSetSuccess || !isSetSuccess2 || !this.success.equals(get_word_asset_pack_info_result.success))) {
//                return false;
//            }
//            boolean isSetSysException = isSetSysException();
//            boolean isSetSysException2 = get_word_asset_pack_info_result.isSetSysException();
//            if ((isSetSysException || isSetSysException2) && (!isSetSysException || !isSetSysException2 || !this.sysException.equals(get_word_asset_pack_info_result.sysException))) {
//                return false;
//            }
//            boolean isSetLogicException = isSetLogicException();
//            boolean isSetLogicException2 = get_word_asset_pack_info_result.isSetLogicException();
//            if ((isSetLogicException || isSetLogicException2) && (!isSetLogicException || !isSetLogicException2 || !this.logicException.equals(get_word_asset_pack_info_result.logicException))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_word_asset_pack_info_result get_word_asset_pack_info_result) {
//            if (!getClass().equals(get_word_asset_pack_info_result.getClass())) {
//                return getClass().getName().compareTo(get_word_asset_pack_info_result.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetSuccess()).compareTo(Boolean.valueOf(get_word_asset_pack_info_result.isSetSuccess()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetSuccess()) {
//                int a = C2121h.m5526a((List) this.success, (List) get_word_asset_pack_info_result.success);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetSysException()).compareTo(Boolean.valueOf(get_word_asset_pack_info_result.isSetSysException()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetSysException()) {
//                int a2 = C2121h.m5524a((Comparable) this.sysException, (Comparable) get_word_asset_pack_info_result.sysException);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            int compareTo3 = Boolean.valueOf(isSetLogicException()).compareTo(Boolean.valueOf(get_word_asset_pack_info_result.isSetLogicException()));
//            if (compareTo3 != 0) {
//                return compareTo3;
//            }
//            if (isSetLogicException()) {
//                int a3 = C2121h.m5524a((Comparable) this.logicException, (Comparable) get_word_asset_pack_info_result.logicException);
//                if (a3 != 0) {
//                    return a3;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_word_asset_pack_info_result(");
//            sb.append("success:");
//            if (this.success == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.success);
//            }
//            sb.append(", ");
//            sb.append("sysException:");
//            if (this.sysException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.sysException);
//            }
//            sb.append(", ");
//            sb.append("logicException:");
//            if (this.logicException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.logicException);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_word_assets_info_by_topic_and_book_id_args implements Serializable, Cloneable, Comparable<get_word_assets_info_by_topic_and_book_id_args>, C2116f<get_word_assets_info_by_topic_and_book_id_args, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2097b ARR_TOPIC_AND_BOOK_IDS_FIELD_DESC = new C2097b("arr_topic_and_book_ids", 15, 1);
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_word_assets_info_by_topic_and_book_id_args");
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        public List<BBGetWordAssetInfoArg> arr_topic_and_book_ids;
//
//        public enum _Fields implements C2124m {
//            ARR_TOPIC_AND_BOOK_IDS(1, "arr_topic_and_book_ids");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 1:
//                        return ARR_TOPIC_AND_BOOK_IDS;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_word_assets_info_by_topic_and_book_id_argsStandardScheme extends C2110c<get_word_assets_info_by_topic_and_book_id_args> {
//            private get_word_assets_info_by_topic_and_book_id_argsStandardScheme() {
//            }
//
//            /* synthetic */ get_word_assets_info_by_topic_and_book_id_argsStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_word_assets_info_by_topic_and_book_id_args get_word_assets_info_by_topic_and_book_id_args) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 1:
//                                if (g.f5835b != 15) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    C2098c i = fVar.mo18508i();
//                                    get_word_assets_info_by_topic_and_book_id_args.arr_topic_and_book_ids = new ArrayList(i.f5838b);
//                                    for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                        BBGetWordAssetInfoArg bBGetWordAssetInfoArg = new BBGetWordAssetInfoArg();
//                                        bBGetWordAssetInfoArg.read(fVar);
//                                        get_word_assets_info_by_topic_and_book_id_args.arr_topic_and_book_ids.add(bBGetWordAssetInfoArg);
//                                    }
//                                    get_word_assets_info_by_topic_and_book_id_args.setArr_topic_and_book_idsIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        get_word_assets_info_by_topic_and_book_id_args.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_word_assets_info_by_topic_and_book_id_args get_word_assets_info_by_topic_and_book_id_args) {
//                get_word_assets_info_by_topic_and_book_id_args.validate();
//                get_word_assets_info_by_topic_and_book_id_args.STRUCT_DESC;
//                fVar.mo18490a();
//                if (get_word_assets_info_by_topic_and_book_id_args.arr_topic_and_book_ids != null) {
//                    fVar.mo18496a(get_word_assets_info_by_topic_and_book_id_args.ARR_TOPIC_AND_BOOK_IDS_FIELD_DESC);
//                    fVar.mo18497a(new C2098c(JceStruct.ZERO_TAG, get_word_assets_info_by_topic_and_book_id_args.arr_topic_and_book_ids.size()));
//                    for (BBGetWordAssetInfoArg write : get_word_assets_info_by_topic_and_book_id_args.arr_topic_and_book_ids) {
//                        write.write(fVar);
//                    }
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        /* renamed from: com.baicizhan.online.bs_words.BSWords$get_word_assets_info_by_topic_and_book_id_args$get_word_assets_info_by_topic_and_book_id_argsStandardSchemeFactory */
//        class C1382x39e9ed7e implements C2109b {
//            private C1382x39e9ed7e() {
//            }
//
//            /* synthetic */ C1382x39e9ed7e(C13611 r1) {
//                this();
//            }
//
//            public get_word_assets_info_by_topic_and_book_id_argsStandardScheme getScheme() {
//                return new get_word_assets_info_by_topic_and_book_id_argsStandardScheme(null);
//            }
//        }
//
//        class get_word_assets_info_by_topic_and_book_id_argsTupleScheme extends C2111d<get_word_assets_info_by_topic_and_book_id_args> {
//            private get_word_assets_info_by_topic_and_book_id_argsTupleScheme() {
//            }
//
//            /* synthetic */ get_word_assets_info_by_topic_and_book_id_argsTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_word_assets_info_by_topic_and_book_id_args get_word_assets_info_by_topic_and_book_id_args) {
//                C2106l lVar = (C2106l) fVar;
//                lVar.mo18493a(get_word_assets_info_by_topic_and_book_id_args.arr_topic_and_book_ids.size());
//                for (BBGetWordAssetInfoArg write : get_word_assets_info_by_topic_and_book_id_args.arr_topic_and_book_ids) {
//                    write.write(lVar);
//                }
//            }
//
//            public void read(C2100f fVar, get_word_assets_info_by_topic_and_book_id_args get_word_assets_info_by_topic_and_book_id_args) {
//                C2106l lVar = (C2106l) fVar;
//                C2098c cVar = new C2098c(JceStruct.ZERO_TAG, lVar.mo18513n());
//                get_word_assets_info_by_topic_and_book_id_args.arr_topic_and_book_ids = new ArrayList(cVar.f5838b);
//                for (int i = 0; i < cVar.f5838b; i++) {
//                    BBGetWordAssetInfoArg bBGetWordAssetInfoArg = new BBGetWordAssetInfoArg();
//                    bBGetWordAssetInfoArg.read(lVar);
//                    get_word_assets_info_by_topic_and_book_id_args.arr_topic_and_book_ids.add(bBGetWordAssetInfoArg);
//                }
//                get_word_assets_info_by_topic_and_book_id_args.setArr_topic_and_book_idsIsSet(true);
//            }
//        }
//
//        class get_word_assets_info_by_topic_and_book_id_argsTupleSchemeFactory implements C2109b {
//            private get_word_assets_info_by_topic_and_book_id_argsTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_assets_info_by_topic_and_book_id_argsTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_assets_info_by_topic_and_book_id_argsTupleScheme getScheme() {
//                return new get_word_assets_info_by_topic_and_book_id_argsTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new C1382x39e9ed7e(null));
//            schemes.put(C2111d.class, new get_word_assets_info_by_topic_and_book_id_argsTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.ARR_TOPIC_AND_BOOK_IDS, new C2091a("arr_topic_and_book_ids", 1, new C2093c(new C2095e(BBGetWordAssetInfoArg.class))));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_word_assets_info_by_topic_and_book_id_args.class, metaDataMap);
//        }
//
//        public get_word_assets_info_by_topic_and_book_id_args() {
//        }
//
//        public get_word_assets_info_by_topic_and_book_id_args(List<BBGetWordAssetInfoArg> list) {
//            this();
//            this.arr_topic_and_book_ids = list;
//        }
//
//        public get_word_assets_info_by_topic_and_book_id_args(get_word_assets_info_by_topic_and_book_id_args get_word_assets_info_by_topic_and_book_id_args) {
//            if (get_word_assets_info_by_topic_and_book_id_args.isSetArr_topic_and_book_ids()) {
//                ArrayList arrayList = new ArrayList(get_word_assets_info_by_topic_and_book_id_args.arr_topic_and_book_ids.size());
//                for (BBGetWordAssetInfoArg bBGetWordAssetInfoArg : get_word_assets_info_by_topic_and_book_id_args.arr_topic_and_book_ids) {
//                    arrayList.add(new BBGetWordAssetInfoArg(bBGetWordAssetInfoArg));
//                }
//                this.arr_topic_and_book_ids = arrayList;
//            }
//        }
//
//        public get_word_assets_info_by_topic_and_book_id_args deepCopy() {
//            return new get_word_assets_info_by_topic_and_book_id_args(this);
//        }
//
//        public void clear() {
//            this.arr_topic_and_book_ids = null;
//        }
//
//        public int getArr_topic_and_book_idsSize() {
//            if (this.arr_topic_and_book_ids == null) {
//                return 0;
//            }
//            return this.arr_topic_and_book_ids.size();
//        }
//
//        public Iterator<BBGetWordAssetInfoArg> getArr_topic_and_book_idsIterator() {
//            if (this.arr_topic_and_book_ids == null) {
//                return null;
//            }
//            return this.arr_topic_and_book_ids.iterator();
//        }
//
//        public void addToArr_topic_and_book_ids(BBGetWordAssetInfoArg bBGetWordAssetInfoArg) {
//            if (this.arr_topic_and_book_ids == null) {
//                this.arr_topic_and_book_ids = new ArrayList();
//            }
//            this.arr_topic_and_book_ids.add(bBGetWordAssetInfoArg);
//        }
//
//        public List<BBGetWordAssetInfoArg> getArr_topic_and_book_ids() {
//            return this.arr_topic_and_book_ids;
//        }
//
//        public get_word_assets_info_by_topic_and_book_id_args setArr_topic_and_book_ids(List<BBGetWordAssetInfoArg> list) {
//            this.arr_topic_and_book_ids = list;
//            return this;
//        }
//
//        public void unsetArr_topic_and_book_ids() {
//            this.arr_topic_and_book_ids = null;
//        }
//
//        public boolean isSetArr_topic_and_book_ids() {
//            return this.arr_topic_and_book_ids != null;
//        }
//
//        public void setArr_topic_and_book_idsIsSet(boolean z) {
//            if (!z) {
//                this.arr_topic_and_book_ids = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case ARR_TOPIC_AND_BOOK_IDS:
//                    if (obj == null) {
//                        unsetArr_topic_and_book_ids();
//                        return;
//                    } else {
//                        setArr_topic_and_book_ids((List) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case ARR_TOPIC_AND_BOOK_IDS:
//                    return getArr_topic_and_book_ids();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case ARR_TOPIC_AND_BOOK_IDS:
//                    return isSetArr_topic_and_book_ids();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_word_assets_info_by_topic_and_book_id_args)) {
//                return equals((get_word_assets_info_by_topic_and_book_id_args) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_word_assets_info_by_topic_and_book_id_args get_word_assets_info_by_topic_and_book_id_args) {
//            if (get_word_assets_info_by_topic_and_book_id_args == null) {
//                return false;
//            }
//            boolean isSetArr_topic_and_book_ids = isSetArr_topic_and_book_ids();
//            boolean isSetArr_topic_and_book_ids2 = get_word_assets_info_by_topic_and_book_id_args.isSetArr_topic_and_book_ids();
//            if ((isSetArr_topic_and_book_ids || isSetArr_topic_and_book_ids2) && (!isSetArr_topic_and_book_ids || !isSetArr_topic_and_book_ids2 || !this.arr_topic_and_book_ids.equals(get_word_assets_info_by_topic_and_book_id_args.arr_topic_and_book_ids))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_word_assets_info_by_topic_and_book_id_args get_word_assets_info_by_topic_and_book_id_args) {
//            if (!getClass().equals(get_word_assets_info_by_topic_and_book_id_args.getClass())) {
//                return getClass().getName().compareTo(get_word_assets_info_by_topic_and_book_id_args.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetArr_topic_and_book_ids()).compareTo(Boolean.valueOf(get_word_assets_info_by_topic_and_book_id_args.isSetArr_topic_and_book_ids()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetArr_topic_and_book_ids()) {
//                int a = C2121h.m5526a((List) this.arr_topic_and_book_ids, (List) get_word_assets_info_by_topic_and_book_id_args.arr_topic_and_book_ids);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_word_assets_info_by_topic_and_book_id_args(");
//            sb.append("arr_topic_and_book_ids:");
//            if (this.arr_topic_and_book_ids == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.arr_topic_and_book_ids);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//            if (this.arr_topic_and_book_ids == null) {
//                throw new C2101g("Required field 'arr_topic_and_book_ids' was not present! Struct: " + toString());
//            }
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_word_assets_info_by_topic_and_book_id_result implements Serializable, Cloneable, Comparable<get_word_assets_info_by_topic_and_book_id_result>, C2116f<get_word_assets_info_by_topic_and_book_id_result, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_word_assets_info_by_topic_and_book_id_result");
//        /* access modifiers changed from: private */
//        public static final C2097b SUCCESS_FIELD_DESC = new C2097b("success", 15, 0);
//        /* access modifiers changed from: private */
//        public static final C2097b SYS_EXCEPTION_FIELD_DESC = new C2097b("sysException", JceStruct.ZERO_TAG, 1);
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        public List<BBGetWordAssetInfoResult> success;
//        public BESystemException sysException;
//
//        public enum _Fields implements C2124m {
//            SUCCESS(0, "success"),
//            SYS_EXCEPTION(1, "sysException");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 0:
//                        return SUCCESS;
//                    case 1:
//                        return SYS_EXCEPTION;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_word_assets_info_by_topic_and_book_id_resultStandardScheme extends C2110c<get_word_assets_info_by_topic_and_book_id_result> {
//            private get_word_assets_info_by_topic_and_book_id_resultStandardScheme() {
//            }
//
//            /* synthetic */ get_word_assets_info_by_topic_and_book_id_resultStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_word_assets_info_by_topic_and_book_id_result get_word_assets_info_by_topic_and_book_id_result) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 0:
//                                if (g.f5835b != 15) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    C2098c i = fVar.mo18508i();
//                                    get_word_assets_info_by_topic_and_book_id_result.success = new ArrayList(i.f5838b);
//                                    for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                        BBGetWordAssetInfoResult bBGetWordAssetInfoResult = new BBGetWordAssetInfoResult();
//                                        bBGetWordAssetInfoResult.read(fVar);
//                                        get_word_assets_info_by_topic_and_book_id_result.success.add(bBGetWordAssetInfoResult);
//                                    }
//                                    get_word_assets_info_by_topic_and_book_id_result.setSuccessIsSet(true);
//                                    break;
//                                }
//                            case 1:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_assets_info_by_topic_and_book_id_result.sysException = new BESystemException();
//                                    get_word_assets_info_by_topic_and_book_id_result.sysException.read(fVar);
//                                    get_word_assets_info_by_topic_and_book_id_result.setSysExceptionIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        get_word_assets_info_by_topic_and_book_id_result.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_word_assets_info_by_topic_and_book_id_result get_word_assets_info_by_topic_and_book_id_result) {
//                get_word_assets_info_by_topic_and_book_id_result.validate();
//                get_word_assets_info_by_topic_and_book_id_result.STRUCT_DESC;
//                fVar.mo18490a();
//                if (get_word_assets_info_by_topic_and_book_id_result.success != null) {
//                    fVar.mo18496a(get_word_assets_info_by_topic_and_book_id_result.SUCCESS_FIELD_DESC);
//                    fVar.mo18497a(new C2098c(JceStruct.ZERO_TAG, get_word_assets_info_by_topic_and_book_id_result.success.size()));
//                    for (BBGetWordAssetInfoResult write : get_word_assets_info_by_topic_and_book_id_result.success) {
//                        write.write(fVar);
//                    }
//                }
//                if (get_word_assets_info_by_topic_and_book_id_result.sysException != null) {
//                    fVar.mo18496a(get_word_assets_info_by_topic_and_book_id_result.SYS_EXCEPTION_FIELD_DESC);
//                    get_word_assets_info_by_topic_and_book_id_result.sysException.write(fVar);
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        /* renamed from: com.baicizhan.online.bs_words.BSWords$get_word_assets_info_by_topic_and_book_id_result$get_word_assets_info_by_topic_and_book_id_resultStandardSchemeFactory */
//        class C1383x1a112d7e implements C2109b {
//            private C1383x1a112d7e() {
//            }
//
//            /* synthetic */ C1383x1a112d7e(C13611 r1) {
//                this();
//            }
//
//            public get_word_assets_info_by_topic_and_book_id_resultStandardScheme getScheme() {
//                return new get_word_assets_info_by_topic_and_book_id_resultStandardScheme(null);
//            }
//        }
//
//        class get_word_assets_info_by_topic_and_book_id_resultTupleScheme extends C2111d<get_word_assets_info_by_topic_and_book_id_result> {
//            private get_word_assets_info_by_topic_and_book_id_resultTupleScheme() {
//            }
//
//            /* synthetic */ get_word_assets_info_by_topic_and_book_id_resultTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_word_assets_info_by_topic_and_book_id_result get_word_assets_info_by_topic_and_book_id_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet bitSet = new BitSet();
//                if (get_word_assets_info_by_topic_and_book_id_result.isSetSuccess()) {
//                    bitSet.set(0);
//                }
//                if (get_word_assets_info_by_topic_and_book_id_result.isSetSysException()) {
//                    bitSet.set(1);
//                }
//                lVar.mo18527a(bitSet, 2);
//                if (get_word_assets_info_by_topic_and_book_id_result.isSetSuccess()) {
//                    lVar.mo18493a(get_word_assets_info_by_topic_and_book_id_result.success.size());
//                    for (BBGetWordAssetInfoResult write : get_word_assets_info_by_topic_and_book_id_result.success) {
//                        write.write(lVar);
//                    }
//                }
//                if (get_word_assets_info_by_topic_and_book_id_result.isSetSysException()) {
//                    get_word_assets_info_by_topic_and_book_id_result.sysException.write(lVar);
//                }
//            }
//
//            public void read(C2100f fVar, get_word_assets_info_by_topic_and_book_id_result get_word_assets_info_by_topic_and_book_id_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet b = lVar.mo18528b(2);
//                if (b.get(0)) {
//                    C2098c cVar = new C2098c(JceStruct.ZERO_TAG, lVar.mo18513n());
//                    get_word_assets_info_by_topic_and_book_id_result.success = new ArrayList(cVar.f5838b);
//                    for (int i = 0; i < cVar.f5838b; i++) {
//                        BBGetWordAssetInfoResult bBGetWordAssetInfoResult = new BBGetWordAssetInfoResult();
//                        bBGetWordAssetInfoResult.read(lVar);
//                        get_word_assets_info_by_topic_and_book_id_result.success.add(bBGetWordAssetInfoResult);
//                    }
//                    get_word_assets_info_by_topic_and_book_id_result.setSuccessIsSet(true);
//                }
//                if (b.get(1)) {
//                    get_word_assets_info_by_topic_and_book_id_result.sysException = new BESystemException();
//                    get_word_assets_info_by_topic_and_book_id_result.sysException.read(lVar);
//                    get_word_assets_info_by_topic_and_book_id_result.setSysExceptionIsSet(true);
//                }
//            }
//        }
//
//        /* renamed from: com.baicizhan.online.bs_words.BSWords$get_word_assets_info_by_topic_and_book_id_result$get_word_assets_info_by_topic_and_book_id_resultTupleSchemeFactory */
//        class C1384xd7db22e7 implements C2109b {
//            private C1384xd7db22e7() {
//            }
//
//            /* synthetic */ C1384xd7db22e7(C13611 r1) {
//                this();
//            }
//
//            public get_word_assets_info_by_topic_and_book_id_resultTupleScheme getScheme() {
//                return new get_word_assets_info_by_topic_and_book_id_resultTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new C1383x1a112d7e(null));
//            schemes.put(C2111d.class, new C1384xd7db22e7(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.SUCCESS, new C2091a("success", 3, new C2093c(new C2095e(BBGetWordAssetInfoResult.class))));
//            enumMap.put(_Fields.SYS_EXCEPTION, new C2091a("sysException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_word_assets_info_by_topic_and_book_id_result.class, metaDataMap);
//        }
//
//        public get_word_assets_info_by_topic_and_book_id_result() {
//        }
//
//        public get_word_assets_info_by_topic_and_book_id_result(List<BBGetWordAssetInfoResult> list, BESystemException bESystemException) {
//            this();
//            this.success = list;
//            this.sysException = bESystemException;
//        }
//
//        public get_word_assets_info_by_topic_and_book_id_result(get_word_assets_info_by_topic_and_book_id_result get_word_assets_info_by_topic_and_book_id_result) {
//            if (get_word_assets_info_by_topic_and_book_id_result.isSetSuccess()) {
//                ArrayList arrayList = new ArrayList(get_word_assets_info_by_topic_and_book_id_result.success.size());
//                for (BBGetWordAssetInfoResult bBGetWordAssetInfoResult : get_word_assets_info_by_topic_and_book_id_result.success) {
//                    arrayList.add(new BBGetWordAssetInfoResult(bBGetWordAssetInfoResult));
//                }
//                this.success = arrayList;
//            }
//            if (get_word_assets_info_by_topic_and_book_id_result.isSetSysException()) {
//                this.sysException = new BESystemException(get_word_assets_info_by_topic_and_book_id_result.sysException);
//            }
//        }
//
//        public get_word_assets_info_by_topic_and_book_id_result deepCopy() {
//            return new get_word_assets_info_by_topic_and_book_id_result(this);
//        }
//
//        public void clear() {
//            this.success = null;
//            this.sysException = null;
//        }
//
//        public int getSuccessSize() {
//            if (this.success == null) {
//                return 0;
//            }
//            return this.success.size();
//        }
//
//        public Iterator<BBGetWordAssetInfoResult> getSuccessIterator() {
//            if (this.success == null) {
//                return null;
//            }
//            return this.success.iterator();
//        }
//
//        public void addToSuccess(BBGetWordAssetInfoResult bBGetWordAssetInfoResult) {
//            if (this.success == null) {
//                this.success = new ArrayList();
//            }
//            this.success.add(bBGetWordAssetInfoResult);
//        }
//
//        public List<BBGetWordAssetInfoResult> getSuccess() {
//            return this.success;
//        }
//
//        public get_word_assets_info_by_topic_and_book_id_result setSuccess(List<BBGetWordAssetInfoResult> list) {
//            this.success = list;
//            return this;
//        }
//
//        public void unsetSuccess() {
//            this.success = null;
//        }
//
//        public boolean isSetSuccess() {
//            return this.success != null;
//        }
//
//        public void setSuccessIsSet(boolean z) {
//            if (!z) {
//                this.success = null;
//            }
//        }
//
//        public BESystemException getSysException() {
//            return this.sysException;
//        }
//
//        public get_word_assets_info_by_topic_and_book_id_result setSysException(BESystemException bESystemException) {
//            this.sysException = bESystemException;
//            return this;
//        }
//
//        public void unsetSysException() {
//            this.sysException = null;
//        }
//
//        public boolean isSetSysException() {
//            return this.sysException != null;
//        }
//
//        public void setSysExceptionIsSet(boolean z) {
//            if (!z) {
//                this.sysException = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case SUCCESS:
//                    if (obj == null) {
//                        unsetSuccess();
//                        return;
//                    } else {
//                        setSuccess((List) obj);
//                        return;
//                    }
//                case SYS_EXCEPTION:
//                    if (obj == null) {
//                        unsetSysException();
//                        return;
//                    } else {
//                        setSysException((BESystemException) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case SUCCESS:
//                    return getSuccess();
//                case SYS_EXCEPTION:
//                    return getSysException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case SUCCESS:
//                    return isSetSuccess();
//                case SYS_EXCEPTION:
//                    return isSetSysException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_word_assets_info_by_topic_and_book_id_result)) {
//                return equals((get_word_assets_info_by_topic_and_book_id_result) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_word_assets_info_by_topic_and_book_id_result get_word_assets_info_by_topic_and_book_id_result) {
//            if (get_word_assets_info_by_topic_and_book_id_result == null) {
//                return false;
//            }
//            boolean isSetSuccess = isSetSuccess();
//            boolean isSetSuccess2 = get_word_assets_info_by_topic_and_book_id_result.isSetSuccess();
//            if ((isSetSuccess || isSetSuccess2) && (!isSetSuccess || !isSetSuccess2 || !this.success.equals(get_word_assets_info_by_topic_and_book_id_result.success))) {
//                return false;
//            }
//            boolean isSetSysException = isSetSysException();
//            boolean isSetSysException2 = get_word_assets_info_by_topic_and_book_id_result.isSetSysException();
//            if ((isSetSysException || isSetSysException2) && (!isSetSysException || !isSetSysException2 || !this.sysException.equals(get_word_assets_info_by_topic_and_book_id_result.sysException))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_word_assets_info_by_topic_and_book_id_result get_word_assets_info_by_topic_and_book_id_result) {
//            if (!getClass().equals(get_word_assets_info_by_topic_and_book_id_result.getClass())) {
//                return getClass().getName().compareTo(get_word_assets_info_by_topic_and_book_id_result.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetSuccess()).compareTo(Boolean.valueOf(get_word_assets_info_by_topic_and_book_id_result.isSetSuccess()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetSuccess()) {
//                int a = C2121h.m5526a((List) this.success, (List) get_word_assets_info_by_topic_and_book_id_result.success);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetSysException()).compareTo(Boolean.valueOf(get_word_assets_info_by_topic_and_book_id_result.isSetSysException()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetSysException()) {
//                int a2 = C2121h.m5524a((Comparable) this.sysException, (Comparable) get_word_assets_info_by_topic_and_book_id_result.sysException);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_word_assets_info_by_topic_and_book_id_result(");
//            sb.append("success:");
//            if (this.success == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.success);
//            }
//            sb.append(", ");
//            sb.append("sysException:");
//            if (this.sysException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.sysException);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_word_media_halftime_list_args implements Serializable, Cloneable, Comparable<get_word_media_halftime_list_args>, C2116f<get_word_media_halftime_list_args, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_word_media_halftime_list_args");
//        public static final Map<_Fields, C2091a> metaDataMap = Collections.unmodifiableMap(new EnumMap(_Fields.class));
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//
//        public enum _Fields implements C2124m {
//            ;
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                return null;
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_word_media_halftime_list_argsStandardScheme extends C2110c<get_word_media_halftime_list_args> {
//            private get_word_media_halftime_list_argsStandardScheme() {
//            }
//
//            /* synthetic */ get_word_media_halftime_list_argsStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_word_media_halftime_list_args get_word_media_halftime_list_args) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        C2103i.m5498a(fVar, g.f5835b);
//                    } else {
//                        fVar.mo18505f();
//                        get_word_media_halftime_list_args.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_word_media_halftime_list_args get_word_media_halftime_list_args) {
//                get_word_media_halftime_list_args.validate();
//                get_word_media_halftime_list_args.STRUCT_DESC;
//                fVar.mo18490a();
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class get_word_media_halftime_list_argsStandardSchemeFactory implements C2109b {
//            private get_word_media_halftime_list_argsStandardSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_media_halftime_list_argsStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_media_halftime_list_argsStandardScheme getScheme() {
//                return new get_word_media_halftime_list_argsStandardScheme(null);
//            }
//        }
//
//        class get_word_media_halftime_list_argsTupleScheme extends C2111d<get_word_media_halftime_list_args> {
//            private get_word_media_halftime_list_argsTupleScheme() {
//            }
//
//            /* synthetic */ get_word_media_halftime_list_argsTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_word_media_halftime_list_args get_word_media_halftime_list_args) {
//            }
//
//            public void read(C2100f fVar, get_word_media_halftime_list_args get_word_media_halftime_list_args) {
//            }
//        }
//
//        class get_word_media_halftime_list_argsTupleSchemeFactory implements C2109b {
//            private get_word_media_halftime_list_argsTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_media_halftime_list_argsTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_media_halftime_list_argsTupleScheme getScheme() {
//                return new get_word_media_halftime_list_argsTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new get_word_media_halftime_list_argsStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new get_word_media_halftime_list_argsTupleSchemeFactory(null));
//            C2091a.m5430a(get_word_media_halftime_list_args.class, metaDataMap);
//        }
//
//        public get_word_media_halftime_list_args() {
//        }
//
//        public get_word_media_halftime_list_args(get_word_media_halftime_list_args get_word_media_halftime_list_args) {
//        }
//
//        public get_word_media_halftime_list_args deepCopy() {
//            return new get_word_media_halftime_list_args(this);
//        }
//
//        public void clear() {
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            int[] iArr = C13611.f2549x6d0c3cba;
//            _fields.ordinal();
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            int[] iArr = C13611.f2549x6d0c3cba;
//            _fields.ordinal();
//            throw new IllegalStateException();
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            int[] iArr = C13611.f2549x6d0c3cba;
//            _fields.ordinal();
//            throw new IllegalStateException();
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_word_media_halftime_list_args)) {
//                return equals((get_word_media_halftime_list_args) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_word_media_halftime_list_args get_word_media_halftime_list_args) {
//            if (get_word_media_halftime_list_args == null) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_word_media_halftime_list_args get_word_media_halftime_list_args) {
//            if (!getClass().equals(get_word_media_halftime_list_args.getClass())) {
//                return getClass().getName().compareTo(get_word_media_halftime_list_args.getClass().getName());
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_word_media_halftime_list_args(");
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_word_media_halftime_list_result implements Serializable, Cloneable, Comparable<get_word_media_halftime_list_result>, C2116f<get_word_media_halftime_list_result, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_word_media_halftime_list_result");
//        /* access modifiers changed from: private */
//        public static final C2097b SUCCESS_FIELD_DESC = new C2097b("success", JceStruct.ZERO_TAG, 0);
//        /* access modifiers changed from: private */
//        public static final C2097b SYS_EXCEPTION_FIELD_DESC = new C2097b("sysException", JceStruct.ZERO_TAG, 1);
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        public BBWordMediaHalftimeList success;
//        public BESystemException sysException;
//
//        public enum _Fields implements C2124m {
//            SUCCESS(0, "success"),
//            SYS_EXCEPTION(1, "sysException");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 0:
//                        return SUCCESS;
//                    case 1:
//                        return SYS_EXCEPTION;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_word_media_halftime_list_resultStandardScheme extends C2110c<get_word_media_halftime_list_result> {
//            private get_word_media_halftime_list_resultStandardScheme() {
//            }
//
//            /* synthetic */ get_word_media_halftime_list_resultStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_word_media_halftime_list_result get_word_media_halftime_list_result) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 0:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_media_halftime_list_result.success = new BBWordMediaHalftimeList();
//                                    get_word_media_halftime_list_result.success.read(fVar);
//                                    get_word_media_halftime_list_result.setSuccessIsSet(true);
//                                    break;
//                                }
//                            case 1:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_media_halftime_list_result.sysException = new BESystemException();
//                                    get_word_media_halftime_list_result.sysException.read(fVar);
//                                    get_word_media_halftime_list_result.setSysExceptionIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        get_word_media_halftime_list_result.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_word_media_halftime_list_result get_word_media_halftime_list_result) {
//                get_word_media_halftime_list_result.validate();
//                get_word_media_halftime_list_result.STRUCT_DESC;
//                fVar.mo18490a();
//                if (get_word_media_halftime_list_result.success != null) {
//                    fVar.mo18496a(get_word_media_halftime_list_result.SUCCESS_FIELD_DESC);
//                    get_word_media_halftime_list_result.success.write(fVar);
//                }
//                if (get_word_media_halftime_list_result.sysException != null) {
//                    fVar.mo18496a(get_word_media_halftime_list_result.SYS_EXCEPTION_FIELD_DESC);
//                    get_word_media_halftime_list_result.sysException.write(fVar);
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class get_word_media_halftime_list_resultStandardSchemeFactory implements C2109b {
//            private get_word_media_halftime_list_resultStandardSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_media_halftime_list_resultStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_media_halftime_list_resultStandardScheme getScheme() {
//                return new get_word_media_halftime_list_resultStandardScheme(null);
//            }
//        }
//
//        class get_word_media_halftime_list_resultTupleScheme extends C2111d<get_word_media_halftime_list_result> {
//            private get_word_media_halftime_list_resultTupleScheme() {
//            }
//
//            /* synthetic */ get_word_media_halftime_list_resultTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_word_media_halftime_list_result get_word_media_halftime_list_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet bitSet = new BitSet();
//                if (get_word_media_halftime_list_result.isSetSuccess()) {
//                    bitSet.set(0);
//                }
//                if (get_word_media_halftime_list_result.isSetSysException()) {
//                    bitSet.set(1);
//                }
//                lVar.mo18527a(bitSet, 2);
//                if (get_word_media_halftime_list_result.isSetSuccess()) {
//                    get_word_media_halftime_list_result.success.write(lVar);
//                }
//                if (get_word_media_halftime_list_result.isSetSysException()) {
//                    get_word_media_halftime_list_result.sysException.write(lVar);
//                }
//            }
//
//            public void read(C2100f fVar, get_word_media_halftime_list_result get_word_media_halftime_list_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet b = lVar.mo18528b(2);
//                if (b.get(0)) {
//                    get_word_media_halftime_list_result.success = new BBWordMediaHalftimeList();
//                    get_word_media_halftime_list_result.success.read(lVar);
//                    get_word_media_halftime_list_result.setSuccessIsSet(true);
//                }
//                if (b.get(1)) {
//                    get_word_media_halftime_list_result.sysException = new BESystemException();
//                    get_word_media_halftime_list_result.sysException.read(lVar);
//                    get_word_media_halftime_list_result.setSysExceptionIsSet(true);
//                }
//            }
//        }
//
//        class get_word_media_halftime_list_resultTupleSchemeFactory implements C2109b {
//            private get_word_media_halftime_list_resultTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_media_halftime_list_resultTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_media_halftime_list_resultTupleScheme getScheme() {
//                return new get_word_media_halftime_list_resultTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new get_word_media_halftime_list_resultStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new get_word_media_halftime_list_resultTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.SUCCESS, new C2091a("success", 3, new C2095e(BBWordMediaHalftimeList.class)));
//            enumMap.put(_Fields.SYS_EXCEPTION, new C2091a("sysException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_word_media_halftime_list_result.class, metaDataMap);
//        }
//
//        public get_word_media_halftime_list_result() {
//        }
//
//        public get_word_media_halftime_list_result(BBWordMediaHalftimeList bBWordMediaHalftimeList, BESystemException bESystemException) {
//            this();
//            this.success = bBWordMediaHalftimeList;
//            this.sysException = bESystemException;
//        }
//
//        public get_word_media_halftime_list_result(get_word_media_halftime_list_result get_word_media_halftime_list_result) {
//            if (get_word_media_halftime_list_result.isSetSuccess()) {
//                this.success = new BBWordMediaHalftimeList(get_word_media_halftime_list_result.success);
//            }
//            if (get_word_media_halftime_list_result.isSetSysException()) {
//                this.sysException = new BESystemException(get_word_media_halftime_list_result.sysException);
//            }
//        }
//
//        public get_word_media_halftime_list_result deepCopy() {
//            return new get_word_media_halftime_list_result(this);
//        }
//
//        public void clear() {
//            this.success = null;
//            this.sysException = null;
//        }
//
//        public BBWordMediaHalftimeList getSuccess() {
//            return this.success;
//        }
//
//        public get_word_media_halftime_list_result setSuccess(BBWordMediaHalftimeList bBWordMediaHalftimeList) {
//            this.success = bBWordMediaHalftimeList;
//            return this;
//        }
//
//        public void unsetSuccess() {
//            this.success = null;
//        }
//
//        public boolean isSetSuccess() {
//            return this.success != null;
//        }
//
//        public void setSuccessIsSet(boolean z) {
//            if (!z) {
//                this.success = null;
//            }
//        }
//
//        public BESystemException getSysException() {
//            return this.sysException;
//        }
//
//        public get_word_media_halftime_list_result setSysException(BESystemException bESystemException) {
//            this.sysException = bESystemException;
//            return this;
//        }
//
//        public void unsetSysException() {
//            this.sysException = null;
//        }
//
//        public boolean isSetSysException() {
//            return this.sysException != null;
//        }
//
//        public void setSysExceptionIsSet(boolean z) {
//            if (!z) {
//                this.sysException = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case SUCCESS:
//                    if (obj == null) {
//                        unsetSuccess();
//                        return;
//                    } else {
//                        setSuccess((BBWordMediaHalftimeList) obj);
//                        return;
//                    }
//                case SYS_EXCEPTION:
//                    if (obj == null) {
//                        unsetSysException();
//                        return;
//                    } else {
//                        setSysException((BESystemException) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case SUCCESS:
//                    return getSuccess();
//                case SYS_EXCEPTION:
//                    return getSysException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case SUCCESS:
//                    return isSetSuccess();
//                case SYS_EXCEPTION:
//                    return isSetSysException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_word_media_halftime_list_result)) {
//                return equals((get_word_media_halftime_list_result) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_word_media_halftime_list_result get_word_media_halftime_list_result) {
//            if (get_word_media_halftime_list_result == null) {
//                return false;
//            }
//            boolean isSetSuccess = isSetSuccess();
//            boolean isSetSuccess2 = get_word_media_halftime_list_result.isSetSuccess();
//            if ((isSetSuccess || isSetSuccess2) && (!isSetSuccess || !isSetSuccess2 || !this.success.equals(get_word_media_halftime_list_result.success))) {
//                return false;
//            }
//            boolean isSetSysException = isSetSysException();
//            boolean isSetSysException2 = get_word_media_halftime_list_result.isSetSysException();
//            if ((isSetSysException || isSetSysException2) && (!isSetSysException || !isSetSysException2 || !this.sysException.equals(get_word_media_halftime_list_result.sysException))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_word_media_halftime_list_result get_word_media_halftime_list_result) {
//            if (!getClass().equals(get_word_media_halftime_list_result.getClass())) {
//                return getClass().getName().compareTo(get_word_media_halftime_list_result.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetSuccess()).compareTo(Boolean.valueOf(get_word_media_halftime_list_result.isSetSuccess()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetSuccess()) {
//                int a = C2121h.m5524a((Comparable) this.success, (Comparable) get_word_media_halftime_list_result.success);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetSysException()).compareTo(Boolean.valueOf(get_word_media_halftime_list_result.isSetSysException()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetSysException()) {
//                int a2 = C2121h.m5524a((Comparable) this.sysException, (Comparable) get_word_media_halftime_list_result.sysException);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_word_media_halftime_list_result(");
//            sb.append("success:");
//            if (this.success == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.success);
//            }
//            sb.append(", ");
//            sb.append("sysException:");
//            if (this.sysException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.sysException);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//            if (this.success != null) {
//                this.success.validate();
//            }
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_word_media_update_info_args implements Serializable, Cloneable, Comparable<get_word_media_update_info_args>, C2116f<get_word_media_update_info_args, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2097b BOOK_ID_FIELD_DESC = new C2097b("book_id", 8, 1);
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_word_media_update_info_args");
//        private static final int __BOOK_ID_ISSET_ID = 0;
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        private byte __isset_bitfield;
//        public int book_id;
//
//        public enum _Fields implements C2124m {
//            BOOK_ID(1, "book_id");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 1:
//                        return BOOK_ID;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_word_media_update_info_argsStandardScheme extends C2110c<get_word_media_update_info_args> {
//            private get_word_media_update_info_argsStandardScheme() {
//            }
//
//            /* synthetic */ get_word_media_update_info_argsStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_word_media_update_info_args get_word_media_update_info_args) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 1:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_media_update_info_args.book_id = fVar.mo18513n();
//                                    get_word_media_update_info_args.setBook_idIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        if (!get_word_media_update_info_args.isSetBook_id()) {
//                            throw new C2101g("Required field 'book_id' was not found in serialized data! Struct: " + toString());
//                        }
//                        get_word_media_update_info_args.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_word_media_update_info_args get_word_media_update_info_args) {
//                get_word_media_update_info_args.validate();
//                get_word_media_update_info_args.STRUCT_DESC;
//                fVar.mo18490a();
//                fVar.mo18496a(get_word_media_update_info_args.BOOK_ID_FIELD_DESC);
//                fVar.mo18493a(get_word_media_update_info_args.book_id);
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class get_word_media_update_info_argsStandardSchemeFactory implements C2109b {
//            private get_word_media_update_info_argsStandardSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_media_update_info_argsStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_media_update_info_argsStandardScheme getScheme() {
//                return new get_word_media_update_info_argsStandardScheme(null);
//            }
//        }
//
//        class get_word_media_update_info_argsTupleScheme extends C2111d<get_word_media_update_info_args> {
//            private get_word_media_update_info_argsTupleScheme() {
//            }
//
//            /* synthetic */ get_word_media_update_info_argsTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_word_media_update_info_args get_word_media_update_info_args) {
//                ((C2106l) fVar).mo18493a(get_word_media_update_info_args.book_id);
//            }
//
//            public void read(C2100f fVar, get_word_media_update_info_args get_word_media_update_info_args) {
//                get_word_media_update_info_args.book_id = ((C2106l) fVar).mo18513n();
//                get_word_media_update_info_args.setBook_idIsSet(true);
//            }
//        }
//
//        class get_word_media_update_info_argsTupleSchemeFactory implements C2109b {
//            private get_word_media_update_info_argsTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_media_update_info_argsTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_media_update_info_argsTupleScheme getScheme() {
//                return new get_word_media_update_info_argsTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new get_word_media_update_info_argsStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new get_word_media_update_info_argsTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.BOOK_ID, new C2091a("book_id", 1, new C2092b(8, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_word_media_update_info_args.class, metaDataMap);
//        }
//
//        public get_word_media_update_info_args() {
//            this.__isset_bitfield = 0;
//        }
//
//        public get_word_media_update_info_args(int i) {
//            this();
//            this.book_id = i;
//            setBook_idIsSet(true);
//        }
//
//        public get_word_media_update_info_args(get_word_media_update_info_args get_word_media_update_info_args) {
//            this.__isset_bitfield = 0;
//            this.__isset_bitfield = get_word_media_update_info_args.__isset_bitfield;
//            this.book_id = get_word_media_update_info_args.book_id;
//        }
//
//        public get_word_media_update_info_args deepCopy() {
//            return new get_word_media_update_info_args(this);
//        }
//
//        public void clear() {
//            setBook_idIsSet(false);
//            this.book_id = 0;
//        }
//
//        public int getBook_id() {
//            return this.book_id;
//        }
//
//        public get_word_media_update_info_args setBook_id(int i) {
//            this.book_id = i;
//            setBook_idIsSet(true);
//            return this;
//        }
//
//        public void unsetBook_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//        }
//
//        public boolean isSetBook_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 0);
//        }
//
//        public void setBook_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case BOOK_ID:
//                    if (obj == null) {
//                        unsetBook_id();
//                        return;
//                    } else {
//                        setBook_id(((Integer) obj).intValue());
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case BOOK_ID:
//                    return Integer.valueOf(getBook_id());
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case BOOK_ID:
//                    return isSetBook_id();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_word_media_update_info_args)) {
//                return equals((get_word_media_update_info_args) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_word_media_update_info_args get_word_media_update_info_args) {
//            if (get_word_media_update_info_args != null && this.book_id == get_word_media_update_info_args.book_id) {
//                return true;
//            }
//            return false;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_word_media_update_info_args get_word_media_update_info_args) {
//            if (!getClass().equals(get_word_media_update_info_args.getClass())) {
//                return getClass().getName().compareTo(get_word_media_update_info_args.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetBook_id()).compareTo(Boolean.valueOf(get_word_media_update_info_args.isSetBook_id()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetBook_id()) {
//                int a = C2121h.m5522a(this.book_id, get_word_media_update_info_args.book_id);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_word_media_update_info_args(");
//            sb.append("book_id:");
//            sb.append(this.book_id);
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                this.__isset_bitfield = 0;
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_word_media_update_info_result implements Serializable, Cloneable, Comparable<get_word_media_update_info_result>, C2116f<get_word_media_update_info_result, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_word_media_update_info_result");
//        /* access modifiers changed from: private */
//        public static final C2097b SUCCESS_FIELD_DESC = new C2097b("success", 15, 0);
//        /* access modifiers changed from: private */
//        public static final C2097b SYS_EXCEPTION_FIELD_DESC = new C2097b("sysException", JceStruct.ZERO_TAG, 1);
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        public List<BBWordMediaUpdateInfo> success;
//        public BESystemException sysException;
//
//        public enum _Fields implements C2124m {
//            SUCCESS(0, "success"),
//            SYS_EXCEPTION(1, "sysException");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 0:
//                        return SUCCESS;
//                    case 1:
//                        return SYS_EXCEPTION;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_word_media_update_info_resultStandardScheme extends C2110c<get_word_media_update_info_result> {
//            private get_word_media_update_info_resultStandardScheme() {
//            }
//
//            /* synthetic */ get_word_media_update_info_resultStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_word_media_update_info_result get_word_media_update_info_result) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 0:
//                                if (g.f5835b != 15) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    C2098c i = fVar.mo18508i();
//                                    get_word_media_update_info_result.success = new ArrayList(i.f5838b);
//                                    for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                        BBWordMediaUpdateInfo bBWordMediaUpdateInfo = new BBWordMediaUpdateInfo();
//                                        bBWordMediaUpdateInfo.read(fVar);
//                                        get_word_media_update_info_result.success.add(bBWordMediaUpdateInfo);
//                                    }
//                                    get_word_media_update_info_result.setSuccessIsSet(true);
//                                    break;
//                                }
//                            case 1:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_media_update_info_result.sysException = new BESystemException();
//                                    get_word_media_update_info_result.sysException.read(fVar);
//                                    get_word_media_update_info_result.setSysExceptionIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        get_word_media_update_info_result.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_word_media_update_info_result get_word_media_update_info_result) {
//                get_word_media_update_info_result.validate();
//                get_word_media_update_info_result.STRUCT_DESC;
//                fVar.mo18490a();
//                if (get_word_media_update_info_result.success != null) {
//                    fVar.mo18496a(get_word_media_update_info_result.SUCCESS_FIELD_DESC);
//                    fVar.mo18497a(new C2098c(JceStruct.ZERO_TAG, get_word_media_update_info_result.success.size()));
//                    for (BBWordMediaUpdateInfo write : get_word_media_update_info_result.success) {
//                        write.write(fVar);
//                    }
//                }
//                if (get_word_media_update_info_result.sysException != null) {
//                    fVar.mo18496a(get_word_media_update_info_result.SYS_EXCEPTION_FIELD_DESC);
//                    get_word_media_update_info_result.sysException.write(fVar);
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class get_word_media_update_info_resultStandardSchemeFactory implements C2109b {
//            private get_word_media_update_info_resultStandardSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_media_update_info_resultStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_media_update_info_resultStandardScheme getScheme() {
//                return new get_word_media_update_info_resultStandardScheme(null);
//            }
//        }
//
//        class get_word_media_update_info_resultTupleScheme extends C2111d<get_word_media_update_info_result> {
//            private get_word_media_update_info_resultTupleScheme() {
//            }
//
//            /* synthetic */ get_word_media_update_info_resultTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_word_media_update_info_result get_word_media_update_info_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet bitSet = new BitSet();
//                if (get_word_media_update_info_result.isSetSuccess()) {
//                    bitSet.set(0);
//                }
//                if (get_word_media_update_info_result.isSetSysException()) {
//                    bitSet.set(1);
//                }
//                lVar.mo18527a(bitSet, 2);
//                if (get_word_media_update_info_result.isSetSuccess()) {
//                    lVar.mo18493a(get_word_media_update_info_result.success.size());
//                    for (BBWordMediaUpdateInfo write : get_word_media_update_info_result.success) {
//                        write.write(lVar);
//                    }
//                }
//                if (get_word_media_update_info_result.isSetSysException()) {
//                    get_word_media_update_info_result.sysException.write(lVar);
//                }
//            }
//
//            public void read(C2100f fVar, get_word_media_update_info_result get_word_media_update_info_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet b = lVar.mo18528b(2);
//                if (b.get(0)) {
//                    C2098c cVar = new C2098c(JceStruct.ZERO_TAG, lVar.mo18513n());
//                    get_word_media_update_info_result.success = new ArrayList(cVar.f5838b);
//                    for (int i = 0; i < cVar.f5838b; i++) {
//                        BBWordMediaUpdateInfo bBWordMediaUpdateInfo = new BBWordMediaUpdateInfo();
//                        bBWordMediaUpdateInfo.read(lVar);
//                        get_word_media_update_info_result.success.add(bBWordMediaUpdateInfo);
//                    }
//                    get_word_media_update_info_result.setSuccessIsSet(true);
//                }
//                if (b.get(1)) {
//                    get_word_media_update_info_result.sysException = new BESystemException();
//                    get_word_media_update_info_result.sysException.read(lVar);
//                    get_word_media_update_info_result.setSysExceptionIsSet(true);
//                }
//            }
//        }
//
//        class get_word_media_update_info_resultTupleSchemeFactory implements C2109b {
//            private get_word_media_update_info_resultTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_media_update_info_resultTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_media_update_info_resultTupleScheme getScheme() {
//                return new get_word_media_update_info_resultTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new get_word_media_update_info_resultStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new get_word_media_update_info_resultTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.SUCCESS, new C2091a("success", 3, new C2093c(new C2095e(BBWordMediaUpdateInfo.class))));
//            enumMap.put(_Fields.SYS_EXCEPTION, new C2091a("sysException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_word_media_update_info_result.class, metaDataMap);
//        }
//
//        public get_word_media_update_info_result() {
//        }
//
//        public get_word_media_update_info_result(List<BBWordMediaUpdateInfo> list, BESystemException bESystemException) {
//            this();
//            this.success = list;
//            this.sysException = bESystemException;
//        }
//
//        public get_word_media_update_info_result(get_word_media_update_info_result get_word_media_update_info_result) {
//            if (get_word_media_update_info_result.isSetSuccess()) {
//                ArrayList arrayList = new ArrayList(get_word_media_update_info_result.success.size());
//                for (BBWordMediaUpdateInfo bBWordMediaUpdateInfo : get_word_media_update_info_result.success) {
//                    arrayList.add(new BBWordMediaUpdateInfo(bBWordMediaUpdateInfo));
//                }
//                this.success = arrayList;
//            }
//            if (get_word_media_update_info_result.isSetSysException()) {
//                this.sysException = new BESystemException(get_word_media_update_info_result.sysException);
//            }
//        }
//
//        public get_word_media_update_info_result deepCopy() {
//            return new get_word_media_update_info_result(this);
//        }
//
//        public void clear() {
//            this.success = null;
//            this.sysException = null;
//        }
//
//        public int getSuccessSize() {
//            if (this.success == null) {
//                return 0;
//            }
//            return this.success.size();
//        }
//
//        public Iterator<BBWordMediaUpdateInfo> getSuccessIterator() {
//            if (this.success == null) {
//                return null;
//            }
//            return this.success.iterator();
//        }
//
//        public void addToSuccess(BBWordMediaUpdateInfo bBWordMediaUpdateInfo) {
//            if (this.success == null) {
//                this.success = new ArrayList();
//            }
//            this.success.add(bBWordMediaUpdateInfo);
//        }
//
//        public List<BBWordMediaUpdateInfo> getSuccess() {
//            return this.success;
//        }
//
//        public get_word_media_update_info_result setSuccess(List<BBWordMediaUpdateInfo> list) {
//            this.success = list;
//            return this;
//        }
//
//        public void unsetSuccess() {
//            this.success = null;
//        }
//
//        public boolean isSetSuccess() {
//            return this.success != null;
//        }
//
//        public void setSuccessIsSet(boolean z) {
//            if (!z) {
//                this.success = null;
//            }
//        }
//
//        public BESystemException getSysException() {
//            return this.sysException;
//        }
//
//        public get_word_media_update_info_result setSysException(BESystemException bESystemException) {
//            this.sysException = bESystemException;
//            return this;
//        }
//
//        public void unsetSysException() {
//            this.sysException = null;
//        }
//
//        public boolean isSetSysException() {
//            return this.sysException != null;
//        }
//
//        public void setSysExceptionIsSet(boolean z) {
//            if (!z) {
//                this.sysException = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case SUCCESS:
//                    if (obj == null) {
//                        unsetSuccess();
//                        return;
//                    } else {
//                        setSuccess((List) obj);
//                        return;
//                    }
//                case SYS_EXCEPTION:
//                    if (obj == null) {
//                        unsetSysException();
//                        return;
//                    } else {
//                        setSysException((BESystemException) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case SUCCESS:
//                    return getSuccess();
//                case SYS_EXCEPTION:
//                    return getSysException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case SUCCESS:
//                    return isSetSuccess();
//                case SYS_EXCEPTION:
//                    return isSetSysException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_word_media_update_info_result)) {
//                return equals((get_word_media_update_info_result) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_word_media_update_info_result get_word_media_update_info_result) {
//            if (get_word_media_update_info_result == null) {
//                return false;
//            }
//            boolean isSetSuccess = isSetSuccess();
//            boolean isSetSuccess2 = get_word_media_update_info_result.isSetSuccess();
//            if ((isSetSuccess || isSetSuccess2) && (!isSetSuccess || !isSetSuccess2 || !this.success.equals(get_word_media_update_info_result.success))) {
//                return false;
//            }
//            boolean isSetSysException = isSetSysException();
//            boolean isSetSysException2 = get_word_media_update_info_result.isSetSysException();
//            if ((isSetSysException || isSetSysException2) && (!isSetSysException || !isSetSysException2 || !this.sysException.equals(get_word_media_update_info_result.sysException))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_word_media_update_info_result get_word_media_update_info_result) {
//            if (!getClass().equals(get_word_media_update_info_result.getClass())) {
//                return getClass().getName().compareTo(get_word_media_update_info_result.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetSuccess()).compareTo(Boolean.valueOf(get_word_media_update_info_result.isSetSuccess()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetSuccess()) {
//                int a = C2121h.m5526a((List) this.success, (List) get_word_media_update_info_result.success);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetSysException()).compareTo(Boolean.valueOf(get_word_media_update_info_result.isSetSysException()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetSysException()) {
//                int a2 = C2121h.m5524a((Comparable) this.sysException, (Comparable) get_word_media_update_info_result.sysException);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_word_media_update_info_result(");
//            sb.append("success:");
//            if (this.success == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.success);
//            }
//            sb.append(", ");
//            sb.append("sysException:");
//            if (this.sysException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.sysException);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_word_package_args implements Serializable, Cloneable, Comparable<get_word_package_args>, C2116f<get_word_package_args, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_word_package_args");
//        /* access modifiers changed from: private */
//        public static final C2097b TOPIC_IDS_FIELD_DESC = new C2097b("topic_ids", 15, 1);
//        /* access modifiers changed from: private */
//        public static final C2097b WORD_LEVEL_ID_FIELD_DESC = new C2097b("word_level_id", 8, 2);
//        private static final int __WORD_LEVEL_ID_ISSET_ID = 0;
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        private byte __isset_bitfield;
//        public List<Integer> topic_ids;
//        public int word_level_id;
//
//        public enum _Fields implements C2124m {
//            TOPIC_IDS(1, "topic_ids"),
//            WORD_LEVEL_ID(2, "word_level_id");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 1:
//                        return TOPIC_IDS;
//                    case 2:
//                        return WORD_LEVEL_ID;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_word_package_argsStandardScheme extends C2110c<get_word_package_args> {
//            private get_word_package_argsStandardScheme() {
//            }
//
//            /* synthetic */ get_word_package_argsStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_word_package_args get_word_package_args) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 1:
//                                if (g.f5835b != 15) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    C2098c i = fVar.mo18508i();
//                                    get_word_package_args.topic_ids = new ArrayList(i.f5838b);
//                                    for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                        get_word_package_args.topic_ids.add(Integer.valueOf(fVar.mo18513n()));
//                                    }
//                                    get_word_package_args.setTopic_idsIsSet(true);
//                                    break;
//                                }
//                            case 2:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_package_args.word_level_id = fVar.mo18513n();
//                                    get_word_package_args.setWord_level_idIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        if (!get_word_package_args.isSetWord_level_id()) {
//                            throw new C2101g("Required field 'word_level_id' was not found in serialized data! Struct: " + toString());
//                        }
//                        get_word_package_args.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_word_package_args get_word_package_args) {
//                get_word_package_args.validate();
//                get_word_package_args.STRUCT_DESC;
//                fVar.mo18490a();
//                if (get_word_package_args.topic_ids != null) {
//                    fVar.mo18496a(get_word_package_args.TOPIC_IDS_FIELD_DESC);
//                    fVar.mo18497a(new C2098c(8, get_word_package_args.topic_ids.size()));
//                    for (Integer intValue : get_word_package_args.topic_ids) {
//                        fVar.mo18493a(intValue.intValue());
//                    }
//                }
//                fVar.mo18496a(get_word_package_args.WORD_LEVEL_ID_FIELD_DESC);
//                fVar.mo18493a(get_word_package_args.word_level_id);
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class get_word_package_argsStandardSchemeFactory implements C2109b {
//            private get_word_package_argsStandardSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_package_argsStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_package_argsStandardScheme getScheme() {
//                return new get_word_package_argsStandardScheme(null);
//            }
//        }
//
//        class get_word_package_argsTupleScheme extends C2111d<get_word_package_args> {
//            private get_word_package_argsTupleScheme() {
//            }
//
//            /* synthetic */ get_word_package_argsTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_word_package_args get_word_package_args) {
//                C2106l lVar = (C2106l) fVar;
//                lVar.mo18493a(get_word_package_args.topic_ids.size());
//                for (Integer intValue : get_word_package_args.topic_ids) {
//                    lVar.mo18493a(intValue.intValue());
//                }
//                lVar.mo18493a(get_word_package_args.word_level_id);
//            }
//
//            public void read(C2100f fVar, get_word_package_args get_word_package_args) {
//                C2106l lVar = (C2106l) fVar;
//                C2098c cVar = new C2098c(8, lVar.mo18513n());
//                get_word_package_args.topic_ids = new ArrayList(cVar.f5838b);
//                for (int i = 0; i < cVar.f5838b; i++) {
//                    get_word_package_args.topic_ids.add(Integer.valueOf(lVar.mo18513n()));
//                }
//                get_word_package_args.setTopic_idsIsSet(true);
//                get_word_package_args.word_level_id = lVar.mo18513n();
//                get_word_package_args.setWord_level_idIsSet(true);
//            }
//        }
//
//        class get_word_package_argsTupleSchemeFactory implements C2109b {
//            private get_word_package_argsTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_package_argsTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_package_argsTupleScheme getScheme() {
//                return new get_word_package_argsTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new get_word_package_argsStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new get_word_package_argsTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.TOPIC_IDS, new C2091a("topic_ids", 1, new C2093c(new C2092b(8, 0))));
//            enumMap.put(_Fields.WORD_LEVEL_ID, new C2091a("word_level_id", 1, new C2092b(8, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_word_package_args.class, metaDataMap);
//        }
//
//        public get_word_package_args() {
//            this.__isset_bitfield = 0;
//        }
//
//        public get_word_package_args(List<Integer> list, int i) {
//            this();
//            this.topic_ids = list;
//            this.word_level_id = i;
//            setWord_level_idIsSet(true);
//        }
//
//        public get_word_package_args(get_word_package_args get_word_package_args) {
//            this.__isset_bitfield = 0;
//            this.__isset_bitfield = get_word_package_args.__isset_bitfield;
//            if (get_word_package_args.isSetTopic_ids()) {
//                this.topic_ids = new ArrayList(get_word_package_args.topic_ids);
//            }
//            this.word_level_id = get_word_package_args.word_level_id;
//        }
//
//        public get_word_package_args deepCopy() {
//            return new get_word_package_args(this);
//        }
//
//        public void clear() {
//            this.topic_ids = null;
//            setWord_level_idIsSet(false);
//            this.word_level_id = 0;
//        }
//
//        public int getTopic_idsSize() {
//            if (this.topic_ids == null) {
//                return 0;
//            }
//            return this.topic_ids.size();
//        }
//
//        public Iterator<Integer> getTopic_idsIterator() {
//            if (this.topic_ids == null) {
//                return null;
//            }
//            return this.topic_ids.iterator();
//        }
//
//        public void addToTopic_ids(int i) {
//            if (this.topic_ids == null) {
//                this.topic_ids = new ArrayList();
//            }
//            this.topic_ids.add(Integer.valueOf(i));
//        }
//
//        public List<Integer> getTopic_ids() {
//            return this.topic_ids;
//        }
//
//        public get_word_package_args setTopic_ids(List<Integer> list) {
//            this.topic_ids = list;
//            return this;
//        }
//
//        public void unsetTopic_ids() {
//            this.topic_ids = null;
//        }
//
//        public boolean isSetTopic_ids() {
//            return this.topic_ids != null;
//        }
//
//        public void setTopic_idsIsSet(boolean z) {
//            if (!z) {
//                this.topic_ids = null;
//            }
//        }
//
//        public int getWord_level_id() {
//            return this.word_level_id;
//        }
//
//        public get_word_package_args setWord_level_id(int i) {
//            this.word_level_id = i;
//            setWord_level_idIsSet(true);
//            return this;
//        }
//
//        public void unsetWord_level_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//        }
//
//        public boolean isSetWord_level_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 0);
//        }
//
//        public void setWord_level_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case TOPIC_IDS:
//                    if (obj == null) {
//                        unsetTopic_ids();
//                        return;
//                    } else {
//                        setTopic_ids((List) obj);
//                        return;
//                    }
//                case WORD_LEVEL_ID:
//                    if (obj == null) {
//                        unsetWord_level_id();
//                        return;
//                    } else {
//                        setWord_level_id(((Integer) obj).intValue());
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case TOPIC_IDS:
//                    return getTopic_ids();
//                case WORD_LEVEL_ID:
//                    return Integer.valueOf(getWord_level_id());
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case TOPIC_IDS:
//                    return isSetTopic_ids();
//                case WORD_LEVEL_ID:
//                    return isSetWord_level_id();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_word_package_args)) {
//                return equals((get_word_package_args) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_word_package_args get_word_package_args) {
//            if (get_word_package_args == null) {
//                return false;
//            }
//            boolean isSetTopic_ids = isSetTopic_ids();
//            boolean isSetTopic_ids2 = get_word_package_args.isSetTopic_ids();
//            if (((isSetTopic_ids || isSetTopic_ids2) && (!isSetTopic_ids || !isSetTopic_ids2 || !this.topic_ids.equals(get_word_package_args.topic_ids))) || this.word_level_id != get_word_package_args.word_level_id) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_word_package_args get_word_package_args) {
//            if (!getClass().equals(get_word_package_args.getClass())) {
//                return getClass().getName().compareTo(get_word_package_args.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetTopic_ids()).compareTo(Boolean.valueOf(get_word_package_args.isSetTopic_ids()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetTopic_ids()) {
//                int a = C2121h.m5526a((List) this.topic_ids, (List) get_word_package_args.topic_ids);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetWord_level_id()).compareTo(Boolean.valueOf(get_word_package_args.isSetWord_level_id()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetWord_level_id()) {
//                int a2 = C2121h.m5522a(this.word_level_id, get_word_package_args.word_level_id);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_word_package_args(");
//            sb.append("topic_ids:");
//            if (this.topic_ids == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.topic_ids);
//            }
//            sb.append(", ");
//            sb.append("word_level_id:");
//            sb.append(this.word_level_id);
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//            if (this.topic_ids == null) {
//                throw new C2101g("Required field 'topic_ids' was not present! Struct: " + toString());
//            }
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                this.__isset_bitfield = 0;
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_word_package_result implements Serializable, Cloneable, Comparable<get_word_package_result>, C2116f<get_word_package_result, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2097b LOGIC_EXCEPTION_FIELD_DESC = new C2097b("logicException", JceStruct.ZERO_TAG, 2);
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_word_package_result");
//        /* access modifiers changed from: private */
//        public static final C2097b SUCCESS_FIELD_DESC = new C2097b("success", 15, 0);
//        /* access modifiers changed from: private */
//        public static final C2097b SYS_EXCEPTION_FIELD_DESC = new C2097b("sysException", JceStruct.ZERO_TAG, 1);
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        public BELogicException logicException;
//        public List<BBWordPackage> success;
//        public BESystemException sysException;
//
//        public enum _Fields implements C2124m {
//            SUCCESS(0, "success"),
//            SYS_EXCEPTION(1, "sysException"),
//            LOGIC_EXCEPTION(2, "logicException");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 0:
//                        return SUCCESS;
//                    case 1:
//                        return SYS_EXCEPTION;
//                    case 2:
//                        return LOGIC_EXCEPTION;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_word_package_resultStandardScheme extends C2110c<get_word_package_result> {
//            private get_word_package_resultStandardScheme() {
//            }
//
//            /* synthetic */ get_word_package_resultStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_word_package_result get_word_package_result) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 0:
//                                if (g.f5835b != 15) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    C2098c i = fVar.mo18508i();
//                                    get_word_package_result.success = new ArrayList(i.f5838b);
//                                    for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                        BBWordPackage bBWordPackage = new BBWordPackage();
//                                        bBWordPackage.read(fVar);
//                                        get_word_package_result.success.add(bBWordPackage);
//                                    }
//                                    get_word_package_result.setSuccessIsSet(true);
//                                    break;
//                                }
//                            case 1:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_package_result.sysException = new BESystemException();
//                                    get_word_package_result.sysException.read(fVar);
//                                    get_word_package_result.setSysExceptionIsSet(true);
//                                    break;
//                                }
//                            case 2:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_package_result.logicException = new BELogicException();
//                                    get_word_package_result.logicException.read(fVar);
//                                    get_word_package_result.setLogicExceptionIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        get_word_package_result.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_word_package_result get_word_package_result) {
//                get_word_package_result.validate();
//                get_word_package_result.STRUCT_DESC;
//                fVar.mo18490a();
//                if (get_word_package_result.success != null) {
//                    fVar.mo18496a(get_word_package_result.SUCCESS_FIELD_DESC);
//                    fVar.mo18497a(new C2098c(JceStruct.ZERO_TAG, get_word_package_result.success.size()));
//                    for (BBWordPackage write : get_word_package_result.success) {
//                        write.write(fVar);
//                    }
//                }
//                if (get_word_package_result.sysException != null) {
//                    fVar.mo18496a(get_word_package_result.SYS_EXCEPTION_FIELD_DESC);
//                    get_word_package_result.sysException.write(fVar);
//                }
//                if (get_word_package_result.logicException != null) {
//                    fVar.mo18496a(get_word_package_result.LOGIC_EXCEPTION_FIELD_DESC);
//                    get_word_package_result.logicException.write(fVar);
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class get_word_package_resultStandardSchemeFactory implements C2109b {
//            private get_word_package_resultStandardSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_package_resultStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_package_resultStandardScheme getScheme() {
//                return new get_word_package_resultStandardScheme(null);
//            }
//        }
//
//        class get_word_package_resultTupleScheme extends C2111d<get_word_package_result> {
//            private get_word_package_resultTupleScheme() {
//            }
//
//            /* synthetic */ get_word_package_resultTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_word_package_result get_word_package_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet bitSet = new BitSet();
//                if (get_word_package_result.isSetSuccess()) {
//                    bitSet.set(0);
//                }
//                if (get_word_package_result.isSetSysException()) {
//                    bitSet.set(1);
//                }
//                if (get_word_package_result.isSetLogicException()) {
//                    bitSet.set(2);
//                }
//                lVar.mo18527a(bitSet, 3);
//                if (get_word_package_result.isSetSuccess()) {
//                    lVar.mo18493a(get_word_package_result.success.size());
//                    for (BBWordPackage write : get_word_package_result.success) {
//                        write.write(lVar);
//                    }
//                }
//                if (get_word_package_result.isSetSysException()) {
//                    get_word_package_result.sysException.write(lVar);
//                }
//                if (get_word_package_result.isSetLogicException()) {
//                    get_word_package_result.logicException.write(lVar);
//                }
//            }
//
//            public void read(C2100f fVar, get_word_package_result get_word_package_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet b = lVar.mo18528b(3);
//                if (b.get(0)) {
//                    C2098c cVar = new C2098c(JceStruct.ZERO_TAG, lVar.mo18513n());
//                    get_word_package_result.success = new ArrayList(cVar.f5838b);
//                    for (int i = 0; i < cVar.f5838b; i++) {
//                        BBWordPackage bBWordPackage = new BBWordPackage();
//                        bBWordPackage.read(lVar);
//                        get_word_package_result.success.add(bBWordPackage);
//                    }
//                    get_word_package_result.setSuccessIsSet(true);
//                }
//                if (b.get(1)) {
//                    get_word_package_result.sysException = new BESystemException();
//                    get_word_package_result.sysException.read(lVar);
//                    get_word_package_result.setSysExceptionIsSet(true);
//                }
//                if (b.get(2)) {
//                    get_word_package_result.logicException = new BELogicException();
//                    get_word_package_result.logicException.read(lVar);
//                    get_word_package_result.setLogicExceptionIsSet(true);
//                }
//            }
//        }
//
//        class get_word_package_resultTupleSchemeFactory implements C2109b {
//            private get_word_package_resultTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_package_resultTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_package_resultTupleScheme getScheme() {
//                return new get_word_package_resultTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new get_word_package_resultStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new get_word_package_resultTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.SUCCESS, new C2091a("success", 3, new C2093c(new C2095e(BBWordPackage.class))));
//            enumMap.put(_Fields.SYS_EXCEPTION, new C2091a("sysException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            enumMap.put(_Fields.LOGIC_EXCEPTION, new C2091a("logicException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_word_package_result.class, metaDataMap);
//        }
//
//        public get_word_package_result() {
//        }
//
//        public get_word_package_result(List<BBWordPackage> list, BESystemException bESystemException, BELogicException bELogicException) {
//            this();
//            this.success = list;
//            this.sysException = bESystemException;
//            this.logicException = bELogicException;
//        }
//
//        public get_word_package_result(get_word_package_result get_word_package_result) {
//            if (get_word_package_result.isSetSuccess()) {
//                ArrayList arrayList = new ArrayList(get_word_package_result.success.size());
//                for (BBWordPackage bBWordPackage : get_word_package_result.success) {
//                    arrayList.add(new BBWordPackage(bBWordPackage));
//                }
//                this.success = arrayList;
//            }
//            if (get_word_package_result.isSetSysException()) {
//                this.sysException = new BESystemException(get_word_package_result.sysException);
//            }
//            if (get_word_package_result.isSetLogicException()) {
//                this.logicException = new BELogicException(get_word_package_result.logicException);
//            }
//        }
//
//        public get_word_package_result deepCopy() {
//            return new get_word_package_result(this);
//        }
//
//        public void clear() {
//            this.success = null;
//            this.sysException = null;
//            this.logicException = null;
//        }
//
//        public int getSuccessSize() {
//            if (this.success == null) {
//                return 0;
//            }
//            return this.success.size();
//        }
//
//        public Iterator<BBWordPackage> getSuccessIterator() {
//            if (this.success == null) {
//                return null;
//            }
//            return this.success.iterator();
//        }
//
//        public void addToSuccess(BBWordPackage bBWordPackage) {
//            if (this.success == null) {
//                this.success = new ArrayList();
//            }
//            this.success.add(bBWordPackage);
//        }
//
//        public List<BBWordPackage> getSuccess() {
//            return this.success;
//        }
//
//        public get_word_package_result setSuccess(List<BBWordPackage> list) {
//            this.success = list;
//            return this;
//        }
//
//        public void unsetSuccess() {
//            this.success = null;
//        }
//
//        public boolean isSetSuccess() {
//            return this.success != null;
//        }
//
//        public void setSuccessIsSet(boolean z) {
//            if (!z) {
//                this.success = null;
//            }
//        }
//
//        public BESystemException getSysException() {
//            return this.sysException;
//        }
//
//        public get_word_package_result setSysException(BESystemException bESystemException) {
//            this.sysException = bESystemException;
//            return this;
//        }
//
//        public void unsetSysException() {
//            this.sysException = null;
//        }
//
//        public boolean isSetSysException() {
//            return this.sysException != null;
//        }
//
//        public void setSysExceptionIsSet(boolean z) {
//            if (!z) {
//                this.sysException = null;
//            }
//        }
//
//        public BELogicException getLogicException() {
//            return this.logicException;
//        }
//
//        public get_word_package_result setLogicException(BELogicException bELogicException) {
//            this.logicException = bELogicException;
//            return this;
//        }
//
//        public void unsetLogicException() {
//            this.logicException = null;
//        }
//
//        public boolean isSetLogicException() {
//            return this.logicException != null;
//        }
//
//        public void setLogicExceptionIsSet(boolean z) {
//            if (!z) {
//                this.logicException = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case SUCCESS:
//                    if (obj == null) {
//                        unsetSuccess();
//                        return;
//                    } else {
//                        setSuccess((List) obj);
//                        return;
//                    }
//                case SYS_EXCEPTION:
//                    if (obj == null) {
//                        unsetSysException();
//                        return;
//                    } else {
//                        setSysException((BESystemException) obj);
//                        return;
//                    }
//                case LOGIC_EXCEPTION:
//                    if (obj == null) {
//                        unsetLogicException();
//                        return;
//                    } else {
//                        setLogicException((BELogicException) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case SUCCESS:
//                    return getSuccess();
//                case SYS_EXCEPTION:
//                    return getSysException();
//                case LOGIC_EXCEPTION:
//                    return getLogicException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case SUCCESS:
//                    return isSetSuccess();
//                case SYS_EXCEPTION:
//                    return isSetSysException();
//                case LOGIC_EXCEPTION:
//                    return isSetLogicException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_word_package_result)) {
//                return equals((get_word_package_result) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_word_package_result get_word_package_result) {
//            if (get_word_package_result == null) {
//                return false;
//            }
//            boolean isSetSuccess = isSetSuccess();
//            boolean isSetSuccess2 = get_word_package_result.isSetSuccess();
//            if ((isSetSuccess || isSetSuccess2) && (!isSetSuccess || !isSetSuccess2 || !this.success.equals(get_word_package_result.success))) {
//                return false;
//            }
//            boolean isSetSysException = isSetSysException();
//            boolean isSetSysException2 = get_word_package_result.isSetSysException();
//            if ((isSetSysException || isSetSysException2) && (!isSetSysException || !isSetSysException2 || !this.sysException.equals(get_word_package_result.sysException))) {
//                return false;
//            }
//            boolean isSetLogicException = isSetLogicException();
//            boolean isSetLogicException2 = get_word_package_result.isSetLogicException();
//            if ((isSetLogicException || isSetLogicException2) && (!isSetLogicException || !isSetLogicException2 || !this.logicException.equals(get_word_package_result.logicException))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_word_package_result get_word_package_result) {
//            if (!getClass().equals(get_word_package_result.getClass())) {
//                return getClass().getName().compareTo(get_word_package_result.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetSuccess()).compareTo(Boolean.valueOf(get_word_package_result.isSetSuccess()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetSuccess()) {
//                int a = C2121h.m5526a((List) this.success, (List) get_word_package_result.success);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetSysException()).compareTo(Boolean.valueOf(get_word_package_result.isSetSysException()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetSysException()) {
//                int a2 = C2121h.m5524a((Comparable) this.sysException, (Comparable) get_word_package_result.sysException);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            int compareTo3 = Boolean.valueOf(isSetLogicException()).compareTo(Boolean.valueOf(get_word_package_result.isSetLogicException()));
//            if (compareTo3 != 0) {
//                return compareTo3;
//            }
//            if (isSetLogicException()) {
//                int a3 = C2121h.m5524a((Comparable) this.logicException, (Comparable) get_word_package_result.logicException);
//                if (a3 != 0) {
//                    return a3;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_word_package_result(");
//            sb.append("success:");
//            if (this.success == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.success);
//            }
//            sb.append(", ");
//            sb.append("sysException:");
//            if (this.sysException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.sysException);
//            }
//            sb.append(", ");
//            sb.append("logicException:");
//            if (this.logicException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.logicException);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_word_share_info_args implements Serializable, Cloneable, Comparable<get_word_share_info_args>, C2116f<get_word_share_info_args, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2097b BOOK_ID_FIELD_DESC = new C2097b("book_id", 8, 2);
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_word_share_info_args");
//        /* access modifiers changed from: private */
//        public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 1);
//        private static final int __BOOK_ID_ISSET_ID = 1;
//        private static final int __TOPIC_ID_ISSET_ID = 0;
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        private byte __isset_bitfield;
//        public int book_id;
//        public int topic_id;
//
//        public enum _Fields implements C2124m {
//            TOPIC_ID(1, "topic_id"),
//            BOOK_ID(2, "book_id");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 1:
//                        return TOPIC_ID;
//                    case 2:
//                        return BOOK_ID;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_word_share_info_argsStandardScheme extends C2110c<get_word_share_info_args> {
//            private get_word_share_info_argsStandardScheme() {
//            }
//
//            /* synthetic */ get_word_share_info_argsStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_word_share_info_args get_word_share_info_args) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 1:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_share_info_args.topic_id = fVar.mo18513n();
//                                    get_word_share_info_args.setTopic_idIsSet(true);
//                                    break;
//                                }
//                            case 2:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_share_info_args.book_id = fVar.mo18513n();
//                                    get_word_share_info_args.setBook_idIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        if (!get_word_share_info_args.isSetTopic_id()) {
//                            throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                        } else if (!get_word_share_info_args.isSetBook_id()) {
//                            throw new C2101g("Required field 'book_id' was not found in serialized data! Struct: " + toString());
//                        } else {
//                            get_word_share_info_args.validate();
//                            return;
//                        }
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_word_share_info_args get_word_share_info_args) {
//                get_word_share_info_args.validate();
//                get_word_share_info_args.STRUCT_DESC;
//                fVar.mo18490a();
//                fVar.mo18496a(get_word_share_info_args.TOPIC_ID_FIELD_DESC);
//                fVar.mo18493a(get_word_share_info_args.topic_id);
//                fVar.mo18496a(get_word_share_info_args.BOOK_ID_FIELD_DESC);
//                fVar.mo18493a(get_word_share_info_args.book_id);
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class get_word_share_info_argsStandardSchemeFactory implements C2109b {
//            private get_word_share_info_argsStandardSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_share_info_argsStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_share_info_argsStandardScheme getScheme() {
//                return new get_word_share_info_argsStandardScheme(null);
//            }
//        }
//
//        class get_word_share_info_argsTupleScheme extends C2111d<get_word_share_info_args> {
//            private get_word_share_info_argsTupleScheme() {
//            }
//
//            /* synthetic */ get_word_share_info_argsTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_word_share_info_args get_word_share_info_args) {
//                C2106l lVar = (C2106l) fVar;
//                lVar.mo18493a(get_word_share_info_args.topic_id);
//                lVar.mo18493a(get_word_share_info_args.book_id);
//            }
//
//            public void read(C2100f fVar, get_word_share_info_args get_word_share_info_args) {
//                C2106l lVar = (C2106l) fVar;
//                get_word_share_info_args.topic_id = lVar.mo18513n();
//                get_word_share_info_args.setTopic_idIsSet(true);
//                get_word_share_info_args.book_id = lVar.mo18513n();
//                get_word_share_info_args.setBook_idIsSet(true);
//            }
//        }
//
//        class get_word_share_info_argsTupleSchemeFactory implements C2109b {
//            private get_word_share_info_argsTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_share_info_argsTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_share_info_argsTupleScheme getScheme() {
//                return new get_word_share_info_argsTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new get_word_share_info_argsStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new get_word_share_info_argsTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//            enumMap.put(_Fields.BOOK_ID, new C2091a("book_id", 1, new C2092b(8, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_word_share_info_args.class, metaDataMap);
//        }
//
//        public get_word_share_info_args() {
//            this.__isset_bitfield = 0;
//        }
//
//        public get_word_share_info_args(int i, int i2) {
//            this();
//            this.topic_id = i;
//            setTopic_idIsSet(true);
//            this.book_id = i2;
//            setBook_idIsSet(true);
//        }
//
//        public get_word_share_info_args(get_word_share_info_args get_word_share_info_args) {
//            this.__isset_bitfield = 0;
//            this.__isset_bitfield = get_word_share_info_args.__isset_bitfield;
//            this.topic_id = get_word_share_info_args.topic_id;
//            this.book_id = get_word_share_info_args.book_id;
//        }
//
//        public get_word_share_info_args deepCopy() {
//            return new get_word_share_info_args(this);
//        }
//
//        public void clear() {
//            setTopic_idIsSet(false);
//            this.topic_id = 0;
//            setBook_idIsSet(false);
//            this.book_id = 0;
//        }
//
//        public int getTopic_id() {
//            return this.topic_id;
//        }
//
//        public get_word_share_info_args setTopic_id(int i) {
//            this.topic_id = i;
//            setTopic_idIsSet(true);
//            return this;
//        }
//
//        public void unsetTopic_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//        }
//
//        public boolean isSetTopic_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 0);
//        }
//
//        public void setTopic_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//        }
//
//        public int getBook_id() {
//            return this.book_id;
//        }
//
//        public get_word_share_info_args setBook_id(int i) {
//            this.book_id = i;
//            setBook_idIsSet(true);
//            return this;
//        }
//
//        public void unsetBook_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//        }
//
//        public boolean isSetBook_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 1);
//        }
//
//        public void setBook_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case TOPIC_ID:
//                    if (obj == null) {
//                        unsetTopic_id();
//                        return;
//                    } else {
//                        setTopic_id(((Integer) obj).intValue());
//                        return;
//                    }
//                case BOOK_ID:
//                    if (obj == null) {
//                        unsetBook_id();
//                        return;
//                    } else {
//                        setBook_id(((Integer) obj).intValue());
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case TOPIC_ID:
//                    return Integer.valueOf(getTopic_id());
//                case BOOK_ID:
//                    return Integer.valueOf(getBook_id());
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case TOPIC_ID:
//                    return isSetTopic_id();
//                case BOOK_ID:
//                    return isSetBook_id();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_word_share_info_args)) {
//                return equals((get_word_share_info_args) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_word_share_info_args get_word_share_info_args) {
//            if (get_word_share_info_args != null && this.topic_id == get_word_share_info_args.topic_id && this.book_id == get_word_share_info_args.book_id) {
//                return true;
//            }
//            return false;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_word_share_info_args get_word_share_info_args) {
//            if (!getClass().equals(get_word_share_info_args.getClass())) {
//                return getClass().getName().compareTo(get_word_share_info_args.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(get_word_share_info_args.isSetTopic_id()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetTopic_id()) {
//                int a = C2121h.m5522a(this.topic_id, get_word_share_info_args.topic_id);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetBook_id()).compareTo(Boolean.valueOf(get_word_share_info_args.isSetBook_id()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetBook_id()) {
//                int a2 = C2121h.m5522a(this.book_id, get_word_share_info_args.book_id);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_word_share_info_args(");
//            sb.append("topic_id:");
//            sb.append(this.topic_id);
//            sb.append(", ");
//            sb.append("book_id:");
//            sb.append(this.book_id);
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                this.__isset_bitfield = 0;
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_word_share_info_result implements Serializable, Cloneable, Comparable<get_word_share_info_result>, C2116f<get_word_share_info_result, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2097b LOGIC_EXCEPTION_FIELD_DESC = new C2097b("logicException", JceStruct.ZERO_TAG, 2);
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_word_share_info_result");
//        /* access modifiers changed from: private */
//        public static final C2097b SUCCESS_FIELD_DESC = new C2097b("success", JceStruct.ZERO_TAG, 0);
//        /* access modifiers changed from: private */
//        public static final C2097b SYS_EXCEPTION_FIELD_DESC = new C2097b("sysException", JceStruct.ZERO_TAG, 1);
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        public BELogicException logicException;
//        public BBWordShareInfo success;
//        public BESystemException sysException;
//
//        public enum _Fields implements C2124m {
//            SUCCESS(0, "success"),
//            SYS_EXCEPTION(1, "sysException"),
//            LOGIC_EXCEPTION(2, "logicException");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 0:
//                        return SUCCESS;
//                    case 1:
//                        return SYS_EXCEPTION;
//                    case 2:
//                        return LOGIC_EXCEPTION;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_word_share_info_resultStandardScheme extends C2110c<get_word_share_info_result> {
//            private get_word_share_info_resultStandardScheme() {
//            }
//
//            /* synthetic */ get_word_share_info_resultStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_word_share_info_result get_word_share_info_result) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 0:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_share_info_result.success = new BBWordShareInfo();
//                                    get_word_share_info_result.success.read(fVar);
//                                    get_word_share_info_result.setSuccessIsSet(true);
//                                    break;
//                                }
//                            case 1:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_share_info_result.sysException = new BESystemException();
//                                    get_word_share_info_result.sysException.read(fVar);
//                                    get_word_share_info_result.setSysExceptionIsSet(true);
//                                    break;
//                                }
//                            case 2:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_share_info_result.logicException = new BELogicException();
//                                    get_word_share_info_result.logicException.read(fVar);
//                                    get_word_share_info_result.setLogicExceptionIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        get_word_share_info_result.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_word_share_info_result get_word_share_info_result) {
//                get_word_share_info_result.validate();
//                get_word_share_info_result.STRUCT_DESC;
//                fVar.mo18490a();
//                if (get_word_share_info_result.success != null) {
//                    fVar.mo18496a(get_word_share_info_result.SUCCESS_FIELD_DESC);
//                    get_word_share_info_result.success.write(fVar);
//                }
//                if (get_word_share_info_result.sysException != null) {
//                    fVar.mo18496a(get_word_share_info_result.SYS_EXCEPTION_FIELD_DESC);
//                    get_word_share_info_result.sysException.write(fVar);
//                }
//                if (get_word_share_info_result.logicException != null) {
//                    fVar.mo18496a(get_word_share_info_result.LOGIC_EXCEPTION_FIELD_DESC);
//                    get_word_share_info_result.logicException.write(fVar);
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class get_word_share_info_resultStandardSchemeFactory implements C2109b {
//            private get_word_share_info_resultStandardSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_share_info_resultStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_share_info_resultStandardScheme getScheme() {
//                return new get_word_share_info_resultStandardScheme(null);
//            }
//        }
//
//        class get_word_share_info_resultTupleScheme extends C2111d<get_word_share_info_result> {
//            private get_word_share_info_resultTupleScheme() {
//            }
//
//            /* synthetic */ get_word_share_info_resultTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_word_share_info_result get_word_share_info_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet bitSet = new BitSet();
//                if (get_word_share_info_result.isSetSuccess()) {
//                    bitSet.set(0);
//                }
//                if (get_word_share_info_result.isSetSysException()) {
//                    bitSet.set(1);
//                }
//                if (get_word_share_info_result.isSetLogicException()) {
//                    bitSet.set(2);
//                }
//                lVar.mo18527a(bitSet, 3);
//                if (get_word_share_info_result.isSetSuccess()) {
//                    get_word_share_info_result.success.write(lVar);
//                }
//                if (get_word_share_info_result.isSetSysException()) {
//                    get_word_share_info_result.sysException.write(lVar);
//                }
//                if (get_word_share_info_result.isSetLogicException()) {
//                    get_word_share_info_result.logicException.write(lVar);
//                }
//            }
//
//            public void read(C2100f fVar, get_word_share_info_result get_word_share_info_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet b = lVar.mo18528b(3);
//                if (b.get(0)) {
//                    get_word_share_info_result.success = new BBWordShareInfo();
//                    get_word_share_info_result.success.read(lVar);
//                    get_word_share_info_result.setSuccessIsSet(true);
//                }
//                if (b.get(1)) {
//                    get_word_share_info_result.sysException = new BESystemException();
//                    get_word_share_info_result.sysException.read(lVar);
//                    get_word_share_info_result.setSysExceptionIsSet(true);
//                }
//                if (b.get(2)) {
//                    get_word_share_info_result.logicException = new BELogicException();
//                    get_word_share_info_result.logicException.read(lVar);
//                    get_word_share_info_result.setLogicExceptionIsSet(true);
//                }
//            }
//        }
//
//        class get_word_share_info_resultTupleSchemeFactory implements C2109b {
//            private get_word_share_info_resultTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_share_info_resultTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_share_info_resultTupleScheme getScheme() {
//                return new get_word_share_info_resultTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new get_word_share_info_resultStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new get_word_share_info_resultTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.SUCCESS, new C2091a("success", 3, new C2095e(BBWordShareInfo.class)));
//            enumMap.put(_Fields.SYS_EXCEPTION, new C2091a("sysException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            enumMap.put(_Fields.LOGIC_EXCEPTION, new C2091a("logicException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_word_share_info_result.class, metaDataMap);
//        }
//
//        public get_word_share_info_result() {
//        }
//
//        public get_word_share_info_result(BBWordShareInfo bBWordShareInfo, BESystemException bESystemException, BELogicException bELogicException) {
//            this();
//            this.success = bBWordShareInfo;
//            this.sysException = bESystemException;
//            this.logicException = bELogicException;
//        }
//
//        public get_word_share_info_result(get_word_share_info_result get_word_share_info_result) {
//            if (get_word_share_info_result.isSetSuccess()) {
//                this.success = new BBWordShareInfo(get_word_share_info_result.success);
//            }
//            if (get_word_share_info_result.isSetSysException()) {
//                this.sysException = new BESystemException(get_word_share_info_result.sysException);
//            }
//            if (get_word_share_info_result.isSetLogicException()) {
//                this.logicException = new BELogicException(get_word_share_info_result.logicException);
//            }
//        }
//
//        public get_word_share_info_result deepCopy() {
//            return new get_word_share_info_result(this);
//        }
//
//        public void clear() {
//            this.success = null;
//            this.sysException = null;
//            this.logicException = null;
//        }
//
//        public BBWordShareInfo getSuccess() {
//            return this.success;
//        }
//
//        public get_word_share_info_result setSuccess(BBWordShareInfo bBWordShareInfo) {
//            this.success = bBWordShareInfo;
//            return this;
//        }
//
//        public void unsetSuccess() {
//            this.success = null;
//        }
//
//        public boolean isSetSuccess() {
//            return this.success != null;
//        }
//
//        public void setSuccessIsSet(boolean z) {
//            if (!z) {
//                this.success = null;
//            }
//        }
//
//        public BESystemException getSysException() {
//            return this.sysException;
//        }
//
//        public get_word_share_info_result setSysException(BESystemException bESystemException) {
//            this.sysException = bESystemException;
//            return this;
//        }
//
//        public void unsetSysException() {
//            this.sysException = null;
//        }
//
//        public boolean isSetSysException() {
//            return this.sysException != null;
//        }
//
//        public void setSysExceptionIsSet(boolean z) {
//            if (!z) {
//                this.sysException = null;
//            }
//        }
//
//        public BELogicException getLogicException() {
//            return this.logicException;
//        }
//
//        public get_word_share_info_result setLogicException(BELogicException bELogicException) {
//            this.logicException = bELogicException;
//            return this;
//        }
//
//        public void unsetLogicException() {
//            this.logicException = null;
//        }
//
//        public boolean isSetLogicException() {
//            return this.logicException != null;
//        }
//
//        public void setLogicExceptionIsSet(boolean z) {
//            if (!z) {
//                this.logicException = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case SUCCESS:
//                    if (obj == null) {
//                        unsetSuccess();
//                        return;
//                    } else {
//                        setSuccess((BBWordShareInfo) obj);
//                        return;
//                    }
//                case SYS_EXCEPTION:
//                    if (obj == null) {
//                        unsetSysException();
//                        return;
//                    } else {
//                        setSysException((BESystemException) obj);
//                        return;
//                    }
//                case LOGIC_EXCEPTION:
//                    if (obj == null) {
//                        unsetLogicException();
//                        return;
//                    } else {
//                        setLogicException((BELogicException) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case SUCCESS:
//                    return getSuccess();
//                case SYS_EXCEPTION:
//                    return getSysException();
//                case LOGIC_EXCEPTION:
//                    return getLogicException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case SUCCESS:
//                    return isSetSuccess();
//                case SYS_EXCEPTION:
//                    return isSetSysException();
//                case LOGIC_EXCEPTION:
//                    return isSetLogicException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_word_share_info_result)) {
//                return equals((get_word_share_info_result) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_word_share_info_result get_word_share_info_result) {
//            if (get_word_share_info_result == null) {
//                return false;
//            }
//            boolean isSetSuccess = isSetSuccess();
//            boolean isSetSuccess2 = get_word_share_info_result.isSetSuccess();
//            if ((isSetSuccess || isSetSuccess2) && (!isSetSuccess || !isSetSuccess2 || !this.success.equals(get_word_share_info_result.success))) {
//                return false;
//            }
//            boolean isSetSysException = isSetSysException();
//            boolean isSetSysException2 = get_word_share_info_result.isSetSysException();
//            if ((isSetSysException || isSetSysException2) && (!isSetSysException || !isSetSysException2 || !this.sysException.equals(get_word_share_info_result.sysException))) {
//                return false;
//            }
//            boolean isSetLogicException = isSetLogicException();
//            boolean isSetLogicException2 = get_word_share_info_result.isSetLogicException();
//            if ((isSetLogicException || isSetLogicException2) && (!isSetLogicException || !isSetLogicException2 || !this.logicException.equals(get_word_share_info_result.logicException))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_word_share_info_result get_word_share_info_result) {
//            if (!getClass().equals(get_word_share_info_result.getClass())) {
//                return getClass().getName().compareTo(get_word_share_info_result.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetSuccess()).compareTo(Boolean.valueOf(get_word_share_info_result.isSetSuccess()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetSuccess()) {
//                int a = C2121h.m5524a((Comparable) this.success, (Comparable) get_word_share_info_result.success);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetSysException()).compareTo(Boolean.valueOf(get_word_share_info_result.isSetSysException()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetSysException()) {
//                int a2 = C2121h.m5524a((Comparable) this.sysException, (Comparable) get_word_share_info_result.sysException);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            int compareTo3 = Boolean.valueOf(isSetLogicException()).compareTo(Boolean.valueOf(get_word_share_info_result.isSetLogicException()));
//            if (compareTo3 != 0) {
//                return compareTo3;
//            }
//            if (isSetLogicException()) {
//                int a3 = C2121h.m5524a((Comparable) this.logicException, (Comparable) get_word_share_info_result.logicException);
//                if (a3 != 0) {
//                    return a3;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_word_share_info_result(");
//            sb.append("success:");
//            if (this.success == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.success);
//            }
//            sb.append(", ");
//            sb.append("sysException:");
//            if (this.sysException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.sysException);
//            }
//            sb.append(", ");
//            sb.append("logicException:");
//            if (this.logicException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.logicException);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//            if (this.success != null) {
//                this.success.validate();
//            }
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_word_share_info_v2_args implements Serializable, Cloneable, Comparable<get_word_share_info_v2_args>, C2116f<get_word_share_info_v2_args, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2097b BOOK_ID_FIELD_DESC = new C2097b("book_id", 8, 2);
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_word_share_info_v2_args");
//        /* access modifiers changed from: private */
//        public static final C2097b TAG_ID_FIELD_DESC = new C2097b("tag_id", 8, 3);
//        /* access modifiers changed from: private */
//        public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 1);
//        private static final int __BOOK_ID_ISSET_ID = 1;
//        private static final int __TAG_ID_ISSET_ID = 2;
//        private static final int __TOPIC_ID_ISSET_ID = 0;
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        private byte __isset_bitfield;
//        public int book_id;
//        public int tag_id;
//        public int topic_id;
//
//        public enum _Fields implements C2124m {
//            TOPIC_ID(1, "topic_id"),
//            BOOK_ID(2, "book_id"),
//            TAG_ID(3, "tag_id");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 1:
//                        return TOPIC_ID;
//                    case 2:
//                        return BOOK_ID;
//                    case 3:
//                        return TAG_ID;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_word_share_info_v2_argsStandardScheme extends C2110c<get_word_share_info_v2_args> {
//            private get_word_share_info_v2_argsStandardScheme() {
//            }
//
//            /* synthetic */ get_word_share_info_v2_argsStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_word_share_info_v2_args get_word_share_info_v2_args) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 1:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_share_info_v2_args.topic_id = fVar.mo18513n();
//                                    get_word_share_info_v2_args.setTopic_idIsSet(true);
//                                    break;
//                                }
//                            case 2:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_share_info_v2_args.book_id = fVar.mo18513n();
//                                    get_word_share_info_v2_args.setBook_idIsSet(true);
//                                    break;
//                                }
//                            case 3:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_share_info_v2_args.tag_id = fVar.mo18513n();
//                                    get_word_share_info_v2_args.setTag_idIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        if (!get_word_share_info_v2_args.isSetTopic_id()) {
//                            throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                        } else if (!get_word_share_info_v2_args.isSetBook_id()) {
//                            throw new C2101g("Required field 'book_id' was not found in serialized data! Struct: " + toString());
//                        } else if (!get_word_share_info_v2_args.isSetTag_id()) {
//                            throw new C2101g("Required field 'tag_id' was not found in serialized data! Struct: " + toString());
//                        } else {
//                            get_word_share_info_v2_args.validate();
//                            return;
//                        }
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_word_share_info_v2_args get_word_share_info_v2_args) {
//                get_word_share_info_v2_args.validate();
//                get_word_share_info_v2_args.STRUCT_DESC;
//                fVar.mo18490a();
//                fVar.mo18496a(get_word_share_info_v2_args.TOPIC_ID_FIELD_DESC);
//                fVar.mo18493a(get_word_share_info_v2_args.topic_id);
//                fVar.mo18496a(get_word_share_info_v2_args.BOOK_ID_FIELD_DESC);
//                fVar.mo18493a(get_word_share_info_v2_args.book_id);
//                fVar.mo18496a(get_word_share_info_v2_args.TAG_ID_FIELD_DESC);
//                fVar.mo18493a(get_word_share_info_v2_args.tag_id);
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class get_word_share_info_v2_argsStandardSchemeFactory implements C2109b {
//            private get_word_share_info_v2_argsStandardSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_share_info_v2_argsStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_share_info_v2_argsStandardScheme getScheme() {
//                return new get_word_share_info_v2_argsStandardScheme(null);
//            }
//        }
//
//        class get_word_share_info_v2_argsTupleScheme extends C2111d<get_word_share_info_v2_args> {
//            private get_word_share_info_v2_argsTupleScheme() {
//            }
//
//            /* synthetic */ get_word_share_info_v2_argsTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_word_share_info_v2_args get_word_share_info_v2_args) {
//                C2106l lVar = (C2106l) fVar;
//                lVar.mo18493a(get_word_share_info_v2_args.topic_id);
//                lVar.mo18493a(get_word_share_info_v2_args.book_id);
//                lVar.mo18493a(get_word_share_info_v2_args.tag_id);
//            }
//
//            public void read(C2100f fVar, get_word_share_info_v2_args get_word_share_info_v2_args) {
//                C2106l lVar = (C2106l) fVar;
//                get_word_share_info_v2_args.topic_id = lVar.mo18513n();
//                get_word_share_info_v2_args.setTopic_idIsSet(true);
//                get_word_share_info_v2_args.book_id = lVar.mo18513n();
//                get_word_share_info_v2_args.setBook_idIsSet(true);
//                get_word_share_info_v2_args.tag_id = lVar.mo18513n();
//                get_word_share_info_v2_args.setTag_idIsSet(true);
//            }
//        }
//
//        class get_word_share_info_v2_argsTupleSchemeFactory implements C2109b {
//            private get_word_share_info_v2_argsTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_share_info_v2_argsTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_share_info_v2_argsTupleScheme getScheme() {
//                return new get_word_share_info_v2_argsTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new get_word_share_info_v2_argsStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new get_word_share_info_v2_argsTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//            enumMap.put(_Fields.BOOK_ID, new C2091a("book_id", 1, new C2092b(8, 0)));
//            enumMap.put(_Fields.TAG_ID, new C2091a("tag_id", 1, new C2092b(8, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_word_share_info_v2_args.class, metaDataMap);
//        }
//
//        public get_word_share_info_v2_args() {
//            this.__isset_bitfield = 0;
//        }
//
//        public get_word_share_info_v2_args(int i, int i2, int i3) {
//            this();
//            this.topic_id = i;
//            setTopic_idIsSet(true);
//            this.book_id = i2;
//            setBook_idIsSet(true);
//            this.tag_id = i3;
//            setTag_idIsSet(true);
//        }
//
//        public get_word_share_info_v2_args(get_word_share_info_v2_args get_word_share_info_v2_args) {
//            this.__isset_bitfield = 0;
//            this.__isset_bitfield = get_word_share_info_v2_args.__isset_bitfield;
//            this.topic_id = get_word_share_info_v2_args.topic_id;
//            this.book_id = get_word_share_info_v2_args.book_id;
//            this.tag_id = get_word_share_info_v2_args.tag_id;
//        }
//
//        public get_word_share_info_v2_args deepCopy() {
//            return new get_word_share_info_v2_args(this);
//        }
//
//        public void clear() {
//            setTopic_idIsSet(false);
//            this.topic_id = 0;
//            setBook_idIsSet(false);
//            this.book_id = 0;
//            setTag_idIsSet(false);
//            this.tag_id = 0;
//        }
//
//        public int getTopic_id() {
//            return this.topic_id;
//        }
//
//        public get_word_share_info_v2_args setTopic_id(int i) {
//            this.topic_id = i;
//            setTopic_idIsSet(true);
//            return this;
//        }
//
//        public void unsetTopic_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//        }
//
//        public boolean isSetTopic_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 0);
//        }
//
//        public void setTopic_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//        }
//
//        public int getBook_id() {
//            return this.book_id;
//        }
//
//        public get_word_share_info_v2_args setBook_id(int i) {
//            this.book_id = i;
//            setBook_idIsSet(true);
//            return this;
//        }
//
//        public void unsetBook_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//        }
//
//        public boolean isSetBook_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 1);
//        }
//
//        public void setBook_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//        }
//
//        public int getTag_id() {
//            return this.tag_id;
//        }
//
//        public get_word_share_info_v2_args setTag_id(int i) {
//            this.tag_id = i;
//            setTag_idIsSet(true);
//            return this;
//        }
//
//        public void unsetTag_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//        }
//
//        public boolean isSetTag_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 2);
//        }
//
//        public void setTag_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case TOPIC_ID:
//                    if (obj == null) {
//                        unsetTopic_id();
//                        return;
//                    } else {
//                        setTopic_id(((Integer) obj).intValue());
//                        return;
//                    }
//                case BOOK_ID:
//                    if (obj == null) {
//                        unsetBook_id();
//                        return;
//                    } else {
//                        setBook_id(((Integer) obj).intValue());
//                        return;
//                    }
//                case TAG_ID:
//                    if (obj == null) {
//                        unsetTag_id();
//                        return;
//                    } else {
//                        setTag_id(((Integer) obj).intValue());
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case TOPIC_ID:
//                    return Integer.valueOf(getTopic_id());
//                case BOOK_ID:
//                    return Integer.valueOf(getBook_id());
//                case TAG_ID:
//                    return Integer.valueOf(getTag_id());
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case TOPIC_ID:
//                    return isSetTopic_id();
//                case BOOK_ID:
//                    return isSetBook_id();
//                case TAG_ID:
//                    return isSetTag_id();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_word_share_info_v2_args)) {
//                return equals((get_word_share_info_v2_args) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_word_share_info_v2_args get_word_share_info_v2_args) {
//            if (get_word_share_info_v2_args != null && this.topic_id == get_word_share_info_v2_args.topic_id && this.book_id == get_word_share_info_v2_args.book_id && this.tag_id == get_word_share_info_v2_args.tag_id) {
//                return true;
//            }
//            return false;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_word_share_info_v2_args get_word_share_info_v2_args) {
//            if (!getClass().equals(get_word_share_info_v2_args.getClass())) {
//                return getClass().getName().compareTo(get_word_share_info_v2_args.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(get_word_share_info_v2_args.isSetTopic_id()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetTopic_id()) {
//                int a = C2121h.m5522a(this.topic_id, get_word_share_info_v2_args.topic_id);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetBook_id()).compareTo(Boolean.valueOf(get_word_share_info_v2_args.isSetBook_id()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetBook_id()) {
//                int a2 = C2121h.m5522a(this.book_id, get_word_share_info_v2_args.book_id);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            int compareTo3 = Boolean.valueOf(isSetTag_id()).compareTo(Boolean.valueOf(get_word_share_info_v2_args.isSetTag_id()));
//            if (compareTo3 != 0) {
//                return compareTo3;
//            }
//            if (isSetTag_id()) {
//                int a3 = C2121h.m5522a(this.tag_id, get_word_share_info_v2_args.tag_id);
//                if (a3 != 0) {
//                    return a3;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_word_share_info_v2_args(");
//            sb.append("topic_id:");
//            sb.append(this.topic_id);
//            sb.append(", ");
//            sb.append("book_id:");
//            sb.append(this.book_id);
//            sb.append(", ");
//            sb.append("tag_id:");
//            sb.append(this.tag_id);
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                this.__isset_bitfield = 0;
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_word_share_info_v2_result implements Serializable, Cloneable, Comparable<get_word_share_info_v2_result>, C2116f<get_word_share_info_v2_result, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2097b LOGIC_EXCEPTION_FIELD_DESC = new C2097b("logicException", JceStruct.ZERO_TAG, 2);
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_word_share_info_v2_result");
//        /* access modifiers changed from: private */
//        public static final C2097b SUCCESS_FIELD_DESC = new C2097b("success", JceStruct.ZERO_TAG, 0);
//        /* access modifiers changed from: private */
//        public static final C2097b SYS_EXCEPTION_FIELD_DESC = new C2097b("sysException", JceStruct.ZERO_TAG, 1);
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        public BELogicException logicException;
//        public BBWordShareInfo success;
//        public BESystemException sysException;
//
//        public enum _Fields implements C2124m {
//            SUCCESS(0, "success"),
//            SYS_EXCEPTION(1, "sysException"),
//            LOGIC_EXCEPTION(2, "logicException");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 0:
//                        return SUCCESS;
//                    case 1:
//                        return SYS_EXCEPTION;
//                    case 2:
//                        return LOGIC_EXCEPTION;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_word_share_info_v2_resultStandardScheme extends C2110c<get_word_share_info_v2_result> {
//            private get_word_share_info_v2_resultStandardScheme() {
//            }
//
//            /* synthetic */ get_word_share_info_v2_resultStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_word_share_info_v2_result get_word_share_info_v2_result) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 0:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_share_info_v2_result.success = new BBWordShareInfo();
//                                    get_word_share_info_v2_result.success.read(fVar);
//                                    get_word_share_info_v2_result.setSuccessIsSet(true);
//                                    break;
//                                }
//                            case 1:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_share_info_v2_result.sysException = new BESystemException();
//                                    get_word_share_info_v2_result.sysException.read(fVar);
//                                    get_word_share_info_v2_result.setSysExceptionIsSet(true);
//                                    break;
//                                }
//                            case 2:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_share_info_v2_result.logicException = new BELogicException();
//                                    get_word_share_info_v2_result.logicException.read(fVar);
//                                    get_word_share_info_v2_result.setLogicExceptionIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        get_word_share_info_v2_result.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_word_share_info_v2_result get_word_share_info_v2_result) {
//                get_word_share_info_v2_result.validate();
//                get_word_share_info_v2_result.STRUCT_DESC;
//                fVar.mo18490a();
//                if (get_word_share_info_v2_result.success != null) {
//                    fVar.mo18496a(get_word_share_info_v2_result.SUCCESS_FIELD_DESC);
//                    get_word_share_info_v2_result.success.write(fVar);
//                }
//                if (get_word_share_info_v2_result.sysException != null) {
//                    fVar.mo18496a(get_word_share_info_v2_result.SYS_EXCEPTION_FIELD_DESC);
//                    get_word_share_info_v2_result.sysException.write(fVar);
//                }
//                if (get_word_share_info_v2_result.logicException != null) {
//                    fVar.mo18496a(get_word_share_info_v2_result.LOGIC_EXCEPTION_FIELD_DESC);
//                    get_word_share_info_v2_result.logicException.write(fVar);
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class get_word_share_info_v2_resultStandardSchemeFactory implements C2109b {
//            private get_word_share_info_v2_resultStandardSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_share_info_v2_resultStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_share_info_v2_resultStandardScheme getScheme() {
//                return new get_word_share_info_v2_resultStandardScheme(null);
//            }
//        }
//
//        class get_word_share_info_v2_resultTupleScheme extends C2111d<get_word_share_info_v2_result> {
//            private get_word_share_info_v2_resultTupleScheme() {
//            }
//
//            /* synthetic */ get_word_share_info_v2_resultTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_word_share_info_v2_result get_word_share_info_v2_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet bitSet = new BitSet();
//                if (get_word_share_info_v2_result.isSetSuccess()) {
//                    bitSet.set(0);
//                }
//                if (get_word_share_info_v2_result.isSetSysException()) {
//                    bitSet.set(1);
//                }
//                if (get_word_share_info_v2_result.isSetLogicException()) {
//                    bitSet.set(2);
//                }
//                lVar.mo18527a(bitSet, 3);
//                if (get_word_share_info_v2_result.isSetSuccess()) {
//                    get_word_share_info_v2_result.success.write(lVar);
//                }
//                if (get_word_share_info_v2_result.isSetSysException()) {
//                    get_word_share_info_v2_result.sysException.write(lVar);
//                }
//                if (get_word_share_info_v2_result.isSetLogicException()) {
//                    get_word_share_info_v2_result.logicException.write(lVar);
//                }
//            }
//
//            public void read(C2100f fVar, get_word_share_info_v2_result get_word_share_info_v2_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet b = lVar.mo18528b(3);
//                if (b.get(0)) {
//                    get_word_share_info_v2_result.success = new BBWordShareInfo();
//                    get_word_share_info_v2_result.success.read(lVar);
//                    get_word_share_info_v2_result.setSuccessIsSet(true);
//                }
//                if (b.get(1)) {
//                    get_word_share_info_v2_result.sysException = new BESystemException();
//                    get_word_share_info_v2_result.sysException.read(lVar);
//                    get_word_share_info_v2_result.setSysExceptionIsSet(true);
//                }
//                if (b.get(2)) {
//                    get_word_share_info_v2_result.logicException = new BELogicException();
//                    get_word_share_info_v2_result.logicException.read(lVar);
//                    get_word_share_info_v2_result.setLogicExceptionIsSet(true);
//                }
//            }
//        }
//
//        class get_word_share_info_v2_resultTupleSchemeFactory implements C2109b {
//            private get_word_share_info_v2_resultTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_share_info_v2_resultTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_share_info_v2_resultTupleScheme getScheme() {
//                return new get_word_share_info_v2_resultTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new get_word_share_info_v2_resultStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new get_word_share_info_v2_resultTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.SUCCESS, new C2091a("success", 3, new C2095e(BBWordShareInfo.class)));
//            enumMap.put(_Fields.SYS_EXCEPTION, new C2091a("sysException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            enumMap.put(_Fields.LOGIC_EXCEPTION, new C2091a("logicException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_word_share_info_v2_result.class, metaDataMap);
//        }
//
//        public get_word_share_info_v2_result() {
//        }
//
//        public get_word_share_info_v2_result(BBWordShareInfo bBWordShareInfo, BESystemException bESystemException, BELogicException bELogicException) {
//            this();
//            this.success = bBWordShareInfo;
//            this.sysException = bESystemException;
//            this.logicException = bELogicException;
//        }
//
//        public get_word_share_info_v2_result(get_word_share_info_v2_result get_word_share_info_v2_result) {
//            if (get_word_share_info_v2_result.isSetSuccess()) {
//                this.success = new BBWordShareInfo(get_word_share_info_v2_result.success);
//            }
//            if (get_word_share_info_v2_result.isSetSysException()) {
//                this.sysException = new BESystemException(get_word_share_info_v2_result.sysException);
//            }
//            if (get_word_share_info_v2_result.isSetLogicException()) {
//                this.logicException = new BELogicException(get_word_share_info_v2_result.logicException);
//            }
//        }
//
//        public get_word_share_info_v2_result deepCopy() {
//            return new get_word_share_info_v2_result(this);
//        }
//
//        public void clear() {
//            this.success = null;
//            this.sysException = null;
//            this.logicException = null;
//        }
//
//        public BBWordShareInfo getSuccess() {
//            return this.success;
//        }
//
//        public get_word_share_info_v2_result setSuccess(BBWordShareInfo bBWordShareInfo) {
//            this.success = bBWordShareInfo;
//            return this;
//        }
//
//        public void unsetSuccess() {
//            this.success = null;
//        }
//
//        public boolean isSetSuccess() {
//            return this.success != null;
//        }
//
//        public void setSuccessIsSet(boolean z) {
//            if (!z) {
//                this.success = null;
//            }
//        }
//
//        public BESystemException getSysException() {
//            return this.sysException;
//        }
//
//        public get_word_share_info_v2_result setSysException(BESystemException bESystemException) {
//            this.sysException = bESystemException;
//            return this;
//        }
//
//        public void unsetSysException() {
//            this.sysException = null;
//        }
//
//        public boolean isSetSysException() {
//            return this.sysException != null;
//        }
//
//        public void setSysExceptionIsSet(boolean z) {
//            if (!z) {
//                this.sysException = null;
//            }
//        }
//
//        public BELogicException getLogicException() {
//            return this.logicException;
//        }
//
//        public get_word_share_info_v2_result setLogicException(BELogicException bELogicException) {
//            this.logicException = bELogicException;
//            return this;
//        }
//
//        public void unsetLogicException() {
//            this.logicException = null;
//        }
//
//        public boolean isSetLogicException() {
//            return this.logicException != null;
//        }
//
//        public void setLogicExceptionIsSet(boolean z) {
//            if (!z) {
//                this.logicException = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case SUCCESS:
//                    if (obj == null) {
//                        unsetSuccess();
//                        return;
//                    } else {
//                        setSuccess((BBWordShareInfo) obj);
//                        return;
//                    }
//                case SYS_EXCEPTION:
//                    if (obj == null) {
//                        unsetSysException();
//                        return;
//                    } else {
//                        setSysException((BESystemException) obj);
//                        return;
//                    }
//                case LOGIC_EXCEPTION:
//                    if (obj == null) {
//                        unsetLogicException();
//                        return;
//                    } else {
//                        setLogicException((BELogicException) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case SUCCESS:
//                    return getSuccess();
//                case SYS_EXCEPTION:
//                    return getSysException();
//                case LOGIC_EXCEPTION:
//                    return getLogicException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case SUCCESS:
//                    return isSetSuccess();
//                case SYS_EXCEPTION:
//                    return isSetSysException();
//                case LOGIC_EXCEPTION:
//                    return isSetLogicException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_word_share_info_v2_result)) {
//                return equals((get_word_share_info_v2_result) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_word_share_info_v2_result get_word_share_info_v2_result) {
//            if (get_word_share_info_v2_result == null) {
//                return false;
//            }
//            boolean isSetSuccess = isSetSuccess();
//            boolean isSetSuccess2 = get_word_share_info_v2_result.isSetSuccess();
//            if ((isSetSuccess || isSetSuccess2) && (!isSetSuccess || !isSetSuccess2 || !this.success.equals(get_word_share_info_v2_result.success))) {
//                return false;
//            }
//            boolean isSetSysException = isSetSysException();
//            boolean isSetSysException2 = get_word_share_info_v2_result.isSetSysException();
//            if ((isSetSysException || isSetSysException2) && (!isSetSysException || !isSetSysException2 || !this.sysException.equals(get_word_share_info_v2_result.sysException))) {
//                return false;
//            }
//            boolean isSetLogicException = isSetLogicException();
//            boolean isSetLogicException2 = get_word_share_info_v2_result.isSetLogicException();
//            if ((isSetLogicException || isSetLogicException2) && (!isSetLogicException || !isSetLogicException2 || !this.logicException.equals(get_word_share_info_v2_result.logicException))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_word_share_info_v2_result get_word_share_info_v2_result) {
//            if (!getClass().equals(get_word_share_info_v2_result.getClass())) {
//                return getClass().getName().compareTo(get_word_share_info_v2_result.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetSuccess()).compareTo(Boolean.valueOf(get_word_share_info_v2_result.isSetSuccess()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetSuccess()) {
//                int a = C2121h.m5524a((Comparable) this.success, (Comparable) get_word_share_info_v2_result.success);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetSysException()).compareTo(Boolean.valueOf(get_word_share_info_v2_result.isSetSysException()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetSysException()) {
//                int a2 = C2121h.m5524a((Comparable) this.sysException, (Comparable) get_word_share_info_v2_result.sysException);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            int compareTo3 = Boolean.valueOf(isSetLogicException()).compareTo(Boolean.valueOf(get_word_share_info_v2_result.isSetLogicException()));
//            if (compareTo3 != 0) {
//                return compareTo3;
//            }
//            if (isSetLogicException()) {
//                int a3 = C2121h.m5524a((Comparable) this.logicException, (Comparable) get_word_share_info_v2_result.logicException);
//                if (a3 != 0) {
//                    return a3;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_word_share_info_v2_result(");
//            sb.append("success:");
//            if (this.success == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.success);
//            }
//            sb.append(", ");
//            sb.append("sysException:");
//            if (this.sysException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.sysException);
//            }
//            sb.append(", ");
//            sb.append("logicException:");
//            if (this.logicException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.logicException);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//            if (this.success != null) {
//                this.success.validate();
//            }
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_word_topic_assets_args implements Serializable, Cloneable, Comparable<get_word_topic_assets_args>, C2116f<get_word_topic_assets_args, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_word_topic_assets_args");
//        /* access modifiers changed from: private */
//        public static final C2097b TOPIC_IDS_FIELD_DESC = new C2097b("topic_ids", 15, 2);
//        /* access modifiers changed from: private */
//        public static final C2097b WORD_LEVEL_ID_FIELD_DESC = new C2097b("word_level_id", 8, 1);
//        private static final int __WORD_LEVEL_ID_ISSET_ID = 0;
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        private byte __isset_bitfield;
//        public List<Integer> topic_ids;
//        public int word_level_id;
//
//        public enum _Fields implements C2124m {
//            WORD_LEVEL_ID(1, "word_level_id"),
//            TOPIC_IDS(2, "topic_ids");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 1:
//                        return WORD_LEVEL_ID;
//                    case 2:
//                        return TOPIC_IDS;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_word_topic_assets_argsStandardScheme extends C2110c<get_word_topic_assets_args> {
//            private get_word_topic_assets_argsStandardScheme() {
//            }
//
//            /* synthetic */ get_word_topic_assets_argsStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_word_topic_assets_args get_word_topic_assets_args) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 1:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_topic_assets_args.word_level_id = fVar.mo18513n();
//                                    get_word_topic_assets_args.setWord_level_idIsSet(true);
//                                    break;
//                                }
//                            case 2:
//                                if (g.f5835b != 15) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    C2098c i = fVar.mo18508i();
//                                    get_word_topic_assets_args.topic_ids = new ArrayList(i.f5838b);
//                                    for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                        get_word_topic_assets_args.topic_ids.add(Integer.valueOf(fVar.mo18513n()));
//                                    }
//                                    get_word_topic_assets_args.setTopic_idsIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        if (!get_word_topic_assets_args.isSetWord_level_id()) {
//                            throw new C2101g("Required field 'word_level_id' was not found in serialized data! Struct: " + toString());
//                        }
//                        get_word_topic_assets_args.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_word_topic_assets_args get_word_topic_assets_args) {
//                get_word_topic_assets_args.validate();
//                get_word_topic_assets_args.STRUCT_DESC;
//                fVar.mo18490a();
//                fVar.mo18496a(get_word_topic_assets_args.WORD_LEVEL_ID_FIELD_DESC);
//                fVar.mo18493a(get_word_topic_assets_args.word_level_id);
//                if (get_word_topic_assets_args.topic_ids != null) {
//                    fVar.mo18496a(get_word_topic_assets_args.TOPIC_IDS_FIELD_DESC);
//                    fVar.mo18497a(new C2098c(8, get_word_topic_assets_args.topic_ids.size()));
//                    for (Integer intValue : get_word_topic_assets_args.topic_ids) {
//                        fVar.mo18493a(intValue.intValue());
//                    }
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class get_word_topic_assets_argsStandardSchemeFactory implements C2109b {
//            private get_word_topic_assets_argsStandardSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_topic_assets_argsStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_topic_assets_argsStandardScheme getScheme() {
//                return new get_word_topic_assets_argsStandardScheme(null);
//            }
//        }
//
//        class get_word_topic_assets_argsTupleScheme extends C2111d<get_word_topic_assets_args> {
//            private get_word_topic_assets_argsTupleScheme() {
//            }
//
//            /* synthetic */ get_word_topic_assets_argsTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_word_topic_assets_args get_word_topic_assets_args) {
//                C2106l lVar = (C2106l) fVar;
//                lVar.mo18493a(get_word_topic_assets_args.word_level_id);
//                lVar.mo18493a(get_word_topic_assets_args.topic_ids.size());
//                for (Integer intValue : get_word_topic_assets_args.topic_ids) {
//                    lVar.mo18493a(intValue.intValue());
//                }
//            }
//
//            public void read(C2100f fVar, get_word_topic_assets_args get_word_topic_assets_args) {
//                C2106l lVar = (C2106l) fVar;
//                get_word_topic_assets_args.word_level_id = lVar.mo18513n();
//                get_word_topic_assets_args.setWord_level_idIsSet(true);
//                C2098c cVar = new C2098c(8, lVar.mo18513n());
//                get_word_topic_assets_args.topic_ids = new ArrayList(cVar.f5838b);
//                for (int i = 0; i < cVar.f5838b; i++) {
//                    get_word_topic_assets_args.topic_ids.add(Integer.valueOf(lVar.mo18513n()));
//                }
//                get_word_topic_assets_args.setTopic_idsIsSet(true);
//            }
//        }
//
//        class get_word_topic_assets_argsTupleSchemeFactory implements C2109b {
//            private get_word_topic_assets_argsTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_topic_assets_argsTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_topic_assets_argsTupleScheme getScheme() {
//                return new get_word_topic_assets_argsTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new get_word_topic_assets_argsStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new get_word_topic_assets_argsTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.WORD_LEVEL_ID, new C2091a("word_level_id", 1, new C2092b(8, 0)));
//            enumMap.put(_Fields.TOPIC_IDS, new C2091a("topic_ids", 1, new C2093c(new C2092b(8, 0))));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_word_topic_assets_args.class, metaDataMap);
//        }
//
//        public get_word_topic_assets_args() {
//            this.__isset_bitfield = 0;
//        }
//
//        public get_word_topic_assets_args(int i, List<Integer> list) {
//            this();
//            this.word_level_id = i;
//            setWord_level_idIsSet(true);
//            this.topic_ids = list;
//        }
//
//        public get_word_topic_assets_args(get_word_topic_assets_args get_word_topic_assets_args) {
//            this.__isset_bitfield = 0;
//            this.__isset_bitfield = get_word_topic_assets_args.__isset_bitfield;
//            this.word_level_id = get_word_topic_assets_args.word_level_id;
//            if (get_word_topic_assets_args.isSetTopic_ids()) {
//                this.topic_ids = new ArrayList(get_word_topic_assets_args.topic_ids);
//            }
//        }
//
//        public get_word_topic_assets_args deepCopy() {
//            return new get_word_topic_assets_args(this);
//        }
//
//        public void clear() {
//            setWord_level_idIsSet(false);
//            this.word_level_id = 0;
//            this.topic_ids = null;
//        }
//
//        public int getWord_level_id() {
//            return this.word_level_id;
//        }
//
//        public get_word_topic_assets_args setWord_level_id(int i) {
//            this.word_level_id = i;
//            setWord_level_idIsSet(true);
//            return this;
//        }
//
//        public void unsetWord_level_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//        }
//
//        public boolean isSetWord_level_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 0);
//        }
//
//        public void setWord_level_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//        }
//
//        public int getTopic_idsSize() {
//            if (this.topic_ids == null) {
//                return 0;
//            }
//            return this.topic_ids.size();
//        }
//
//        public Iterator<Integer> getTopic_idsIterator() {
//            if (this.topic_ids == null) {
//                return null;
//            }
//            return this.topic_ids.iterator();
//        }
//
//        public void addToTopic_ids(int i) {
//            if (this.topic_ids == null) {
//                this.topic_ids = new ArrayList();
//            }
//            this.topic_ids.add(Integer.valueOf(i));
//        }
//
//        public List<Integer> getTopic_ids() {
//            return this.topic_ids;
//        }
//
//        public get_word_topic_assets_args setTopic_ids(List<Integer> list) {
//            this.topic_ids = list;
//            return this;
//        }
//
//        public void unsetTopic_ids() {
//            this.topic_ids = null;
//        }
//
//        public boolean isSetTopic_ids() {
//            return this.topic_ids != null;
//        }
//
//        public void setTopic_idsIsSet(boolean z) {
//            if (!z) {
//                this.topic_ids = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case WORD_LEVEL_ID:
//                    if (obj == null) {
//                        unsetWord_level_id();
//                        return;
//                    } else {
//                        setWord_level_id(((Integer) obj).intValue());
//                        return;
//                    }
//                case TOPIC_IDS:
//                    if (obj == null) {
//                        unsetTopic_ids();
//                        return;
//                    } else {
//                        setTopic_ids((List) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case WORD_LEVEL_ID:
//                    return Integer.valueOf(getWord_level_id());
//                case TOPIC_IDS:
//                    return getTopic_ids();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case WORD_LEVEL_ID:
//                    return isSetWord_level_id();
//                case TOPIC_IDS:
//                    return isSetTopic_ids();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_word_topic_assets_args)) {
//                return equals((get_word_topic_assets_args) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_word_topic_assets_args get_word_topic_assets_args) {
//            if (get_word_topic_assets_args == null || this.word_level_id != get_word_topic_assets_args.word_level_id) {
//                return false;
//            }
//            boolean isSetTopic_ids = isSetTopic_ids();
//            boolean isSetTopic_ids2 = get_word_topic_assets_args.isSetTopic_ids();
//            if ((isSetTopic_ids || isSetTopic_ids2) && (!isSetTopic_ids || !isSetTopic_ids2 || !this.topic_ids.equals(get_word_topic_assets_args.topic_ids))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_word_topic_assets_args get_word_topic_assets_args) {
//            if (!getClass().equals(get_word_topic_assets_args.getClass())) {
//                return getClass().getName().compareTo(get_word_topic_assets_args.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetWord_level_id()).compareTo(Boolean.valueOf(get_word_topic_assets_args.isSetWord_level_id()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetWord_level_id()) {
//                int a = C2121h.m5522a(this.word_level_id, get_word_topic_assets_args.word_level_id);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetTopic_ids()).compareTo(Boolean.valueOf(get_word_topic_assets_args.isSetTopic_ids()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetTopic_ids()) {
//                int a2 = C2121h.m5526a((List) this.topic_ids, (List) get_word_topic_assets_args.topic_ids);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_word_topic_assets_args(");
//            sb.append("word_level_id:");
//            sb.append(this.word_level_id);
//            sb.append(", ");
//            sb.append("topic_ids:");
//            if (this.topic_ids == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.topic_ids);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//            if (this.topic_ids == null) {
//                throw new C2101g("Required field 'topic_ids' was not present! Struct: " + toString());
//            }
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                this.__isset_bitfield = 0;
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_word_topic_assets_result implements Serializable, Cloneable, Comparable<get_word_topic_assets_result>, C2116f<get_word_topic_assets_result, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_word_topic_assets_result");
//        /* access modifiers changed from: private */
//        public static final C2097b SUCCESS_FIELD_DESC = new C2097b("success", 15, 0);
//        /* access modifiers changed from: private */
//        public static final C2097b SYS_EXCEPTION_FIELD_DESC = new C2097b("sysException", JceStruct.ZERO_TAG, 1);
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        public List<BBTopicAsset> success;
//        public BESystemException sysException;
//
//        public enum _Fields implements C2124m {
//            SUCCESS(0, "success"),
//            SYS_EXCEPTION(1, "sysException");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 0:
//                        return SUCCESS;
//                    case 1:
//                        return SYS_EXCEPTION;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_word_topic_assets_resultStandardScheme extends C2110c<get_word_topic_assets_result> {
//            private get_word_topic_assets_resultStandardScheme() {
//            }
//
//            /* synthetic */ get_word_topic_assets_resultStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_word_topic_assets_result get_word_topic_assets_result) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 0:
//                                if (g.f5835b != 15) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    C2098c i = fVar.mo18508i();
//                                    get_word_topic_assets_result.success = new ArrayList(i.f5838b);
//                                    for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                        BBTopicAsset bBTopicAsset = new BBTopicAsset();
//                                        bBTopicAsset.read(fVar);
//                                        get_word_topic_assets_result.success.add(bBTopicAsset);
//                                    }
//                                    get_word_topic_assets_result.setSuccessIsSet(true);
//                                    break;
//                                }
//                            case 1:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_topic_assets_result.sysException = new BESystemException();
//                                    get_word_topic_assets_result.sysException.read(fVar);
//                                    get_word_topic_assets_result.setSysExceptionIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        get_word_topic_assets_result.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_word_topic_assets_result get_word_topic_assets_result) {
//                get_word_topic_assets_result.validate();
//                get_word_topic_assets_result.STRUCT_DESC;
//                fVar.mo18490a();
//                if (get_word_topic_assets_result.success != null) {
//                    fVar.mo18496a(get_word_topic_assets_result.SUCCESS_FIELD_DESC);
//                    fVar.mo18497a(new C2098c(JceStruct.ZERO_TAG, get_word_topic_assets_result.success.size()));
//                    for (BBTopicAsset write : get_word_topic_assets_result.success) {
//                        write.write(fVar);
//                    }
//                }
//                if (get_word_topic_assets_result.sysException != null) {
//                    fVar.mo18496a(get_word_topic_assets_result.SYS_EXCEPTION_FIELD_DESC);
//                    get_word_topic_assets_result.sysException.write(fVar);
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class get_word_topic_assets_resultStandardSchemeFactory implements C2109b {
//            private get_word_topic_assets_resultStandardSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_topic_assets_resultStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_topic_assets_resultStandardScheme getScheme() {
//                return new get_word_topic_assets_resultStandardScheme(null);
//            }
//        }
//
//        class get_word_topic_assets_resultTupleScheme extends C2111d<get_word_topic_assets_result> {
//            private get_word_topic_assets_resultTupleScheme() {
//            }
//
//            /* synthetic */ get_word_topic_assets_resultTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_word_topic_assets_result get_word_topic_assets_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet bitSet = new BitSet();
//                if (get_word_topic_assets_result.isSetSuccess()) {
//                    bitSet.set(0);
//                }
//                if (get_word_topic_assets_result.isSetSysException()) {
//                    bitSet.set(1);
//                }
//                lVar.mo18527a(bitSet, 2);
//                if (get_word_topic_assets_result.isSetSuccess()) {
//                    lVar.mo18493a(get_word_topic_assets_result.success.size());
//                    for (BBTopicAsset write : get_word_topic_assets_result.success) {
//                        write.write(lVar);
//                    }
//                }
//                if (get_word_topic_assets_result.isSetSysException()) {
//                    get_word_topic_assets_result.sysException.write(lVar);
//                }
//            }
//
//            public void read(C2100f fVar, get_word_topic_assets_result get_word_topic_assets_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet b = lVar.mo18528b(2);
//                if (b.get(0)) {
//                    C2098c cVar = new C2098c(JceStruct.ZERO_TAG, lVar.mo18513n());
//                    get_word_topic_assets_result.success = new ArrayList(cVar.f5838b);
//                    for (int i = 0; i < cVar.f5838b; i++) {
//                        BBTopicAsset bBTopicAsset = new BBTopicAsset();
//                        bBTopicAsset.read(lVar);
//                        get_word_topic_assets_result.success.add(bBTopicAsset);
//                    }
//                    get_word_topic_assets_result.setSuccessIsSet(true);
//                }
//                if (b.get(1)) {
//                    get_word_topic_assets_result.sysException = new BESystemException();
//                    get_word_topic_assets_result.sysException.read(lVar);
//                    get_word_topic_assets_result.setSysExceptionIsSet(true);
//                }
//            }
//        }
//
//        class get_word_topic_assets_resultTupleSchemeFactory implements C2109b {
//            private get_word_topic_assets_resultTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_topic_assets_resultTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_topic_assets_resultTupleScheme getScheme() {
//                return new get_word_topic_assets_resultTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new get_word_topic_assets_resultStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new get_word_topic_assets_resultTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.SUCCESS, new C2091a("success", 3, new C2093c(new C2095e(BBTopicAsset.class))));
//            enumMap.put(_Fields.SYS_EXCEPTION, new C2091a("sysException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_word_topic_assets_result.class, metaDataMap);
//        }
//
//        public get_word_topic_assets_result() {
//        }
//
//        public get_word_topic_assets_result(List<BBTopicAsset> list, BESystemException bESystemException) {
//            this();
//            this.success = list;
//            this.sysException = bESystemException;
//        }
//
//        public get_word_topic_assets_result(get_word_topic_assets_result get_word_topic_assets_result) {
//            if (get_word_topic_assets_result.isSetSuccess()) {
//                ArrayList arrayList = new ArrayList(get_word_topic_assets_result.success.size());
//                for (BBTopicAsset bBTopicAsset : get_word_topic_assets_result.success) {
//                    arrayList.add(new BBTopicAsset(bBTopicAsset));
//                }
//                this.success = arrayList;
//            }
//            if (get_word_topic_assets_result.isSetSysException()) {
//                this.sysException = new BESystemException(get_word_topic_assets_result.sysException);
//            }
//        }
//
//        public get_word_topic_assets_result deepCopy() {
//            return new get_word_topic_assets_result(this);
//        }
//
//        public void clear() {
//            this.success = null;
//            this.sysException = null;
//        }
//
//        public int getSuccessSize() {
//            if (this.success == null) {
//                return 0;
//            }
//            return this.success.size();
//        }
//
//        public Iterator<BBTopicAsset> getSuccessIterator() {
//            if (this.success == null) {
//                return null;
//            }
//            return this.success.iterator();
//        }
//
//        public void addToSuccess(BBTopicAsset bBTopicAsset) {
//            if (this.success == null) {
//                this.success = new ArrayList();
//            }
//            this.success.add(bBTopicAsset);
//        }
//
//        public List<BBTopicAsset> getSuccess() {
//            return this.success;
//        }
//
//        public get_word_topic_assets_result setSuccess(List<BBTopicAsset> list) {
//            this.success = list;
//            return this;
//        }
//
//        public void unsetSuccess() {
//            this.success = null;
//        }
//
//        public boolean isSetSuccess() {
//            return this.success != null;
//        }
//
//        public void setSuccessIsSet(boolean z) {
//            if (!z) {
//                this.success = null;
//            }
//        }
//
//        public BESystemException getSysException() {
//            return this.sysException;
//        }
//
//        public get_word_topic_assets_result setSysException(BESystemException bESystemException) {
//            this.sysException = bESystemException;
//            return this;
//        }
//
//        public void unsetSysException() {
//            this.sysException = null;
//        }
//
//        public boolean isSetSysException() {
//            return this.sysException != null;
//        }
//
//        public void setSysExceptionIsSet(boolean z) {
//            if (!z) {
//                this.sysException = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case SUCCESS:
//                    if (obj == null) {
//                        unsetSuccess();
//                        return;
//                    } else {
//                        setSuccess((List) obj);
//                        return;
//                    }
//                case SYS_EXCEPTION:
//                    if (obj == null) {
//                        unsetSysException();
//                        return;
//                    } else {
//                        setSysException((BESystemException) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case SUCCESS:
//                    return getSuccess();
//                case SYS_EXCEPTION:
//                    return getSysException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case SUCCESS:
//                    return isSetSuccess();
//                case SYS_EXCEPTION:
//                    return isSetSysException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_word_topic_assets_result)) {
//                return equals((get_word_topic_assets_result) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_word_topic_assets_result get_word_topic_assets_result) {
//            if (get_word_topic_assets_result == null) {
//                return false;
//            }
//            boolean isSetSuccess = isSetSuccess();
//            boolean isSetSuccess2 = get_word_topic_assets_result.isSetSuccess();
//            if ((isSetSuccess || isSetSuccess2) && (!isSetSuccess || !isSetSuccess2 || !this.success.equals(get_word_topic_assets_result.success))) {
//                return false;
//            }
//            boolean isSetSysException = isSetSysException();
//            boolean isSetSysException2 = get_word_topic_assets_result.isSetSysException();
//            if ((isSetSysException || isSetSysException2) && (!isSetSysException || !isSetSysException2 || !this.sysException.equals(get_word_topic_assets_result.sysException))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_word_topic_assets_result get_word_topic_assets_result) {
//            if (!getClass().equals(get_word_topic_assets_result.getClass())) {
//                return getClass().getName().compareTo(get_word_topic_assets_result.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetSuccess()).compareTo(Boolean.valueOf(get_word_topic_assets_result.isSetSuccess()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetSuccess()) {
//                int a = C2121h.m5526a((List) this.success, (List) get_word_topic_assets_result.success);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetSysException()).compareTo(Boolean.valueOf(get_word_topic_assets_result.isSetSysException()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetSysException()) {
//                int a2 = C2121h.m5524a((Comparable) this.sysException, (Comparable) get_word_topic_assets_result.sysException);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_word_topic_assets_result(");
//            sb.append("success:");
//            if (this.success == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.success);
//            }
//            sb.append(", ");
//            sb.append("sysException:");
//            if (this.sysException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.sysException);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_word_topic_assets_v2_args implements Serializable, Cloneable, Comparable<get_word_topic_assets_v2_args>, C2116f<get_word_topic_assets_v2_args, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_word_topic_assets_v2_args");
//        /* access modifiers changed from: private */
//        public static final C2097b TOPIC_IDS_FIELD_DESC = new C2097b("topic_ids", 15, 2);
//        /* access modifiers changed from: private */
//        public static final C2097b WORD_LEVEL_ID_FIELD_DESC = new C2097b("word_level_id", 8, 1);
//        private static final int __WORD_LEVEL_ID_ISSET_ID = 0;
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        private byte __isset_bitfield;
//        public List<Integer> topic_ids;
//        public int word_level_id;
//
//        public enum _Fields implements C2124m {
//            WORD_LEVEL_ID(1, "word_level_id"),
//            TOPIC_IDS(2, "topic_ids");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 1:
//                        return WORD_LEVEL_ID;
//                    case 2:
//                        return TOPIC_IDS;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_word_topic_assets_v2_argsStandardScheme extends C2110c<get_word_topic_assets_v2_args> {
//            private get_word_topic_assets_v2_argsStandardScheme() {
//            }
//
//            /* synthetic */ get_word_topic_assets_v2_argsStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_word_topic_assets_v2_args get_word_topic_assets_v2_args) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 1:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_topic_assets_v2_args.word_level_id = fVar.mo18513n();
//                                    get_word_topic_assets_v2_args.setWord_level_idIsSet(true);
//                                    break;
//                                }
//                            case 2:
//                                if (g.f5835b != 15) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    C2098c i = fVar.mo18508i();
//                                    get_word_topic_assets_v2_args.topic_ids = new ArrayList(i.f5838b);
//                                    for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                        get_word_topic_assets_v2_args.topic_ids.add(Integer.valueOf(fVar.mo18513n()));
//                                    }
//                                    get_word_topic_assets_v2_args.setTopic_idsIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        if (!get_word_topic_assets_v2_args.isSetWord_level_id()) {
//                            throw new C2101g("Required field 'word_level_id' was not found in serialized data! Struct: " + toString());
//                        }
//                        get_word_topic_assets_v2_args.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_word_topic_assets_v2_args get_word_topic_assets_v2_args) {
//                get_word_topic_assets_v2_args.validate();
//                get_word_topic_assets_v2_args.STRUCT_DESC;
//                fVar.mo18490a();
//                fVar.mo18496a(get_word_topic_assets_v2_args.WORD_LEVEL_ID_FIELD_DESC);
//                fVar.mo18493a(get_word_topic_assets_v2_args.word_level_id);
//                if (get_word_topic_assets_v2_args.topic_ids != null) {
//                    fVar.mo18496a(get_word_topic_assets_v2_args.TOPIC_IDS_FIELD_DESC);
//                    fVar.mo18497a(new C2098c(8, get_word_topic_assets_v2_args.topic_ids.size()));
//                    for (Integer intValue : get_word_topic_assets_v2_args.topic_ids) {
//                        fVar.mo18493a(intValue.intValue());
//                    }
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class get_word_topic_assets_v2_argsStandardSchemeFactory implements C2109b {
//            private get_word_topic_assets_v2_argsStandardSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_topic_assets_v2_argsStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_topic_assets_v2_argsStandardScheme getScheme() {
//                return new get_word_topic_assets_v2_argsStandardScheme(null);
//            }
//        }
//
//        class get_word_topic_assets_v2_argsTupleScheme extends C2111d<get_word_topic_assets_v2_args> {
//            private get_word_topic_assets_v2_argsTupleScheme() {
//            }
//
//            /* synthetic */ get_word_topic_assets_v2_argsTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_word_topic_assets_v2_args get_word_topic_assets_v2_args) {
//                C2106l lVar = (C2106l) fVar;
//                lVar.mo18493a(get_word_topic_assets_v2_args.word_level_id);
//                lVar.mo18493a(get_word_topic_assets_v2_args.topic_ids.size());
//                for (Integer intValue : get_word_topic_assets_v2_args.topic_ids) {
//                    lVar.mo18493a(intValue.intValue());
//                }
//            }
//
//            public void read(C2100f fVar, get_word_topic_assets_v2_args get_word_topic_assets_v2_args) {
//                C2106l lVar = (C2106l) fVar;
//                get_word_topic_assets_v2_args.word_level_id = lVar.mo18513n();
//                get_word_topic_assets_v2_args.setWord_level_idIsSet(true);
//                C2098c cVar = new C2098c(8, lVar.mo18513n());
//                get_word_topic_assets_v2_args.topic_ids = new ArrayList(cVar.f5838b);
//                for (int i = 0; i < cVar.f5838b; i++) {
//                    get_word_topic_assets_v2_args.topic_ids.add(Integer.valueOf(lVar.mo18513n()));
//                }
//                get_word_topic_assets_v2_args.setTopic_idsIsSet(true);
//            }
//        }
//
//        class get_word_topic_assets_v2_argsTupleSchemeFactory implements C2109b {
//            private get_word_topic_assets_v2_argsTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_topic_assets_v2_argsTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_topic_assets_v2_argsTupleScheme getScheme() {
//                return new get_word_topic_assets_v2_argsTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new get_word_topic_assets_v2_argsStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new get_word_topic_assets_v2_argsTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.WORD_LEVEL_ID, new C2091a("word_level_id", 1, new C2092b(8, 0)));
//            enumMap.put(_Fields.TOPIC_IDS, new C2091a("topic_ids", 1, new C2093c(new C2092b(8, 0))));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_word_topic_assets_v2_args.class, metaDataMap);
//        }
//
//        public get_word_topic_assets_v2_args() {
//            this.__isset_bitfield = 0;
//        }
//
//        public get_word_topic_assets_v2_args(int i, List<Integer> list) {
//            this();
//            this.word_level_id = i;
//            setWord_level_idIsSet(true);
//            this.topic_ids = list;
//        }
//
//        public get_word_topic_assets_v2_args(get_word_topic_assets_v2_args get_word_topic_assets_v2_args) {
//            this.__isset_bitfield = 0;
//            this.__isset_bitfield = get_word_topic_assets_v2_args.__isset_bitfield;
//            this.word_level_id = get_word_topic_assets_v2_args.word_level_id;
//            if (get_word_topic_assets_v2_args.isSetTopic_ids()) {
//                this.topic_ids = new ArrayList(get_word_topic_assets_v2_args.topic_ids);
//            }
//        }
//
//        public get_word_topic_assets_v2_args deepCopy() {
//            return new get_word_topic_assets_v2_args(this);
//        }
//
//        public void clear() {
//            setWord_level_idIsSet(false);
//            this.word_level_id = 0;
//            this.topic_ids = null;
//        }
//
//        public int getWord_level_id() {
//            return this.word_level_id;
//        }
//
//        public get_word_topic_assets_v2_args setWord_level_id(int i) {
//            this.word_level_id = i;
//            setWord_level_idIsSet(true);
//            return this;
//        }
//
//        public void unsetWord_level_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//        }
//
//        public boolean isSetWord_level_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 0);
//        }
//
//        public void setWord_level_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//        }
//
//        public int getTopic_idsSize() {
//            if (this.topic_ids == null) {
//                return 0;
//            }
//            return this.topic_ids.size();
//        }
//
//        public Iterator<Integer> getTopic_idsIterator() {
//            if (this.topic_ids == null) {
//                return null;
//            }
//            return this.topic_ids.iterator();
//        }
//
//        public void addToTopic_ids(int i) {
//            if (this.topic_ids == null) {
//                this.topic_ids = new ArrayList();
//            }
//            this.topic_ids.add(Integer.valueOf(i));
//        }
//
//        public List<Integer> getTopic_ids() {
//            return this.topic_ids;
//        }
//
//        public get_word_topic_assets_v2_args setTopic_ids(List<Integer> list) {
//            this.topic_ids = list;
//            return this;
//        }
//
//        public void unsetTopic_ids() {
//            this.topic_ids = null;
//        }
//
//        public boolean isSetTopic_ids() {
//            return this.topic_ids != null;
//        }
//
//        public void setTopic_idsIsSet(boolean z) {
//            if (!z) {
//                this.topic_ids = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case WORD_LEVEL_ID:
//                    if (obj == null) {
//                        unsetWord_level_id();
//                        return;
//                    } else {
//                        setWord_level_id(((Integer) obj).intValue());
//                        return;
//                    }
//                case TOPIC_IDS:
//                    if (obj == null) {
//                        unsetTopic_ids();
//                        return;
//                    } else {
//                        setTopic_ids((List) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case WORD_LEVEL_ID:
//                    return Integer.valueOf(getWord_level_id());
//                case TOPIC_IDS:
//                    return getTopic_ids();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case WORD_LEVEL_ID:
//                    return isSetWord_level_id();
//                case TOPIC_IDS:
//                    return isSetTopic_ids();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_word_topic_assets_v2_args)) {
//                return equals((get_word_topic_assets_v2_args) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_word_topic_assets_v2_args get_word_topic_assets_v2_args) {
//            if (get_word_topic_assets_v2_args == null || this.word_level_id != get_word_topic_assets_v2_args.word_level_id) {
//                return false;
//            }
//            boolean isSetTopic_ids = isSetTopic_ids();
//            boolean isSetTopic_ids2 = get_word_topic_assets_v2_args.isSetTopic_ids();
//            if ((isSetTopic_ids || isSetTopic_ids2) && (!isSetTopic_ids || !isSetTopic_ids2 || !this.topic_ids.equals(get_word_topic_assets_v2_args.topic_ids))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_word_topic_assets_v2_args get_word_topic_assets_v2_args) {
//            if (!getClass().equals(get_word_topic_assets_v2_args.getClass())) {
//                return getClass().getName().compareTo(get_word_topic_assets_v2_args.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetWord_level_id()).compareTo(Boolean.valueOf(get_word_topic_assets_v2_args.isSetWord_level_id()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetWord_level_id()) {
//                int a = C2121h.m5522a(this.word_level_id, get_word_topic_assets_v2_args.word_level_id);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetTopic_ids()).compareTo(Boolean.valueOf(get_word_topic_assets_v2_args.isSetTopic_ids()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetTopic_ids()) {
//                int a2 = C2121h.m5526a((List) this.topic_ids, (List) get_word_topic_assets_v2_args.topic_ids);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_word_topic_assets_v2_args(");
//            sb.append("word_level_id:");
//            sb.append(this.word_level_id);
//            sb.append(", ");
//            sb.append("topic_ids:");
//            if (this.topic_ids == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.topic_ids);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//            if (this.topic_ids == null) {
//                throw new C2101g("Required field 'topic_ids' was not present! Struct: " + toString());
//            }
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                this.__isset_bitfield = 0;
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class get_word_topic_assets_v2_result implements Serializable, Cloneable, Comparable<get_word_topic_assets_v2_result>, C2116f<get_word_topic_assets_v2_result, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("get_word_topic_assets_v2_result");
//        /* access modifiers changed from: private */
//        public static final C2097b SUCCESS_FIELD_DESC = new C2097b("success", 15, 0);
//        /* access modifiers changed from: private */
//        public static final C2097b SYS_EXCEPTION_FIELD_DESC = new C2097b("sysException", JceStruct.ZERO_TAG, 1);
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        public List<BBTopicAssetV2> success;
//        public BESystemException sysException;
//
//        public enum _Fields implements C2124m {
//            SUCCESS(0, "success"),
//            SYS_EXCEPTION(1, "sysException");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 0:
//                        return SUCCESS;
//                    case 1:
//                        return SYS_EXCEPTION;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class get_word_topic_assets_v2_resultStandardScheme extends C2110c<get_word_topic_assets_v2_result> {
//            private get_word_topic_assets_v2_resultStandardScheme() {
//            }
//
//            /* synthetic */ get_word_topic_assets_v2_resultStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, get_word_topic_assets_v2_result get_word_topic_assets_v2_result) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 0:
//                                if (g.f5835b != 15) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    C2098c i = fVar.mo18508i();
//                                    get_word_topic_assets_v2_result.success = new ArrayList(i.f5838b);
//                                    for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                        BBTopicAssetV2 bBTopicAssetV2 = new BBTopicAssetV2();
//                                        bBTopicAssetV2.read(fVar);
//                                        get_word_topic_assets_v2_result.success.add(bBTopicAssetV2);
//                                    }
//                                    get_word_topic_assets_v2_result.setSuccessIsSet(true);
//                                    break;
//                                }
//                            case 1:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    get_word_topic_assets_v2_result.sysException = new BESystemException();
//                                    get_word_topic_assets_v2_result.sysException.read(fVar);
//                                    get_word_topic_assets_v2_result.setSysExceptionIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        get_word_topic_assets_v2_result.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, get_word_topic_assets_v2_result get_word_topic_assets_v2_result) {
//                get_word_topic_assets_v2_result.validate();
//                get_word_topic_assets_v2_result.STRUCT_DESC;
//                fVar.mo18490a();
//                if (get_word_topic_assets_v2_result.success != null) {
//                    fVar.mo18496a(get_word_topic_assets_v2_result.SUCCESS_FIELD_DESC);
//                    fVar.mo18497a(new C2098c(JceStruct.ZERO_TAG, get_word_topic_assets_v2_result.success.size()));
//                    for (BBTopicAssetV2 write : get_word_topic_assets_v2_result.success) {
//                        write.write(fVar);
//                    }
//                }
//                if (get_word_topic_assets_v2_result.sysException != null) {
//                    fVar.mo18496a(get_word_topic_assets_v2_result.SYS_EXCEPTION_FIELD_DESC);
//                    get_word_topic_assets_v2_result.sysException.write(fVar);
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class get_word_topic_assets_v2_resultStandardSchemeFactory implements C2109b {
//            private get_word_topic_assets_v2_resultStandardSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_topic_assets_v2_resultStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_topic_assets_v2_resultStandardScheme getScheme() {
//                return new get_word_topic_assets_v2_resultStandardScheme(null);
//            }
//        }
//
//        class get_word_topic_assets_v2_resultTupleScheme extends C2111d<get_word_topic_assets_v2_result> {
//            private get_word_topic_assets_v2_resultTupleScheme() {
//            }
//
//            /* synthetic */ get_word_topic_assets_v2_resultTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, get_word_topic_assets_v2_result get_word_topic_assets_v2_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet bitSet = new BitSet();
//                if (get_word_topic_assets_v2_result.isSetSuccess()) {
//                    bitSet.set(0);
//                }
//                if (get_word_topic_assets_v2_result.isSetSysException()) {
//                    bitSet.set(1);
//                }
//                lVar.mo18527a(bitSet, 2);
//                if (get_word_topic_assets_v2_result.isSetSuccess()) {
//                    lVar.mo18493a(get_word_topic_assets_v2_result.success.size());
//                    for (BBTopicAssetV2 write : get_word_topic_assets_v2_result.success) {
//                        write.write(lVar);
//                    }
//                }
//                if (get_word_topic_assets_v2_result.isSetSysException()) {
//                    get_word_topic_assets_v2_result.sysException.write(lVar);
//                }
//            }
//
//            public void read(C2100f fVar, get_word_topic_assets_v2_result get_word_topic_assets_v2_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet b = lVar.mo18528b(2);
//                if (b.get(0)) {
//                    C2098c cVar = new C2098c(JceStruct.ZERO_TAG, lVar.mo18513n());
//                    get_word_topic_assets_v2_result.success = new ArrayList(cVar.f5838b);
//                    for (int i = 0; i < cVar.f5838b; i++) {
//                        BBTopicAssetV2 bBTopicAssetV2 = new BBTopicAssetV2();
//                        bBTopicAssetV2.read(lVar);
//                        get_word_topic_assets_v2_result.success.add(bBTopicAssetV2);
//                    }
//                    get_word_topic_assets_v2_result.setSuccessIsSet(true);
//                }
//                if (b.get(1)) {
//                    get_word_topic_assets_v2_result.sysException = new BESystemException();
//                    get_word_topic_assets_v2_result.sysException.read(lVar);
//                    get_word_topic_assets_v2_result.setSysExceptionIsSet(true);
//                }
//            }
//        }
//
//        class get_word_topic_assets_v2_resultTupleSchemeFactory implements C2109b {
//            private get_word_topic_assets_v2_resultTupleSchemeFactory() {
//            }
//
//            /* synthetic */ get_word_topic_assets_v2_resultTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public get_word_topic_assets_v2_resultTupleScheme getScheme() {
//                return new get_word_topic_assets_v2_resultTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new get_word_topic_assets_v2_resultStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new get_word_topic_assets_v2_resultTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.SUCCESS, new C2091a("success", 3, new C2093c(new C2095e(BBTopicAssetV2.class))));
//            enumMap.put(_Fields.SYS_EXCEPTION, new C2091a("sysException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(get_word_topic_assets_v2_result.class, metaDataMap);
//        }
//
//        public get_word_topic_assets_v2_result() {
//        }
//
//        public get_word_topic_assets_v2_result(List<BBTopicAssetV2> list, BESystemException bESystemException) {
//            this();
//            this.success = list;
//            this.sysException = bESystemException;
//        }
//
//        public get_word_topic_assets_v2_result(get_word_topic_assets_v2_result get_word_topic_assets_v2_result) {
//            if (get_word_topic_assets_v2_result.isSetSuccess()) {
//                ArrayList arrayList = new ArrayList(get_word_topic_assets_v2_result.success.size());
//                for (BBTopicAssetV2 bBTopicAssetV2 : get_word_topic_assets_v2_result.success) {
//                    arrayList.add(new BBTopicAssetV2(bBTopicAssetV2));
//                }
//                this.success = arrayList;
//            }
//            if (get_word_topic_assets_v2_result.isSetSysException()) {
//                this.sysException = new BESystemException(get_word_topic_assets_v2_result.sysException);
//            }
//        }
//
//        public get_word_topic_assets_v2_result deepCopy() {
//            return new get_word_topic_assets_v2_result(this);
//        }
//
//        public void clear() {
//            this.success = null;
//            this.sysException = null;
//        }
//
//        public int getSuccessSize() {
//            if (this.success == null) {
//                return 0;
//            }
//            return this.success.size();
//        }
//
//        public Iterator<BBTopicAssetV2> getSuccessIterator() {
//            if (this.success == null) {
//                return null;
//            }
//            return this.success.iterator();
//        }
//
//        public void addToSuccess(BBTopicAssetV2 bBTopicAssetV2) {
//            if (this.success == null) {
//                this.success = new ArrayList();
//            }
//            this.success.add(bBTopicAssetV2);
//        }
//
//        public List<BBTopicAssetV2> getSuccess() {
//            return this.success;
//        }
//
//        public get_word_topic_assets_v2_result setSuccess(List<BBTopicAssetV2> list) {
//            this.success = list;
//            return this;
//        }
//
//        public void unsetSuccess() {
//            this.success = null;
//        }
//
//        public boolean isSetSuccess() {
//            return this.success != null;
//        }
//
//        public void setSuccessIsSet(boolean z) {
//            if (!z) {
//                this.success = null;
//            }
//        }
//
//        public BESystemException getSysException() {
//            return this.sysException;
//        }
//
//        public get_word_topic_assets_v2_result setSysException(BESystemException bESystemException) {
//            this.sysException = bESystemException;
//            return this;
//        }
//
//        public void unsetSysException() {
//            this.sysException = null;
//        }
//
//        public boolean isSetSysException() {
//            return this.sysException != null;
//        }
//
//        public void setSysExceptionIsSet(boolean z) {
//            if (!z) {
//                this.sysException = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case SUCCESS:
//                    if (obj == null) {
//                        unsetSuccess();
//                        return;
//                    } else {
//                        setSuccess((List) obj);
//                        return;
//                    }
//                case SYS_EXCEPTION:
//                    if (obj == null) {
//                        unsetSysException();
//                        return;
//                    } else {
//                        setSysException((BESystemException) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case SUCCESS:
//                    return getSuccess();
//                case SYS_EXCEPTION:
//                    return getSysException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case SUCCESS:
//                    return isSetSuccess();
//                case SYS_EXCEPTION:
//                    return isSetSysException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof get_word_topic_assets_v2_result)) {
//                return equals((get_word_topic_assets_v2_result) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(get_word_topic_assets_v2_result get_word_topic_assets_v2_result) {
//            if (get_word_topic_assets_v2_result == null) {
//                return false;
//            }
//            boolean isSetSuccess = isSetSuccess();
//            boolean isSetSuccess2 = get_word_topic_assets_v2_result.isSetSuccess();
//            if ((isSetSuccess || isSetSuccess2) && (!isSetSuccess || !isSetSuccess2 || !this.success.equals(get_word_topic_assets_v2_result.success))) {
//                return false;
//            }
//            boolean isSetSysException = isSetSysException();
//            boolean isSetSysException2 = get_word_topic_assets_v2_result.isSetSysException();
//            if ((isSetSysException || isSetSysException2) && (!isSetSysException || !isSetSysException2 || !this.sysException.equals(get_word_topic_assets_v2_result.sysException))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(get_word_topic_assets_v2_result get_word_topic_assets_v2_result) {
//            if (!getClass().equals(get_word_topic_assets_v2_result.getClass())) {
//                return getClass().getName().compareTo(get_word_topic_assets_v2_result.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetSuccess()).compareTo(Boolean.valueOf(get_word_topic_assets_v2_result.isSetSuccess()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetSuccess()) {
//                int a = C2121h.m5526a((List) this.success, (List) get_word_topic_assets_v2_result.success);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetSysException()).compareTo(Boolean.valueOf(get_word_topic_assets_v2_result.isSetSysException()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetSysException()) {
//                int a2 = C2121h.m5524a((Comparable) this.sysException, (Comparable) get_word_topic_assets_v2_result.sysException);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("get_word_topic_assets_v2_result(");
//            sb.append("success:");
//            if (this.success == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.success);
//            }
//            sb.append(", ");
//            sb.append("sysException:");
//            if (this.sysException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.sysException);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class similar_words_vote_args implements Serializable, Cloneable, Comparable<similar_words_vote_args>, C2116f<similar_words_vote_args, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2097b BOOK_ID_FIELD_DESC = new C2097b("book_id", 8, 1);
//        /* access modifiers changed from: private */
//        public static final C2097b SIMILAR_WORDS_VOTES_FIELD_DESC = new C2097b("similar_words_votes", 15, 2);
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("similar_words_vote_args");
//        private static final int __BOOK_ID_ISSET_ID = 0;
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        private byte __isset_bitfield;
//        public int book_id;
//        public List<BBSimilarWordVote> similar_words_votes;
//
//        public enum _Fields implements C2124m {
//            BOOK_ID(1, "book_id"),
//            SIMILAR_WORDS_VOTES(2, "similar_words_votes");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 1:
//                        return BOOK_ID;
//                    case 2:
//                        return SIMILAR_WORDS_VOTES;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class similar_words_vote_argsStandardScheme extends C2110c<similar_words_vote_args> {
//            private similar_words_vote_argsStandardScheme() {
//            }
//
//            /* synthetic */ similar_words_vote_argsStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, similar_words_vote_args similar_words_vote_args) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 1:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    similar_words_vote_args.book_id = fVar.mo18513n();
//                                    similar_words_vote_args.setBook_idIsSet(true);
//                                    break;
//                                }
//                            case 2:
//                                if (g.f5835b != 15) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    C2098c i = fVar.mo18508i();
//                                    similar_words_vote_args.similar_words_votes = new ArrayList(i.f5838b);
//                                    for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                        BBSimilarWordVote bBSimilarWordVote = new BBSimilarWordVote();
//                                        bBSimilarWordVote.read(fVar);
//                                        similar_words_vote_args.similar_words_votes.add(bBSimilarWordVote);
//                                    }
//                                    similar_words_vote_args.setSimilar_words_votesIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        if (!similar_words_vote_args.isSetBook_id()) {
//                            throw new C2101g("Required field 'book_id' was not found in serialized data! Struct: " + toString());
//                        }
//                        similar_words_vote_args.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, similar_words_vote_args similar_words_vote_args) {
//                similar_words_vote_args.validate();
//                similar_words_vote_args.STRUCT_DESC;
//                fVar.mo18490a();
//                fVar.mo18496a(similar_words_vote_args.BOOK_ID_FIELD_DESC);
//                fVar.mo18493a(similar_words_vote_args.book_id);
//                if (similar_words_vote_args.similar_words_votes != null) {
//                    fVar.mo18496a(similar_words_vote_args.SIMILAR_WORDS_VOTES_FIELD_DESC);
//                    fVar.mo18497a(new C2098c(JceStruct.ZERO_TAG, similar_words_vote_args.similar_words_votes.size()));
//                    for (BBSimilarWordVote write : similar_words_vote_args.similar_words_votes) {
//                        write.write(fVar);
//                    }
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class similar_words_vote_argsStandardSchemeFactory implements C2109b {
//            private similar_words_vote_argsStandardSchemeFactory() {
//            }
//
//            /* synthetic */ similar_words_vote_argsStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public similar_words_vote_argsStandardScheme getScheme() {
//                return new similar_words_vote_argsStandardScheme(null);
//            }
//        }
//
//        class similar_words_vote_argsTupleScheme extends C2111d<similar_words_vote_args> {
//            private similar_words_vote_argsTupleScheme() {
//            }
//
//            /* synthetic */ similar_words_vote_argsTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, similar_words_vote_args similar_words_vote_args) {
//                C2106l lVar = (C2106l) fVar;
//                lVar.mo18493a(similar_words_vote_args.book_id);
//                lVar.mo18493a(similar_words_vote_args.similar_words_votes.size());
//                for (BBSimilarWordVote write : similar_words_vote_args.similar_words_votes) {
//                    write.write(lVar);
//                }
//            }
//
//            public void read(C2100f fVar, similar_words_vote_args similar_words_vote_args) {
//                C2106l lVar = (C2106l) fVar;
//                similar_words_vote_args.book_id = lVar.mo18513n();
//                similar_words_vote_args.setBook_idIsSet(true);
//                C2098c cVar = new C2098c(JceStruct.ZERO_TAG, lVar.mo18513n());
//                similar_words_vote_args.similar_words_votes = new ArrayList(cVar.f5838b);
//                for (int i = 0; i < cVar.f5838b; i++) {
//                    BBSimilarWordVote bBSimilarWordVote = new BBSimilarWordVote();
//                    bBSimilarWordVote.read(lVar);
//                    similar_words_vote_args.similar_words_votes.add(bBSimilarWordVote);
//                }
//                similar_words_vote_args.setSimilar_words_votesIsSet(true);
//            }
//        }
//
//        class similar_words_vote_argsTupleSchemeFactory implements C2109b {
//            private similar_words_vote_argsTupleSchemeFactory() {
//            }
//
//            /* synthetic */ similar_words_vote_argsTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public similar_words_vote_argsTupleScheme getScheme() {
//                return new similar_words_vote_argsTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new similar_words_vote_argsStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new similar_words_vote_argsTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.BOOK_ID, new C2091a("book_id", 1, new C2092b(8, 0)));
//            enumMap.put(_Fields.SIMILAR_WORDS_VOTES, new C2091a("similar_words_votes", 1, new C2093c(new C2095e(BBSimilarWordVote.class))));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(similar_words_vote_args.class, metaDataMap);
//        }
//
//        public similar_words_vote_args() {
//            this.__isset_bitfield = 0;
//        }
//
//        public similar_words_vote_args(int i, List<BBSimilarWordVote> list) {
//            this();
//            this.book_id = i;
//            setBook_idIsSet(true);
//            this.similar_words_votes = list;
//        }
//
//        public similar_words_vote_args(similar_words_vote_args similar_words_vote_args) {
//            this.__isset_bitfield = 0;
//            this.__isset_bitfield = similar_words_vote_args.__isset_bitfield;
//            this.book_id = similar_words_vote_args.book_id;
//            if (similar_words_vote_args.isSetSimilar_words_votes()) {
//                ArrayList arrayList = new ArrayList(similar_words_vote_args.similar_words_votes.size());
//                for (BBSimilarWordVote bBSimilarWordVote : similar_words_vote_args.similar_words_votes) {
//                    arrayList.add(new BBSimilarWordVote(bBSimilarWordVote));
//                }
//                this.similar_words_votes = arrayList;
//            }
//        }
//
//        public similar_words_vote_args deepCopy() {
//            return new similar_words_vote_args(this);
//        }
//
//        public void clear() {
//            setBook_idIsSet(false);
//            this.book_id = 0;
//            this.similar_words_votes = null;
//        }
//
//        public int getBook_id() {
//            return this.book_id;
//        }
//
//        public similar_words_vote_args setBook_id(int i) {
//            this.book_id = i;
//            setBook_idIsSet(true);
//            return this;
//        }
//
//        public void unsetBook_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//        }
//
//        public boolean isSetBook_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 0);
//        }
//
//        public void setBook_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//        }
//
//        public int getSimilar_words_votesSize() {
//            if (this.similar_words_votes == null) {
//                return 0;
//            }
//            return this.similar_words_votes.size();
//        }
//
//        public Iterator<BBSimilarWordVote> getSimilar_words_votesIterator() {
//            if (this.similar_words_votes == null) {
//                return null;
//            }
//            return this.similar_words_votes.iterator();
//        }
//
//        public void addToSimilar_words_votes(BBSimilarWordVote bBSimilarWordVote) {
//            if (this.similar_words_votes == null) {
//                this.similar_words_votes = new ArrayList();
//            }
//            this.similar_words_votes.add(bBSimilarWordVote);
//        }
//
//        public List<BBSimilarWordVote> getSimilar_words_votes() {
//            return this.similar_words_votes;
//        }
//
//        public similar_words_vote_args setSimilar_words_votes(List<BBSimilarWordVote> list) {
//            this.similar_words_votes = list;
//            return this;
//        }
//
//        public void unsetSimilar_words_votes() {
//            this.similar_words_votes = null;
//        }
//
//        public boolean isSetSimilar_words_votes() {
//            return this.similar_words_votes != null;
//        }
//
//        public void setSimilar_words_votesIsSet(boolean z) {
//            if (!z) {
//                this.similar_words_votes = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case BOOK_ID:
//                    if (obj == null) {
//                        unsetBook_id();
//                        return;
//                    } else {
//                        setBook_id(((Integer) obj).intValue());
//                        return;
//                    }
//                case SIMILAR_WORDS_VOTES:
//                    if (obj == null) {
//                        unsetSimilar_words_votes();
//                        return;
//                    } else {
//                        setSimilar_words_votes((List) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case BOOK_ID:
//                    return Integer.valueOf(getBook_id());
//                case SIMILAR_WORDS_VOTES:
//                    return getSimilar_words_votes();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case BOOK_ID:
//                    return isSetBook_id();
//                case SIMILAR_WORDS_VOTES:
//                    return isSetSimilar_words_votes();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof similar_words_vote_args)) {
//                return equals((similar_words_vote_args) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(similar_words_vote_args similar_words_vote_args) {
//            if (similar_words_vote_args == null || this.book_id != similar_words_vote_args.book_id) {
//                return false;
//            }
//            boolean isSetSimilar_words_votes = isSetSimilar_words_votes();
//            boolean isSetSimilar_words_votes2 = similar_words_vote_args.isSetSimilar_words_votes();
//            if ((isSetSimilar_words_votes || isSetSimilar_words_votes2) && (!isSetSimilar_words_votes || !isSetSimilar_words_votes2 || !this.similar_words_votes.equals(similar_words_vote_args.similar_words_votes))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(similar_words_vote_args similar_words_vote_args) {
//            if (!getClass().equals(similar_words_vote_args.getClass())) {
//                return getClass().getName().compareTo(similar_words_vote_args.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetBook_id()).compareTo(Boolean.valueOf(similar_words_vote_args.isSetBook_id()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetBook_id()) {
//                int a = C2121h.m5522a(this.book_id, similar_words_vote_args.book_id);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetSimilar_words_votes()).compareTo(Boolean.valueOf(similar_words_vote_args.isSetSimilar_words_votes()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetSimilar_words_votes()) {
//                int a2 = C2121h.m5526a((List) this.similar_words_votes, (List) similar_words_vote_args.similar_words_votes);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("similar_words_vote_args(");
//            sb.append("book_id:");
//            sb.append(this.book_id);
//            sb.append(", ");
//            sb.append("similar_words_votes:");
//            if (this.similar_words_votes == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.similar_words_votes);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//            if (this.similar_words_votes == null) {
//                throw new C2101g("Required field 'similar_words_votes' was not present! Struct: " + toString());
//            }
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                this.__isset_bitfield = 0;
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class similar_words_vote_result implements Serializable, Cloneable, Comparable<similar_words_vote_result>, C2116f<similar_words_vote_result, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("similar_words_vote_result");
//        /* access modifiers changed from: private */
//        public static final C2097b SUCCESS_FIELD_DESC = new C2097b("success", 8, 0);
//        /* access modifiers changed from: private */
//        public static final C2097b SYS_EXCEPTION_FIELD_DESC = new C2097b("sysException", JceStruct.ZERO_TAG, 1);
//        private static final int __SUCCESS_ISSET_ID = 0;
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        private byte __isset_bitfield;
//        public int success;
//        public BESystemException sysException;
//
//        public enum _Fields implements C2124m {
//            SUCCESS(0, "success"),
//            SYS_EXCEPTION(1, "sysException");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 0:
//                        return SUCCESS;
//                    case 1:
//                        return SYS_EXCEPTION;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class similar_words_vote_resultStandardScheme extends C2110c<similar_words_vote_result> {
//            private similar_words_vote_resultStandardScheme() {
//            }
//
//            /* synthetic */ similar_words_vote_resultStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, similar_words_vote_result similar_words_vote_result) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 0:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    similar_words_vote_result.success = fVar.mo18513n();
//                                    similar_words_vote_result.setSuccessIsSet(true);
//                                    break;
//                                }
//                            case 1:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    similar_words_vote_result.sysException = new BESystemException();
//                                    similar_words_vote_result.sysException.read(fVar);
//                                    similar_words_vote_result.setSysExceptionIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        similar_words_vote_result.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, similar_words_vote_result similar_words_vote_result) {
//                similar_words_vote_result.validate();
//                similar_words_vote_result.STRUCT_DESC;
//                fVar.mo18490a();
//                if (similar_words_vote_result.isSetSuccess()) {
//                    fVar.mo18496a(similar_words_vote_result.SUCCESS_FIELD_DESC);
//                    fVar.mo18493a(similar_words_vote_result.success);
//                }
//                if (similar_words_vote_result.sysException != null) {
//                    fVar.mo18496a(similar_words_vote_result.SYS_EXCEPTION_FIELD_DESC);
//                    similar_words_vote_result.sysException.write(fVar);
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class similar_words_vote_resultStandardSchemeFactory implements C2109b {
//            private similar_words_vote_resultStandardSchemeFactory() {
//            }
//
//            /* synthetic */ similar_words_vote_resultStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public similar_words_vote_resultStandardScheme getScheme() {
//                return new similar_words_vote_resultStandardScheme(null);
//            }
//        }
//
//        class similar_words_vote_resultTupleScheme extends C2111d<similar_words_vote_result> {
//            private similar_words_vote_resultTupleScheme() {
//            }
//
//            /* synthetic */ similar_words_vote_resultTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, similar_words_vote_result similar_words_vote_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet bitSet = new BitSet();
//                if (similar_words_vote_result.isSetSuccess()) {
//                    bitSet.set(0);
//                }
//                if (similar_words_vote_result.isSetSysException()) {
//                    bitSet.set(1);
//                }
//                lVar.mo18527a(bitSet, 2);
//                if (similar_words_vote_result.isSetSuccess()) {
//                    lVar.mo18493a(similar_words_vote_result.success);
//                }
//                if (similar_words_vote_result.isSetSysException()) {
//                    similar_words_vote_result.sysException.write(lVar);
//                }
//            }
//
//            public void read(C2100f fVar, similar_words_vote_result similar_words_vote_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet b = lVar.mo18528b(2);
//                if (b.get(0)) {
//                    similar_words_vote_result.success = lVar.mo18513n();
//                    similar_words_vote_result.setSuccessIsSet(true);
//                }
//                if (b.get(1)) {
//                    similar_words_vote_result.sysException = new BESystemException();
//                    similar_words_vote_result.sysException.read(lVar);
//                    similar_words_vote_result.setSysExceptionIsSet(true);
//                }
//            }
//        }
//
//        class similar_words_vote_resultTupleSchemeFactory implements C2109b {
//            private similar_words_vote_resultTupleSchemeFactory() {
//            }
//
//            /* synthetic */ similar_words_vote_resultTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public similar_words_vote_resultTupleScheme getScheme() {
//                return new similar_words_vote_resultTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new similar_words_vote_resultStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new similar_words_vote_resultTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.SUCCESS, new C2091a("success", 3, new C2092b(8, 0)));
//            enumMap.put(_Fields.SYS_EXCEPTION, new C2091a("sysException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(similar_words_vote_result.class, metaDataMap);
//        }
//
//        public similar_words_vote_result() {
//            this.__isset_bitfield = 0;
//        }
//
//        public similar_words_vote_result(int i, BESystemException bESystemException) {
//            this();
//            this.success = i;
//            setSuccessIsSet(true);
//            this.sysException = bESystemException;
//        }
//
//        public similar_words_vote_result(similar_words_vote_result similar_words_vote_result) {
//            this.__isset_bitfield = 0;
//            this.__isset_bitfield = similar_words_vote_result.__isset_bitfield;
//            this.success = similar_words_vote_result.success;
//            if (similar_words_vote_result.isSetSysException()) {
//                this.sysException = new BESystemException(similar_words_vote_result.sysException);
//            }
//        }
//
//        public similar_words_vote_result deepCopy() {
//            return new similar_words_vote_result(this);
//        }
//
//        public void clear() {
//            setSuccessIsSet(false);
//            this.success = 0;
//            this.sysException = null;
//        }
//
//        public int getSuccess() {
//            return this.success;
//        }
//
//        public similar_words_vote_result setSuccess(int i) {
//            this.success = i;
//            setSuccessIsSet(true);
//            return this;
//        }
//
//        public void unsetSuccess() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//        }
//
//        public boolean isSetSuccess() {
//            return C2090b.m5429a(this.__isset_bitfield, 0);
//        }
//
//        public void setSuccessIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//        }
//
//        public BESystemException getSysException() {
//            return this.sysException;
//        }
//
//        public similar_words_vote_result setSysException(BESystemException bESystemException) {
//            this.sysException = bESystemException;
//            return this;
//        }
//
//        public void unsetSysException() {
//            this.sysException = null;
//        }
//
//        public boolean isSetSysException() {
//            return this.sysException != null;
//        }
//
//        public void setSysExceptionIsSet(boolean z) {
//            if (!z) {
//                this.sysException = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case SUCCESS:
//                    if (obj == null) {
//                        unsetSuccess();
//                        return;
//                    } else {
//                        setSuccess(((Integer) obj).intValue());
//                        return;
//                    }
//                case SYS_EXCEPTION:
//                    if (obj == null) {
//                        unsetSysException();
//                        return;
//                    } else {
//                        setSysException((BESystemException) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case SUCCESS:
//                    return Integer.valueOf(getSuccess());
//                case SYS_EXCEPTION:
//                    return getSysException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case SUCCESS:
//                    return isSetSuccess();
//                case SYS_EXCEPTION:
//                    return isSetSysException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof similar_words_vote_result)) {
//                return equals((similar_words_vote_result) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(similar_words_vote_result similar_words_vote_result) {
//            if (similar_words_vote_result == null || this.success != similar_words_vote_result.success) {
//                return false;
//            }
//            boolean isSetSysException = isSetSysException();
//            boolean isSetSysException2 = similar_words_vote_result.isSetSysException();
//            if ((isSetSysException || isSetSysException2) && (!isSetSysException || !isSetSysException2 || !this.sysException.equals(similar_words_vote_result.sysException))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(similar_words_vote_result similar_words_vote_result) {
//            if (!getClass().equals(similar_words_vote_result.getClass())) {
//                return getClass().getName().compareTo(similar_words_vote_result.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetSuccess()).compareTo(Boolean.valueOf(similar_words_vote_result.isSetSuccess()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetSuccess()) {
//                int a = C2121h.m5522a(this.success, similar_words_vote_result.success);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetSysException()).compareTo(Boolean.valueOf(similar_words_vote_result.isSetSysException()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetSysException()) {
//                int a2 = C2121h.m5524a((Comparable) this.sysException, (Comparable) similar_words_vote_result.sysException);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("similar_words_vote_result(");
//            sb.append("success:");
//            sb.append(this.success);
//            sb.append(", ");
//            sb.append("sysException:");
//            if (this.sysException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.sysException);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                this.__isset_bitfield = 0;
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class update_online_topic_args implements Serializable, Cloneable, Comparable<update_online_topic_args>, C2116f<update_online_topic_args, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2097b SIGNED_KEY_FIELD_DESC = new C2097b("signed_key", JceStruct.STRUCT_END, 5);
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("update_online_topic_args");
//        /* access modifiers changed from: private */
//        public static final C2097b TAG_ID_FIELD_DESC = new C2097b("tag_id", 8, 3);
//        /* access modifiers changed from: private */
//        public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 1);
//        /* access modifiers changed from: private */
//        public static final C2097b VERSION_FIELD_DESC = new C2097b(BaicizhanCookieInflator.VERSION, 8, 4);
//        /* access modifiers changed from: private */
//        public static final C2097b WORD_LEVEL_ID_FIELD_DESC = new C2097b("word_level_id", 8, 2);
//        private static final int __TAG_ID_ISSET_ID = 2;
//        private static final int __TOPIC_ID_ISSET_ID = 0;
//        private static final int __VERSION_ISSET_ID = 3;
//        private static final int __WORD_LEVEL_ID_ISSET_ID = 1;
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        private byte __isset_bitfield;
//        public String signed_key;
//        public int tag_id;
//        public int topic_id;
//        public int version;
//        public int word_level_id;
//
//        public enum _Fields implements C2124m {
//            TOPIC_ID(1, "topic_id"),
//            WORD_LEVEL_ID(2, "word_level_id"),
//            TAG_ID(3, "tag_id"),
//            VERSION(4, BaicizhanCookieInflator.VERSION),
//            SIGNED_KEY(5, "signed_key");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 1:
//                        return TOPIC_ID;
//                    case 2:
//                        return WORD_LEVEL_ID;
//                    case 3:
//                        return TAG_ID;
//                    case 4:
//                        return VERSION;
//                    case 5:
//                        return SIGNED_KEY;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class update_online_topic_argsStandardScheme extends C2110c<update_online_topic_args> {
//            private update_online_topic_argsStandardScheme() {
//            }
//
//            /* synthetic */ update_online_topic_argsStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, update_online_topic_args update_online_topic_args) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 1:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    update_online_topic_args.topic_id = fVar.mo18513n();
//                                    update_online_topic_args.setTopic_idIsSet(true);
//                                    break;
//                                }
//                            case 2:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    update_online_topic_args.word_level_id = fVar.mo18513n();
//                                    update_online_topic_args.setWord_level_idIsSet(true);
//                                    break;
//                                }
//                            case 3:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    update_online_topic_args.tag_id = fVar.mo18513n();
//                                    update_online_topic_args.setTag_idIsSet(true);
//                                    break;
//                                }
//                            case 4:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    update_online_topic_args.version = fVar.mo18513n();
//                                    update_online_topic_args.setVersionIsSet(true);
//                                    break;
//                                }
//                            case 5:
//                                if (g.f5835b != 11) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    update_online_topic_args.signed_key = fVar.mo18516q();
//                                    update_online_topic_args.setSigned_keyIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        if (!update_online_topic_args.isSetTopic_id()) {
//                            throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                        } else if (!update_online_topic_args.isSetWord_level_id()) {
//                            throw new C2101g("Required field 'word_level_id' was not found in serialized data! Struct: " + toString());
//                        } else if (!update_online_topic_args.isSetTag_id()) {
//                            throw new C2101g("Required field 'tag_id' was not found in serialized data! Struct: " + toString());
//                        } else if (!update_online_topic_args.isSetVersion()) {
//                            throw new C2101g("Required field 'version' was not found in serialized data! Struct: " + toString());
//                        } else {
//                            update_online_topic_args.validate();
//                            return;
//                        }
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, update_online_topic_args update_online_topic_args) {
//                update_online_topic_args.validate();
//                update_online_topic_args.STRUCT_DESC;
//                fVar.mo18490a();
//                fVar.mo18496a(update_online_topic_args.TOPIC_ID_FIELD_DESC);
//                fVar.mo18493a(update_online_topic_args.topic_id);
//                fVar.mo18496a(update_online_topic_args.WORD_LEVEL_ID_FIELD_DESC);
//                fVar.mo18493a(update_online_topic_args.word_level_id);
//                fVar.mo18496a(update_online_topic_args.TAG_ID_FIELD_DESC);
//                fVar.mo18493a(update_online_topic_args.tag_id);
//                fVar.mo18496a(update_online_topic_args.VERSION_FIELD_DESC);
//                fVar.mo18493a(update_online_topic_args.version);
//                if (update_online_topic_args.signed_key != null) {
//                    fVar.mo18496a(update_online_topic_args.SIGNED_KEY_FIELD_DESC);
//                    fVar.mo18495a(update_online_topic_args.signed_key);
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class update_online_topic_argsStandardSchemeFactory implements C2109b {
//            private update_online_topic_argsStandardSchemeFactory() {
//            }
//
//            /* synthetic */ update_online_topic_argsStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public update_online_topic_argsStandardScheme getScheme() {
//                return new update_online_topic_argsStandardScheme(null);
//            }
//        }
//
//        class update_online_topic_argsTupleScheme extends C2111d<update_online_topic_args> {
//            private update_online_topic_argsTupleScheme() {
//            }
//
//            /* synthetic */ update_online_topic_argsTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, update_online_topic_args update_online_topic_args) {
//                C2106l lVar = (C2106l) fVar;
//                lVar.mo18493a(update_online_topic_args.topic_id);
//                lVar.mo18493a(update_online_topic_args.word_level_id);
//                lVar.mo18493a(update_online_topic_args.tag_id);
//                lVar.mo18493a(update_online_topic_args.version);
//                lVar.mo18495a(update_online_topic_args.signed_key);
//            }
//
//            public void read(C2100f fVar, update_online_topic_args update_online_topic_args) {
//                C2106l lVar = (C2106l) fVar;
//                update_online_topic_args.topic_id = lVar.mo18513n();
//                update_online_topic_args.setTopic_idIsSet(true);
//                update_online_topic_args.word_level_id = lVar.mo18513n();
//                update_online_topic_args.setWord_level_idIsSet(true);
//                update_online_topic_args.tag_id = lVar.mo18513n();
//                update_online_topic_args.setTag_idIsSet(true);
//                update_online_topic_args.version = lVar.mo18513n();
//                update_online_topic_args.setVersionIsSet(true);
//                update_online_topic_args.signed_key = lVar.mo18516q();
//                update_online_topic_args.setSigned_keyIsSet(true);
//            }
//        }
//
//        class update_online_topic_argsTupleSchemeFactory implements C2109b {
//            private update_online_topic_argsTupleSchemeFactory() {
//            }
//
//            /* synthetic */ update_online_topic_argsTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public update_online_topic_argsTupleScheme getScheme() {
//                return new update_online_topic_argsTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new update_online_topic_argsStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new update_online_topic_argsTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//            enumMap.put(_Fields.WORD_LEVEL_ID, new C2091a("word_level_id", 1, new C2092b(8, 0)));
//            enumMap.put(_Fields.TAG_ID, new C2091a("tag_id", 1, new C2092b(8, 0)));
//            enumMap.put(_Fields.VERSION, new C2091a(BaicizhanCookieInflator.VERSION, 1, new C2092b(8, 0)));
//            enumMap.put(_Fields.SIGNED_KEY, new C2091a("signed_key", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(update_online_topic_args.class, metaDataMap);
//        }
//
//        public update_online_topic_args() {
//            this.__isset_bitfield = 0;
//        }
//
//        public update_online_topic_args(int i, int i2, int i3, int i4, String str) {
//            this();
//            this.topic_id = i;
//            setTopic_idIsSet(true);
//            this.word_level_id = i2;
//            setWord_level_idIsSet(true);
//            this.tag_id = i3;
//            setTag_idIsSet(true);
//            this.version = i4;
//            setVersionIsSet(true);
//            this.signed_key = str;
//        }
//
//        public update_online_topic_args(update_online_topic_args update_online_topic_args) {
//            this.__isset_bitfield = 0;
//            this.__isset_bitfield = update_online_topic_args.__isset_bitfield;
//            this.topic_id = update_online_topic_args.topic_id;
//            this.word_level_id = update_online_topic_args.word_level_id;
//            this.tag_id = update_online_topic_args.tag_id;
//            this.version = update_online_topic_args.version;
//            if (update_online_topic_args.isSetSigned_key()) {
//                this.signed_key = update_online_topic_args.signed_key;
//            }
//        }
//
//        public update_online_topic_args deepCopy() {
//            return new update_online_topic_args(this);
//        }
//
//        public void clear() {
//            setTopic_idIsSet(false);
//            this.topic_id = 0;
//            setWord_level_idIsSet(false);
//            this.word_level_id = 0;
//            setTag_idIsSet(false);
//            this.tag_id = 0;
//            setVersionIsSet(false);
//            this.version = 0;
//            this.signed_key = null;
//        }
//
//        public int getTopic_id() {
//            return this.topic_id;
//        }
//
//        public update_online_topic_args setTopic_id(int i) {
//            this.topic_id = i;
//            setTopic_idIsSet(true);
//            return this;
//        }
//
//        public void unsetTopic_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//        }
//
//        public boolean isSetTopic_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 0);
//        }
//
//        public void setTopic_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//        }
//
//        public int getWord_level_id() {
//            return this.word_level_id;
//        }
//
//        public update_online_topic_args setWord_level_id(int i) {
//            this.word_level_id = i;
//            setWord_level_idIsSet(true);
//            return this;
//        }
//
//        public void unsetWord_level_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//        }
//
//        public boolean isSetWord_level_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 1);
//        }
//
//        public void setWord_level_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//        }
//
//        public int getTag_id() {
//            return this.tag_id;
//        }
//
//        public update_online_topic_args setTag_id(int i) {
//            this.tag_id = i;
//            setTag_idIsSet(true);
//            return this;
//        }
//
//        public void unsetTag_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//        }
//
//        public boolean isSetTag_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 2);
//        }
//
//        public void setTag_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
//        }
//
//        public int getVersion() {
//            return this.version;
//        }
//
//        public update_online_topic_args setVersion(int i) {
//            this.version = i;
//            setVersionIsSet(true);
//            return this;
//        }
//
//        public void unsetVersion() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -9);
//        }
//
//        public boolean isSetVersion() {
//            return C2090b.m5429a(this.__isset_bitfield, 3);
//        }
//
//        public void setVersionIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 3, z);
//        }
//
//        public String getSigned_key() {
//            return this.signed_key;
//        }
//
//        public update_online_topic_args setSigned_key(String str) {
//            this.signed_key = str;
//            return this;
//        }
//
//        public void unsetSigned_key() {
//            this.signed_key = null;
//        }
//
//        public boolean isSetSigned_key() {
//            return this.signed_key != null;
//        }
//
//        public void setSigned_keyIsSet(boolean z) {
//            if (!z) {
//                this.signed_key = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case TOPIC_ID:
//                    if (obj == null) {
//                        unsetTopic_id();
//                        return;
//                    } else {
//                        setTopic_id(((Integer) obj).intValue());
//                        return;
//                    }
//                case WORD_LEVEL_ID:
//                    if (obj == null) {
//                        unsetWord_level_id();
//                        return;
//                    } else {
//                        setWord_level_id(((Integer) obj).intValue());
//                        return;
//                    }
//                case TAG_ID:
//                    if (obj == null) {
//                        unsetTag_id();
//                        return;
//                    } else {
//                        setTag_id(((Integer) obj).intValue());
//                        return;
//                    }
//                case VERSION:
//                    if (obj == null) {
//                        unsetVersion();
//                        return;
//                    } else {
//                        setVersion(((Integer) obj).intValue());
//                        return;
//                    }
//                case SIGNED_KEY:
//                    if (obj == null) {
//                        unsetSigned_key();
//                        return;
//                    } else {
//                        setSigned_key((String) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case TOPIC_ID:
//                    return Integer.valueOf(getTopic_id());
//                case WORD_LEVEL_ID:
//                    return Integer.valueOf(getWord_level_id());
//                case TAG_ID:
//                    return Integer.valueOf(getTag_id());
//                case VERSION:
//                    return Integer.valueOf(getVersion());
//                case SIGNED_KEY:
//                    return getSigned_key();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case TOPIC_ID:
//                    return isSetTopic_id();
//                case WORD_LEVEL_ID:
//                    return isSetWord_level_id();
//                case TAG_ID:
//                    return isSetTag_id();
//                case VERSION:
//                    return isSetVersion();
//                case SIGNED_KEY:
//                    return isSetSigned_key();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof update_online_topic_args)) {
//                return equals((update_online_topic_args) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(update_online_topic_args update_online_topic_args) {
//            if (update_online_topic_args == null || this.topic_id != update_online_topic_args.topic_id || this.word_level_id != update_online_topic_args.word_level_id || this.tag_id != update_online_topic_args.tag_id || this.version != update_online_topic_args.version) {
//                return false;
//            }
//            boolean isSetSigned_key = isSetSigned_key();
//            boolean isSetSigned_key2 = update_online_topic_args.isSetSigned_key();
//            if ((isSetSigned_key || isSetSigned_key2) && (!isSetSigned_key || !isSetSigned_key2 || !this.signed_key.equals(update_online_topic_args.signed_key))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(update_online_topic_args update_online_topic_args) {
//            if (!getClass().equals(update_online_topic_args.getClass())) {
//                return getClass().getName().compareTo(update_online_topic_args.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(update_online_topic_args.isSetTopic_id()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetTopic_id()) {
//                int a = C2121h.m5522a(this.topic_id, update_online_topic_args.topic_id);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetWord_level_id()).compareTo(Boolean.valueOf(update_online_topic_args.isSetWord_level_id()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetWord_level_id()) {
//                int a2 = C2121h.m5522a(this.word_level_id, update_online_topic_args.word_level_id);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            int compareTo3 = Boolean.valueOf(isSetTag_id()).compareTo(Boolean.valueOf(update_online_topic_args.isSetTag_id()));
//            if (compareTo3 != 0) {
//                return compareTo3;
//            }
//            if (isSetTag_id()) {
//                int a3 = C2121h.m5522a(this.tag_id, update_online_topic_args.tag_id);
//                if (a3 != 0) {
//                    return a3;
//                }
//            }
//            int compareTo4 = Boolean.valueOf(isSetVersion()).compareTo(Boolean.valueOf(update_online_topic_args.isSetVersion()));
//            if (compareTo4 != 0) {
//                return compareTo4;
//            }
//            if (isSetVersion()) {
//                int a4 = C2121h.m5522a(this.version, update_online_topic_args.version);
//                if (a4 != 0) {
//                    return a4;
//                }
//            }
//            int compareTo5 = Boolean.valueOf(isSetSigned_key()).compareTo(Boolean.valueOf(update_online_topic_args.isSetSigned_key()));
//            if (compareTo5 != 0) {
//                return compareTo5;
//            }
//            if (isSetSigned_key()) {
//                int a5 = C2121h.m5525a(this.signed_key, update_online_topic_args.signed_key);
//                if (a5 != 0) {
//                    return a5;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("update_online_topic_args(");
//            sb.append("topic_id:");
//            sb.append(this.topic_id);
//            sb.append(", ");
//            sb.append("word_level_id:");
//            sb.append(this.word_level_id);
//            sb.append(", ");
//            sb.append("tag_id:");
//            sb.append(this.tag_id);
//            sb.append(", ");
//            sb.append("version:");
//            sb.append(this.version);
//            sb.append(", ");
//            sb.append("signed_key:");
//            if (this.signed_key == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.signed_key);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//            if (this.signed_key == null) {
//                throw new C2101g("Required field 'signed_key' was not present! Struct: " + toString());
//            }
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                this.__isset_bitfield = 0;
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class update_online_topic_result implements Serializable, Cloneable, Comparable<update_online_topic_result>, C2116f<update_online_topic_result, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2097b LOGIC_EXCEPTION_FIELD_DESC = new C2097b("logicException", JceStruct.ZERO_TAG, 2);
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("update_online_topic_result");
//        /* access modifiers changed from: private */
//        public static final C2097b SUCCESS_FIELD_DESC = new C2097b("success", 8, 0);
//        /* access modifiers changed from: private */
//        public static final C2097b SYS_EXCEPTION_FIELD_DESC = new C2097b("sysException", JceStruct.ZERO_TAG, 1);
//        private static final int __SUCCESS_ISSET_ID = 0;
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        private byte __isset_bitfield;
//        public BELogicException logicException;
//        public int success;
//        public BESystemException sysException;
//
//        public enum _Fields implements C2124m {
//            SUCCESS(0, "success"),
//            SYS_EXCEPTION(1, "sysException"),
//            LOGIC_EXCEPTION(2, "logicException");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 0:
//                        return SUCCESS;
//                    case 1:
//                        return SYS_EXCEPTION;
//                    case 2:
//                        return LOGIC_EXCEPTION;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class update_online_topic_resultStandardScheme extends C2110c<update_online_topic_result> {
//            private update_online_topic_resultStandardScheme() {
//            }
//
//            /* synthetic */ update_online_topic_resultStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, update_online_topic_result update_online_topic_result) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 0:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    update_online_topic_result.success = fVar.mo18513n();
//                                    update_online_topic_result.setSuccessIsSet(true);
//                                    break;
//                                }
//                            case 1:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    update_online_topic_result.sysException = new BESystemException();
//                                    update_online_topic_result.sysException.read(fVar);
//                                    update_online_topic_result.setSysExceptionIsSet(true);
//                                    break;
//                                }
//                            case 2:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    update_online_topic_result.logicException = new BELogicException();
//                                    update_online_topic_result.logicException.read(fVar);
//                                    update_online_topic_result.setLogicExceptionIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        update_online_topic_result.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, update_online_topic_result update_online_topic_result) {
//                update_online_topic_result.validate();
//                update_online_topic_result.STRUCT_DESC;
//                fVar.mo18490a();
//                if (update_online_topic_result.isSetSuccess()) {
//                    fVar.mo18496a(update_online_topic_result.SUCCESS_FIELD_DESC);
//                    fVar.mo18493a(update_online_topic_result.success);
//                }
//                if (update_online_topic_result.sysException != null) {
//                    fVar.mo18496a(update_online_topic_result.SYS_EXCEPTION_FIELD_DESC);
//                    update_online_topic_result.sysException.write(fVar);
//                }
//                if (update_online_topic_result.logicException != null) {
//                    fVar.mo18496a(update_online_topic_result.LOGIC_EXCEPTION_FIELD_DESC);
//                    update_online_topic_result.logicException.write(fVar);
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class update_online_topic_resultStandardSchemeFactory implements C2109b {
//            private update_online_topic_resultStandardSchemeFactory() {
//            }
//
//            /* synthetic */ update_online_topic_resultStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public update_online_topic_resultStandardScheme getScheme() {
//                return new update_online_topic_resultStandardScheme(null);
//            }
//        }
//
//        class update_online_topic_resultTupleScheme extends C2111d<update_online_topic_result> {
//            private update_online_topic_resultTupleScheme() {
//            }
//
//            /* synthetic */ update_online_topic_resultTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, update_online_topic_result update_online_topic_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet bitSet = new BitSet();
//                if (update_online_topic_result.isSetSuccess()) {
//                    bitSet.set(0);
//                }
//                if (update_online_topic_result.isSetSysException()) {
//                    bitSet.set(1);
//                }
//                if (update_online_topic_result.isSetLogicException()) {
//                    bitSet.set(2);
//                }
//                lVar.mo18527a(bitSet, 3);
//                if (update_online_topic_result.isSetSuccess()) {
//                    lVar.mo18493a(update_online_topic_result.success);
//                }
//                if (update_online_topic_result.isSetSysException()) {
//                    update_online_topic_result.sysException.write(lVar);
//                }
//                if (update_online_topic_result.isSetLogicException()) {
//                    update_online_topic_result.logicException.write(lVar);
//                }
//            }
//
//            public void read(C2100f fVar, update_online_topic_result update_online_topic_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet b = lVar.mo18528b(3);
//                if (b.get(0)) {
//                    update_online_topic_result.success = lVar.mo18513n();
//                    update_online_topic_result.setSuccessIsSet(true);
//                }
//                if (b.get(1)) {
//                    update_online_topic_result.sysException = new BESystemException();
//                    update_online_topic_result.sysException.read(lVar);
//                    update_online_topic_result.setSysExceptionIsSet(true);
//                }
//                if (b.get(2)) {
//                    update_online_topic_result.logicException = new BELogicException();
//                    update_online_topic_result.logicException.read(lVar);
//                    update_online_topic_result.setLogicExceptionIsSet(true);
//                }
//            }
//        }
//
//        class update_online_topic_resultTupleSchemeFactory implements C2109b {
//            private update_online_topic_resultTupleSchemeFactory() {
//            }
//
//            /* synthetic */ update_online_topic_resultTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public update_online_topic_resultTupleScheme getScheme() {
//                return new update_online_topic_resultTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new update_online_topic_resultStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new update_online_topic_resultTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.SUCCESS, new C2091a("success", 3, new C2092b(8, 0)));
//            enumMap.put(_Fields.SYS_EXCEPTION, new C2091a("sysException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            enumMap.put(_Fields.LOGIC_EXCEPTION, new C2091a("logicException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(update_online_topic_result.class, metaDataMap);
//        }
//
//        public update_online_topic_result() {
//            this.__isset_bitfield = 0;
//        }
//
//        public update_online_topic_result(int i, BESystemException bESystemException, BELogicException bELogicException) {
//            this();
//            this.success = i;
//            setSuccessIsSet(true);
//            this.sysException = bESystemException;
//            this.logicException = bELogicException;
//        }
//
//        public update_online_topic_result(update_online_topic_result update_online_topic_result) {
//            this.__isset_bitfield = 0;
//            this.__isset_bitfield = update_online_topic_result.__isset_bitfield;
//            this.success = update_online_topic_result.success;
//            if (update_online_topic_result.isSetSysException()) {
//                this.sysException = new BESystemException(update_online_topic_result.sysException);
//            }
//            if (update_online_topic_result.isSetLogicException()) {
//                this.logicException = new BELogicException(update_online_topic_result.logicException);
//            }
//        }
//
//        public update_online_topic_result deepCopy() {
//            return new update_online_topic_result(this);
//        }
//
//        public void clear() {
//            setSuccessIsSet(false);
//            this.success = 0;
//            this.sysException = null;
//            this.logicException = null;
//        }
//
//        public int getSuccess() {
//            return this.success;
//        }
//
//        public update_online_topic_result setSuccess(int i) {
//            this.success = i;
//            setSuccessIsSet(true);
//            return this;
//        }
//
//        public void unsetSuccess() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//        }
//
//        public boolean isSetSuccess() {
//            return C2090b.m5429a(this.__isset_bitfield, 0);
//        }
//
//        public void setSuccessIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//        }
//
//        public BESystemException getSysException() {
//            return this.sysException;
//        }
//
//        public update_online_topic_result setSysException(BESystemException bESystemException) {
//            this.sysException = bESystemException;
//            return this;
//        }
//
//        public void unsetSysException() {
//            this.sysException = null;
//        }
//
//        public boolean isSetSysException() {
//            return this.sysException != null;
//        }
//
//        public void setSysExceptionIsSet(boolean z) {
//            if (!z) {
//                this.sysException = null;
//            }
//        }
//
//        public BELogicException getLogicException() {
//            return this.logicException;
//        }
//
//        public update_online_topic_result setLogicException(BELogicException bELogicException) {
//            this.logicException = bELogicException;
//            return this;
//        }
//
//        public void unsetLogicException() {
//            this.logicException = null;
//        }
//
//        public boolean isSetLogicException() {
//            return this.logicException != null;
//        }
//
//        public void setLogicExceptionIsSet(boolean z) {
//            if (!z) {
//                this.logicException = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case SUCCESS:
//                    if (obj == null) {
//                        unsetSuccess();
//                        return;
//                    } else {
//                        setSuccess(((Integer) obj).intValue());
//                        return;
//                    }
//                case SYS_EXCEPTION:
//                    if (obj == null) {
//                        unsetSysException();
//                        return;
//                    } else {
//                        setSysException((BESystemException) obj);
//                        return;
//                    }
//                case LOGIC_EXCEPTION:
//                    if (obj == null) {
//                        unsetLogicException();
//                        return;
//                    } else {
//                        setLogicException((BELogicException) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case SUCCESS:
//                    return Integer.valueOf(getSuccess());
//                case SYS_EXCEPTION:
//                    return getSysException();
//                case LOGIC_EXCEPTION:
//                    return getLogicException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case SUCCESS:
//                    return isSetSuccess();
//                case SYS_EXCEPTION:
//                    return isSetSysException();
//                case LOGIC_EXCEPTION:
//                    return isSetLogicException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof update_online_topic_result)) {
//                return equals((update_online_topic_result) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(update_online_topic_result update_online_topic_result) {
//            if (update_online_topic_result == null || this.success != update_online_topic_result.success) {
//                return false;
//            }
//            boolean isSetSysException = isSetSysException();
//            boolean isSetSysException2 = update_online_topic_result.isSetSysException();
//            if ((isSetSysException || isSetSysException2) && (!isSetSysException || !isSetSysException2 || !this.sysException.equals(update_online_topic_result.sysException))) {
//                return false;
//            }
//            boolean isSetLogicException = isSetLogicException();
//            boolean isSetLogicException2 = update_online_topic_result.isSetLogicException();
//            if ((isSetLogicException || isSetLogicException2) && (!isSetLogicException || !isSetLogicException2 || !this.logicException.equals(update_online_topic_result.logicException))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(update_online_topic_result update_online_topic_result) {
//            if (!getClass().equals(update_online_topic_result.getClass())) {
//                return getClass().getName().compareTo(update_online_topic_result.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetSuccess()).compareTo(Boolean.valueOf(update_online_topic_result.isSetSuccess()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetSuccess()) {
//                int a = C2121h.m5522a(this.success, update_online_topic_result.success);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetSysException()).compareTo(Boolean.valueOf(update_online_topic_result.isSetSysException()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetSysException()) {
//                int a2 = C2121h.m5524a((Comparable) this.sysException, (Comparable) update_online_topic_result.sysException);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            int compareTo3 = Boolean.valueOf(isSetLogicException()).compareTo(Boolean.valueOf(update_online_topic_result.isSetLogicException()));
//            if (compareTo3 != 0) {
//                return compareTo3;
//            }
//            if (isSetLogicException()) {
//                int a3 = C2121h.m5524a((Comparable) this.logicException, (Comparable) update_online_topic_result.logicException);
//                if (a3 != 0) {
//                    return a3;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("update_online_topic_result(");
//            sb.append("success:");
//            sb.append(this.success);
//            sb.append(", ");
//            sb.append("sysException:");
//            if (this.sysException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.sysException);
//            }
//            sb.append(", ");
//            sb.append("logicException:");
//            if (this.logicException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.logicException);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                this.__isset_bitfield = 0;
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class word_media_by_topic_ids_args implements Serializable, Cloneable, Comparable<word_media_by_topic_ids_args>, C2116f<word_media_by_topic_ids_args, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("word_media_by_topic_ids_args");
//        /* access modifiers changed from: private */
//        public static final C2097b TOPIC_IDS_FIELD_DESC = new C2097b("topic_ids", 15, 1);
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        public List<Integer> topic_ids;
//
//        public enum _Fields implements C2124m {
//            TOPIC_IDS(1, "topic_ids");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 1:
//                        return TOPIC_IDS;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class word_media_by_topic_ids_argsStandardScheme extends C2110c<word_media_by_topic_ids_args> {
//            private word_media_by_topic_ids_argsStandardScheme() {
//            }
//
//            /* synthetic */ word_media_by_topic_ids_argsStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, word_media_by_topic_ids_args word_media_by_topic_ids_args) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 1:
//                                if (g.f5835b != 15) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    C2098c i = fVar.mo18508i();
//                                    word_media_by_topic_ids_args.topic_ids = new ArrayList(i.f5838b);
//                                    for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                        word_media_by_topic_ids_args.topic_ids.add(Integer.valueOf(fVar.mo18513n()));
//                                    }
//                                    word_media_by_topic_ids_args.setTopic_idsIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        word_media_by_topic_ids_args.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, word_media_by_topic_ids_args word_media_by_topic_ids_args) {
//                word_media_by_topic_ids_args.validate();
//                word_media_by_topic_ids_args.STRUCT_DESC;
//                fVar.mo18490a();
//                if (word_media_by_topic_ids_args.topic_ids != null) {
//                    fVar.mo18496a(word_media_by_topic_ids_args.TOPIC_IDS_FIELD_DESC);
//                    fVar.mo18497a(new C2098c(8, word_media_by_topic_ids_args.topic_ids.size()));
//                    for (Integer intValue : word_media_by_topic_ids_args.topic_ids) {
//                        fVar.mo18493a(intValue.intValue());
//                    }
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class word_media_by_topic_ids_argsStandardSchemeFactory implements C2109b {
//            private word_media_by_topic_ids_argsStandardSchemeFactory() {
//            }
//
//            /* synthetic */ word_media_by_topic_ids_argsStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public word_media_by_topic_ids_argsStandardScheme getScheme() {
//                return new word_media_by_topic_ids_argsStandardScheme(null);
//            }
//        }
//
//        class word_media_by_topic_ids_argsTupleScheme extends C2111d<word_media_by_topic_ids_args> {
//            private word_media_by_topic_ids_argsTupleScheme() {
//            }
//
//            /* synthetic */ word_media_by_topic_ids_argsTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, word_media_by_topic_ids_args word_media_by_topic_ids_args) {
//                C2106l lVar = (C2106l) fVar;
//                lVar.mo18493a(word_media_by_topic_ids_args.topic_ids.size());
//                for (Integer intValue : word_media_by_topic_ids_args.topic_ids) {
//                    lVar.mo18493a(intValue.intValue());
//                }
//            }
//
//            public void read(C2100f fVar, word_media_by_topic_ids_args word_media_by_topic_ids_args) {
//                C2106l lVar = (C2106l) fVar;
//                C2098c cVar = new C2098c(8, lVar.mo18513n());
//                word_media_by_topic_ids_args.topic_ids = new ArrayList(cVar.f5838b);
//                for (int i = 0; i < cVar.f5838b; i++) {
//                    word_media_by_topic_ids_args.topic_ids.add(Integer.valueOf(lVar.mo18513n()));
//                }
//                word_media_by_topic_ids_args.setTopic_idsIsSet(true);
//            }
//        }
//
//        class word_media_by_topic_ids_argsTupleSchemeFactory implements C2109b {
//            private word_media_by_topic_ids_argsTupleSchemeFactory() {
//            }
//
//            /* synthetic */ word_media_by_topic_ids_argsTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public word_media_by_topic_ids_argsTupleScheme getScheme() {
//                return new word_media_by_topic_ids_argsTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new word_media_by_topic_ids_argsStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new word_media_by_topic_ids_argsTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.TOPIC_IDS, new C2091a("topic_ids", 1, new C2093c(new C2092b(8, 0))));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(word_media_by_topic_ids_args.class, metaDataMap);
//        }
//
//        public word_media_by_topic_ids_args() {
//        }
//
//        public word_media_by_topic_ids_args(List<Integer> list) {
//            this();
//            this.topic_ids = list;
//        }
//
//        public word_media_by_topic_ids_args(word_media_by_topic_ids_args word_media_by_topic_ids_args) {
//            if (word_media_by_topic_ids_args.isSetTopic_ids()) {
//                this.topic_ids = new ArrayList(word_media_by_topic_ids_args.topic_ids);
//            }
//        }
//
//        public word_media_by_topic_ids_args deepCopy() {
//            return new word_media_by_topic_ids_args(this);
//        }
//
//        public void clear() {
//            this.topic_ids = null;
//        }
//
//        public int getTopic_idsSize() {
//            if (this.topic_ids == null) {
//                return 0;
//            }
//            return this.topic_ids.size();
//        }
//
//        public Iterator<Integer> getTopic_idsIterator() {
//            if (this.topic_ids == null) {
//                return null;
//            }
//            return this.topic_ids.iterator();
//        }
//
//        public void addToTopic_ids(int i) {
//            if (this.topic_ids == null) {
//                this.topic_ids = new ArrayList();
//            }
//            this.topic_ids.add(Integer.valueOf(i));
//        }
//
//        public List<Integer> getTopic_ids() {
//            return this.topic_ids;
//        }
//
//        public word_media_by_topic_ids_args setTopic_ids(List<Integer> list) {
//            this.topic_ids = list;
//            return this;
//        }
//
//        public void unsetTopic_ids() {
//            this.topic_ids = null;
//        }
//
//        public boolean isSetTopic_ids() {
//            return this.topic_ids != null;
//        }
//
//        public void setTopic_idsIsSet(boolean z) {
//            if (!z) {
//                this.topic_ids = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case TOPIC_IDS:
//                    if (obj == null) {
//                        unsetTopic_ids();
//                        return;
//                    } else {
//                        setTopic_ids((List) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case TOPIC_IDS:
//                    return getTopic_ids();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case TOPIC_IDS:
//                    return isSetTopic_ids();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof word_media_by_topic_ids_args)) {
//                return equals((word_media_by_topic_ids_args) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(word_media_by_topic_ids_args word_media_by_topic_ids_args) {
//            if (word_media_by_topic_ids_args == null) {
//                return false;
//            }
//            boolean isSetTopic_ids = isSetTopic_ids();
//            boolean isSetTopic_ids2 = word_media_by_topic_ids_args.isSetTopic_ids();
//            if ((isSetTopic_ids || isSetTopic_ids2) && (!isSetTopic_ids || !isSetTopic_ids2 || !this.topic_ids.equals(word_media_by_topic_ids_args.topic_ids))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(word_media_by_topic_ids_args word_media_by_topic_ids_args) {
//            if (!getClass().equals(word_media_by_topic_ids_args.getClass())) {
//                return getClass().getName().compareTo(word_media_by_topic_ids_args.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetTopic_ids()).compareTo(Boolean.valueOf(word_media_by_topic_ids_args.isSetTopic_ids()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetTopic_ids()) {
//                int a = C2121h.m5526a((List) this.topic_ids, (List) word_media_by_topic_ids_args.topic_ids);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("word_media_by_topic_ids_args(");
//            sb.append("topic_ids:");
//            if (this.topic_ids == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.topic_ids);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//            if (this.topic_ids == null) {
//                throw new C2101g("Required field 'topic_ids' was not present! Struct: " + toString());
//            }
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class word_media_by_topic_ids_result implements Serializable, Cloneable, Comparable<word_media_by_topic_ids_result>, C2116f<word_media_by_topic_ids_result, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("word_media_by_topic_ids_result");
//        /* access modifiers changed from: private */
//        public static final C2097b SUCCESS_FIELD_DESC = new C2097b("success", 15, 0);
//        /* access modifiers changed from: private */
//        public static final C2097b SYS_EXCEPTION_FIELD_DESC = new C2097b("sysException", JceStruct.ZERO_TAG, 1);
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        public List<BBWordMedia> success;
//        public BESystemException sysException;
//
//        public enum _Fields implements C2124m {
//            SUCCESS(0, "success"),
//            SYS_EXCEPTION(1, "sysException");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 0:
//                        return SUCCESS;
//                    case 1:
//                        return SYS_EXCEPTION;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class word_media_by_topic_ids_resultStandardScheme extends C2110c<word_media_by_topic_ids_result> {
//            private word_media_by_topic_ids_resultStandardScheme() {
//            }
//
//            /* synthetic */ word_media_by_topic_ids_resultStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, word_media_by_topic_ids_result word_media_by_topic_ids_result) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 0:
//                                if (g.f5835b != 15) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    C2098c i = fVar.mo18508i();
//                                    word_media_by_topic_ids_result.success = new ArrayList(i.f5838b);
//                                    for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                        BBWordMedia bBWordMedia = new BBWordMedia();
//                                        bBWordMedia.read(fVar);
//                                        word_media_by_topic_ids_result.success.add(bBWordMedia);
//                                    }
//                                    word_media_by_topic_ids_result.setSuccessIsSet(true);
//                                    break;
//                                }
//                            case 1:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    word_media_by_topic_ids_result.sysException = new BESystemException();
//                                    word_media_by_topic_ids_result.sysException.read(fVar);
//                                    word_media_by_topic_ids_result.setSysExceptionIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        word_media_by_topic_ids_result.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, word_media_by_topic_ids_result word_media_by_topic_ids_result) {
//                word_media_by_topic_ids_result.validate();
//                word_media_by_topic_ids_result.STRUCT_DESC;
//                fVar.mo18490a();
//                if (word_media_by_topic_ids_result.success != null) {
//                    fVar.mo18496a(word_media_by_topic_ids_result.SUCCESS_FIELD_DESC);
//                    fVar.mo18497a(new C2098c(JceStruct.ZERO_TAG, word_media_by_topic_ids_result.success.size()));
//                    for (BBWordMedia write : word_media_by_topic_ids_result.success) {
//                        write.write(fVar);
//                    }
//                }
//                if (word_media_by_topic_ids_result.sysException != null) {
//                    fVar.mo18496a(word_media_by_topic_ids_result.SYS_EXCEPTION_FIELD_DESC);
//                    word_media_by_topic_ids_result.sysException.write(fVar);
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class word_media_by_topic_ids_resultStandardSchemeFactory implements C2109b {
//            private word_media_by_topic_ids_resultStandardSchemeFactory() {
//            }
//
//            /* synthetic */ word_media_by_topic_ids_resultStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public word_media_by_topic_ids_resultStandardScheme getScheme() {
//                return new word_media_by_topic_ids_resultStandardScheme(null);
//            }
//        }
//
//        class word_media_by_topic_ids_resultTupleScheme extends C2111d<word_media_by_topic_ids_result> {
//            private word_media_by_topic_ids_resultTupleScheme() {
//            }
//
//            /* synthetic */ word_media_by_topic_ids_resultTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, word_media_by_topic_ids_result word_media_by_topic_ids_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet bitSet = new BitSet();
//                if (word_media_by_topic_ids_result.isSetSuccess()) {
//                    bitSet.set(0);
//                }
//                if (word_media_by_topic_ids_result.isSetSysException()) {
//                    bitSet.set(1);
//                }
//                lVar.mo18527a(bitSet, 2);
//                if (word_media_by_topic_ids_result.isSetSuccess()) {
//                    lVar.mo18493a(word_media_by_topic_ids_result.success.size());
//                    for (BBWordMedia write : word_media_by_topic_ids_result.success) {
//                        write.write(lVar);
//                    }
//                }
//                if (word_media_by_topic_ids_result.isSetSysException()) {
//                    word_media_by_topic_ids_result.sysException.write(lVar);
//                }
//            }
//
//            public void read(C2100f fVar, word_media_by_topic_ids_result word_media_by_topic_ids_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet b = lVar.mo18528b(2);
//                if (b.get(0)) {
//                    C2098c cVar = new C2098c(JceStruct.ZERO_TAG, lVar.mo18513n());
//                    word_media_by_topic_ids_result.success = new ArrayList(cVar.f5838b);
//                    for (int i = 0; i < cVar.f5838b; i++) {
//                        BBWordMedia bBWordMedia = new BBWordMedia();
//                        bBWordMedia.read(lVar);
//                        word_media_by_topic_ids_result.success.add(bBWordMedia);
//                    }
//                    word_media_by_topic_ids_result.setSuccessIsSet(true);
//                }
//                if (b.get(1)) {
//                    word_media_by_topic_ids_result.sysException = new BESystemException();
//                    word_media_by_topic_ids_result.sysException.read(lVar);
//                    word_media_by_topic_ids_result.setSysExceptionIsSet(true);
//                }
//            }
//        }
//
//        class word_media_by_topic_ids_resultTupleSchemeFactory implements C2109b {
//            private word_media_by_topic_ids_resultTupleSchemeFactory() {
//            }
//
//            /* synthetic */ word_media_by_topic_ids_resultTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public word_media_by_topic_ids_resultTupleScheme getScheme() {
//                return new word_media_by_topic_ids_resultTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new word_media_by_topic_ids_resultStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new word_media_by_topic_ids_resultTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.SUCCESS, new C2091a("success", 3, new C2093c(new C2095e(BBWordMedia.class))));
//            enumMap.put(_Fields.SYS_EXCEPTION, new C2091a("sysException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(word_media_by_topic_ids_result.class, metaDataMap);
//        }
//
//        public word_media_by_topic_ids_result() {
//        }
//
//        public word_media_by_topic_ids_result(List<BBWordMedia> list, BESystemException bESystemException) {
//            this();
//            this.success = list;
//            this.sysException = bESystemException;
//        }
//
//        public word_media_by_topic_ids_result(word_media_by_topic_ids_result word_media_by_topic_ids_result) {
//            if (word_media_by_topic_ids_result.isSetSuccess()) {
//                ArrayList arrayList = new ArrayList(word_media_by_topic_ids_result.success.size());
//                for (BBWordMedia bBWordMedia : word_media_by_topic_ids_result.success) {
//                    arrayList.add(new BBWordMedia(bBWordMedia));
//                }
//                this.success = arrayList;
//            }
//            if (word_media_by_topic_ids_result.isSetSysException()) {
//                this.sysException = new BESystemException(word_media_by_topic_ids_result.sysException);
//            }
//        }
//
//        public word_media_by_topic_ids_result deepCopy() {
//            return new word_media_by_topic_ids_result(this);
//        }
//
//        public void clear() {
//            this.success = null;
//            this.sysException = null;
//        }
//
//        public int getSuccessSize() {
//            if (this.success == null) {
//                return 0;
//            }
//            return this.success.size();
//        }
//
//        public Iterator<BBWordMedia> getSuccessIterator() {
//            if (this.success == null) {
//                return null;
//            }
//            return this.success.iterator();
//        }
//
//        public void addToSuccess(BBWordMedia bBWordMedia) {
//            if (this.success == null) {
//                this.success = new ArrayList();
//            }
//            this.success.add(bBWordMedia);
//        }
//
//        public List<BBWordMedia> getSuccess() {
//            return this.success;
//        }
//
//        public word_media_by_topic_ids_result setSuccess(List<BBWordMedia> list) {
//            this.success = list;
//            return this;
//        }
//
//        public void unsetSuccess() {
//            this.success = null;
//        }
//
//        public boolean isSetSuccess() {
//            return this.success != null;
//        }
//
//        public void setSuccessIsSet(boolean z) {
//            if (!z) {
//                this.success = null;
//            }
//        }
//
//        public BESystemException getSysException() {
//            return this.sysException;
//        }
//
//        public word_media_by_topic_ids_result setSysException(BESystemException bESystemException) {
//            this.sysException = bESystemException;
//            return this;
//        }
//
//        public void unsetSysException() {
//            this.sysException = null;
//        }
//
//        public boolean isSetSysException() {
//            return this.sysException != null;
//        }
//
//        public void setSysExceptionIsSet(boolean z) {
//            if (!z) {
//                this.sysException = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case SUCCESS:
//                    if (obj == null) {
//                        unsetSuccess();
//                        return;
//                    } else {
//                        setSuccess((List) obj);
//                        return;
//                    }
//                case SYS_EXCEPTION:
//                    if (obj == null) {
//                        unsetSysException();
//                        return;
//                    } else {
//                        setSysException((BESystemException) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case SUCCESS:
//                    return getSuccess();
//                case SYS_EXCEPTION:
//                    return getSysException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case SUCCESS:
//                    return isSetSuccess();
//                case SYS_EXCEPTION:
//                    return isSetSysException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof word_media_by_topic_ids_result)) {
//                return equals((word_media_by_topic_ids_result) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(word_media_by_topic_ids_result word_media_by_topic_ids_result) {
//            if (word_media_by_topic_ids_result == null) {
//                return false;
//            }
//            boolean isSetSuccess = isSetSuccess();
//            boolean isSetSuccess2 = word_media_by_topic_ids_result.isSetSuccess();
//            if ((isSetSuccess || isSetSuccess2) && (!isSetSuccess || !isSetSuccess2 || !this.success.equals(word_media_by_topic_ids_result.success))) {
//                return false;
//            }
//            boolean isSetSysException = isSetSysException();
//            boolean isSetSysException2 = word_media_by_topic_ids_result.isSetSysException();
//            if ((isSetSysException || isSetSysException2) && (!isSetSysException || !isSetSysException2 || !this.sysException.equals(word_media_by_topic_ids_result.sysException))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(word_media_by_topic_ids_result word_media_by_topic_ids_result) {
//            if (!getClass().equals(word_media_by_topic_ids_result.getClass())) {
//                return getClass().getName().compareTo(word_media_by_topic_ids_result.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetSuccess()).compareTo(Boolean.valueOf(word_media_by_topic_ids_result.isSetSuccess()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetSuccess()) {
//                int a = C2121h.m5526a((List) this.success, (List) word_media_by_topic_ids_result.success);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetSysException()).compareTo(Boolean.valueOf(word_media_by_topic_ids_result.isSetSysException()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetSysException()) {
//                int a2 = C2121h.m5524a((Comparable) this.sysException, (Comparable) word_media_by_topic_ids_result.sysException);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("word_media_by_topic_ids_result(");
//            sb.append("success:");
//            if (this.success == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.success);
//            }
//            sb.append(", ");
//            sb.append("sysException:");
//            if (this.sysException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.sysException);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class word_media_by_topic_ids_v2_args implements Serializable, Cloneable, Comparable<word_media_by_topic_ids_v2_args>, C2116f<word_media_by_topic_ids_v2_args, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("word_media_by_topic_ids_v2_args");
//        /* access modifiers changed from: private */
//        public static final C2097b TOPIC_IDS_FIELD_DESC = new C2097b("topic_ids", 15, 1);
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        public List<Integer> topic_ids;
//
//        public enum _Fields implements C2124m {
//            TOPIC_IDS(1, "topic_ids");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 1:
//                        return TOPIC_IDS;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class word_media_by_topic_ids_v2_argsStandardScheme extends C2110c<word_media_by_topic_ids_v2_args> {
//            private word_media_by_topic_ids_v2_argsStandardScheme() {
//            }
//
//            /* synthetic */ word_media_by_topic_ids_v2_argsStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, word_media_by_topic_ids_v2_args word_media_by_topic_ids_v2_args) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 1:
//                                if (g.f5835b != 15) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    C2098c i = fVar.mo18508i();
//                                    word_media_by_topic_ids_v2_args.topic_ids = new ArrayList(i.f5838b);
//                                    for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                        word_media_by_topic_ids_v2_args.topic_ids.add(Integer.valueOf(fVar.mo18513n()));
//                                    }
//                                    word_media_by_topic_ids_v2_args.setTopic_idsIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        word_media_by_topic_ids_v2_args.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, word_media_by_topic_ids_v2_args word_media_by_topic_ids_v2_args) {
//                word_media_by_topic_ids_v2_args.validate();
//                word_media_by_topic_ids_v2_args.STRUCT_DESC;
//                fVar.mo18490a();
//                if (word_media_by_topic_ids_v2_args.topic_ids != null) {
//                    fVar.mo18496a(word_media_by_topic_ids_v2_args.TOPIC_IDS_FIELD_DESC);
//                    fVar.mo18497a(new C2098c(8, word_media_by_topic_ids_v2_args.topic_ids.size()));
//                    for (Integer intValue : word_media_by_topic_ids_v2_args.topic_ids) {
//                        fVar.mo18493a(intValue.intValue());
//                    }
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class word_media_by_topic_ids_v2_argsStandardSchemeFactory implements C2109b {
//            private word_media_by_topic_ids_v2_argsStandardSchemeFactory() {
//            }
//
//            /* synthetic */ word_media_by_topic_ids_v2_argsStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public word_media_by_topic_ids_v2_argsStandardScheme getScheme() {
//                return new word_media_by_topic_ids_v2_argsStandardScheme(null);
//            }
//        }
//
//        class word_media_by_topic_ids_v2_argsTupleScheme extends C2111d<word_media_by_topic_ids_v2_args> {
//            private word_media_by_topic_ids_v2_argsTupleScheme() {
//            }
//
//            /* synthetic */ word_media_by_topic_ids_v2_argsTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, word_media_by_topic_ids_v2_args word_media_by_topic_ids_v2_args) {
//                C2106l lVar = (C2106l) fVar;
//                lVar.mo18493a(word_media_by_topic_ids_v2_args.topic_ids.size());
//                for (Integer intValue : word_media_by_topic_ids_v2_args.topic_ids) {
//                    lVar.mo18493a(intValue.intValue());
//                }
//            }
//
//            public void read(C2100f fVar, word_media_by_topic_ids_v2_args word_media_by_topic_ids_v2_args) {
//                C2106l lVar = (C2106l) fVar;
//                C2098c cVar = new C2098c(8, lVar.mo18513n());
//                word_media_by_topic_ids_v2_args.topic_ids = new ArrayList(cVar.f5838b);
//                for (int i = 0; i < cVar.f5838b; i++) {
//                    word_media_by_topic_ids_v2_args.topic_ids.add(Integer.valueOf(lVar.mo18513n()));
//                }
//                word_media_by_topic_ids_v2_args.setTopic_idsIsSet(true);
//            }
//        }
//
//        class word_media_by_topic_ids_v2_argsTupleSchemeFactory implements C2109b {
//            private word_media_by_topic_ids_v2_argsTupleSchemeFactory() {
//            }
//
//            /* synthetic */ word_media_by_topic_ids_v2_argsTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public word_media_by_topic_ids_v2_argsTupleScheme getScheme() {
//                return new word_media_by_topic_ids_v2_argsTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new word_media_by_topic_ids_v2_argsStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new word_media_by_topic_ids_v2_argsTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.TOPIC_IDS, new C2091a("topic_ids", 1, new C2093c(new C2092b(8, 0))));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(word_media_by_topic_ids_v2_args.class, metaDataMap);
//        }
//
//        public word_media_by_topic_ids_v2_args() {
//        }
//
//        public word_media_by_topic_ids_v2_args(List<Integer> list) {
//            this();
//            this.topic_ids = list;
//        }
//
//        public word_media_by_topic_ids_v2_args(word_media_by_topic_ids_v2_args word_media_by_topic_ids_v2_args) {
//            if (word_media_by_topic_ids_v2_args.isSetTopic_ids()) {
//                this.topic_ids = new ArrayList(word_media_by_topic_ids_v2_args.topic_ids);
//            }
//        }
//
//        public word_media_by_topic_ids_v2_args deepCopy() {
//            return new word_media_by_topic_ids_v2_args(this);
//        }
//
//        public void clear() {
//            this.topic_ids = null;
//        }
//
//        public int getTopic_idsSize() {
//            if (this.topic_ids == null) {
//                return 0;
//            }
//            return this.topic_ids.size();
//        }
//
//        public Iterator<Integer> getTopic_idsIterator() {
//            if (this.topic_ids == null) {
//                return null;
//            }
//            return this.topic_ids.iterator();
//        }
//
//        public void addToTopic_ids(int i) {
//            if (this.topic_ids == null) {
//                this.topic_ids = new ArrayList();
//            }
//            this.topic_ids.add(Integer.valueOf(i));
//        }
//
//        public List<Integer> getTopic_ids() {
//            return this.topic_ids;
//        }
//
//        public word_media_by_topic_ids_v2_args setTopic_ids(List<Integer> list) {
//            this.topic_ids = list;
//            return this;
//        }
//
//        public void unsetTopic_ids() {
//            this.topic_ids = null;
//        }
//
//        public boolean isSetTopic_ids() {
//            return this.topic_ids != null;
//        }
//
//        public void setTopic_idsIsSet(boolean z) {
//            if (!z) {
//                this.topic_ids = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case TOPIC_IDS:
//                    if (obj == null) {
//                        unsetTopic_ids();
//                        return;
//                    } else {
//                        setTopic_ids((List) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case TOPIC_IDS:
//                    return getTopic_ids();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case TOPIC_IDS:
//                    return isSetTopic_ids();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof word_media_by_topic_ids_v2_args)) {
//                return equals((word_media_by_topic_ids_v2_args) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(word_media_by_topic_ids_v2_args word_media_by_topic_ids_v2_args) {
//            if (word_media_by_topic_ids_v2_args == null) {
//                return false;
//            }
//            boolean isSetTopic_ids = isSetTopic_ids();
//            boolean isSetTopic_ids2 = word_media_by_topic_ids_v2_args.isSetTopic_ids();
//            if ((isSetTopic_ids || isSetTopic_ids2) && (!isSetTopic_ids || !isSetTopic_ids2 || !this.topic_ids.equals(word_media_by_topic_ids_v2_args.topic_ids))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(word_media_by_topic_ids_v2_args word_media_by_topic_ids_v2_args) {
//            if (!getClass().equals(word_media_by_topic_ids_v2_args.getClass())) {
//                return getClass().getName().compareTo(word_media_by_topic_ids_v2_args.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetTopic_ids()).compareTo(Boolean.valueOf(word_media_by_topic_ids_v2_args.isSetTopic_ids()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetTopic_ids()) {
//                int a = C2121h.m5526a((List) this.topic_ids, (List) word_media_by_topic_ids_v2_args.topic_ids);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("word_media_by_topic_ids_v2_args(");
//            sb.append("topic_ids:");
//            if (this.topic_ids == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.topic_ids);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//            if (this.topic_ids == null) {
//                throw new C2101g("Required field 'topic_ids' was not present! Struct: " + toString());
//            }
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class word_media_by_topic_ids_v2_result implements Serializable, Cloneable, Comparable<word_media_by_topic_ids_v2_result>, C2116f<word_media_by_topic_ids_v2_result, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("word_media_by_topic_ids_v2_result");
//        /* access modifiers changed from: private */
//        public static final C2097b SUCCESS_FIELD_DESC = new C2097b("success", 15, 0);
//        /* access modifiers changed from: private */
//        public static final C2097b SYS_EXCEPTION_FIELD_DESC = new C2097b("sysException", JceStruct.ZERO_TAG, 1);
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        public List<BBWordMediaV2> success;
//        public BESystemException sysException;
//
//        public enum _Fields implements C2124m {
//            SUCCESS(0, "success"),
//            SYS_EXCEPTION(1, "sysException");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 0:
//                        return SUCCESS;
//                    case 1:
//                        return SYS_EXCEPTION;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class word_media_by_topic_ids_v2_resultStandardScheme extends C2110c<word_media_by_topic_ids_v2_result> {
//            private word_media_by_topic_ids_v2_resultStandardScheme() {
//            }
//
//            /* synthetic */ word_media_by_topic_ids_v2_resultStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, word_media_by_topic_ids_v2_result word_media_by_topic_ids_v2_result) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 0:
//                                if (g.f5835b != 15) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    C2098c i = fVar.mo18508i();
//                                    word_media_by_topic_ids_v2_result.success = new ArrayList(i.f5838b);
//                                    for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                        BBWordMediaV2 bBWordMediaV2 = new BBWordMediaV2();
//                                        bBWordMediaV2.read(fVar);
//                                        word_media_by_topic_ids_v2_result.success.add(bBWordMediaV2);
//                                    }
//                                    word_media_by_topic_ids_v2_result.setSuccessIsSet(true);
//                                    break;
//                                }
//                            case 1:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    word_media_by_topic_ids_v2_result.sysException = new BESystemException();
//                                    word_media_by_topic_ids_v2_result.sysException.read(fVar);
//                                    word_media_by_topic_ids_v2_result.setSysExceptionIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        word_media_by_topic_ids_v2_result.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, word_media_by_topic_ids_v2_result word_media_by_topic_ids_v2_result) {
//                word_media_by_topic_ids_v2_result.validate();
//                word_media_by_topic_ids_v2_result.STRUCT_DESC;
//                fVar.mo18490a();
//                if (word_media_by_topic_ids_v2_result.success != null) {
//                    fVar.mo18496a(word_media_by_topic_ids_v2_result.SUCCESS_FIELD_DESC);
//                    fVar.mo18497a(new C2098c(JceStruct.ZERO_TAG, word_media_by_topic_ids_v2_result.success.size()));
//                    for (BBWordMediaV2 write : word_media_by_topic_ids_v2_result.success) {
//                        write.write(fVar);
//                    }
//                }
//                if (word_media_by_topic_ids_v2_result.sysException != null) {
//                    fVar.mo18496a(word_media_by_topic_ids_v2_result.SYS_EXCEPTION_FIELD_DESC);
//                    word_media_by_topic_ids_v2_result.sysException.write(fVar);
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class word_media_by_topic_ids_v2_resultStandardSchemeFactory implements C2109b {
//            private word_media_by_topic_ids_v2_resultStandardSchemeFactory() {
//            }
//
//            /* synthetic */ word_media_by_topic_ids_v2_resultStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public word_media_by_topic_ids_v2_resultStandardScheme getScheme() {
//                return new word_media_by_topic_ids_v2_resultStandardScheme(null);
//            }
//        }
//
//        class word_media_by_topic_ids_v2_resultTupleScheme extends C2111d<word_media_by_topic_ids_v2_result> {
//            private word_media_by_topic_ids_v2_resultTupleScheme() {
//            }
//
//            /* synthetic */ word_media_by_topic_ids_v2_resultTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, word_media_by_topic_ids_v2_result word_media_by_topic_ids_v2_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet bitSet = new BitSet();
//                if (word_media_by_topic_ids_v2_result.isSetSuccess()) {
//                    bitSet.set(0);
//                }
//                if (word_media_by_topic_ids_v2_result.isSetSysException()) {
//                    bitSet.set(1);
//                }
//                lVar.mo18527a(bitSet, 2);
//                if (word_media_by_topic_ids_v2_result.isSetSuccess()) {
//                    lVar.mo18493a(word_media_by_topic_ids_v2_result.success.size());
//                    for (BBWordMediaV2 write : word_media_by_topic_ids_v2_result.success) {
//                        write.write(lVar);
//                    }
//                }
//                if (word_media_by_topic_ids_v2_result.isSetSysException()) {
//                    word_media_by_topic_ids_v2_result.sysException.write(lVar);
//                }
//            }
//
//            public void read(C2100f fVar, word_media_by_topic_ids_v2_result word_media_by_topic_ids_v2_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet b = lVar.mo18528b(2);
//                if (b.get(0)) {
//                    C2098c cVar = new C2098c(JceStruct.ZERO_TAG, lVar.mo18513n());
//                    word_media_by_topic_ids_v2_result.success = new ArrayList(cVar.f5838b);
//                    for (int i = 0; i < cVar.f5838b; i++) {
//                        BBWordMediaV2 bBWordMediaV2 = new BBWordMediaV2();
//                        bBWordMediaV2.read(lVar);
//                        word_media_by_topic_ids_v2_result.success.add(bBWordMediaV2);
//                    }
//                    word_media_by_topic_ids_v2_result.setSuccessIsSet(true);
//                }
//                if (b.get(1)) {
//                    word_media_by_topic_ids_v2_result.sysException = new BESystemException();
//                    word_media_by_topic_ids_v2_result.sysException.read(lVar);
//                    word_media_by_topic_ids_v2_result.setSysExceptionIsSet(true);
//                }
//            }
//        }
//
//        class word_media_by_topic_ids_v2_resultTupleSchemeFactory implements C2109b {
//            private word_media_by_topic_ids_v2_resultTupleSchemeFactory() {
//            }
//
//            /* synthetic */ word_media_by_topic_ids_v2_resultTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public word_media_by_topic_ids_v2_resultTupleScheme getScheme() {
//                return new word_media_by_topic_ids_v2_resultTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new word_media_by_topic_ids_v2_resultStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new word_media_by_topic_ids_v2_resultTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.SUCCESS, new C2091a("success", 3, new C2093c(new C2095e(BBWordMediaV2.class))));
//            enumMap.put(_Fields.SYS_EXCEPTION, new C2091a("sysException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(word_media_by_topic_ids_v2_result.class, metaDataMap);
//        }
//
//        public word_media_by_topic_ids_v2_result() {
//        }
//
//        public word_media_by_topic_ids_v2_result(List<BBWordMediaV2> list, BESystemException bESystemException) {
//            this();
//            this.success = list;
//            this.sysException = bESystemException;
//        }
//
//        public word_media_by_topic_ids_v2_result(word_media_by_topic_ids_v2_result word_media_by_topic_ids_v2_result) {
//            if (word_media_by_topic_ids_v2_result.isSetSuccess()) {
//                ArrayList arrayList = new ArrayList(word_media_by_topic_ids_v2_result.success.size());
//                for (BBWordMediaV2 bBWordMediaV2 : word_media_by_topic_ids_v2_result.success) {
//                    arrayList.add(new BBWordMediaV2(bBWordMediaV2));
//                }
//                this.success = arrayList;
//            }
//            if (word_media_by_topic_ids_v2_result.isSetSysException()) {
//                this.sysException = new BESystemException(word_media_by_topic_ids_v2_result.sysException);
//            }
//        }
//
//        public word_media_by_topic_ids_v2_result deepCopy() {
//            return new word_media_by_topic_ids_v2_result(this);
//        }
//
//        public void clear() {
//            this.success = null;
//            this.sysException = null;
//        }
//
//        public int getSuccessSize() {
//            if (this.success == null) {
//                return 0;
//            }
//            return this.success.size();
//        }
//
//        public Iterator<BBWordMediaV2> getSuccessIterator() {
//            if (this.success == null) {
//                return null;
//            }
//            return this.success.iterator();
//        }
//
//        public void addToSuccess(BBWordMediaV2 bBWordMediaV2) {
//            if (this.success == null) {
//                this.success = new ArrayList();
//            }
//            this.success.add(bBWordMediaV2);
//        }
//
//        public List<BBWordMediaV2> getSuccess() {
//            return this.success;
//        }
//
//        public word_media_by_topic_ids_v2_result setSuccess(List<BBWordMediaV2> list) {
//            this.success = list;
//            return this;
//        }
//
//        public void unsetSuccess() {
//            this.success = null;
//        }
//
//        public boolean isSetSuccess() {
//            return this.success != null;
//        }
//
//        public void setSuccessIsSet(boolean z) {
//            if (!z) {
//                this.success = null;
//            }
//        }
//
//        public BESystemException getSysException() {
//            return this.sysException;
//        }
//
//        public word_media_by_topic_ids_v2_result setSysException(BESystemException bESystemException) {
//            this.sysException = bESystemException;
//            return this;
//        }
//
//        public void unsetSysException() {
//            this.sysException = null;
//        }
//
//        public boolean isSetSysException() {
//            return this.sysException != null;
//        }
//
//        public void setSysExceptionIsSet(boolean z) {
//            if (!z) {
//                this.sysException = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case SUCCESS:
//                    if (obj == null) {
//                        unsetSuccess();
//                        return;
//                    } else {
//                        setSuccess((List) obj);
//                        return;
//                    }
//                case SYS_EXCEPTION:
//                    if (obj == null) {
//                        unsetSysException();
//                        return;
//                    } else {
//                        setSysException((BESystemException) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case SUCCESS:
//                    return getSuccess();
//                case SYS_EXCEPTION:
//                    return getSysException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case SUCCESS:
//                    return isSetSuccess();
//                case SYS_EXCEPTION:
//                    return isSetSysException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof word_media_by_topic_ids_v2_result)) {
//                return equals((word_media_by_topic_ids_v2_result) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(word_media_by_topic_ids_v2_result word_media_by_topic_ids_v2_result) {
//            if (word_media_by_topic_ids_v2_result == null) {
//                return false;
//            }
//            boolean isSetSuccess = isSetSuccess();
//            boolean isSetSuccess2 = word_media_by_topic_ids_v2_result.isSetSuccess();
//            if ((isSetSuccess || isSetSuccess2) && (!isSetSuccess || !isSetSuccess2 || !this.success.equals(word_media_by_topic_ids_v2_result.success))) {
//                return false;
//            }
//            boolean isSetSysException = isSetSysException();
//            boolean isSetSysException2 = word_media_by_topic_ids_v2_result.isSetSysException();
//            if ((isSetSysException || isSetSysException2) && (!isSetSysException || !isSetSysException2 || !this.sysException.equals(word_media_by_topic_ids_v2_result.sysException))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(word_media_by_topic_ids_v2_result word_media_by_topic_ids_v2_result) {
//            if (!getClass().equals(word_media_by_topic_ids_v2_result.getClass())) {
//                return getClass().getName().compareTo(word_media_by_topic_ids_v2_result.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetSuccess()).compareTo(Boolean.valueOf(word_media_by_topic_ids_v2_result.isSetSuccess()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetSuccess()) {
//                int a = C2121h.m5526a((List) this.success, (List) word_media_by_topic_ids_v2_result.success);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetSysException()).compareTo(Boolean.valueOf(word_media_by_topic_ids_v2_result.isSetSysException()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetSysException()) {
//                int a2 = C2121h.m5524a((Comparable) this.sysException, (Comparable) word_media_by_topic_ids_v2_result.sysException);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("word_media_by_topic_ids_v2_result(");
//            sb.append("success:");
//            if (this.success == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.success);
//            }
//            sb.append(", ");
//            sb.append("sysException:");
//            if (this.sysException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.sysException);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class word_search_args implements Serializable, Cloneable, Comparable<word_search_args>, C2116f<word_search_args, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2097b QUERY_STR_FIELD_DESC = new C2097b("query_str", JceStruct.STRUCT_END, 1);
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("word_search_args");
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        public String query_str;
//
//        public enum _Fields implements C2124m {
//            QUERY_STR(1, "query_str");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 1:
//                        return QUERY_STR;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class word_search_argsStandardScheme extends C2110c<word_search_args> {
//            private word_search_argsStandardScheme() {
//            }
//
//            /* synthetic */ word_search_argsStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, word_search_args word_search_args) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 1:
//                                if (g.f5835b != 11) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    word_search_args.query_str = fVar.mo18516q();
//                                    word_search_args.setQuery_strIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        word_search_args.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, word_search_args word_search_args) {
//                word_search_args.validate();
//                word_search_args.STRUCT_DESC;
//                fVar.mo18490a();
//                if (word_search_args.query_str != null) {
//                    fVar.mo18496a(word_search_args.QUERY_STR_FIELD_DESC);
//                    fVar.mo18495a(word_search_args.query_str);
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class word_search_argsStandardSchemeFactory implements C2109b {
//            private word_search_argsStandardSchemeFactory() {
//            }
//
//            /* synthetic */ word_search_argsStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public word_search_argsStandardScheme getScheme() {
//                return new word_search_argsStandardScheme(null);
//            }
//        }
//
//        class word_search_argsTupleScheme extends C2111d<word_search_args> {
//            private word_search_argsTupleScheme() {
//            }
//
//            /* synthetic */ word_search_argsTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, word_search_args word_search_args) {
//                ((C2106l) fVar).mo18495a(word_search_args.query_str);
//            }
//
//            public void read(C2100f fVar, word_search_args word_search_args) {
//                word_search_args.query_str = ((C2106l) fVar).mo18516q();
//                word_search_args.setQuery_strIsSet(true);
//            }
//        }
//
//        class word_search_argsTupleSchemeFactory implements C2109b {
//            private word_search_argsTupleSchemeFactory() {
//            }
//
//            /* synthetic */ word_search_argsTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public word_search_argsTupleScheme getScheme() {
//                return new word_search_argsTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new word_search_argsStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new word_search_argsTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.QUERY_STR, new C2091a("query_str", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(word_search_args.class, metaDataMap);
//        }
//
//        public word_search_args() {
//        }
//
//        public word_search_args(String str) {
//            this();
//            this.query_str = str;
//        }
//
//        public word_search_args(word_search_args word_search_args) {
//            if (word_search_args.isSetQuery_str()) {
//                this.query_str = word_search_args.query_str;
//            }
//        }
//
//        public word_search_args deepCopy() {
//            return new word_search_args(this);
//        }
//
//        public void clear() {
//            this.query_str = null;
//        }
//
//        public String getQuery_str() {
//            return this.query_str;
//        }
//
//        public word_search_args setQuery_str(String str) {
//            this.query_str = str;
//            return this;
//        }
//
//        public void unsetQuery_str() {
//            this.query_str = null;
//        }
//
//        public boolean isSetQuery_str() {
//            return this.query_str != null;
//        }
//
//        public void setQuery_strIsSet(boolean z) {
//            if (!z) {
//                this.query_str = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case QUERY_STR:
//                    if (obj == null) {
//                        unsetQuery_str();
//                        return;
//                    } else {
//                        setQuery_str((String) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case QUERY_STR:
//                    return getQuery_str();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case QUERY_STR:
//                    return isSetQuery_str();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof word_search_args)) {
//                return equals((word_search_args) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(word_search_args word_search_args) {
//            if (word_search_args == null) {
//                return false;
//            }
//            boolean isSetQuery_str = isSetQuery_str();
//            boolean isSetQuery_str2 = word_search_args.isSetQuery_str();
//            if ((isSetQuery_str || isSetQuery_str2) && (!isSetQuery_str || !isSetQuery_str2 || !this.query_str.equals(word_search_args.query_str))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(word_search_args word_search_args) {
//            if (!getClass().equals(word_search_args.getClass())) {
//                return getClass().getName().compareTo(word_search_args.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetQuery_str()).compareTo(Boolean.valueOf(word_search_args.isSetQuery_str()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetQuery_str()) {
//                int a = C2121h.m5525a(this.query_str, word_search_args.query_str);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("word_search_args(");
//            sb.append("query_str:");
//            if (this.query_str == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.query_str);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//            if (this.query_str == null) {
//                throw new C2101g("Required field 'query_str' was not present! Struct: " + toString());
//            }
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class word_search_result implements Serializable, Cloneable, Comparable<word_search_result>, C2116f<word_search_result, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2097b LOGIC_EXCEPTION_FIELD_DESC = new C2097b("logicException", JceStruct.ZERO_TAG, 2);
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("word_search_result");
//        /* access modifiers changed from: private */
//        public static final C2097b SUCCESS_FIELD_DESC = new C2097b("success", 15, 0);
//        /* access modifiers changed from: private */
//        public static final C2097b SYS_EXCEPTION_FIELD_DESC = new C2097b("sysException", JceStruct.ZERO_TAG, 1);
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        public BELogicException logicException;
//        public List<BBWordSearchResult> success;
//        public BESystemException sysException;
//
//        public enum _Fields implements C2124m {
//            SUCCESS(0, "success"),
//            SYS_EXCEPTION(1, "sysException"),
//            LOGIC_EXCEPTION(2, "logicException");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 0:
//                        return SUCCESS;
//                    case 1:
//                        return SYS_EXCEPTION;
//                    case 2:
//                        return LOGIC_EXCEPTION;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class word_search_resultStandardScheme extends C2110c<word_search_result> {
//            private word_search_resultStandardScheme() {
//            }
//
//            /* synthetic */ word_search_resultStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, word_search_result word_search_result) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 0:
//                                if (g.f5835b != 15) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    C2098c i = fVar.mo18508i();
//                                    word_search_result.success = new ArrayList(i.f5838b);
//                                    for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                        BBWordSearchResult bBWordSearchResult = new BBWordSearchResult();
//                                        bBWordSearchResult.read(fVar);
//                                        word_search_result.success.add(bBWordSearchResult);
//                                    }
//                                    word_search_result.setSuccessIsSet(true);
//                                    break;
//                                }
//                            case 1:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    word_search_result.sysException = new BESystemException();
//                                    word_search_result.sysException.read(fVar);
//                                    word_search_result.setSysExceptionIsSet(true);
//                                    break;
//                                }
//                            case 2:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    word_search_result.logicException = new BELogicException();
//                                    word_search_result.logicException.read(fVar);
//                                    word_search_result.setLogicExceptionIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        word_search_result.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, word_search_result word_search_result) {
//                word_search_result.validate();
//                word_search_result.STRUCT_DESC;
//                fVar.mo18490a();
//                if (word_search_result.success != null) {
//                    fVar.mo18496a(word_search_result.SUCCESS_FIELD_DESC);
//                    fVar.mo18497a(new C2098c(JceStruct.ZERO_TAG, word_search_result.success.size()));
//                    for (BBWordSearchResult write : word_search_result.success) {
//                        write.write(fVar);
//                    }
//                }
//                if (word_search_result.sysException != null) {
//                    fVar.mo18496a(word_search_result.SYS_EXCEPTION_FIELD_DESC);
//                    word_search_result.sysException.write(fVar);
//                }
//                if (word_search_result.logicException != null) {
//                    fVar.mo18496a(word_search_result.LOGIC_EXCEPTION_FIELD_DESC);
//                    word_search_result.logicException.write(fVar);
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class word_search_resultStandardSchemeFactory implements C2109b {
//            private word_search_resultStandardSchemeFactory() {
//            }
//
//            /* synthetic */ word_search_resultStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public word_search_resultStandardScheme getScheme() {
//                return new word_search_resultStandardScheme(null);
//            }
//        }
//
//        class word_search_resultTupleScheme extends C2111d<word_search_result> {
//            private word_search_resultTupleScheme() {
//            }
//
//            /* synthetic */ word_search_resultTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, word_search_result word_search_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet bitSet = new BitSet();
//                if (word_search_result.isSetSuccess()) {
//                    bitSet.set(0);
//                }
//                if (word_search_result.isSetSysException()) {
//                    bitSet.set(1);
//                }
//                if (word_search_result.isSetLogicException()) {
//                    bitSet.set(2);
//                }
//                lVar.mo18527a(bitSet, 3);
//                if (word_search_result.isSetSuccess()) {
//                    lVar.mo18493a(word_search_result.success.size());
//                    for (BBWordSearchResult write : word_search_result.success) {
//                        write.write(lVar);
//                    }
//                }
//                if (word_search_result.isSetSysException()) {
//                    word_search_result.sysException.write(lVar);
//                }
//                if (word_search_result.isSetLogicException()) {
//                    word_search_result.logicException.write(lVar);
//                }
//            }
//
//            public void read(C2100f fVar, word_search_result word_search_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet b = lVar.mo18528b(3);
//                if (b.get(0)) {
//                    C2098c cVar = new C2098c(JceStruct.ZERO_TAG, lVar.mo18513n());
//                    word_search_result.success = new ArrayList(cVar.f5838b);
//                    for (int i = 0; i < cVar.f5838b; i++) {
//                        BBWordSearchResult bBWordSearchResult = new BBWordSearchResult();
//                        bBWordSearchResult.read(lVar);
//                        word_search_result.success.add(bBWordSearchResult);
//                    }
//                    word_search_result.setSuccessIsSet(true);
//                }
//                if (b.get(1)) {
//                    word_search_result.sysException = new BESystemException();
//                    word_search_result.sysException.read(lVar);
//                    word_search_result.setSysExceptionIsSet(true);
//                }
//                if (b.get(2)) {
//                    word_search_result.logicException = new BELogicException();
//                    word_search_result.logicException.read(lVar);
//                    word_search_result.setLogicExceptionIsSet(true);
//                }
//            }
//        }
//
//        class word_search_resultTupleSchemeFactory implements C2109b {
//            private word_search_resultTupleSchemeFactory() {
//            }
//
//            /* synthetic */ word_search_resultTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public word_search_resultTupleScheme getScheme() {
//                return new word_search_resultTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new word_search_resultStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new word_search_resultTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.SUCCESS, new C2091a("success", 3, new C2093c(new C2095e(BBWordSearchResult.class))));
//            enumMap.put(_Fields.SYS_EXCEPTION, new C2091a("sysException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            enumMap.put(_Fields.LOGIC_EXCEPTION, new C2091a("logicException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(word_search_result.class, metaDataMap);
//        }
//
//        public word_search_result() {
//        }
//
//        public word_search_result(List<BBWordSearchResult> list, BESystemException bESystemException, BELogicException bELogicException) {
//            this();
//            this.success = list;
//            this.sysException = bESystemException;
//            this.logicException = bELogicException;
//        }
//
//        public word_search_result(word_search_result word_search_result) {
//            if (word_search_result.isSetSuccess()) {
//                ArrayList arrayList = new ArrayList(word_search_result.success.size());
//                for (BBWordSearchResult bBWordSearchResult : word_search_result.success) {
//                    arrayList.add(new BBWordSearchResult(bBWordSearchResult));
//                }
//                this.success = arrayList;
//            }
//            if (word_search_result.isSetSysException()) {
//                this.sysException = new BESystemException(word_search_result.sysException);
//            }
//            if (word_search_result.isSetLogicException()) {
//                this.logicException = new BELogicException(word_search_result.logicException);
//            }
//        }
//
//        public word_search_result deepCopy() {
//            return new word_search_result(this);
//        }
//
//        public void clear() {
//            this.success = null;
//            this.sysException = null;
//            this.logicException = null;
//        }
//
//        public int getSuccessSize() {
//            if (this.success == null) {
//                return 0;
//            }
//            return this.success.size();
//        }
//
//        public Iterator<BBWordSearchResult> getSuccessIterator() {
//            if (this.success == null) {
//                return null;
//            }
//            return this.success.iterator();
//        }
//
//        public void addToSuccess(BBWordSearchResult bBWordSearchResult) {
//            if (this.success == null) {
//                this.success = new ArrayList();
//            }
//            this.success.add(bBWordSearchResult);
//        }
//
//        public List<BBWordSearchResult> getSuccess() {
//            return this.success;
//        }
//
//        public word_search_result setSuccess(List<BBWordSearchResult> list) {
//            this.success = list;
//            return this;
//        }
//
//        public void unsetSuccess() {
//            this.success = null;
//        }
//
//        public boolean isSetSuccess() {
//            return this.success != null;
//        }
//
//        public void setSuccessIsSet(boolean z) {
//            if (!z) {
//                this.success = null;
//            }
//        }
//
//        public BESystemException getSysException() {
//            return this.sysException;
//        }
//
//        public word_search_result setSysException(BESystemException bESystemException) {
//            this.sysException = bESystemException;
//            return this;
//        }
//
//        public void unsetSysException() {
//            this.sysException = null;
//        }
//
//        public boolean isSetSysException() {
//            return this.sysException != null;
//        }
//
//        public void setSysExceptionIsSet(boolean z) {
//            if (!z) {
//                this.sysException = null;
//            }
//        }
//
//        public BELogicException getLogicException() {
//            return this.logicException;
//        }
//
//        public word_search_result setLogicException(BELogicException bELogicException) {
//            this.logicException = bELogicException;
//            return this;
//        }
//
//        public void unsetLogicException() {
//            this.logicException = null;
//        }
//
//        public boolean isSetLogicException() {
//            return this.logicException != null;
//        }
//
//        public void setLogicExceptionIsSet(boolean z) {
//            if (!z) {
//                this.logicException = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case SUCCESS:
//                    if (obj == null) {
//                        unsetSuccess();
//                        return;
//                    } else {
//                        setSuccess((List) obj);
//                        return;
//                    }
//                case SYS_EXCEPTION:
//                    if (obj == null) {
//                        unsetSysException();
//                        return;
//                    } else {
//                        setSysException((BESystemException) obj);
//                        return;
//                    }
//                case LOGIC_EXCEPTION:
//                    if (obj == null) {
//                        unsetLogicException();
//                        return;
//                    } else {
//                        setLogicException((BELogicException) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case SUCCESS:
//                    return getSuccess();
//                case SYS_EXCEPTION:
//                    return getSysException();
//                case LOGIC_EXCEPTION:
//                    return getLogicException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case SUCCESS:
//                    return isSetSuccess();
//                case SYS_EXCEPTION:
//                    return isSetSysException();
//                case LOGIC_EXCEPTION:
//                    return isSetLogicException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof word_search_result)) {
//                return equals((word_search_result) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(word_search_result word_search_result) {
//            if (word_search_result == null) {
//                return false;
//            }
//            boolean isSetSuccess = isSetSuccess();
//            boolean isSetSuccess2 = word_search_result.isSetSuccess();
//            if ((isSetSuccess || isSetSuccess2) && (!isSetSuccess || !isSetSuccess2 || !this.success.equals(word_search_result.success))) {
//                return false;
//            }
//            boolean isSetSysException = isSetSysException();
//            boolean isSetSysException2 = word_search_result.isSetSysException();
//            if ((isSetSysException || isSetSysException2) && (!isSetSysException || !isSetSysException2 || !this.sysException.equals(word_search_result.sysException))) {
//                return false;
//            }
//            boolean isSetLogicException = isSetLogicException();
//            boolean isSetLogicException2 = word_search_result.isSetLogicException();
//            if ((isSetLogicException || isSetLogicException2) && (!isSetLogicException || !isSetLogicException2 || !this.logicException.equals(word_search_result.logicException))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(word_search_result word_search_result) {
//            if (!getClass().equals(word_search_result.getClass())) {
//                return getClass().getName().compareTo(word_search_result.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetSuccess()).compareTo(Boolean.valueOf(word_search_result.isSetSuccess()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetSuccess()) {
//                int a = C2121h.m5526a((List) this.success, (List) word_search_result.success);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetSysException()).compareTo(Boolean.valueOf(word_search_result.isSetSysException()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetSysException()) {
//                int a2 = C2121h.m5524a((Comparable) this.sysException, (Comparable) word_search_result.sysException);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            int compareTo3 = Boolean.valueOf(isSetLogicException()).compareTo(Boolean.valueOf(word_search_result.isSetLogicException()));
//            if (compareTo3 != 0) {
//                return compareTo3;
//            }
//            if (isSetLogicException()) {
//                int a3 = C2121h.m5524a((Comparable) this.logicException, (Comparable) word_search_result.logicException);
//                if (a3 != 0) {
//                    return a3;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("word_search_result(");
//            sb.append("success:");
//            if (this.success == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.success);
//            }
//            sb.append(", ");
//            sb.append("sysException:");
//            if (this.sysException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.sysException);
//            }
//            sb.append(", ");
//            sb.append("logicException:");
//            if (this.logicException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.logicException);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class word_share_notify_args implements Serializable, Cloneable, Comparable<word_share_notify_args>, C2116f<word_share_notify_args, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2097b BOOK_ID_FIELD_DESC = new C2097b("book_id", 8, 2);
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("word_share_notify_args");
//        /* access modifiers changed from: private */
//        public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 1);
//        private static final int __BOOK_ID_ISSET_ID = 1;
//        private static final int __TOPIC_ID_ISSET_ID = 0;
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        private byte __isset_bitfield;
//        public int book_id;
//        public int topic_id;
//
//        public enum _Fields implements C2124m {
//            TOPIC_ID(1, "topic_id"),
//            BOOK_ID(2, "book_id");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 1:
//                        return TOPIC_ID;
//                    case 2:
//                        return BOOK_ID;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class word_share_notify_argsStandardScheme extends C2110c<word_share_notify_args> {
//            private word_share_notify_argsStandardScheme() {
//            }
//
//            /* synthetic */ word_share_notify_argsStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, word_share_notify_args word_share_notify_args) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 1:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    word_share_notify_args.topic_id = fVar.mo18513n();
//                                    word_share_notify_args.setTopic_idIsSet(true);
//                                    break;
//                                }
//                            case 2:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    word_share_notify_args.book_id = fVar.mo18513n();
//                                    word_share_notify_args.setBook_idIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        if (!word_share_notify_args.isSetTopic_id()) {
//                            throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                        } else if (!word_share_notify_args.isSetBook_id()) {
//                            throw new C2101g("Required field 'book_id' was not found in serialized data! Struct: " + toString());
//                        } else {
//                            word_share_notify_args.validate();
//                            return;
//                        }
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, word_share_notify_args word_share_notify_args) {
//                word_share_notify_args.validate();
//                word_share_notify_args.STRUCT_DESC;
//                fVar.mo18490a();
//                fVar.mo18496a(word_share_notify_args.TOPIC_ID_FIELD_DESC);
//                fVar.mo18493a(word_share_notify_args.topic_id);
//                fVar.mo18496a(word_share_notify_args.BOOK_ID_FIELD_DESC);
//                fVar.mo18493a(word_share_notify_args.book_id);
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class word_share_notify_argsStandardSchemeFactory implements C2109b {
//            private word_share_notify_argsStandardSchemeFactory() {
//            }
//
//            /* synthetic */ word_share_notify_argsStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public word_share_notify_argsStandardScheme getScheme() {
//                return new word_share_notify_argsStandardScheme(null);
//            }
//        }
//
//        class word_share_notify_argsTupleScheme extends C2111d<word_share_notify_args> {
//            private word_share_notify_argsTupleScheme() {
//            }
//
//            /* synthetic */ word_share_notify_argsTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, word_share_notify_args word_share_notify_args) {
//                C2106l lVar = (C2106l) fVar;
//                lVar.mo18493a(word_share_notify_args.topic_id);
//                lVar.mo18493a(word_share_notify_args.book_id);
//            }
//
//            public void read(C2100f fVar, word_share_notify_args word_share_notify_args) {
//                C2106l lVar = (C2106l) fVar;
//                word_share_notify_args.topic_id = lVar.mo18513n();
//                word_share_notify_args.setTopic_idIsSet(true);
//                word_share_notify_args.book_id = lVar.mo18513n();
//                word_share_notify_args.setBook_idIsSet(true);
//            }
//        }
//
//        class word_share_notify_argsTupleSchemeFactory implements C2109b {
//            private word_share_notify_argsTupleSchemeFactory() {
//            }
//
//            /* synthetic */ word_share_notify_argsTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public word_share_notify_argsTupleScheme getScheme() {
//                return new word_share_notify_argsTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new word_share_notify_argsStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new word_share_notify_argsTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//            enumMap.put(_Fields.BOOK_ID, new C2091a("book_id", 1, new C2092b(8, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(word_share_notify_args.class, metaDataMap);
//        }
//
//        public word_share_notify_args() {
//            this.__isset_bitfield = 0;
//        }
//
//        public word_share_notify_args(int i, int i2) {
//            this();
//            this.topic_id = i;
//            setTopic_idIsSet(true);
//            this.book_id = i2;
//            setBook_idIsSet(true);
//        }
//
//        public word_share_notify_args(word_share_notify_args word_share_notify_args) {
//            this.__isset_bitfield = 0;
//            this.__isset_bitfield = word_share_notify_args.__isset_bitfield;
//            this.topic_id = word_share_notify_args.topic_id;
//            this.book_id = word_share_notify_args.book_id;
//        }
//
//        public word_share_notify_args deepCopy() {
//            return new word_share_notify_args(this);
//        }
//
//        public void clear() {
//            setTopic_idIsSet(false);
//            this.topic_id = 0;
//            setBook_idIsSet(false);
//            this.book_id = 0;
//        }
//
//        public int getTopic_id() {
//            return this.topic_id;
//        }
//
//        public word_share_notify_args setTopic_id(int i) {
//            this.topic_id = i;
//            setTopic_idIsSet(true);
//            return this;
//        }
//
//        public void unsetTopic_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//        }
//
//        public boolean isSetTopic_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 0);
//        }
//
//        public void setTopic_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//        }
//
//        public int getBook_id() {
//            return this.book_id;
//        }
//
//        public word_share_notify_args setBook_id(int i) {
//            this.book_id = i;
//            setBook_idIsSet(true);
//            return this;
//        }
//
//        public void unsetBook_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//        }
//
//        public boolean isSetBook_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 1);
//        }
//
//        public void setBook_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case TOPIC_ID:
//                    if (obj == null) {
//                        unsetTopic_id();
//                        return;
//                    } else {
//                        setTopic_id(((Integer) obj).intValue());
//                        return;
//                    }
//                case BOOK_ID:
//                    if (obj == null) {
//                        unsetBook_id();
//                        return;
//                    } else {
//                        setBook_id(((Integer) obj).intValue());
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case TOPIC_ID:
//                    return Integer.valueOf(getTopic_id());
//                case BOOK_ID:
//                    return Integer.valueOf(getBook_id());
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case TOPIC_ID:
//                    return isSetTopic_id();
//                case BOOK_ID:
//                    return isSetBook_id();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof word_share_notify_args)) {
//                return equals((word_share_notify_args) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(word_share_notify_args word_share_notify_args) {
//            if (word_share_notify_args != null && this.topic_id == word_share_notify_args.topic_id && this.book_id == word_share_notify_args.book_id) {
//                return true;
//            }
//            return false;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(word_share_notify_args word_share_notify_args) {
//            if (!getClass().equals(word_share_notify_args.getClass())) {
//                return getClass().getName().compareTo(word_share_notify_args.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(word_share_notify_args.isSetTopic_id()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetTopic_id()) {
//                int a = C2121h.m5522a(this.topic_id, word_share_notify_args.topic_id);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetBook_id()).compareTo(Boolean.valueOf(word_share_notify_args.isSetBook_id()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetBook_id()) {
//                int a2 = C2121h.m5522a(this.book_id, word_share_notify_args.book_id);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("word_share_notify_args(");
//            sb.append("topic_id:");
//            sb.append(this.topic_id);
//            sb.append(", ");
//            sb.append("book_id:");
//            sb.append(this.book_id);
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                this.__isset_bitfield = 0;
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class word_share_notify_result implements Serializable, Cloneable, Comparable<word_share_notify_result>, C2116f<word_share_notify_result, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2097b LOGIC_EXCEPTION_FIELD_DESC = new C2097b("logicException", JceStruct.ZERO_TAG, 2);
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("word_share_notify_result");
//        /* access modifiers changed from: private */
//        public static final C2097b SUCCESS_FIELD_DESC = new C2097b("success", 8, 0);
//        /* access modifiers changed from: private */
//        public static final C2097b SYS_EXCEPTION_FIELD_DESC = new C2097b("sysException", JceStruct.ZERO_TAG, 1);
//        private static final int __SUCCESS_ISSET_ID = 0;
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        private byte __isset_bitfield;
//        public BELogicException logicException;
//        public int success;
//        public BESystemException sysException;
//
//        public enum _Fields implements C2124m {
//            SUCCESS(0, "success"),
//            SYS_EXCEPTION(1, "sysException"),
//            LOGIC_EXCEPTION(2, "logicException");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 0:
//                        return SUCCESS;
//                    case 1:
//                        return SYS_EXCEPTION;
//                    case 2:
//                        return LOGIC_EXCEPTION;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class word_share_notify_resultStandardScheme extends C2110c<word_share_notify_result> {
//            private word_share_notify_resultStandardScheme() {
//            }
//
//            /* synthetic */ word_share_notify_resultStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, word_share_notify_result word_share_notify_result) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 0:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    word_share_notify_result.success = fVar.mo18513n();
//                                    word_share_notify_result.setSuccessIsSet(true);
//                                    break;
//                                }
//                            case 1:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    word_share_notify_result.sysException = new BESystemException();
//                                    word_share_notify_result.sysException.read(fVar);
//                                    word_share_notify_result.setSysExceptionIsSet(true);
//                                    break;
//                                }
//                            case 2:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    word_share_notify_result.logicException = new BELogicException();
//                                    word_share_notify_result.logicException.read(fVar);
//                                    word_share_notify_result.setLogicExceptionIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        word_share_notify_result.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, word_share_notify_result word_share_notify_result) {
//                word_share_notify_result.validate();
//                word_share_notify_result.STRUCT_DESC;
//                fVar.mo18490a();
//                if (word_share_notify_result.isSetSuccess()) {
//                    fVar.mo18496a(word_share_notify_result.SUCCESS_FIELD_DESC);
//                    fVar.mo18493a(word_share_notify_result.success);
//                }
//                if (word_share_notify_result.sysException != null) {
//                    fVar.mo18496a(word_share_notify_result.SYS_EXCEPTION_FIELD_DESC);
//                    word_share_notify_result.sysException.write(fVar);
//                }
//                if (word_share_notify_result.logicException != null) {
//                    fVar.mo18496a(word_share_notify_result.LOGIC_EXCEPTION_FIELD_DESC);
//                    word_share_notify_result.logicException.write(fVar);
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class word_share_notify_resultStandardSchemeFactory implements C2109b {
//            private word_share_notify_resultStandardSchemeFactory() {
//            }
//
//            /* synthetic */ word_share_notify_resultStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public word_share_notify_resultStandardScheme getScheme() {
//                return new word_share_notify_resultStandardScheme(null);
//            }
//        }
//
//        class word_share_notify_resultTupleScheme extends C2111d<word_share_notify_result> {
//            private word_share_notify_resultTupleScheme() {
//            }
//
//            /* synthetic */ word_share_notify_resultTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, word_share_notify_result word_share_notify_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet bitSet = new BitSet();
//                if (word_share_notify_result.isSetSuccess()) {
//                    bitSet.set(0);
//                }
//                if (word_share_notify_result.isSetSysException()) {
//                    bitSet.set(1);
//                }
//                if (word_share_notify_result.isSetLogicException()) {
//                    bitSet.set(2);
//                }
//                lVar.mo18527a(bitSet, 3);
//                if (word_share_notify_result.isSetSuccess()) {
//                    lVar.mo18493a(word_share_notify_result.success);
//                }
//                if (word_share_notify_result.isSetSysException()) {
//                    word_share_notify_result.sysException.write(lVar);
//                }
//                if (word_share_notify_result.isSetLogicException()) {
//                    word_share_notify_result.logicException.write(lVar);
//                }
//            }
//
//            public void read(C2100f fVar, word_share_notify_result word_share_notify_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet b = lVar.mo18528b(3);
//                if (b.get(0)) {
//                    word_share_notify_result.success = lVar.mo18513n();
//                    word_share_notify_result.setSuccessIsSet(true);
//                }
//                if (b.get(1)) {
//                    word_share_notify_result.sysException = new BESystemException();
//                    word_share_notify_result.sysException.read(lVar);
//                    word_share_notify_result.setSysExceptionIsSet(true);
//                }
//                if (b.get(2)) {
//                    word_share_notify_result.logicException = new BELogicException();
//                    word_share_notify_result.logicException.read(lVar);
//                    word_share_notify_result.setLogicExceptionIsSet(true);
//                }
//            }
//        }
//
//        class word_share_notify_resultTupleSchemeFactory implements C2109b {
//            private word_share_notify_resultTupleSchemeFactory() {
//            }
//
//            /* synthetic */ word_share_notify_resultTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public word_share_notify_resultTupleScheme getScheme() {
//                return new word_share_notify_resultTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new word_share_notify_resultStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new word_share_notify_resultTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.SUCCESS, new C2091a("success", 3, new C2092b(8, 0)));
//            enumMap.put(_Fields.SYS_EXCEPTION, new C2091a("sysException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            enumMap.put(_Fields.LOGIC_EXCEPTION, new C2091a("logicException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(word_share_notify_result.class, metaDataMap);
//        }
//
//        public word_share_notify_result() {
//            this.__isset_bitfield = 0;
//        }
//
//        public word_share_notify_result(int i, BESystemException bESystemException, BELogicException bELogicException) {
//            this();
//            this.success = i;
//            setSuccessIsSet(true);
//            this.sysException = bESystemException;
//            this.logicException = bELogicException;
//        }
//
//        public word_share_notify_result(word_share_notify_result word_share_notify_result) {
//            this.__isset_bitfield = 0;
//            this.__isset_bitfield = word_share_notify_result.__isset_bitfield;
//            this.success = word_share_notify_result.success;
//            if (word_share_notify_result.isSetSysException()) {
//                this.sysException = new BESystemException(word_share_notify_result.sysException);
//            }
//            if (word_share_notify_result.isSetLogicException()) {
//                this.logicException = new BELogicException(word_share_notify_result.logicException);
//            }
//        }
//
//        public word_share_notify_result deepCopy() {
//            return new word_share_notify_result(this);
//        }
//
//        public void clear() {
//            setSuccessIsSet(false);
//            this.success = 0;
//            this.sysException = null;
//            this.logicException = null;
//        }
//
//        public int getSuccess() {
//            return this.success;
//        }
//
//        public word_share_notify_result setSuccess(int i) {
//            this.success = i;
//            setSuccessIsSet(true);
//            return this;
//        }
//
//        public void unsetSuccess() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//        }
//
//        public boolean isSetSuccess() {
//            return C2090b.m5429a(this.__isset_bitfield, 0);
//        }
//
//        public void setSuccessIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//        }
//
//        public BESystemException getSysException() {
//            return this.sysException;
//        }
//
//        public word_share_notify_result setSysException(BESystemException bESystemException) {
//            this.sysException = bESystemException;
//            return this;
//        }
//
//        public void unsetSysException() {
//            this.sysException = null;
//        }
//
//        public boolean isSetSysException() {
//            return this.sysException != null;
//        }
//
//        public void setSysExceptionIsSet(boolean z) {
//            if (!z) {
//                this.sysException = null;
//            }
//        }
//
//        public BELogicException getLogicException() {
//            return this.logicException;
//        }
//
//        public word_share_notify_result setLogicException(BELogicException bELogicException) {
//            this.logicException = bELogicException;
//            return this;
//        }
//
//        public void unsetLogicException() {
//            this.logicException = null;
//        }
//
//        public boolean isSetLogicException() {
//            return this.logicException != null;
//        }
//
//        public void setLogicExceptionIsSet(boolean z) {
//            if (!z) {
//                this.logicException = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case SUCCESS:
//                    if (obj == null) {
//                        unsetSuccess();
//                        return;
//                    } else {
//                        setSuccess(((Integer) obj).intValue());
//                        return;
//                    }
//                case SYS_EXCEPTION:
//                    if (obj == null) {
//                        unsetSysException();
//                        return;
//                    } else {
//                        setSysException((BESystemException) obj);
//                        return;
//                    }
//                case LOGIC_EXCEPTION:
//                    if (obj == null) {
//                        unsetLogicException();
//                        return;
//                    } else {
//                        setLogicException((BELogicException) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case SUCCESS:
//                    return Integer.valueOf(getSuccess());
//                case SYS_EXCEPTION:
//                    return getSysException();
//                case LOGIC_EXCEPTION:
//                    return getLogicException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case SUCCESS:
//                    return isSetSuccess();
//                case SYS_EXCEPTION:
//                    return isSetSysException();
//                case LOGIC_EXCEPTION:
//                    return isSetLogicException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof word_share_notify_result)) {
//                return equals((word_share_notify_result) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(word_share_notify_result word_share_notify_result) {
//            if (word_share_notify_result == null || this.success != word_share_notify_result.success) {
//                return false;
//            }
//            boolean isSetSysException = isSetSysException();
//            boolean isSetSysException2 = word_share_notify_result.isSetSysException();
//            if ((isSetSysException || isSetSysException2) && (!isSetSysException || !isSetSysException2 || !this.sysException.equals(word_share_notify_result.sysException))) {
//                return false;
//            }
//            boolean isSetLogicException = isSetLogicException();
//            boolean isSetLogicException2 = word_share_notify_result.isSetLogicException();
//            if ((isSetLogicException || isSetLogicException2) && (!isSetLogicException || !isSetLogicException2 || !this.logicException.equals(word_share_notify_result.logicException))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(word_share_notify_result word_share_notify_result) {
//            if (!getClass().equals(word_share_notify_result.getClass())) {
//                return getClass().getName().compareTo(word_share_notify_result.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetSuccess()).compareTo(Boolean.valueOf(word_share_notify_result.isSetSuccess()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetSuccess()) {
//                int a = C2121h.m5522a(this.success, word_share_notify_result.success);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetSysException()).compareTo(Boolean.valueOf(word_share_notify_result.isSetSysException()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetSysException()) {
//                int a2 = C2121h.m5524a((Comparable) this.sysException, (Comparable) word_share_notify_result.sysException);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            int compareTo3 = Boolean.valueOf(isSetLogicException()).compareTo(Boolean.valueOf(word_share_notify_result.isSetLogicException()));
//            if (compareTo3 != 0) {
//                return compareTo3;
//            }
//            if (isSetLogicException()) {
//                int a3 = C2121h.m5524a((Comparable) this.logicException, (Comparable) word_share_notify_result.logicException);
//                if (a3 != 0) {
//                    return a3;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("word_share_notify_result(");
//            sb.append("success:");
//            sb.append(this.success);
//            sb.append(", ");
//            sb.append("sysException:");
//            if (this.sysException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.sysException);
//            }
//            sb.append(", ");
//            sb.append("logicException:");
//            if (this.logicException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.logicException);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                this.__isset_bitfield = 0;
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class word_share_notify_v2_args implements Serializable, Cloneable, Comparable<word_share_notify_v2_args>, C2116f<word_share_notify_v2_args, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2097b BOOK_ID_FIELD_DESC = new C2097b("book_id", 8, 2);
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("word_share_notify_v2_args");
//        /* access modifiers changed from: private */
//        public static final C2097b TAG_ID_FIELD_DESC = new C2097b("tag_id", 8, 3);
//        /* access modifiers changed from: private */
//        public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 1);
//        private static final int __BOOK_ID_ISSET_ID = 1;
//        private static final int __TAG_ID_ISSET_ID = 2;
//        private static final int __TOPIC_ID_ISSET_ID = 0;
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        private byte __isset_bitfield;
//        public int book_id;
//        public int tag_id;
//        public int topic_id;
//
//        public enum _Fields implements C2124m {
//            TOPIC_ID(1, "topic_id"),
//            BOOK_ID(2, "book_id"),
//            TAG_ID(3, "tag_id");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 1:
//                        return TOPIC_ID;
//                    case 2:
//                        return BOOK_ID;
//                    case 3:
//                        return TAG_ID;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class word_share_notify_v2_argsStandardScheme extends C2110c<word_share_notify_v2_args> {
//            private word_share_notify_v2_argsStandardScheme() {
//            }
//
//            /* synthetic */ word_share_notify_v2_argsStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, word_share_notify_v2_args word_share_notify_v2_args) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 1:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    word_share_notify_v2_args.topic_id = fVar.mo18513n();
//                                    word_share_notify_v2_args.setTopic_idIsSet(true);
//                                    break;
//                                }
//                            case 2:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    word_share_notify_v2_args.book_id = fVar.mo18513n();
//                                    word_share_notify_v2_args.setBook_idIsSet(true);
//                                    break;
//                                }
//                            case 3:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    word_share_notify_v2_args.tag_id = fVar.mo18513n();
//                                    word_share_notify_v2_args.setTag_idIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        if (!word_share_notify_v2_args.isSetTopic_id()) {
//                            throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                        } else if (!word_share_notify_v2_args.isSetBook_id()) {
//                            throw new C2101g("Required field 'book_id' was not found in serialized data! Struct: " + toString());
//                        } else if (!word_share_notify_v2_args.isSetTag_id()) {
//                            throw new C2101g("Required field 'tag_id' was not found in serialized data! Struct: " + toString());
//                        } else {
//                            word_share_notify_v2_args.validate();
//                            return;
//                        }
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, word_share_notify_v2_args word_share_notify_v2_args) {
//                word_share_notify_v2_args.validate();
//                word_share_notify_v2_args.STRUCT_DESC;
//                fVar.mo18490a();
//                fVar.mo18496a(word_share_notify_v2_args.TOPIC_ID_FIELD_DESC);
//                fVar.mo18493a(word_share_notify_v2_args.topic_id);
//                fVar.mo18496a(word_share_notify_v2_args.BOOK_ID_FIELD_DESC);
//                fVar.mo18493a(word_share_notify_v2_args.book_id);
//                fVar.mo18496a(word_share_notify_v2_args.TAG_ID_FIELD_DESC);
//                fVar.mo18493a(word_share_notify_v2_args.tag_id);
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class word_share_notify_v2_argsStandardSchemeFactory implements C2109b {
//            private word_share_notify_v2_argsStandardSchemeFactory() {
//            }
//
//            /* synthetic */ word_share_notify_v2_argsStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public word_share_notify_v2_argsStandardScheme getScheme() {
//                return new word_share_notify_v2_argsStandardScheme(null);
//            }
//        }
//
//        class word_share_notify_v2_argsTupleScheme extends C2111d<word_share_notify_v2_args> {
//            private word_share_notify_v2_argsTupleScheme() {
//            }
//
//            /* synthetic */ word_share_notify_v2_argsTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, word_share_notify_v2_args word_share_notify_v2_args) {
//                C2106l lVar = (C2106l) fVar;
//                lVar.mo18493a(word_share_notify_v2_args.topic_id);
//                lVar.mo18493a(word_share_notify_v2_args.book_id);
//                lVar.mo18493a(word_share_notify_v2_args.tag_id);
//            }
//
//            public void read(C2100f fVar, word_share_notify_v2_args word_share_notify_v2_args) {
//                C2106l lVar = (C2106l) fVar;
//                word_share_notify_v2_args.topic_id = lVar.mo18513n();
//                word_share_notify_v2_args.setTopic_idIsSet(true);
//                word_share_notify_v2_args.book_id = lVar.mo18513n();
//                word_share_notify_v2_args.setBook_idIsSet(true);
//                word_share_notify_v2_args.tag_id = lVar.mo18513n();
//                word_share_notify_v2_args.setTag_idIsSet(true);
//            }
//        }
//
//        class word_share_notify_v2_argsTupleSchemeFactory implements C2109b {
//            private word_share_notify_v2_argsTupleSchemeFactory() {
//            }
//
//            /* synthetic */ word_share_notify_v2_argsTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public word_share_notify_v2_argsTupleScheme getScheme() {
//                return new word_share_notify_v2_argsTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new word_share_notify_v2_argsStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new word_share_notify_v2_argsTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//            enumMap.put(_Fields.BOOK_ID, new C2091a("book_id", 1, new C2092b(8, 0)));
//            enumMap.put(_Fields.TAG_ID, new C2091a("tag_id", 1, new C2092b(8, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(word_share_notify_v2_args.class, metaDataMap);
//        }
//
//        public word_share_notify_v2_args() {
//            this.__isset_bitfield = 0;
//        }
//
//        public word_share_notify_v2_args(int i, int i2, int i3) {
//            this();
//            this.topic_id = i;
//            setTopic_idIsSet(true);
//            this.book_id = i2;
//            setBook_idIsSet(true);
//            this.tag_id = i3;
//            setTag_idIsSet(true);
//        }
//
//        public word_share_notify_v2_args(word_share_notify_v2_args word_share_notify_v2_args) {
//            this.__isset_bitfield = 0;
//            this.__isset_bitfield = word_share_notify_v2_args.__isset_bitfield;
//            this.topic_id = word_share_notify_v2_args.topic_id;
//            this.book_id = word_share_notify_v2_args.book_id;
//            this.tag_id = word_share_notify_v2_args.tag_id;
//        }
//
//        public word_share_notify_v2_args deepCopy() {
//            return new word_share_notify_v2_args(this);
//        }
//
//        public void clear() {
//            setTopic_idIsSet(false);
//            this.topic_id = 0;
//            setBook_idIsSet(false);
//            this.book_id = 0;
//            setTag_idIsSet(false);
//            this.tag_id = 0;
//        }
//
//        public int getTopic_id() {
//            return this.topic_id;
//        }
//
//        public word_share_notify_v2_args setTopic_id(int i) {
//            this.topic_id = i;
//            setTopic_idIsSet(true);
//            return this;
//        }
//
//        public void unsetTopic_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//        }
//
//        public boolean isSetTopic_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 0);
//        }
//
//        public void setTopic_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//        }
//
//        public int getBook_id() {
//            return this.book_id;
//        }
//
//        public word_share_notify_v2_args setBook_id(int i) {
//            this.book_id = i;
//            setBook_idIsSet(true);
//            return this;
//        }
//
//        public void unsetBook_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//        }
//
//        public boolean isSetBook_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 1);
//        }
//
//        public void setBook_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//        }
//
//        public int getTag_id() {
//            return this.tag_id;
//        }
//
//        public word_share_notify_v2_args setTag_id(int i) {
//            this.tag_id = i;
//            setTag_idIsSet(true);
//            return this;
//        }
//
//        public void unsetTag_id() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//        }
//
//        public boolean isSetTag_id() {
//            return C2090b.m5429a(this.__isset_bitfield, 2);
//        }
//
//        public void setTag_idIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case TOPIC_ID:
//                    if (obj == null) {
//                        unsetTopic_id();
//                        return;
//                    } else {
//                        setTopic_id(((Integer) obj).intValue());
//                        return;
//                    }
//                case BOOK_ID:
//                    if (obj == null) {
//                        unsetBook_id();
//                        return;
//                    } else {
//                        setBook_id(((Integer) obj).intValue());
//                        return;
//                    }
//                case TAG_ID:
//                    if (obj == null) {
//                        unsetTag_id();
//                        return;
//                    } else {
//                        setTag_id(((Integer) obj).intValue());
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case TOPIC_ID:
//                    return Integer.valueOf(getTopic_id());
//                case BOOK_ID:
//                    return Integer.valueOf(getBook_id());
//                case TAG_ID:
//                    return Integer.valueOf(getTag_id());
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case TOPIC_ID:
//                    return isSetTopic_id();
//                case BOOK_ID:
//                    return isSetBook_id();
//                case TAG_ID:
//                    return isSetTag_id();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof word_share_notify_v2_args)) {
//                return equals((word_share_notify_v2_args) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(word_share_notify_v2_args word_share_notify_v2_args) {
//            if (word_share_notify_v2_args != null && this.topic_id == word_share_notify_v2_args.topic_id && this.book_id == word_share_notify_v2_args.book_id && this.tag_id == word_share_notify_v2_args.tag_id) {
//                return true;
//            }
//            return false;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(word_share_notify_v2_args word_share_notify_v2_args) {
//            if (!getClass().equals(word_share_notify_v2_args.getClass())) {
//                return getClass().getName().compareTo(word_share_notify_v2_args.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(word_share_notify_v2_args.isSetTopic_id()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetTopic_id()) {
//                int a = C2121h.m5522a(this.topic_id, word_share_notify_v2_args.topic_id);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetBook_id()).compareTo(Boolean.valueOf(word_share_notify_v2_args.isSetBook_id()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetBook_id()) {
//                int a2 = C2121h.m5522a(this.book_id, word_share_notify_v2_args.book_id);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            int compareTo3 = Boolean.valueOf(isSetTag_id()).compareTo(Boolean.valueOf(word_share_notify_v2_args.isSetTag_id()));
//            if (compareTo3 != 0) {
//                return compareTo3;
//            }
//            if (isSetTag_id()) {
//                int a3 = C2121h.m5522a(this.tag_id, word_share_notify_v2_args.tag_id);
//                if (a3 != 0) {
//                    return a3;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("word_share_notify_v2_args(");
//            sb.append("topic_id:");
//            sb.append(this.topic_id);
//            sb.append(", ");
//            sb.append("book_id:");
//            sb.append(this.book_id);
//            sb.append(", ");
//            sb.append("tag_id:");
//            sb.append(this.tag_id);
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                this.__isset_bitfield = 0;
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//
//    public class word_share_notify_v2_result implements Serializable, Cloneable, Comparable<word_share_notify_v2_result>, C2116f<word_share_notify_v2_result, _Fields> {
//        /* access modifiers changed from: private */
//        public static final C2097b LOGIC_EXCEPTION_FIELD_DESC = new C2097b("logicException", JceStruct.ZERO_TAG, 2);
//        /* access modifiers changed from: private */
//        public static final C2105k STRUCT_DESC = new C2105k("word_share_notify_v2_result");
//        /* access modifiers changed from: private */
//        public static final C2097b SUCCESS_FIELD_DESC = new C2097b("success", 8, 0);
//        /* access modifiers changed from: private */
//        public static final C2097b SYS_EXCEPTION_FIELD_DESC = new C2097b("sysException", JceStruct.ZERO_TAG, 1);
//        private static final int __SUCCESS_ISSET_ID = 0;
//        public static final Map<_Fields, C2091a> metaDataMap;
//        private static final Map<Class<? extends C2108a>, C2109b> schemes;
//        private byte __isset_bitfield;
//        public BELogicException logicException;
//        public int success;
//        public BESystemException sysException;
//
//        public enum _Fields implements C2124m {
//            SUCCESS(0, "success"),
//            SYS_EXCEPTION(1, "sysException"),
//            LOGIC_EXCEPTION(2, "logicException");
//
//            private static final Map<String, _Fields> byName = null;
//            private final String _fieldName;
//            private final short _thriftId;
//
//            static {
//                byName = new HashMap();
//                Iterator it = EnumSet.allOf(_Fields.class).iterator();
//                while (it.hasNext()) {
//                    _Fields _fields = (_Fields) it.next();
//                    byName.put(_fields.getFieldName(), _fields);
//                }
//            }
//
//            public static _Fields findByThriftId(int i) {
//                switch (i) {
//                    case 0:
//                        return SUCCESS;
//                    case 1:
//                        return SYS_EXCEPTION;
//                    case 2:
//                        return LOGIC_EXCEPTION;
//                    default:
//                        return null;
//                }
//            }
//
//            public static _Fields findByThriftIdOrThrow(int i) {
//                _Fields findByThriftId = findByThriftId(i);
//                if (findByThriftId != null) {
//                    return findByThriftId;
//                }
//                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//            }
//
//            public static _Fields findByName(String str) {
//                return (_Fields) byName.get(str);
//            }
//
//            private _Fields(short s, String str) {
//                this._thriftId = s;
//                this._fieldName = str;
//            }
//
//            public final short getThriftFieldId() {
//                return this._thriftId;
//            }
//
//            public final String getFieldName() {
//                return this._fieldName;
//            }
//        }
//
//        class word_share_notify_v2_resultStandardScheme extends C2110c<word_share_notify_v2_result> {
//            private word_share_notify_v2_resultStandardScheme() {
//            }
//
//            /* synthetic */ word_share_notify_v2_resultStandardScheme(C13611 r1) {
//                this();
//            }
//
//            public void read(C2100f fVar, word_share_notify_v2_result word_share_notify_v2_result) {
//                fVar.mo18504e();
//                while (true) {
//                    C2097b g = fVar.mo18506g();
//                    if (g.f5835b != 0) {
//                        switch (g.f5836c) {
//                            case 0:
//                                if (g.f5835b != 8) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    word_share_notify_v2_result.success = fVar.mo18513n();
//                                    word_share_notify_v2_result.setSuccessIsSet(true);
//                                    break;
//                                }
//                            case 1:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    word_share_notify_v2_result.sysException = new BESystemException();
//                                    word_share_notify_v2_result.sysException.read(fVar);
//                                    word_share_notify_v2_result.setSysExceptionIsSet(true);
//                                    break;
//                                }
//                            case 2:
//                                if (g.f5835b != 12) {
//                                    C2103i.m5498a(fVar, g.f5835b);
//                                    break;
//                                } else {
//                                    word_share_notify_v2_result.logicException = new BELogicException();
//                                    word_share_notify_v2_result.logicException.read(fVar);
//                                    word_share_notify_v2_result.setLogicExceptionIsSet(true);
//                                    break;
//                                }
//                            default:
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                        }
//                    } else {
//                        fVar.mo18505f();
//                        word_share_notify_v2_result.validate();
//                        return;
//                    }
//                }
//            }
//
//            public void write(C2100f fVar, word_share_notify_v2_result word_share_notify_v2_result) {
//                word_share_notify_v2_result.validate();
//                word_share_notify_v2_result.STRUCT_DESC;
//                fVar.mo18490a();
//                if (word_share_notify_v2_result.isSetSuccess()) {
//                    fVar.mo18496a(word_share_notify_v2_result.SUCCESS_FIELD_DESC);
//                    fVar.mo18493a(word_share_notify_v2_result.success);
//                }
//                if (word_share_notify_v2_result.sysException != null) {
//                    fVar.mo18496a(word_share_notify_v2_result.SYS_EXCEPTION_FIELD_DESC);
//                    word_share_notify_v2_result.sysException.write(fVar);
//                }
//                if (word_share_notify_v2_result.logicException != null) {
//                    fVar.mo18496a(word_share_notify_v2_result.LOGIC_EXCEPTION_FIELD_DESC);
//                    word_share_notify_v2_result.logicException.write(fVar);
//                }
//                fVar.mo18502c();
//                fVar.mo18501b();
//            }
//        }
//
//        class word_share_notify_v2_resultStandardSchemeFactory implements C2109b {
//            private word_share_notify_v2_resultStandardSchemeFactory() {
//            }
//
//            /* synthetic */ word_share_notify_v2_resultStandardSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public word_share_notify_v2_resultStandardScheme getScheme() {
//                return new word_share_notify_v2_resultStandardScheme(null);
//            }
//        }
//
//        class word_share_notify_v2_resultTupleScheme extends C2111d<word_share_notify_v2_result> {
//            private word_share_notify_v2_resultTupleScheme() {
//            }
//
//            /* synthetic */ word_share_notify_v2_resultTupleScheme(C13611 r1) {
//                this();
//            }
//
//            public void write(C2100f fVar, word_share_notify_v2_result word_share_notify_v2_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet bitSet = new BitSet();
//                if (word_share_notify_v2_result.isSetSuccess()) {
//                    bitSet.set(0);
//                }
//                if (word_share_notify_v2_result.isSetSysException()) {
//                    bitSet.set(1);
//                }
//                if (word_share_notify_v2_result.isSetLogicException()) {
//                    bitSet.set(2);
//                }
//                lVar.mo18527a(bitSet, 3);
//                if (word_share_notify_v2_result.isSetSuccess()) {
//                    lVar.mo18493a(word_share_notify_v2_result.success);
//                }
//                if (word_share_notify_v2_result.isSetSysException()) {
//                    word_share_notify_v2_result.sysException.write(lVar);
//                }
//                if (word_share_notify_v2_result.isSetLogicException()) {
//                    word_share_notify_v2_result.logicException.write(lVar);
//                }
//            }
//
//            public void read(C2100f fVar, word_share_notify_v2_result word_share_notify_v2_result) {
//                C2106l lVar = (C2106l) fVar;
//                BitSet b = lVar.mo18528b(3);
//                if (b.get(0)) {
//                    word_share_notify_v2_result.success = lVar.mo18513n();
//                    word_share_notify_v2_result.setSuccessIsSet(true);
//                }
//                if (b.get(1)) {
//                    word_share_notify_v2_result.sysException = new BESystemException();
//                    word_share_notify_v2_result.sysException.read(lVar);
//                    word_share_notify_v2_result.setSysExceptionIsSet(true);
//                }
//                if (b.get(2)) {
//                    word_share_notify_v2_result.logicException = new BELogicException();
//                    word_share_notify_v2_result.logicException.read(lVar);
//                    word_share_notify_v2_result.setLogicExceptionIsSet(true);
//                }
//            }
//        }
//
//        class word_share_notify_v2_resultTupleSchemeFactory implements C2109b {
//            private word_share_notify_v2_resultTupleSchemeFactory() {
//            }
//
//            /* synthetic */ word_share_notify_v2_resultTupleSchemeFactory(C13611 r1) {
//                this();
//            }
//
//            public word_share_notify_v2_resultTupleScheme getScheme() {
//                return new word_share_notify_v2_resultTupleScheme(null);
//            }
//        }
//
//        static {
//            HashMap hashMap = new HashMap();
//            schemes = hashMap;
//            hashMap.put(C2110c.class, new word_share_notify_v2_resultStandardSchemeFactory(null));
//            schemes.put(C2111d.class, new word_share_notify_v2_resultTupleSchemeFactory(null));
//            EnumMap enumMap = new EnumMap(_Fields.class);
//            enumMap.put(_Fields.SUCCESS, new C2091a("success", 3, new C2092b(8, 0)));
//            enumMap.put(_Fields.SYS_EXCEPTION, new C2091a("sysException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            enumMap.put(_Fields.LOGIC_EXCEPTION, new C2091a("logicException", 3, new C2092b(JceStruct.ZERO_TAG, 0)));
//            metaDataMap = Collections.unmodifiableMap(enumMap);
//            C2091a.m5430a(word_share_notify_v2_result.class, metaDataMap);
//        }
//
//        public word_share_notify_v2_result() {
//            this.__isset_bitfield = 0;
//        }
//
//        public word_share_notify_v2_result(int i, BESystemException bESystemException, BELogicException bELogicException) {
//            this();
//            this.success = i;
//            setSuccessIsSet(true);
//            this.sysException = bESystemException;
//            this.logicException = bELogicException;
//        }
//
//        public word_share_notify_v2_result(word_share_notify_v2_result word_share_notify_v2_result) {
//            this.__isset_bitfield = 0;
//            this.__isset_bitfield = word_share_notify_v2_result.__isset_bitfield;
//            this.success = word_share_notify_v2_result.success;
//            if (word_share_notify_v2_result.isSetSysException()) {
//                this.sysException = new BESystemException(word_share_notify_v2_result.sysException);
//            }
//            if (word_share_notify_v2_result.isSetLogicException()) {
//                this.logicException = new BELogicException(word_share_notify_v2_result.logicException);
//            }
//        }
//
//        public word_share_notify_v2_result deepCopy() {
//            return new word_share_notify_v2_result(this);
//        }
//
//        public void clear() {
//            setSuccessIsSet(false);
//            this.success = 0;
//            this.sysException = null;
//            this.logicException = null;
//        }
//
//        public int getSuccess() {
//            return this.success;
//        }
//
//        public word_share_notify_v2_result setSuccess(int i) {
//            this.success = i;
//            setSuccessIsSet(true);
//            return this;
//        }
//
//        public void unsetSuccess() {
//            this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//        }
//
//        public boolean isSetSuccess() {
//            return C2090b.m5429a(this.__isset_bitfield, 0);
//        }
//
//        public void setSuccessIsSet(boolean z) {
//            this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//        }
//
//        public BESystemException getSysException() {
//            return this.sysException;
//        }
//
//        public word_share_notify_v2_result setSysException(BESystemException bESystemException) {
//            this.sysException = bESystemException;
//            return this;
//        }
//
//        public void unsetSysException() {
//            this.sysException = null;
//        }
//
//        public boolean isSetSysException() {
//            return this.sysException != null;
//        }
//
//        public void setSysExceptionIsSet(boolean z) {
//            if (!z) {
//                this.sysException = null;
//            }
//        }
//
//        public BELogicException getLogicException() {
//            return this.logicException;
//        }
//
//        public word_share_notify_v2_result setLogicException(BELogicException bELogicException) {
//            this.logicException = bELogicException;
//            return this;
//        }
//
//        public void unsetLogicException() {
//            this.logicException = null;
//        }
//
//        public boolean isSetLogicException() {
//            return this.logicException != null;
//        }
//
//        public void setLogicExceptionIsSet(boolean z) {
//            if (!z) {
//                this.logicException = null;
//            }
//        }
//
//        public void setFieldValue(_Fields _fields, Object obj) {
//            switch (_fields) {
//                case SUCCESS:
//                    if (obj == null) {
//                        unsetSuccess();
//                        return;
//                    } else {
//                        setSuccess(((Integer) obj).intValue());
//                        return;
//                    }
//                case SYS_EXCEPTION:
//                    if (obj == null) {
//                        unsetSysException();
//                        return;
//                    } else {
//                        setSysException((BESystemException) obj);
//                        return;
//                    }
//                case LOGIC_EXCEPTION:
//                    if (obj == null) {
//                        unsetLogicException();
//                        return;
//                    } else {
//                        setLogicException((BELogicException) obj);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//
//        public Object getFieldValue(_Fields _fields) {
//            switch (_fields) {
//                case SUCCESS:
//                    return Integer.valueOf(getSuccess());
//                case SYS_EXCEPTION:
//                    return getSysException();
//                case LOGIC_EXCEPTION:
//                    return getLogicException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean isSet(_Fields _fields) {
//            if (_fields == null) {
//                throw new IllegalArgumentException();
//            }
//            switch (_fields) {
//                case SUCCESS:
//                    return isSetSuccess();
//                case SYS_EXCEPTION:
//                    return isSetSysException();
//                case LOGIC_EXCEPTION:
//                    return isSetLogicException();
//                default:
//                    throw new IllegalStateException();
//            }
//        }
//
//        public boolean equals(Object obj) {
//            if (obj != null && (obj instanceof word_share_notify_v2_result)) {
//                return equals((word_share_notify_v2_result) obj);
//            }
//            return false;
//        }
//
//        public boolean equals(word_share_notify_v2_result word_share_notify_v2_result) {
//            if (word_share_notify_v2_result == null || this.success != word_share_notify_v2_result.success) {
//                return false;
//            }
//            boolean isSetSysException = isSetSysException();
//            boolean isSetSysException2 = word_share_notify_v2_result.isSetSysException();
//            if ((isSetSysException || isSetSysException2) && (!isSetSysException || !isSetSysException2 || !this.sysException.equals(word_share_notify_v2_result.sysException))) {
//                return false;
//            }
//            boolean isSetLogicException = isSetLogicException();
//            boolean isSetLogicException2 = word_share_notify_v2_result.isSetLogicException();
//            if ((isSetLogicException || isSetLogicException2) && (!isSetLogicException || !isSetLogicException2 || !this.logicException.equals(word_share_notify_v2_result.logicException))) {
//                return false;
//            }
//            return true;
//        }
//
//        public int hashCode() {
//            return 0;
//        }
//
//        public int compareTo(word_share_notify_v2_result word_share_notify_v2_result) {
//            if (!getClass().equals(word_share_notify_v2_result.getClass())) {
//                return getClass().getName().compareTo(word_share_notify_v2_result.getClass().getName());
//            }
//            int compareTo = Boolean.valueOf(isSetSuccess()).compareTo(Boolean.valueOf(word_share_notify_v2_result.isSetSuccess()));
//            if (compareTo != 0) {
//                return compareTo;
//            }
//            if (isSetSuccess()) {
//                int a = C2121h.m5522a(this.success, word_share_notify_v2_result.success);
//                if (a != 0) {
//                    return a;
//                }
//            }
//            int compareTo2 = Boolean.valueOf(isSetSysException()).compareTo(Boolean.valueOf(word_share_notify_v2_result.isSetSysException()));
//            if (compareTo2 != 0) {
//                return compareTo2;
//            }
//            if (isSetSysException()) {
//                int a2 = C2121h.m5524a((Comparable) this.sysException, (Comparable) word_share_notify_v2_result.sysException);
//                if (a2 != 0) {
//                    return a2;
//                }
//            }
//            int compareTo3 = Boolean.valueOf(isSetLogicException()).compareTo(Boolean.valueOf(word_share_notify_v2_result.isSetLogicException()));
//            if (compareTo3 != 0) {
//                return compareTo3;
//            }
//            if (isSetLogicException()) {
//                int a3 = C2121h.m5524a((Comparable) this.logicException, (Comparable) word_share_notify_v2_result.logicException);
//                if (a3 != 0) {
//                    return a3;
//                }
//            }
//            return 0;
//        }
//
//        public _Fields fieldForId(int i) {
//            return _Fields.findByThriftId(i);
//        }
//
//        public void read(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//        }
//
//        public void write(C2100f fVar) {
//            ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("word_share_notify_v2_result(");
//            sb.append("success:");
//            sb.append(this.success);
//            sb.append(", ");
//            sb.append("sysException:");
//            if (this.sysException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.sysException);
//            }
//            sb.append(", ");
//            sb.append("logicException:");
//            if (this.logicException == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.logicException);
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//
//        public void validate() {
//        }
//
//        private void writeObject(ObjectOutputStream objectOutputStream) {
//            try {
//                write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//
//        private void readObject(ObjectInputStream objectInputStream) {
//            try {
//                this.__isset_bitfield = 0;
//                read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//            } catch (C2123l e) {
//                throw new IOException(e);
//            }
//        }
//    }
//}
