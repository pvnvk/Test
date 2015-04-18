package restaurant.praveen.com.restaurantorder.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Praveen on 4/4/2015.
 */
public class CROItem implements Serializable {

    private String mName;
//    private ArrayList<String> mNameList;

    public String getName() {
        return mName;
    }

    public void setName(String mItem) {
        this.mName = mItem;
    }

//    public ArrayList<String> getNameList() {
//        return mNameList;
//    }

//    public void setNameList(ArrayList<String> mNameList) {
//        this.mNameList = mNameList;
//    }
}
