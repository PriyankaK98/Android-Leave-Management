package com.priyanka.leavemanagement;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class EstablishmentSectionActivity extends AppCompatActivity {

    EditText etUsername2,etPassword2;
    TextView tvEs2;
    Button btnSignin2,btnReset2;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_establishment_section);

        btnSignin2=(Button)findViewById(R.id.btnSignin2);
        btnReset2=(Button)findViewById(R.id.btnReset2);
        etUsername2=(EditText)findViewById(R.id.etUsername2);
        etPassword2=(EditText)findViewById(R.id.etPassword2);
        tvEs2=(TextView)findViewById(R.id.tvEs2);
        firebaseAuth=FirebaseAuth.getInstance();

        int o = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);

        btnSignin2.setOnClickListener
                (new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String e=etUsername2.getText().toString();
                        String p=etPassword2.getText().toString();
                        if(e.equals("") && p.equals("dypatil@123")){
                            Intent i= new Intent(EstablishmentSectionActivity.this,EstabHomeActivity.class);
                            startActivity(i);
                        }
                    }
                });
        btnReset2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EstablishmentSectionActivity.this,EstabHomeActivity.class);
                startActivity(intent);
            }
        });
    }
}

