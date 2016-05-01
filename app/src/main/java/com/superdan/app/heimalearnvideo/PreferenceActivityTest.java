package com.superdan.app.heimalearnvideo;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by dsz on 16/4/30.
 */
public class PreferenceActivityTest extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);
    }
}
