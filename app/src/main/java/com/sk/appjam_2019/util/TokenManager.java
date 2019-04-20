package com.sk.appjam_2019.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class TokenManager {
    private static TokenManager instance;

    private TokenManager() { }

    public TokenManager getInstance() {
        if (instance == null) {
            return new TokenManager();
        }
        return instance;
    }

    public void saveToken(Context context, String token) {
        SharedPreferences pref = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("token", token);
        editor.apply();
    }

    public String getToken(Context context) {
        SharedPreferences pref = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        return pref.getString("token", "none");
    }
}
