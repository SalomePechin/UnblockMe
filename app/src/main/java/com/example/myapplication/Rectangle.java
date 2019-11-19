package com.example.myapplication;

public class Rectangle {

    private int longueur;
    private String orientation;

    public Rectangle(int longueur, String orientation) {
        this.longueur = longueur;
        this.orientation = orientation;
    }

    public int getLongueur() {
        return longueur;
    }

    public String getOrientation() {
        return orientation;
    }
}
