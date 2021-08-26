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

public class NumbersAdapter extends PagerAdapter {

    int[] numbers={R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,
            R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine};
    String numbertext []={"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    private Context context;
    private LayoutInflater layoutInflater;

    private OnItemClickListner mListner;
    public NumbersAdapter(Context context) {

        this.context = context;
    }

    public  interface OnItemClickListner
    {
        void onItemClick(int position);
    }
    public  void setOnItemClickListner(OnItemClickListner listner)
    {
       mListner=listner;
    }
    @Override
    public int getCount() {
        return numbers.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) container.getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v=layoutInflater.inflate(R.layout.item,container,false);
        ImageView imageView=v.findViewById(R.id.itemid);
        TextView textView=v.findViewById(R.id.itemname);
        textView.setText(numbertext[position]);
        imageView.setImageResource(numbers[position]);
        container.addView(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListner!=null)
                {
                    int pos=position;
                    mListner.onItemClick(position);
                }

            }
        });
        return v;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp= (ViewPager) container;
        View view= (View) object;
        vp.removeView(view);;
    }
}
