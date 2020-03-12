//package com.baicizhan.main.fragment;
//
//import android.content.Context;
//import android.graphics.drawable.GradientDrawable;
//import android.os.Bundle;
//import android.support.p004v4.app.Fragment;
//import android.support.p004v4.app.FragmentActivity;
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.baicizhan.client.business.util.CollectionUtils;
//import com.baicizhan.client.business.util.CollectionUtils.Mapper;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.handmark.pulltorefresh.library.p057a.C1604j;
//import com.jiongji.andriod.card.R;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//import java.util.Locale;
//import java.util.Map;
//import kankan.wheel.widget.OnWheelChangedListener;
//import kankan.wheel.widget.WheelView;
//import kankan.wheel.widget.p098a.AbstractWheelTextAdapter;
//
//public class SchedulePickerFragment extends Fragment {
//    private static final int[] BAO_STATUS_LIST = {R.drawable.bao_status1_normal_default, R.drawable.bao_status1_normal_default, R.drawable.bao_status3_normal_default, R.drawable.bao_status4_normal_default, R.drawable.bao_status5_normal_default, R.drawable.bao_status6_normal_default, R.drawable.bao_status7_normal_default, R.drawable.bao_status8_normal_default};
//    private static final float ESTIMATE_WORD_COSUME_TIME = 0.66f;
//    public static final String EXTRA_MODE = "mode";
//    public static final String EXTRA_SCHEDULE_DAY_COUNT = "schedule_day_count";
//    public static final String EXTRA_WORD_COUNT = "word_count";
//    public static final int MODE_LEARN = 1;
//    public static final int MODE_REVIEW = 2;
//    static final String TAG = SchedulePickerFragment.class.getSimpleName();
//    private Bundle mArgs;
//    private TextView mDailyConsumeTime;
//    /* access modifiers changed from: private */
//    public AbstractScheduleDataProvider mDataProvider;
//    private OnWheelChangedListener mDayChangeListener = new OnWheelChangedListener() {
//        public void onChanged(WheelView wheelView, int i, int i2) {
//            if (i != i2) {
//                int mappingWordIdx = SchedulePickerFragment.this.mDataProvider.getMappingWordIdx(i2);
//                if (mappingWordIdx != -1) {
//                    SchedulePickerFragment.this.mWordCountPicker.setCurrentItem(mappingWordIdx);
//                }
//                SchedulePickerFragment.this.notifyPickListener();
//            }
//        }
//    };
//    /* access modifiers changed from: private */
//    public ArrayPickerAdapter mDayCountAdapter;
//    /* access modifiers changed from: private */
//    public WheelView mDayCountPicker;
//    private OnPickListener mOnPickListener;
//    private ImageView mStatus;
//    private int mTotalWordCount;
//    private boolean mViewCreated;
//    private OnWheelChangedListener mWordChangeListener = new OnWheelChangedListener() {
//        public void onChanged(WheelView wheelView, int i, int i2) {
//            if (i != i2) {
//                int mappingDayIdx = SchedulePickerFragment.this.mDataProvider.getMappingDayIdx(i2);
//                if (mappingDayIdx != -1) {
//                    SchedulePickerFragment.this.mDayCountPicker.setCurrentItem(mappingDayIdx);
//                }
//                SchedulePickerFragment.this.notifyPickListener();
//            }
//        }
//    };
//    /* access modifiers changed from: private */
//    public ArrayPickerAdapter mWordCountAdapter;
//    /* access modifiers changed from: private */
//    public WheelView mWordCountPicker;
//
//    abstract class AbstractScheduleDataProvider {
//        public static final int INVALID_INDEX = -1;
//        public String mDayFormat;
//        ArrayList<Integer> mDayList = new ArrayList<>();
//        public String mWordFormat;
//        ArrayList<Integer> mWordList = new ArrayList<>();
//
//        public abstract void prepare(int i);
//
//        public AbstractScheduleDataProvider(String str, String str2) {
//            this.mDayFormat = str;
//            this.mWordFormat = str2;
//        }
//
//        public List<String> getDayList() {
//            return CollectionUtils.map((Collection<T>) this.mDayList, (Mapper<T, R>) new Mapper<Integer, String>() {
//                public String map(Integer num) {
//                    return String.format(Locale.CHINA, AbstractScheduleDataProvider.this.mDayFormat, new Object[]{num});
//                }
//            });
//        }
//
//        public List<String> getWordList() {
//            return CollectionUtils.map((Collection<T>) this.mWordList, (Mapper<T, R>) new Mapper<Integer, String>() {
//                public String map(Integer num) {
//                    return String.format(Locale.CHINA, AbstractScheduleDataProvider.this.mWordFormat, new Object[]{num});
//                }
//            });
//        }
//
//        public int indexOfDayCount(int i) {
//            return this.mDayList.indexOf(Integer.valueOf(i));
//        }
//
//        public int indexOfWordCount(int i) {
//            return this.mWordList.indexOf(Integer.valueOf(i));
//        }
//
//        public int getDayCountByIdx(int i) {
//            return ((Integer) this.mDayList.get(i)).intValue();
//        }
//
//        public int getWordCountByIdx(int i) {
//            return ((Integer) this.mWordList.get(i)).intValue();
//        }
//
//        public int getMappingDayIdx(int i) {
//            return -1;
//        }
//
//        public int getMappingWordIdx(int i) {
//            return -1;
//        }
//
//        public void insertData(int i, int i2) {
//        }
//    }
//
//    class ArrayPickerAdapter extends AbstractWheelTextAdapter {
//        private List<String> mItems = Collections.emptyList();
//        private int mNormalColor;
//        private int mSelected = -1;
//        private int mSelectedColor;
//
//        public void update(List<String> list) {
//            this.mItems = list;
//            notifyDataInvalidatedEvent();
//        }
//
//        public void notifySelected(int i) {
//            this.mSelected = i;
//            notifyDataChangedEvent();
//        }
//
//        public ArrayPickerAdapter(Context context) {
//            super(context, R.layout.schedule_date_item, 0);
//            setItemTextResource(R.id.text);
//            this.mSelectedColor = ThemeUtil.getThemeColorWithAttr(context, R.attr.color_progress);
//            this.mNormalColor = ThemeUtil.getThemeColorWithAttr(context, R.attr.color_button_text_mediabar);
//        }
//
//        public View getItem(int i, View view, ViewGroup viewGroup) {
//            View item = super.getItem(i, view, viewGroup);
//            TextView textView = (TextView) item.findViewById(R.id.text);
//            if (i == this.mSelected) {
//                textView.setTextColor(this.mSelectedColor);
//            } else {
//                textView.setTextColor(this.mNormalColor);
//            }
//            return item;
//        }
//
//        public int getItemsCount() {
//            return this.mItems.size();
//        }
//
//        /* access modifiers changed from: protected */
//        public CharSequence getItemText(int i) {
//            return (CharSequence) this.mItems.get(i);
//        }
//    }
//
//    class LearnScheduleDataProvider extends AbstractScheduleDataProvider {
//        private static final int MAX_WORD_COUNT = 1000;
//        private static final int MIN_WORD_COUNT = 5;
//        Map<Integer, Integer> mDay2WordIndex = new ArrayMap();
//        Map<Integer, Integer> mWord2DayIndex = new ArrayMap();
//
//        public LearnScheduleDataProvider(String str, String str2) {
//            super(str, str2);
//        }
//
//        public void insertData(int i, int i2) {
//            this.mWord2DayIndex.put(Integer.valueOf(i2), Integer.valueOf(i));
//            if (!this.mDay2WordIndex.containsKey(Integer.valueOf(i))) {
//                this.mDay2WordIndex.put(Integer.valueOf(i), Integer.valueOf(i2));
//            } else if (i2 < ((Integer) this.mDay2WordIndex.get(Integer.valueOf(i))).intValue()) {
//                this.mDay2WordIndex.put(Integer.valueOf(i), Integer.valueOf(i2));
//            }
//        }
//
//        public void prepare(int i) {
//            int i2;
//            if (i <= 5) {
//                this.mDay2WordIndex.put(Integer.valueOf(1), Integer.valueOf(i));
//                this.mWord2DayIndex.put(Integer.valueOf(i), Integer.valueOf(1));
//            } else {
//                int min = Math.min(i, 1000);
//                int i3 = 5;
//                while (i3 <= min) {
//                    int i4 = i / i3;
//                    if (i % i3 == 0) {
//                        i2 = 0;
//                    } else {
//                        i2 = 1;
//                    }
//                    insertData(i2 + i4, i3);
//                    i3 = getWordCountStep(i3) + i3;
//                }
//                if (!this.mWord2DayIndex.containsKey(Integer.valueOf(min))) {
//                    this.mDay2WordIndex.put(Integer.valueOf(1), Integer.valueOf(min));
//                    this.mWord2DayIndex.put(Integer.valueOf(min), Integer.valueOf(1));
//                }
//            }
//            this.mWordList.addAll(this.mWord2DayIndex.keySet());
//            this.mDayList.addAll(this.mDay2WordIndex.keySet());
//            Collections.sort(this.mWordList);
//            Collections.sort(this.mDayList);
//        }
//
//        private int getWordCountStep(int i) {
//            if (i < 50) {
//                return 5;
//            }
//            if (i < 100) {
//                return 10;
//            }
//            if (i < 400) {
//                return 25;
//            }
//            if (i >= 1000) {
//                return 100;
//            }
//            return 50;
//        }
//
//        public int getMappingDayIdx(int i) {
//            return this.mDayList.indexOf(Integer.valueOf(((Integer) this.mWord2DayIndex.get(Integer.valueOf(((Integer) this.mWordList.get(i)).intValue()))).intValue()));
//        }
//
//        public int getMappingWordIdx(int i) {
//            return this.mWordList.indexOf(Integer.valueOf(((Integer) this.mDay2WordIndex.get(Integer.valueOf(((Integer) this.mDayList.get(i)).intValue()))).intValue()));
//        }
//    }
//
//    public interface OnPickListener {
//        void onPick(int i, int i2, int i3);
//    }
//
//    class ReviewScheduleDataProvider extends AbstractScheduleDataProvider {
//        private static final int MAX_WORD_COUNT = 1000;
//        private static final int MIN_WORD_COUNT = 100;
//        private static final int WORD_COUNT_STEP = 50;
//
//        public ReviewScheduleDataProvider(String str, String str2) {
//            super(str, str2);
//        }
//
//        public void prepare(int i) {
//            for (int i2 = 100; i2 <= 1000; i2 += 50) {
//                this.mWordList.add(Integer.valueOf(i2));
//            }
//            for (int i3 = 1; i3 <= 100; i3++) {
//                this.mDayList.add(Integer.valueOf(i3));
//            }
//        }
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        View inflate = layoutInflater.inflate(R.layout.fragment_schedule_picker, viewGroup, false);
//        FragmentActivity activity = getActivity();
//        GradientDrawable gradientDrawable = new GradientDrawable();
//        gradientDrawable.setShape(0);
//        gradientDrawable.setColor(ThemeUtil.getThemeColorWithAttr(activity, R.attr.color_plan_date_bg));
//        gradientDrawable.setStroke(DisplayUtils.dpToPx(activity, 1.0f), ThemeUtil.getThemeColorWithAttr(activity, R.attr.color_bar_text));
//        gradientDrawable.setCornerRadius((float) DisplayUtils.dpToPx(activity, 4.0f));
//        C1604j.m3631a(inflate.findViewById(R.id.picker_table), gradientDrawable);
//        this.mDailyConsumeTime = (TextView) inflate.findViewById(R.id.daily_consume_time);
//        this.mStatus = (ImageView) inflate.findViewById(R.id.status);
//        this.mDayCountPicker = (WheelView) inflate.findViewById(R.id.day_count_picker);
//        this.mWordCountPicker = (WheelView) inflate.findViewById(R.id.word_count_picker);
//        this.mDayCountPicker.setVisibleItems(7);
//        this.mDayCountPicker.setWheelForeground(R.drawable.wheel_val_holo);
//        this.mDayCountPicker.setDrawShadows(false);
//        this.mDayCountPicker.setClickable(true);
//        this.mWordCountPicker.setVisibleItems(7);
//        this.mWordCountPicker.setWheelForeground(R.drawable.wheel_val_holo);
//        this.mWordCountPicker.setDrawShadows(false);
//        this.mWordCountPicker.setClickable(true);
//        this.mDayCountAdapter = new ArrayPickerAdapter(getActivity());
//        this.mWordCountAdapter = new ArrayPickerAdapter(getActivity());
//        this.mDayCountPicker.setViewAdapter(this.mDayCountAdapter);
//        this.mWordCountPicker.setViewAdapter(this.mWordCountAdapter);
//        return inflate;
//    }
//
//    public void onViewCreated(View view, Bundle bundle) {
//        super.onViewCreated(view, bundle);
//        this.mViewCreated = true;
//        if (getArguments() != null) {
//            updateView(getArguments());
//        }
//        if (this.mArgs != null) {
//            updateView(this.mArgs);
//        }
//    }
//
//    public void updateView(Bundle bundle) {
//        int i;
//        int i2;
//        if (!this.mViewCreated) {
//            this.mArgs = bundle;
//            return;
//        }
//        this.mTotalWordCount = bundle.getInt("word_count");
//        if (this.mTotalWordCount != 0) {
//            if (this.mDayChangeListener != null) {
//                this.mDayCountPicker.mo18387b(this.mDayChangeListener);
//            }
//            if (this.mWordChangeListener != null) {
//                this.mWordCountPicker.mo18387b(this.mWordChangeListener);
//            }
//            int i3 = bundle.getInt(EXTRA_MODE, 1);
//            if (i3 == 1) {
//                this.mDataProvider = new LearnScheduleDataProvider("%d天", "%d个单词");
//            } else if (i3 == 2) {
//                this.mDataProvider = new ReviewScheduleDataProvider("%d天", "复习%d个单词");
//            }
//            int i4 = bundle.getInt(EXTRA_SCHEDULE_DAY_COUNT);
//            if (i4 > 0) {
//                int i5 = this.mTotalWordCount / i4;
//                if (this.mTotalWordCount % i4 > 0) {
//                    i2 = 1;
//                } else {
//                    i2 = 0;
//                }
//                i = i2 + i5;
//                this.mDataProvider.insertData(i4, i);
//            } else {
//                i = 0;
//            }
//            this.mDataProvider.prepare(this.mTotalWordCount);
//            this.mDayCountAdapter.update(this.mDataProvider.getDayList());
//            this.mWordCountAdapter.update(this.mDataProvider.getWordList());
//            if (i3 == 1) {
//                if (i <= 0) {
//                    i = 25;
//                }
//                int max = Math.max(0, this.mDataProvider.indexOfWordCount(i));
//                this.mWordCountPicker.setCurrentItem(max);
//                int mappingDayIdx = this.mDataProvider.getMappingDayIdx(max);
//                if (mappingDayIdx != -1) {
//                    this.mDayCountPicker.setCurrentItem(mappingDayIdx);
//                }
//            } else if (i3 == 2) {
//                this.mDayCountPicker.setCurrentItem(0);
//                this.mWordCountPicker.setCurrentItem(0);
//            }
//            this.mDayCountPicker.mo18385a(this.mDayChangeListener);
//            this.mWordCountPicker.mo18385a(this.mWordChangeListener);
//            notifyPickListener();
//        }
//    }
//
//    public void setOnPickListener(OnPickListener onPickListener) {
//        this.mOnPickListener = onPickListener;
//    }
//
//    /* access modifiers changed from: private */
//    public void notifyPickListener() {
//        int i;
//        final int currentItem = this.mDayCountPicker.getCurrentItem();
//        final int currentItem2 = this.mWordCountPicker.getCurrentItem();
//        int dayCountByIdx = this.mDataProvider.getDayCountByIdx(currentItem);
//        int wordCountByIdx = this.mDataProvider.getWordCountByIdx(currentItem2);
//        this.mWordCountPicker.post(new Runnable() {
//            public void run() {
//                SchedulePickerFragment.this.mWordCountAdapter.notifySelected(currentItem2);
//            }
//        });
//        this.mDayCountPicker.post(new Runnable() {
//            public void run() {
//                SchedulePickerFragment.this.mDayCountAdapter.notifySelected(currentItem);
//            }
//        });
//        if (this.mWordCountAdapter.getItemsCount() > 0) {
//            i = (currentItem2 * 8) / this.mWordCountAdapter.getItemsCount();
//        } else {
//            i = 0;
//        }
//        int ceil = (int) Math.ceil((double) (((float) wordCountByIdx) * ESTIMATE_WORD_COSUME_TIME));
//        this.mDailyConsumeTime.setText(String.format(Locale.CHINA, "每天大约花%d分钟", new Object[]{Integer.valueOf(ceil)}));
//        this.mStatus.setImageResource(BAO_STATUS_LIST[i]);
//        if (this.mOnPickListener != null) {
//            this.mOnPickListener.onPick(this.mTotalWordCount, dayCountByIdx, wordCountByIdx);
//        }
//    }
//}
