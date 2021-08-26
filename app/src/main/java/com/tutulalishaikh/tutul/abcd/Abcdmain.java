package com.tutulalishaikh.tutul.abcd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import static com.google.android.gms.ads.MobileAds.*;

public class Abcdmain extends AppCompatActivity {
    CardView abcd,num,ani,bir,veh,fru,mon,day,color;
    Toolbar toolbar;
    ImageView about;

    AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abcdmain);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        abcd=findViewById(R.id.abcd);
        num=findViewById(R.id.numbers);
        ani=findViewById(R.id.animals);
        bir=findViewById(R.id.birds);
        veh=findViewById(R.id.vehi);
        fru=findViewById(R.id.fruits);
        mon=findViewById(R.id.months);
        day=findViewById(R.id.days);
        color=findViewById(R.id.colors);
        about=toolbar.findViewById(R.id.aboutme);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Abcdmain.this,AboutMe.class);
                startActivity(intent);
            }
        });
        abcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abcd = new Intent(Abcdmain.this,Loadfragment.class);
                String aaa="a";
                abcd.putExtra("name",aaa);
                startActivity(abcd);
            }
        });
        num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent num = new Intent(Abcdmain.this,Loadfragment.class);
                String b="x";
                num.putExtra("onetw",b);
                startActivity(num);
            }
        });
        ani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ani = new Intent(Abcdmain.this,Loadfragment.class);
                String c="w";
                ani.putExtra("ani",c);
                startActivity(ani);
            }
        });
        bir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bird = new Intent(Abcdmain.this,Loadfragment.class);
                String d="v";
                bird.putExtra("bird",d);
                startActivity(bird);
            }
        });
        veh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent veh = new Intent(Abcdmain.this,Loadfragment.class);
                String e="u";
                veh.putExtra("vehicl",e);
                startActivity(veh);
            }
        });
        fru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fruit = new Intent(Abcdmain.this,Loadfragment.class);
                String f="t";
                fruit.putExtra("fruit",f);
                startActivity(fruit);
            }
        });
        mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent month = new Intent(Abcdmain.this,Loadfragment.class);
                String g="s";
                month.putExtra("month",g);
                startActivity(month);
            }
        });
        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(Abcdmain.this,Loadfragment.class);
                String h="r";
               day.putExtra("day",h);
                startActivity(day);
            }
        });
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent col = new Intent(Abcdmain.this,Loadfragment.class);
                String i="q";
                col.putExtra("color",i);
                startActivity(col);
            }
        });
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
                super.onAdFailedToLoad(adError);
                mAdView.loadAd(adRequest);
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                super.onAdOpened();
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                super.onAdClicked();
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.

            }
        });

    }
}