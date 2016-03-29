package com.thexma.kle.thebasics;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  MediaPlayer logoMusic;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);

    logoMusic = MediaPlayer.create(MainActivity.this, R.raw.splash);
    logoMusic.start();

    Thread logoTimer = new Thread() {
      public void run() {
        try {
          sleep(1000);
          Intent menuIntent = new Intent("com.thexma.kle.thebasics.MENU");
          startActivity(menuIntent);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          finish();
        }
      }
    };
    logoTimer.start();
  }

  @Override
  protected void onStop() {
    super.onStop();
    logoMusic.release();
  }

}
