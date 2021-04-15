package com.example.muslimapp.util;

import com.example.muslimapp.pojo.Roza;

public class Converter {

    public static String rozaConvertToStr(Roza roza) {

        String strRoza = roza.getRozaNum() + " " + roza.getDay() + " " + roza.getMonth() + " " + roza.isPassed();
        return strRoza;
    }

    public static Roza strToRoza(String roza) {

        String[] rozaArray = roza.split(" ");

        Roza resultRoza = new Roza(Integer.parseInt(rozaArray[0]), Integer.parseInt(rozaArray[1]),
                Integer.parseInt(rozaArray[2]), Boolean.valueOf(rozaArray[3]));

        return resultRoza;
    }
}
