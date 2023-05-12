package com.example.mad_try;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView Listview = findViewById(R.id.myView);
        Button button = findViewById(R.id.back);
        DBHelper DB = new DBHelper(this);

        Cursor res = DB.getdata();
        if (res.getCount() == 0) {
            Toast.makeText(MainActivity2.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer buffer = new StringBuffer();
        ArrayList<String> list = new ArrayList<String>();
        while (((Cursor) res).moveToNext()) {
            String n ="Name: "+ res.getString(0)+"  "+" Contact: "+res.getString(1)+"  "+" DOB: "+res.getString(2);
            list.add(n);
        }

        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);
        Listview.setAdapter(adapt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}