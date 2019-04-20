package com.sk.appjam_2019.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

public class CommonUtil {
    private Context context;

    public CommonUtil(Context context) {
        this.context = context;
    }

    // convert dp to px for set size programmatically
    public static int DpToPx(Context context, float dp) {
        Resources r = context.getResources();
        float px = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                r.getDisplayMetrics()
        );
        return (int)px;
    }

    // for horizontal recyclerview
    public static class RecyclerViewExtraSpace extends RecyclerView.ItemDecoration {
        private int extraSpace;

        public RecyclerViewExtraSpace(int extraSpace) {
            this.extraSpace = extraSpace;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            // 마지막 아이템일 시 간격 추가 안함
            if (parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount() - 1) {
                outRect.right = extraSpace;
            }
        }
    }
}
