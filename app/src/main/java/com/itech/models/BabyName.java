package com.itech.models;

/**
 * Created by oSunshine on 08/08/2015.
 */
public class BabyName {

    private String name ;
    private boolean checked ;
    private String genre ;



    public BabyName(String name, boolean checked) {
        this.name = name;
        this.setChecked(checked);
    }
    public BabyName(String name, boolean checked, String genre) {
        this.name = name;
        this.setChecked(checked);
        this.setGenre(genre);
    }

    public BabyName(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }



    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
