package com.example.profilesetting.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.profilesetting.R;
import com.example.profilesetting.adapter.RequestAdapter;
import com.example.profilesetting.model.DataModel;
import com.example.profilesetting.network.APIInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RequestsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RequestAdapter adapter;
    private ArrayList<DataModel> list;
    private String BASE_URL = "http://jsonplaceholder.typicode.com/";


    public RequestsFragment() {
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

        loadData();
        recyclerView = view.findViewById(R.id.requestsRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


    }

    private void loadData() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            APIInterface apiInterface = retrofit.create(APIInterface.class);
            Call<List<DataModel>> call = apiInterface.getList();
            call.enqueue(new Callback<List<DataModel>>() {
                @Override
                public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                    Log.d("Success",response.message());
                    list = new ArrayList<>();
                    list.addAll(response.body());
                    adapter = new RequestAdapter(list,getContext());
                    recyclerView.setAdapter(adapter);

                }

                @Override
                public void onFailure(Call<List<DataModel>> call, Throwable t) {
                    Log.d("Error",t.getMessage());
                }
            });

    }
}