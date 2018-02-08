package com.example.akankshasingh.ecommerce.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.akankshasingh.ecommerce.R;
import com.example.akankshasingh.ecommerce.models.RankingsData;

import java.util.List;

/**
 * Created by Akanksha.Singh on 2/6/2018.
 */

public class RankingDataAdapter extends RecyclerView.Adapter<RankingDataAdapter.ViewHolder> {
    private final OnItemClickListener listener;
    private List<RankingsData> data;
    private Context context;

    public RankingDataAdapter(Context context, List<RankingsData> data, OnItemClickListener listener) {
        this.data = data;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public RankingDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RankingDataAdapter.ViewHolder holder, int position) {
        holder.click(data.get(position), listener);
        if (data.get(position).getRanking() != null)
            holder.tvName.setText(data.get(position).getRanking().trim());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnItemClickListener {
        void onClick(RankingsData Item);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.text_name);
        }

        void click(final RankingsData cityListData, final RankingDataAdapter.OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(cityListData);
                }
            });
        }
    }
}
