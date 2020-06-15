package com.LINDA.myqrcordapp;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {
    private EditText edtinputtext;
    private ImageView imgQRcode;
    private Button btnQRcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtinputtext =findViewById(R.id.edtinputtext);
        imgQRcode = findViewById(R.id.imgQRcode);
        btnQRcode =findViewById(R.id.btnQRcode);


    }
    public void getCode(View view){
        BarcodeEncoder encoder =new BarcodeEncoder();
        try {
            Bitmap bit = encoder.encodeBitmap(edtinputtext.getText().toString(), BarcodeFormat.QR_CODE,250,250);
            imgQRcode.setImageBitmap(bit);

        }catch (WriterException e){
            e.printStackTrace();
        }

    }

    public void btnOK(View view) {
        getCode(view);
    }
};
