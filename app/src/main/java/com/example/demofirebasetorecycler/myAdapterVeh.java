package com.example.demofirebasetorecycler;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class myAdapterVeh extends FirebaseRecyclerAdapter<model, myAdapterVeh.myviewholder> {

    public myAdapterVeh(@NonNull FirebaseRecyclerOptions<model> options)
    {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myviewholder holder, final int position, @NonNull final model model) {
        holder.vehNum.setText(model.getVehNum());
        holder.vehDate.setText(model.getVehDate());
        holder.vehModel.setText(model.getVehModel());
        holder.vehColor.setText(model.getVehColor());
        holder.vehManuYear.setText(model.getVehManuYear());
        holder.vehNic.setText(model.getVehNic());

        Glide.with(holder.img.getContext()).load(model.getVehUrl()).into(holder.img);

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.dialogcontent))
                        .setExpanded(true,1100)
                        .create();

                View myview=dialogPlus.getHolderView();
                final EditText vehUrl=myview.findViewById(R.id.shurlVeh);
                final EditText vehNum=myview.findViewById(R.id.shVehNum);
                final EditText vehDate=myview.findViewById(R.id.shVehDate);
                final EditText vehModel=myview.findViewById(R.id.shVehModel);
                final EditText vehColor=myview.findViewById(R.id.shVehCol);
                final EditText vehManuYear=myview.findViewById(R.id.shVehManuYe);
                final EditText vehNic=myview.findViewById(R.id.shVehNic);
                Button updateVeh=myview.findViewById(R.id.vehsubmit);

                vehUrl.setText(model.getVehUrl());
                vehNum.setText(model.getVehNum());
                vehDate.setText(model.getVehDate());
                vehModel.setText(model.getVehModel());
                vehColor.setText(model.getVehColor());
                vehManuYear.setText(model.getVehManuYear());
                vehNic.setText(model.getVehNic());


                dialogPlus.show();

                updateVeh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map=new HashMap<>();
                        map.put("vehNum",vehNum.getText().toString());
                        map.put("vehDate",vehDate.toString());
                        map.put("vehModel",vehModel.getText().toString());
                        map.put("vehColor",vehColor.getText().toString());
                        map.put("vehManuYear",vehManuYear.getText().toString());
                        map.put("vehNic",vehNic.getText().toString());
                        map.put("vehUrl",vehUrl.getText().toString());



                        FirebaseDatabase.getInstance().getReference().child("vehicle")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });


            }
        });


        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.img.getContext());
                builder.setTitle("Delete Panel");
                builder.setMessage("Delete...?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("vehicle")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
        });
    }


    @NonNull
    @Override
    public myAdapterVeh.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }




    class myviewholder extends RecyclerView.ViewHolder
    {
        CircleImageView img;
        ImageView edit,delete;
        TextView vehNum,vehDate,vehModel,vehColor,vehManuYear,vehNic;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img=(CircleImageView) itemView.findViewById(R.id.img2);
            vehNum=(TextView)itemView.findViewById(R.id.vehNum);
            vehDate=itemView.findViewById(R.id.vehdate);
            vehModel=itemView.findViewById(R.id.vehModel);
            vehColor=itemView.findViewById(R.id.vehCol);
            vehManuYear=itemView.findViewById(R.id.vehManuYear);
            vehNic=itemView.findViewById(R.id.vehNic);


            edit=(ImageView)itemView.findViewById(R.id.editiconVeh);
            delete=(ImageView)itemView.findViewById(R.id.deleteiconVeh);
        }
    }


}
