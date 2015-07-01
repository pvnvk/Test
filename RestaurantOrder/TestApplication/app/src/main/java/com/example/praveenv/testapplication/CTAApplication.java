package com.example.praveenv.testapplication;

import android.app.Application;
import android.content.Context;

/**
 * Created by Praveen V K on 01-07-2015.
 */
public class CTAApplication extends Application{

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        initApplication();
    }

    private void initApplication() {
        CTAVolley.init(getApplicationContext());
    }
}
