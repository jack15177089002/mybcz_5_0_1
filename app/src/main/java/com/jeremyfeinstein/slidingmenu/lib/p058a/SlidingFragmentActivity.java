package com.jeremyfeinstein.slidingmenu.lib.p058a;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
//import android.support.p004v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

import androidx.fragment.app.FragmentActivity;

import com.jeremyfeinstein.slidingmenu.lib.C1640i;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/* renamed from: com.jeremyfeinstein.slidingmenu.lib.a.c */
public class SlidingFragmentActivity extends FragmentActivity {
    private SlidingActivityHelper mHelper;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHelper = new SlidingActivityHelper(this);
        SlidingActivityHelper aVar = this.mHelper;
        aVar.f3931b = (SlidingMenu) LayoutInflater.from(aVar.f3930a).inflate(C1640i.slidingmenumain, null);
    }

    public void onPostCreate(Bundle bundle) {
        boolean z;
        int i = 1;
        boolean z2 = false;
        super.onPostCreate(bundle);
        SlidingActivityHelper aVar = this.mHelper;
        if (aVar.f3933d == null || aVar.f3932c == null) {
            throw new IllegalStateException("Both setBehindContentView must be called in onCreate in addition to setContentView.");
        }
        aVar.f3935f = true;
        SlidingMenu slidingMenu = aVar.f3931b;
        Activity activity = aVar.f3930a;
        if (aVar.f3936g) {
            i = 0;
        }
        slidingMenu.mo16502a(activity, i);
        if (bundle != null) {
            z2 = bundle.getBoolean("SlidingActivityHelper.open");
            z = bundle.getBoolean("SlidingActivityHelper.secondary");
        } else {
            z = false;
        }
        new Handler().post(new C1633b(aVar, z2, z));
    }

    public View findViewById(int i) {
        View findViewById = super.findViewById(i);
        if (findViewById != null) {
            return findViewById;
        }
        SlidingActivityHelper aVar = this.mHelper;
        if (aVar.f3931b != null) {
            View findViewById2 = aVar.f3931b.findViewById(i);
            if (findViewById2 != null) {
                return findViewById2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        SlidingActivityHelper aVar = this.mHelper;
        bundle.putBoolean("SlidingActivityHelper.open", aVar.f3931b.mo16504a());
        bundle.putBoolean("SlidingActivityHelper.secondary", aVar.f3931b.f3896a.getCurrentItem() == 2);
    }

    public void setContentView(int i) {
        setContentView(getLayoutInflater().inflate(i, null));
    }

    public void setContentView(View view) {
        setContentView(view, new LayoutParams(-1, -1));
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        SlidingActivityHelper aVar = this.mHelper;
        if (!aVar.f3934e) {
            aVar.f3932c = view;
        }
    }

    public void setBehindContentView(int i) {
        setBehindContentView(getLayoutInflater().inflate(i, null));
    }

    public void setBehindContentView(View view) {
        setBehindContentView(view, new LayoutParams(-1, -1));
    }

    public void setBehindContentView(View view, LayoutParams layoutParams) {
        SlidingActivityHelper aVar = this.mHelper;
        aVar.f3933d = view;
        aVar.f3931b.setMenu(aVar.f3933d);
    }

    public SlidingMenu getSlidingMenu() {
        return this.mHelper.f3931b;
    }

    public void toggle() {
        SlidingMenu slidingMenu = this.mHelper.f3931b;
        if (slidingMenu.mo16504a()) {
            slidingMenu.mo16506c(true);
        } else {
            slidingMenu.mo16503a(true);
        }
    }

    public void showContent() {
        this.mHelper.mo16581a();
    }

    public void showMenu() {
        this.mHelper.f3931b.mo16503a(true);
    }

    public void showSecondaryMenu() {
        this.mHelper.f3931b.mo16505b(true);
    }

    public void setSlidingActionBarEnabled(boolean z) {
        SlidingActivityHelper aVar = this.mHelper;
        if (aVar.f3935f) {
            throw new IllegalStateException("enableSlidingActionBar must be called in onCreate.");
        }
        aVar.f3936g = z;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean z;
        SlidingActivityHelper aVar = this.mHelper;
        if (i != 4 || !aVar.f3931b.mo16504a()) {
            z = false;
        } else {
            aVar.mo16581a();
            z = true;
        }
        if (z) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }
}
