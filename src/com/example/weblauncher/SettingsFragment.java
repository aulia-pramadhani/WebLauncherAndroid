package com.example.weblauncher;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;

public class SettingsFragment extends PreferenceFragment implements
OnSharedPreferenceChangeListener{
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	  // TODO Auto-generated method stub
	  super.onCreate(savedInstanceState);
	  
	  // Load the preferences from an XML resource
	        addPreferencesFromResource(R.xml.settings);

			Preference pref = findPreference("webUrl");
            EditTextPreference etp = (EditTextPreference) pref;
            pref.setSummary("Current url: "+etp.getText());       
	 }

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		// TODO Auto-generated method stub
		Preference pref = findPreference(key);
        if (pref instanceof EditTextPreference) {
            EditTextPreference etp = (EditTextPreference) pref;
            pref.setSummary("Current url: "+etp.getText());
        }
	}

}