package com.example.fragment_app;

import androidx.appcompat.app.AppCompatActivity;
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

        fragmentTransaction.add(R.id.fragment_frame, detailsFragment).addToBackStack(null).commit();

        isFragmentDisplayed = true;
        mButton.setText(R.string.close_button);
    }

    public void closeFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        DetailsFragment detailsFragment = (DetailsFragment) fragmentManager.findFragmentById(R.id.fragment_frame);

        if(detailsFragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(detailsFragment).commit();
        }

        mButton.setText(R.string.default_button);
        isFragmentDisplayed = false;

    }
}