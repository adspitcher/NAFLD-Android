package com.app.nafld.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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
	//String[] colors = new String[2];
	//String color = "#FF0000";

	public FragmentsListViewAdapter(Context context,
			int layoutResourceId, String[] objects) {
		super(context, layoutResourceId, objects);
		this.context = context;
		this.layoutResourceId = layoutResourceId;
		this.mostPopularItem = objects;
		//colors[0] = "#0095CD";
		//colors[1] = "#FF0000";
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;

		if (convertView == null) {
			holder = new ViewHolder();
			LayoutInflater layout_inflator = ((Activity)context).getLayoutInflater();
			convertView = layout_inflator.inflate(R.layout.listview_row,
					null);

			holder.dataCell_text = (TextView) convertView
					.findViewById(R.id.textview_rowitem);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		/*holder.border_textview = (TextView) convertView
				.findViewById(R.id.border_textview);
		GradientDrawable gradDB = (GradientDrawable) holder.border_textview
				.getBackground();
		if(position%2==0){
			color = colors[0];
		}else
			color = colors[1];
		
		gradDB.setColor(Color.parseColor(color));
		// Log.v("Adapter", "Set color if===>"+color);
		holder.border_textview.setTag(R.id.textview_background_color, color);
		holder.border_textview.setBackgroundDrawable(gradDB);*/


		String item = mostPopularItem[position];
		holder.dataCell_text.setText(item);

		return convertView;
	}

	/**
	 * A class defining the view holder
	 */
	static class ViewHolder {
		private TextView dataCell_text;
		//private TextView border_textview;
	}

}