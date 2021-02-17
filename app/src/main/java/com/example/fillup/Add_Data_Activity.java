package com.example.fillup;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;

public class Add_Data_Activity extends AppCompatActivity {


    EditText txtName,txtAge,txtContact,txtAddress, txtDate, txtTime;
    Button btn_insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__data_);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbartwo);

        txtName = findViewById(R.id.edtName);
        txtAge = findViewById(R.id.edtAge);
        txtContact = findViewById(R.id.edtContact);
        txtAddress = findViewById(R.id.edtAddress);
        txtDate = findViewById(R.id.edtDate);
        txtTime = findViewById(R.id.edtTime);
        btn_insert = findViewById(R.id.btnInsert);


        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inserData();
            }
        });
    }

    private void inserData() {
       String name = txtName.getText().toString().trim();
       String age = txtAge.getText().toString().trim();
       String contact = txtContact.getText().toString().trim();
       String address = txtAddress.getText().toString().trim();
       String date = txtDate.getText().toString().trim();
       String time = txtTime.getText().toString().trim();

       ProgressDialog progressDialog = new ProgressDialog(this);
       progressDialog.setMessage("Loading...");

        if (name.isEmpty()){
            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (age.isEmpty()){
            Toast.makeText(this, "Enter Age", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (contact.isEmpty()){
            Toast.makeText(this, "Enter Contact", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (address.isEmpty()){
            Toast.makeText(this, "Enter Address", Toast.LENGTH_SHORT).show();
            return;
        }

        else if (date.isEmpty()){
            Toast.makeText(this, "Enter Date", Toast.LENGTH_SHORT).show();
            return;
        }

        else if (time.isEmpty()){
            Toast.makeText(this, "Enter Time", Toast.LENGTH_SHORT).show();
            return;
        }

        else {
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "https://museourdaneta.000webhostapp.com/insert.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if(response.equalsIgnoreCase("Data Inserted")){
                                Toast.makeText(Add_Data_Activity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                                progressDialog.dismiss();
                            }
                            else {
                                Toast.makeText(Add_Data_Activity.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Add_Data_Activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();
                    params.put("name",name);
                    params.put("age",age);
                    params.put("contact",contact);
                    params.put("address",address);
                    params.put("date",date);
                    params.put("time",time);


                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(Add_Data_Activity.this);
            requestQueue.add(request);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}