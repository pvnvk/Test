
package com.example.praveenv.testapplication;


import java.io.Serializable;
import java.util.ArrayList;

public class CJRAlbum implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<CJRAlbumItem> albumItems;


    public ArrayList<CJRAlbumItem> getAlbumItems() {
        return albumItems;
    }

    public void setAlbumItems(ArrayList<CJRAlbumItem> albumItems) {
        this.albumItems = albumItems;
    }
}