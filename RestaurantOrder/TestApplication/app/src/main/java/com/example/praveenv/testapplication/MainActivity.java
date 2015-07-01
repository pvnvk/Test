package com.example.praveenv.testapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.ArrayList;


public class MainActivity<T> extends ActionBarActivity implements Response.ErrorListener, Response.Listener<T>{

    private ListView mListView;
    private CTAListAdapter mListAdapter;
    private ArrayList<CJRAlbumItem> mAlbumItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        load();
    }

    private void init() {
        mListView = (ListView) findViewById(R.id.list_view);
        mListAdapter = new CTAListAdapter(this, mAlbumItemList);
        mListView.setAdapter(mListAdapter);
    }

    private void load() {
        CTAVolley.getRequestQueue(this).add(new CTARequestHelper<T>("http://jsonplaceholder.typicode.com/photos", this, this, null, null));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(T response) {
        if (response instanceof CJRAlbum) {
            CJRAlbum album = (CJRAlbum) response;
            Toast.makeText(this, "Album size :: " + album.getAlbumItems().size(), Toast.LENGTH_LONG).show();
            mListAdapter.updateContent(album.getAlbumItems());
        }
    }
}
