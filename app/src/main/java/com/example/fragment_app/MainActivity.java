package com.example.fragment_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private Boolean isFragmentDisplayed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFragmentDisplayed) {
                    displayFragment();
                }
                else {
                    closeFragment();
                }
            }
        });

    }

    public void displayFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DetailsFragment detailsFragment = new DetailsFragment();
        MainFragment mainFragment = new MainFragment();

        fragmentTransaction.replace(R.id.fragment_frame, detailsFragment).addToBackStack(null).commit();
        //fragmentTransaction.remove(mainFragment).commit();

        isFragmentDisplayed = true;

        mButton.setText(R.string.close_button);
    }

    public void closeFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment detailsFragment = fragmentManager.findFragmentById(R.id.fragment_frame);
        MainFragment mainFragment = new MainFragment();

        if(detailsFragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_frame, mainFragment).addToBackStack(null).commit();
            //fragmentTransaction.replace(R.id.fragment_frame, mainFragment).addToBackStack(null).commit();
        }

        mButton.setText(R.string.default_button);
        isFragmentDisplayed = false;

    }
}