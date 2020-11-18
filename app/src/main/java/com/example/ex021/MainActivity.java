package com.example.ex021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

/**
 * @author Tahel Hazan <th8887@bs.amalnet.k12.il>
 * @version	1.1.3
 * @since 18.11.2020
 * the user can press one of the buttons and an AlertDialog will show,
 * in the 4th and the 5th buttons the yser can change the background color too.
 */
public class MainActivity extends AppCompatActivity {
    Random rnd = new Random();
    AlertDialog.Builder adb;
    /**
     *bg=background.
     */
    LinearLayout bg;
    /**
     * @param color - the number of the random color.
     */
    int color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bg=(LinearLayout) findViewById(R.id.bg);
    }

    /**
     * Alertm.
     *
     * @param view the view
     * creates an AlertDialog with a short message
     */
    public void alertm(View view) {
        adb=new AlertDialog.Builder(this);
        adb.setTitle("you have a message");
        adb.setMessage("hello there 😀");
        AlertDialog ad= adb.create();
        ad.show();
    }

    /**
     * Mes pic 1.
     *
     * @param view the view
     *creates an AlertDialog with a picture and a short message.
     */
    public void mesPic1(View view) {
        adb=new AlertDialog.Builder(this);
        adb.setTitle("Short Message:");
        adb.setMessage("you have a picture");
        adb.setIcon(R.drawable.bear1);
        AlertDialog ad= adb.create();
        ad.show();
    }

    /**
     * Mes pic 2.
     *
     * @param view the view
     * shows an AlertDialog with a message, a picture and a button to close it.
     */
    public void mesPic2(View view) {
        adb=new AlertDialog.Builder(this);
        adb.setTitle("Short Message:");
        adb.setMessage("hi there, you can close this message at the bottom!😀");
        adb.setIcon(R.drawable.bear2);
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad= adb.create();
        ad.show();
    }

    /**
     * Color alert 1.
     *
     * @param view the view
     * shows an AlertDialog with a message, a picture, a button to close it and the user
     *            can change the color of the background.
     */
    public void colorAlert1(View view) {
        adb=new AlertDialog.Builder(this);
        adb.setTitle("Color Alert!");
        adb.setMessage("Now you can choose to change the background to a random color 😀");
        adb.setPositiveButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color= Color.argb(255,rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256));
                bg.setBackgroundColor(color);
            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad= adb.create();
        ad.show();
    }

    /**
     * Color alert 2.
     *
     * @param view the view
     * shows an AlertDialog with a message, a picture, a button to close it, the user can change the
     *             color of the background and he can reset the background to white.
     */
    public void colorAlert2(View view) {
        adb=new AlertDialog.Builder(this);
        adb.setTitle("Color Alert!");
        adb.setMessage("Now you can reset the background too 😀");
        adb.setPositiveButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int color= Color.argb(255,rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256));
                bg.setBackgroundColor(color);
            }
        });
        adb.setNeutralButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                bg.setBackgroundColor(Color.WHITE);
            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad= adb.create();
        ad.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Btnp.
     *
     * @param item the item
     * Sends a Toast to let the user know he is in the current page he chose from the OptionMenu.
     */
    public void btnp(MenuItem item) {
        Toast.makeText(this, "You are already here :)", Toast.LENGTH_SHORT).show();
    }

    /**
     * Cred.
     *
     * @param item the item
     * moves from main activity to Credits.
     */
    public void cred(MenuItem item) {
        Intent c= new Intent(this,Credits.class);
        startActivity(c);
    }
}