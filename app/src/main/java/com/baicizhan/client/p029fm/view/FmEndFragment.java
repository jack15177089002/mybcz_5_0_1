package com.baicizhan.client.p029fm.view;

import android.os.Bundle;
//import android.support.p004v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
//import com.baicizhan.client.p029fm.R;
import androidx.fragment.app.Fragment;

import com.baicizhan.client.p029fm.eventbus.FmEvents.ListenMoreEvent;
import com.jiongji.andriod.card.R;
//import p000a.p001a.p002a.EventBus;

/* renamed from: com.baicizhan.client.fm.view.FmEndFragment */
public class FmEndFragment extends Fragment implements IFragmentUpdator {
    public static FmEndFragment createInstance() {
        return new FmEndFragment();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fm_line_item_end, viewGroup, false);
        viewGroup2.findViewById(R.id.fm_end_listen_more).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
//                EventBus.m0a().mo9c((Object) new ListenMoreEvent());
            }
        });
        return viewGroup2;
    }

    public void setEnabled(boolean z) {
    }
}
