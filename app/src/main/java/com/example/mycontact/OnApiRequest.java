package com.example.mycontact;


import com.example.mycontact.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;


public interface OnApiRequest {


    @GET("todos")
    Call<List<User>> getUser();


    @POST
    Call<Object> postNotification(@Url String url);

}
