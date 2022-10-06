package com.priyanka.leavemanagement;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IconActivity extends AppCompatActivity{
    Button btnStaff,btnHod,btnPrin,btnEs;
    TextView tvStaff,tvHod,tvPrin,tvEs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon);

        btnStaff=(Button)findViewById(R.id.btnStaff);
        btnHod=(Button)findViewById(R.id.btnHod);
        btnPrin=(Button)findViewById(R.id.btnPrin);
        btnEs=(Button)findViewById(R.id.btnEs);
        tvStaff=(TextView)findViewById(R.id.tvStaff);
        tvHod=(TextView)findViewById(R.id.tvHod);
        tvPrin=(TextView)findViewById(R.id.tvPrin);
        tvEs=(TextView)findViewById(R.id.tvEs);


        int o = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);

        btnStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(IconActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        btnHod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(IconActivity.this,HODLoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnPrin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(IconActivity.this,PrincipalActivity.class);
                startActivity(i);
                finish();
            }
        });
        btnEs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(IconActivity.this,EstablishmentSectionActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

}
