package com.ashwin.orientation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MainRepository mMainRepository;

    private int mLastRotation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button pingButton = findViewById(R.id.ping_button);
        pingButton.setOnClickListener(v -> {
            ping();
        });

        Button nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, NextActivity.class));
//            finish();
        });

        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);

        OrientationEventListener orientationEventListener = new OrientationEventListener(this) {
            @Override
            public void onOrientationChanged(int orientation) {
                /**
                 * orientation
                 * clock-1 : -1
                 * clock-2 :
                 */
                //Log.d("orientation-test", "onOrientationChanged orientation: " + orientation);

                /**
                 * rotation
                 * default : 0
                 * clock-1 : 3
                 * anticlock-1 : 1
                 */
                int rotation = getDisplay().getRotation();
                //Log.d("orientation-test", "onOrientationChanged rotation: " + rotation);

                /**
                 * Deprecated
                 */
                mLastRotation = windowManager.getDefaultDisplay().getRotation();
                //Log.d("orientation-test", "onOrientationChanged LastRotation: " + mLastRotation);
            }
        };

        orientationEventListener.enable();

        mMainRepository = new MainRepository(getApplication());
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("orientation-test", "onConfigurationChanged: newConfig: " + newConfig);
    }

    private void ping() {
        Log.d("orientation-test", "ping: MainRepository: rotation: " + mMainRepository.getRotation());
        Log.d("orientation-test", "ping: MainActivity: rotation: " + getDisplay().getRotation());
        Log.d("orientation-test", "ping: MyApplication: rotation: " + ((MyApplication) getApplication()).getRotation());
    }

    @Override
    protected void onStart() {
        super.onStart();
        ((MyApplication) getApplication()).setCurrentActivity(this);
    }
}
