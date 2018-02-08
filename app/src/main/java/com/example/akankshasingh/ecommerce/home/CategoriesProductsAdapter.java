package com.example.akankshasingh.ecommerce.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.akankshasingh.ecommerce.R;
import com.example.akankshasingh.ecommerce.models.VariantsData;

import java.util.List;

/**
 * Created by Akanksha.Singh on 2/7/2018.
 */
public class CategoriesProductsAdapter extends RecyclerView.Adapter<CategoriesProductsAdapter.ViewHolder> {
    private List<VariantsData> data;
    private Context context;

    public CategoriesProductsAdapter(Context context, List<VariantsData> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public CategoriesProductsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_products, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new CategoriesProductsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoriesProductsAdapter.ViewHolder holder, int position) {
        for (int i = 1; i <= data.size(); i++) {
            if (data.get(position).getId() != null)
                holder.tvSNo.setText(data.get(position).getId().trim());
        }
        if (data.get(position).getPrice() != null)
            holder.tvPrice.setText("Rs " + data.get(position).getPrice().trim());
        if (data.get(position).getColor() != null)
            holder.tvColor.setText(data.get(position).getColor().trim());
        if (data.get(position).getSize() != null)
            holder.tvSize.setText(data.get(position).getSize().trim());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSNo, tvPrice, tvColor, tvSize;

        ViewHolder(View itemView) {
            super(itemView);
            tvSNo = itemView.findViewById(R.id.text_s_no);
            tvPrice = itemView.findViewById(R.id.text_price);
            tvColor = itemView.findViewById(R.id.text_color);
            tvSize = itemView.findViewById(R.id.text_size);
        }
    }
}
