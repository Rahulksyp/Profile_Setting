package com.example.profilesetting.network;

import com.example.profilesetting.model.DataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("/posts")
    Call<List<DataModel>> getList();
}
