package com.priyanka.leavemanagement;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EstabHomeActivity extends AppCompatActivity {
    ListView lvEs;
    ArrayList<Final> s1 = new ArrayList<>();
    ArrayAdapter<Final> ad;
    FirebaseDatabase database;
    DatabaseReference myRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estab_home);

        int o = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);

        lvEs=(ListView)findViewById(R.id.lvEs);
        database = FirebaseDatabase.getInstance();
        myRef=database.getReference("Final");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                s1.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()) {
                    Final data2 = d.getValue(Final.class);
                    s1.add(data2);
                    //k.add(d.getKey());
                }
                ad = new ArrayAdapter<Final>(EstabHomeActivity.this, android.R.layout.simple_list_item_1, s1);
                lvEs.setAdapter(ad);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }
}
