package com.priyanka.leavemanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DirectActivity extends AppCompatActivity {

    EditText etDate,etReason,etName,etBranch,etPhone,etleavetype;
    Button btnSend;
    FirebaseDatabase database;
    DatabaseReference myRef;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Leave");
        btnSend=(Button)findViewById(R.id.btnSend);
        etName=(EditText)findViewById(R.id.etName);
        etBranch=(EditText)findViewById(R.id.etBranch);
        etleavetype=(EditText)findViewById(R.id.etleavetype);
        etPhone=(EditText)findViewById(R.id.etPhone);



        Intent intent=getIntent();
        String a=intent.getStringExtra("a");


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=etName.getText().toString();
                String b=etBranch.getText().toString();
                String m=etPhone.getText().toString();
                String d = etDate.getText().toString();
                String a= etleavetype.getText().toString();
                String r = etReason.getText().toString();
                Leave p = new Leave(n,b,m,d,a,r);
                myRef.push().setValue(p);
                etName.setText("");
                etBranch.setText("");
                etPhone.setText("");
                etleavetype.setText("");
                etDate.setText("");
                etReason.setText("");
                Toast.makeText(DirectActivity.this, "msg send", Toast.LENGTH_SHORT).show();

            }
        });
    }
}






