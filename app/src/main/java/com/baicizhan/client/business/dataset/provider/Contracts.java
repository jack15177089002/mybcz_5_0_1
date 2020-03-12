package com.baicizhan.client.business.dataset.provider;

import android.net.Uri;
import android.net.Uri.Builder;
//import com.tencent.android.tpush.common.MessageKey;
import java.util.Locale;

public class Contracts {
    public static final String AUTHORITY = "com.jiongji.andriod.card.provider";
//    public final Uri BaseUri = new Builder().scheme(MessageKey.MSG_CONTENT).authority(AUTHORITY).build();
    public static final String LOG_TAG = "baicizhandb";
    public static final String RAW_EXEC = "raw_exec";
    public static final String RAW_QUERY = "raw_query";

    public class BOOK_TS_OFFLINE_ROAD_MAP_IDS {
        private static final String TABLE_NAME_BASE = "ts_offline_road_map_ids";

        public class Columns {
            public static final String OPTIONS = "options";
            public static final String TAPESCRIPT_ID = "tapescript_id";
            public static final String TOPIC_ID = "topic_id";
            public static final String TOPIC_ID_INDEX = "topic_id_index";
        }

        public  String getBookTableName(int i) {
            return String.format(Locale.US, "%s_%02d", new Object[]{TABLE_NAME_BASE, Integer.valueOf(i)});
        }

        public  Uri getBookContentUri(int i) {
            return Contracts.getTableContentUri(Databases.TOPIC_PROBLEM, getBookTableName(i));
        }
    }

    public class DICTIONARY {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.DICTIONARY, TABLE_NAME);
        public static final String TABLE_NAME = "dictionary";

        public class Columns {
            public static final String ACCENT = "accent";
            public static final String MEAN_CN = "mean_cn";
            public static final String TOPIC_ID = "topic_id";
            public static final String TOPIC_WORD = "topic_word";
        }
    }

    public class Databases {
        public static final String DICTIONARY = "dictionary.db";
        public static final String DO_EXAMPLE_INFO = "baicizhandoexampleinfo.db";
        public static final String EVERY_NOTICE = "baicizhaneverynotice.sqlite";
        public static final String JIONG100_OPENEARS = "jiong100openears.sqlite";
        public static final String JIONGJI_DAILY = "jiongjidaily_json.sqlite";
        public static final String JIONG_DAILY_DICTIONARY = "jiongdailydictionary.sqlite";
        public static final String PROPERTY = "baicizhanproperty.db";
        public static final String STATS = "stats.db";
        public static final String TOPIC = "baicizhantopic.db";
        public static final String TOPIC_PROBLEM = "baicizhantopicproblem.db";
        public static final String TOPIC_WORD_MEAN = "baicizhantopicwordmean.db";
        public static final String TOTAL_RESOURCES = "baicizhantotal.sqlite";
        public static final String USER = "baicizhanuser.db";
        public static final String WORD_LOCK = "lockdb.db";
        public static final String WORD_MEDIA = "word_media.db";
        public static final String WORD_RADIO_TOPIC = "baicizhanwordradiotopic.db";

        public Databases() {
        }
    }

    public class KVDICT {
        public  final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.DO_EXAMPLE_INFO, TABLE_NAME);
        public static final String TABLE_NAME = "KVDICT";

        public class Columns {
            public static final String KEY = "key";
            public static final String VALUE = "value";
        }
    }

    public class NOTIFY_MESSAGE_TB {
        public  final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.EVERY_NOTICE, TABLE_NAME);
        public static final int MSG_TYPE_ACTIVITY = 2;
        public static final int MSG_TYPE_BAOGUO = 3;
        public static final int MSG_TYPE_SYSTEM = 1;
        public static final String TABLE_NAME = "tb_notify_message";

        public final class Columns {
            public static final String CONTENT_URL = "content_url";
            public static final String IMG_URL = "img_url";
            public static final String IS_HIDDEN = "is_hidden";
            public static final String MSG_ID = "msg_id";
            public static final String MSG_TYPE = "msg_type";
            public static final String READ = "read";
            public static final String TIME = "time";
            public static final String TITLE = "title";
            public static final String TITLE_DESC = "title_desc";
        }
    }

    public class PHRASE_MATCH_RESULT_TB {
        public static final String TABLE_NAME_BASE = "tb_phrase_match_result";

        public class Columns {
            public static final String RESULT = "result";
            public static final String TOPIC_ID = "word_topic_id";
        }

        public String getTableName(int i) {
            return String.format(Locale.US, "%s_%02d", new Object[]{TABLE_NAME_BASE, Integer.valueOf(i)});
        }

        public  Uri getContentUri(int i) {
            return Contracts.getTableContentUri(Databases.TOPIC_PROBLEM, getTableName(i));
        }
    }

    public static class PROPERTY {
        public static final String TABLE_NAME = "ZPROPERTY";
        public static final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.PROPERTY, TABLE_NAME);

        public class Columns {
            public static final String KEY = "KEY";
            public static final String VALUE = "VALUE";
        }
    }

    public class SQLITE_SEQUENCE {
        public  final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.JIONGJI_DAILY, TABLE_NAME);
        public static final String TABLE_NAME = "sqlite_sequence";

        public class Columns {
            public static final String NAME = "name";
            public static final String SEQ = "seq";
        }
    }

    public class STATS_OPERATION_COMMON_TB {
        public  final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.STATS, TABLE_NAME);
        public static final String TABLE_NAME = "tb_stats_operation_common";

        public final class Columns {

            /* renamed from: ID */
            public static final String f2234ID = "id";
            public static final String OP_TIME = "op_time";
            public static final String OP_TYPE = "op_type";
            public static final String OP_VALUE = "op_value";
        }
    }

    public class STATS_OPERATION_TB {
        public  final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.STATS, TABLE_NAME);
        public static final String TABLE_NAME = "tb_stats_operation";

        public final class Columns {
            public static final String OP_NAME = "op_name";
            public static final String OP_TIME = "op_time";
            public static final String OP_VALUE = "op_value";
        }
    }

    public class STATS_WORD_DONE_TB {
        public  final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.STATS, TABLE_NAME);
        public static final String TABLE_NAME = "tb_stats_word_done";

        public final class Columns {
            public static final String DONE_TYPE = "done_type";
            public static final String DURATION = "duration";
            public static final String IS_DONE_RIGHT = "is_done_right";
            public static final String IS_TODAY_NEW = "is_today_new";
            public static final String OPTION = "option";
            public static final String TOPIC_ID = "topic_id";
        }
    }

    public class TATAL_TOPIC_RESOURCES_TB {
        public  final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.TOTAL_RESOURCES, TABLE_NAME);
        public static final String TABLE_NAME = "tb_total_topic_resources";

        public final class Columns {
            public static final String BOOK_ID = "book_id";
            public static final String DEFORMATION_IMAGE = "deformation_image";
            public static final String ETYMA = "etyma";
            public static final String IMAGE = "image";
            public static final String MEAN_CN = "mean_cn";
            public static final String MEAN_EN = "mean_en";
            public static final String PHONETIC = "phonetic";
            public static final String SENTENCE = "sentence";
            public static final String SENTENCE_AUDIO = "sentence_audio";
            public static final String SENTENCE_TRANS = "sentence_trans";
            public static final String SHORT_PHRASE = "short_phrase";
            public static final String TOPIC_ID = "topic_id";
            public static final String UPDATE_FLAG = "update_flag";
            public static final String WORD = "word";
            public static final String WORD_AUDIO = "word_audio";
            public static final String WORD_VARIANTS = "word_variants";
        }
    }

    public class TOPICRESOURCE {
        public static final String TABLE_NAME_BASE = "topic_resource";

        public class Columns {
            public static final String DEFORMATION_IMAGE = "deformation_image";
            public static final String ETYMA = "etyma";
            public static final String IMAGE = "image";
            public static final String MEAN_CN = "mean_cn";
            public static final String MEAN_EN = "mean_en";
            public static final String PHONETIC = "phonetic";
            public static final String SENTENCE = "sentence";
            public static final String SENTENCE_AUDIO = "sentence_audio";
            public static final String SENTENCE_TRANS = "sentence_trans";
            public static final String SHORT_PHRASE = "short_phrase";
            public static final String TOPIC = "topic";
            public static final String UPDATE_FLAG_MD5 = "update_flag_md5";
            public static final String WORD = "word";
            public static final String WORD_AUDIO = "word_audio";
            public static final String WORD_VARIANTS = "word_variants";
            public static final String ZPK_PATH = "zpk_path";
        }

        public  String getBookTableName(int i) {
            return String.format(Locale.US, "%s_%02d", new Object[]{TABLE_NAME_BASE, Integer.valueOf(i)});
        }

        public  Uri getBookContentUri(int i) {
            return Contracts.getTableContentUri(Databases.TOPIC, getBookTableName(i));
        }
    }

    public class TS_ALL_NOTICE_LIST {
        public  final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.EVERY_NOTICE, TABLE_NAME);
        public static final String TABLE_NAME = "ts_all_notice_list";

        public class Columns {
            public static final String NTF_CONTENT = "ntf_content";
            public static final String NTF_ID = "ntf_id";
            public static final String NTF_PERSON = "ntf_person";
            public static final String NTF_TIME = "ntf_time";
            public static final String READ_STATUS = "read_status";
        }
    }

    public class TS_EVERY_NOTICE_INFO {
        public  final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.EVERY_NOTICE, TABLE_NAME);
        public static final String TABLE_NAME = "ts_every_notice_info";

        public class Columns {
            public static final String NTF_CONTENT = "ntf_content";
            public static final String NTF_DAY = "ntf_day";
            public static final String NTF_ID = "ntf_id";
            public static final String NTF_PERSON = "ntf_person";
            public static final String NTF_TIME = "ntf_time";
        }
    }

    public class TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS {
        private static final String TABLE_NAME_BASE = "ts_learn_offline_dotopic_sync_ids";

        public class Columns {
            public static final String DO_NUM = "do_num";
            public static final String ERR_NUM = "err_num";
            public static final String IS_TODAY_NEW = "is_today_new";
            public static final String LAST_DO_TIME = "last_do_time";
            public static final String RADIO_POST_STATE = "radio_post_state";
            public static final String RADIO_SKIP_STATE = "radio_skip_state";
            public static final String RADIO_STATE = "radio_state";
            public static final String RADIO_TV_STATE = "radio_tv_state";
            public static final String REVIEW_MORE_COUNT = "review_more_count";
            public static final String SYNC_STATE = "sync_state";
            public static final String TOPIC_DAY = "topic_day";
            public static final String TOPIC_ID = "topic_id";
            public static final String TOPIC_OBN = "topic_obn";
            public static final String TOTAL_TIME = "total_time";
            public static final String ZIJIAN_STATE = "zijian_state";
        }

        public  String getBookTableName(int i) {
            return String.format(Locale.US, "%s_%02d", new Object[]{TABLE_NAME_BASE, Integer.valueOf(i)});
        }

        public  Uri getBookContentUri(int i) {
            return Contracts.getTableContentUri(Databases.TOPIC_PROBLEM, getBookTableName(i));
        }
    }

    public class TS_NOTICE_ID_USE {
        public  final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.EVERY_NOTICE, TABLE_NAME);
        public static final String TABLE_NAME = "ts_notice_id_use";

        public class Columns {
            public static final String NTF_ID = "ntf_id";
            public static final String READ_STATUS = "read_status";
        }
    }

    public class TS_OFFLINE_DOTOPIC_SYNC_IDS {
        private static final String TABLE_NAME_BASE = "ts_offline_dotopic_sync_ids";

        public class Columns {
            public static final String DO_NUM = "do_num";
            public static final String ERR_NUM = "err_num";
            public static final String IS_TODAY_NEW = "is_today_new";
            public static final String LAST_DO_TIME = "last_do_time";
            public static final String SYNC_STATE = "sync_state";
            public static final String TOPIC_DAY = "topic_day";
            public static final String TOPIC_ID = "topic_id";
            public static final String TOPIC_OBN = "topic_obn";
            public static final String TOTAL_TIME = "total_time";
        }

        public  String getBookTableName(int i) {
            return String.format(Locale.US, "%s_%02d", new Object[]{TABLE_NAME_BASE, Integer.valueOf(i)});
        }

        public  Uri getBookContentUri(int i) {
            return Contracts.getTableContentUri(Databases.TOPIC_PROBLEM, getBookTableName(i));
        }
    }

    public class TS_OFFLINE_SYNC_STATE {
        public  final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.TOPIC_PROBLEM, TABLE_NAME);
        public static final String TABLE_NAME = "ts_offline_sync_state";

        public class Columns {
            public static final String BOOK_ID = "book_id";
            public static final String COMBO_COUNT = "combo_count";
            public static final String MAX_COMBO_COUNT = "max_combo_count";
            public static final String RUN_TIME = "run_time";
            public static final String WANT_MORE_COUNT = "want_more_count";
        }
    }

    public class TS_OPEN_EARS_MATCH_INFO {
        public  final Uri CONTENT_URI = Contracts.getTableContentUri("jiong100openears.sqlite", TABLE_NAME);
        public static final String TABLE_NAME = "ts_open_ears_match_info";

        public class Columns {
            public static final String BOOK_ID = "book_id";
            public static final String FILE_NAME = "file_name";
            public static final String MAX_ID = "max_id";
            public static final String MIN_ID = "min_id";
        }
    }

    public class TS_TOPIC_DATA_ALL {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.JIONGJI_DAILY, TABLE_NAME);
        public static final String TABLE_NAME = "ts_topic_data_all";

        public class Columns {
            public static final String TOPIC_ACCENT = "topic_accent";
            public static final String TOPIC_ATTR_OPTIONS = "topic_attr_options";
            public static final String TOPIC_COMPLETE = "topic_complete";
            public static final String TOPIC_EXAMPLE = "topic_example";
            public static final String TOPIC_EXAMPLE_AUDIO_URL = "topic_example_audio_url";
            public static final String TOPIC_EXAMPLE_INTERPRET = "topic_example_interpret";
            public static final String TOPIC_ID = "topic_id";
            public static final String TOPIC_IMAGE = "topic_image";
            public static final String TOPIC_IMAGE_SIZE = "topic_image_size";
            public static final String TOPIC_READ = "topic_read";
            public static final String TOPIC_THUMBNAIL = "topic_thumbnail";
            public static final String TOPIC_THUMBNAIL_SIZE = "topic_thumbnail_size";
            public static final String TOPIC_UPDATETIME = "topic_updatetime";
            public static final String TOPIC_WORD = "topic_word";
            public static final String TOPIC_WORD_AUDIO_URL = "topic_word_audio_url";
            public static final String TOPIC_WORD_INTERPRET = "topic_word_interpret";
            public static final String TOPIC_WORD_TRANSFROM = "topic_word_transfrom";
        }
    }

    public class TS_TOPIC_DATA_INFO {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.JIONGJI_DAILY, TABLE_NAME);
        public static final String TABLE_NAME = "ts_topic_data_info";

        public class Columns {
            public static final String DEFORMATION_DESC = "deformation_desc";
            public static final String DEFORMATION_IMG = "deformation_img";
            public static final String EXAMPLE_KEYWORD = "example_keyword";
            public static final String MEAN_EN = "mean_en";
            public static final String SHORT_PHRASE = "short_phrase";
            public static final String SHOT_PHRASE = "shot_phrase";
            public static final String TOPIC_ID = "topic_id";
            public static final String UPDATE_FLAG = "update_flag";
            public static final String WORD_ETYMA = "word_etyma";
            public static final String WORD_VARIANTS = "word_variants";
        }
    }

    public class TS_TOPIC_WORD_DISCRIMINATE {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.JIONG_DAILY_DICTIONARY, TABLE_NAME);
        public static final String TABLE_NAME = "ts_topic_word_discriminate";

        public class Columns {
            public static final String GROUP_ID = "group_id";
            public static final String SENTENCE_1 = "sentence_1";
            public static final String SENTENCE_TIP1 = "sentence_tip1";
            public static final String SENTENCE_TIP2 = "sentence_tip2";
            public static final String SENTENCE_TIP3 = "sentence_tip3";
            public static final String TYPE = "type";
            public static final String WORD_1 = "word_1";
            public static final String WORD_2 = "word_2";
            public static final String WORD_ANSWER = "word_answer";
            public static final String WORD_DISCRIMINATE_EXPLAIN1 = "word_discriminate_explain1";
            public static final String WORD_DISCRIMINATE_EXPLAIN2 = "word_discriminate_explain2";
            public static final String WORD_DISCRIMINATE_EXPLAIN3 = "word_discriminate_explain3";
            public static final String WORD_DISCRIMINATE_EXPLAIN4 = "word_discriminate_explain4";
            public static final String WORD_DISCRIMINATE_EXPLAIN5 = "word_discriminate_explain5";
            public static final String WORD_DISCRIMINATE_EXPLAIN6 = "word_discriminate_explain6";
            public static final String WORD_DISCRIMINATE_EXPLAIN7 = "word_discriminate_explain7";
            public static final String WORD_DISCRIMINATE_EXPLAIN8 = "word_discriminate_explain8";
            public static final String WORD_ID = "word_id";
        }
    }

    public class TS_WORD_RADIO_HALF_TIME {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.WORD_RADIO_TOPIC, TABLE_NAME);
        public static final String TABLE_NAME = "ts_word_radio_half_time";

        public class Columns {
            public static final String WS_AUDIO = "ws_audio";
            public static final String WS_BOOKID = "ws_bookid";
            public static final String WS_COMPLETE = "ws_complete";
            public static final String WS_ID = "ws_id";
            public static final String WS_UPDATE_TIME = "ws_update_time";
            public static final String WS_WORD_TV = "ws_word_tv";
        }
    }

    public class TS_WORD_STATION_DATA_ALL {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.WORD_RADIO_TOPIC, TABLE_NAME);
        public static final String TABLE_NAME = "ts_word_station_data_all";

        public class Columns {
            public static final String TV_VEDIO_PATH = "tv_vedio_path";
            public static final String WS_AUDIO = "ws_audio";
            public static final String WS_AUDIO_HIGH = "ws_audio_high";
            public static final String WS_COMPLETE = "ws_complete";
            public static final String WS_DESC = "ws_desc";
            public static final String WS_ID = "ws_id";
            public static final String WS_READ = "ws_read";
            public static final String WS_SENTENCE = "ws_sentence";
            public static final String WS_UPDATE_TIME = "ws_update_time";
            public static final String WS_WORD = "ws_word";
            public static final String WS_WORD_CN = "ws_word_cn";
            public static final String WS_WORD_TYPE = "ws_word_type";
        }
    }

    public class WORD_LOCK_REVIEW_TB {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.WORD_LOCK, TABLE_NAME);
        public static final String TABLE_NAME = "tb_review";

        public class Columns {
            public static final String TOPIC_ID = "topic_id";
        }
    }

    public class WORD_LOCK_SEARCH_HISTORY_TB {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.WORD_LOCK, TABLE_NAME);
        public static final String TABLE_NAME = "tb_search_history";

        public class Columns {
            public static final String ACCENT = "accent";
            public static final String AUDIO = "audio";
            public static final String BOOK_ID = "book_id";
            public static final String CNEXAMPLE = "cnexample";
            public static final String CNMEAN = "cnmean";
            public static final String ENMEAN = "enmean";
            public static final String EXAMPLE = "example";
            public static final String FLAG = "flag";
            public static final String IMAGE = "image";
            public static final String ROOT = "root";
            public static final String TIME = "time";
            public static final String TOPIC_ID = "topic_id";
            public static final String VIVID = "vivid";
            public static final String WORD = "word";
            public static final String ZPKPATH = "zpk_path";
        }
    }

    public class WORD_LOCK_TODAY_REVIEW_TB {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.WORD_LOCK, TABLE_NAME);
        public static final String TABLE_NAME = "tb_review_today";

        public class Columns {
            public static final String TOPIC_ID = "topic_id";
        }
    }

    public class WORD_MEDIA_BOOK_TB {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.WORD_MEDIA, "tb_word_media_book");
        public static final String TABLE_NAME = "tb_word_media_book";

        public class Columns {
            public static final String LOADED_BOOK_ID = "loaded_book_id";
        }
    }

    public class WORD_MEDIA_MID_TB {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.WORD_MEDIA, "tb_word_media_mid");
        public static final String TABLE_NAME = "tb_word_media_mid";

        public class Columns {
            public static final String PATH = "path";
            public static final String TYPE = "type";
        }
    }

    public class WORD_MEDIA_MID_UPD_TB {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.WORD_MEDIA, "tb_word_media_mid_update");
        public static final String TABLE_NAME = "tb_word_media_mid_update";

        public class Columns {
            public static final String FM_MID_UPDATE = "fm_mid_update";
            public static final String TV_MID_UPDATE = "tv_mid_update";
        }
    }

    public class WORD_MEDIA_TB {
        public static final String TABLE_NAME_BASE = "tb_word_media";

        public class Columns {
            public static final String AMR_AUDIO_PATH = "amr_audio_path";
            public static final String FM_UPD_AT = "fm_updated_at";
            public static final String M4A_AUDIO_PATH = "m4a_audio_path";
            public static final String TOPIC_ID = "topic_id";
            public static final String TOPIC_SENTENCE = "topic_sentence";
            public static final String TOPIC_WORD = "topic_word";
            public static final String TOPIC_WORD_CNMEAN = "topic_word_cnmean";
            public static final String TOPIC_WORD_TYPE = "topic_word_type";
            public static final String TV_PATH = "tv_path";
            public static final String TV_SNAPSHOT_PATH = "tv_snapshot_path";
            public static final String TV_UPD_AT = "tv_updated_at";
        }

        public  String getTableName(int i) {
            return String.format(Locale.US, "%s_%02d", new Object[]{TABLE_NAME_BASE, Integer.valueOf(i)});
        }

        public  Uri getContentUri(int i) {
            return Contracts.getTableContentUri(Databases.WORD_MEDIA, getTableName(i));
        }
    }

    public class WORD_MEDIA_UPD_TB {
        public static final String TABLE_NAME_BASE = "tb_word_media_update";

        public class Columns {
            public static final String FM_UPD_AT = "fm_updated_at";
            public static final String TOPIC_ID = "word_topic_id";
            public static final String TV_UPD_AT = "tv_updated_at";
        }

        public  String getTableName(int i) {
            return String.format(Locale.US, "%s_%02d", new Object[]{TABLE_NAME_BASE, Integer.valueOf(i)});
        }

        public  Uri getContentUri(int i) {
            return Contracts.getTableContentUri(Databases.WORD_MEDIA, getTableName(i));
        }
    }

    public class ZBOOKFINISHINFO {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.DO_EXAMPLE_INFO, TABLE_NAME);
        public static final String TABLE_NAME = "ZBOOKFINISHINFO";

        public class Columns {
            public static final String BOOK_ID = "BOOK_ID";
            public static final String DAILY_NEW_WORD = "DAILY_NEW_WORD";
            public static final String DAKA_DAYS = "DAKA_DAYS";
            public static final String IS_CURRENT_SELECT_BOOK = "IS_CURRENT_SELECT_BOOK";
            public static final String LAST_DAKA_TIMES = "LAST_DAKA_TIMES";
            public static final String LAST_DANCILIANG_FINISH_WORD_COUNT = "LAST_DANCILIANG_FINISH_WORD_COUNT";
            public static final String LAST_DANCILIANG_TIMES = "LAST_DANCILIANG_TIMES";
            public static final String MAX_OFFLINE_DAYS = "MAX_OFFLINE_DAYS";
            public static final String MAX_OFFLINE_PROBLEM_COUNT = "MAX_OFFLINE_PROBLEM_COUNT";
            public static final String SYNC_STATE = "sync_state";
            public static final String WORD_FINISH_COUNT = "WORD_FINISH_COUNT";
        }
    }

    public class ZBOOKRESOURCE {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.DO_EXAMPLE_INFO, TABLE_NAME);
        public static final String TABLE_NAME = "ZBOOKRESOURCE";

        public class Columns {
            public static final String BOOKNAME = "BOOKNAME";
            public static final String BOOK_ID = "BOOK_ID";
            public static final String DESCRIPTION = "description";
            public static final String ROADMAP_VER = "roadmap_ver";
            public static final String SETDATETIME = "SETDATETIME";
            public static final String UPDATETIME = "UPDATETIME";
            public static final String UPDATE_DATA = "update_data";
            public static final String UPDATE_LOCAL_DATA = "update_local_data";
            public static final String WORD_COUNT = "WORD_COUNT";
            public static final String ZWORD_RADIO_UPDATE_TIME = "ZWORD_RADIO_UPDATE_TIME";
        }
    }

    public class ZBOOKWORDINFO {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.DO_EXAMPLE_INFO, TABLE_NAME);
        public static final String TABLE_NAME = "ZBOOKWORDINFO";

        public class Columns {
            public static final String ALL_WORD = "ALL_WORD";
            public static final String BOOK_ID = "BOOK_ID";
            public static final String TYPE = "TYPE";
            public static final String UPDATETIME = "UPDATETIME";
        }
    }

    public class ZCOMBORECORD {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.TOPIC_WORD_MEAN, TABLE_NAME);
        public static final String TABLE_NAME = "ZCOMBORECORD";

        public class Columns {
            public static final String ZDESCRIPTION = "ZDESCRIPTION";
            public static final String ZNAME = "ZNAME";
            public static final String ZSHOWTIME = "ZSHOWTIME";
            public static final String ZTYPE_NAME = "ZTYPE_NAME";
            public static final String ZUPDATE_TIME = "ZUPDATE_TIME";
            public static final String ZVOICE_NAME = "ZVOICE_NAME";
        }
    }

    public class ZLOGINUSER {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.USER, TABLE_NAME);
        public static final String TABLE_NAME = "ZLOGINUSER";

        public class Columns {
            public static final String USER = "USER";
            public static final String ZLOGINTYPE = "ZLOGINTYPE";
            public static final String ZPASSWORD = "ZPASSWORD";
            public static final String ZPASSWORDMD5 = "ZPASSWORDMD5";
            public static final String ZPROFILEIMAGE = "ZPROFILEIMAGE";
            public static final String ZSAVESTATUS = "ZSAVESTATUS";
            public static final String ZSESSION = "ZSESSION";
            public static final String ZSEX = "ZSEX";
            public static final String ZUSERNICKNAME = "ZUSERNICKNAME";
        }
    }

    public class ZSHORTPHRASETOPICRESOURCE {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.TOPIC, TABLE_NAME);
        public static final String TABLE_NAME = "ZSHORTPHRASETOPICRESOURCE";

        public class Columns {
            public static final String TOPIC = "TOPIC";
            public static final String ZEXAMINFO = "ZEXAMINFO";
            public static final String ZEXPLAIN = "ZEXPLAIN";
            public static final String ZEXPLAINCIDEO = "ZEXPLAINCIDEO";
            public static final String ZIMAGEPATH = "ZIMAGEPATH";
            public static final String ZSENTENCE = "ZSENTENCE";
            public static final String ZSENTENCE2 = "ZSENTENCE2";
            public static final String ZSENTENCEVIDEO = "ZSENTENCEVIDEO";
            public static final String ZSENTENCEVIDEO2 = "ZSENTENCEVIDEO2";
            public static final String ZSENTENCEWORDHIGHLIGHT = "ZSENTENCEWORDHIGHLIGHT";
            public static final String ZSENTENCEWORDHIGHLIGHT2 = "ZSENTENCEWORDHIGHLIGHT2";
            public static final String ZSENTENCE_TRANS = "ZSENTENCE_TRANS";
            public static final String ZSENTENCE_TRANS2 = "ZSENTENCE_TRANS2";
            public static final String ZSIMILAR_HIGHLIGHT = "ZSIMILAR_HIGHLIGHT";
            public static final String ZWORD = "ZWORD";
            public static final String ZWORDMEAN = "ZWORDMEAN";
            public static final String ZWORDVARIANTS = "ZWORDVARIANTS";
            public static final String ZWORDVIDEO = "ZWORDVIDEO";
        }
    }

    public class ZTOPICREDOEXAMPLE {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.DO_EXAMPLE_INFO, TABLE_NAME);
        public static final String TABLE_NAME = "ZTOPICREDOEXAMPLE";

        public class Columns {
            public static final String DODATEDATE = "DODATEDATE";
            public static final String ERRORCOUNT = "ERRORCOUNT";
            public static final String TOPIC = "TOPIC";
        }
    }

    public class ZTOPICRESOURCE {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.TOPIC, TABLE_NAME);
        public static final String TABLE_NAME = "ZTOPICRESOURCE";

        public class Columns {
            public static final String TOPIC = "TOPIC";
            public static final String UPDATEDATE = "UPDATEDATE";
            public static final String ZIMAGEPATH = "ZIMAGEPATH";
            public static final String ZPHONETIC = "ZPHONETIC";
            public static final String ZSENTENCE = "ZSENTENCE";
            public static final String ZSENTENCEVIDEO = "ZSENTENCEVIDEO";
            public static final String ZTHUMBIMAGEPATH = "ZTHUMBIMAGEPATH";
            public static final String ZWORD = "ZWORD";
            public static final String ZWORDMEAN = "ZWORDMEAN";
            public static final String ZWORDVARIANTS = "ZWORDVARIANTS";
            public static final String ZWORDVIDEO = "ZWORDVIDEO";
        }
    }

    public class ZTOPICRESOURCESQLVERSION {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.DO_EXAMPLE_INFO, TABLE_NAME);
        public static final String TABLE_NAME = "ZTOPICRESOURCESQLVERSION";

        public class Columns {
            public static final String SQLLABEL = "SQLLABEL";
        }
    }

    public class ZTOPICRESOURCEWORDEXTRA {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.TOPIC_WORD_MEAN, TABLE_NAME);
        public static final String TABLE_NAME = "ZTOPICRESOURCEWORDEXTRA";

        public class Columns {
            public static final String TOPIC = "TOPIC";
            public static final String UPDATELABEL = "UPDATELABEL";
            public static final String ZDEFORMATION_DESC = "ZDEFORMATION_DESC";
            public static final String ZKEYWORD_VARIANTS = "ZKEYWORD_VARIANTS";
            public static final String ZSENTENCE_TRANS = "ZSENTENCE_TRANS";
            public static final String ZWORDMEAN_EN = "ZWORDMEAN_EN";
            public static final String ZWORD_DEFORMATION_IMG = "ZWORD_DEFORMATION_IMG";
            public static final String ZWORD_ETYMA = "ZWORD_ETYMA";
            public static final String ZWORD_EXAMPLE_KEYWORD = "ZWORD_EXAMPLE_KEYWORD";
        }
    }

    public class ZTOPICRESOURCEWORDMEAN {
        public final Uri CONTENT_URI = Contracts.getTableContentUri(Databases.TOPIC_WORD_MEAN, TABLE_NAME);
        public static final String TABLE_NAME = "ZTOPICRESOURCEWORDMEAN";

        public class Columns {
            public static final String TOPIC = "TOPIC";
            public static final String UPDATEDATE = "UPDATEDATE";
            public static final String ZWORDMEAN = "ZWORDMEAN";
        }
    }

    public static Uri getTableContentUri(String str, String str2) {
//        return BaseUri.buildUpon().appendPath(str).appendPath(str2).build();

        return null;
    }

    public static Uri getRawQueryContentUri(String str, String str2) {
//        return BaseUri.buildUpon().appendPath(str).appendPath(RAW_QUERY).query(str2).build();
        return null;
    }

    public static Uri getRawExecContentUri(String str, String str2) {
//        return BaseUri.buildUpon().appendPath(str).appendPath(RAW_EXEC).query(str2).build();

        return null;
    }

    public static Uri getCallMethodUri(String str, String str2) {
//        Builder appendPath = BaseUri.buildUpon().appendPath(str);
//        if (str2 != null) {
//            appendPath.query(str2);
//        }
//        return appendPath.build();
        return null;
    }
}
