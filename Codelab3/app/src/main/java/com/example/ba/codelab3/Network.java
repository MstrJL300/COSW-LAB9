package com.example.ba.codelab3;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jose on 16/11/16.
 * Here I instantiate the interface and use the service for calling the list of teams.
 */

public class Network {

    private final TeamsService service;

    public Network() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                "https://raw.githubusercontent.com/sancarbar/starting-android-lists/master/" ).
                addConverterFactory(GsonConverterFactory.create()).build();
        service = retrofit.create(TeamsService.class);
    }

    public List<Team> getTeams() throws IOException{

        //"Call" sends a request to a webserver using "service.listTeam" and returns a response using "call.execute".
        Call<List<Team>> call = service.listTeam();
        Response<List<Team>> response = call.execute();
        return response.body();
    }
}
