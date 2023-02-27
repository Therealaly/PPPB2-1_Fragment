package com.example.fragment_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ButtonFragment extends Fragment {

    private boolean counter;

    public ButtonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_button, container, false);
        final Button button = rootView.findViewById(R.id.button);
        final TextView desc = rootView.findViewById(R.id.main_desc);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter == false){
                    button.setText(R.string.close_button);
                    desc.setText(R.string.details_desc);
                    counter = true;
                }else if(counter != false ){
                    button.setText(R.string.default_button);
                    desc.setText(R.string.main_desc);
                    counter = false;
                }

            }
        });

        return rootView;
    }
}