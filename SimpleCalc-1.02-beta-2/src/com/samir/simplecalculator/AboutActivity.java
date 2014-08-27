package com.samir.simplecalculator;

import android.os.Bundle;
import android.preference.PreferenceActivity;
 
public class AboutActivity extends PreferenceActivity {
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
 
    }
}
