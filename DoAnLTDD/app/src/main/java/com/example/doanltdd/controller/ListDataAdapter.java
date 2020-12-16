package com.example.doanltdd.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanltdd.R;
import com.example.doanltdd.adapter.ExerciseAdapter;
import com.example.doanltdd.adapter.GroupAdapter;
import com.example.doanltdd.model.ListData;

import java.util.List;

public class ListDataAdapter extends RecyclerView.Adapter<ListDataAdapter.ListDataViewHolder> {
    public static final int TYPE_GROUP = 1;
    public static final int TYPE_EXCERCISE =2;
    List<ListData> listData;
    private Context context;

    public void setData(Context context,List<ListData> listData){
        this.listData = listData;
        this.context = context;
        notifyDataSetChanged();
    }
    @Override
    public int getItemViewType(int position) {
        return listData.get(position).getType();
    }

    @NonNull
    @Override
    public ListDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_data,parent,false);
        return new ListDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListDataViewHolder holder, int position) {
        ListData listData1 = listData.get(position);
        if(listData1==null)
        {
            return;
        }
        if(TYPE_GROUP == holder.getItemViewType())
        {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false);
            holder.rcvItem.setLayoutManager(linearLayoutManager);
            holder.rcvItem.setFocusable(false);

            GroupAdapter groupAdapter =  new GroupAdapter();
            groupAdapter.setData(listData1.getListGroups());
            holder.rcvItem.setAdapter(groupAdapter);
        }
        else if(TYPE_EXCERCISE==holder.getItemViewType())
        {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,RecyclerView.VERTICAL,false);
            holder.rcvItem.setLayoutManager(linearLayoutManager);
            holder.rcvItem.setFocusable(false);

            ExerciseAdapter exerciseAdapter = new ExerciseAdapter();
            exerciseAdapter.setData(listData1.getListExercises());
            holder.rcvItem.setAdapter(exerciseAdapter);
        }
    }

    @Override
    public int getItemCount() {
        if(listData != null)
        {
            return listData.size();
        }
        return 0;
    }

    public static class ListDataViewHolder extends RecyclerView.ViewHolder{

        private RecyclerView rcvItem;

        public ListDataViewHolder(@NonNull View itemView) {

            super(itemView);

            rcvItem = itemView.findViewById(R.id.rcv_item);
        }
    }
}
