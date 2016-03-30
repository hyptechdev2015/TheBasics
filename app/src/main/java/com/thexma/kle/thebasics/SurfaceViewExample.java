package com.thexma.kle.thebasics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by Tien on 3/29/2016.
 */

public class SurfaceViewExample extends AppCompatActivity implements View.OnTouchListener {

  OurView v;
  Bitmap ball, blob;

  Sprite sprite;

  float x, y;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    v = new OurView(this);
    v.setOnTouchListener(this);
    ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
    blob = BitmapFactory.decodeResource(getResources(), R.drawable.runningGrant);
    x = y = 0;
    setContentView(v);
  }

  @Override
  protected void onPause() {
    super.onPause();
    v.pause();
  }

  @Override
  protected void onResume() {
    super.onResume();
    v.resume();
  }

  @Override
  public boolean onTouch(View v, MotionEvent event) {

    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    switch (event.getAction()) {
      case MotionEvent.ACTION_DOWN:
        x = event.getX();
        y = event.getY();
        break;
      case MotionEvent.ACTION_UP:
        x = event.getX();
        y = event.getY();
        break;
      case MotionEvent.ACTION_MOVE:
        x = event.getX();
        y = event.getY();
        break;
    }

    return true;
  }

  /**
   * defined View Class
   */
  public class OurView extends SurfaceView implements Runnable {
    Thread t;

    SurfaceHolder holder = null;
    boolean isItOk = false;


    public OurView(Context context) {
      super(context);
      holder = getHolder();
      sprite = new Sprite(this, blob);
    }

    @Override
    public void run() {
      while (isItOk == true) {
        //perform canvas drawing
        if (!holder.getSurface().isValid()) {
          continue;
        }
        Canvas c = holder.lockCanvas();
        //c.drawARGB(255,155,150,12);
        //c.drawBitmap(ball,x-(ball.getWidth()/2),y-(ball.getHeight()/2),null);
        meDraw(c);
        holder.unlockCanvasAndPost(c);

      }
    }

    protected void meDraw(Canvas c) {
      c.drawARGB(255, 155, 150, 12);
      c.drawBitmap(ball, x - (ball.getWidth() / 2), y - (ball.getHeight() / 2), null);
      //TODO 1.34 tutorial
      sprite.meDraw(c);
    }

    public void pause() {
      isItOk = false;
      while (true) {
        try {
          t.join();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        break;
      }
      t = null;
    }

    public void resume() {
      isItOk = true;
      t = new Thread(this);
      t.start();
    }

  }
}
