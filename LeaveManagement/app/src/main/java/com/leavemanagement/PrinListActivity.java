package com.priyanka.leavemanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PrinListActivity extends AppCompatActivity {

    ListView lvPrin;
    ArrayList<Teacher> s2 = new ArrayList<>();
    ArrayAdapter<Teacher> sd;
    FirebaseDatabase database;
    DatabaseReference myRef;
    DatabaseReference myRef1;
    DatabaseReference myRef2;
    SharedPreferences sp;
     int count=0;


    ArrayList<String> m= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prin_list);

        lvPrin = (ListView) findViewById(R.id.lvPrin);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Teacher");
        sp=getSharedPreferences("f1",MODE_PRIVATE);



        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                s2.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()) {
                    Teacher data = d.getValue(Teacher.class);
                    s2.add(data);
                    m.add(d.getKey());
                }
                sd = new ArrayAdapter<Teacher>(PrinListActivity.this, android.R.layout.simple_list_item_1, s2);
                lvPrin.setAdapter(sd);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        lvPrin.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Teacher td = s2.get(i);
                showUpdateDelete1Dialog(m.get(i),td.getName1(),td.getBranch1(),td.getPhone1(),td.getDate1(),td.getLeavetype1(),td.getReason1());
                return true;

            }
        });


    }



    public void showUpdateDelete1Dialog(final String m, final String name1, final String branch1, String phone1, final String date1, final String leavetype1, String reason1){
        AlertDialog.Builder ab=new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        View dialogView=inflater.inflate(R.layout.uddialog1,null);
        ab.setView(dialogView);


        Button btnAccept=(Button)dialogView.findViewById(R.id.btnAccept);
        Button btnReject=(Button)dialogView.findViewById(R.id.btnReject);




        final AlertDialog a=ab.create();
        a.show();

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final  String n=sp.getString("n","");
                String msg="Your Leave Request has been Granted";
                String s="Leave Status";
                        Intent i=new Intent(Intent.ACTION_SENDTO);
                        i.setData(Uri.parse("mailto:"+n));
                        i.putExtra(Intent.EXTRA_TEXT,msg);
                        i.putExtra(Intent.EXTRA_SUBJECT,s);
                        startActivity(i);
                myRef1 = database.getReference("Final");
                SharedPreferences.Editor editor=sp.edit();
                editor.putString("rn",name1);
                editor.putString("rn1",branch1);
                editor.putString("rn3",date1);
                editor.putString("rn4",leavetype1);
                editor.commit();
                String rn=sp.getString("rn","");
                String rn1=sp.getString("rn1","");
                String rn3=sp.getString("rn3","");
                String rn4=sp.getString("rn4","");
                Final f = new Final(rn,rn1,rn3,rn4);
                myRef1.push().setValue(f);
                //Toast.makeText(PrinListActivity.this, "done", Toast.LENGTH_SHORT).show();
                myRef2=database.getReference("Status");

                count=count+1;

                Status d=new Status(n,count);
                myRef2.push().setValue(d);
                Toast.makeText(PrinListActivity.this, "success", Toast.LENGTH_SHORT).show();

            }
                });
        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final  String n=sp.getString("n","");
                String msg="Your Leave Request has been Rejected";
                String s="Leave Status";
                Intent i=new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"+n));
                i.putExtra(Intent.EXTRA_TEXT,msg);
                i.putExtra(Intent.EXTRA_SUBJECT,s);
                startActivity(i);

            }
        });
    }




    }







