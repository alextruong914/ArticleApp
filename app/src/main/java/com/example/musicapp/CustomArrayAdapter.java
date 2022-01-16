package com.example.musicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter<String> {
    private Context context;
    private int resource;
    private ArrayList<String> arrArticle;

    public CustomArrayAdapter(Context context, int resource, ArrayList<String> arrArticle) {
        super(context, resource, arrArticle);
        this.context = context;
        this.resource = resource;
        this.arrArticle = arrArticle;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(resource, parent, false);

            viewHolder = new ViewHolder();

            // R.id.tv_heading might be different for each instance of the CustomArrayAdapter
            // Seems like using only R.id.tv_Heading might create a problem or be a conceptual shortcoming in this code
            viewHolder.tHeading = (TextView) convertView.findViewById(R.id.tv_Heading);

            convertView.setTag(viewHolder);

        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    public class ViewHolder {

        TextView tHeading;
    }
}
