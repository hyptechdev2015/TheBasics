package com.thexma.kle.thebasics;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Tien on 3/29/2016.
 */
public class TutorialThree extends AppCompatActivity implements View.OnClickListener {

  ImageView display;
  int toPhone;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    //set full scree
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    setContentView(R.layout.wallpaper);

    toPhone = R.drawable.aodai;

    //TODO define instant from layout
    display = (ImageView) findViewById(R.id.IVdisplay);
    ImageView image1 = (ImageView) findViewById(R.id.IVImage1);
    ImageView image2 = (ImageView) findViewById(R.id.IVImage2);
    ImageView image3 = (ImageView) findViewById(R.id.IVImage3);
    ImageView image4 = (ImageView) findViewById(R.id.IVImage4);

    Button setWall = (Button) findViewById(R.id.BsetWallpaper) ;

    setWall.setOnClickListener(this);
    image1.setOnClickListener(this);
    image2.setOnClickListener(this);
    image3.setOnClickListener(this);
    image4.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId() ) {
      case R.id.IVImage1:
        display.setImageResource(R.drawable.aodai);
        toPhone = R.drawable.aodai;
        break;
      case R.id.IVImage2:
        display.setImageResource(R.drawable.longme1);
        toPhone = R.drawable.longme1;
        break;
      case R.id.IVImage3:
        display.setImageResource(R.drawable.longme2);
        toPhone = R.drawable.longme2;
        break;
      case R.id.IVImage4:
        display.setImageResource(R.drawable.aodai);
        toPhone = R.drawable.aodai;
        break;
      case R.id.BsetWallpaper:
        InputStream strm = getResources().openRawResource(toPhone);
        Bitmap obj = BitmapFactory.decodeStream(strm);
        try{
          getApplicationContext().setWallpaper(obj);
        }
        catch(IOException e){e.printStackTrace();}
        break;
    }
  }
}
