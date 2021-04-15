package com.example.muslimapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.muslimapp.adapter.RozaDisplayRecycleViewAdapter;
import com.example.muslimapp.pojo.Roza;
import com.example.muslimapp.util.Converter;
import com.example.muslimapp.util.InputData;
import com.example.muslimapp.util.PreferenceUtil;
import com.example.muslimapp.util.VerticalSpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RozaDisplayRecycleViewAdapter.CallBack {

    @BindView(R.id.recy_roza)
    RecyclerView recyRoza;

    private List<Roza> rozaList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<Roza> preferenceData = PreferenceUtil.gerData(this);

        if (!preferenceData.isEmpty()) {
            rozaList = preferenceData;
            Log.d("tag", "onCreate: " + "use save data");
        } else {
            InputData.initRozaData(rozaList);
            Log.d("tag", "onCreate: " + "empty");
        }

        recyRoza.setLayoutManager(new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false));
        recyRoza.setAdapter(new RozaDisplayRecycleViewAdapter(this, rozaList, this));
        recyRoza.addItemDecoration(new VerticalSpaceItemDecoration(80));

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();

        for (int i = 0; i < rozaList.size(); i++) {

            String roza = Converter.rozaConvertToStr(rozaList.get(i));

            PreferenceUtil.putData(this, i, roza);
        }
    }

    @Override
    public void onClicRoza(List<Roza> rozaList) {
        this.rozaList = rozaList;

        Log.d("tag", "onClicRoza: " + rozaList);
    }
}