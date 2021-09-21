package com.ashwin.orientation;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.WindowManager;

public class MainRepository {
    private static final String SUB_TAG = MainRepository.class.getSimpleName();

    private Application mApplication;

    public MainRepository(Application application) {
        Log.d("orientation-test", SUB_TAG + ": constructor");
        mApplication = application;

        initWindowManager();
    }

    public void initWindowManager() {
        WindowManager windowManager = (WindowManager) mApplication.getSystemService(Context.WINDOW_SERVICE);
        Log.d("orientation-test", SUB_TAG + ": windowManager: " + windowManager);
    }

    public int getRotation() {
        try {
            return mApplication.getDisplay().getRotation();
        } catch (Exception e) {
            /**
             * java.lang.UnsupportedOperationException: Tried to obtain display from a Context not associated with  one. Only visual Contexts (such as Activity or one created with Context#createWindowContext) or ones created with Context#createDisplayContext are associated with displays. Other types of Contexts are typically related to background entities and may return an arbitrary display.
             */
            Log.e("orientation-test", SUB_TAG + ": error", e);
        }
        return Integer.MIN_VALUE;
    }
}
