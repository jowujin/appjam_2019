package com.sk.appjam_2019.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sk.appjam_2019.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapter_byage_list extends RecyclerView.Adapter<Adapter_byage_list.ViewHolder> implements BaseAdapter.View, BaseAdapter.Model<String> {
    private ArrayList<String> list_text = new ArrayList<>();
    private Context context;

    public Adapter_byage_list() {

    }

    @NonNull
    @Override
    public Adapter_byage_list.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_bylist, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_byage_list.ViewHolder holder, int position) {
        String text = list_text.get(position);
        holder.tv_bylist_text.setText(text);
    }

    @Override
    public int getItemCount() {
        return list_text.size();
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public void addItem(String model) {
        list_text.add(model);
    }

    @Override
    public String getItem(int position) {
        return list_text.get(position);
    }

    @Override
    public void clear() {
        list_text.clear();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_bylist_text)
        TextView tv_bylist_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
