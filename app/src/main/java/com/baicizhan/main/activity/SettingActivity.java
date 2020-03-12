//package com.baicizhan.main.activity;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.CompoundButton;
//import android.widget.CompoundButton.OnCheckedChangeListener;
//import android.widget.ListView;
//import android.widget.TextView;
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.client.wordlock.service.WordLockDaemon;
//import com.baicizhan.client.wordlock.service.WordLockService;
//import com.baicizhan.client.wordlock.setting.Settings;
//import com.jiongji.andriod.card.R;
//import com.kyleduo.switchbutton.SwitchButton;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class SettingActivity extends Activity implements OnClickListener {
//    /* access modifiers changed from: private */
//    public AudioPlayer mAudioPlayer;
//    private SettingAdapter mSettingAdapter;
//    private List<SettingItem> mSettingItems = new ArrayList(6);
//
//    class NightModeSwitchListener implements OnCheckedChangeListener {
//        private NightModeSwitchListener() {
//        }
//
//        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
//            compoundButton.post(new Runnable() {
//                public void run() {
//                    ThemeUtil.setThemeOnActivityCreate(SettingActivity.this);
//                    SettingActivity.this.setContentView(R.layout.activity_setting);
//                    SettingActivity.this.initViews();
//                    SettingActivity.this.updateSettings();
//                }
//            });
//        }
//    }
//
//    class SettingAdapter extends BaseAdapter {
//        List<SettingItem> mItems = Collections.emptyList();
//
//        class ViewHolder {
//            SettingItem item;
//            TextView label;
//            SwitchButton switcher;
//            TextView tip;
//
//            ViewHolder() {
//            }
//        }
//
//        public void update(List<SettingItem> list) {
//            this.mItems = list;
//            notifyDataSetChanged();
//        }
//
//        public int getCount() {
//            return this.mItems.size();
//        }
//
//        public Object getItem(int i) {
//            return this.mItems.get(i);
//        }
//
//        public long getItemId(int i) {
//            return (long) i;
//        }
//
//        public View getView(int i, View view, ViewGroup viewGroup) {
//            final ViewHolder viewHolder;
//            if (view == null) {
//                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.setting_item_view, viewGroup, false);
//                viewHolder = new ViewHolder();
//                viewHolder.label = (TextView) view.findViewById(R.id.label);
//                viewHolder.tip = (TextView) view.findViewById(R.id.tip);
//                viewHolder.switcher = (SwitchButton) view.findViewById(R.id.switcher);
//                view.setTag(viewHolder);
//            } else {
//                viewHolder = (ViewHolder) view.getTag();
//            }
//            SettingItem settingItem = (SettingItem) getItem(i);
//            viewHolder.item = settingItem;
//            viewHolder.label.setText(settingItem.label);
//            if (!TextUtils.isEmpty(settingItem.tip)) {
//                viewHolder.tip.setText(settingItem.tip);
//            } else {
//                viewHolder.tip.setText("");
//            }
//            viewHolder.switcher.setChecked(settingItem.isChecked);
//            viewHolder.switcher.setOnCheckedChangeListener(new OnCheckedChangeListener() {
//                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
//                    PropertyHelper.put(viewHolder.item.prefKey, z);
//                    viewHolder.item.isChecked = z;
//                    if (viewHolder.item.listener != null) {
//                        viewHolder.item.listener.onCheckedChanged(compoundButton, z);
//                    }
//                }
//            });
//            return view;
//        }
//    }
//
//    class SettingItem {
//        public boolean isChecked;
//        public String label;
//        public OnCheckedChangeListener listener;
//        public String prefKey;
//        public String tip;
//
//        public SettingItem(String str, String str2, OnCheckedChangeListener onCheckedChangeListener, String str3, boolean z) {
//            this.label = str;
//            this.tip = str2;
//            this.listener = onCheckedChangeListener;
//            this.prefKey = str3;
//            this.isChecked = z;
//        }
//    }
//
//    class WordLockSwitchListener implements OnCheckedChangeListener {
//        private WordLockSwitchListener() {
//        }
//
//        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
//            Settings.setWordLockscreenEnabled(z);
//            if (z) {
//                Log.d("whiz", "wordlock daemon start from settings");
//                WordLockService.startForRefreshTopN(SettingActivity.this, null);
//                WordLockDaemon.start(SettingActivity.this);
//                return;
//            }
//            WordLockDaemon.stop(SettingActivity.this);
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(R.layout.activity_setting);
//            this.mAudioPlayer = new AudioPlayer(this);
//            initViews();
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onDestroy() {
//        super.onDestroy();
//        if (this.mAudioPlayer != null) {
//            this.mAudioPlayer.destroy();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void initViews() {
//        findViewById(R.id.back).setOnClickListener(this);
//        ListView listView = (ListView) findViewById(R.id.settings);
//        this.mSettingAdapter = new SettingAdapter();
//        listView.setAdapter(this.mSettingAdapter);
//    }
//
//    /* access modifiers changed from: private */
//    public void updateSettings() {
//        initSettings();
//        this.mSettingAdapter.update(this.mSettingItems);
//    }
//
//    public void onResume() {
//        super.onResume();
//        UMStats.traceOnActivityResume(this);
//        updateSettings();
//    }
//
//    public void onPause() {
//        super.onPause();
//        UMStats.traceOnActivityPause(this);
//    }
//
//    public void finish() {
//        setResult(3);
//        super.finish();
//    }
//
//    private void initSettings() {
//        this.mSettingItems.clear();
//        this.mSettingItems.add(new SettingItem("百词斩锁屏", null, new WordLockSwitchListener(), PropertyHelper.WORD_LOCK, Settings.isWordLockscreenEnabled()));
//        this.mSettingItems.add(new SettingItem("包大人模式", "(也就是夜间模式啦)", new NightModeSwitchListener(), PropertyHelper.NIGHT_MODE, PropertyHelper.getBoolean(PropertyHelper.NIGHT_MODE)));
//        this.mSettingItems.add(new SettingItem("显示图片对应中文", null, null, PropertyHelper.SHOW_IMAGE_MEAN, PropertyHelper.getBoolean(PropertyHelper.SHOW_IMAGE_MEAN)));
//        this.mSettingItems.add(new SettingItem("竖屏", "(只支持单词做题界面)", null, "portrait_mode", PropertyHelper.getBoolean("portrait_mode")));
//        this.mSettingItems.add(new SettingItem("操作音效", "(包含正确错误提示音等)", new OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
//                if (z) {
//                    SettingActivity.this.mAudioPlayer.newPlayRaw(R.raw.answer_right);
//                }
//            }
//        }, PropertyHelper.SOUND_EFFECT, PropertyHelper.getBoolean(PropertyHelper.SOUND_EFFECT, true)));
//        this.mSettingItems.add(new SettingItem("例句翻译默认显示", null, null, PropertyHelper.SHOW_SENTENCE_TRANSLATION, PropertyHelper.getBoolean(PropertyHelper.SHOW_SENTENCE_TRANSLATION, true)));
//    }
//
//    public void onClick(View view) {
//        if (view.getId() == R.id.back) {
//            finish();
//        }
//    }
//}
