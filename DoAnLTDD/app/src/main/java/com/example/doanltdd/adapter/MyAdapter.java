package com.example.doanltdd.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.doanltdd.R;

import static com.example.doanltdd.R.layout.activity_list_row_ex;

public class MyAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String rTitle[];
    private final String rDescription[];
    private final int rImage[];

    public MyAdapter(Context c, String title[], String description[], int images[])
    {
        super(c, activity_list_row_ex,R.id.textView1,title);
        this.context = c;
        this.rTitle=title;
        this.rDescription= description;
        this.rImage = images;

    }

    @NonNull
    @Override
    public View getView(int position,View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(activity_list_row_ex,parent,false);
        ImageView imageView = view.findViewById(R.id.image);
        TextView myTitle= view.findViewById(R.id.textView1);
        TextView myDescription= view.findViewById(R.id.textView2);


        imageView.setImageResource(rImage[position]);
        myTitle.setText(rTitle[position]);
        myDescription.setText(rDescription[position]);
        return super.getView(position,convertView,parent);


    }

}
