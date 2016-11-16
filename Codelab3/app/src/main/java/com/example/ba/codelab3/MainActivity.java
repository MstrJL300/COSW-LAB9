package com.example.ba.codelab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity{

    Network network = new Network();
    ExecutorService executorService = Executors.newFixedThreadPool(1);
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("1||"+network.getTeams());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void configureRecyclerView(){
        recyclerView = (RecyclerView) findViewById((R.id.recyclerView));
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
