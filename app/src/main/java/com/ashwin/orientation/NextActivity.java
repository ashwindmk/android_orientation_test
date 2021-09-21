package com.ashwin.orientation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class NextActivity extends AppCompatActivity {
    private static final String SUB_TAG = NextActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Button pingButton = findViewById(R.id.ping_button);
        pingButton.setOnClickListener(v -> {
            ping();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        ((MyApplication) getApplication()).setCurrentActivity(this);
    }

    private void ping() {
        Log.d("orientation-test", SUB_TAG + ": ping: act rotation: " + getDisplay().getRotation());
        Log.d("orientation-test", SUB_TAG + ": ping: app rotation: " + ((MyApplication) getApplication()).getRotation());
    }
}