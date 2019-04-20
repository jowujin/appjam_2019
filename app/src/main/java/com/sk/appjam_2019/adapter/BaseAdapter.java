package com.sk.appjam_2019.adapter;

public interface BaseAdapter {
    interface View {
        void notifyAdapter();
    }

    interface Model<M> {
        void addItem(M model);
        M getItem(int position);
        void clear();
    }
}
