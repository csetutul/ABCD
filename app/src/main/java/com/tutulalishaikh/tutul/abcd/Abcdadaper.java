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

public class Abcdadaper extends PagerAdapter {
    int[] alphabet={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,
            R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,
            R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o,
            R.drawable.p,R.drawable.q,R.drawable.r,R.drawable.s,R.drawable.t,
            R.drawable.u,R.drawable.v,R.drawable.w,R.drawable.x,R.drawable.y,
            R.drawable.z};
   String [] abcd= { "A", "B", "C",
            "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M",
           "N", "O", "P", "Q", "R",
           "S", "T",
           "U", "V", "W",
           "X", "Y", "Z"};
    private Context context;
    private LayoutInflater layoutInflater;
    private OnItemClickListner mListner;

    public Abcdadaper(Context context) {
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
        return alphabet.length;
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
        textView.setText(abcd[position]);
        imageView.setImageResource(alphabet[position]);

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
