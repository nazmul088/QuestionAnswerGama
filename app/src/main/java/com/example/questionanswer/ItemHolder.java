package com.example.questionanswer;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ItemHolder extends RecyclerView.ViewHolder{
    ImageView iv;
    ConstraintLayout cv;
    View v;
    public ItemHolder(View itemView, Context context) {
        super(itemView);
        iv=itemView.findViewById(R.id.iv);
        cv=itemView.findViewById(R.id.parent);
        v=itemView;
    }
}
