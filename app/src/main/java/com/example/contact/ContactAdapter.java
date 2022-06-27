package com.example.contact;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MViewHolder> {
    private Context mcontext;
    private List<Contact> contextList;


    public ContactAdapter(Context context, List<Contact> contextList) {
        this.mcontext = context;
        this.contextList = contextList;
    }

    @NonNull
    @Override
    public ContactAdapter.MViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row_card,parent,false);
        return new MViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.MViewHolder holder, int position) {
        Contact contact=contextList.get(position);
        holder.imgPhoto.setImageResource(contact.img);
        holder.tvTel.setText(contact.telephone);
        holder.tvNomPrenom.setText(contact.nom);
        holder.imgInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext, contact.telephone, Toast.LENGTH_SHORT).show();
                Uri uri = Uri.parse("tel:56030344");
                Intent intent=new Intent(Intent.ACTION_DIAL,uri);
                mcontext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto,imgTel,imgInfo;
        TextView tvNomPrenom,tvTel;
        public MViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto=itemView.findViewById(R.id.imageViewPhoto);
            imgTel=itemView.findViewById(R.id.imageViewCall);
            imgInfo=itemView.findViewById(R.id.imageViewInfo);
            tvNomPrenom=itemView.findViewById(R.id.textViewNom);
            tvTel=itemView.findViewById(R.id.textViewTel);
        }
    }
}
