package com.tutulalishaikh.tutul.abcd;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Locale;


public class Month extends Fragment implements MonthsAdapter.OnItemClickListner, TextToSpeech.OnInitListener {
    private ViewPager viewPager;
    private Context context;
    private TextToSpeech myTTS;
    private int MY_DATA_CHECK_CODE = 0;
    public Month() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        context = container.getContext();
       MonthsAdapter monthsAdapter=new MonthsAdapter(context);
        viewPager = v.findViewById(R.id.abcdpager);
        viewPager.setAdapter(monthsAdapter);
        monthsAdapter.setOnItemClickListener(Month.this);
        Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);

        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onInit(int status) {
        if (status != TextToSpeech.ERROR) {
            myTTS.setLanguage(Locale.UK);
        }
    }

    @Override
    public void onItemClick(int position) {
        if (position==0)
        {
            speakword("January");
        }else if(position==1)
        {
            speakword("february");
        }else if(position==2)
        {
            speakword("march");
        }else if(position==3)
        {
            speakword("april");
        }else if(position==4)
        {
            speakword("may");
        }else if(position==5)
        {
            speakword("june");
        }else if(position==6)
        {
            speakword("july");
        }else if(position==7)
        {
            speakword("august");
        }else if(position==8)
        {
            speakword("september");
        }else if(position==9)
        {
            speakword("october");
        }else if(position==10)
        {
            speakword("november");
        }
        else if(position==11)
        {
            speakword("december");
        }


    }

    private void speakword(String november) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int speach=myTTS.speak(november,TextToSpeech.QUEUE_FLUSH,null,null);
        } else {
            int spech=myTTS.speak(november, TextToSpeech.QUEUE_FLUSH, null);
        }
    }
    public   void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                //the user has the necessary data - create the TTS
                myTTS = new TextToSpeech(getActivity(),this);
            }
            else {
                //no data - install it now
                Intent installTTSIntent = new Intent();
                installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installTTSIntent);
            }
        }
    }
}