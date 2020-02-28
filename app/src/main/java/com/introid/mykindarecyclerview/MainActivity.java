package com.introid.mykindarecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.introid.mykindarecyclerview.Adapter.GroupAdapter;
import com.introid.mykindarecyclerview.model.Group;
import com.introid.mykindarecyclerview.model.Movie;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Serializable {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private GroupAdapter groupAdapter;
    private ArrayList<Group> groups;
    private ArrayList<Movie> simple;
    private ArrayList<Movie> simple2;
    private ArrayList<Movie> simple3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
       setAdapterType();
       setAdapter();
    }
    public void initGroupData(){
        groups= new ArrayList<>(  );
        groups.add( new Group( "simple1" ) );
        groups.add( new Group( "simple2" ) );
        groups.add( new Group( "simple3" ) );

    }
    public void initMovieData(){
        simple= new ArrayList<>(  );



        simple.add( new Movie("https://i.redd.it/obx4zydshg601.jpg" ) );
        simple.add( new Movie("https://i.redd.it/tpsnoz5bzo501.jpg" ) );
        simple.add( new Movie("https://i.redd.it/qn7f9oqu7o501.jpg" ) );
        simple.add( new Movie("https://i.redd.it/j6myfqglup501.jpg" ) );
        simple.add( new Movie("https://i.redd.it/0h2gm1ix6p501.jpg" ) );
        simple.add( new Movie("https://i.redd.it/k98uzl68eh501.jpg" ) );

        simple2= new ArrayList<>(  );
        simple2.add( new Movie("https://i.redd.it/j6myfqglup501.jpg" ) );
        simple2.add( new Movie("https://i.redd.it/0h2gm1ix6p501.jpg" ) );
        simple2.add( new Movie("https://i.redd.it/k98uzl68eh501.jpg" ) );
        simple2.add( new Movie("https://i.redd.it/glin0nwndo501.jpg" ) );
        simple2.add( new Movie("https://i.redd.it/obx4zydshg601.jpg" ) );

        simple3= new ArrayList<>(  );
        simple3.add( new Movie("https://i.redd.it/k98uzl68eh501.jpg" ) );
        simple3.add( new Movie("https://i.redd.it/glin0nwndo501.jpg" ) );
        simple3.add( new Movie("https://i.redd.it/obx4zydshg601.jpg" ) );

    }
    private void setAdapterType(){
        recyclerView= findViewById( R.id.recyclerView );
        layoutManager= new LinearLayoutManager( this );
        recyclerView.setLayoutManager( layoutManager );
    }
    private void setAdapter(){
        initGroupData();
        initMovieData();

        groupAdapter= new GroupAdapter( MainActivity.this,groups,simple,simple2,simple3 );
        recyclerView.setAdapter( groupAdapter );
    }
}
