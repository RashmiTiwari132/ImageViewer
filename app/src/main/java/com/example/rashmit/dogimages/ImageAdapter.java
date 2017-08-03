package com.example.rashmit.dogimages;

/**
 * Created by RashmiT on 8/3/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.Button;
import android.widget.ImageView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private Context mContext;
    private Integer[] imageIds;
    private MainActivity mainActivity;

    public ImageAdapter(Context mContext, Integer[] imageIds, MainActivity mainActivity){
        this.mContext = mContext;
        this.imageIds = imageIds;
        this.mainActivity = mainActivity;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public Button btnChangeImage;
        public ImageView imageView1;
        public ViewHolder(View v){
            super(v);
            btnChangeImage = (Button) v.findViewById(R.id.btnChangeImage);
            imageView1 = (ImageView) v.findViewById(R.id.imageView1);
        }
    }

    public ImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        final ViewHolder holder1 = holder;
        holder1.imageView1.setImageResource(imageIds[mainActivity.id]);
        holder1.btnChangeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.id = ((mainActivity.id + 1) % mainActivity.max_id);
                holder1.imageView1.setImageResource(imageIds[mainActivity.id]);
            }
        });
        Log.d("ImageAdapter", "onBindViewHolder");
    }

    public int getItemCount(){
        return imageIds.length;
    }
}