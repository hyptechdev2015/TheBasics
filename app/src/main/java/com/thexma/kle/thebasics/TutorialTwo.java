package com.thexma.kle.thebasics;

import android.app.IntentService;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Tien on 3/29/2016.
 */
public class TutorialTwo extends  ListActivity {

  String classNames[] ={"MainActivity","menu", "Sweet","TutorialOne"};


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, classNames));

  }

  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    super.onListItemClick(l, v, position, id);
    String openClass = classNames[position];
    try{
      Class selected = Class.forName("com.thexma.kle.thebasics." + openClass);
      Intent selectedIntent = new Intent(this,selected);
      startActivity(selectedIntent);
    }
    catch (ClassNotFoundException e){ e.printStackTrace();}
  }

}
