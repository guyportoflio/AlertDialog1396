package com.example.presly.alertdialog1396;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener{

    LinearLayout linearLayout;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout) findViewById(R.id.theLayout);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
      if (which == Dialog.BUTTON_POSITIVE){
          //change background color
          String color = "#";
          Random rnd = new Random();
              for(int i = 0; i < 6; ++i) {
                  int c = rnd.nextInt(6);
                  if(c == 0){
                     color = "" + color + "A";
                  }
                  else if(c == 1){
                      color = "" + color + "B";
                  }
                  else if(c == 2){
                      color = "" + color + "C";
                  }
                  else if(c == 3){
                      color = "" + color + "D";
                  }
                  else if(c == 4){
                      color = "" + color + "E";
                  }
                  else if(c == 5){
                      color = "" + color + "F";
                  }

              }

          result = Color.parseColor(color);
          linearLayout.setBackgroundColor(result);

      }

      else if(which == Dialog.BUTTON_NEGATIVE){
          //do nothing
      }
    }

    public void buttonPressed(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        alertDialog.setTitle("Change Background");
        alertDialog.setMessage("would you like to change the background color?");

        alertDialog.setButton(Dialog.BUTTON_POSITIVE,"YES", this);
        alertDialog.setButton(Dialog.BUTTON_NEGATIVE, "NO", this);

        alertDialog.setCancelable(false);

        alertDialog.show();

    }
}
