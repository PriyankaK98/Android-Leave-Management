package com.priyanka.leavemanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
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
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;



public class HOD_Activity extends AppCompatActivity {
    ListView lvData;
    ArrayList<Leave> s1 = new ArrayList<>();
    ArrayAdapter<Leave> ad;
    //ArrayList<Teacher> t = new ArrayList<>();
    //ArrayAdapter<Teacher> Add;
    FirebaseDatabase database;
    DatabaseReference myRef;
    SharedPreferences sp1;


    ArrayList<String> k= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hod_);

        lvData = (ListView) findViewById(R.id.lvData);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Leave");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                s1.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()) {
                    Leave data = d.getValue(Leave.class);
                    s1.add(data);
                    k.add(d.getKey());
                }
                ad = new ArrayAdapter<Leave>(HOD_Activity.this, android.R.layout.simple_list_item_1, s1);
                lvData.setAdapter(ad);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        lvData.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Leave leave= s1.get(i);
                showUpdateDeleteDialog(k.get(i),leave.getName(),leave.getBranch(),leave.getPhone(),leave.getDate(),leave.getLeavetype(),leave.getReason());


                SharedPreferences.Editor editor=sp1.edit();
                editor.putString("rn",leave.getName());
                editor.putString("rn1",leave.getBranch());
                editor.putString("rn2",leave.getPhone());
                editor.putString("rn3",leave.getDate());
                editor.putString("rn4",leave.getLeavetype());
                editor.putString("rn5",leave.getReason());
                editor.commit();
                return true;

            }
        });


    }



    public void showUpdateDeleteDialog(final String k,String name,String branch,String phone,String date,String leavetype,String reason){
        AlertDialog.Builder ab=new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        View dialogView=inflater.inflate(R.layout.uddialog,null);
        ab.setView(dialogView);

       // final Spinner spnSelect=(Spinner)findViewById(R.id.spnSelect);
        Button btnUDDelete=(Button)dialogView.findViewById(R.id.btnUDDelete);
        Button btnSend=(Button)dialogView.findViewById(R.id.btnSend);
        final EditText etPhone=(EditText)dialogView.findViewById(R.id.etPhone);
        Button btnNRecommended=(Button)dialogView.findViewById(R.id.btnNRecommended);
        Button btnRecommended=(Button)dialogView.findViewById(R.id.btnRecommended);
        sp1=getSharedPreferences("f1",MODE_PRIVATE);
        myRef = database.getReference("Teacher");


        //ab.setTitle(" "+ name);
       // ab.setTitle(" "+ branch);
        ab.setTitle(" "+ phone);
        //ab.setTitle(" "+ date);
        //ab.setTitle(" "+ leavetype);
        //ab.setTitle(" "+ reason);
        final AlertDialog a=ab.create();
        a.show();

        btnRecommended.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String rn=sp1.getString("rn","");
                String rn1=sp1.getString("rn1","");
                String rn2=sp1.getString("rn2","");
                String rn3=sp1.getString("rn3","");
                String rn4=sp1.getString("rn4","");
                String rn5=sp1.getString("rn5","");
                Teacher t = new Teacher(rn,rn1,rn2,rn3,rn4,rn5);
                myRef.push().setValue(t);
                Toast.makeText(HOD_Activity.this, "msg send", Toast.LENGTH_SHORT).show();
            }


        });



        btnNRecommended.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String p=etPhone.getText().toString();
                if (p.length() != 10) {

                    etPhone.setError("Invalid Phone Number");
                    etPhone.requestFocus();
                    return;
                }

                String msg="Your Leave Request is Rejected";
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("sms:"+p));
                i.putExtra("sms_body",msg);
                startActivity(i);
            }});

        btnUDDelete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                DatabaseReference d1 = FirebaseDatabase.getInstance().getReference("Leave").child(k);
                d1.removeValue();
                Toast.makeText(HOD_Activity.this, "deleted", Toast.LENGTH_SHORT).show();
                a.dismiss();
            }
        });

    }
}





