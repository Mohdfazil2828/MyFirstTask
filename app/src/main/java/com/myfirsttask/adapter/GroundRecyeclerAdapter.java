package com.myfirsttask.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myfirsttask.Model.GroundResponse;
import com.myfirsttask.R;
import com.myfirsttask.fragments.GroundsFragment;

import java.util.ArrayList;

public class GroundRecyeclerAdapter extends RecyclerView.Adapter<GroundRecyeclerAdapter.MyViewHolder> {


    private GroundsFragment context;

    private ArrayList<GroundResponse> groundResponseArrayList = new ArrayList<GroundResponse>();



    public GroundRecyeclerAdapter(GroundsFragment context, ArrayList<GroundResponse> groundResponseArrayList) {

        this.groundResponseArrayList = groundResponseArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grounds_list, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GroundRecyeclerAdapter.MyViewHolder myViewHolder, final int position) {

        GroundResponse groundResponse = groundResponseArrayList.get(position);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
