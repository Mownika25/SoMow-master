package com.example.android.somow;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.somow.MainActivity;
import com.example.android.somow.R;

public class dashboard extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);





        TextView buttons = (TextView) findViewById(R.id.button1);
        buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(dashboard.this,auctionslive.class);
                startActivity(k);
            }
        });
        TextView buttons2 = (TextView) findViewById(R.id.button2);
        buttons2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(dashboard.this,auctionslive.class);
                startActivity(k);

            }
        });
        TextView buttons3 = (TextView) findViewById(R.id.button3);
        buttons3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(dashboard.this,auctionslive.class);
                startActivity(k);
            }
        });
        TextView buttons4 = (TextView) findViewById(R.id.button4);
        buttons4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(dashboard.this,auctionslive.class);
                startActivity(k);
            }
        });
        TextView buttons5 = (TextView) findViewById(R.id.button5);
        buttons5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(dashboard.this,myauctions.class);
                startActivity(k);
            }
        });
        TextView buttons6 = (TextView) findViewById(R.id.button6);
        buttons6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(dashboard.this,newauctions.class);
                startActivity(k);
            }
        });



    }
}