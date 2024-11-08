package com.quizzy.kids.services;

import android.app.Activity;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.content.Context;
import android.view.WindowManager;

import androidx.core.content.ContextCompat;

import com.quizzy.kids.R;

public class AppService {
    public static Integer getIndicatorColor(Context context, int value) {
        if (value >= 80) {
            return ContextCompat.getColor(context, R.color.lightGreen);
        } else if (value >= 60) {
            return ContextCompat.getColor(context, R.color.lightPurple);
        } else if (value >= 40) {
            return ContextCompat.getColor(context, R.color.skyBlue);
        } else
            return ContextCompat.getColor(context, R.color.lightRed);
    }

    public static Point getScreenSize(Context context) {
        WindowManager windowManager = ((Activity) context).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        DisplayMetrics dm = new DisplayMetrics();
        display.getMetrics(dm);
        float density = dm.density;

        // Convert the pixel values to dp
        int widthDp = (int) (size.x / density);
        int heightDp = (int) (size.y / density);

        // Create a new Point object with the dp values
        return new Point(widthDp, heightDp);
    }


}
