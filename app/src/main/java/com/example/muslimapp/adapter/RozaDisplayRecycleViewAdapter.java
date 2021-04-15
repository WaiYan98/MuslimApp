package com.example.muslimapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatCallback;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muslimapp.R;
import com.example.muslimapp.pojo.Roza;
import com.example.muslimapp.util.Converter;
import com.example.muslimapp.util.PreferenceUtil;
import com.google.android.material.button.MaterialButton;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RozaDisplayRecycleViewAdapter extends RecyclerView.Adapter<RozaDisplayRecycleViewAdapter.ViewHolder> {

    private Context context;
    private List<Roza> rozaList;
    private CallBack callBack;

    public RozaDisplayRecycleViewAdapter(Context context, List<Roza> rozaList, CallBack callBack) {
        this.context = context;
        this.rozaList = rozaList;
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_roza, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Roza currentRoza = rozaList.get(position);

        holder.mbRoza.setText(String.valueOf(currentRoza.getRozaNum()));
        holder.txtDay.setText(String.valueOf(currentRoza.getDay()));
        holder.txtMonth.setText(String.valueOf(currentRoza.getMonth()));

        colorSwitch(holder.mbRoza, currentRoza.isPassed());

        holder.mbRoza.setOnClickListener(v -> {
            currentRoza.setPassed(true);
            colorSwitch(holder.mbRoza, currentRoza.isPassed());

            callBack.onClicRoza(rozaList);

        });

    }

    @Override
    public int getItemCount() {
        return rozaList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.mb_roza)
        MaterialButton mbRoza;
        @BindView(R.id.txt_day)
        TextView txtDay;
        @BindView(R.id.txt_month)
        TextView txtMonth;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    public void colorSwitch(MaterialButton mb, boolean isPassed) {

        if (isPassed) {
            mb.setBackgroundColor(ContextCompat.getColor(context, R.color.red));
            mb.setTextColor(ContextCompat.getColor(context, R.color.white));
        } else {
            mb.setBackgroundColor(ContextCompat.getColor(context, R.color.color_gray));
            mb.setTextColor(ContextCompat.getColor(context, R.color.black));
        }
    }

    public interface CallBack {

        void onClicRoza(List<Roza> rozaList);
    }
}
