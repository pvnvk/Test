package restaurant.praveen.com.restaurantorder.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Praveen on 4/4/2015.
 */
public class CROOrderSummary implements Serializable{
    CROItem mItemType;
    CROItem mBread;
    ArrayList<CROItem> mVegFilling;
    CROItem mNonVegFilling;
    CROItem mCheese;
    ArrayList<CROItem> mSauce;

    public CROItem getmItemType() {
        return mItemType;
    }

    public void setmItemType(CROItem mItemType) {
        this.mItemType = mItemType;
    }

    public CROItem getmBread() {
        return mBread;
    }

    public void setmBread(CROItem mBread) {
        this.mBread = mBread;
    }

    public ArrayList<CROItem> getmVegFilling() {
        return mVegFilling;
    }

    public void setmVegFilling(ArrayList<CROItem> mVegFilling) {
        this.mVegFilling = mVegFilling;
    }

    public CROItem getmNonVegFilling() {
        return mNonVegFilling;
    }

    public void setmNonVegFilling(CROItem mNonVegFilling) {
        this.mNonVegFilling = mNonVegFilling;
    }

    public CROItem getmCheese() {
        return mCheese;
    }

    public void setmCheese(CROItem mCheese) {
        this.mCheese = mCheese;
    }

    public ArrayList<CROItem> getmSauce() {
        return mSauce;
    }

    public void setmSauce(ArrayList<CROItem> mSauce) {
        this.mSauce = mSauce;
    }
}
