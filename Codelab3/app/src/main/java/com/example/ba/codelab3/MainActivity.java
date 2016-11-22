package com.example.ba.codelab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Adapter.TeamsAdapter;

public class MainActivity extends AppCompatActivity{

    Network network = new Network();
    List<Team> teams=new ArrayList<Team>();
    //After calling Network I use "ExecutorService" to execute the code on the
    //background thread to avoid an error
    ExecutorService executorService = Executors.newFixedThreadPool(1);

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //I now use the method "executorService.execute" to execute the code on
        //the background.
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    teams = network.getTeams();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            recyclerView.setAdapter(new TeamsAdapter(teams));
                        }
                    });
                    //System.out.println("1||"+network.getTeams()); //I used this to check if the function was working
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        //This function adds values to the "recyclerView" in the layout.
        configureRecyclerView();
    }

    private void configureRecyclerView(){
        recyclerView = (RecyclerView) findViewById((R.id.recyclerView));
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
