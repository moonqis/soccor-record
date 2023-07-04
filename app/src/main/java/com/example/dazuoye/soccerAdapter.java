package com.example.dazuoye;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class soccerAdapter extends RecyclerView.Adapter<soccerAdapter.ViewHolder> {
    private List<Integer> msoccerlist;
    private Context mContext;

    public soccerAdapter(Context context,List<Integer> msoccerlist){
        this.mContext=context;
        this.msoccerlist=msoccerlist;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.soccer_item,parent,false);
        return new ViewHolder(view);
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView id;
        TextView id1;
        TextView id2;
        TextView id3;
        TextView id4;
        TextView id5;
        TextView id6;
        TextView id7;
        ImageView head;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            head=itemView.findViewById(R.id.head);
            id=itemView.findViewById(R.id.num);
            id1=itemView.findViewById(R.id.num1);
            id2=itemView.findViewById(R.id.num2);
            id3=itemView.findViewById(R.id.num3);
            id4=itemView.findViewById(R.id.num4);
            id5=itemView.findViewById(R.id.num5);
            id6=itemView.findViewById(R.id.num6);
            id7=itemView.findViewById(R.id.num7);

        }


    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
          holder.head.setVisibility(View.VISIBLE);
          holder.id.setVisibility(View.VISIBLE);
          holder.id1.setVisibility(View.VISIBLE);
          holder.id2.setVisibility(View.VISIBLE);
          holder.id3.setVisibility(View.VISIBLE);
          holder.id4.setVisibility(View.VISIBLE);
          holder.id5.setVisibility(View.VISIBLE);
          holder.id6.setVisibility(View.VISIBLE);
          holder.id7.setVisibility(View.VISIBLE);


          if (position==0){
//              holder.head.setImageDrawable();
              holder.head.setImageResource(R.drawable.bunasaier);
              holder.id.setText("布纳萨尔");

              holder.id2.setText("10");
              holder.id1.setText("拜仁");
              holder.id3.setText("2");
              holder.id4.setText("7");
              holder.id5.setText("7");
              holder.id6.setText("7");
              holder.id7.setText("7");
          }
//         if (position==1){
////              holder.head.setImageDrawable();
        else{
            holder.head.setImageResource(R.drawable.soccer);
            holder.id.setText("帕瓦尔");
            holder.id1.setText("拜仁");
            holder.id2.setText("17");
            holder.id3.setText("2");
            holder.id4.setText("2");
            holder.id5.setText("7");
            holder.id6.setText("5");
            holder.id7.setText("7");
        }

    }


    @Override
    public int getItemCount() {

        return 9;
    }




}
