package restaurant.praveen.com.restaurantorder;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import restaurant.praveen.com.restaurantorder.entity.CROItem;
import restaurant.praveen.com.restaurantorder.entity.CROOrderSummary;
import restaurant.praveen.com.restaurantorder.utils.CROConstants;


public class AROOrder extends ActionBarActivity {

    private CROOrderSummary mOrderSummary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        init();
    }

    private void init() {
        Intent intent = getIntent();
        if (intent.hasExtra(CROConstants.INTENT_EXTRA_ORDER)) {
            mOrderSummary = (CROOrderSummary) intent.getSerializableExtra(CROConstants.INTENT_EXTRA_ORDER);
//            Toast.makeText(this, mOrderSummary.getmItemType().getName(), Toast.LENGTH_SHORT).show();
        }
        LinearLayout itemTypeLyt = (LinearLayout) findViewById(R.id.lyt_item_type);
        TextView itemType = (TextView) findViewById(R.id.item_type);

        LinearLayout breadLyt = (LinearLayout) findViewById(R.id.lyt_bread);
        TextView breadTxt = (TextView) findViewById(R.id.bread);

        LinearLayout vegLyt = (LinearLayout) findViewById(R.id.lyt_veg_filling);
        TextView vegTxt = (TextView) findViewById(R.id.veg_filling);

        LinearLayout cheeseLyt = (LinearLayout) findViewById(R.id.lyt_cheese);
        TextView cheeseTxt = (TextView) findViewById(R.id.cheese);

        LinearLayout nonVegLyt = (LinearLayout) findViewById(R.id.lyt_non_veg_filling);
        TextView nonVegTxt = (TextView) findViewById(R.id.non_veg_filling);

        LinearLayout saucesLyt = (LinearLayout) findViewById(R.id.lyt_sauce);
        TextView sauce = (TextView) findViewById(R.id.sauce);

        if (mOrderSummary == null) return;
        if (mOrderSummary.getmItemType() != null && mOrderSummary.getmItemType().getName().trim().length() > 0) {
            itemTypeLyt.setVisibility(View.VISIBLE);
            itemType.setText(mOrderSummary.getmItemType().getName());
        } else {
            itemTypeLyt.setVisibility(View.GONE);
        }
        if (mOrderSummary.getmBread() != null && mOrderSummary.getmBread().getName().trim().length() > 0) {
            breadLyt.setVisibility(View.VISIBLE);
            breadTxt.setText(mOrderSummary.getmBread().getName());
        } else {
            breadLyt.setVisibility(View.GONE);
        }
        if (mOrderSummary.getmVegFilling() != null && mOrderSummary.getmVegFilling().size() > 0) {
            String text = "";
            for (CROItem item : mOrderSummary.getmVegFilling()) {
                text +=  item.getName() + " ";
            }
            vegLyt.setVisibility(View.VISIBLE);
            vegTxt.setText(text);
        } else {
            vegLyt.setVisibility(View.GONE);
        }
        if (mOrderSummary.getmNonVegFilling() != null && mOrderSummary.getmNonVegFilling().getName().trim().length() > 0) {
            nonVegLyt.setVisibility(View.VISIBLE);
            nonVegTxt.setText(mOrderSummary.getmNonVegFilling().getName());
        } else {
            nonVegLyt.setVisibility(View.GONE);
        }
        if (mOrderSummary.getmCheese() != null && mOrderSummary.getmCheese().getName().trim().length() > 0) {
            cheeseLyt.setVisibility(View.VISIBLE);
            cheeseTxt.setText(mOrderSummary.getmCheese().getName());
        } else {
            cheeseLyt.setVisibility(View.GONE);
        }
        if (mOrderSummary.getmSauce() != null && mOrderSummary.getmSauce().size() > 0) {
            String text = "";
            for (CROItem item : mOrderSummary.getmSauce()) {
                text +=  item.getName() + " ";
            }
            saucesLyt.setVisibility(View.VISIBLE);
            sauce.setText(text);
        } else {
            saucesLyt.setVisibility(View.GONE);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_order, menu);
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
}
