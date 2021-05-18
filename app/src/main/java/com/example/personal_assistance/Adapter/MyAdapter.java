package com.example.personal_assistance.Adapter;

import android.content.Context;
import android.net.sip.SipSession;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personal_assistance.R;
import com.example.personal_assistance.model.ModelImdb;
import com.example.personal_assistance.repo.ImdbRepository;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Context context;
    List<ModelImdb> detels;
    ImdbRepository repository;


    public MyAdapter(Context context, List<ModelImdb> detels, ImdbRepository repository) {
        this.context = context;
        this.detels = detels;
        this.repository = repository;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vh = LayoutInflater.from(context).inflate(R.layout.listfile,parent,false);

        return new ViewHolder(vh);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.textView1.setText(detels.get(position).getTitle());
        holder.textView2.setText(detels.get(position).getDescription());

         holder.textView3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(context,"Plesce Click Delete Image Logo",Toast.LENGTH_LONG).show();
             }
         });

         holder.textView4.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(context,"Plesce Click Update Image Logo",Toast.LENGTH_LONG).show();

             }
         });


           holder.imageButton1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                       repository.DeleteSingleData(detels.get(position));
               }
           });


           holder.imageButton2.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {




                          holder.textView1.setText(detels.get(position).getTitle());
                          holder.textView2.setText(detels.get(position).getDescription());


               }
           });


    }

    @Override
    public int getItemCount() {
        return detels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

           TextView textView1,textView2,textView3,textView4;

           ImageButton imageButton1,imageButton2;

           public ViewHolder(@NonNull View itemView) {
               super(itemView);


                  textView1 = itemView.findViewById(R.id.r_title);
                  textView2 = itemView.findViewById(R.id.r_dec);


                  imageButton1 = itemView.findViewById(R.id.r_delete);
                  imageButton2 = itemView.findViewById(R.id.r_update);

                  // logo tost use


                  textView3 = itemView.findViewById(R.id.delete_logo);
                  textView4 = itemView.findViewById(R.id.update_logo);

           }
       }
}
