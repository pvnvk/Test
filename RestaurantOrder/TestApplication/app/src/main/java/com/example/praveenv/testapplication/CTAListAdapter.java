package com.example.praveenv.testapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

/**
 * Created by Praveen V K on 01-07-2015.
 */
public class CTAListAdapter extends BaseAdapter{

    private Context mContext;
    private ArrayList<CJRAlbumItem> mAlbumItemList;
    private LayoutInflater mLayoutInflator;
    private ImageLoader mImageLoaderNew;

    public CTAListAdapter(Context context, ArrayList<CJRAlbumItem> albumItems) {
        mContext = context;
        mAlbumItemList = albumItems;
        mLayoutInflator = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mAlbumItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return mAlbumItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = mLayoutInflator.inflate(R.layout.layout_album_item,
                    viewGroup, false);
            ViewHolder holder = new ViewHolder();
            holder.imageView = (NetworkImageView) convertView.findViewById(R.id.image_view);
            holder.textView = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        }
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        mImageLoaderNew = ImageCacheManager.INSTANCE.getImageLoader();
        CJRAlbumItem albumItem = mAlbumItemList.get(position);
        viewHolder.imageView.setImageUrl(albumItem.getmThumbnailUrl(), mImageLoaderNew);
        viewHolder.textView.setText("asfsa");
        return convertView;
    }

    public class ViewHolder {
        public NetworkImageView imageView;
        public TextView textView;
    }

    public void updateContent(ArrayList<CJRAlbumItem> albumItems) {
        mAlbumItemList = albumItems;
        notifyDataSetChanged();
    }
}
