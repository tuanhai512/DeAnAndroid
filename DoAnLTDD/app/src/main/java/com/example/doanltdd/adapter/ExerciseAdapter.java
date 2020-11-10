package com.example.doanltdd.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanltdd.R;
import com.example.doanltdd.model.Exercise;

import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHoder> {

    private List<Exercise> exerciseList;


    public void setData(List<Exercise> list)
    {
        this.exerciseList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ExerciseViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_excercise,parent,false);
        return new ExerciseViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHoder holder, int position) {
        Exercise exercise = exerciseList.get(position);
        if(exercise == null) {
            return;
        }
        holder.tvName.setImageResource(exercise.getResourceID());

    }

    @Override
    public int getItemCount() {
        if(exerciseList != null)
        {
            return exerciseList.size();
        }
        return 0;
    }

    public static class ExerciseViewHoder extends RecyclerView.ViewHolder {
        //Khởi tạo biến
        private ImageView tvName;

        public ExerciseViewHoder(@NonNull View itemView) {
            super(itemView);
            //Gán biến
            tvName= itemView.findViewById(R.id.tv_name);
        }
    }
}
