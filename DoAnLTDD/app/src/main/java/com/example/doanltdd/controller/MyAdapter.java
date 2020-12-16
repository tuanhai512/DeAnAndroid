package com.example.doanltdd.controller;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.doanltdd.R;

import java.util.List;


public class MyAdapter extends ArrayAdapter<Contact> {
    Context context;
    int layout;
    List<Contact> contactList;
    private LayoutInflater layoutInflater;

    public MyAdapter( Context context, int resource,  List<Contact> objects)
    {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.contactList = objects;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent)
    {
        ViewHolder viewHolder = new ViewHolder();

        if(convertView==null)
        {
            convertView = layoutInflater.inflate(R.layout.activity_list_row_ex,null);
            viewHolder.myTitle= convertView.findViewById(R.id.textView);
            viewHolder.imageView = convertView.findViewById(R.id.image);
            convertView.setTag(viewHolder);
        }else
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Contact contact = contactList.get(position);
        viewHolder.imageView.setImageResource(contact.getImage());
        viewHolder.myTitle.setText(contact.getTitle());

        return convertView;
    }
    private class ViewHolder
    {
        ImageView imageView ;
        TextView myTitle;
    }
}
