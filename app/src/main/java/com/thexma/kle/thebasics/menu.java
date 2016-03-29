package com.thexma.kle.thebasics;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by kle on 3/28/2016.
 */
public class menu extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Button sound
     final MediaPlayer buttonSound = MediaPlayer.create(menu.this, R.raw.click01);

    //button ref
    Button tut1 = (Button) findViewById(R.id.tutorial1);
    Button tut2 = (Button) findViewById(R.id.tutorial2);
    tut1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        buttonSound.start();
        startActivity(new Intent("com.thexma.kle.thebasics.TUTORIALONE"));
      }
    });

    tut2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent("com.thexma.kle.thebasics.TUTORIALONE"));
      }
    });
  }

  @Override
  protected void onStop() {
    super.onStop();
  }

}
