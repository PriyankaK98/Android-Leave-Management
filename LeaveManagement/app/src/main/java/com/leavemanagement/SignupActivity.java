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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    EditText etSignupemail,etSignuppassword;
    Button btnRegister;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etSignupemail=(EditText)findViewById(R.id.etSignupemail);
        etSignuppassword=(EditText)findViewById(R.id.etSignuppassword);
        btnRegister=(Button)findViewById(R.id.btnRegister);
        firebaseAuth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference("Teacher");

        int o = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e=etSignupemail.getText().toString();
                String p=etSignuppassword.getText().toString();

                if(e.length()==0){
                    etSignupemail.setError("Enter email");
                    etSignupemail.requestFocus();
                    return;
                }
                if(p.length()<6){
                    etSignuppassword.setError("Enter Min 6 char password");
                    etSignuppassword.requestFocus();
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(e,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Intent i = new Intent(SignupActivity.this, MainActivity.class);
                            startActivity(i);
                            Toast.makeText(SignupActivity.this, "Success", Toast.LENGTH_SHORT).show();
                            etSignupemail.setText("");
                            etSignuppassword.setText("");
                            finish();

                        } else {
                            Toast.makeText(SignupActivity.this, "issue" + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });
    }
}
