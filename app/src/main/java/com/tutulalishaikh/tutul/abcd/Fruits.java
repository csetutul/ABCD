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


public class Fruits extends Fragment implements FruitsAdapter.OnItemClickListner, TextToSpeech.OnInitListener {
    private ViewPager viewPager;
    private Context context;
    private TextToSpeech myTTS;
    private int MY_DATA_CHECK_CODE = 0;
    public Fruits() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        context = container.getContext();
       FruitsAdapter fruitsAdapter=new FruitsAdapter(context);
        viewPager = v.findViewById(R.id.abcdpager);
        viewPager.setAdapter(fruitsAdapter);
        fruitsAdapter.setOnItemClickListner(Fruits.this);
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
        if(position==0)
        {
            speakword("apple");

        }else if (position==1)
        {
            speakword("banana");
        }else if (position==2)
        {
            speakword("cherry");
        }else if(position==3)
        {
            speakword("coconut");
        }else if (position==4)
        {
            speakword("grapes");
        }else if (position==5)
        {
            speakword("lemon");
        }else if(position==6)
        {
            speakword("mango");
        }else if (position==7)
        {
            speakword("orange");
        }else if (position==8)
        {
            speakword("papaya");
        }else if(position==9)
        {
            speakword("pomegranate");
        }else if (position==10)
        {
            speakword("strawberry");
        }else if (position==11)
        {
            speakword("tomato");
        }else if(position==12)
        {
            speakword("watermelon");
        }

    }
    private void speakword(String a) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int speach=  myTTS.speak(a,TextToSpeech.QUEUE_FLUSH,null,null);
        } else {
            int spech=myTTS.speak(a, TextToSpeech.QUEUE_FLUSH, null);
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