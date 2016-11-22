package com.example.ba.codelab3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by god damn handsome jose on 16/11/16.
 * Interface that contains the url of the API for future use.
 */

public interface TeamsService {
    @GET("teams.json")
    Call<List<Team>> listTeam();
}
