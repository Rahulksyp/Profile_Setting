package com.example.profilesetting.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.profilesetting.R;
import com.example.profilesetting.adapter.OfferingAdapter;
import com.example.profilesetting.adapter.RequestAdapter;
import com.example.profilesetting.model.DataModel;
import com.example.profilesetting.model.DummyDataModel;

import java.util.ArrayList;


public class OfferingFragment extends Fragment {

    private RecyclerView recyclerView;
    private OfferingAdapter adapter;
    private ArrayList<DummyDataModel> list;


    public OfferingFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.requestsRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        list.add(new DummyDataModel("Rahul","Android Developer","Bangalore","Looking for job change"));
        list.add(new DummyDataModel("Raj","Android Developer","Bangalore","Looking for job change"));
        list.add(new DummyDataModel("Hariom","Android Developer","Bangalore","Looking for job change"));
        list.add(new DummyDataModel("Rocky","Android Developer","Bangalore","Looking for job change"));
        list.add(new DummyDataModel("Aman","Android Developer","Bangalore","Looking for job change"));

        adapter = new OfferingAdapter(list,getContext());
        recyclerView.setAdapter(adapter);
    }
}