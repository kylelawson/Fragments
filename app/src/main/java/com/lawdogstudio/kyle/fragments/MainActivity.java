package com.lawdogstudio.kyle.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Example and template of two different ways to include fragments, dynamic and static
 * Static includes a fragment in the layout xml but is inflexible
 * Dynamic inludes a fragment in code, more complex but allows for the fragment to be changed
 * if needed
 */
public class MainActivity extends AppCompatActivity implements CodeFragmentActivity.interfaceForPassingData {

    //Set a fragment manager for the main screen fragment
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //All of this is for dynamic fragments, static fragments are coded in the xml layout files

        //Initiate the fragment itself by attaching it to the fragment manager and assigning it the
        //layout within the activity_main.xml
        Fragment mainFragment = fm.findFragmentById(R.id.code_fragment);

        //If the fragment is empty, attach a fragment activity class to it and begin a fragment transaction
        //in order to show the fragment in the main view
        if(mainFragment == null){
            mainFragment = new CodeFragmentActivity();
            fm.beginTransaction().add(R.id.code_fragment, mainFragment).commit();
        }
    }

    //Implemented method for passing data from fragment of origin to activity
    //This is where the activity sends the data where ever it needs to, including another fragment
    @Override
    public void thisIsTheInterface(String string) {

        //Use bundle to send data to another fragment
        Bundle bundle = new Bundle();
        bundle.putString("data","This is passed data");

        //Create a new fragment
        Fragment replacementFragment = new CodeFragmentActivity();

        //Give the new fragment the data
        replacementFragment.setArguments(bundle);

        //Replace the old fragment with the new one that holds the data
        fm.beginTransaction().replace(R.id.code_fragment, replacementFragment).commit();

    }
}
