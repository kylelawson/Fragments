package com.lawdogstudio.kyle.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Kyle on 4/23/2016.
 */
public class XMLFragmentActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.xml_fragment_layout, container, false);

        //This is where the logic goes including widgets, widget hookups, and intents

        return view;
    }

}
