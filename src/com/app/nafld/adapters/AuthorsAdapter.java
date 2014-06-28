package com.app.nafld.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.app.nafld.R;
import com.app.nafld.dataobjects.AuthorsItems;

public class AuthorsAdapter extends ArrayAdapter<AuthorsItems> {

	Context context;
	int layoutResourceId;
	AuthorsItems[] authorsItem = null;

	public AuthorsAdapter(Context context, int layoutResourceId,
			AuthorsItems[] objects) {
		super(context, layoutResourceId, objects);
		this.context = context;
		this.layoutResourceId = layoutResourceId;
		this.authorsItem = objects;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;

		if (convertView == null) {
			holder = new ViewHolder();
			LayoutInflater layout_inflator = ((Activity) context)
					.getLayoutInflater();
			convertView = layout_inflator.inflate(R.layout.listview_row_authors, parent, false);
			holder.dataCell_drname = (TextView) convertView
					.findViewById(R.id.textview_drname);
			holder.dataCell_department = (TextView) convertView.findViewById(R.id.textview_department);
			holder.dataCell_qualification = (TextView) convertView.findViewById(R.id.textview_qualification);
			holder.dataCell_location = (TextView) convertView.findViewById(R.id.textview_location);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();			
		}

		AuthorsItems item = authorsItem[position];
		holder.dataCell_drname.setText(item.getDrname());
		holder.dataCell_department.setText(item.getDepartment());
		holder.dataCell_qualification.setText(item.getQualification());
		holder.dataCell_location.setText(item.getLocation());

		return convertView;
	}

	/**
	 * A class defining the view holder
	 */
	static class ViewHolder {
		private TextView dataCell_drname;
		private TextView dataCell_department;
		private TextView dataCell_qualification;
		private TextView dataCell_location;
	}

}
