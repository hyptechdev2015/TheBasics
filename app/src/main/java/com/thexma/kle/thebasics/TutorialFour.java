package com.thexma.kle.thebasics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Tien on 3/29/2016.
 */
public class TutorialFour extends AppCompatActivity {

  DrawingTheBall v;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    v = new DrawingTheBall(TutorialFour.this);

    setContentView(v);

  }
}
