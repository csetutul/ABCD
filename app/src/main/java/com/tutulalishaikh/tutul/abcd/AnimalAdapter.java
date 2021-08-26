package com.tutulalishaikh.tutul.abcd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class AnimalAdapter extends PagerAdapter {
    int[] animal={R.drawable.cat,R.drawable.cheetah,R.drawable.fox,R.drawable.cow,R.drawable.crocodile,
            R.drawable.deer,R.drawable.dog,R.drawable.donkey,R.drawable.elephant,R.drawable.giarffe,
            R.drawable.horse,R.drawable.kangaroo,R.drawable.lion,R.drawable.monkey,R.drawable.rabbit,
    R.drawable.tiger,R.drawable.zebra};
    String [] animalname={"Cat","Cheetah","Fox","Cow","Crocodile","Deer","Dog","Donkey","Elephant","Giraffe"
    ,"Horse","Kangaroo","Lion","Monkey","Rabbit","Tiger","Zebra"};
    private Context context;
    private LayoutInflater layoutInflater;
    private OnItemClickListner mListner;

    public AnimalAdapter(Context context) {
        this.context = context;
    }
    public  interface OnItemClickListner
    {
        void onItemClick(int position);
    }
    public  void  setOnItemClickListner(OnItemClickListner listner)
    {
        mListner=listner;
    }
    @Override
    public int getCount() {
        return animal.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) container.getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.item, container, false);
        ImageView imageView = itemView.findViewById(R.id.itemid);
        TextView textView=itemView.findViewById(R.id.itemname);
        textView.setText(animalname[position]);
        imageView.setImageResource(animal[position]);

        container.addView(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListner!=null)
                {
                    int pos=position;
                    mListner.onItemClick(pos);
                }
            }
        });

        return  itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp= (ViewPager) container;
        View view= (View) object;
        vp.removeView(view);
    }
}
