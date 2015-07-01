package com.example.praveenv.testapplication;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by Praveen V K on 01-07-2015.
 */
public class CTARequestHelper<T> extends Request<T> {

    private final Response.Listener<T> mListener;
    private T mDataModel;
    private final Gson mGson;
    private Map<String, String> mHeaders;
    private String TAG =CTARequestHelper.class.getName();
    public static final int MY_SOCKET_TIMEOUT_MS = 30000;
    private String mUrl;

    public CTARequestHelper(String url, Response.Listener<T> listener, Response.ErrorListener errorListener, T model, Map<String, String> headers) {
        super(Method.GET, url, errorListener);
        mListener = listener;
        mDataModel = model;
        mGson = new Gson();
        mHeaders = headers;
        mUrl = url;
    }

    @Override
    protected void deliverResponse(T model) {
        mListener.onResponse(model);
    }

    @Override
    public void deliverError(VolleyError error) {
        super.deliverError(error);
    }

    @Override
    public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
        retryPolicy = new DefaultRetryPolicy(MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        return super.setRetryPolicy(retryPolicy);
    }

	/*@Override
	public void setRetryPolicy(RetryPolicy retryPolicy) {
		retryPolicy = new DefaultRetryPolicy(
				MY_SOCKET_TIMEOUT_MS,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
		super.setRetryPolicy(retryPolicy);
	}*/


    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString =  new String(response.data);
            Log.d("RESPONSE", ">>>>>>>>>>>>>jsonString :;" + jsonString);
            CJRAlbumItem[] ad = mGson.fromJson(jsonString, CJRAlbumItem[].class);
            ArrayList<CJRAlbumItem> arrayList = new ArrayList<CJRAlbumItem>(Arrays.asList(ad));
            CJRAlbum album = new CJRAlbum();
            album.setAlbumItems(arrayList);
            Log.d("RESPONSE", ">>>>>>>>>>>>>arrayList.size() :" + arrayList.size());
            return Response.success((T)album, getCacheEntry());
        } catch (Exception e) {
            return Response.error( new VolleyError("parse error"));
        }
    }

    @Override
    public Map<String, String> getHeaders() {
        try {
            return mHeaders != null ? mHeaders : super.getHeaders();
        } catch (AuthFailureError exception) {
            exception.printStackTrace();
            return null;
        }
    }


}
