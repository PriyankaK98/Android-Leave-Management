package com.priyanka.leavemanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TeacherActivity extends AppCompatActivity{
    RadioGroup rgLeave;
    EditText etReason, etDate,etName,etBranch,etPhone;
    Button btnSend,btnGo;
    FirebaseDatabase database;
    DatabaseReference myRef;
    SharedPreferences sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);


        btnSend = (Button) findViewById(R.id.btnSend);
        etReason = (EditText) findViewById(R.id.etReason);
        etDate = (EditText) findViewById(R.id.etDate);
        rgLeave = (RadioGroup) findViewById(R.id.rgLeave);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Leave");
        etName=(EditText)findViewById(R.id.etName);
        etBranch=(EditText)findViewById(R.id.etBranch);
        etPhone=(EditText)findViewById(R.id.etPhone);
        btnGo=(Button)findViewById(R.id.btnGo);
        sp1= getSharedPreferences("f1",MODE_PRIVATE);
        final String n= sp1.getString("n","");
        final String[] output=n.split("\\@");
        final String[] op1=output[0].split("\\.");
        final String z= op1[0].concat(" ").concat(op1[1]);
        final String a= z.toLowerCase();

        int o = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n1=etName.getText().toString();
                String b=etBranch.getText().toString();
                String m=etPhone.getText().toString();
                if(n1.length()==0){
                    etName.setError("Enter name");
                    etName.requestFocus();
                    return;
                }
                if(!n1.equals(a)){
                    etName.setError("Enter name");
                    etName.requestFocus();
                    return;
                }
                if(b.length()==0){
                    etBranch.setError("Enter branch");
                    return;
                }
                if(m.length() !=10){
                    etPhone.setError("Invalid Phone no.");
                    etPhone.setText("");
                    etPhone.requestFocus();
                    return;
                }
                String d = etDate.getText().toString();
                int id = rgLeave.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(id);
                String a = rb.getText().toString();
                String r = etReason.getText().toString();
                Leave p = new Leave(n,b,m,d, a, r);
                myRef.push().setValue(p);
                Toast.makeText(TeacherActivity.this, "msg send", Toast.LENGTH_SHORT).show();
            }
        });


        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(TeacherActivity.this,ListViewActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
