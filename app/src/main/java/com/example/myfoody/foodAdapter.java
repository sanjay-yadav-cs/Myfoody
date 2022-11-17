package com.example.myfoody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class foodAdapter extends RecyclerView.Adapter<foodAdapter.viewHolder> {
    ArrayList<foodModel> list;
    Context context;

    public foodAdapter(ArrayList<foodModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.foodcatlog,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        foodModel model=list.get(position);
        Picasso.get().load(model.uri).placeholder(R.drawable.loading_gi).error(R.drawable.loading_gi).into(holder.foodimage);
//        holder.foodimage.setImageResource(model.getImage());
        holder.foodname.setText(model.getName());
//        foodModel model = list.
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView foodimage;
        TextView foodname;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            foodimage=itemView.findViewById(R.id.foodimage);
            foodname=itemView.findViewById(R.id.foodname);
        }
    }
}
