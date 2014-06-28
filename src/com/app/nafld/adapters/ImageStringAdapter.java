package com.app.nafld.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.app.nafld.R;
import com.app.nafld.dataobjects.ImageStringItems;

public class ImageStringAdapter extends ArrayAdapter<ImageStringItems> {

	Context context;
	int layoutResourceId;
	ImageStringItems[] items = null;

	public ImageStringAdapter(Context context, int layoutResourceId,
			ImageStringItems[] objects) {
		super(context, layoutResourceId, objects);
		this.context = context;
		this.layoutResourceId = layoutResourceId;
		this.items = objects;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;

		if (convertView == null) {
			holder = new ViewHolder();
			LayoutInflater layout_inflator = ((Activity) context)
					.getLayoutInflater();
			convertView = layout_inflator.inflate(R.layout.listview_row_imagestring, null);
			holder.dataCell_item = (TextView) convertView
					.findViewById(R.id.textview_algorithm);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();			
		}

		ImageStringItems item = items[position];
		holder.dataCell_item.setText(item.getItemText());
		holder.dataCell_item.setCompoundDrawablesWithIntrinsicBounds(item.getItemDrawableID(), 0, 0, 0);

		return convertView;
	}

	/**
	 * A class defining the view holder
	 */
	static class ViewHolder {
		private TextView dataCell_item;
	}

}
