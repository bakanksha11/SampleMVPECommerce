package com.example.akankshasingh.ecommerce.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.akankshasingh.ecommerce.R;
import com.example.akankshasingh.ecommerce.models.ProductsData;

import java.util.List;

/**
 * Created by Akanksha.Singh on 2/7/2018.
 */

public class ProductsRankingAdapter extends RecyclerView.Adapter<ProductsRankingAdapter.ViewHolder> {
    private List<ProductsData> data;
    private Context context;

    public ProductsRankingAdapter(Context context, List<ProductsData> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ProductsRankingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ProductsRankingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductsRankingAdapter.ViewHolder holder, int position) {
        if (data.get(position).getView_count() != null)
            holder.tvName.setText(data.get(position).getView_count().trim());
        else if(data.get(position).getOrder_count() != null)
            holder.tvName.setText(data.get(position).getOrder_count().trim());
        else if(data.get(position).getShares() != null)
            holder.tvName.setText(data.get(position).getShares().trim());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.text_name);
        }

    }
}