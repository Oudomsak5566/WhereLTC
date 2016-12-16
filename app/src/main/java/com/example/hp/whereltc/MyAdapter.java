package com.example.hp.whereltc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

/**
 * Created by HP on 16/12/2016.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private String[] nameStrings, latStrings, lngStrings, iconStrings;

    public MyAdapter(Context context,
                     String[] nameStrings,
                     String[] latStrings,
                     String[] lngStrings,
                     String[] iconStrings)
    {
        this.context = context;
        this.nameStrings = nameStrings;
        this.latStrings = latStrings;
        this.lngStrings = lngStrings;
        this.iconStrings = iconStrings;
    }

    @Override
    public int getCount() {
        return nameStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.my_listview, viewGroup, false);
        //findViewByid(R.id.TextView) > ctrl+shift+enter > cast to (alt+enter)
        TextView nameTextView = (TextView) view1.findViewById(R.id.textView);
        TextView latTextView = (TextView) view1.findViewById(R.id.textView5);
        TextView lngTextView = (TextView) view1.findViewById(R.id.textView6);
        ImageView iconImageView = (ImageView) view1.findViewById(R.id.imageView2);

        nameTextView.setText(nameStrings[i]);
        latTextView.setText("Lat = " + String.format("%.3f",Double.parseDouble(latStrings[i])));
        lngTextView.setText("Lng = " + String.format("%.3f",Double.parseDouble(lngStrings[i])));
        Picasso.with(context).load(iconStrings[i]).into(iconImageView);


        return view1;
    }
}//Main Class
