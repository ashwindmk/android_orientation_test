package com.ashwin.orientation;

import android.app.Activity;
import android.app.Application;
import android.hardware.display.DisplayManager;
import android.view.Display;

import androidx.fragment.app.FragmentActivity;

public class MyApplication extends Application {
    private FragmentActivity mCurrentActivity;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public void setCurrentActivity(Activity activity) {
        //mCurrentActivity = (FragmentActivity) activity;
    }

    public int getRotation() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            final DisplayManager dm = getSystemService(DisplayManager.class);
            return dm.getDisplay(Display.DEFAULT_DISPLAY).getRotation();
        }
        return 0;

//        if (mCurrentActivity != null) {
//            return mCurrentActivity.getDisplay().getRotation();
//        }
//        return 0;
    }
}
