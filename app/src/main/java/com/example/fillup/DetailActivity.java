package com.example.fillup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tvid,tvname,tvage,tvcontact,tvaddress,tvdate,tvtime;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbarfour);

        //initializing views
        tvid = findViewById(R.id.txtid);
        tvname = findViewById(R.id.txtname);
        tvage = findViewById(R.id.txtage);
        tvcontact = findViewById(R.id.txtcontact);
        tvaddress = findViewById(R.id.txtaddress);
        tvdate = findViewById(R.id.txtdate);
        tvtime = findViewById(R.id.txttime);

        Intent intent =getIntent();
        position = intent.getExtras().getInt("position");

        tvid.setText("ID: "+MainActivity.visitorsArrayList.get(position).getId());
        tvname.setText("Name: "+MainActivity.visitorsArrayList.get(position).getName());
        tvage.setText("Age: "+MainActivity.visitorsArrayList.get(position).getAge());
        tvcontact.setText("Contact: "+MainActivity.visitorsArrayList.get(position).getContact());
        tvaddress.setText("Address: "+MainActivity.visitorsArrayList.get(position).getAddress());
        tvdate.setText("Date: "+MainActivity.visitorsArrayList.get(position).getDate());
        tvtime.setText("Time: "+MainActivity.visitorsArrayList.get(position).getTime());
    }
}