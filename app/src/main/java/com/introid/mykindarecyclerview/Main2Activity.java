package com.introid.mykindarecyclerview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.introid.mykindarecyclerview.Adapter.RecyclerViewStaggered;
import com.introid.mykindarecyclerview.model.Movie;

import java.io.Serializable;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements Serializable {
    private static final int NUPL_COLUMS=2;
    private static final String TAG = "MAIN2";

    public ArrayList<Movie> mImageUrls= new ArrayList<>();

//    private ArrayList<String> mNames=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );
        initRecyclerVIew();
    }
//    public void IncomingIntent(){
//        Bundle bundleObject1= getIntent().getExtras();
//        mImageUrls= (ArrayList<Movie>)bundleObject1.getSerializable( "simple" );
//
//
//    }
//
    private void IncomingIntent(){
        try {
    Log.d( TAG, "IncomingIntent: " );
    if(getIntent().hasExtra( "simple" )) {
        Log.d( TAG, "IncomingIntent: simple" );
        mImageUrls = (ArrayList<Movie>) getIntent().getSerializableExtra( "simple" );
    } else if (getIntent().hasExtra( "simple2" )){
        Log.d( TAG, "IncomingIntent: simple2" );
        mImageUrls= (ArrayList<Movie>)getIntent().getSerializableExtra( "simple2" );
    }else if( getIntent().hasExtra( "simple3" )){
        Log.d( TAG, "IncomingIntent: simple3" );
        mImageUrls= (ArrayList<Movie>)getIntent().getSerializableExtra( "simple3" );
    }
} catch (Exception e) {
    e.printStackTrace();
}
    }
    private void initRecyclerVIew(){
        IncomingIntent();
        RecyclerView recyclerView2=findViewById( R.id.recyclerView2 );
        RecyclerViewStaggered recyclerViewStaggered= new RecyclerViewStaggered(
                 mImageUrls,this);
        StaggeredGridLayoutManager staggeredGridLayoutManager= new StaggeredGridLayoutManager( NUPL_COLUMS,
                LinearLayoutManager.VERTICAL );
        recyclerView2.setLayoutManager(staggeredGridLayoutManager);
        recyclerView2.setAdapter(recyclerViewStaggered);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );

    }
}
