package com.tutulalishaikh.tutul.abcd;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class Colors extends Fragment {

MaterialButton b1,b2,b3,b4,b5,b6,b7;
 FrameLayout frameLayout;
 RelativeLayout relativeLayout;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_colors, container, false);
       b1=view.findViewById(R.id.orang);
        b2=view.findViewById(R.id.yellow);
        b3=view.findViewById(R.id.pink);
        b4=view.findViewById(R.id.green);
        b5=view.findViewById(R.id.blue);
        b6=view.findViewById(R.id.red);
        b7=view.findViewById(R.id.purple);
        frameLayout=view.findViewById(R.id.frme);
        relativeLayout=view.findViewById(R.id.back);
         b1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 relativeLayout.setBackgroundColor(getResources().getColor(R.color.orange));
                 TextView textView=relativeLayout.findViewById(R.id.colorname);
                 textView.setText("Orange");
             }
         });
         b2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 relativeLayout.setBackgroundColor(getResources().getColor(R.color.yellow));
                 TextView textView=relativeLayout.findViewById(R.id.colorname);
                 textView.setText("Yellow");
             }
         });
         b3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 relativeLayout.setBackgroundColor(getResources().getColor(R.color.pink));
                 TextView textView=relativeLayout.findViewById(R.id.colorname);
                 textView.setText("Pink");
             }
         });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.green));
                TextView textView=relativeLayout.findViewById(R.id.colorname);
                textView.setText("Green");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.blue));
                TextView textView=relativeLayout.findViewById(R.id.colorname);
                textView.setText("Blue");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.red));
                TextView textView=relativeLayout.findViewById(R.id.colorname);
                textView.setText("Red");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               relativeLayout.setBackgroundColor(getResources().getColor(R.color.purple));
                TextView textView=relativeLayout.findViewById(R.id.colorname);
                textView.setText("Purple");
            }
        });


        return view;
    }
}