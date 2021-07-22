package com.indiastastebook.utils;

import android.content.Context;
import android.widget.Toast;

public class App {
    public static void toast(Context context, String str) {
        Toast.makeText(context, str, Toast.LENGTH_LONG).show();
    }
}
