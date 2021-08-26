package com.tutulalishaikh.tutul.abcd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class Loadfragment extends AppCompatActivity {
    FrameLayout frameLayout;
    public static FragmentManager fm;
    Toolbar toolbar;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadfragment);
        frameLayout=findViewById(R.id.container);
        toolbar=findViewById(R.id.btmbar);
        imageView=toolbar.findViewById(R.id.backtomain);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        fm=getSupportFragmentManager();
        Bundle extras = getIntent().getExtras();
        String ab = extras.getString("name");
        String num = extras.getString("onetw");
        String animal = extras.getString("ani");
        String bird = extras.getString("bird");
        String vehi = extras.getString("vehicl");
        String fruit= extras.getString("fruit");
        String month = extras.getString("month");
        String day = extras.getString("day");
        String color = extras.getString("color");

        if(ab!=null)
        {
            if(frameLayout!=null)
            {
                if(savedInstanceState!=null)
                {
                    return;
                }
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
               BlankFragment abcd = new BlankFragment();
                fragmentTransaction.add(R.id.container,abcd,null);
                fragmentTransaction.commit();
            }
        }
        if(num!=null)
        {
            if(frameLayout!=null)
            {
                if(savedInstanceState!=null)
                {
                    return;
                }
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                Numbers numbers =new Numbers();
                fragmentTransaction.add(R.id.container,numbers,null);
                fragmentTransaction.commit();
            }
        }
        if(animal!=null)
        {
            if(frameLayout!=null)
            {
                if(savedInstanceState!=null)
                {
                    return;
                }
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
               Animal animal1=new Animal();
                fragmentTransaction.add(R.id.container,animal1,null);
                fragmentTransaction.commit();
            }
        }
        if(bird!=null)
        {
            if(frameLayout!=null)
            {
                if(savedInstanceState!=null)
                {
                    return;
                }
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
               Birds birds=new Birds();
                fragmentTransaction.add(R.id.container,birds,null);
                fragmentTransaction.commit();
            }
        }
        if(vehi!=null)
        {
            if(frameLayout!=null)
            {
                if(savedInstanceState!=null)
                {
                    return;
                }
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                Vehicles vehicles=new Vehicles();
                fragmentTransaction.add(R.id.container,vehicles,null);
                fragmentTransaction.commit();
            }
        }
        if (fruit!=null)
        {
            if(frameLayout!=null)
            {
                if(savedInstanceState!=null)
                {
                    return;
                }
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                Fruits fruits=new Fruits();
                fragmentTransaction.add(R.id.container,fruits,null);
                fragmentTransaction.commit();
            }
        }

        if (month!=null)
        {
            if(frameLayout!=null)
            {
                if(savedInstanceState!=null)
                {
                    return;
                }
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
               Month month1=new Month();
                fragmentTransaction.add(R.id.container,month1,null);
                fragmentTransaction.commit();
            }
        }

        if (day!=null)
        {
            if(frameLayout!=null)
            {
                if(savedInstanceState!=null)
                {
                    return;
                }
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
               Days days=new Days();
                fragmentTransaction.add(R.id.container,days,null);
                fragmentTransaction.commit();
            }
        }
        if (color!=null)
        {
            if(frameLayout!=null)
            {
                if(savedInstanceState!=null)
                {
                    return;
                }
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
             Colors colors=new Colors();
                fragmentTransaction.add(R.id.container,colors,null);
                fragmentTransaction.commit();
            }
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Loadfragment.this,Abcdmain.class);
                startActivity(intent);
            }
        });


    }
}