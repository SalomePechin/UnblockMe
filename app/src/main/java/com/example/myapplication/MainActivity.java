package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.gesture.Gesture;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    // Déclarer les attributs
    private Plateau plateau;
    private Rectangle p1, p2, p3, p4;
    private List<ImageButton> listePieces;
    private ImageButton piece1, piece2, piece3, piece4;
    private GestureDetectorCompat gestureDetector;
    private ImageButton pieceSelec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instancier les attributs
        listePieces = new ArrayList<>();
        gestureDetector = new GestureDetectorCompat(this, this);

        plateau = new Plateau();

        p1 = new Rectangle(3,"horizontal");
        p2 = new Rectangle(3, "vertical");
        p3 = new Rectangle(2,"horizontal");
        p4 = new Rectangle(2, "vertical");

        plateau.ajouterPiece(p1, 0, 0);
        plateau.ajouterPiece(p3, 1, 1);
        plateau.ajouterPiece(p2, 5, 2);
        plateau.ajouterPiece(p4, 2, 3);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        piece1 = (ImageButton) findViewById(R.id.piece1);
        piece2 = (ImageButton)  findViewById(R.id.piece2);
        piece3 = (ImageButton)  findViewById(R.id.piece3);
        piece4 = (ImageButton)  findViewById(R.id.piece4);

        listePieces.add(piece1);
        listePieces.add(piece2);
        listePieces.add(piece3);
        listePieces.add(piece4);

        float x, y;

        for (final ImageButton piece : listePieces) {
            piece.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    pieceSelec = piece;
                }
            });
        }
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {
        if (e1.getX() < e2.getX() && (e2.getX() - e1.getX()) > (e2.getY() - e1.getY())){
            Log.e("gauche_droite", "de gauche à droite");
        } else if (e1.getX() > e2.getX() && (e1.getX() - e2.getX()) > (e1.getY() - e2.getY())){
            Log.e("droite_gauche", "de droite à gauche");
        } else if (e1.getY() < e2.getY() && (e2.getX() - e1.getY()) > (e2.getX() - e1.getX())) {
            Log.e("haut_bas", "de haut en bas");
        } else if (e1.getY() > e2.getY() && (e1.getX() - e2.getY()) > (e1.getX() - e2.getX())) {
        Log.e("haut_bas", "de haut en bas");
    }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        this.gestureDetector.onTouchEvent(e);
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
