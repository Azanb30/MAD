package com.example.irtazanadeem.madproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customAdapter extends ArrayAdapter<String>
{
    int[] logos = {R.drawable.howdy, R.drawable.arcadian, R.drawable.monal1, R.drawable.mcdonalds, R.drawable.cafeaylanto};

    public customAdapter(@NonNull Context context, String[] res)
    {
        super(context, R.layout.customlayout, res);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater myInflator = LayoutInflater.from(getContext());
        View customView=myInflator.inflate(R.layout.customlayout, parent, false);

        TextView myText = (TextView)customView.findViewById(R.id.R_nameView);
        ImageView myImage = (ImageView) customView.findViewById(R.id.logoView);

        myText.setText(getItem(position));
        myImage.setImageResource(logos[position]);

        return customView;
    }
}
