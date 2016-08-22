package com.chenggoi.androidstudy.CoolWeather.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.chenggoi.androidstudy.CoolWeather.model.City;
import com.chenggoi.androidstudy.CoolWeather.model.CoolWeatherDB;
import com.chenggoi.androidstudy.CoolWeather.model.County;
import com.chenggoi.androidstudy.CoolWeather.model.Province;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/**
 * Created by chenggoi on 16-8-17.
 */

public class Utility {
    public synchronized static boolean handleProvincesResponse(CoolWeatherDB coolWeatherDB, String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONObject jsonObject = new JSONObject(response);
                if (jsonObject != null && jsonObject.length() > 0) {
                    for (int i = 0; i < jsonObject.length(); i++) {
                        Province province = new Province();
                        province.setProvinceCode(Integer.toString(10101 + i));
                        province.setProvinceName(jsonObject.getString(Integer.toString(10101 + i)));
                        coolWeatherDB.saveProvince(province);
                    }
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCitiesResponse(CoolWeatherDB coolWeatherDB, String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONObject jsonObject = new JSONObject(response);
                Iterator<String> k = jsonObject.keys();
                while (k.hasNext()) {
                    String key = k.next();
                    City city = new City();
                    city.setCityCode(key);
                    city.setCityName(jsonObject.getString(key));
                    city.setProvinceId(provinceId);
                    coolWeatherDB.saveCity(city);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    public static boolean handleCountiesResponse(CoolWeatherDB coolWeatherDB, String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONObject jsonObject = new JSONObject(response);
                Iterator<String> k = jsonObject.keys();
                while (k.hasNext()) {
                    String key = k.next();
                    County county = new County();
                    county.setCountyCode(key);
                    county.setCountyName(jsonObject.getString(key));
                    county.setCityId(cityId);

                    coolWeatherDB.saveCounty(county);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    public static void handleWeatherResponse(Context contex, String response) {
        try {
            JSONObject jsObject = new JSONObject(response);
            JSONObject weatherInfo = jsObject.getJSONObject("weatherinfo");
            String cityName = weatherInfo.getString("city");
            String weatherCode = weatherInfo.getString("cityid");
            String temp1 = weatherInfo.getString("temp1");
            String temp2 = weatherInfo.getString("temp2");
            String weatherDesp = weatherInfo.getString("weather");
            String publishTime = weatherInfo.getString("ptime");
            saveWeatherInfo(contex, cityName, weatherCode, temp1, temp2, weatherDesp, publishTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveWeatherInfo(Context context, String cityName, String weatherCode, String temp1, String temp2, String weatherDesp, String publishTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d", Locale.CHINA);
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean("city_selected", true);
        editor.putString("city_name", cityName);
        editor.putString("weather_code", weatherCode);
        editor.putString("temp1", temp1);
        editor.putString("temp2", temp2);
        editor.putString("weather_desp", weatherDesp);
        editor.putString("publish_time", publishTime);
        editor.putString("current_date", sdf.format(new Date()));
        editor.commit();
    }
}
