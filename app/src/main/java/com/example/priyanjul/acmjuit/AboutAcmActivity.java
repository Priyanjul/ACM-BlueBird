package com.example.priyanjul.acmjuit;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Priyanjul on 24-03-2017.
 */


public class AboutAcmActivity extends Fragment {


    TextView head1,head2;
    ImageButton btn1,btn2,btn3,btn4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.about_acm, container, false);

        head1 = (TextView)v.findViewById(R.id.head1);
        head2 = (TextView)v.findViewById(R.id.head2);
        Typeface myFont1 = Typeface.createFromAsset(getActivity().getAssets(),"fonts/thundertrooperexpand.ttf");
        Typeface myFont2 = Typeface.createFromAsset(getActivity().getAssets(),"fonts/thundertroopergrad.ttf");
        head1.setTypeface(myFont1);
        head2.setTypeface(myFont2);


        btn1 = (ImageButton)v.findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View vi) {
                startActivity(new Intent(AboutAcmActivity.this.getActivity(),Pop1.class));

            }
        });

        btn2 = (ImageButton)v.findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View vi) {
                startActivity(new Intent(AboutAcmActivity.this.getActivity(),Pop2.class));

            }
        });

        btn3 = (ImageButton)v.findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View vi) {
                startActivity(new Intent(AboutAcmActivity.this.getActivity(),Pop3.class));

            }
        });

        btn4 = (ImageButton)v.findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View vi) {
                startActivity(new Intent(AboutAcmActivity.this.getActivity(),Pop4.class));

            }
        });


        return v;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("ACM BlueBird");
    }
}
