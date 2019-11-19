package com.example.myapplication;

import android.util.Log;

import java.util.Arrays;

public class Plateau {

    private int[][] tab;

    public Plateau(){
        int i, j;
        tab = new int[6][6];
        for (i = 0; i < tab.length; i++){
            for (j = 0; j < tab.length; j++){
                tab[i][j] = 0;
            }
        }
    }

    // On utilise les caractéristiques du rectangle pour bien le placer
    public void ajouterPiece(Rectangle rect, int x, int y){
        int i = 0, j = 0;
        if (rect.getOrientation() == "horizontal" && rect.getLongueur() == 2){
            for (i = x; i <= x + (rect.getLongueur() - 1); i++){
                tab[i][y] = 1;
            }
        }
        if (rect.getOrientation() == "horizontal" && rect.getLongueur() == 3){
            for (i = x; i <= x + (rect.getLongueur() - 1); i++){
                tab[i][y] = 1;
            }
        }
        if (rect.getOrientation() == "vertical" && rect.getLongueur() == 2){
            for (j = y; j <= y + (rect.getLongueur() -  1); j++){
                tab[x][j] = 1;
            }
        }
        if (rect.getOrientation() == "vertical" && rect.getLongueur() == 3){
            for (j = y; j <= y + (rect.getLongueur() -  1); j++){
                tab[x][j] = 1;
            }
        }
    }



//    @Override
//    public String toString() {
//        int i, j;
//        for (i = 0; i < tab.length; i++){
//            for (j = 0; j < tab.length; j++){
//                Log.e("Tableau " + i + ";" + j + " ", tab[i][j] + "");
//            }
//        }
//    return "";
//    }
}
