package com.lawdogstudio.kyle.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Kyle on 4/23/2016.
 * This activity is used for the dynamic fragment
 */

public class CodeFragmentActivity extends Fragment {

    //TextView and button instantiation used to demonstrate the passing of data
    TextView text;
    Button button;
    String passedData = "Passing something along";

    //Interface variable declaration
    interfaceForPassingData interfaceForPassingData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.code_fragment_layout, container, false);

        //This is where the logic goes including widgets, widget hookups, and intents
        text = (TextView) view.findViewById(R.id.textView);
        button = (Button) view.findViewById(R.id.button);

        //The logic to include the bundled data passed from the originating fragment to the activity to another fragment
        if(getArguments() != null){
            text.setText(getArguments().getString("data"));
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceForPassingData.thisIsTheInterface(passedData);
            }
        });

        return view;
    }

    //This is the interface that must be used to pass data from the orignator to the destination fragment
    //Using the activity to control where the data goes, be sure to implement this in the activity
    public interface interfaceForPassingData
    {
        public void thisIsTheInterface(String string);
    }

    @SuppressWarnings("deprecation")
    //Makes sure the interface is implemented on this fragment's attachment to the activity
    //This is deprecated for Lollipop on so make sure to compile using Jellybean
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            interfaceForPassingData = (interfaceForPassingData) activity;
        } catch (Exception e){

        }
    }
}
