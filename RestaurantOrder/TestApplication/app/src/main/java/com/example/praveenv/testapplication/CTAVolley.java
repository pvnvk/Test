package com.example.praveenv.testapplication;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Praveen V K on 01-07-2015.
 */
public class CTAVolley {
    private static RequestQueue mRequestQueue;
    private static RequestQueue mImageRequestQueue;


    private CTAVolley() {}

    public static void init(Context context) {
        mRequestQueue = Volley.newRequestQueue(context, null);
        mImageRequestQueue = Volley.newRequestQueue(context);
        ImageCacheManager.INSTANCE.initImageCache();
    }

    public static RequestQueue getRequestQueue(Context context) {
        if (mRequestQueue != null) {
            return mRequestQueue;
        } else {
            return mRequestQueue = Volley.newRequestQueue(context, null);
        }
    }

    public static RequestQueue getImageRequestQueue() {

        if (mImageRequestQueue != null) {
            return mImageRequestQueue;
        } else {
            throw new IllegalStateException("Image RequestQueue not initialized");
        }
    }
}
