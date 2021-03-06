package restaurant.praveen.com.restaurantorder;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import restaurant.praveen.com.restaurantorder.entity.CROItem;
import restaurant.praveen.com.restaurantorder.entity.CROOrderSummary;
import restaurant.praveen.com.restaurantorder.utils.CROConstants;


public class AROBread extends ActionBarActivity implements View.OnClickListener {

    private CROOrderSummary mOrderSummary;
    private RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bread);
        init();
    }

    private void setRadioGrp() {
        mRadioGroup = (RadioGroup) findViewById(R.id.radio_group);
        for (int index = 0; index < CROConstants.BREAD_ARRAY.length; index++) {
            int padding = 10;
            String name = CROConstants.BREAD_ARRAY[index];
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(name);
            radioButton.setId(index + 100);
            radioButton.setTag(name);
            radioButton.setOnClickListener(this);
            radioButton.setPadding(padding, padding, padding, padding);
            mRadioGroup.addView(radioButton);
            if (index == 0)
                radioButton.setChecked(true);
        }
    }

    private void init() {
        Intent intent = getIntent();
        if (intent.hasExtra(CROConstants.INTENT_EXTRA_ORDER)) {
            mOrderSummary = (CROOrderSummary) intent.getSerializableExtra(CROConstants.INTENT_EXTRA_ORDER);
//            Toast.makeText(this, mOrderSummary.getmItemType().getName(), Toast.LENGTH_SHORT).show();
        }
        setRadioGrp();
        ( (Button) findViewById(R.id.btn_proceed)).setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bread, menu);
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

    private void handleProceed() {
        int selectedId = mRadioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        CROItem breadObj = new CROItem();
        breadObj.setName(radioButton.getText().toString());
        mOrderSummary.setmBread(breadObj);
        Intent intent = new Intent(this, AROVegFilling.class);
        intent.putExtra(CROConstants.INTENT_EXTRA_ORDER, mOrderSummary);
        startActivity(intent);
//        Toast.makeText(this, radioButton.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_proceed) {
            handleProceed();
        }
    }
}
