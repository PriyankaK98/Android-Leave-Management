package com.priyanka.leavemanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Btn5Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn5);

        PDFView pdfView=(PDFView)findViewById(R.id.pdfView);
        pdfView.fromAsset("Nikita mam tt.pdf").load();

    }
}
