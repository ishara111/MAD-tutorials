package com.example.tutorial_4and5;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RviewHolder extends RecyclerView.ViewHolder {
    ViewGroup parent;
    TextView selectText;
    ImageView selectIcon;
    public RviewHolder(@NonNull View itemView) {
        super(itemView);

        selectText = itemView.findViewById(R.id.SelectIconText);
        selectIcon = itemView.findViewById(R.id.selectIcon);

//        int size = parent.getMeasuredHeight() / MapData.HEIGHT + 1;
//        ViewGroup.LayoutParams lp = itemView.getLayoutParams();
//        lp.width = size;
//        lp.height = size;
    }
}
