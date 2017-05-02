package com.example.priyanjul.acmjuit;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * Created by Priyanjul on 11-04-2017.
 */

public class Pop3 extends Activity {

    TextView head, cont;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop3);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;
        getWindow().setLayout((int)(width),(int)(height*0.4));

        head=(TextView)findViewById(R.id.head);
        cont=(TextView)findViewById(R.id.cont);

        Typeface myFont1 = Typeface.createFromAsset(getAssets(),"fonts/HelveticaNeue Medium.ttf");
        Typeface myFont2 = Typeface.createFromAsset(getAssets(),"fonts/HelveticaNeue Thin.ttf");

        head.setTypeface(myFont1);
        cont.setTypeface(myFont2);




    }
}
