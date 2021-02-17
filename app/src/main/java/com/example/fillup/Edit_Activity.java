package com.example.fillup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class Edit_Activity extends AppCompatActivity {

    EditText edId,edName,edAge,edContact,edAddress,edDate,edTime;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbarthree);

        edId = findViewById(R.id.ed_id);
        edName = findViewById(R.id.ed_name);
        edAge = findViewById(R.id.ed_age);
        edContact = findViewById(R.id.ed_contact);
        edAddress = findViewById(R.id.ed_address);
        edDate = findViewById(R.id.ed_date);
        edTime = findViewById(R.id.ed_time);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        edId.setText(MainActivity.visitorsArrayList.get(position).getId());
        edName.setText(MainActivity.visitorsArrayList.get(position).getName());
        edAge.setText(MainActivity.visitorsArrayList.get(position).getAge());
        edContact.setText(MainActivity.visitorsArrayList.get(position).getContact());
        edAddress.setText(MainActivity.visitorsArrayList.get(position).getAddress());
        edDate.setText(MainActivity.visitorsArrayList.get(position).getDate());
        edTime.setText(MainActivity.visitorsArrayList.get(position).getTime());
    }


    public void btn_updateData(View view) {

        String name = edName.getText().toString();
        String age = edAge.getText().toString();
        String contact = edContact.getText().toString();
        String address = edAddress.getText().toString();
        String date = edDate.getText().toString();
        String time = edTime.getText().toString();
        String id = edId.getText().toString();




        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Updating...");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, "https://museourdaneta.000webhostapp.com/update.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Edit_Activity.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Edit_Activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();
                params.put("id",id);
                params.put("name",name);
                params.put("age",age);
                params.put("contact",contact);
                params.put("address",address);
                params.put("date",date);
                params.put("time",time);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Edit_Activity.this);
        requestQueue.add(request);
    }
}