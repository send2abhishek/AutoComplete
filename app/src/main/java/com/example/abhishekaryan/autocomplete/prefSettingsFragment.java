package com.example.abhishekaryan.autocomplete;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

public class prefSettingsFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {

    public prefSettingsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.prefernce);
        BindListPrefSummToValue(findPreference(getString(R.string.pref_key)));

    }

    private void BindListPrefSummToValue(Preference preference){


        preference.setOnPreferenceChangeListener(this);
        SetSummeryMethod(preference,PreferenceManager.getDefaultSharedPreferences(preference.getContext())

                .getString(preference.getKey(),""));

    }

    private void SetSummeryMethod(Preference preference,Object value){

        String indexVal=value.toString();

        if(preference instanceof ListPreference){

            ListPreference listPreference=(ListPreference)preference;

            int prefIndex=listPreference.findIndexOfValue(indexVal);
            if(prefIndex >= 0){

                listPreference.setSummary(listPreference.getEntries()[prefIndex]);
            }
        }
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {

        SetSummeryMethod(preference,newValue);

        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(getActivity());

        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("MyKey",newValue.toString()).apply();

        return true;
    }
}
