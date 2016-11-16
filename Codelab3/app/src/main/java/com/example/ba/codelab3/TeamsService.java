package com.example.ba.codelab3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jose on 16/11/16.
 */

public interface TeamsService {
    @GET("teams.json")
    Call<List<Team>> listTeam();
}
