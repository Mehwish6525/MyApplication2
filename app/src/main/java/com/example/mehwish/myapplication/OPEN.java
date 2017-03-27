package com.example.mehwish.myapplication;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;

public class OPEN extends AppCompatActivity {
    private static int[] listview_images = {R.drawable.shape,R.drawable.shape1,R.drawable.shape2,R.drawable.shape3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        TextView tv = ((TextView)findViewById(R.id.textView2));
        tv.setText(getIntent().getStringExtra("KEY_StringName"));
        TextView tv2 = ((TextView)findViewById(R.id.textView3));
        tv2.setText(getIntent().getStringExtra("KEY_StringName1"));
        TextView tv3 = ((TextView)findViewById(R.id.textView));
        tv3.setText(getIntent().getStringExtra("KEY_StringName2"));
        int ind=Integer.parseInt(getIntent().getStringExtra("KEY"));
        tv3.setBackgroundResource(listview_images[ind]);
        }
}
