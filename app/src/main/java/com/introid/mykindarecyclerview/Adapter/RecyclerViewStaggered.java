package com.introid.mykindarecyclerview.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.introid.mykindarecyclerview.R;
import com.introid.mykindarecyclerview.model.Movie;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.Serializable;
import java.util.ArrayList;

import static java.lang.String.*;

public class RecyclerViewStaggered extends RecyclerView.Adapter<RecyclerViewStaggered.ViewHolder> implements Serializable {
    private static final String TAG="RecyclerViewStaggered";

//    private ArrayList<String> mNames= new ArrayList<>();
    public ArrayList<Movie> mImageUrls= new ArrayList<>();
    public Context mContext;

    public RecyclerViewStaggered( ArrayList<Movie> mImageUrls, Context mContext) {
//        this.mNames = mNames;
        this.mImageUrls = mImageUrls;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .layout_grid_item,parent,false);

        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewStaggered.ViewHolder holder,final int position) {

        Log.d(TAG, "onBindViewHolder:called ");
        setimage(holder.image,mImageUrls.get( position ).getMoviePictureURL());

//        RequestOptions requestOptions= new RequestOptions()
//                .placeholder(R.drawable.ic_launcher_background);


//        Glide.with(mContext)
//                .load(mImageUrls.get(position))
//                .apply(requestOptions)
//                .into(holder.image);

//        holder.name.setText(mNames.get(position));
//        Picasso.get()
//                .load( valueOf( mImageUrls.get(position  ) ) )
//                .fit()
//                .centerCrop()
//                .into(holder.image  );


//        holder.image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, (CharSequence) mImageUrls.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });


    }
    private void setimage(final ImageView image,String moviePictureURL){
        Log.d( TAG, "setimage: set Image Called" );
        Picasso.get().load( moviePictureURL).fit().centerCrop().into( image, new Callback() {
            
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {
                image.setBackgroundResource( R.drawable.ic_launcher_background );
            }
        } );
    }
    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;


        public ViewHolder(View itemView) {
            super(itemView);
            image= itemView.findViewById(R.id.imageAdapter);

        }
    }

}
