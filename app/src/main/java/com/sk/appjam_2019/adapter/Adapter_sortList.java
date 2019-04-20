package com.sk.appjam_2019.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sk.appjam_2019.R;
import com.sk.appjam_2019.model.Product;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapter_sortList extends RecyclerView.Adapter<Adapter_sortList.ViewHolder> implements BaseAdapter.View, BaseAdapter.Model<Product> {
    private Context context;
    private ArrayList<Product> list_product = new ArrayList<>();

    public Adapter_sortList() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_sort_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = list_product.get(position);

        Glide.with(context)
                .load(product.getImg())
                .into(holder.iv_sortList_thumbnail);

        holder.tv_sortList_brand.setText(product.getCompany());
        holder.tv_sortList_name.setText(product.getTitle());
        holder.tv_sortList_price.setText(product.getPrice());

        holder.cb_sortList_favorite.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                holder.tv_sortList_favorite.setTextColor(Color.parseColor("#ff3b70"));
            } else {
                holder.tv_sortList_favorite.setTextColor(Color.parseColor("#a0a0a0"));
            }
        });

        holder.cl_sortList_favorite.setOnClickListener(v -> {
            holder.cb_sortList_favorite.performClick();
        });
    }

    @Override
    public int getItemCount() {
        return list_product.size();
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public void addItem(Product model) {
        list_product.add(model);
    }

    @Override
    public Product getItem(int position) {
        return list_product.get(position);
    }

    @Override
    public void clear() {
        list_product.clear();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_sortList_thumbnail)
        ImageView iv_sortList_thumbnail;
        @BindView(R.id.tv_sortList_brand)
        TextView tv_sortList_brand;
        @BindView(R.id.tv_sortList_name)
        TextView tv_sortList_name;
        @BindView(R.id.tv_sortList_price)
        TextView tv_sortList_price;
        @BindView(R.id.cl_sortList_favorite)
        ConstraintLayout cl_sortList_favorite;
        @BindView(R.id.cb_sortList_favorite)
        CheckBox cb_sortList_favorite;
        @BindView(R.id.tv_sortList_favorite)
        TextView tv_sortList_favorite;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
