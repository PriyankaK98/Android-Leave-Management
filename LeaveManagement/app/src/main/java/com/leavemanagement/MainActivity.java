package com.priyanka.leavemanagement;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity{
    Button btnSignin,btnSignup,btnReset;
    EditText etUsername,etPassword;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnSignin=(Button)findViewById(R.id.btnSignin);
        btnSignup=(Button)findViewById(R.id.btnSignup);
        btnReset=(Button)findViewById(R.id.btnReset);
        etUsername=(EditText)findViewById(R.id.etUsername);
        etPassword=(EditText)findViewById(R.id.etPassword);
        firebaseAuth=FirebaseAuth.getInstance();
        sp=getSharedPreferences("f1",MODE_PRIVATE);

        int o = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);

        btnSignin.setOnClickListener
                (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e=etUsername.getText().toString();
                String p=etPassword.getText().toString();

                if(e.length()==0){
                    etUsername.setError("Enter email");
                    etUsername.requestFocus();
                    return;
                }
                if(p.length()==0){
                    etPassword.setError("Enter valid password");
                    return;
                }
                firebaseAuth.signInWithEmailAndPassword(e,p).addOnCompleteListener
                        (new OnCompleteListener<AuthResult>(){

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){

                                    String e=etUsername.getText().toString();
                                    String n=sp.getString("e","");
                                    SharedPreferences.Editor editor=sp.edit();
                                    editor.putString("n",e);
                                    editor.commit();
                                    Intent i=new Intent(MainActivity.this,Homepage_Activity.class);
                                    i.putExtra("",e);
                                    startActivity(i);
                                    finish();
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "Login issue"+task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ResetActivity.class);
                startActivity(intent);
            }
        });

    }

}
