package com.fuck.viewtest.rv;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fuck.viewtest.R;

public class MyHolder extends RecyclerView.ViewHolder {

    public TextView tv;
    public View v_back;

    public MyHolder(@NonNull View itemView) {
        super(itemView);
        tv= itemView.findViewById(R.id.tv);
        v_back= itemView.findViewById(R.id.v_back);
    }
}
