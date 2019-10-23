package com.example.popovgym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.popovgym.pojo.LoginUser;
import com.example.popovgym.pojo.LogoutUser;
import com.example.popovgym.pojo.RegisterUser;
import com.example.popovgym.pojo.ServerResponce;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public Retrofit retrofitw;
    EditText editTextlogin;
    EditText editTextpass;
    EditText editTextemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextlogin = findViewById(R.id.editText);
        editTextpass = findViewById(R.id.editText2);
    }
     public void ddd(View v){
        GymApi.getInstance()
                .login(new LoginUser(editTextlogin.getText().toString(), editTextpass.getText().toString()))
                .enqueue(new Callback<ServerResponce>() {
            @Override
            public void onResponse(Call<ServerResponce> call, Response<ServerResponce> response) {
                if (response.body().getNotice().getAnswer()!=null) {
                    Toast.makeText(getApplicationContext(), ""+response.body().getNotice().getAnswer(), Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), ""+response.body().getNotice().getToken(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ServerResponce> call, Throwable throwable) {
                Toast.makeText(getApplicationContext(), "no network", Toast.LENGTH_LONG).show();
            }
        });
     }

     public void fff(View v){
        GymApi.getInstance().logout(new LogoutUser(editTextlogin.getText().toString())).enqueue(new Callback<ServerResponce>() {
            @Override
            public void onResponse(Call<ServerResponce> call, Response<ServerResponce> response) {
                Toast.makeText(getApplicationContext(), ""+response.body().getNotice().getText(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ServerResponce> call, Throwable throwable) {
                Toast.makeText(getApplicationContext(), "no network", Toast.LENGTH_LONG).show();
            }
        });
     }

     public void ggg(View v){
         GymApi.getInstance().singup(new RegisterUser(editTextlogin.getText().toString(), editTextemail.getText().toString(), editTextpass.getText().toString(), 32, 32)).enqueue(new Callback<ServerResponce>() {
             @Override
             public void onResponse(Call<ServerResponce> call, Response<ServerResponce> response) {
                 Toast.makeText(getApplicationContext(), ""+response.body().getNotice().getText(), Toast.LENGTH_LONG).show();
             }

             @Override
             public void onFailure(Call<ServerResponce> call, Throwable throwable) {
                 Toast.makeText(getApplicationContext(), "no network", Toast.LENGTH_LONG).show();
             }
         });
     }
}
