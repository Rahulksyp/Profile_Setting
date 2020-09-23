package com.example.profilesetting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.profilesetting.R;
import com.example.profilesetting.model.DataModel;

import java.util.ArrayList;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.ViewHolder> {

    private ArrayList<DataModel> arrayList;
    private Context context;

    public RequestAdapter(ArrayList<DataModel> arrayList, Context context) {
        this.arrayList = arrayList;
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

        DataModel obj = arrayList.get(position);
        holder.name.setText("UserId: "+obj.getUserId());
        holder.jobTitle.setText("Id: "+obj.getId());
        holder.jobLocationl.setText("Title: "+obj.getTitle());
        holder.discription.setText("Description: "+obj.getBody());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
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
