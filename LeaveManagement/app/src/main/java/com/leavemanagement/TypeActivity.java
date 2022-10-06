package com.priyanka.leavemanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TypeActivity extends AppCompatActivity {

    RadioGroup rgLeave;
    Button btnProceed;
    SharedPreferences sp1;
    TextView tvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);


        tvCount=(TextView)findViewById(R.id.tvCount);
        rgLeave = (RadioGroup) findViewById(R.id.rgLeave);
        btnProceed=(Button)findViewById(R.id.btnProceed);
        sp1=getSharedPreferences("f1",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp1.edit();
        editor.putInt("rn",new Status().getCount());
        editor.commit();
        int rn=sp1.getInt("rn",0);
        String ras=String.valueOf(rn);
        tvCount.setText("Casual Leaves taken: "+ ras);

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = rgLeave.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(id);
                String a = rb.getText().toString();
                if(a.equals("Casual Leave")){
                    Intent intent=new Intent(TypeActivity.this,TeacherActivity.class);
                    startActivity(intent);
                }
                if(a.equals("Medical Leave"))
                {
                    Intent intent=new Intent(TypeActivity.this,DirectActivity.class);
                    intent.putExtra("a",a);
                    startActivity(intent);
                }
                if(a.equals("Maternity Leave"))
                {
                    Intent intent=new Intent(TypeActivity.this,DirectActivity.class);
                    intent.putExtra("a",a);
                    startActivity(intent);
                }

                if(a.equals("OnDuty Leave"))
                {
                    Intent intent=new Intent(TypeActivity.this,ListViewActivity.class);
                    intent.putExtra("a",a);
                    startActivity(intent);
                }
            }
        });
        
    }
}



