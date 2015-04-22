package restaurant.praveen.com.restaurantorder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;

import restaurant.praveen.com.restaurantorder.entity.CROItem;
import restaurant.praveen.com.restaurantorder.entity.CROOrderSummary;
import restaurant.praveen.com.restaurantorder.utils.CROConstants;


public class AROMainActivity extends ActionBarActivity implements View.OnClickListener {


    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private String[] mPlanetTitles;
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content_frame);
        frameLayout.addView(getLayoutInflater().inflate(
                R.layout.layout_main, null));
        mPlanetTitles = getResources().getStringArray(R.array.planets_array);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mPlanetTitles));
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.mipmap.ic_launcher, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle("Title");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                ActionBar actionBar = getSupportActionBar();
                actionBar.setTitle("DrawerTitle");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        init();
    }

    private void init() {
        ( (Button) findViewById(R.id.btn_burger)).setOnClickListener(this);
        ( (Button) findViewById(R.id.btn_salad)).setOnClickListener(this);
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

    private void handleBurgerClick() {
        CROOrderSummary orderSummary = new CROOrderSummary();
        CROItem item = new CROItem();
        item.setName("Burger");
        orderSummary.setmItemType(item);
        Intent intent = new Intent(this, AROBread.class);
        intent.putExtra(CROConstants.INTENT_EXTRA_ORDER, orderSummary);
        startActivity(intent);
    }

    private void handleSaladClick() {
        CROOrderSummary orderSummary = new CROOrderSummary();
        CROItem item = new CROItem();
        item.setName("Salad");
        orderSummary.setmItemType(item);
        Intent intent = new Intent(this, AROVegFilling.class);
        intent.putExtra(CROConstants.INTENT_EXTRA_ORDER, orderSummary);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_burger:
                handleBurgerClick();
                break;
            case R.id.btn_salad:
                handleSaladClick();
                break;
        }
    }
}
