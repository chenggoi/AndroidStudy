package com.chenggoi.androidstudy.CoolWeather.util;

import android.text.TextUtils;

import com.chenggoi.androidstudy.CoolWeather.model.City;
import com.chenggoi.androidstudy.CoolWeather.model.CoolWeatherDB;
import com.chenggoi.androidstudy.CoolWeather.model.County;
import com.chenggoi.androidstudy.CoolWeather.model.Province;

import org.json.JSONObject;

import java.util.Iterator;

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
}
