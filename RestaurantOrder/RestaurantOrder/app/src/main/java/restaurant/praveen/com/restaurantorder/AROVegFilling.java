package restaurant.praveen.com.restaurantorder;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import restaurant.praveen.com.restaurantorder.entity.CROItem;
import restaurant.praveen.com.restaurantorder.entity.CROOrderSummary;
import restaurant.praveen.com.restaurantorder.utils.CROConstants;


public class AROVegFilling extends ActionBarActivity implements View.OnClickListener {

    private CROOrderSummary mOrderSummary;
    private ArrayList<CROItem> mSelectedVegFilling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg_filling);
        init();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_veg_filling, menu);
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

    private int getFillingIndex(String name) {
        for(int index = 0; index < mSelectedVegFilling.size(); index++)
            if (mSelectedVegFilling.get(index).getName().equalsIgnoreCase(name))
                return index;
        return -1;
    }

    private void initCheckBox() {
        LinearLayout mCheckBoxLyt = (LinearLayout) findViewById(R.id.lyt_checkbox);
        for (int index = 0; index < CROConstants.VEG_FILLING_ARRAY.length; index++) {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(CROConstants.VEG_FILLING_ARRAY[index]);
//            checkBox.setId(index + 1000);
            final int finalIndex = index;
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    CROItem filling = new CROItem();
                    filling.setName(CROConstants.VEG_FILLING_ARRAY[finalIndex]);
                    int fillingIndex = getFillingIndex(CROConstants.VEG_FILLING_ARRAY[finalIndex]);
                    if (isChecked) {
                        if (fillingIndex < 0) {
                            mSelectedVegFilling.add(filling);
                        }
                    }else {
                        if (fillingIndex > -1) {
                            mSelectedVegFilling.remove(fillingIndex);
                        }
                    }
                }
            });
            mCheckBoxLyt.addView(checkBox);
        }
    }

    private void init() {
        mSelectedVegFilling = new ArrayList<CROItem>();
        Intent intent = getIntent();
        if (intent.hasExtra(CROConstants.INTENT_EXTRA_ORDER)) {
            mOrderSummary = (CROOrderSummary) intent.getSerializableExtra(CROConstants.INTENT_EXTRA_ORDER);
//            Toast.makeText(this, mOrderSummary.getmItemType().getName(), Toast.LENGTH_SHORT).show();
        }
        initCheckBox();
        ( (Button) findViewById(R.id.btn_proceed)).setOnClickListener(this);

    }

    private void handleProceedClick() {
        if (mSelectedVegFilling.size() < 1) {
            Toast.makeText(this, "Please select one of the options to proceed", Toast.LENGTH_SHORT).show();
            return;
        }
        mOrderSummary.setmVegFilling(mSelectedVegFilling);
        Intent intent = new Intent(this, ARONonVegFilling.class);
        intent.putExtra(CROConstants.INTENT_EXTRA_ORDER, mOrderSummary);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_proceed) {
            handleProceedClick();

        }
    }
}
