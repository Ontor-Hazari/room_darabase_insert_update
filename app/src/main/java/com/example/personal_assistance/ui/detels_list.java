package com.example.personal_assistance.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.personal_assistance.Adapter.MyAdapter;
import com.example.personal_assistance.R;
import com.example.personal_assistance.model.ModelImdb;
import com.example.personal_assistance.repo.ImdbRepository;

import java.util.ArrayList;
import java.util.List;

public class detels_list extends AppCompatActivity {

    RecyclerView id_recyceler;

    List<ModelImdb> detels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detels_list);

        detels = new ArrayList<>();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImdbRepository repository = new ImdbRepository(getApplicationContext());


        id_recyceler = (RecyclerView)findViewById(R.id.id_recyceler);

        id_recyceler.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter adapter = new MyAdapter(this, detels,repository);

        id_recyceler.setAdapter(adapter);


        repository.getAllData().observe(this, new Observer<List<ModelImdb>>() {
            @Override
            public void onChanged(List<ModelImdb> modelImdbs) {



                detels.clear();
                detels.addAll(modelImdbs);
                adapter.notifyDataSetChanged();
               // Toast.makeText(getApplicationContext(),"Data Insert", Toast.LENGTH_LONG).show();



            }
        });



    }


}