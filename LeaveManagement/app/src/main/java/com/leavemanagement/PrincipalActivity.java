package com.priyanka.leavemanagement;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class PrincipalActivity extends AppCompatActivity {

    EditText etUsername1,etPassword1;
    Button btnSignin1,btnReset1;
    FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnSignin1=(Button)findViewById(R.id.btnSignin1);
        btnReset1=(Button)findViewById(R.id.btnReset1);
        etUsername1=(EditText)findViewById(R.id.etUsername1);
        etPassword1=(EditText)findViewById(R.id.etPassword1);
        firebaseAuth=FirebaseAuth.getInstance();

        int o = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);

        btnSignin1.setOnClickListener
                (new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String e=etUsername1.getText().toString();
                        String p=etPassword1.getText().toString();
                        if(e.equals("") && p.equals("dypatil@123")){
                            Intent i= new Intent(PrincipalActivity.this,PrinListActivity.class);
                            startActivity(i);
                            finish();
                        }
                    }
                });
        btnReset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PrincipalActivity.this,PrinListActivity.class);
                startActivity(intent);
            }
        });
    }
}



