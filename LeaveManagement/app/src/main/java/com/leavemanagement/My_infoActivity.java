package com.priyanka.leavemanagement;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class My_infoActivity extends AppCompatActivity{
    ListView lvInfo;
    ArrayList<Teacher> t=new ArrayList<>();
    ArrayAdapter<Teacher> ad;
    FirebaseDatabase database;
    DatabaseReference myRef;
    ArrayList<String> k=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        lvInfo=(ListView)findViewById(R.id.lvInfo);
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference("student");

        int o = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                t.clear();
                for(DataSnapshot d: dataSnapshot.getChildren())
                {
                    Teacher data=d.getValue(Teacher.class);
                    t.add(data);
                }
                ad=new ArrayAdapter<Teacher>(My_infoActivity.this,android.R.layout.simple_list_item_1,t);
                lvInfo.setAdapter(ad);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
