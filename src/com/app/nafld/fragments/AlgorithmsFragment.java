package com.app.nafld.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.app.nafld.R;
import com.app.nafld.adapters.ImageStringAdapter;
import com.app.nafld.dataobjects.ImageStringItems;

public class AlgorithmsFragment  extends Fragment{
	
	private onAlgorithmClickListener activityCallback;

	public interface onAlgorithmClickListener{
		public void onAlgoClicked(View view, int position);
	}
	
	@Override
	public void onAttach(Activity activity) {
		 super.onAttach(activity);
	        try {
	        	activityCallback = (onAlgorithmClickListener) activity;
	        } catch (ClassCastException e) {
	            throw new ClassCastException(activity.toString()
	                    + " must implement onAlgorithmClickListener");
	        }
	}
	
	private int[] drawableID = {R.drawable.algorithm1_icon, R.drawable.algorithm2_icon};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_algorithms, container, false);

		ListView listView_items = (ListView)view.findViewById(R.id.listview_algorithms);

		String[] infoItems = view.getResources().getStringArray(R.array.algorithms_array);
		
		ImageStringItems[] dataItems = new ImageStringItems[infoItems.length];
		for (int i = 0; i < infoItems.length; i++) {
			dataItems[i] = new ImageStringItems(infoItems[i], drawableID[i]);
		}
		
		ImageStringAdapter adapter = new ImageStringAdapter(view.getContext(), R.layout.fragment_algorithms, dataItems);
		listView_items.setAdapter(adapter);

		listView_items.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long arg3) {
				activityCallback.onAlgoClicked(view, position);
			}
		});

		return view;
	}

}
