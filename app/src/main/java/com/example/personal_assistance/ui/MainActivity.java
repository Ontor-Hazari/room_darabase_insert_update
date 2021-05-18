package com.example.personal_assistance.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.personal_assistance.R;
import com.example.personal_assistance.model.ModelImdb;
import com.example.personal_assistance.repo.ImdbRepository;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText id_title,id_dec;
    Button id_insert,id_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImdbRepository repository = new ImdbRepository(getApplicationContext());

        id_title = (EditText)findViewById(R.id.id_title);
        id_dec = (EditText)findViewById(R.id.id_dec);


        id_view = (Button)findViewById(R.id.id_view);


           id_view.setOnClickListener(this);



           findViewById(R.id.id_insert).setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   String title = id_title.getText().toString();
                   String des = id_dec.getText().toString();
                   repository.InsertSingleData(new ModelImdb(title,des));

                   Toast.makeText(MainActivity.this,"Data Insert",Toast.LENGTH_LONG).show();

               }
           });



    }

    @Override
    public void onClick(View v) {

         if(v.getId()==R.id.id_view)
         {
             Intent intent = new Intent(MainActivity.this, detels_list.class);
                 startActivity(intent);
         }


    }
}