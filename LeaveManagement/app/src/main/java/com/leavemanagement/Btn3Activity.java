package com.priyanka.leavemanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Btn3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn3);


        PDFView pdfView=(PDFView)findViewById(R.id.pdfView);
        pdfView.fromAsset("Pallavi mam tt1.pdf").load();

    }
}
