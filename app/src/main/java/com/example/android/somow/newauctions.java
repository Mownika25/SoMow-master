package com.example.android.somow;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class newauctions extends AppCompatActivity {
Button camera,gallery,ok; //ok=upload,gallery==chose
ImageView imageView;
private Uri filepath;
EditText timelimit,bidprice;
private final int PICK_IMAGE_REQUEST = 71;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newauctions);


        camera=findViewById(R.id.camera);

        gallery=findViewById(R.id.gallery);
        ok=findViewById(R.id.ok);
        imageView=findViewById(R.id.imageView);
        timelimit=findViewById(R.id.timelimit);
        bidprice=findViewById(R.id.bidprice);

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });

    }
    void chooseImage()
    {
        Intent i= new Intent();
        i.setType("image/*");
        i.setAction(i.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i,"SELECT PIC",PICK_IMAGE_REQUEST));
    }
    @Override
    protected void onActivityResult(int requestcode,int resultcode,Intent data)
    {
        super.onActivityResult(requestcode, resultcode, data);
        if(requestcode==PICK_IMAGE_REQUEST && resultcode==RESULTOK && data!=null&&data.getData()!=null)
        {
            filepath=data.getData();
        }
    }

}