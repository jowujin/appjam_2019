package com.sk.appjam_2019.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sk.appjam_2019.R;
import com.sk.appjam_2019.adapter.Adapter_recommendedProduct;
import com.sk.appjam_2019.adapter.Adapter_sortList;
import com.sk.appjam_2019.model.Product;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClothesFragment extends Fragment {
    @BindView(R.id.rv_clothes_recommendedProduct)
    RecyclerView rv_clothes_recommendedProduct;
    @BindView(R.id.rv_main_grid)
    RecyclerView rv_main_grid;
    @BindView(R.id.tl_main_tablayout)
    TabLayout tl_main_tablayout;

    Adapter_recommendedProduct adapter_recommendedProduct;
    Adapter_sortList adapter_sortList;

    public ClothesFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clothes, container, false);
        ButterKnife.bind(this, view);

        initView();

        for (int i = 0; i < 10; i++) {
            adapter_recommendedProduct.addItem(new Product("https://image.musinsa.com/images/goods_img/20160912/410572/410572_2_500.jpg", "asdf", "asdf", "asdf"));
            adapter_sortList.addItem(new Product("https://image.musinsa.com/images/goods_img/20160912/410572/410572_2_500.jpg", "asdf", "asdf", "asdf"));
        }
        adapter_recommendedProduct.notifyAdapter();
        adapter_sortList.notifyAdapter();

        return view;
    }

    private void initView() {

        initRecommendedProduct();
        initTabLayout();
        initSortList();
    }

    private void initTabLayout() {
        tl_main_tablayout.getTabAt(0).setCustomView(R.layout.layout_clothes_tab).setText("By Age");
        TextView tab_one = tl_main_tablayout.getTabAt(0).getCustomView().findViewById(R.id.text);
        tab_one.setText("By Age");

        tl_main_tablayout.getTabAt(1).setCustomView(R.layout.layout_clothes_tab).setText("By Year");
        TextView tab_two = tl_main_tablayout.getTabAt(1).getCustomView().findViewById(R.id.text);
        tab_two.setText("By Year");
    }

    private void initRecommendedProduct() {
        adapter_recommendedProduct = new Adapter_recommendedProduct();

        rv_clothes_recommendedProduct.setHasFixedSize(true);
        rv_clothes_recommendedProduct.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rv_clothes_recommendedProduct.setAdapter(adapter_recommendedProduct);
    }

    private void initSortList() {
        adapter_sortList = new Adapter_sortList();

        rv_main_grid.setHasFixedSize(true);
        rv_main_grid.setLayoutManager(new GridLayoutManager(getContext(), 3, LinearLayoutManager.VERTICAL, false));
        rv_main_grid.setAdapter(adapter_sortList);
    }
}
