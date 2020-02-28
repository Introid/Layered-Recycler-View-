package com.introid.mykindarecyclerview.Adapter;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.introid.mykindarecyclerview.Main2Activity;
import com.introid.mykindarecyclerview.R;
import com.introid.mykindarecyclerview.model.Group;
import com.introid.mykindarecyclerview.model.Movie;

import java.io.Serializable;
import java.util.ArrayList;



public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> implements Serializable {
    public static final String TAG1 = "GroupAdapter";
private Context context;
private ArrayList<Group> groups;
private ArrayList<Movie> simple;
private ArrayList<Movie> simple2;
private ArrayList<Movie> simple3;

    public GroupAdapter(Context context, ArrayList<Group> groups, ArrayList<Movie> simple,ArrayList<Movie> simple2,ArrayList<Movie> simple3) {
        this.context = context;
        this.groups = groups;
        this.simple = simple;
        this.simple2= simple2;
        this.simple3=simple3;
    }
    @NonNull
    @Override
    public GroupAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate( R.layout.group_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupAdapter.ViewHolder holder, int position) {
        setGroupTitle(holder.group_title,groups.get( position ).getGroupTitle());
        setOnClickViewAll(holder.head_parent,groups.get( position ).getGroupTitle(),position);
        setLists(holder.group_recycler_view,position);
    }

    @Override
    public int getItemCount() {
        return groups.size();
    }

    private void setGroupTitle(TextView group_title, String groupTitle) {
        group_title.setText(groupTitle);
        }
    private void setOnClickViewAll(RelativeLayout group_title, final String groupTitle, final int position) {
        group_title.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
                        Intent intent= new Intent(context, Main2Activity.class );
                        Bundle bundle1= new Bundle(  );
                        bundle1.putSerializable( "simple",  simple );
                        intent.putExtras(bundle1);
                        context.startActivity(intent);
                        Log.d( TAG1, "onClick: First Layer Clicked " );
                        break;

                    case 1:
                        Intent intent1= new Intent(context, Main2Activity.class );
                        Bundle bundle2= new Bundle();
                        bundle2.putSerializable( "simple2",simple2 );
                        intent1.putExtras( bundle2 );
                        context.startActivity(intent1);
                        Log.d( TAG1, "onClick: Second Layer Clicked " );
                        break;
                    case 2:
                        Intent intent3= new Intent(context, Main2Activity.class );
                        Bundle bundle3= new Bundle(  );
                        bundle3.putSerializable( "simple3",  simple3 );
                        intent3.putExtras( bundle3 );
                        context.startActivity(intent3);
                        Log.d( TAG1, "onClick: Third Layer clicked" );
                        break;
                }
            }
        } );

//        head_parent.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Toast.makeText( context, groupTitle, Toast.LENGTH_SHORT ).show();
//                switch (position){
//                    case 0:
//                        Intent intent= new Intent(context, Main2Activity.class );
//                        Bundle bundle1= new Bundle(  );
//                        bundle1.putSerializable( "simple",  simple );
//                        intent.putExtras(bundle1);
//                        context.startActivity(intent);
//                        break;
//                    case 1:
//                        Intent intent1= new Intent(context, Main2Activity.class );
//                        Bundle bundle2= new Bundle();
//                        bundle2.putSerializable( "simple2",simple2 );
//                        intent1.putExtras( bundle2 );
//                        context.startActivity(intent1);
//                        break;
//                    case 2:
//                        Intent intent3= new Intent(context, Main2Activity.class );
//                        Bundle bundle3= new Bundle(  );
//                        bundle3.putSerializable( "simple3",  simple3 );
//                        intent3.putExtras( bundle3 );
//                        context.startActivity(intent3);
//                        break;
//                }
//            }
//        } );
    }
    private void setLists(RecyclerView group_recycler_view, int position) {
        switch (position){
            case 0:
                setHorizontalList1(group_recycler_view);
                break;
            case 1:
                setHorizontalList2(group_recycler_view);
                break;
            case 2:
                setHorizontalList3(group_recycler_view);
                break;
        }
    }

    private void setHorizontalList3(RecyclerView group_recycler_view) {
        MSimpleAdapter mSimpleAdapter3= new MSimpleAdapter( context,simple3 );
        group_recycler_view.setHasFixedSize( true );
        group_recycler_view.setLayoutManager( new LinearLayoutManager( context,LinearLayoutManager.HORIZONTAL,false ) );
        group_recycler_view.setAdapter( mSimpleAdapter3 );
        group_recycler_view.setNestedScrollingEnabled( true );
    }

    private void setHorizontalList2(RecyclerView group_recycler_view) {
        MSimpleAdapter mSimpleAdapter2= new MSimpleAdapter( context,simple2 );
        group_recycler_view.setNestedScrollingEnabled( true );
        group_recycler_view.setHasFixedSize( true );
        group_recycler_view.setLayoutManager( new LinearLayoutManager( context,LinearLayoutManager.HORIZONTAL,false ) );
        group_recycler_view.setAdapter( mSimpleAdapter2 );
    }

    private void setHorizontalList1(RecyclerView group_recycler_view) {
        MSimpleAdapter mSimpleAdapter1= new MSimpleAdapter( context,simple );
        group_recycler_view.setHasFixedSize( true );
        group_recycler_view.setLayoutManager( new LinearLayoutManager( context,LinearLayoutManager.HORIZONTAL,false ) );
        group_recycler_view.setAdapter( mSimpleAdapter1 );
        group_recycler_view.setNestedScrollingEnabled( true );
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {
       public RelativeLayout head_parent;
       public TextView group_title;
       public TextView view_all;
       public RecyclerView group_recycler_view;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            head_parent= itemView.findViewById( R.id.head_parent );
            group_title= itemView.findViewById( R.id.group_title );
            view_all= itemView.findViewById( R.id.view_all );
            group_recycler_view= itemView.findViewById( R.id.group_recycler_view );
        }
    }
}
