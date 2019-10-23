package com.example.popovgym;

import com.example.popovgym.pojo.LoginUser;
import com.example.popovgym.pojo.LogoutUser;
import com.example.popovgym.pojo.RegisterUser;
import com.example.popovgym.pojo.ServerResponce;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class GymApi {
    public interface Api {
        @POST("signin")
        Call<ServerResponce> login(@Body LoginUser user);

        @POST("signup")
        Call<ServerResponce> singup(@Body RegisterUser user);

        @POST("signout")
        Call<ServerResponce> logout(@Body LogoutUser user);
    }
    private static String urlBase = "http://gym.areas.su/";
    private static Retrofit retrofit;
    private static Api api;

    public static Api getInstance(){
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(urlBase)
                    .build();
        }
        api = retrofit.create(Api.class);
        return api;
    }

}
