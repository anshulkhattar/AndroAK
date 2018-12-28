package com.example.hp.androak;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class apps_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps_details);
        final Button explore=(Button)findViewById(R.id.explore);
        final RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final char TAG ='D' ;

        final List appList=new ArrayList<Apps>();

        DatabaseReference dbApps=FirebaseDatabase.getInstance().getReference("apps");
        dbApps.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {

                    for (DataSnapshot productSnapshot : dataSnapshot.getChildren()) {
                        Apps app = productSnapshot.getValue(Apps.class);
                        appList.add(app);
                        System.out.println(appList);
                    }
                }
                            AppsAdapter adapter = new AppsAdapter(apps_details.this, appList);
                            recyclerView.setAdapter(adapter);






            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

       // List applist=new ArrayList<Apps>();

        /*appList.add(new Apps("awzsexdrcftvgybhunjimkojnbyvtcfrdxeszwaesxrdctfvgybhunjimkoinhubygvtfcrdxesz","123","Bmic"));
        appList.add(new Apps("..","56","Quizem"));
        appList.add(new Apps("..","6256","LnS"));


        AppsAdapter adapter =new AppsAdapter(this,appList);
        recyclerView.setAdapter(adapter);*/

    }
}
