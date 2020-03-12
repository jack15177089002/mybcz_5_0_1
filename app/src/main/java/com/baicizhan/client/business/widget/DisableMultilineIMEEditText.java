package com.baicizhan.client.business.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

public class DisableMultilineIMEEditText extends EditText {
    public DisableMultilineIMEEditText(Context context) {
        super(context);
    }

    public DisableMultilineIMEEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DisableMultilineIMEEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        editorInfo.imeOptions ^= 1073741824;
        return onCreateInputConnection;
    }
}
