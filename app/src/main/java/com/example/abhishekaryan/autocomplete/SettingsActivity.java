package com.example.abhishekaryan.autocomplete;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

public class SettingsActivity extends AppCompatActivity {

    private FrameLayout layout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity_layout);
        layout=(FrameLayout)findViewById(R.id.settings_frame_layout);
        FragmentManager manager=getFragmentManager();
        FragmentTransaction txn=manager.beginTransaction();
        txn.add(R.id.settings_frame_layout,new prefSettingsFragment());
        txn.commit();
    }


}
