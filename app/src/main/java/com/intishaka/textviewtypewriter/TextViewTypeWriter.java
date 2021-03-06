package com.intishaka.textviewtypewriter;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class TextViewTypeWriter extends AppCompatTextView {

    private CharSequence mText;
    private int mIndex;
    private long mDelay = 500; //Default 500ms delay


    public TextViewTypeWriter(Context context) {
        super(context);
    }

    public TextViewTypeWriter(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private final Handler mHandler = new Handler();
    private final Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(mText.subSequence(0, mIndex++));
            if(mIndex <= mText.length()) {
                mHandler.postDelayed(characterAdder, mDelay);
            }
        }
    };

    public void animateText(CharSequence text) {
        mText = text;
        mIndex = 0;

        setText("");
        mHandler.removeCallbacks(characterAdder);
        mHandler.postDelayed(characterAdder, mDelay);
    }

    public void setCharacterDelay(long millis) {
        mDelay = millis;
    }
}
