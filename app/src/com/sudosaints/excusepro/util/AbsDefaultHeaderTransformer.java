package com.sudosaints.excusepro.util;

import com.sudosaints.excusepro.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import uk.co.senab.actionbarpulltorefresh.library.DefaultHeaderTransformer;

public class AbsDefaultHeaderTransformer extends DefaultHeaderTransformer {

    @Override
    protected Drawable getActionBarBackground(Context context) {
        // Super handles ICS+ anyway...
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            return super.getActionBarBackground(context);
        }

        // Need to get resource id of style pointed to from actionBarStyle
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.actionBarStyle, outValue, true);
        // Now get action bar style values...
        TypedArray abStyle = context.getTheme().obtainStyledAttributes(outValue.resourceId,
                R.styleable.SherlockActionBar);
        try {
            return abStyle.getDrawable(R.styleable.SherlockActionBar_background);
        } finally {
            abStyle.recycle();
        }
    }

    @Override
    protected int getActionBarSize(Context context) {
        // Super handles ICS+ anyway...
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            return super.getActionBarSize(context);
        }

        TypedArray values = context.getTheme()
                .obtainStyledAttributes(R.styleable.SherlockTheme);
        try {
            return values.getDimensionPixelSize(R.styleable.SherlockTheme_actionBarSize, 0);
        } finally {
            values.recycle();
        }
    }

    @Override
    protected int getActionBarTitleStyle(Context context) {
        // Super handles ICS+ anyway...
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            return super.getActionBarTitleStyle(context);
        }

        // Need to get resource id of style pointed to from actionBarStyle
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.actionBarStyle, outValue, true);
        // Now get action bar style values...
        TypedArray abStyle = context.getTheme().obtainStyledAttributes(outValue.resourceId,
                R.styleable.SherlockActionBar);
        try {
            return abStyle.getResourceId(R.styleable.SherlockActionBar_titleTextStyle, 0);
        } finally {
            abStyle.recycle();
        }
    }

    @Override
    protected int getMinimumApiLevel() {
        return Build.VERSION_CODES.ECLAIR_MR1;
    }
}
