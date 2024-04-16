package com.example.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Data> data;

    public DataAdapter(Context context, ArrayList<Data> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rowview, parent, false);

        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Data d = this.data.get(position);
        DataViewHolder vh =(DataViewHolder) holder;
        vh.tvId.setText(String.valueOf(d.getId()));
        vh.tvTime.setText(d.getTime());
        vh.tvWhat.setText(d.getWhat());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder{
        private TextView tvId, tvTime, tvWhat;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvId = itemView.findViewById(R.id.tvId);
            this.tvTime = itemView.findViewById(R.id.tvTime);
            this.tvWhat = itemView.findViewById(R.id.tvWhat);

        }
    }


}
