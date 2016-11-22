package com.example.ba.codelab3;

import java.net.URL;

/**
 * Created by jose on 16/11/16.
 */

/**
 * Class that contains going to contain the structure of the data to download.
 */
public class Team {

    int id;
    String name;
    String shortName;
    URL imageUrl;

    Team(){
    }

    Team(int id, String name, String shortName, URL imageUrl){

        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public URL getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(URL imageUrl) {
        this.imageUrl = imageUrl;
    }

}
