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


public class BlankFragment extends Fragment implements Abcdadaper.OnItemClickListner, TextToSpeech.OnInitListener {

    private ViewPager viewPager;
    private Context context;
    private TextToSpeech myTTS;
    private int MY_DATA_CHECK_CODE = 0;
    public BlankFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        context = container.getContext();
        Abcdadaper abcdAdapter =new Abcdadaper(context);
        viewPager = v.findViewById(R.id.abcdpager);
        viewPager.setAdapter(abcdAdapter);
        abcdAdapter.setOnItemClickListner(BlankFragment.this);
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
            speakword("a");

        }else if (position==1)
        {
            speakword("b");
        }else if (position==2)
        {
            speakword("c");
        }else if(position==3)
        {
            speakword("d");
        }else if (position==4)
        {
            speakword("e");
        }else if (position==5)
        {
            speakword("f");
        }else if(position==6)
        {
            speakword("g");
        }else if (position==7)
        {
            speakword("h");
        }else if (position==8)
        {
            speakword("i");
        }else if(position==9)
        {
            speakword("j");
        }else if (position==10)
        {
            speakword("k");
        }else if (position==11)
        {
            speakword("l");
        }else if(position==12)
        {
            speakword("m");
        }else if (position==13)
        {
            speakword("n");
        }else if (position==14)
        {
            speakword("o");
        }else if(position==15)
        {
            speakword("p");
        }else if (position==16)
        {
            speakword("q");
        }else if (position==17)
        {
            speakword("r");
        }else if(position==18)
        {
            speakword("s");
        }else if (position==19)
        {
            speakword("t");
        }else if (position==20)
        {
            speakword("u");
        }else if(position==21)
        {
            speakword("v");
        }else if (position==22)
        {
            speakword("w");
        }else if (position==23)
        {
            speakword("x");
        }else if(position==24)
        {
            speakword("y");
        }else if(position==25)
        {
            speakword("z");
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