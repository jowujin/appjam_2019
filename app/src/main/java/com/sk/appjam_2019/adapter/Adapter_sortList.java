package com.sk.appjam_2019.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sk.appjam_2019.R;
import com.sk.appjam_2019.model.Product;

import java.util.ArrayList;

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
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Product product = list_product.get(position);
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }
}
