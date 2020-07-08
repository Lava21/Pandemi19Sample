package com.mas.sampleinfopandemi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mas.sampleinfopandemi.R;
import com.mas.sampleinfopandemi.model.HistoryModel;

import java.util.ArrayList;

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.ViewHolder> {

    private ArrayList<HistoryModel> historyModelArrayList = new ArrayList<>();
    private Context mContext;

    public HistoryListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public ArrayList<HistoryModel> getHistoryModelArrayList(){
        return historyModelArrayList;
    }

    public void setHistoryModelArrayList(ArrayList<HistoryModel> items){
        if (historyModelArrayList != null){
            if (historyModelArrayList.size() > 0){
                historyModelArrayList.clear();
            }
            historyModelArrayList.addAll(items);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_history_holder, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvLastUpdateDate.setText(historyModelArrayList.get(position).getLastUpdate());
        holder.tvConfirmed.setText(historyModelArrayList.get(position).getConfirmed());
        holder.tvRecovered.setText(historyModelArrayList.get(position).getRecovered());
        holder.tvDeath.setText(historyModelArrayList.get(position).getDeaths());
        holder.tvListCountry.setText("Negara : "+  historyModelArrayList.get(position).getCountryRegion());
    }

    @Override
    public int getItemCount() {
        return historyModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvLastUpdateDate, tvConfirmed, tvRecovered, tvDeath, tvListCountry;

        ViewHolder(@NonNull View itemView){
            super(itemView);
            tvLastUpdateDate = itemView.findViewById(R.id.tvListLastUpdate);
            tvConfirmed = itemView.findViewById(R.id.tvListConfirmed);
            tvRecovered = itemView.findViewById(R.id.tvListRecovered);
            tvDeath = itemView.findViewById(R.id.tvListDeath);
            tvListCountry = itemView.findViewById(R.id.tvListCountry);
        }
    }
}
