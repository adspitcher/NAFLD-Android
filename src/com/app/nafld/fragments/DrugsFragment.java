package com.app.nafld.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.app.nafld.R;
import com.app.nafld.adapters.FragmentsListViewAdapter;

public class DrugsFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_drugs, container, false);

		ListView listView_drugs_items = (ListView)view.findViewById(R.id.listview_drugs_mainitems);

		String[] drugsItems = view.getResources().getStringArray(R.array.drugs_array);
		FragmentsListViewAdapter adapter = new FragmentsListViewAdapter(view.getContext(), R.layout.fragment_drugs, drugsItems);
		listView_drugs_items.setAdapter(adapter);

		return view;
	}

}