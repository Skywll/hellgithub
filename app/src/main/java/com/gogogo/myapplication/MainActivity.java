package com.gogogo.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView viewById = (ImageView) findViewById(R.id.iv);

        String url ="http://p1.pstatp.com/large/166200019850062839d3";
                Glide.with(this)
                        .load(url)
                        .asBitmap()
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.drawable.error)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(viewById);

    }

    public void loadimage(View view) {

    }
}
