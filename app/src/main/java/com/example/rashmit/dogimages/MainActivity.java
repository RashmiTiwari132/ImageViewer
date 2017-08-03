package com.example.rashmit.dogimages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * This class displays each image one by one with the click of a button
 * */

public class MainActivity extends AppCompatActivity {

    int id = 0;
    final int max_id = 9;
    private final Integer[] mThumbIds = {
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_8
    };

    public RecyclerView mRecyclerView;
    public LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.image_layout);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(new ImageAdapter(getApplicationContext(), mThumbIds, this));

        //changeImage();
    }

    public void changeImage(){
        Button btnChangeImage  = (Button) findViewById(R.id.btnChangeImage);
        final ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        btnChangeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = ((id + 1) % max_id);
                imageView1.setImageResource(mThumbIds[id]);
            }
        });
    }
}
