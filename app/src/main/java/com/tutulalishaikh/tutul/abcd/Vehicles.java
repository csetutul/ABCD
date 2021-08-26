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


public class Vehicles extends Fragment  implements VehicleAdapter.OnItemClickListner,TextToSpeech.OnInitListener{
    private ViewPager viewPager;
    private Context context;
    private TextToSpeech myTTS;
    private int MY_DATA_CHECK_CODE = 0;
    public Vehicles() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        context = container.getContext();
       VehicleAdapter vehicleAdapter=new VehicleAdapter(context);
        viewPager = v.findViewById(R.id.abcdpager);
        viewPager.setAdapter(vehicleAdapter);
        vehicleAdapter.setOnItemClickListner(Vehicles.this);
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
            speakword("Airplane");

        }else if (position==1)
        {
            speakword("bike");
        }else if (position==2)
        {
            speakword("boat");
        }else if(position==3)
        {
            speakword("bus");
        }else if (position==4)
        {
            speakword("car");
        }else if (position==5)
        {
            speakword("cycle");
        }else if(position==6)
        {
            speakword("scooty");
        }else if (position==7)
        {
            speakword("taxi");
        }

    }

    private void speakword(String l) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int speach=  myTTS.speak(l,TextToSpeech.QUEUE_FLUSH,null,null);
        } else {
            int spech=myTTS.speak(l, TextToSpeech.QUEUE_FLUSH, null);
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