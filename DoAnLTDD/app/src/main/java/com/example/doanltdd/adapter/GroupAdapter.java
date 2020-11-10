package com.example.doanltdd.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanltdd.R;
import com.example.doanltdd.model.Group;

import java.util.List;

import static com.example.doanltdd.R.id.gr_name;


public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupViewHolder> {

    private List<Group> groupList;


    public void setData (List<Group> list)
    {
        this.groupList= list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_group,parent,false);
        return new GroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {
        Group group = groupList.get(position);
        if (group==null)
        {
            return ;
        }
        holder.grname.setText(group.getName());
    }

    @Override
    public int getItemCount() {
        if(groupList != null)
        {
            return groupList.size();
        }
        return 0;
    }

    public static class GroupViewHolder extends RecyclerView.ViewHolder{

        private TextView grname;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            grname = itemView.findViewById(gr_name);
        }
    }

}
