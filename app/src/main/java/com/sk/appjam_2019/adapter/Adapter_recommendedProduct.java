package com.sk.appjam_2019.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.sk.appjam_2019.R;
import com.sk.appjam_2019.model.Product;
import com.sk.appjam_2019.util.CommonUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapter_recommendedProduct extends RecyclerView.Adapter<Adapter_recommendedProduct.ViewHolder> implements BaseAdapter.View, BaseAdapter.Model<Product> {
    private ArrayList<Product> list_products = new ArrayList<>();
    private Context context;

    public Adapter_recommendedProduct() {

    }

    @NonNull
    @Override
    public Adapter_recommendedProduct.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.item_recommendedproduct, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_recommendedProduct.ViewHolder holder, int position) {
        Product product = list_products.get(position);

        Glide.with(context)
                .load(product.getImg())
                .apply(new RequestOptions().transforms(new CenterCrop(), new RoundedCorners(CommonUtil.DpToPx(context, 4)))) // change Dp to Px
                .into(holder.iv_recommendedProduct_thumbnail);

        holder.tv_recommendedProduct_brand.setText(product.getCompany());
        holder.tv_recommendedProduct_name.setText(product.getTitle());
        holder.tv_recommendedProduct_price.setText(product.getPrice());
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
        list_products.add(model);
    }

    @Override
    public Product getItem(int position) {
        return list_products.get(position);
    }

    @Override
    public void clear() {
        list_products.clear();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_recommendedProduct_thumbnail)
        ImageView iv_recommendedProduct_thumbnail;
        @BindView(R.id.tv_recommendedProduct_brand)
        TextView tv_recommendedProduct_brand;
        @BindView(R.id.tv_recommendedProduct_name)
        TextView tv_recommendedProduct_name;
        @BindView(R.id.tv_recommendedProduct_price)
        TextView tv_recommendedProduct_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
