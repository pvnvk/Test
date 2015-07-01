
package com.example.praveenv.testapplication;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CJRAlbumItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("title")
	private String mTitle;

    @SerializedName("url")
    private String mUrl;

    @SerializedName("thumbnailUrl")
    private String mThumbnailUrl;


    public String getTitle() {
        return mTitle;
    }

    public String getmThumbnailUrl() {
        return mThumbnailUrl;
    }

    public String getmUrl() {
        return mUrl;
    }
}