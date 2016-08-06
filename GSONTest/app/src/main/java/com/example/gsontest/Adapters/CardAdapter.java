package com.example.gsontest.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gsontest.dto.DataDTO;
import com.example.gsontest.R;

import java.util.List;

/**
 * Created by Андрей on 03.08.2016.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{

    private static List<DataDTO> data;

    public static void setData(List<DataDTO> data) {
        CardAdapter.data = data;
    }

    public CardAdapter(List<DataDTO> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.fio.setText(data.get(position).getFio());
        holder.phone.setText(data.get(position).getPhone());
        holder.about.setText(data.get(position).getAbout());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView phone;
        TextView fio;
        TextView about;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            fio = (TextView) itemView.findViewById(R.id.fio);
            phone = (TextView) itemView.findViewById(R.id.phone);
            about = (TextView) itemView.findViewById(R.id.about);
        }
    }

}
