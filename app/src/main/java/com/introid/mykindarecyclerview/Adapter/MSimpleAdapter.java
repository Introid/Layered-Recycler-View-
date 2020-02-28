package com.introid.mykindarecyclerview.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.introid.mykindarecyclerview.R;
import com.introid.mykindarecyclerview.model.Movie;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

public class MSimpleAdapter extends RecyclerView.Adapter<MSimpleAdapter.ViewHolder> implements Serializable {
    private Context context;
    ArrayList<Movie> movies;

    public MSimpleAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MSimpleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( parent.getContext() ).inflate( R.layout.simple_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MSimpleAdapter.ViewHolder holder, int position) {
        setImage(holder.item_simple_pictue,movies.get( position ).getMoviePictureURL());
        setOnClick(holder.simple_parent,position);
    }

    private void setImage(final ImageView item_simple_pictue, String moviePictureURL) {
        Picasso.get().load( moviePictureURL ).fit().centerCrop().into( item_simple_pictue, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {
                item_simple_pictue.setBackgroundResource( R.drawable.ic_launcher_background );
            }
        } );
    }

    private void setOnClick(RelativeLayout simple_parent, final int position) {
        simple_parent.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                    Toast.makeText(context, position , Toast.LENGTH_LONG).show();

            }
        } );
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
       public ImageView item_simple_pictue;
       public RelativeLayout simple_parent;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            item_simple_pictue= itemView.findViewById( R.id.item_simple_picture );
            simple_parent= itemView.findViewById( R.id.simple_parent );
        }

        @Override
        public void onClick(View view) {

        }
    }
}
