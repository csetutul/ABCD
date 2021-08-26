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

public class BirdsAdapter extends PagerAdapter {
    int[] bird={R.drawable.nightingale,R.drawable.bat,R.drawable.crow,R.drawable.egle,R.drawable.owl,
            R.drawable.parrot,R.drawable.peacook,R.drawable.pigeon,R.drawable.rooster,R.drawable.stork};
    String [] birdname={"nightingale","bat","crow","Eagle","Owl","Parrot","peacock","Pigeon","Rooster","stork"};
    private Context context;
    private LayoutInflater layoutInflater;
    private OnItemClickListner mListner;

    public BirdsAdapter(Context context) {
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
        return bird.length;
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
        textView.setText(birdname[position]);
        imageView.setImageResource(bird[position]);

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
