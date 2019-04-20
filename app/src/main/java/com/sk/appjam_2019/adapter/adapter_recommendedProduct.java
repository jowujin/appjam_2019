package com.sk.appjam_2019.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sk.appjam_2019.R;
import com.sk.appjam_2019.model.Product;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class adapter_recommendedProduct extends RecyclerView.Adapter<adapter_recommendedProduct.ViewHolder> implements BaseAdapter.View, BaseAdapter.Model<Product> {
    private ArrayList<Product> list_products;

    public adapter_recommendedProduct() {

    }

    @NonNull
    @Override
    public adapter_recommendedProduct.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recommendedproduct, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_recommendedProduct.ViewHolder viewHolder, int i) {
        Product product = list_products.get(i);

    }

    @Override
    public int getItemCount() {
        return list_products.size();
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public void addItem(Product model) {

    }

    @Override
    public Product getItem(int position) {
        return list_products.get(position);
    }

    @Override
    public void clear() {
        list_products.clear();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
