package com.thexma.kle.thebasics;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
    Button tut3 = (Button) findViewById(R.id.tutorial3);
    tut1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        buttonSound.start();
        startActivity(new Intent("com.thexma.kle.thebasics.TUTORIALONE"));
      }
    });
    //TODO open list view button
    tut2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent("com.thexma.kle.thebasics.TUTORIALTWO"));
      }
    });
    tut3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent("com.thexma.kle.thebasics.TUTORIALTHREE"));
      }
    });
  }

  @Override
  protected void onStop() {
    super.onStop();
  }

  public boolean onCreateOptionsMenu(Menu menu){
    super.onCreateOptionsMenu(menu);
    MenuInflater awesome = getMenuInflater();
    awesome.inflate(R.menu.main_menu, menu);
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem item){
    switch(item.getItemId() ){
      case R.id.menuSweet:
        startActivity(new Intent("com.thexma.kle.thebasics.SWEET"));
        return  true;
      case R.id.menuToast:
        //TODO setup in next tur
        Toast addEggs = Toast.makeText(menu.this, "This is a toast", Toast.LENGTH_LONG);
        addEggs.show();
        return true;
    }
    return false;
  }

}
