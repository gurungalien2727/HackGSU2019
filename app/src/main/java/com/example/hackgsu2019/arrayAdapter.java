package com.example.hackgsu2019;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class arrayAdapter extends ArrayAdapter<cards> {

    Context context;

    public arrayAdapter(Context context, int resourceId, List<cards> items){

        super(context,resourceId,items);
    }

    public View getView(int position, View contentView, ViewGroup parent){

        cards card_item=getItem(position);

        if(contentView==null){

            contentView = LayoutInflater.from(getContext()).inflate(R.layout.item,parent,false);
        }

        TextView name=(TextView) contentView.findViewById(R.id.name);
        ImageView image=(ImageView) contentView.findViewById(R.id.image);

        //name.setText(card_item.getQuestion());
        //image.setImageResource(card_item.getImageId());
        Toast toast= Toast.makeText(getContext(),card_item.getQuestion(),Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,0,190);

      //  RelativeLayout tl=(RelativeLayout)toast.getView();
        //TextView tv=(TextView)tl.getChildAt(0);
      //  tv.setTextSize(24);
        toast.show();
        Glide.with(getContext()).load(card_item.getImageId()).into(image);


        return contentView;
    }
}
