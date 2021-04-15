package com.example.muslimapp.util;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int verticalSpaceLength;

    public VerticalSpaceItemDecoration(int verticalSpaceLength) {
        this.verticalSpaceLength = verticalSpaceLength;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = verticalSpaceLength;
    }

}
