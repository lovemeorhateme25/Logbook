package com.example.fillup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter<Visitors> {

    Context context;
    List<Visitors> arrayListVisitors;
    public MyAdapter(@NonNull Context context, List<Visitors> arrayListVisitors) {
        super(context, R.layout.custom_list_item,arrayListVisitors);
        this.context = context;
        this.arrayListVisitors = arrayListVisitors;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, null, true);
        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvName = view.findViewById(R.id.txt_name);
        tvID.setText(arrayListVisitors.get(position).getId());
        tvName.setText(arrayListVisitors.get(position).getName());

        return view;
    }
}
