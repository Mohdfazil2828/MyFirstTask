package com.myfirsttask.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myfirsttask.Model.GroundResponse;
import com.myfirsttask.Model.Record;
import com.myfirsttask.R;
import com.myfirsttask.fragments.GroundsFragment;

import java.util.ArrayList;

public class GroundRecyeclerAdapter extends RecyclerView.Adapter<GroundRecyeclerAdapter.MyViewHolder> {


    private GroundsFragment context;

    Record record;
    private ArrayList<GroundResponse> groundResponseArrayList = new ArrayList<GroundResponse>();



    public GroundRecyeclerAdapter(GroundsFragment context, ArrayList<GroundResponse> recordArrayList) {

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

        final String groundId = String.valueOf(groundResponseArrayList.get(position).getRecord());


        myViewHolder.textgroundnameTextView.setText(record.getGroundname());
        myViewHolder.textlocationnameTextView.setText(record.getLocation_name());
        myViewHolder.texteventtypenameTextView.setText(record.getEvent_type_name());

    }

    @Override
    public int getItemCount() {

        return groundResponseArrayList.size();
    }

    public void updateData(ArrayList<GroundResponse> groundResponseArrayList) {
        this.groundResponseArrayList.clear();
        this.groundResponseArrayList = groundResponseArrayList;

        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textgroundnameTextView, textlocationnameTextView, texteventtypenameTextView;

        private ImageView groundImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            groundImageView = itemView.findViewById(R.id.imageview);
            textgroundnameTextView = itemView.findViewById(R.id.textview1);
            textlocationnameTextView = itemView.findViewById(R.id.textview2);
            texteventtypenameTextView = itemView.findViewById(R.id.textview3);

        }
    }
}
