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
import com.google.firebase.auth.FirebaseAuth;

public class ResetActivity extends AppCompatActivity{
    EditText etResetEmail;
    Button btnResetSend;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        firebaseAuth=FirebaseAuth.getInstance();

        etResetEmail=(EditText)findViewById(R.id.etResetEmail);
        btnResetSend=(Button)findViewById(R.id.btnResetSend);
        int o = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);

        btnResetSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e=etResetEmail.getText().toString();
                firebaseAuth.sendPasswordResetEmail(e).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ResetActivity.this, "Check mail",
                                    Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ResetActivity.this,MainActivity.class));
                            finish();
                        }
                        else
                        {
                            Toast.makeText(ResetActivity.this, "galat baat", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}
