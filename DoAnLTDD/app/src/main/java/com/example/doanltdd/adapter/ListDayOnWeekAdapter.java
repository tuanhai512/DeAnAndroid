package com.example.doanltdd.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doanltdd.R;
import com.example.doanltdd.controller.MyList;

import java.util.HashMap;
import java.util.List;

public class ListDayOnWeekAdapter extends BaseExpandableListAdapter {

    Context context;
    List<String> listgroup;
    HashMap<String,List<String>> listItem;

    public ListDayOnWeekAdapter(Context context, List<String> listgroup, HashMap<String, List<String>> listItem) {
        this.context = context;
        this.listgroup = listgroup;
        this.listItem = listItem;
    }


    @Override
    public int getGroupCount() {
        return listgroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listItem.get(this.listgroup.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listgroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listItem.get(this.listgroup.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String group =(String) getGroup(groupPosition);
        if(convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this
                    .context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group,null);
        }
        TextView textView =convertView.findViewById(R.id.list_parent);
        textView.setText(group);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String child =(String) getChild(groupPosition,childPosition);
        if(convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this
                    .context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item,null);
        }
        TextView textView =convertView.findViewById(R.id.list_child);
        textView.setText(child);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(childPosition==0)
                {
                    Toast.makeText(context,"Ngày"+childPosition,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context.getApplicationContext(), MyList.class);
                    context.startActivity(intent);

                }
                if(childPosition==1)
                {
                    Toast.makeText(context,"Ngày"+childPosition,Toast.LENGTH_SHORT).show();
                }
                if(childPosition==2)
                {
                    Toast.makeText(context,"Ngày"+childPosition,Toast.LENGTH_SHORT).show();
                }
                if(childPosition==3)
                {
                    Toast.makeText(context,"Ngày"+childPosition,Toast.LENGTH_SHORT).show();
                }
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
