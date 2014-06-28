package com.app.nafld.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.app.nafld.R;
import com.app.nafld.adapters.FragmentsListViewAdapter;
import com.app.nafld.constants.Constants;

public class NAFLDnMSFragment extends Fragment{

	private ListView listView_nafld_items;
	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_nafld, container, false);

		listView_nafld_items = (ListView)view.findViewById(R.id.listview_nafld_mainitems);

		String[] nafldItems = view.getResources().getStringArray(R.array.naflds_array);
		FragmentsListViewAdapter adapter = new FragmentsListViewAdapter(view.getContext(), R.layout.fragment_nafld, nafldItems);
		listView_nafld_items.setAdapter(adapter);

		listView_nafld_items.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long arg3) {
				Log.d("ListItem Clicked==", ">>>>>"+position);
				switch(position){
				case Constants.INDEX_POSITION_PAPER:
					break;
				case Constants.INDEX_POSITION_PATHOGENESIS:
					break;
				case Constants.INDEX_POSITION_DEFINITIONS:
					break;
				case Constants.INDEX_POSITION_DIAGNOSIS:
					break;
				case Constants.INDEX_POSITION_TREATMENT:
					break;
				case Constants.INDEX_POSITION_CONCLUSION:
					break;
				}
			}
		});

		return view;
	}
}