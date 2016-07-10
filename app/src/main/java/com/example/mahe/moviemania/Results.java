package com.example.mahe.moviemania;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by MAHE on 4/10/2016.
 */
public class Results extends Activity {


    Bundle user_input;
    String[] userdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mresult);

        userdata=new String[4];

        user_input=getIntent().getExtras();
        userdata[0]=user_input.getString("m_id");
        userdata[1]=user_input.getString("synopsis");
        userdata[2]=user_input.getString("rel_date");
        userdata[3]=user_input.getString("rating");




        TextView tv1 = (TextView)findViewById(R.id.textView);
        TextView tv2 = (TextView)findViewById(R.id.textView2);
        TextView tv3= (TextView)findViewById(R.id.textView3);
        TextView tv4 = (TextView)findViewById(R.id.textView4);
        tv1.setText(userdata[0]);
        tv2.setText(userdata[1]);
        tv3.setText(userdata[2]);
        tv4.setText(userdata[3]);

        // Close progressdialog


    }


}
