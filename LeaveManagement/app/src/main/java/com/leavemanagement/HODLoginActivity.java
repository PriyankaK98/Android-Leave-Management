package com.priyanka.leavemanagement;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class HODLoginActivity extends AppCompatActivity {
    EditText etUsername,etPassword;
    Button btnSignin,btnReset;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hodlogin);

        btnSignin=(Button)findViewById(R.id.btnSignin);
        btnReset=(Button)findViewById(R.id.btnReset);
        etUsername=(EditText)findViewById(R.id.etUsername);
        etPassword=(EditText)findViewById(R.id.etPassword);
        firebaseAuth=FirebaseAuth.getInstance();

        int o = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);

        btnSignin.setOnClickListener
                (new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String e=etUsername.getText().toString();
                        String p=etPassword.getText().toString();
                        if(e.equals("") && p.equals("dypatil@123")){
                            Intent i= new Intent(HODLoginActivity.this,HOD_Activity.class);
                            startActivity(i);
                            finish();
                        }
                    }
                });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HODLoginActivity.this,ResetActivity.class);
                startActivity(intent);
            }
        });
    }
}
