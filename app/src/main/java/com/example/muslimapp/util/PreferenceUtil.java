package com.example.muslimapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.muslimapp.pojo.Roza;

import java.util.ArrayList;
import java.util.List;

public class PreferenceUtil {

    public static void putData(Context context, int key, String roza) {

        SharedPreferences sp = context.getSharedPreferences("com.example.muslimapp.util.preference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(String.valueOf(key), roza);
        editor.apply();
    }

    public static List<Roza> gerData(Context context) {

        List<Roza> rozaList = new ArrayList<>();

        SharedPreferences sp = context.getSharedPreferences("com.example.muslimapp.util.preference", Context.MODE_PRIVATE);

        for (int i = 0; i < sp.getAll().size(); i++) {

            rozaList.add(Converter.strToRoza(sp.getString(String.valueOf(i), "")));
        }

        return rozaList;
    }
}
