package com.example.muslimapp.util;

import android.icu.text.UFormat;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.muslimapp.pojo.Roza;

import java.time.LocalDate;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.O)
public class InputData {

    private static LocalDate startRoza = LocalDate.of(2021, 4, 14);

    public static void initRozaData(List<Roza> rozaList) {


        for (int i = 0; i < 30; i++) {

            LocalDate futureDate = startRoza.plusDays(i);

            Roza roza = new Roza(i + 1, futureDate.getDayOfMonth(), futureDate.getMonthValue(), false);

            rozaList.add(roza);
        }
    }
}
