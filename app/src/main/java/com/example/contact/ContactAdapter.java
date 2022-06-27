package com.example.contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
                .inflate(R.layout.item_row,parent,false);
        return new MViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.MViewHolder holder, int position) {
        Contact contact=contextList.get(position);
        holder.imgPhoto.setImageResource(contact.img);


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto,imgTel,imgCall;
        TextView tvNomPrenom,tvTel;
        public MViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto=itemView.findViewById(R.id.imageViewPhoto);
            imgTel=itemView.findViewById(R.id.imageViewCall);
            imgCall=itemView.findViewById(R.id.imageViewInfo);
            tvNomPrenom=itemView.findViewById(R.id.textViewNom);
            tvTel=itemView.findViewById(R.id.textViewTel);
        }
    }
}
