package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Contact> listData=new ArrayList<>();
    ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerContacts);
        adapter=new ContactAdapter(MainActivity.this,listData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        getData();
    }

    void getData(){
        listData.add(new Contact ("hamza","zaafrane","123456789",R.mipmap.DSC_0712_Perfect365));
        listData.add(new Contact ("hamza2","zaafrane2","123456789",R.mipmap.DSC_0712_Perfect365));
        listData.add(new Contact ("hamza3","zaafrane3","123456789",R.mipmap.DSC_0712_Perfect365));
        listData.add(new Contact ("hamza4","zaafrane4","123456789",R.mipmap.DSC_0712_Perfect365));
        adapter.notifyDataSetChanged();
    }
}