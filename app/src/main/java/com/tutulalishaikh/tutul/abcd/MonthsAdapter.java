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

public class MonthsAdapter extends PagerAdapter {

    int[] months={R.drawable.jauary,R.drawable.february,R.drawable.march,R.drawable.april,R.drawable.may,
            R.drawable.june,R.drawable.july,R.drawable.augest,R.drawable.september,R.drawable.octobor,R.drawable.november,R.drawable.december};
     String[] monthsname={"January","February","March","April","May","June","July","August","September","october","November","December"};
    private Context context;
    private LayoutInflater layoutInflater;
    private OnItemClickListner mListener;
    public MonthsAdapter(Context context) {
        this.context = context;
    }
    public interface OnItemClickListner
    {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListner listener)
    {
        mListener=listener;
    }
    @Override
    public int getCount() {
        return months.length;
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
        textView.setText(monthsname[position]);
        imageView.setImageResource(months[position]);
        container.addView(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null)
                {
                    int pos=position;
                    mListener.onItemClick(position);
                }

            }
        });
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager= (ViewPager) container;
        View view= (View) object;
        viewPager.removeView(view);
    }
}
