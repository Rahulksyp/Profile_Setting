package com.example.profilesetting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.profilesetting.R;
import com.example.profilesetting.model.DummyDataModel;

import java.util.ArrayList;

public class OfferingAdapter extends RecyclerView.Adapter<OfferingAdapter.ViewHolder> {
    ArrayList<DummyDataModel> dummyDataModels;
    Context context;

    public OfferingAdapter(ArrayList<DummyDataModel> dummyDataModels, Context context) {
        this.dummyDataModels = dummyDataModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DummyDataModel obj = dummyDataModels.get(position);
        holder.name.setText("Name: "+obj.getUserName());
        holder.jobTitle.setText("Looking For: "+obj.getJobTitle());
        holder.jobLocationl.setText("Location: "+obj.getLocation());
        holder.discription.setText("Description: "+obj.getDescription());

    }

    @Override
    public int getItemCount() {
        return dummyDataModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name,discription,jobLocationl,jobTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            discription = itemView.findViewById(R.id.descTv);
            jobLocationl = itemView.findViewById(R.id.locationTv);
            jobTitle = itemView.findViewById(R.id.jobTv);
        }
    }
}
