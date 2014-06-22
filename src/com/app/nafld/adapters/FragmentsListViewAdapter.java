package com.app.nafld.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.app.nafld.R;

public class FragmentsListViewAdapter extends ArrayAdapter<String>{

	Context context;
	int layoutResourceId;
	String[] mostPopularItem = null;

	public FragmentsListViewAdapter(Context context,
			int layoutResourceId, String[] objects) {
		super(context, layoutResourceId, objects);
		this.context = context;
		this.layoutResourceId = layoutResourceId;
		this.mostPopularItem = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;

		if (convertView == null) {
			holder = new ViewHolder();
			LayoutInflater layout_inflator = ((Activity)context).getLayoutInflater();
			convertView = layout_inflator.inflate(R.layout.listview_row,
					null);

			/*int firstrow_color = convertView.getResources().getColor(R.color.color_listview_firstrow_item);
			int secondrow_color = convertView.getResources().getColor(R.color.color_listview_secondrow_item);
			//check for odd or even to set alternate colors to the row background
			if(position % 2 == 0){  
				convertView.setBackgroundColor(firstrow_color);
			}
			else {
				convertView.setBackgroundColor(secondrow_color);
			}*/

			holder.dataCell_text = (TextView) convertView
					.findViewById(R.id.textview_rowitem);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		String item = mostPopularItem[position];
		holder.dataCell_text.setText(item);

		return convertView;
	}

	/**
	 * A class defining the view holder
	 */
	static class ViewHolder {
		private TextView dataCell_text;
	}

}