package com.techacademy;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

        @GetMapping("/dayofweek/{yyyymmdd}")
        public String dispDayOfWeek(@PathVariable String yyyymmdd) {
            // Calendarオブジェクトを作成
            Calendar cal = new GregorianCalendar();

            // 日付を解析してCalendarオブジェクトに設定
            int year = Integer.parseInt(yyyymmdd.substring(0, 4));
            int month = Integer.parseInt(yyyymmdd.substring(4, 6)) - 1; // Calendarの月は0から始まる
            int day = Integer.parseInt(yyyymmdd.substring(6, 8));
            cal.set(year, month, day);

            // 曜日を取得
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

            // 曜日を文字列に変換
            // 曜日を文字列に変換
            String result = null;
            switch(dayOfWeek) {
                case Calendar.MONDAY:
                    result = "Monday";
                    break;
                case Calendar.TUESDAY:
                    result = "Tuesday";
                    break;
                case Calendar.WEDNESDAY:
                    result = "Wednesday";
                    break;
                case Calendar.THURSDAY:
                    result = "Thursday";
                    break;
                case Calendar.FRIDAY:
                    result = "Friday";
                    break;
                case Calendar.SATURDAY:
                    result = "Saturday";
                    break;
                case Calendar.SUNDAY:
                    result = "Sunday";
                    break;
            }
                    return "指定された日付の曜日は: " + result;
            }


    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return "計算結果:" + res;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return "計算結果:" + res;
    }

    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return "計算結果:" + res;
    }

    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return "計算結果:" + res;
    }
}
