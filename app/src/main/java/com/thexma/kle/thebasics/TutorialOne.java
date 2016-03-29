package com.thexma.kle.thebasics;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by Tien on 3/29/2016.
 */
public class TutorialOne extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    TextView textOut;
    EditText textIn;
    RadioGroup gravityG, styleG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial1);
        textOut = (TextView) findViewById(R.id.tvChange);
        textIn = (EditText) findViewById(R.id.editText1);
        gravityG = (RadioGroup) findViewById(R.id.rgGravity);
        gravityG.setOnCheckedChangeListener(this);
        styleG = (RadioGroup) findViewById(R.id.rgStyle);
styleG.setOnCheckedChangeListener(this);

        Button gen = (Button) findViewById(R.id.btnGenerate);
        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textIn.getText());
            }
        });

    }

    //TODO DONE at 16

    public void onCheckedChanged(RadioGroup group, int checkedID ) {
        switch (checkedID){
            case R.id.rbLeft:
                textOut.setGravity(Gravity.LEFT);
                break;
            case R.id.rbCenter:
                textOut.setGravity(Gravity.CENTER);
                break;
            case R.id.rbRight:
                textOut.setGravity(Gravity.RIGHT);
                break;
            case R.id.rbNormal:
                textOut.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL), Typeface.NORMAL);
                break;
            case R.id.rbItalic:
                textOut.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC), Typeface.ITALIC);
                break;
            case R.id.rbBold:
                textOut.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD), Typeface.BOLD);
                break;
        }
    }
}
