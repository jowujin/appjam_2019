package com.sk.appjam_2019.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.sk.appjam_2019.R;
import com.sk.appjam_2019.adapter.Adapter_byage_list;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ByAge_Dialog extends Dialog {
    @BindView(R.id.tv_dialog_year)
    TextView tv_dialog_year;

    @BindView(R.id.rv_dialog_listview)
    RecyclerView rv_dialog_listview;

    @BindView(R.id.bt_dialog_button1)
    Button bt_dialog_button1;

    Adapter_byage_list adapter_byage_list;

    String title;


    public ByAge_Dialog(Context context, String title) {
        super(context);
        this.title = title;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_sortproduct);
        ButterKnife.bind(this);
        this.setCanceledOnTouchOutside(false);

        tv_dialog_year.setText(title);

       adapter_byage_list = new Adapter_byage_list();

       rv_dialog_listview.setHasFixedSize(true);
       rv_dialog_listview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
       rv_dialog_listview.setAdapter(adapter_byage_list);

       if (title.equals("By Age")) {
           adapter_byage_list.clear();
           for (int i = 15; i < 100; i++) {
               adapter_byage_list.addItem(Integer.toString(i));
           }
           adapter_byage_list.notifyAdapter();
       } else {
           String[] list = getContext().getResources().getStringArray(R.array.list_items);
           adapter_byage_list.clear();
           for (int i = 0; i < list.length; i++) {
               adapter_byage_list.addItem(list[i]);
           }
           adapter_byage_list.notifyAdapter();
       }

       bt_dialog_button1.setOnClickListener(v -> {
           dismiss();
       });
    }
}
