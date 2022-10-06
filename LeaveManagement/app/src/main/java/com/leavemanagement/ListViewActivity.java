package com.priyanka.leavemanagement;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewActivity extends AppCompatActivity {

    String[] names = {"Ms.Anita Patil", "Ms.Samudiswary", "Ms.Pallavi Chavan", "Mr.Madhav Vyas", "Ms.Nikita Kulkarni"};
    TextView tvTitle,tvPdf;
    Button btnPdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        tvTitle=(TextView)findViewById(R.id.tvTitle);
        tvPdf=(TextView)findViewById(R.id.tvPdf);
        btnPdf=(Button)findViewById(R.id.btnPdf);

        ListView lvList = (ListView) findViewById(R.id.lvList);
        CustomAdapter customAdapter = new CustomAdapter();

        lvList.setAdapter(customAdapter);

        btnPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListViewActivity.this,PdfActivity.class));
            }
        });





    }


    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.customlayout, null);

            TextView tvName1 = (TextView) view.findViewById(R.id.tvName1);
            Button btnRequest = (Button) view.findViewById(R.id.btnRequest);

            tvName1.setText(names[i]);

            btnRequest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String msg = "Please can you substitute my lec";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("sms:"));
                    i.putExtra("sms_body", msg);
                    startActivity(i);

                }
            });

            return view;



        }




    }
}

